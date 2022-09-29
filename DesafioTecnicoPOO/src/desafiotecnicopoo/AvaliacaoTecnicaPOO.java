package desafiotecnicopoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AvaliacaoTecnicaPOO {

    public static void main(String[] args) {



        menuFuncao(garcons, contas, produtos, caixa, gerentes, proprietario);
    }

    public static void menuFuncao(List<Garcom> garcons, List<Conta> contas, List<Produto> produtos,
                                  Caixa caixa, List<Gerente> gerentes, Proprietario proprietario) {
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
                    menuGerente(gerentes, garcons, contas);
                    break;

                case 4:
                    menuProprietario(proprietario, gerentes, garcons, contas);
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
        System.out.println("Matrícula não cadastrada. Favor digitar sua matrícula corretamente.");

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

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuGerente(List<Gerente> gerentes, List<Garcom> garcons, List<Conta> contas) {
        int opcao = 1;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o CPF: ");
        int cpf = scan.nextInt();

        Gerente gerente = new Gerente();

        for (int i = 0; i < gerentes.size(); i++) {
            if (gerentes.get(i).getCpf() == cpf) {
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
//                    System.out.println(" ..... Cadastrar Garçom ..... ");
//                    System.out.println("Digite o nome do garçom: ");
//                    String nome = scan.nextLine();
//                    System.out.println("Digite o endereco: ");
//                    String endereco = scan.nextLine();
//                    System.out.println("Digite o telefone: ");
//                    String telefone = scan.nextLine();
//                    System.out.println("Digite a identidade: ");
//                    int identidade = scan.nextInt();
//                    System.out.println("Digite a matricula: ");
//                    int matricula = scan.nextInt();

                    gerente.cadastrarGarcom(garcons);
                    break;

                case 2:
                    System.out.println(" ..... Calcular Comissão ..... ");
                    gerente.calcularComissao(contas);
                    break;

                case 3:
                    System.out.println(" ..... Calcular Ocupação das Mesas ..... ");
                    gerente.calcularOcupacoMesas(contas);
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

    public static void menuProprietario(Proprietario proprietario, List<Gerente> gerentes, List<Garcom> garcons, List<Conta> contas) {
        int opcao = 1;
        Scanner scan = new Scanner(System.in);

        Gerente gerente = new Gerente();

        while (opcao != 0) {

            System.out.println(" ----- MENU PROPRIETÁRIO ----- ");
            System.out.println("Escolha a opção desejada");
            System.out.println("1. Cadastrar garçom");
            System.out.println("2. Calcular comissão");
            System.out.println("3. Ocupação das mesas");
            System.out.println("4. Imprimir lista de garçons");
            System.out.println("5. Cadastrar gerente");
            System.out.println("6. Imprimir lista de gerentes");
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
                    System.out.println(" ..... Calcular Ocupação das Mesas ..... ");
                    gerente.calcularOcupacoMesas(contas);
                    break;

                case 4:
                    System.out.println(" ..... Lista Garçons ..... ");
                    gerente.imprimeDadosGarcom(garcons);
                    break;

                case 5:
                    System.out.println(" ..... Cadastrar Gerente ..... ");
                    proprietario.cadastrarGerente(gerentes);
                    break;

                case 6:
                    System.out.println(" ..... Lista Gerente ..... ");
                    proprietario.imprimeDadosGerente(gerentes);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

}
