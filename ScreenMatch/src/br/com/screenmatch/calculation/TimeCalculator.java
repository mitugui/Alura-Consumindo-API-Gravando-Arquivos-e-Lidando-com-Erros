package br.com.screenmatch.calculation;

// import br.com.screenmatch.models.Film;
// import br.com.screenmatch.models.Serie;
import br.com.screenmatch.models.Tittle;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    // public void include(Film film) {
    //     totalTime += film.getDurationInMinutes();
    // }

    // public void include(Serie serie) {
    //     totalTime += serie.getDurationInMinutes();
    // }

    public void include (Tittle titulo) {
        this.totalTime += titulo.getDurationInMinutes();
    }
}