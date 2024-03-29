package br.com.alura.assignments.persistindo_dados_em_arquivos.ex4;

public class Vehicle {
    private String brand;
    private String model;
    private int manufactureYear;
    private double price;
    
    public Vehicle(String brand, String model, int manufactureYear, double price) {
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getManufactureYear() {
        return manufactureYear;
    }
    
    public double getPrice() {
        return price;
    }
}
