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
    private Caixa caixa;
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

    public void cargaDeDados() {

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

    }

    public void adicionarGarcom(Garcom garcom) {
        garcons.add(garcom);
    }

    public void imprimeDadosGarcom() {
        for (int i = 0; i < garcons.size(); i++) {
            System.out.println("Nome: " + garcons.get(i).getNome() + ";  Endereço: " + garcons.get(i).getEndereco() +
                    "; Telefone: " + garcons.get(i).getTelefone() + "; Identidade: " + garcons.get(i).getIdentidade() +
                    "; Matrícula: " + garcons.get(i).getMatricula());
        }
    }

    public boolean encontraGarcom(int matricula){

        for (int i = 0; i < getGarcons().size(); i++) {
            if (getGarcons().get(i).getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }

    public void adicionarGerente(Gerente gerente) {
        gerentes.add(gerente);
    }

    public void imprimeDadosGerente() {
        for (int i = 0; i < gerentes.size(); i++) {
            System.out.println("Nome: " + gerentes.get(i).getNome() + ";  Endereço: " + gerentes.get(i).getEndereco() +
                    "; Telefone: " + gerentes.get(i).getTelefone() + "; CPF: " + gerentes.get(i).getCpf());
        }
    }

    public boolean encontraGerente(int cpf){

        for (int i = 0; i < getGerentes().size(); i++) {
            if (getGerentes().get(i).getCpf() == cpf) {
                return true;
            }
        }
        return false;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void imprimeContasAbertas() {
        for (int i = 0; i < contas.size(); i++) {
            System.out.println("Numero da mesa: " + contas.get(i).getNumeroDaMesa());
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Garcom> getGarcons() {
        return garcons;
    }

    public void setGarcons(List<Garcom> garcons) {
        this.garcons = garcons;
    }

    public List<Gerente> getGerentes() {
        return gerentes;
    }

    public void setGerentes(List<Gerente> gerentes) {
        this.gerentes = gerentes;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
