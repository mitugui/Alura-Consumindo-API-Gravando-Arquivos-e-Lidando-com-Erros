package br.com.screenmatch.utilities;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import br.com.screenmatch.exceptions.YearConversionException;
import br.com.screenmatch.models.Title;

public class SearchTitleMenu {
    private Scanner sc = new Scanner(System.in);

    public void searchTitle(String search, Gson gson, List<Title> titles) throws UnsupportedEncodingException {
        while (true) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Digite um filme para buscar ou \"sair\" para encerrar o programa:");
            search = sc.nextLine();

            if (search.equalsIgnoreCase("sair"))
                break;

            String address = "http://www.omdbapi.com/?t=" + URLEncoder.encode(search, "UTF-8")
                    + "&apikey=47804e78";

            try {
                QueryTitle query = new QueryTitle();
                titles.add(query.queryTitle(address, gson));
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Aconteceu um erro:");
                System.out.println("[" + e.getMessage() + "]");
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca:");
                System.out.println("[" + e.getMessage() + "]");
            } catch (YearConversionException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        }
        sc.close();
    }
}