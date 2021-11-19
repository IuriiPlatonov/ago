package com.otoil.ot_932_ago.client.tiles.restorationgeo;


import com.otoil.ot_932_2_0510.client.BlockModelParametersClientFactory;
import com.otoil.ot_932_2_0510.client.BlockModelParametersClientFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTilePresenter.RestorationgeoTileModelTileModel;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTilePresenter.RestorationgeoTileModelTileView;

import ru.ot.mvp.client.factory.AbstractClientFactory;
import ru.ot.mvp.client.history.AsyncPlaceController;


public class RestorationgeoTileClientFactoryImpl extends AbstractClientFactory
        implements RestorationgeoTileClientFactory
{
    public RestorationgeoTileClientFactoryImpl(AsyncPlaceController placeController)
    {
        super(placeController);
    }

    @Override
    public RestorationgeoTileModelTileModel getRestorationgeoTileModel()
    {
        return new RestorationgeoTileModelImpl();
    }

    @Override
    public RestorationgeoTileModelTileView getRestorationgeoTileView()
    {
        return new RestorationgeoTileViewImpl();
    }

    @Override
    public BlockModelParametersClientFactory getBlockModelParametersClientFactory()
    {
        return new BlockModelParametersClientFactoryImpl();
    }
}
