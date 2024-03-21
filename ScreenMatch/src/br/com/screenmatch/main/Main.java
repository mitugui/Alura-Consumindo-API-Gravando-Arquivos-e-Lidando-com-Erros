package br.com.screenmatch.main;
import java.util.ArrayList;

import br.com.screenmatch.calculation.RecommendationFilter;
import br.com.screenmatch.calculation.TimeCalculator;
import br.com.screenmatch.models.Episode;
import br.com.screenmatch.models.Film;
import br.com.screenmatch.models.Serie;

public class Main {
    public static void main(String[] args) {
        Film favoriteMovie = new Film("The Matrix", 1999);
        Film otherMovie = new Film("John Wick", 2014);
        Serie favoriteSerie = new Serie("The Office", 2005);

        favoriteMovie.setDurationInMinutes(135);
        favoriteMovie.setIncludedInPlan(true);

        otherMovie.setDurationInMinutes(101);
        otherMovie.setIncludedInPlan(true);

        favoriteSerie.setIncludedInPlan(true);
        favoriteSerie.setActive(false);
        favoriteSerie.setSeasons(9);
        favoriteSerie.setEpisodesPerSeason(22);
        favoriteSerie.setMinutesPerEpisode(40);

        // Atribuindo nota
        // favoriteMovie.displayTechnicalSheet();
        // favoriteMovie.setRating(9.4);
        // favoriteMovie.setRating(10);
        // favoriteMovie.setRating(8.8);

        // Media
        // System.out.printf("A média ficou: %.1f", favoriteMovie.getAverage());

        TimeCalculator calculator = new TimeCalculator();
        calculator.include(favoriteMovie);
        calculator.include(otherMovie);
        calculator.include(favoriteSerie);
        System.out.println("Tempo total para maratonar: " + calculator.getTotalTime());

        Episode pilot = new Episode();
        pilot.setNumber(1);
        pilot.setSerie(favoriteSerie);
        pilot.setTotalViews(300);

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(favoriteMovie);
        filter.filter(otherMovie);
        filter.filter(pilot);

        var mituguiMovie = new Film("Past Lives", 2023);
        mituguiMovie.setDirector("Celine Song");
        mituguiMovie.setDurationInMinutes(106);
        mituguiMovie.setRating(10);

        ArrayList<Film> filmList = new ArrayList<>();
        filmList.add(favoriteMovie);
        filmList.add(otherMovie);
        filmList.add(mituguiMovie);
        System.out.println("Tamanho da lista: " + filmList.size());
        System.out.println("Primeiro filme: " + filmList.get(0).getName());
        System.out.println(filmList);
    }
}