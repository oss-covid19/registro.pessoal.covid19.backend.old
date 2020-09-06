package covid19.core.api.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import covid19.core.api.dominio.RegistroPessoalCovid19;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class RegistroPessoalCovid19ResourceTest {
    private final Gson gson = new GsonBuilder().serializeNulls().create();

    //-------------------------------------------------------------------------
    
    @Test
    public void deveCriarRegistroComPost(){
        String registroJson = gson.toJson(createRegistro(null));
        
        given()
            .body(registroJson)
            .contentType("application/json")
        .when().post("/registro-pessoal-covid19/registro")
        .then()
            .statusCode(CREATED.getStatusCode());
    }
    
    @Test
    public void dadoIDdeveRecuperarRegistroViaGet(){
        //--- este ID é carregado no import.sql
        String rID = "99fa309b-e362-440c-8812-af9df067dad3";
        
        given()
            .when().get("/registro-pessoal-covid19/registro/"+rID)
            .then()
                .statusCode(OK.getStatusCode());
    }
    
    //-------------------------------------------------------------------------

    @Test
    public void testDeveRetornaPong(){
        given()
            .when().get("/registro-pessoal-covid19/ping")
            .then()
                .statusCode(200)
                .body(is("pong"));
    }
    
    //-------------------------------------------------------------------------
    
    private RegistroPessoalCovid19 createRegistro(String id){
        RegistroPessoalCovid19 registro = new RegistroPessoalCovid19();
        registro.id = id;
        registro.naoPegueiCovid19 = true;
        return registro;
    }
}
