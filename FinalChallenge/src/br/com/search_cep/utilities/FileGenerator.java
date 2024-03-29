package br.com.search_cep.utilities;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.GsonBuilder;

import br.com.search_cep.records.AdressViaCep;

public class FileGenerator {
    public void recordJson(AdressViaCep objectAdress) throws IOException {
        String jsonAdress = new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(objectAdress);

        FileWriter writer = new FileWriter(objectAdress.cep() + ".json");
        writer.write(jsonAdress);
        writer.close();
    }
}