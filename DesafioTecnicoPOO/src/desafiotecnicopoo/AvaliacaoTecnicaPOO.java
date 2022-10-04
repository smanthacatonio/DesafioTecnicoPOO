package desafiotecnicopoo;

import java.util.Scanner;

public class AvaliacaoTecnicaPOO {

    static Restaurante restaurante;

    public static void main(String[] args) {
        restaurante = new Restaurante();

        menuFuncao();

    }

    public static void menuFuncao() {
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
                    menuGarcom();
                    break;

                case 2:
                    menuCaixa();
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

    public static void menuGarcom() {
        int opcao = 1;

        System.out.println("Digite a matrícula: ");
        Scanner scan = new Scanner(System.in);
        int matricula = scan.nextInt();

        Garcom garcom = new Garcom();

        for (int i = 0; i < restaurante.getGarcons().size(); i++) {
            if (restaurante.getGarcons().get(i).getMatricula() == matricula) {
                garcom = restaurante.getGarcons().get(i);
            }
        }
//        System.out.println("Matrícula não cadastrada. Favor digitar sua matrícula corretamente.");

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

                    System.out.println("Digite o número da mesa:");
                    int numDaMesa = scan.nextInt();
                    System.out.println("Digite o Codigo do produto");
                    int codigo = scan.nextInt();
                    System.out.println("Digite a quantidade");
                    int quantidade = scan.nextInt();

                    garcom.realizarPedido(restaurante, numDaMesa, codigo, quantidade);
                    break;

                case 2:
                    System.out.println(" ..... Cancelar Conta ..... ");

                    System.out.println("Digite o número da mesa:");
                    numDaMesa = scan.nextInt();

                    garcom.cancelarConta(restaurante, numDaMesa);
                    break;

                case 3:
                    System.out.println(" ..... Fechar Conta ..... ");

                    System.out.println("Digite o número da mesa:");
                    numDaMesa = scan.nextInt();


                    garcom.fecharConta(numDaMesa);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuCaixa() {

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

                    System.out.println("Digite o número da mesa: ");
                    int numeroDaMesa = scan.nextInt();
                    System.out.println("Digite a matricula do Garcom: ");
                    int matriculaDoGarcom = scan.nextInt();

                    Conta novaConta = restaurante.getCaixa().abrirConta(numeroDaMesa, matriculaDoGarcom);
                    restaurante.adicionarConta(novaConta);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuGerente() {
        int opcao = 1;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o CPF: ");
        int cpf = scan.nextInt();

        Gerente gerente = new Gerente();

        for (int i = 0; i < restaurante.getGerentes().size(); i++) {
            if (restaurante.getGerentes().get(i).getCpf() == cpf) {
                gerente = restaurante.getGerentes().get(i);
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

                    Garcom novoGarcom = gerente.cadastrarGarcom(nome, endereco, telefone, identidade, matricula);
                    restaurante.adicionarGarcom(novoGarcom);
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

                    gerente.calcularComissao(restaurante, percentualComissao, valorVendidoNaSemana, diaInicio, mesInicio,
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

                    gerente.calcularOcupacoMesas(restaurante, ocupacaoDaMesa, numeroDaMesa, diaInicio, mesInicio,
                            diaFinal, mesFinal, horaInicio, horaFim);
                    break;

                case 4:
                    System.out.println(" ..... Lista Garçons ..... ");
                    restaurante.imprimeDadosGarcom();

                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void menuProprietario() {
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
