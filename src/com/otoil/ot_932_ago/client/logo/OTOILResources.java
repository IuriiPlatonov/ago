package com.otoil.ot_932_ago.client.logo;


import ru.ot.wevelns.client.main.resources.MainFormResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;


public interface OTOILResources extends MainFormResources
{
    OTOILResources INSTANCE = GWT.create(OTOILResources.class);

    @Source("logo_big.png")
    ImageResource imgLogoFull();

    @Source("logo.png")
    ImageResource imgLogoShort();
}
