package br.com.screenmatch.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.screenmatch.models.Film;
import br.com.screenmatch.models.Serie;
import br.com.screenmatch.models.Tittle;

public class MainWithLists {
    public static void main(String[] args) {
        Film favoriteMovie = new Film("The Matrix", 1999);
        Film otherMovie = new Film("John Wick", 2014);
        Film mituguiMovie = new Film("Past Lives", 2023);
        Serie favoriteSerie = new Serie("The Office", 2005);
        
        ArrayList<Tittle> watchedList = new ArrayList<>();
        watchedList.add(favoriteMovie);
        favoriteMovie.setRating(9);
        watchedList.add(otherMovie);
        otherMovie.setRating(6);
        watchedList.add(mituguiMovie);
        mituguiMovie.setRating(8);
        watchedList.add(favoriteSerie);

        for (Tittle item:watchedList) {
            System.out.print(item.getName());
            if (item instanceof Film film) {
                System.out.println(" - " + film.getClassification());     
            }
        }

        // Outra opção de foreach (lambda):
        // watchedList.forEach(item -> {
        //     System.out.println(item.getName());
        //     Film film = (Film) item;
        //     System.out.println(" - " + film.getClassification());
        // });

        // Outra opção de for-each (Method Reference):
        // watchedList.forEach(System.out::println);

        List<String> searchForArtist = new ArrayList<>(); // List é uma interface implementada por ArrayList e outras 
        searchForArtist.add("Ryan Gosling");
        searchForArtist.add("Emma Stone");
        searchForArtist.add("Cillian Murphy");

        System.out.println("\n" +searchForArtist);
        Collections.sort(searchForArtist);
        System.out.println(searchForArtist);
        
        Collections.sort(watchedList);
        System.out.println("\nLista de títulos por ordem alfabética:");
        System.out.println(watchedList);
        watchedList.sort(Comparator.comparing(Tittle::getReleaseYear));
        System.out.println("\nLista de títulos por ordem de lançamento:");
        System.out.println(watchedList);
    }
}