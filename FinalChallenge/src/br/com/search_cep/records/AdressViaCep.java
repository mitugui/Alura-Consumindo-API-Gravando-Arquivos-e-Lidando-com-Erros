package br.com.search_cep.records;

public record AdressViaCep(String cep, String logradouro, String complemento,
                    String bairro, String localidade, String uf) {}