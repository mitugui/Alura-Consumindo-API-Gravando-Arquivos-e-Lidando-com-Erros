package br.com.screenmatch.main;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.screenmatch.exceptions.YearConversionException;
import br.com.screenmatch.models.Title;
import br.com.screenmatch.records.TitleOmdb;
import br.com.screenmatch.utilities.FileGenerator;

public class MainWithSearch {
        public static void main(String[] args) throws IOException, InterruptedException {
                Scanner sc = new Scanner(System.in);
                String search = "";
                List<Title> titles = new ArrayList<>();

                Gson gson = new GsonBuilder()
                                .setPrettyPrinting()
                                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                                .create();

                while (!search.equalsIgnoreCase("sair")) {

                        System.out.println("Digite um filme para buscar:");
                        search = sc.nextLine();

                        if (search.equalsIgnoreCase("sair")) {
                                break;
                        }

                        String address = "http://www.omdbapi.com/?t=" + URLEncoder.encode(search, "UTF-8")
                                        + "&apikey=47804e78";

                        try {
                                HttpClient client = HttpClient.newHttpClient();
                                HttpRequest request = HttpRequest.newBuilder()
                                                .uri(URI.create(address))
                                                .build();
                                HttpResponse<String> response = client
                                                .send(request, BodyHandlers.ofString());

                                String json = response.body();
                                // System.out.println(json);

                                TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);

                                Title myTitle = new Title(myTitleOmdb);
                                System.out.println("Titulo convertido: " + myTitle);

                                titles.add(myTitle);
                        } catch (NumberFormatException e) {
                                System.out.println("Aconteceu um erro: " + e.getMessage());
                        } catch (IllegalArgumentException e) {
                                System.out.println("Algum erro de argumento na busca: ");
                        } catch (YearConversionException e) {
                                System.out.println(e.getMessage());
                        } catch (NullPointerException e) {
                                System.out.println("Aconteceu um erro: " + e.getMessage());
                        } catch (Exception e) {
                                System.out.println(e.getClass());
                        }
                }
                sc.close();

                FileGenerator myFileGenerator = new FileGenerator();
                myFileGenerator.recordJson(titles);

                System.out.println("O programa finalizou corretamente!");
        }
}