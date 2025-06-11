package com.example.controllers; 

import com.example.models.Cartao;
import com.example.models.CartaoRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Optional;

@Path("/api/cartoes") 
@Produces(MediaType.APPLICATION_JSON) 
public class CartaoController {

    @Inject
    CartaoRepository cartaoRepository; 

    @GET
    @Path("/verificar/{numeroCartao}")
    public Response verificarCartao(@PathParam("numeroCartao") String numeroCartao) {
        if (numeroCartao == null || numeroCartao.trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("{\"mensagem\": \"Número do cartão não pode ser vazio.\"}")
                           .build();
        }

        Optional<Cartao> cartaoOptional = cartaoRepository.findByNumeroCartao(numeroCartao);

        if (cartaoOptional.isPresent()) {
            // Cartão encontrado, retorna os dados do cartão
            return Response.ok(cartaoOptional.get()).build();
        } else {
            // Cartão não encontrado
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("{\"mensagem\": \"Cartão com número " + numeroCartao + " não encontrado.\"}")
                           .build();
        }
    }
}
