package br.com.screenmatch.utilities;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import br.com.screenmatch.models.Title;
import br.com.screenmatch.records.TitleOmdb;

public class QueryTitle {
    public Title queryTitle(String address, Gson gson) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(address))
                .build();
        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, BodyHandlers.ofString());

        System.out.println(response.body());

        TitleOmdb myTitleOmdb = gson.fromJson(response.body(), TitleOmdb.class);
        Title myTitle = new Title(myTitleOmdb);
        System.out.println("Titulo convertido: " + myTitle);

        return myTitle;
    }
}