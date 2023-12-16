package Models;

import java.util.ArrayList;
import java.util.Scanner;

public class Estacionamento {

    private Double precoInicial = 0.0;
    private Double precoPorHora = 0.0;
    private ArrayList<String> veiculos = new ArrayList<String>();

    Scanner scanner = new Scanner(System.in);


    public Estacionamento(){

    }

    public Estacionamento(Double precoInicial, Double precoPorHora, ArrayList<String> veiculos) {
        this.precoInicial = precoInicial;
        this.precoPorHora = precoPorHora;
        this.veiculos = veiculos;
    }


    public Double getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(Double precoInicial) {
        this.precoInicial = precoInicial;
    }

    public Double getPrecoPorHora() {
        return precoPorHora;
    }

    public void setPrecoPorHora(Double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public boolean AdicionarVeiculos(String placa){
        placa = placa.toUpperCase();
        if (!veiculos.contains(placa)) {
            veiculos.add(placa);
            return true;
        }
        return false;
    }

    public boolean removerVeiculo(String placa){
        placa = placa.toUpperCase();
        if (veiculos.contains(placa)) {
            veiculos.remove(placa);
            return true;
        } 
        return false;
    }

    public void listarVeiculo(){
        if (veiculos.isEmpty()) {
            System.out.println("O estacionamento está vazio");
        }
        for (int i = 0; i < veiculos.size(); i++) {
            String veiculo = veiculos.get(i);
            System.out.println((i+1) + " - " + veiculo);
        }
    }



    


}
