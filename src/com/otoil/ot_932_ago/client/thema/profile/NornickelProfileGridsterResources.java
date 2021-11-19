package com.otoil.ot_932_ago.client.thema.profile;


import com.google.gwt.core.shared.GWT;
import com.otoil.ot_040_1_0050.client.resources.ProfileGridsterResources;
import com.otoil.ot_040_1_0050.client.resources.ProfileStyle;


public interface NornickelProfileGridsterResources
        extends ProfileGridsterResources
{
    NornickelProfileGridsterResources INSTANCE = GWT
        .create(NornickelProfileGridsterResources.class);

    @Override
    @Source({"com/otoil/ot_040_1_0050/client/resources/ProfileGridster.css",
        "NornickelProfileGridster.css"})
    ProfileGridsterStyle css();

    @Override
    @Source({"com/otoil/ot_040_1_0050/client/resources/TileColors.css",
        "NornickelTileColors.css",
        "com/otoil/ot_040_1_0050/client/resources/Profile.css"})
    ProfileStyle profileCss();
}
