package com.isagiongo.services;

import com.isagiongo.models.UnidadeFederativa;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(configKey="ufs-api")
@Path("ufs")
@Produces(MediaType.APPLICATION_JSON)
public interface UnidadeFederativaService {

    public List<UnidadeFederativa> getUfs();

    @GET
    @Path("/{id}")
    public UnidadeFederativa getUF(@PathParam("id") Integer id);


}
