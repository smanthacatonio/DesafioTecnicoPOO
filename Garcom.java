package avaliacaotecnicapoo;

import java.util.Scanner;

public class Garcom {
      
    private String nome;
    private String endereco;
    private String telefone;
    private int identidade;
    private int matricula;
    
    public Garcom(String nome, String endereco, String telefone, int identidade, int matricula) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.identidade = identidade;
        this.matricula = matricula;
    }

    public int getIdentidade() {
        return identidade;
    }

    public void setIdentidade(int identidade) {
        this.identidade = identidade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public void dadosGarcom() {
        Scanner scan = new Scanner(System.in);
                
       System.out.println("Digite o nome do Garcom: ");
        nome = scan.nextLine();
        System.out.println("Digite o endereco: ");
        endereco = scan.nextLine();
        System.out.println("Digite o telefone: ");
        telefone = scan.nextLine();
        System.out.println("Digite a identidade: ");
        identidade = scan.nextInt();
        System.out.println("Digite a matricula: ");
        matricula = scan.nextInt();
    }
    
    //abrirConta
    
    //cancelarConta (se ainda não tem itens cadastrados)
    
    //emitirCancelamentoGerente
    
    //fecharConta
    
}
