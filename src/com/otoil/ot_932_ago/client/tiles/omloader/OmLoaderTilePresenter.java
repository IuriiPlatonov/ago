package com.otoil.ot_932_ago.client.tiles.omloader;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.IsWidget;
import com.intendia.rxgwt2.user.RxHandlers;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.BmOmDialogLoaderClientFactory;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.om.OmLoaderPresenter;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.om.event.OpenOmLoaderEvent;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.wizard.AbstractWizardPresenter.WizardView;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.wizard.impl.WizardViewImpl;
import com.otoil.ot_932_ago.client.tiles.omloader.OmLoaderTilePresenter.OmLoaderTileModel;
import com.otoil.ot_932_ago.client.tiles.omloader.OmLoaderTilePresenter.OmLoaderTileView;
import com.otoil.ot_932_ago.client.tiles.omloader.factory.OmLoaderTileClientFactory;

import io.reactivex.disposables.CompositeDisposable;
import ru.ot.mvp.client.presenters.AbstractPresenter;
import ru.ot.mvp.client.presenters.Model;
import ru.ot.wevelns.client.action.Action;


public class OmLoaderTilePresenter
        extends AbstractPresenter<OmLoaderTileModel, OmLoaderTileView>
{

    public interface OmLoaderTileView extends IsWidget
    {
        Action getOpenButton();
    }

    public interface OmLoaderTileModel extends Model
    {

    }

    private OmLoaderPresenter omLoaderPresenter;

    public OmLoaderTilePresenter(OmLoaderTileClientFactory clientFactory)
    {
        super(clientFactory.getOmLoaderTileModel(),
            clientFactory.getOmLoaderTileView());

    }

    private CompositeDisposable subscription = new CompositeDisposable();

    @Override
    public void bind()
    {
        subscription
            .add(RxHandlers.click(view.getOpenButton()).subscribe(event -> {
                // дизейблим кнопку на 1000 мс, что бы избежать даблклика
                view.getOpenButton().setEnabled(false);
                openOmLoader();
                Scheduler.get().scheduleFixedDelay(() -> {
                    view.getOpenButton().setEnabled(true);
                    return false;
                }, 1000);
            }));

    }
    
    private void openOmLoader()
    {
        omLoaderPresenter = new OmLoaderPresenter(
            new BmOmDialogLoaderClientFactory()
            {
                public WizardView getWizardView(String title)
                {
                    return new WizardViewImpl(title)
                    {
                        @Override
                        public void hide()
                        {
                            super.hide();
                            stopOmPresenter();
                        }

                    };
                }
            })
        {
            @Override
            public void doClose(ClickEvent e)
            {
                super.doClose(e);
                stopOmPresenter();
            }
        };
        omLoaderPresenter.start(null, eventBus);
        eventBus.fireEvent(new OpenOmLoaderEvent());
    }

    @Override
    public void onStop()
    {
        subscription.clear();
        stopOmPresenter();
        super.onStop();
    }
    
    private void stopOmPresenter()
    {
        if (omLoaderPresenter != null)
        {
            omLoaderPresenter.onStop();
            omLoaderPresenter = null;
        }
    }
}
