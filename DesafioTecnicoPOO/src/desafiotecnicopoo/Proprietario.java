package desafiotecnicopoo;

import java.util.List;
import java.util.Scanner;

public class Proprietario{
    Scanner scan = new Scanner(System.in);
//extends Gerente?


    public Proprietario() {
    }

    public void cadastrarGerente(List<Gerente> gerentes) {

        System.out.println("Digite o nome do gerente: ");
        String nome = scan.nextLine();
        System.out.println("Digite o endereco: ");
        String endereco = scan.nextLine();
        System.out.println("Digite o telefone: ");
        String telefone = scan.nextLine();
        System.out.println("Digite o CPF: ");
        int cpf = scan.nextInt();

        Gerente gerente = new Gerente(nome, endereco, telefone, cpf);
        gerentes.add(gerente);

    }

    public void imprimeDadosGerente(List<Gerente> gerentes) {
        for (int i = 0; i < gerentes.size(); i++) {
            System.out.println("Nome: " + gerentes.get(i).getNome() + ";  Endereço: " + gerentes.get(i).getEndereco() +
                    "; Telefone: " + gerentes.get(i).getTelefone() + "; CPF: " + gerentes.get(i).getCpf());
        }
    }
}
