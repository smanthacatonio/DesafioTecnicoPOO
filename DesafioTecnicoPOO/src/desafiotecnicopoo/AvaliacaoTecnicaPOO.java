package desafiotecnicopoo;

import java.time.LocalDate;
import java.time.LocalTime;
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
//        garcons.add(new Garcom("maria", "Rua tal", "12345678", 123456, 02));
//        garcons.add(new Garcom("jose", "Rua tal", "12345678", 123456, 02));

        List<Gerente> gerentes = new ArrayList<>();
        gerentes.add(new Gerente("joao", "rua tal", "98564", 123456789));


        List<Conta> contas = new ArrayList<>();
        contas.add(new Conta(03, 01, LocalDate.of(2022, 9,19),
                LocalTime.of(12,00), new ArrayList(), 15));
        contas.add(new Conta(01, 01, LocalDate.of(2022,9,20),
                LocalTime.of(13,55),new ArrayList(), 5.20));
        contas.add(new Conta(02, 01, LocalDate.of(2022, 9, 21),
                LocalTime.of(13, 15),new ArrayList(), 45.65));
        contas.add(new Conta(01, 01, LocalDate.of(2022, 9, 22),
                LocalTime.of(14, 05),new ArrayList(), 25.15));


        Caixa caixa = new Caixa();

        Proprietario proprietario = new Proprietario();

        Comissao comissao = new Comissao();

        menuFuncao(garcons, contas, produtos, caixa, gerentes, proprietario, comissao);
    }

    public static void menuFuncao(List<Garcom> garcons, List<Conta> contas, List<Produto> produtos,
                                  Caixa caixa, List<Gerente> gerentes, Proprietario proprietario, Comissao comissao) {
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
                    menuGerente(gerentes, garcons, comissao, contas);
                    break;

                case 4:
                    menuProprietario(proprietario, gerentes);
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
            } else {
                System.out.println("Matrícula não cadastrada. Favor digitar sua matrícula corretamente.");
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
                    System.out.println(" ..... Realizar Pedido ..... ");
                    garcom.realizarPedido(contas, produtos);
                    break;

                case 2:
                    System.out.println(" ..... Cancelar Conta ..... ");
                    garcom.cancelarConta(contas);
                    break;

                case 3:
                    System.out.println(" ..... Fechar Conta ..... ");
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
                    System.out.println(" ..... Abrir Conta ..... ");
                    caixa.abrirConta(contas);
                    break;

                case 2:
                    System.out.println(" ..... Calcular Comissão ..... ");

                    break;

                case 3:
                    System.out.println(" ..... Ocupação das mesas ..... ");

                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuGerente(List<Gerente> gerentes, List<Garcom> garcons, Comissao comissao, List<Conta> contas) {
        int opcao = 1;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o CPF: ");
        int cpf = scan.nextInt();

        Gerente gerente = new Gerente();

        for (int i = 0; i < gerentes.size(); i++) {
            if (gerentes.get(i).getCpf() == cpf){
                gerente = gerentes.get(i);
            }
        }

        while (opcao != 0) {

            System.out.println(" ----- MENU GERENTE ----- ");
            System.out.println("Escolha a opção desejada");
            System.out.println("1. Cadastrar garçom");
            System.out.println("2. Calcular comissão");
            System.out.println("3. Ocupação das mesas");
            System.out.println("4. Imprimir lista de garçons");
            System.out.println("0. Sair");

            opcao = scan.nextInt();

            switch (opcao) {

                case 0:
                    System.out.println("Saindo.........");
                    break;

                case 1:
                    System.out.println(" ..... Cadastrar Garçom ..... ");
                    gerente.cadastrarGarcom(garcons);
                    break;

                case 2:
                    System.out.println(" ..... Calcular Comissão ..... ");
                    gerente.calcularComissao(contas);
                    break;

                case 3:

                    break;

                case 4:
                    System.out.println(" ..... Lista Garçons ..... ");
                    gerente.imprimeDadosGarcom(garcons);

                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuProprietario(Proprietario proprietario, List<Gerente> gerentes) {
        int opcao = 1;
        Scanner scan = new Scanner(System.in);

        while (opcao != 0) {

            System.out.println(" ----- MENU PROPRIETÁRIO ----- ");
            System.out.println("Escolha a opção desejada");
            System.out.println("1. Cadastrar gerente");
            System.out.println("2. Imprimir lista de gerentes");
            System.out.println("3. Calcular comissão");
            System.out.println("0. Sair");
            opcao = scan.nextInt();

            switch (opcao) {

                case 0:
                    System.out.println("Saindo.........");
                    break;

                case 1:
                    System.out.println(" ..... Cadastrar Gerente ..... ");
                    proprietario.cadastrarGerente(gerentes);
                    break;

                case 2:
                    System.out.println(" ..... Lista Gerentes ..... ");
                    proprietario.imprimeDadosGerente(gerentes);
                    break;

                case 3:

                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

}
