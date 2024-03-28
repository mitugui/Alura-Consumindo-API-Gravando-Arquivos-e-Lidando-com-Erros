package br.com.alura.assignments.utilizando_uma_biblioteca_externa.ex1person;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        String jsonPerson = """
                {
                    "name":"João",
                    "age":"20",
                    "city":"São Paulo"
                }
                """;

        Gson gson = new Gson();
        Person person = gson.fromJson(jsonPerson, Person.class);

        System.out.println("Objeto pessoa: " + person);
    }
}