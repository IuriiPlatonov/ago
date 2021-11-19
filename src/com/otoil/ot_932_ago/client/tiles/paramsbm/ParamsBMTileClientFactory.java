package com.otoil.ot_932_ago.client.tiles.paramsbm;


import com.otoil.ot_932_2_0510.client.BlockModelParametersClientFactory;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTilePresenter.ParamsBMTileModel;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTilePresenter.ParamsBMTileView;


public interface ParamsBMTileClientFactory
{
    ParamsBMTileModel getParamsBMTileModel();

    ParamsBMTileView getParamsBMTileView();

    BlockModelParametersClientFactory getBlockModelParametersClientFactory();
}
