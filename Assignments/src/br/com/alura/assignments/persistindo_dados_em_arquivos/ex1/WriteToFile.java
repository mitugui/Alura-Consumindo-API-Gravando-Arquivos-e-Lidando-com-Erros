package br.com.alura.assignments.persistindo_dados_em_arquivos.ex1;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        String data = "Conteúdo a ser gravado no arquivo.";

        try {
            FileWriter writer = new FileWriter("file.txt");
            writer.write(data);
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}