package br.com.assignments.requisicoeserepostas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class TheMealDBRecipeQuery {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a sua receita:");
        var recipeName = sc.nextLine();
        sc.close();

        var address = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + recipeName;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
