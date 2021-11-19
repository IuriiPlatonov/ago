package com.otoil.ot_932_ago.client.thema.main;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;

import ru.ot.wevelns.client.main.resources.UpScrollButtonResources;


public interface NornickelUpScrollButtonResources
        extends UpScrollButtonResources
{
    NornickelUpScrollButtonResources INSTANCE = GWT
        .create(NornickelUpScrollButtonResources.class);

    @Override
    @Source("up_scroll_normal.png")
    ImageResource up();

    @Override
    @Source("up_scroll_disabled.png")
    ImageResource upDisabled();

    @Override
    @Source("up_scroll_hover.png")
    ImageResource upHover();

    @Override
    @Source("up_scroll_pressed.png")
    ImageResource upPressed();
}