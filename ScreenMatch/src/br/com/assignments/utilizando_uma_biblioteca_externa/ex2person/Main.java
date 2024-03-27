package br.com.assignments.utilizando_uma_biblioteca_externa.ex2person;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        String jsonPerson = """
                {
                    "name":"João",
                    "age":"20",
                    "gender":"male"
                }
                """;

        Gson gson = new GsonBuilder().setLenient().create();
        Person person = gson.fromJson(jsonPerson, Person.class);

        System.out.println("Objeto pessoa: " + person);
    }
}