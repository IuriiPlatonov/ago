package com.otoil.ot_932_ago.client.tiles;


import com.otoil.ot_040_5_0010.client.tile.manual.ManualTilePresenter.ManualTileModel;
import com.otoil.ot_040_5_0010.client.tile.manual.ManualTilePresenter.ManualTileView;
import com.otoil.ot_932_2_0050.micromine.client.tiles.calcworks.CalcWorksTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.bmloader.factory.BmLoaderClientFactory;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.omloader.factory.OmLoaderTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTileClientFactory;

import ru.ot.mvp.client.factory.ClientFactory;


public interface OT_932_TileClientFactory extends ClientFactory
{
    ManualTileModel getUserHelpManualTileModel();

    ManualTileView getUserHelpManualView();

    ClassifyTileClientFactory getClassifyTileClientFactory();

    ParamsBMTileClientFactory getParamsBMTileClientFactory();
    
    GetReportTileClientFactory getGetReportTileClientFactory();

    ScenarioResourceTileClientFactory getScenarioResourceModelTileClientFactory();
    
    BmLoaderClientFactory getBmLoaderClientFactory();
    
    OmLoaderTileClientFactory getOmLoaderTileClientFactory();
    
    RestorationgeoTileClientFactory getRestorationgeoTileClientFactory();
    
    CalcWorksTileClientFactory getCalcWorksTileClientFactory();
}
