package com.otoil.ot_932_ago.client.i18n;


import com.google.gwt.core.client.GWT;


public class OreMainConstantsFactory
{
    private static OreMainConstants constants = null;

    public static OreMainConstants getInstance()
    {
        if (constants == null)
        {
            constants = GWT.create(OreMainConstants.class);
        }

        return constants;
    }
}
