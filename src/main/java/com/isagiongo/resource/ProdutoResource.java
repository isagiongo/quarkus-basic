package com.isagiongo.resource;

import com.isagiongo.models.Produto;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;
import com.isagiongo.services.ProdutoService;

import javax.inject.Inject;
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
    @Timed(name = "duracao busca produtos")
    public List<Produto> getProdutos() {
        return produtoService.getProdutos();
    }

    @POST
    public void addProduto(Produto produto) {
        produtoService.salvaProduto(produto);
    }

    @GET
    @Path("/memoria")
    @Gauge(name = "quantidade memoria livre", unit = MetricUnits.BYTES)
    public long quantidadeMemoria() {
        return Runtime.getRuntime().freeMemory();
    }
}
