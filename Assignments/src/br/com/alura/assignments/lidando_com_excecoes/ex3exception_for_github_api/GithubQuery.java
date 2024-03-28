package br.com.alura.assignments.lidando_com_excecoes.ex3exception_for_github_api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class GithubQuery {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome de usuário:");
        String search = sc.nextLine();
        sc.close();

        String address = "https://api.github.com/search/users?q=" + search;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client.
                    send(request, BodyHandlers.ofString());
    
            if (response.statusCode() == 404) {
                throw new GithubQueryException("Usuário não encontrado");
            }

            String json = response.body();
            System.out.println(json);
        } catch (GithubQueryException e) {
            System.out.println(e.getMessage());
        }
    }
}