package br.com.alura.assignments.lidando_com_excecoes.ex1division;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número:");
        int numerator = sc.nextInt();
        
        System.out.println("Digite um número:");
        int denominator = sc.nextInt();
        sc.close();

        try {
            int result = numerator / denominator;
            System.out.println("Resultado da divisão: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Erro: divisão por 0 não permitida");
        }
    }
}