package br.com.screenmatch.models;

import br.com.screenmatch.exceptions.YearConversionException;
import br.com.screenmatch.records.TitleOmdb;

public class Title implements Comparable<Title>{
    private String name;
    private int releaseYear;
    private boolean includedInPlan;
    private int durationInMinutes;
    private double ratingSum;
    private int totalRatings;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(TitleOmdb titleOmdb) {
        this.name = titleOmdb.title();

        if (titleOmdb.year().length() > 4) {
            throw new YearConversionException("Não foi possível converter o ano por possuir mais de 4 caracteres");
        }
        this.releaseYear = Integer.valueOf(titleOmdb.year().replaceAll("[^0-9]", ""));
        this.durationInMinutes = Integer.valueOf(titleOmdb.runtime().replaceAll("[^0-9]", ""));
    }

    public void displayTechnicalSheet () {
        System.out.println("Nome do filme: " + name);
        System.out.println("Ano de lançamento: " + releaseYear);
    }

    public void setRating(double rating) {
        this.ratingSum += rating;
        totalRatings++;
    }

    public double getAverage() {
        return ratingSum / totalRatings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean getIncludedInPlan() {
        return includedInPlan;
    }
    
    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getTotalRatings() {
        return totalRatings;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "(Nome: " + name + " (" + releaseYear + ")" + ", Duração: " + durationInMinutes + " min)";
    }
}
