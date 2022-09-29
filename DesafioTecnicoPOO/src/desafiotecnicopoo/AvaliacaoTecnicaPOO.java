package desafiotecnicopoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AvaliacaoTecnicaPOO {

    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(TipoDeProduto.BEBIDAS, 5.20, 100));
        produtos.add(new Produto(TipoDeProduto.PETISCOS, 25.15, 200));
        produtos.add(new Produto(TipoDeProduto.CARNES, 45.65, 300));
        produtos.add(new Produto(TipoDeProduto.AVES, 35, 400));
        produtos.add(new Produto(TipoDeProduto.MASSAS, 25, 500));
        produtos.add(new Produto(TipoDeProduto.SOBREMESAS, 15, 600));

        List<Garcom> garcons = new ArrayList<>();
        garcons.add(new Garcom("joao", "Rua tal", "12345678", 123456, 1));
        garcons.add(new Garcom("maria", "Rua tal", "12345678", 123456, 2));
        garcons.add(new Garcom("jose", "Rua tal", "12345678", 123456, 3));

        List<Gerente> gerentes = new ArrayList<>();
        gerentes.add(new Gerente("joao", "rua tal", "98564", 123456789));


        List<Conta> contas = new ArrayList<>();
        contas.add(new Conta(03, 01, LocalDate.of(2022, 9, 19),
                LocalTime.of(12, 00), new ArrayList(), 15));
        contas.add(new Conta(01, 01, LocalDate.of(2022, 9, 20),
                LocalTime.of(13, 55), new ArrayList(), 5.20));
        contas.add(new Conta(02, 01, LocalDate.of(2022, 9, 21),
                LocalTime.of(13, 15), new ArrayList(), 45.65));
        contas.add(new Conta(01, 01, LocalDate.of(2022, 9, 22),
                LocalTime.of(14, 05), new ArrayList(), 25.15));
//        quando começa em um mês e termina do outro
        contas.add(new Conta(03, 01, LocalDate.of(2022, 9, 29),
                LocalTime.of(12, 00), new ArrayList(), 15));
        contas.add(new Conta(01, 01, LocalDate.of(2022, 9, 30),
                LocalTime.of(13, 55), new ArrayList(), 5.20));
        contas.add(new Conta(02, 01, LocalDate.of(2022, 10, 1),
                LocalTime.of(13, 15), new ArrayList(), 45.65));
        contas.add(new Conta(01, 01, LocalDate.of(2022, 10, 2),
                LocalTime.of(14, 05), new ArrayList(), 25.15));


        Caixa caixa = new Caixa();

        Proprietario proprietario = new Proprietario();

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
                    System.out.println(" ..... Cadastrar Garçom ..... ");
                    System.out.println("Digite o nome do garçom: ");
                    String nome = scan.nextLine();
                    System.out.println("Digite o endereco: ");
                    String endereco = scan.nextLine();
                    System.out.println("Digite o telefone: ");
                    String telefone = scan.nextLine();
                    System.out.println("Digite a identidade: ");
                    int identidade = scan.nextInt();
                    System.out.println("Digite a matricula: ");
                    int matricula = scan.nextInt();

                    gerente.cadastrarGarcom(garcons, nome, endereco, telefone, identidade, matricula);
                    break;

                case 2:
                    System.out.println(" ..... Calcular Comissão ..... ");

                    double percentualComissao;
                    double valorVendidoNaSemana = 0;

                    System.out.println("Digite o dia de início da semana");
                    int diaInicio = scan.nextInt();
                    System.out.println("Digite o mês de início da semana");
                    int mesInicio = scan.nextInt();
                    System.out.println("Digite o dia de final da semana");
                    int diaFinal = scan.nextInt();
                    System.out.println("Digite o mês de final da semana");
                    int mesFinal = scan.nextInt();

                    System.out.println("Digite o valor do percentual da comissão dessa semana.");
                    percentualComissao = scan.nextDouble();
                    System.out.println("Digite a matricula do garcom");
                    matricula = scan.nextInt();

                    gerente.calcularComissao(contas, percentualComissao, valorVendidoNaSemana, diaInicio, mesInicio,
                            diaFinal, mesFinal, matricula);
                    break;

                case 3:
                    System.out.println(" ..... Calcular Ocupação das Mesas ..... ");

                    double ocupacaoDaMesa = 0;

                    System.out.println("Digite o número da mesa");
                    int numeroDaMesa = scan.nextInt();
                    System.out.println("Digite o dia de início da semana");
                    diaInicio = scan.nextInt();
                    System.out.println("Digite o mês de início da semana");
                    mesInicio = scan.nextInt();
                    System.out.println("Digite o dia de final da semana");
                    diaFinal = scan.nextInt();
                    System.out.println("Digite o mês de final da semana");
                    mesFinal = scan.nextInt();
                    System.out.println("Digite a hora de início");
                    int horaInicio = scan.nextInt();
                    System.out.println("Digite a hora de fim");
                    int horaFim = scan.nextInt();

                    gerente.calcularOcupacoMesas(contas, ocupacaoDaMesa, numeroDaMesa, diaInicio, mesInicio,
                            diaFinal, mesFinal, horaInicio, horaFim);
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

//                case 0:
//                    System.out.println("Saindo.........");
//                    break;
//
//                case 1:
//                    System.out.println(" ..... Cadastrar Garçom ..... ");
////                    gerente.cadastrarGarcom(garcons);
//                    break;
//
//                case 2:
//                    System.out.println(" ..... Calcular Comissão ..... ");
//                    gerente.calcularComissao(contas);
//                    break;
//
//                case 3:
//                    System.out.println(" ..... Calcular Ocupação das Mesas ..... ");
//                    gerente.calcularOcupacoMesas(contas);
//                    break;
//
//                case 4:
//                    System.out.println(" ..... Lista Garçons ..... ");
//                    gerente.imprimeDadosGarcom(garcons);
//                    break;
//
//                case 5:
//                    System.out.println(" ..... Cadastrar Gerente ..... ");
//                    proprietario.cadastrarGerente(gerentes);
//                    break;
//
//                case 6:
//                    System.out.println(" ..... Lista Gerente ..... ");
//                    proprietario.imprimeDadosGerente(gerentes);
//                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

}
