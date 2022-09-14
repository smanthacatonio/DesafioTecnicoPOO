package desafiotecnicopoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {

    private int numeroDaMesa;
    private String nomeDoGarcom;
    private LocalDate data = LocalDate.now() ;
    private LocalTime hora = LocalTime.now();
    private List<ItemDaConta> itensDaConta = new ArrayList<>();
    private double valorConta;

    public Conta() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o número da mesa: ");
        numeroDaMesa = scan.nextInt();
        System.out.println("Digite o nome do Garcom: ");
        nomeDoGarcom = scan.nextLine();
        valorConta = 0;
    }
    
    public int getNumeroDaMesa() {
        return numeroDaMesa;
    }

    public void setNumeroDaMesa(int numeroDaMesa) {
        this.numeroDaMesa = numeroDaMesa;
    }

    public String getNomeDoGarcom() {
        return nomeDoGarcom;
    }

    public void setNomeDoGarcom(String nomeDoGarcom) {
        this.nomeDoGarcom = nomeDoGarcom;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public List<ItemDaConta> getItensDaConta() {
        return itensDaConta;
    }

    public void setItensDaConta(List<ItemDaConta> itensDaConta) {
        this.itensDaConta = itensDaConta;
    }

    public void adicionarItemDaConta(ItemDaConta itemDaConta) {
        this.itensDaConta.add(itemDaConta);
    }

    public double getValorConta() {
        return valorConta;
    }

    public void setValorConta(double valorConta) {
        this.valorConta = valorConta;
    }
    
    public void calcularValorConta(double valorConta){
        this.valorConta += valorConta;
    }

}
