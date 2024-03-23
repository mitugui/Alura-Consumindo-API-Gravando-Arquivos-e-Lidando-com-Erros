package br.com.screenmatch.models;

import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title>{
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int releaseYear;
    private boolean includedInPlan;
    @SerializedName("Runtime")
    private int durationInMinutes;
    private double ratingSum;
    private int totalRatings;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
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
        return name + " (" + releaseYear + ")";
    }
}