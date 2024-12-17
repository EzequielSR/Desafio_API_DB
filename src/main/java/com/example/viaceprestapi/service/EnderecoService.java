package com.example.viaceprestapi.service;

import com.example.viaceprestapi.dto.EnderecoDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Optional;

public class EnderecoService {
    public Optional<EnderecoDTO> getCepAsDTO(String cep){
        return Optional.ofNullable(getCepResponse(cep)).filter(this::isSucessfulResponse)
                .map(response -> response.as(EnderecoDTO.class))
                .filter(dto -> dto.getCep() != null);
    }

    public Response getCepResponse(String cep) {

        return RestAssured.given().baseUri("https://viacep.com.br")
                .basePath("/ws/{cep}/json/").pathParam("cep", cep)
                .when().get().then().extract().response();
    }

    private boolean isSucessfulResponse(Response response){
        return response.statusCode() == 200;
    }
}
