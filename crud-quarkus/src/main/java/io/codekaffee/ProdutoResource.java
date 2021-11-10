package io.codekaffee;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.codekaffee.models.Produto;

@Path("produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    
    @GET
    public List<Produto> buscarTodos(){
        // Padrão Active Record
        return Produto.listAll();
    } 
}
