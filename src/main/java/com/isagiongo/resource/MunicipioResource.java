package com.isagiongo.resource;

import com.isagiongo.models.Municipio;
import com.isagiongo.models.UnidadeFederativa;
import com.isagiongo.services.LocalidadeService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/municipios")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MunicipioResource {

    @Inject
    LocalidadeService localidadeService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Municipio> getMunicipios() {
        return localidadeService.getMunicipios();
    }

    @GET
    @Path("/{idMunicipio}/uf")
    public UnidadeFederativa getUF(@PathParam("idMunicipio") Integer idMunicipio) {
        Optional<Municipio> municipio = localidadeService.getMunicipios()
                .stream()
                .filter(m -> idMunicipio.equals(m.getId())).findFirst();
        if (municipio.isEmpty()) {
            throw new NotFoundException();
        }
        return localidadeService.getUF(municipio.get().getIdUF());

    }

    @POST
    public void addMunicipio(Municipio municipio) {
        localidadeService.addMunicipio(municipio);
    }


}
