package com.otoil.ot_932_ago.client.tiles.bmloader;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.IsWidget;
import com.intendia.rxgwt2.user.RxHandlers;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.BmOmDialogLoaderClientFactory;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.bm.BmLoaderPresenter;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.bm.event.OpenBmLoaderEvent;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.wizard.AbstractWizardPresenter.WizardView;
import com.otoil.ot_932_2_0050.micromine.client.form.set6.wizard.impl.WizardViewImpl;
import com.otoil.ot_932_ago.client.tiles.bmloader.BmLoaderTilePresenter.BMTileLoaderModel;
import com.otoil.ot_932_ago.client.tiles.bmloader.BmLoaderTilePresenter.BmLoaderTileView;
import com.otoil.ot_932_ago.client.tiles.bmloader.factory.BmLoaderClientFactory;

import io.reactivex.disposables.CompositeDisposable;
import ru.ot.mvp.client.presenters.AbstractPresenter;
import ru.ot.mvp.client.presenters.Model;
import ru.ot.wevelns.client.action.Action;


/**
 * Запуск блочной модели
 */
public class BmLoaderTilePresenter
        extends AbstractPresenter<BMTileLoaderModel, BmLoaderTileView>
{

    public interface BmLoaderTileView extends IsWidget
    {

        Action getOpenButton();
    }

    public interface BMTileLoaderModel extends Model
    {

    }

    private final BmLoaderClientFactory clientFactory;

    public BmLoaderTilePresenter(final BmLoaderClientFactory clientFactory)
    {
        super(clientFactory.getBMTileLoaderModel(),
            clientFactory.getBmLoaderTileView());
        this.clientFactory = clientFactory;
    }

    private CompositeDisposable subscription = new CompositeDisposable();
    private BmLoaderPresenter bmLoaderPresenter = null;

    @Override
    public void bind()
    {
        subscription
            .add(RxHandlers.click(view.getOpenButton()).subscribe(event -> {
                bmLoaderPresenter = new BmLoaderPresenter(
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
                                    stopBmPresenter();
                                }

                            };
                        }
                    })
                {
                    @Override
                    public void doClose(ClickEvent e)
                    {
                        super.doClose(e);
                        stopBmPresenter();
                    }
                };
                bmLoaderPresenter.start(null, eventBus);
                eventBus.fireEvent(new OpenBmLoaderEvent());
            }));

    }

    @Override
    public void onStop()
    {
        subscription.clear();
        stopBmPresenter();
        super.onStop();
    }

    private void stopBmPresenter()
    {
        if (bmLoaderPresenter != null)
        {
            bmLoaderPresenter.onStop();
            bmLoaderPresenter = null;
        }
    }
}
