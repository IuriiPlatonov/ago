package com.otoil.ot_932_ago.client;


import com.otoil.ot_040_5_0010.client.tile.desktop.DesktopTilePlacer;
import com.otoil.ot_040_5_0010.client.tile.quicklauncher.FavoritesTile;
import com.otoil.ot_932_2_0050.micromine.client.tiles.calcworks.CalcWorksTile;
import com.otoil.ot_932_ago.client.tiles.bmloader.BmLoaderTile;
import com.otoil.ot_932_ago.client.tiles.classify.ClassifyTile;
import com.otoil.ot_932_ago.client.tiles.getreport.GetReportTile;
import com.otoil.ot_932_ago.client.tiles.omloader.OmLoaderTile;
import com.otoil.ot_932_ago.client.tiles.paramsbm.ParamsBMTile;
import com.otoil.ot_932_ago.client.tiles.restorationgeo.RestorationgeoTile;
import com.otoil.ot_932_ago.client.tiles.scenarioresource.ScenarioResourceTile;
import com.otoil.ot_932_ago.client.tiles.usermanual.UserHelpManualTile;
import com.otoil.tiles.client.TileRegistry;

import ru.ot.gwt.authorise.client.access.AccessManager;
import ru.ot.wevelns.client.Point;


/**
 * SettingsFilterTilePlacer скачает из БД плитки, которые соответствуют
 * сохраненным фильтрам и разместит их
 */
public class OT_932_TilePlacer extends DesktopTilePlacer
{
    public static final String PROFILE_FORM_ID = "OT_100_1_0150";
    private static final AccessManager accessManager = AccessManager
        .getInstance();

    public OT_932_TilePlacer(TileRegistry register)
    {
        super(PROFILE_FORM_ID, register, 3, 6);

        FavoritesTile favoritesTile = new FavoritesTile();
        register.registerTiles(favoritesTile);
        placeTile(new Point(1, 1), favoritesTile);

        if (accessManager.isFunctionsGranted("OT.932.APP.SF.16.000"))
        {
            UserHelpManualTile userHelpManualTile = new UserHelpManualTile();
            register.registerTiles(userHelpManualTile);
            placeTile(new Point(1, 2), userHelpManualTile);
        }
        if (accessManager.isFunctionsGranted("OT.932.APP.SF.1.004.10"))
        {
            GetReportTile getReportTile = new GetReportTile();
            register.registerTiles(getReportTile);
            placeTile(new Point(1, 8), getReportTile);
        }

        if (accessManager.isFunctionsGranted("OT.932.APP.SF.1.004.06"))
        {
            ClassifyTile classifyTile = new ClassifyTile();
            register.registerTiles(classifyTile);
            placeTile(new Point(1, 3), classifyTile);
        }

        if (accessManager.isFunctionsGranted("OT.932.APP.SF.10.001"))
        {
            ParamsBMTile paramsBMTile = new ParamsBMTile();
            register.registerTiles(paramsBMTile);
            placeTile(new Point(1, 4), paramsBMTile);
        }

        if (accessManager.isFunctionsGranted("OT.932.APP.SF.10.003"))
        {
            ScenarioResourceTile srmTile = new ScenarioResourceTile();
            register.registerTiles(srmTile);
            placeTile(new Point(2, 2), srmTile);
        }

        if (accessManager.isFunctionsGranted("OT.932.APP.SF.15.001"))
        {

            BmLoaderTile bmLoaderTile = new BmLoaderTile();
            register.registerTiles(bmLoaderTile);
            placeTile(new Point(1, 5), bmLoaderTile);
        }

        if (accessManager.isFunctionsGranted("OT.932.APP.SF.15.002"))
        {
            OmLoaderTile omLoaderTile = new OmLoaderTile();
            register.registerTiles(omLoaderTile);
            placeTile(new Point(2, 5), omLoaderTile);
        }
        
        if (accessManager.isFunctionsGranted("OT.932.APP.SF.10.005"))
        {
            RestorationgeoTile restorationgeoTile = new RestorationgeoTile();
            register.registerTiles(restorationgeoTile);
            placeTile(new Point(1, 6), restorationgeoTile);
        }
        
//        if (accessManager.isFunctionsGranted("OT.932.APP.SF.1.004.18"))
//        {
//            CalcWorksTile calcWorksTile = new CalcWorksTile();
//            register.registerTiles(calcWorksTile);
//            placeTile(new Point(1, 7), calcWorksTile);
//        }

    }
}
