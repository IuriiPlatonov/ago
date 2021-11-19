package com.otoil.ot_932_ago.client.tiles.getreport;


import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.intendia.rxgwt2.user.RxHandlers;

import ru.ot.mvp.client.presenters.AbstractPresenter;
import ru.ot.mvp.client.presenters.Model;
import ru.ot.wevelns.client.action.Action;

import com.otoil.ot_932_2_0050.micromine.client.beans.OpenGgisWizardEventBean;
import com.otoil.ot_932_2_0050.micromine.client.beans.OpenGgisWizardEventBean.OpenType;
import com.otoil.ot_932_2_0050.micromine.client.events.OpenGgisWizardEvent;
import com.otoil.ot_932_2_0050.micromine.client.form.wizard.GgisLoaderWizardPresenter;
import com.otoil.ot_932_2_0050.micromine.client.form.wizard.GgisLoaderWizardPresenter.SET;
import com.otoil.ot_932_2_0050.micromine.shared.SessionConstants;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTilePresenter.GetReportTileModel;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTilePresenter.GetReportTileView;

import io.reactivex.disposables.CompositeDisposable;


public class GetReportTilePresenter
        extends AbstractPresenter<GetReportTileModel, GetReportTileView>
{
    public interface GetReportTileModel extends Model
    {

    }

    public interface GetReportTileView extends IsWidget
    {
        Action openClassifyWizardAction();

        HasClickHandlers close();
    }

    private CompositeDisposable subscription = new CompositeDisposable();
    private GetReportTileClientFactory clientFactory;

    public GetReportTilePresenter(GetReportTileClientFactory clientFactory)
    {
        super(clientFactory.getGetReportTileModel(),
            clientFactory.getGetReportTileView());
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
                GgisLoaderWizardPresenter.openAndStopOnClose(
                    clientFactory.getGgisLoaderWizardFactory(), SET.SET3,
                    eventBus,
                    new OpenGgisWizardEvent(SessionConstants.FORM_DESKTOP_ID,
                        new OpenGgisWizardEventBean(OpenType.FROM_DESKTOP)));
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
