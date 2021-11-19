package com.otoil.ot_932_ago.client.thema.main;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource.ImportedWithPrefix;
import com.google.gwt.resources.client.ImageResource;

import ru.ot.wevelns.client.main.resources.MainMenuCellTreeResources;
import ru.ot.wevelns.client.main.resources.MainMenuCellTreeStyle;


public interface NornickelMainMenuCellTreeResources
        extends MainMenuCellTreeResources
{
    NornickelMainMenuCellTreeResources INSTANCE = GWT
        .create(NornickelMainMenuCellTreeResources.class);

    @Override
    @Source({"ru/ot/wevelns/client/CellWidgetColors.css",
        "ru/ot/wevelns/client/tree/resources/CellTree.css",
        "ru/ot/wevelns/client/main/resources/MainMenuCellTree.css",
        "NornickelMainMenuCellTree.css"})
    NornickelMainMenuCellTreeStyle cellTreeStyle();

    @Override
    @Source("arrow_tree_right.png")
    ImageResource cellTreeClosedItem();

    @Override
    @Source("arrow_tree_down.png")
    ImageResource cellTreeOpenItem();

    @ImportedWithPrefix("Nornickel")
    interface NornickelMainMenuCellTreeStyle extends MainMenuCellTreeStyle
    {
    }
}