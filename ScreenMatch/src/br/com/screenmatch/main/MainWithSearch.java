package br.com.screenmatch.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.screenmatch.models.Title;
import br.com.screenmatch.models.TitleOmdb;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um filme para buscar:");
        var search = sc.nextLine();
        sc.close();

        String address = "http://www.omdbapi.com/?t=" + search + "&apikey=47804e78";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
        
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);

        try {
                Title myTitle = new Title(myTitleOmdb);
                System.out.println("Titulo convertido: " + myTitle);          
        } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: " + e.getMessage());
        }
        System.out.println("O programa finalizou corretamente!");
    }
}