package br.com.alura.assignments.persistindo_dados_em_arquivos.ex4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Vehicle myVehicle = new Vehicle("Toyota", "Corolla", 2020, 132000);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(myVehicle);
        System.out.println(json);
    }
}