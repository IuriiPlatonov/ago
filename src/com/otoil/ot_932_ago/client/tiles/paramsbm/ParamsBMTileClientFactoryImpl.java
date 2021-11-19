package com.otoil.ot_932_ago.client.tiles.paramsbm;


import ru.ot.mvp.client.factory.AbstractClientFactory;
import ru.ot.mvp.client.history.AsyncPlaceController;

import com.otoil.ot_932_2_0510.client.BlockModelParametersClientFactory;
import com.otoil.ot_932_2_0510.client.BlockModelParametersClientFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTilePresenter.ParamsBMTileModel;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTilePresenter.ParamsBMTileView;


public class ParamsBMTileClientFactoryImpl extends AbstractClientFactory
        implements ParamsBMTileClientFactory
{
    public ParamsBMTileClientFactoryImpl(AsyncPlaceController placeController)
    {
        super(placeController);
    }

    @Override
    public ParamsBMTileModel getParamsBMTileModel()
    {
        return new ParamsBMTileModelImpl();
    }

    @Override
    public ParamsBMTileView getParamsBMTileView()
    {
        return new ParamsBMTileViewImpl();
    }

    @Override
    public BlockModelParametersClientFactory getBlockModelParametersClientFactory()
    {
        return new BlockModelParametersClientFactoryImpl();
    }
}
