package br.com.alura.assignments.lidando_com_excecoes.ex3exception_for_github_api;

public class GithubQueryException extends RuntimeException {
    GithubQueryException(String message) {
        super(message);
    }
}