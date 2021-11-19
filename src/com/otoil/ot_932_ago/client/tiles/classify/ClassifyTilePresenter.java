package com.otoil.ot_932_ago.client.tiles.classify;


import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.intendia.rxgwt2.user.RxHandlers;
import com.otoil.ot_932_2_0050.micromine.client.beans.OpenGgisWizardEventBean;
import com.otoil.ot_932_2_0050.micromine.client.beans.OpenGgisWizardEventBean.OpenType;
import com.otoil.ot_932_2_0050.micromine.client.events.OpenGgisWizardEvent;
import com.otoil.ot_932_2_0050.micromine.client.form.wizard.GgisLoaderWizardPresenter;
import com.otoil.ot_932_2_0050.micromine.client.form.wizard.GgisLoaderWizardPresenter.SET;
import com.otoil.ot_932_2_0050.micromine.shared.SessionConstants;
import com.otoil.ot_932_5_0020.shared.pivot.report.ReportConstants;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTilePresenter.ClassifyTileModel;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTilePresenter.ClassifyTileView;

import io.reactivex.disposables.CompositeDisposable;
import ru.ot.mvp.client.presenters.AbstractPresenter;
import ru.ot.mvp.client.presenters.Model;
import ru.ot.wevelns.client.action.Action;


public class ClassifyTilePresenter
        extends AbstractPresenter<ClassifyTileModel, ClassifyTileView>
{
    public interface ClassifyTileModel extends Model
    {

    }

    public interface ClassifyTileView extends IsWidget
    {
        Action openClassifyWizardAction();

        HasClickHandlers close();
    }

    private CompositeDisposable subscription = new CompositeDisposable();
    private ClassifyTileClientFactory clientFactory;

    public ClassifyTilePresenter(ClassifyTileClientFactory clientFactory)
    {
        super(clientFactory.getClassifyTileModel(),
            clientFactory.getClassifyTileView());
        this.clientFactory = clientFactory;

    }

    
    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus)
    {
        super.start(panel, eventBus);

    }

    @Override
    public void bind()
    {
        subscription.add(RxHandlers.click(view.openClassifyWizardAction())
            .subscribe(event -> {
                OpenGgisWizardEventBean eventBean = new OpenGgisWizardEventBean(OpenType.FROM_DESKTOP);
                eventBean.setReportKindId(ReportConstants.DATA_KIND_GMP);
                GgisLoaderWizardPresenter.openAndStopOnClose(
                    clientFactory.getGgisLoaderWizardFactory(), SET.SET1,
                    eventBus, new OpenGgisWizardEvent(
                        SessionConstants.FORM_DESKTOP_ID, eventBean));
            }));

        subscription.add(RxHandlers.click(view.close()).subscribe(event -> {
            onStop();
        }));
    }

    @Override
    public void onStop()
    {
        subscription.clear();
        super.onStop();
    }

}
