package br.com.alura.assignments.lidando_com_excecoes.ex2valid_password;

public class InvalidPasswordException extends RuntimeException {
    InvalidPasswordException(String message) {
        super(message);
    }
}