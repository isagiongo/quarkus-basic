package com.isagiongo.services;

import com.isagiongo.models.Municipio;
import com.isagiongo.models.UnidadeFederativa;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class LocalidadeService {

    @Inject
    EntityManager entityManager;

    @Inject
    @RestClient
    UnidadeFederativaService ufService;

    public List<Municipio> getMunicipios() {
        return entityManager.createQuery("select m from Municipio m", Municipio.class).getResultList();
    }

    public void addMunicipio(Municipio municipio) {
        entityManager.persist(municipio);
    }

    public UnidadeFederativa getUF(Integer id) {
        return ufService.getUF(id);
    }
}
