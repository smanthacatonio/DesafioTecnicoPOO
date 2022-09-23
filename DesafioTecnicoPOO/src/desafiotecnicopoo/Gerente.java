package desafiotecnicopoo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Gerente extends Funcionario {

    Scanner scan = new Scanner(System.in);

    private int cpf;

    public Gerente(String nome, String endereco, String telefone, int cpf) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }
    public Gerente() {

    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void cadastrarGarcom(List<Garcom> garcons) {

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

        Garcom garcom = new Garcom(nome, endereco, telefone, identidade, matricula);
        garcons.add(garcom);
    }

    public void imprimeDadosGarcom(List<Garcom> garcons) {

        for (int i = 0; i < garcons.size(); i++) {
            System.out.println("Nome: " + garcons.get(i).getNome() + ";  Endereço: " + garcons.get(i).getEndereco() +
                    "; Telefone: " + garcons.get(i).getTelefone() + "; Identidade: " + garcons.get(i).getIdentidade() +
                    "; Matrícula: " + garcons.get(i).getMatricula());
        }
    }

    public void calcularComissao(List<Conta> contas) {

        double percentualComissao;
        double valorVendidoNaSemana = 0;
        int diaInicio;
        int mesInicio;
        int diaFinal;
        int mesFinal;

        System.out.println("Digite o dia de início da semana");
        diaInicio = scan.nextInt();
        System.out.println("Digite o mês de início da semana");
        mesInicio = scan.nextInt();
        System.out.println("Digite o dia de final da semana");
        diaFinal = scan.nextInt();
        System.out.println("Digite o mês de final da semana");
        mesFinal = scan.nextInt();
        System.out.println("Digite o valor do percentual da comissão dessa semana.");
        percentualComissao = scan.nextDouble();
        System.out.println("Digite a matricula do garcom");
        int matricula = scan.nextInt();

        for (int i = 0; i < contas.size(); i++){
            if (contas.get(i).getMatriculaDoGarcom() == matricula
                    && contas.get(i).getData().getDayOfMonth() >= diaInicio
                    && contas.get(i).getData().getDayOfMonth() <= diaFinal
                    && contas.get(i).getData().getMonthValue() >= mesInicio
                    && contas.get(i).getData().getMonthValue() <= mesFinal) {
                valorVendidoNaSemana = valorVendidoNaSemana + contas.get(i).getValorConta();
            }
        }

        double comissao = valorVendidoNaSemana * percentualComissao/100;
        System.out.println("O valor da comissão dessa semana será de: " + comissao);

    }
}
