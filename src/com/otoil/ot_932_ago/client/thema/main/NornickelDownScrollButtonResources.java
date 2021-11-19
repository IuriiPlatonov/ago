package com.otoil.ot_932_ago.client.thema.main;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;

import ru.ot.wevelns.client.main.resources.DownScrollButtonResources;


public interface NornickelDownScrollButtonResources
        extends DownScrollButtonResources
{
    NornickelDownScrollButtonResources INSTANCE = GWT
        .create(NornickelDownScrollButtonResources.class);

    @Override
    @Source("down_scroll_normal.png")
    ImageResource up();

    @Override
    @Source("down_scroll_disabled.png")
    ImageResource upDisabled();

    @Override
    @Source("down_scroll_hover.png")
    ImageResource upHover();

    @Override
    @Source("down_scroll_pressed.png")
    ImageResource upPressed();
}