package br.com.screenmatch.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import br.com.screenmatch.models.Title;

public class FileGenerator {
    public void recordJson(List<Title> titles, Gson gson) throws IOException {
        FileWriter writer = new FileWriter("filmes.json");
        writer.write(gson.toJson(titles));
        writer.close();
    }
}