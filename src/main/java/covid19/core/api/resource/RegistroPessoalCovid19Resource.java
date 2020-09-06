package covid19.core.api.resource;

import covid19.core.api.dominio.RegistroPessoalCovid19;
import covid19.core.api.service.RegistroPessoalCovid19Service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * API Pesquisa Covid-19
 */
@Path("/registro-pessoal-covid19")
public class RegistroPessoalCovid19Resource {
    @Inject
    RegistroPessoalCovid19Service service;
    
    
    //--- TODO: CRUD post, get, put, delete
    /**
     * CRUD:
     * -create:     POST => /registro  { json contendo respostas para o registro }
     * -restore:    GET  => /registro/{id}
     * -update:     PUT  => /registro/{id} { json contendo respostas para o registro }
     * -delete:   DELETE => /registro/{id}
     */
    @POST
    @Path("/registro")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response postRegistro(RegistroPessoalCovid19 registro){
        //--- TODO: validar por null
        service.postRegistro(registro);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/registro/{id}")
    @Produces(APPLICATION_JSON)
    public Response getRegistro(@PathParam("id") String id){
        //--- TODO: validar por null
        RegistroPessoalCovid19 registro = service.findByIdRegistro(id);
        return Response.ok(registro).build();
    }
    
    
    
    /**
     * Se tem o registro, retornar 204
     * Se não tem o registro, então NÃO CRIAR e retornar 404
     *
     * @param registro
     * @return
     */
    @PUT
    @Path("/registro/{id}")
    public Response putRegistro(RegistroPessoalCovid19 registro){
        boolean existeRegistro = false;
        
        //--- TODO: validar por null \ validar existencia do registro sendo atualizado
        
        RegistroPessoalCovid19 registroAtual = service.findByIdRegistro(registro.id);
        
        if((existeRegistro = registroAtual != null)){
            service.putRegistro(registro);
        }
        
        return existeRegistro ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build() ;
    }
    
    @DELETE
    @Path("/registro/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response deleteRegistro(RegistroPessoalCovid19 registro){
        //--- TODO: validar por null
        
        boolean removido = service.deleteRegistro(registro);
        return removido ? Response.ok().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
    
    /**
     * URL de HEALTH CHECK
     * @return
     */
    @GET
    @Path("/ping")
    public Response ping(){
        return Response.ok("pong").build();
    }
    
}
