package com.otoil.ot_932_ago.client.tiles.paramsbm;


import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.IsWidget;
import com.intendia.rxgwt2.user.RxHandlers;

import ru.ot.mvp.client.presenters.AbstractPresenter;
import ru.ot.mvp.client.presenters.Model;
import ru.ot.wevelns.client.action.Action;

import com.otoil.ot_932_2_0510.client.events.OpenBlockModelParametersEvent;
import com.otoil.ot_932_2_0510.client.form.BlockModelParametersPresenter;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTilePresenter.ParamsBMTileModel;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTilePresenter.ParamsBMTileView;

import io.reactivex.disposables.CompositeDisposable;


public class ParamsBMTilePresenter
        extends AbstractPresenter<ParamsBMTileModel, ParamsBMTileView>
{
    public interface ParamsBMTileModel extends Model
    {

    }

    public interface ParamsBMTileView extends IsWidget
    {
        Action openBlockModelParameters();

        HasClickHandlers close();
    }

    private CompositeDisposable subscription = new CompositeDisposable();
    private ParamsBMTileClientFactory clientFactory;
    private BlockModelParametersPresenter blockModelParametersPresenter;

    public ParamsBMTilePresenter(ParamsBMTileClientFactory clientFactory)
    {
        super(clientFactory.getParamsBMTileModel(),
            clientFactory.getParamsBMTileView());
        this.clientFactory = clientFactory;
    }

    public BlockModelParametersPresenter ensureBlockModelParametersPresenter()
    {
        if (blockModelParametersPresenter != null)
        {
            blockModelParametersPresenter.onStop();
        }
        blockModelParametersPresenter = new BlockModelParametersPresenter(
            clientFactory.getBlockModelParametersClientFactory());
        blockModelParametersPresenter.start(null, eventBus);
        return blockModelParametersPresenter;
    }

    @Override
    public void bind()
    {
        subscription.add(RxHandlers.click(view.openBlockModelParameters())
            .subscribe(event -> {
                ensureBlockModelParametersPresenter();
                eventBus.fireEvent(new OpenBlockModelParametersEvent());
            }));

        subscription.add(RxHandlers.click(view.close()).subscribe(event -> {
            onStop();
        }));
    }

    @Override
    public void onStop()
    {
        subscription.clear();
        if (blockModelParametersPresenter != null)
        {
            blockModelParametersPresenter.onStop();
            blockModelParametersPresenter = null;
        }
        super.onStop();
    }
}
