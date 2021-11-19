package com.otoil.ot_932_ago.client.thema.main;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource.ImportedWithPrefix;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

import ru.ot.wevelns.client.main.resources.FavoriteButtonStyle;
import ru.ot.wevelns.client.main.resources.MainFormResources;
import ru.ot.wevelns.client.main.resources.MainFormStyle;
import ru.ot.wevelns.client.main.resources.UserButtonStyle;


public interface NornickelMainFormResources extends MainFormResources
{
    NornickelMainFormResources INSTANCE = GWT
        .create(NornickelMainFormResources.class);

    @ImportedWithPrefix("Nornickel")
    interface NornickelMainFormStyle extends MainFormStyle
    {
    }

    @ImportedWithPrefix("Nornickel")
    interface NornickelUserButtonStyle extends UserButtonStyle
    {
    }

    @ImportedWithPrefix("Nornickel")
    interface NornickelFavoriteButtonStyle extends FavoriteButtonStyle
    {
    }

    @Override
    @Source({"ru/ot/wevelns/client/main/resources/MainForm.css",
        "ru/ot/wevelns/client/main/resources/TitlePanel.css",
        "NornickelMainForm.css"})
    NornickelMainFormStyle style();

    @Override
    @Source({"ru/ot/wevelns/client/main/resources/UserButton.css",
        "NornickelUserButton.css"})
    NornickelUserButtonStyle userButtonStyle();

    @Override
    @Source({"ru/ot/wevelns/client/main/resources/FavoriteButton.css",
        "NornickelFavoriteButton.css"})
    NornickelFavoriteButtonStyle favoriteButtonStyle();

    @Override
    @Source("shadow.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource shadow();

//    @Override
//    @Source("logo_full.png")
//    ImageResource imgLogoFull();
//
//    @Override
//    @Source("logo_short.png")
//    ImageResource imgLogoShort();

    @Override
    @Source("img01191.png")
    ImageResource imgUser();

    @Override
    @Source("search.png")
    ImageResource imgSearch();

    @Override
    @Source("search_small.png")
    ImageResource imgSearchField();

    @Override
    @Source("star_pressed.png")
    ImageResource imgFavoriteChecked();

    @Override
    @Source("star_unactive.png")
    ImageResource imgFavoriteUnchecked();

    @Override
    @Source("ru/ot/gwt/atoll/client/images/img1901_32x32.png")
    ImageResource imgPopularMenuItem();

    @Override
    @Source("ru/ot/gwt/atoll/client/images/img1900_32x32.png")
    ImageResource imgLastUsageMenuItem();
    
    @Override
    @Source("ru/ot/gwt/atoll/client/images/img1970_32x32.png")
    ImageResource imgApplication();
}