package br.com.alura.assignments.persistindo_dados_em_arquivos.ex2;

public class Title {
    private String name;
    private int releaseDate;
    private String director;

    public Title(String name, int releaseDate, String director) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public String getDirector() {
        return director;
    }
}