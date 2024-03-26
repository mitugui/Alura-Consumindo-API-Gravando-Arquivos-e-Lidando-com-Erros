package br.com.assignments.utilizandoumabibliotecaexterna.ex3books;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        String jsonBook = """
                {
                    "title" : "Código Limpo",
                    "author" : "Robert C. Martin",
                    "publisher" : {
                        "name" : "Alta Books",
                        "city" : "Rio de Janeiro"
                    }
                }
                """;

        Gson gson = new Gson();
        Book myBook = gson.fromJson(jsonBook, Book.class);

        System.out.println("Objeto Livro: " + myBook);
    }
}