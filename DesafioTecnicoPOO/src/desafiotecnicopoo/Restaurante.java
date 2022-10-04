package desafiotecnicopoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {

    private List<Produto> produtos;
    private List<Garcom> garcons;
    private List<Gerente> gerentes;
    private List<Conta> contas;
    private  Caixa caixa;
    private Proprietario proprietario;

    public Restaurante() {
        produtos = new ArrayList<>();
        garcons = new ArrayList<>();
        gerentes = new ArrayList<>();
        contas = new ArrayList<>();
        caixa = new Caixa();
        proprietario = new Proprietario();
        cargaDeDados();
    }

    public void cargaDeDados(){

        produtos.add(new Produto(TipoDeProduto.BEBIDAS, 5.20, 100));
        produtos.add(new Produto(TipoDeProduto.PETISCOS, 25.15, 200));
        produtos.add(new Produto(TipoDeProduto.CARNES, 45.65, 300));
        produtos.add(new Produto(TipoDeProduto.AVES, 35, 400));
        produtos.add(new Produto(TipoDeProduto.MASSAS, 25, 500));
        produtos.add(new Produto(TipoDeProduto.SOBREMESAS, 15, 600));

        garcons.add(new Garcom("joao", "Rua tal", "12345678", 123456, 1));
        garcons.add(new Garcom("maria", "Rua tal", "12345678", 123456, 2));
        garcons.add(new Garcom("jose", "Rua tal", "12345678", 123456, 3));

        gerentes.add(new Gerente("joao", "rua tal", "98564", 123456789));

        contas.add(new Conta(03, 01,LocalDate.of(2022, 9, 19),
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

    }

    public void adicionarGarcom(Garcom garcom) {
        garcons.add(garcom);
    }



}

//    List<Produto> produtos = new ArrayList<>();
//        produtos.add(new Produto(TipoDeProduto.BEBIDAS, 5.20, 100));
//                produtos.add(new Produto(TipoDeProduto.PETISCOS, 25.15, 200));
//                produtos.add(new Produto(TipoDeProduto.CARNES, 45.65, 300));
//                produtos.add(new Produto(TipoDeProduto.AVES, 35, 400));
//                produtos.add(new Produto(TipoDeProduto.MASSAS, 25, 500));
//                produtos.add(new Produto(TipoDeProduto.SOBREMESAS, 15, 600));
//
//                List<Garcom> garcons = new ArrayList<>();
//        garcons.add(new Garcom("joao", "Rua tal", "12345678", 123456, 1));
//        garcons.add(new Garcom("maria", "Rua tal", "12345678", 123456, 2));
//        garcons.add(new Garcom("jose", "Rua tal", "12345678", 123456, 3));
//
//        List<Gerente> gerentes = new ArrayList<>();
//        gerentes.add(new Gerente("joao", "rua tal", "98564", 123456789));
//
//
//        List<Conta> contas = new ArrayList<>();
//        contas.add(new Conta(03, 01,LocalDate.of(2022, 9, 19),
//        LocalTime.of(12, 00), new ArrayList(), 15));
//        contas.add(new Conta(01, 01, LocalDate.of(2022, 9, 20),
//        LocalTime.of(13, 55), new ArrayList(), 5.20));
//        contas.add(new Conta(02, 01, LocalDate.of(2022, 9, 21),
//        LocalTime.of(13, 15), new ArrayList(), 45.65));
//        contas.add(new Conta(01, 01, LocalDate.of(2022, 9, 22),
//        LocalTime.of(14, 05), new ArrayList(), 25.15));
////        quando começa em um mês e termina do outro
//        contas.add(new Conta(03, 01, LocalDate.of(2022, 9, 29),
//        LocalTime.of(12, 00), new ArrayList(), 15));
//        contas.add(new Conta(01, 01, LocalDate.of(2022, 9, 30),
//        LocalTime.of(13, 55), new ArrayList(), 5.20));
//        contas.add(new Conta(02, 01, LocalDate.of(2022, 10, 1),
//        LocalTime.of(13, 15), new ArrayList(), 45.65));
//        contas.add(new Conta(01, 01, LocalDate.of(2022, 10, 2),
//        LocalTime.of(14, 05), new ArrayList(), 25.15));
//
//
//        Caixa caixa = new Caixa();
//
//        Proprietario proprietario = new Proprietario();
//
//
//        AvaliacaoTecnicaPOO.menuFuncao(garcons, contas, produtos, caixa, gerentes, proprietario);
