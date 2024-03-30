package br.com.screenmatch.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.screenmatch.models.Title;
import br.com.screenmatch.utilities.FileGenerator;
import br.com.screenmatch.utilities.SearchTitleMenu;

public class MainWithSearch {
        public static void main(String[] args) throws IOException, InterruptedException {
                String title = "";
                List<Title> titles = new ArrayList<>();

                Gson gson = new GsonBuilder()
                                .setPrettyPrinting()
                                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                                .create();

                SearchTitleMenu searchMenu = new SearchTitleMenu();
                searchMenu.searchTitle(title, gson, titles);

                FileGenerator myFileGenerator = new FileGenerator();
                myFileGenerator.recordJson(titles, gson);

                System.out.println("---------------------------------------------------------------");
                System.out.println("O programa finalizou corretamente!");
        }
}
