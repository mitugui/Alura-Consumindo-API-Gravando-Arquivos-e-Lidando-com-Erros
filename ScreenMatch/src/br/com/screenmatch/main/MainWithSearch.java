package br.com.screenmatch.main;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.screenmatch.exceptions.YearConversionException;
import br.com.screenmatch.models.Title;
import br.com.screenmatch.utilities.FileGenerator;
import br.com.screenmatch.utilities.QueryTitle;

public class MainWithSearch {
        public static void main(String[] args) throws IOException, InterruptedException {
                Scanner sc = new Scanner(System.in);
                String search = "";
                List<Title> titles = new ArrayList<>();

                Gson gson = new GsonBuilder()
                                .setPrettyPrinting()
                                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                                .create();

                while (!search.equalsIgnoreCase("sair")) {

                        System.out.println("---------------------------------------------------------------");
                        System.out.println("Digite um filme para buscar ou \"sair\" para encerrar o programa:");
                        search = sc.nextLine();

                        if (search.equalsIgnoreCase("sair")) break;

                        String address = "http://www.omdbapi.com/?t=" + URLEncoder.encode(search, "UTF-8")
                                        + "&apikey=47804e78";

                        try {
                                QueryTitle query = new QueryTitle();
                                titles.add(query.queryTitle(address, gson));
                        } catch (NumberFormatException e) {
                                System.out.println("Aconteceu um erro: " + e.getMessage());
                        } catch (IllegalArgumentException e) {
                                System.out.println("Algum erro de argumento na busca: ");
                        } catch (YearConversionException e) {
                                System.out.println(e.getMessage());
                        } catch (NullPointerException e) {
                                System.out.println("Aconteceu um erro: " + e.getMessage());
                        } catch (Exception e) {
                                System.out.println(e.getClass());
                        }
                }
                sc.close();

                FileGenerator myFileGenerator = new FileGenerator();
                myFileGenerator.recordJson(titles, gson);

                System.out.println("---------------------------------------------------------------");
                System.out.println("O programa finalizou corretamente!");
        }
}