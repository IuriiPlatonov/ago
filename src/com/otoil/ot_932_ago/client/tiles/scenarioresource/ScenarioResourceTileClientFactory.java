package com.otoil.ot_932_ago.client.tiles.scenarioresource;


import com.otoil.ot_932_2_0780.client.ScenarioResourceClientFactory;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTilePresenter.ScenarioResourceModelTileModel;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTilePresenter.ScenarioResourceModelTileView;


public interface ScenarioResourceTileClientFactory
{
    ScenarioResourceModelTileModel getScenarioResourceModelTileModel();

    ScenarioResourceModelTileView getScenarioResourceModelTileView();

    ScenarioResourceClientFactory getScenarioResourceClientFactory();
}
