package desafiotecnicopoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AvaliacaoTecnicaPOO {

    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(TipoDeProduto.BEBIDAS, 5.20, 001));
        produtos.add(new Produto(TipoDeProduto.PETISCOS, 25.15, 002));
        produtos.add(new Produto(TipoDeProduto.CARNES, 45.65, 003));
        produtos.add(new Produto(TipoDeProduto.AVES, 35, 004));
        produtos.add(new Produto(TipoDeProduto.MASSAS, 25, 005));
        produtos.add(new Produto(TipoDeProduto.SOBREMESAS, 15, 006));

        List<Garcom> garcons = new ArrayList<>();
        garcons.add(new Garcom("joao", "Rua tal", "12345678", 123456, 01));
        garcons.add(new Garcom("maria", "Rua tal", "12345678", 123456, 02));
        garcons.add(new Garcom("jose", "Rua tal", "12345678", 123456, 02));

        List<Conta> contas = new ArrayList<>();

        Caixa caixa = new Caixa();

        menuFuncao(garcons, contas, produtos, caixa);
    }

    public static void menuFuncao(List<Garcom> garcons, List<Conta> contas, List<Produto> produtos, Caixa caixa) {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("Qual a sua função?");
            System.out.println("1. Garçom");
            System.out.println("2. Caixa");
            System.out.println("3. Gerente");
            System.out.println("4. Proprietário");
            System.out.println("0. Sair");

            Scanner scan = new Scanner(System.in);
            opcao = scan.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo.........");
                    break;

                case 1:
                    menuGarcom(garcons, contas, produtos);
                    break;

                case 2:
                    menuCaixa(caixa, contas);
                    break;

                case 3:
                    menuGerente();
                    break;

                case 4:
                    menuProprietario();
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuGarcom(List<Garcom> garcons, List<Conta> contas, List<Produto> produtos) {
        int opcao = 1;

        System.out.println("Digite a matrícula: ");
        Scanner scan = new Scanner(System.in);
        int matricula = scan.nextInt();

        Garcom garcom = new Garcom();

        for (int i = 0; i < garcons.size(); i++) {
            if (garcons.get(i).getMatricula() == matricula) {
                garcom = garcons.get(i);
            }
        }

        while (opcao != 0) {

            System.out.println(" ----- MENU GARÇOM ----- ");
            System.out.println("Escolha a opção desejada");
            System.out.println("1. Realizar pedido");
            System.out.println("2. Cancelar conta");
            System.out.println("3. Fechar conta");
            System.out.println("0. Logout");
            
            opcao = scan.nextInt();

            switch (opcao) {

                case 0:
                    System.out.println("Saindo.........");
                    break;

                case 1:
                    garcom.realizarPedido(contas, produtos);
                    break;

                case 2:
                    garcom.cancelarConta(contas);
                    break;

                case 3:
                    garcom.fecharConta(contas);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuCaixa(Caixa caixa, List<Conta> contas) {

        int opcao = 1;

        while (opcao != 0) {

            System.out.println(" ----- MENU CAIXA ----- ");
            System.out.println("Escolha a opção desejada");
            System.out.println("1. Abrir conta");
            System.out.println("2. Calcular comissão");
            System.out.println("3. Ocupação das mesas");
            System.out.println("0. Sair");
            
            Scanner scan = new Scanner(System.in);
            opcao = scan.nextInt();

            switch (opcao) {

                case 0:
                    System.out.println("Saindo.........");
                    break;

                case 1:
                    caixa.abrirConta(contas);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuGerente() {

        int opcao = 1;

        while (opcao != 0) {

            System.out.println(" ----- MENU GERENTE ----- ");
            System.out.println("Escolha a opção desejada");
            System.out.println("1. Cadastrar garçom");
            System.out.println("2. Calcular comissão");
            System.out.println("3. Ocupação das mesas");
            System.out.println("0. Sair");

            switch (opcao) {

                case 0:
                    System.out.println("Saindo.........");
                    break;

                case 1:
//                    gerente.cadastrarGarcom(garcons);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuProprietario() {

        int opcao = 1;

        while (opcao != 0) {

            System.out.println(" ----- MENU PROPRIETÁRIO ----- ");
            System.out.println("Escolha a opção desejada");
            System.out.println("1. Cadastrar gerente");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("0. Sair");

            switch (opcao) {

                case 0:
                    System.out.println("Saindo.........");
                    break;

                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

}
