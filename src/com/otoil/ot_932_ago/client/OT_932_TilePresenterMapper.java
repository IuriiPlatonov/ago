package com.otoil.ot_932_ago.client;


import com.otoil.issue.creator.client.tray.IssueCreatorTile;
import com.otoil.issue.creator.client.tray.IssueCreatorTilePresenterFactory;
import com.otoil.ot_040_1_0020.client.tray.NotificationTrayTile;
import com.otoil.ot_040_1_0020.client.tray.NotificationTrayTilePresenterFactory;
import com.otoil.ot_040_1_0050.client.tiles.home.HomeTile;
import com.otoil.ot_040_1_0050.client.tiles.home.HomeTilePresenterFactory;
import com.otoil.ot_040_5_0010.client.form.monitoring.solrtile.tile.presenter.SolrTilePresenterFactory;
import com.otoil.ot_040_5_0010.client.tile.quicklauncher.FavoritesTile;
import com.otoil.ot_040_5_0010.client.tile.quicklauncher.FavoritesTilePresenterFactory;
import com.otoil.ot_040_5_0010.client.tile.quicklauncher.LastUsageTile;
import com.otoil.ot_040_5_0010.client.tile.quicklauncher.LastUsageTilePresenterFactory;
import com.otoil.ot_040_5_0010.client.tile.quicklauncher.PopularTile;
import com.otoil.ot_040_5_0010.client.tile.quicklauncher.PopularTtilePresenterFactory;
import com.otoil.ot_932_2_0050.micromine.client.tiles.calcworks.CalcWorksTile;
import com.otoil.ot_932_2_0050.micromine.client.tiles.calcworks.CalcWorksTilePresenterFactory;
import com.otoil.ot_932_ago.client.tiles.bmloader.BmLoaderTile;
import com.otoil.ot_932_ago.client.tiles.bmloader.factory.BmLoaderPresenterFactory;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTile;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTilePresenterFactory;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTile;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTilePresenterFactory;
import com.otoil.ot_932_ago.client.tiles.omloader.OmLoaderTile;
import com.otoil.ot_932_ago.client.tiles.omloader.factory.OmLoaderTilePresenterFactory;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTile;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTilePresenterFactory;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTile;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTilePresenterFactory;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTile;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTilePresenterFactory;
import com.otoil.ot_932_ago.client.tiles.usermanual.UserHelpManualTile;
import com.otoil.ot_932_ago.client.tiles.usermanual.UserHelpManualTilePresenterFactory;
import com.otoil.tiles.client.mapper.DefaultTilePresenterMapper;


public class OT_932_TilePresenterMapper extends DefaultTilePresenterMapper
{
    public OT_932_TilePresenterMapper(OT_932_ClientFactory clientFactory)
    {
        addTilePresenterFactory(UserHelpManualTile.class,
            new UserHelpManualTilePresenterFactory(
                clientFactory.getOT_932_TileClientFactory()));

        /*
         * Плитка "Домой". Явно мы ее не используем, но ее использует
         * "Рабочий стол"
         */
        addTilePresenterFactory(HomeTile.class, new HomeTilePresenterFactory(
            clientFactory.getProfileClientFactory()));

        addTilePresenterFactory(FavoritesTile.class,
            new FavoritesTilePresenterFactory());
        addTilePresenterFactory(LastUsageTile.class,
            new LastUsageTilePresenterFactory());
        addTilePresenterFactory(PopularTile.class,
            new PopularTtilePresenterFactory());

        addTilePresenterFactory(IssueCreatorTile.class,
            new IssueCreatorTilePresenterFactory(
                clientFactory.getIssueCreatorTilePresenterFactory()));

        addTilePresenterFactory(SolrTilePresenterFactory.SOLR_TILE_CLASS,
            new SolrTilePresenterFactory(
                clientFactory.getSolrTileClientFactory(),
                clientFactory.getPlaceHistoryMapper()));

        addTilePresenterFactory(ClassifyTile.class,
            new ClassifyTilePresenterFactory(clientFactory
                .getOT_932_TileClientFactory().getClassifyTileClientFactory()));

        addTilePresenterFactory(ParamsBMTile.class,
            new ParamsBMTilePresenterFactory(clientFactory
                .getOT_932_TileClientFactory().getParamsBMTileClientFactory()));
        
        addTilePresenterFactory(RestorationgeoTile.class,
            new RestorationgeoTilePresenterFactory(clientFactory
                .getOT_932_TileClientFactory().getRestorationgeoTileClientFactory()));
        
        addTilePresenterFactory(ScenarioResourceTile.class,
            new ScenarioResourceTilePresenterFactory(clientFactory
                .getOT_932_TileClientFactory().getScenarioResourceModelTileClientFactory()));

        addTilePresenterFactory(NotificationTrayTile.class,
            new NotificationTrayTilePresenterFactory(
                clientFactory.getNotificationClientFactory()));
        
        addTilePresenterFactory(GetReportTile.class,
            new GetReportTilePresenterFactory(clientFactory
                .getOT_932_TileClientFactory().getGetReportTileClientFactory()));
        
        addTilePresenterFactory(BmLoaderTile.class,
            new BmLoaderPresenterFactory(clientFactory
                .getOT_932_TileClientFactory().getBmLoaderClientFactory()));
        
        addTilePresenterFactory(OmLoaderTile.class,
            new OmLoaderTilePresenterFactory(clientFactory
                .getOT_932_TileClientFactory().getOmLoaderTileClientFactory()));
        
//        addTilePresenterFactory(CalcWorksTile.class,
//            new CalcWorksTilePresenterFactory(
//                clientFactory.getOT_932_TileClientFactory()
//                    .getCalcWorksTileClientFactory()));
    }

}
