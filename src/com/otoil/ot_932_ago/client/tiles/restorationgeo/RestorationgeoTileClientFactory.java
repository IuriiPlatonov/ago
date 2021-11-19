package com.otoil.ot_932_ago.client.tiles.restorationgeo;

import com.otoil.ot_932_2_0510.client.BlockModelParametersClientFactory;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTilePresenter.RestorationgeoTileModelTileModel;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTilePresenter.RestorationgeoTileModelTileView;

public interface RestorationgeoTileClientFactory
{
    RestorationgeoTileModelTileModel getRestorationgeoTileModel();

    RestorationgeoTileModelTileView getRestorationgeoTileView();

    BlockModelParametersClientFactory getBlockModelParametersClientFactory();
}
