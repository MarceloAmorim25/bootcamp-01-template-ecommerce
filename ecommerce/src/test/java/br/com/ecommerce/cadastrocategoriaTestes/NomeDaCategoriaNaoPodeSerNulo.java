package br.com.ecommerce.cadastrocategoriaTestes;

import br.com.ecommerce.cadastrocategoria.Categoria;
import br.com.ecommerce.cadastrousuario.SenhaLimpa;
import br.com.ecommerce.cadastrousuario.Usuario;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class NomeDaCategoriaNaoPodeSerNulo {


    @LocalServerPort
    private int port;


    @Value("${ecommerce.jwt.testes}")
    private String token;


    @Test
    public void deveRetornarBadRequestQuandoCategoriaEhAdicionadaSemNome() throws JSONException {


        JSONObject categoria = new JSONObject()
                .put("nome","  ")
                .put("categoriaId",1);


        given()
                .basePath("/categorias")
                .port(port)
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .body(categoria.toString())
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());


    }
}