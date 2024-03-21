package br.com.screenmatch.models;

import br.com.screenmatch.calculation.Classifiable;

public class Film extends Tittle implements Classifiable{
    private String director;

    public Film(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) getAverage() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getName() + " (" + this.getReleaseYear() +")";
    }
}