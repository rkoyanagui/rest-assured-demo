package com.rkoyanagui.rest_assured_demo.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.rkoyanagui.rest_assured_demo.steps.model.UsuarioModel;
import com.rkoyanagui.rest_assured_demo.utils.Headers;
import com.rkoyanagui.rest_assured_demo.utils.Keys;
import com.rkoyanagui.rest_assured_demo.utils.World;
import io.cucumber.java.pt.E;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class UsuarioSteps
{
  static final String USER_ENDPOINT = "/user";

  @Autowired
  World world;

  @Value("${rest-assured.base-uri}")
  String baseUri;

  @E("não consigo cadastrar um usuário sem primeiro nome")
  public void cadastrarUsuarioSemPrimeiroNome()
  {
    Response response = RestAssured.given().baseUri(baseUri)
        .and().header(Headers.CONTENT_TYPE, Headers.JSON)
        .and().body(UsuarioModel.builder()
            .lastName("dos Santos")
            .build()
        ).when().post(USER_ENDPOINT);

    world.put(Keys.RESPONSE, response);

    response.then()
        .statusCode(400)
        .and().body("firstName", is(equalTo("'firstName' is mandatory")));
  }

  @E("não consigo cadastrar um usuário sem sobrenome")
  public void cadastrarUsuarioSemSobrenome()
  {
    Response response = RestAssured.given().baseUri(baseUri)
        .and().header(Headers.CONTENT_TYPE, Headers.JSON)
        .and().body(UsuarioModel.builder()
            .firstName("José")
            .build()
        ).when().post(USER_ENDPOINT);

    world.put(Keys.RESPONSE, response);

    response.then()
        .statusCode(400)
        .and().body("lastName", is(equalTo("'lastName' is mandatory")));
  }

  @E("não consigo cadastrar um usuário vazio")
  public void cadastrarUsuarioVazio()
  {
    Response response = RestAssured.given().baseUri(baseUri)
        .and().header(Headers.CONTENT_TYPE, Headers.JSON)
        .and().body(UsuarioModel.builder().build())
        .when().post(USER_ENDPOINT);

    world.put(Keys.RESPONSE, response);

    response.then()
        .statusCode(400)
        .and().body("firstName", is(equalTo("'firstName' is mandatory")))
        .and().body("lastName", is(equalTo("'lastName' is mandatory")));
  }
}
