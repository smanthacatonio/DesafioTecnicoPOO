package desafiotecnicopoo;

import java.util.List;
import java.util.Scanner;

public class Comissao {
    Scanner scan = new Scanner(System.in);

    double comissao;
    double percentual;

    public Comissao() {
    }


    public double calcularComissao(List<Garcom> garcons, List<Conta> contas) {
        System.out.println("Digite o valor do percentual da comissão dessa semana. (Ex de formato: 0.10)");
        percentual = scan.nextDouble();

        System.out.println("Digite a matricula do garcom");
        int matricula = scan.nextInt();

        for (int i = 0; i < garcons.size(); i++){
            if (contas.get(i).getMatriculaDoGarcom() == matricula) {
                comissao = percentual * contas.get(i).getValorConta();
            }
            comissao += comissao;
        }
        System.out.println("O valor da comissão dessa semana será de: " + comissao);
        return comissao;
    }

}
