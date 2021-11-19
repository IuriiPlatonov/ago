package com.otoil.ot_932_ago.client.tiles.usermanual;


import com.google.gwt.core.client.GWT;

import com.otoil.ot_040_5_0010.client.tile.manual.ManualTileViewImpl;
import com.otoil.ot_932_ago.client.i18n.OreMainConstantsFactory;
import com.otoil.ot_932_ago.client.tiles.usermanual.resourses.UserHelpManualTileResources;


public class UserHelpManualTileViewImpl extends ManualTileViewImpl
{
    public UserHelpManualTileViewImpl()
    {
        super(UserHelpManualTileResources.INSTANCE,
            OreMainConstantsFactory.getInstance().userHelpManualTileName());

        setCaption(OreMainConstantsFactory.getInstance().userHelpManualTitle());
    }

    @Override
    public String convertManualUrl(String url)
    {
        return GWT.getHostPageBaseURL() + url;
    }
}
