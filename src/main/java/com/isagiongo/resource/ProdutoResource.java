package com.isagiongo.resource;

import models.Produto;
import org.eclipse.microprofile.metrics.annotation.Counted;
import services.ProdutoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoService produtoService;

    @GET
    @Counted(name = "produtos")
    public List<Produto> getProdutos() {
        return produtoService.getProdutos();
    }

    @POST
    public void addProduto(Produto produto) {
        produtoService.salvaProduto(produto);
    }
}
