package com.isagiongo.resource;

import com.isagiongo.PessoaRepository;
import com.isagiongo.models.Pessoa;
import com.isagiongo.models.PessoaDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON})
@Transactional
public class PessoaResource {

    @Inject
    PessoaRepository pessoaRepository;

    @GET
    public List<Pessoa> buscaPessoas() {
        return pessoaRepository.listAll();
    }

    @POST
    public void addPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setTipo(pessoaDTO.getTipo());
        pessoaRepository.persist(pessoa);
    }
}
