package com.otoil.ot_932_ago.client;


import com.google.common.base.Objects;
import com.google.gwt.place.shared.Place;


public class UnderConstructionPlace extends Place
{
    private final String formToken;
    private final String formId;

    public UnderConstructionPlace(String formToken, String formId)
    {
        this.formToken = formToken;
        this.formId = formId;
    }

    public String getFormToken()
    {
        return formToken;
    }

    public String getFormId()
    {
        return formId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(formId, formToken);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        UnderConstructionPlace other = (UnderConstructionPlace) obj;
        return Objects.equal(this.formId, other.formId) && Objects.equal(
            tokenMainPart(this.formToken), tokenMainPart(other.formToken));
    }

    private static String tokenMainPart(String token)
    {
        if (token == null)
        {
            return null;
        }

        int i = token.indexOf(':');
        if (i < 0)
        {
            return token;
        }
        else
        {
            return token.substring(0, i);
        }
    }
}
