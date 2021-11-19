package com.otoil.ot_932_ago.client.thema.main;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource.ImportedWithPrefix;
import com.google.gwt.resources.client.DataResource;

import ru.ot.wevelns.client.main.resources.UserButtonBackgroundResources;
import ru.ot.wevelns.client.main.resources.UserButtonBackgroundStyle;


public interface NornickelUserButtonBackgroundResources
        extends UserButtonBackgroundResources
{
    NornickelUserButtonBackgroundResources INSTANCE = GWT
        .create(NornickelUserButtonBackgroundResources.class);

    @Source({"ru/ot/wevelns/client/main/resources/UserButtonBackground.css",
        "NornickelUserButtonBackground.css"})
    NornickelUserButtonBackgroundStyle css();

    @Source("footer_big_normal.png")
    DataResource userFullNormal();

    @Source("footer_big_pressed.png")
    DataResource userFullPressed();

    @Source("footer_big_hover.png")
    DataResource userFullHover();

    @Source("footer_small_hover.png")
    DataResource userShortNormal();

    @Source("footer_small_pressed.png")
    DataResource userShortPressed();

    @Source("footer_small_hover.png")
    DataResource userShortHover();

    @ImportedWithPrefix("Nornickel")
    interface NornickelUserButtonBackgroundStyle
            extends UserButtonBackgroundStyle
    {
    }
}