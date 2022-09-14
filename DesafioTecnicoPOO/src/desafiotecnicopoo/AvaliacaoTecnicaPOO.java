package desafiotecnicopoo;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoTecnicaPOO {

    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(TipoDeProduto.BEBIDAS, 5, 001));
        produtos.add(new Produto(TipoDeProduto.PETISCOS, 25, 002));
        produtos.add(new Produto(TipoDeProduto.CARNES, 45, 003));
        produtos.add(new Produto(TipoDeProduto.AVES, 35, 004));
        produtos.add(new Produto(TipoDeProduto.MASSAS, 25, 005));
        produtos.add(new Produto(TipoDeProduto.SOBREMESAS, 15, 006));

        List<Garcom> garcons = new ArrayList<>();

        List<Conta> contas = new ArrayList<>();
    }

    public void menu(Caixa caixa, Garcom garcom, Gerente gerente, Conta conta, List<Produto> produtos) {

        int opcao = 1;

        while (opcao != 0) {

            System.out.println("Escolha a opção desejada");
            System.out.println("1. Cadastrar garçom");
            System.out.println("2. Abrir conta");
            System.out.println("3. Realizar pedido");
//            System.out.println("4. Calcular conta");
            System.out.println("5. Cancelar conta");
            System.out.println("6. Fechar conta");
            System.out.println("7. Calcular comissão");
            System.out.println("8. Ocupação das mesas");
            System.out.println("9. Cadastrar Gerente");
            System.out.println("0. Sair");

            switch (opcao) {

                case 0:
                    System.out.println("Saindo.........");
                    break;

                case 1:
                    gerente.cadastrarGarcom(garcons);
                    break;

                case 2:
                    caixa.abrirConta(contas);
                    break;

                case 3:
                    garcom.realizarPedido(conta, produtos);
                    break;

//                case 4:
//
//                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:

                    break;

                case 9:
//                    proprietario.cadastrarGerente();
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        }

    }

}
