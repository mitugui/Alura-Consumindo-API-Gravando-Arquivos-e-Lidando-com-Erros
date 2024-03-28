package br.com.alura.assignments.requisicoes_e_respostas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class CryptoQuoteQuery {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da criptomoeda:");
        var cryptoName = sc.nextLine();
        sc.close();

        var address = "https://api.coingecko.com/api/v3/simple/price?ids=" + cryptoName + "&vs_currencies=usd";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());

        System.out.println(response.body());
    }
}