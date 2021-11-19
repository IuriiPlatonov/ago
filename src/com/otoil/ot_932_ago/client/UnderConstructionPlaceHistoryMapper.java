package com.otoil.ot_932_ago.client;


import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;


public class UnderConstructionPlaceHistoryMapper implements PlaceHistoryMapper
{
    private final Map<String, String> unimplementedFormTokensAndIds;

    /**
     * @param unimplementedFormTokensAndIds - нереализованные формы. ключ -
     *            токен формы, значение - идентификатор формы (например,
     *            ("license-monitoring", "OT_932_1_0010") )
     */
    public UnderConstructionPlaceHistoryMapper(
        Map<String, String> unimplementedFormTokensAndIds)
    {
        this.unimplementedFormTokensAndIds = unimplementedFormTokensAndIds;
    }

    @Override
    public Place getPlace(String token)
    {
        if (token != null)
        {
            for (Entry<String, String> form : unimplementedFormTokensAndIds
                .entrySet())
            {
                String formToken = form.getKey();
                String formId = form.getValue();

                if (token.startsWith(withColon(formToken)))
                {
                    return new UnderConstructionPlace(token, formId);
                }
            }
        }

        return null;
    }

    private static String withColon(String str)
    {
        return str.endsWith(":") ? str : str + ":";
    }

    @Override
    public String getToken(Place place)
    {
        if (place instanceof UnderConstructionPlace)
        {
            return ((UnderConstructionPlace) place).getFormToken();
        }

        return null;
    }
}
