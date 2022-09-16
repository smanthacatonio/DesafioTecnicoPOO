package desafiotecnicopoo;

import java.util.Scanner;

public abstract class Funcionario {
     Scanner scan = new Scanner(System.in);

    private String funcao;
    private String nome;
    private String endereco;
    private String telefone;
    
//    só tem no garçom
//     private int identidade;
//    private int matricula;
    
//    só tem no gerente
//    private int cpf; 

    public Funcionario() {
        System.out.println("Digite o nome da função: ");
        funcao = scan.nextLine();
        System.out.println("Digite o nome do funcionário: ");
        nome = scan.nextLine();
        System.out.println("Digite o endereco: ");
        endereco = scan.nextLine();
        System.out.println("Digite o telefone: ");
        telefone = scan.nextLine();
//        System.out.println("Digite a identidade: ");
//        identidade = scan.nextInt();
//        System.out.println("Digite a matricula: ");
//        matricula = scan.nextInt();
    }

    
}
