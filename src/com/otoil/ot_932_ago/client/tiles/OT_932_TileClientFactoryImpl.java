package com.otoil.ot_932_ago.client.tiles;


import com.otoil.ot_040_5_0010.client.tile.manual.ManualTilePresenter.ManualTileModel;
import com.otoil.ot_040_5_0010.client.tile.manual.ManualTilePresenter.ManualTileView;
import com.otoil.ot_932_2_0050.micromine.client.tiles.calcworks.CalcWorksTileClientFactory;
import com.otoil.ot_932_2_0050.micromine.client.tiles.calcworks.CalcWorksTileClientFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.bmloader.factory.BmLoaderClientFactory;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTileClientFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTileClientFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.omloader.factory.OmLoaderTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTileClientFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTileClientFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTileClientFactory;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTileClientFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.usermanual.UserHelpManualTileModelImpl;
import com.otoil.ot_932_ago.client.tiles.usermanual.UserHelpManualTileViewImpl;

import ru.ot.mvp.client.factory.AbstractClientFactory;
import ru.ot.mvp.client.history.AsyncPlaceController;


public class OT_932_TileClientFactoryImpl extends AbstractClientFactory
        implements OT_932_TileClientFactory
{
    public OT_932_TileClientFactoryImpl(AsyncPlaceController placeController)
    {
        super(placeController);
    }

    @Override
    public ManualTileModel getUserHelpManualTileModel()
    {
        return new UserHelpManualTileModelImpl();
    }

    @Override
    public ManualTileView getUserHelpManualView()
    {
        return new UserHelpManualTileViewImpl();
    }

    @Override
    public ClassifyTileClientFactory getClassifyTileClientFactory()
    {
        return new ClassifyTileClientFactoryImpl(placeController);
    }

    @Override
    public ParamsBMTileClientFactory getParamsBMTileClientFactory()
    {
        return new ParamsBMTileClientFactoryImpl(placeController);
    }

    @Override
    public GetReportTileClientFactory getGetReportTileClientFactory()
    {
        return new GetReportTileClientFactoryImpl(placeController);
    }

    @Override
    public ScenarioResourceTileClientFactory getScenarioResourceModelTileClientFactory()
    {
        return new ScenarioResourceTileClientFactoryImpl(placeController);
    }

    @Override
    public BmLoaderClientFactory getBmLoaderClientFactory()
    {
        return new BmLoaderClientFactory()
        {
            
            @Override
            public AsyncPlaceController getPlaceController()
            {
                return placeController;
            }
        };
    }

    @Override
    public OmLoaderTileClientFactory getOmLoaderTileClientFactory()
    {
        return new OmLoaderTileClientFactory()
        {
            
            @Override
            public AsyncPlaceController getPlaceController()
            {
                return placeController;
            }
        };
    }

    @Override
    public RestorationgeoTileClientFactory getRestorationgeoTileClientFactory()
    {
        return new RestorationgeoTileClientFactoryImpl(placeController);
    }
    
    @Override
    public CalcWorksTileClientFactory getCalcWorksTileClientFactory()
    {
        return new CalcWorksTileClientFactoryImpl(placeController);
    }
}
