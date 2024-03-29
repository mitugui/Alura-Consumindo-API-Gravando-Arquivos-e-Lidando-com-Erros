package br.com.search_cep.main;

import java.io.IOException;
import java.util.Scanner;

import br.com.search_cep.records.AdressViaCep;
import br.com.search_cep.utilities.FileGenerator;
import br.com.search_cep.utilities.QueryCep;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número de CEP para consulta:");
        var cep = sc.nextLine();
        sc.close();

        QueryCep myQueryCep = new QueryCep();

        try {
            AdressViaCep myAdressViaCep = myQueryCep.searchAdress(cep);
    
            FileGenerator myFileGenerator = new FileGenerator();
            myFileGenerator.recordJson(myAdressViaCep);         
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação.");
        }
    }
}