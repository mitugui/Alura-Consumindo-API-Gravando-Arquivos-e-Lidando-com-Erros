package br.com.search_cep.utilities;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import br.com.search_cep.records.AdressViaCep;

public class QueryCep {
    public AdressViaCep searchAdress(String cep) {
        URI address = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest
                .newBuilder(address)
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), AdressViaCep.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse cep");
        }
    }
}