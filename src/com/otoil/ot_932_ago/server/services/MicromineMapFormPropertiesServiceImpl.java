package com.otoil.ot_932_ago.server.services;


import java.util.Map;

import javax.ws.rs.Path;

import ru.ot.gwt.authorise.server.ParamsXML;

import com.otoil.ot_932_5_0020.shared.service.MicromineMapFormPropertiesService;


@Path("/mapformnames")

public class MicromineMapFormPropertiesServiceImpl
        implements MicromineMapFormPropertiesService
{
    private static final String PATH_MAP_FORM_NAMES = "micromine.mapProperty";

    @Override
    public Map<String, String> getMapFormProperties()
    {
        return ParamsXML.getInstance().getBySet(PATH_MAP_FORM_NAMES);
    }
}
