package desafiotecnicopoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {

    private int numeroDaMesa;
    private int matriculaDoGarcom;
    private LocalDate data = LocalDate.now();
    private LocalTime hora = LocalTime.now();
    private List<ItemDaConta> itensDaConta = new ArrayList<>();
    private double valorConta;

    public Conta() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o número da mesa: ");
        numeroDaMesa = scan.nextInt();
        System.out.println("Digite a matricula do Garcom: ");
        matriculaDoGarcom = scan.nextInt();
        valorConta = 0;
    }

    public Conta(int numeroDaMesa, int matriculaDoGarcom, LocalDate data, LocalTime hora,
                 List<ItemDaConta> itensDaConta, double valorConta) {
        this.numeroDaMesa = numeroDaMesa;
        this.matriculaDoGarcom = matriculaDoGarcom;
        this.data = data;
        this.hora = hora;
        this.itensDaConta = itensDaConta;
        this.valorConta = valorConta;
    }

    public int getNumeroDaMesa() {
        return numeroDaMesa;
    }

    public void setNumeroDaMesa(int numeroDaMesa) {
        this.numeroDaMesa = numeroDaMesa;
    }

    public int getMatriculaDoGarcom() {
        return matriculaDoGarcom;
    }

    public void setMatriculaDoGarcom(int matriculaDoGarcom) {
        this.matriculaDoGarcom = matriculaDoGarcom;
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

    public void calcularValorConta(double valorConta) {
        this.valorConta = this.valorConta + valorConta;
    }

}
