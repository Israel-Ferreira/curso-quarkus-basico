package io.codekaffee;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.codekaffee.dto.ProdutoDTO;
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


    @POST
    @Transactional
    public Response criarProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto(produtoDTO);


        try {
            produto.persist();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return Response.status(Status.BAD_REQUEST).build();
        }


    
        return Response.status(Status.CREATED).build();

    }



    @PUT
    @Path("{id}")
    @Transactional
    public Response atualizarProduto(@PathParam("id") Long id, ProdutoDTO produtoDTO){
        var product = Produto.findByIdOptional(id);

        if(product.isEmpty()){
            return Response.status(Status.NOT_FOUND).build();
        }


        Produto produto = (Produto) product.get();
        produto.setNome(produtoDTO.getNome());
        produto.setValor(produtoDTO.getValor());

        produto.persist();

        return Response.noContent().build();
        
    }



    @DELETE
    @Path("{id}")
    @Transactional
    public Response deletarProduto(@PathParam("id") Long id){
        var deleted =  Produto.deleteById(id);

        if(!deleted){
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.noContent().build();
    }

}
