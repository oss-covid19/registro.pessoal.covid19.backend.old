package covid19.core.api.resource;

import covid19.core.api.service.PesquisaCovid19Service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * API Pesquisa Covid-19
 */
@Path("/pesquisa-covid19")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class PesquisaCovid19Resource {
    @Inject
    PesquisaCovid19Service service;
    
    
}
