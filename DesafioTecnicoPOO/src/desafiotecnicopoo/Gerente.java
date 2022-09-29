package desafiotecnicopoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Gerente extends Funcionario {

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

    public void cadastrarGarcom(List<Garcom> garcons, String nome, String endereco, String telefone, int identidade, int matricula) {
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

    public void calcularComissao(List<Conta> contas, double percentualComissao, double valorVendidoNaSemana, int diaInicio,
                                 int mesInicio, int diaFinal, int mesFinal, int matricula) {

        LocalDate dataInicial = LocalDate.of(2022, mesInicio, diaInicio);
        LocalDate dataFinal = LocalDate.of(2022, mesFinal, diaFinal);

        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getMatriculaDoGarcom() == matricula
                    && contas.get(i).getData().isAfter(dataInicial)
                    && contas.get(i).getData().isBefore(dataFinal)) {
                valorVendidoNaSemana = valorVendidoNaSemana + contas.get(i).getValorConta();
            }
        }
        double comissao = valorVendidoNaSemana * percentualComissao / 100;
        System.out.println("O valor da comissão dessa semana será de: " + comissao);

    }

    public void calcularOcupacoMesas(List<Conta> contas, double ocupacaoDaMesa, int numeroDaMesa, int diaInicio, int mesInicio,
                                     int diaFinal, int mesFinal, int horaInicio, int horaFim) {

        LocalDate dataInicial = LocalDate.of(2022, mesInicio, diaInicio);
        LocalDate dataFinal = LocalDate.of(2022, mesFinal, diaFinal);
        LocalTime horaInicial = LocalTime.of(horaInicio, 00);
        LocalTime horaFinal = LocalTime.of(horaFim, 00);

        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumeroDaMesa() == numeroDaMesa
                    && contas.get(i).getData().isAfter(dataInicial)
                    && contas.get(i).getData().isBefore(dataFinal)
                    && contas.get(i).getHora().isAfter(horaInicial)
                    && contas.get(i).getHora().isBefore(horaFinal)) {
                ocupacaoDaMesa++;
            }
        }

        System.out.println("A mesa " + numeroDaMesa + " foi ocupada: " + ocupacaoDaMesa + " vezes essa semana");

    }
}
