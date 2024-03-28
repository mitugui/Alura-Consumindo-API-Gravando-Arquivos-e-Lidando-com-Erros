package br.com.alura.assignments.lidando_com_excecoes.ex2valid_password;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma senha:");
        String password = sc.nextLine();
        sc.close();
        
        try {
            validatePassword(password);
        } catch (InvalidPasswordException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void validatePassword (String password) {
        if (password.length() < 8) {
            throw new InvalidPasswordException("A senha deve ter mais de 8 caracteres!");
        }
    }
}
