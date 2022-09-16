package desafiotecnicopoo;

import java.util.List;
import java.util.Scanner;

public class Gerente {

    Scanner scan = new Scanner(System.in);

    private String nome;
    private String endereco;
    private String telefone;
    private int cpf;

    public Gerente() {

        System.out.println("Digite o nome do Gerente: ");
        nome = scan.nextLine();
        System.out.println("Digite o endereco: ");
        endereco = scan.nextLine();
        System.out.println("Digite o telefone: ");
        telefone = scan.nextLine();
        System.out.println("Digite o CPF: ");
        cpf = scan.nextInt();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void imprimeDadosGerente() {
        System.out.println("Nome: " + nome + ";  Endereço: " + endereco + "; Telefone: " + telefone + "; CPF: " + cpf);
    }

    public void cadastrarGarcom(List<Garcom> garcons) {
        
        System.out.println("Digite o nome do Garcom: ");
        String nome  = scan.nextLine();
        System.out.println("Digite o endereco: ");
        String endereco = scan.nextLine();
        System.out.println("Digite o telefone: ");
        String telefone = scan.nextLine();
        System.out.println("Digite a identidade: ");
        int identidade = scan.nextInt();
        System.out.println("Digite a matricula: ");
        int matricula = scan.nextInt();
        
        Garcom garcom = new Garcom();
        garcons.add(garcom);
        //return garcom
    }
}
