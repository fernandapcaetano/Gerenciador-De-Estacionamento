package View;

import java.util.Scanner;

import Models.Estacionamento;

public class InterfacePrincipal {

    Estacionamento estacionamento = new Estacionamento();
    Scanner scan = new Scanner(System.in);

        public void bemVindo(){

            System.out.println("!!BEM VINDO AO ESTACIONAMENTO!!");

            System.out.println("Digite o preço inicial: ");
            double precoInicial = scan.nextDouble();
            estacionamento.setPrecoInicial(precoInicial);
            
            System.out.println("Digite o preço por hora: ");
            double precoPorHora = scan.nextDouble();
            estacionamento.setPrecoPorHora(precoPorHora);
            menu();
        }

        public void menu(){

            System.out.flush();

            String opcao = "";
            boolean exibirMenu = true;

                
                while (exibirMenu) {
                
                   System.out.println("DIGITE A OPCAO");
                System.out.println("1 - Cadastrar veículo");
                System.out.println("2 - Remover veículo");
                System.out.println("3 - Listar Veículos");
                System.out.println("4 - Encerrar");

                opcao = scan.next();

                switch (opcao) {
                    case "1":
                        addVeiculo();
                        break;
                    case "2":
                        rmVeiculo();
                        break;
                    case "3":
                        listVeiculos();
                        break;
                    case "4":
                        exibirMenu = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                } 


                }
                
        }
    
        public void addVeiculo(){
            String placa = "";
            System.out.println("Digite a placa do veículo: ");
            placa = scan.next();
            
            if (estacionamento.AdicionarVeiculos(placa)) {
                System.out.println("Veículo adicionado com sucesso.");
            } else {
                System.out.println("Falha ao adicionar veículo.");
            }
            
        }

        public void rmVeiculo(){
            String placa = "";
            double hora;
            System.out.println("Digite a placa do veículo para remover: ");
            placa = scan.next();
            placa = placa.toUpperCase();
            
            if (estacionamento.removerVeiculo(placa)) {
                System.out.println("Veículo removido com sucesso.");
                System.out.println("Quantas horas o veículo ficou no estacionamento: ");
                hora = scan.nextDouble();
                Double valorTotal = estacionamento.getPrecoInicial() + (estacionamento.getPrecoPorHora() * hora);
                
                System.out.println("O veículo" + placa + " foi removido e o preço total foi de: R$" + valorTotal);
            } else {
                System.out.println("Falha ao remover o veículo.");
            }
        }

        public void listVeiculos(){
            estacionamento.listarVeiculo();
        }
        
}
