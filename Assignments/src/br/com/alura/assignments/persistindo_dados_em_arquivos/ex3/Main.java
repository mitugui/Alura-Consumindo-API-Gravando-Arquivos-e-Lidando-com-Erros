package br.com.alura.assignments.persistindo_dados_em_arquivos.ex3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Title myTitle = new Title("Past Lives", 2023, "Celine Song");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(myTitle);
        System.out.println(json);
    }
}