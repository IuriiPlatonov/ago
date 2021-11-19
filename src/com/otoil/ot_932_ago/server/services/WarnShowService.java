package com.otoil.ot_932_ago.server.services;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.otoil.ot_932_ago.client.services.WarnShowServiceAsync;

import ru.ot.gwt.utils.server.ServiceHelper;


@Path("/toshow")
public class WarnShowService implements WarnShowServiceAsync
{

    @Context
    private HttpServletRequest request;

    @Override
    public Boolean getToShowWarn()
    {
        AtomicBoolean isShowSecretDialog = ServiceHelper.getAttributeValue(
            request.getSession(), "toShowWarn", () -> new AtomicBoolean(true));
        return isShowSecretDialog.get();
    }

    @Override
    public Boolean setToShowWarn(Boolean value)
    {
        AtomicBoolean isShowSecretDialog = ServiceHelper.getAttributeValue(
            request.getSession(), "toShowWarn", () -> new AtomicBoolean(value));
        isShowSecretDialog.set(value);
        return isShowSecretDialog.get();
    }

}
