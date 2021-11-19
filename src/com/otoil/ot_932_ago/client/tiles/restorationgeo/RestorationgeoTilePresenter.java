package com.otoil.ot_932_ago.client.tiles.restorationgeo;


import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.IsWidget;
import com.intendia.rxgwt2.user.RxHandlers;
import com.otoil.ot_932_2_0050.micromine.client.beans.OpenGgisWizardEventBean;
import com.otoil.ot_932_2_0050.micromine.client.beans.OpenGgisWizardEventBean.OpenType;
import com.otoil.ot_932_2_0050.micromine.client.events.OpenGgisWizardEvent;
import com.otoil.ot_932_2_0050.micromine.client.factory.impl.WizardFactoryImpl;
import com.otoil.ot_932_2_0050.micromine.client.form.wizard.GgisLoaderWizardPresenter;
import com.otoil.ot_932_2_0050.micromine.client.form.wizard.GgisLoaderWizardPresenter.SET;
import com.otoil.ot_932_2_0050.micromine.shared.SessionConstants;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTilePresenter.RestorationgeoTileModelTileModel;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTilePresenter.RestorationgeoTileModelTileView;

import io.reactivex.disposables.CompositeDisposable;
import ru.ot.mvp.client.presenters.AbstractPresenter;
import ru.ot.mvp.client.presenters.Model;
import ru.ot.wevelns.client.action.Action;


public class RestorationgeoTilePresenter
        extends AbstractPresenter<RestorationgeoTileModelTileModel, RestorationgeoTileModelTileView>
{
    public interface RestorationgeoTileModelTileModel extends Model
    {

    }

    public interface RestorationgeoTileModelTileView extends IsWidget
    {
        Action openBlockModelParameters();

        HasClickHandlers close();
    }

    private CompositeDisposable subscription = new CompositeDisposable();

    public RestorationgeoTilePresenter(RestorationgeoTileClientFactory clientFactory)
    {
        super(clientFactory.getRestorationgeoTileModel(),
            clientFactory.getRestorationgeoTileView());
    }

    @Override
    public void bind()
    {
        subscription.add(RxHandlers.click(view.openBlockModelParameters())
            .subscribe(event -> {
                OpenGgisWizardEventBean eventBean = new OpenGgisWizardEventBean(
                    OpenType.FOR_LOAD);

                GgisLoaderWizardPresenter.openAndStopOnClose(
                    new WizardFactoryImpl(), SET.SET8, eventBus,
                    new OpenGgisWizardEvent(SessionConstants.FORM_MINE_PROJECT_ID,
                        eventBean));
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
