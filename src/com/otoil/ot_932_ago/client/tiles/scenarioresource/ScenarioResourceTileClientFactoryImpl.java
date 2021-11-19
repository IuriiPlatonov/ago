package com.otoil.ot_932_ago.client.tiles.scenarioresource;


import com.otoil.ot_932_2_0780.client.ScenarioResourceClientFactory;
import com.otoil.ot_932_2_0780.client.ScenarionResourceClientFactoryImpl;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTilePresenter.ScenarioResourceModelTileModel;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTilePresenter.ScenarioResourceModelTileView;

import ru.ot.mvp.client.factory.AbstractClientFactory;
import ru.ot.mvp.client.history.AsyncPlaceController;


public class ScenarioResourceTileClientFactoryImpl extends AbstractClientFactory
        implements ScenarioResourceTileClientFactory
{
    public ScenarioResourceTileClientFactoryImpl(AsyncPlaceController placeController)
    {
        super(placeController);
    }

    @Override
    public ScenarioResourceModelTileModel getScenarioResourceModelTileModel()
    {
        return new ScenarioResourceTileImpl();
    }

    @Override
    public ScenarioResourceModelTileView getScenarioResourceModelTileView()
    {
        return new ScenarioResourceTileViewImpl();
    }

    @Override
    public ScenarioResourceClientFactory getScenarioResourceClientFactory()
    {
        return new ScenarionResourceClientFactoryImpl();
    }
}
