package com.otoil.ot_932_ago.client.thema.main;


import ru.ot.wevelns.client.main.resources.FormButtonBackgroundResources;
import ru.ot.wevelns.client.main.resources.FormButtonBackgroundStyle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource.ImportedWithPrefix;


public interface NornickelFormButtonBackgroundResources extends FormButtonBackgroundResources
{
    NornickelFormButtonBackgroundResources INSTANCE = GWT.create(NornickelFormButtonBackgroundResources.class);

    @Source({"ru/ot/wevelns/client/main/resources/FormButtonBackground.css",
    	"NornickelFormButtonBackground.css"})
    NornickelFormButtonBackgroundStyle css();
    
    @ImportedWithPrefix("Nornickel")
    interface NornickelFormButtonBackgroundStyle
            extends FormButtonBackgroundStyle
    {
    }
}
