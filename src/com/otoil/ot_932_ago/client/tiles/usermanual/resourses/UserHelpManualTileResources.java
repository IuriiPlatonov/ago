package com.otoil.ot_932_ago.client.tiles.usermanual.resourses;


import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ImageResource;

import com.otoil.ot_040_5_0010.client.tile.manual.resources.ManualTileResources;


public interface UserHelpManualTileResources extends ManualTileResources
{
    UserHelpManualTileResources INSTANCE = GWT
        .create(UserHelpManualTileResources.class);

    @Source("docs_icon.png")
    ImageResource icon();
}
