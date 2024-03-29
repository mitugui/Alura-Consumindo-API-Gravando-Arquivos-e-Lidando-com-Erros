package br.com.alura.assignments.persistindo_dados_em_arquivos.ex2;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Title myTitle = new Title("Past Lives", 2023, "Celine Song");

        Gson gson = new Gson();

        String json = gson.toJson(myTitle);
        System.out.println(json);
    }
}