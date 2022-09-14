package desafiotecnicopoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garcom {

    Scanner scan = new Scanner(System.in);

    private String nome;
    private String endereco;
    private String telefone;
    private int identidade;
    private int matricula;

    public Garcom() {

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

    public void imprimeDadosGarcom() {
        System.out.println("Nome: " + nome + ";  Endereço: " + endereco + "; Telefone: " + telefone + "; Identidade: " + identidade + "; Matrícula: " + matricula);
    }

    //Conta relativa à mesa
    public void realizarPedido(Conta conta, List<Produto> produtos) {
        int quantidade;
        int codigo;
        int indiceDoItem;
// acrescentar numMesa
        System.out.println("Digite o Codigo do produto");
        codigo = scan.nextInt();
        System.out.println("Digite a quantidade");
        quantidade = scan.nextInt();

        indiceDoItem = verificarSeExisteItemCadastrado(conta, codigo);

        if (indiceDoItem == -1) {//teria que ser != -1, não?
            Produto produto = buscarProduto(codigo, produtos);
            if (produto != null) {
                ItemDaConta itemDaConta = new ItemDaConta(produto, quantidade);
                conta.adicionarItemDaConta(itemDaConta);
                conta.calcularValorConta(produto.getPreco() * quantidade);
            } else {
                System.out.println("Produto não cadastrado");
                realizarPedido(conta, produtos);
            }
        } else {
            int quantidadeAtualDoItem = conta.getItensDaConta().get(indiceDoItem).getQuantidade();
            conta.getItensDaConta().get(indiceDoItem).setQuantidade(quantidadeAtualDoItem + quantidade);
            conta.calcularValorConta(conta.getItensDaConta().get(indiceDoItem).getProduto().getPreco() * quantidade);
        }
    }

    //buscar se o produto está no Banco de Dados
    public Produto buscarProduto(int codigo, List<Produto> produtos) {
        for (int i = 0; i <= produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo) {
                return produtos.get(i);
            }
        }
        return null;
    }

    //verifica se o item está cadastrado na conta
    public int verificarSeExisteItemCadastrado(Conta conta, int codigo) {
        int indice = -1;
        List<ItemDaConta> itensDaConta = conta.getItensDaConta();
        for (int i = 0; i <= itensDaConta.size(); i++) {
            if (itensDaConta.get(i).getProduto().getCodigo() == codigo) {
                return indice;
            }
        }
        return indice;
    }

//cancelarConta (se ainda não tem itens cadastrados)
    public void cancelarConta(List<Conta> contas) {
        
        System.out.println("Digite o número da mesa:");
        int numDaMesa = scan.nextInt();

        for (int i = 0; i <= contas.size(); i++) {
            if (contas.get(i).getNumeroDaMesa() == numDaMesa) {
                if (contas.get(i).getItensDaConta().isEmpty()) {
                    contas.remove(i);
                    //enviar alerta de  cancelamento pro gerente
                    
                    System.out.println("A conta foi cancelada com sucesso.");
                } else {
                    System.out.println("Já existe pedido lançado. Não é possível cancelar a conta.");
                }
            }
        }
    }

// emitirCancelamentoGerente
  
//fecharConta
}
