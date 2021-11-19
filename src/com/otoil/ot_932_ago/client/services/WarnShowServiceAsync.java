package com.otoil.ot_932_ago.client.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.DirectRestService;


@Path("/rest/toshow")
public interface WarnShowServiceAsync extends DirectRestService
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Boolean getToShowWarn();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Boolean setToShowWarn(Boolean value);

}
