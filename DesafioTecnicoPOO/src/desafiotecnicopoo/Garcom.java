package desafiotecnicopoo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    

    public Garcom(String nome, String endereco, String telefone, int identidade, int matricula) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.identidade = identidade;
        this.matricula = matricula;
    }
    
    public Garcom() {

//        System.out.println("Digite o nome do Garcom: ");
//        nome = scan.nextLine();
//        System.out.println("Digite o endereco: ");
//        endereco = scan.nextLine();
//        System.out.println("Digite o telefone: ");
//        telefone = scan.nextLine();
//        System.out.println("Digite a identidade: ");
//        identidade = scan.nextInt();
//        System.out.println("Digite a matricula: ");
//        matricula = scan.nextInt();
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
    public void realizarPedido(List<Conta> contas, List<Produto> produtos) {
        int quantidade;
        int codigo;
        int indiceDoItem;

        System.out.println("Digite o número da mesa:");
        int numDaMesa = scan.nextInt();

        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumeroDaMesa() == numDaMesa) {
                System.out.println("Digite o Codigo do produto");
                codigo = scan.nextInt();
                System.out.println("Digite a quantidade");
                quantidade = scan.nextInt();

                //lista de itens já existentes nessa conta
                List<ItemDaConta> itensDaConta = contas.get(i).getItensDaConta();


                for (int j = 0; j < itensDaConta.size(); j++) {
                    if (itensDaConta.get(j).getProduto().getCodigo() == codigo) {
                        int qntAtualDoItem = itensDaConta.get(j).getQuantidade();
                        itensDaConta.get(j).setQuantidade(qntAtualDoItem + quantidade);
                        double valor = itensDaConta.get(j).getProduto().getPreco() * quantidade;
                        contas.get(i).calcularValorConta(valor);
                        return; //sair do método
                    }
                }

                //ainda não existe esse item na conta
                Produto produto = buscarProduto(codigo, produtos);
                if (produto != null) {
                    ItemDaConta itemDaConta = new ItemDaConta(produto, quantidade);
                    contas.get(i).adicionarItemDaConta(itemDaConta);
                    double valor = itensDaConta.get(i).getProduto().getPreco() * quantidade;
                    contas.get(i).calcularValorConta(valor);
                } else {
                    System.out.println("Produto não cadastrado. Tente novamente.");
                    realizarPedido(contas, produtos);
                }
            }
        }
    }

    //buscar se o produto existe no banco de dados
    public Produto buscarProduto(int codigo, List<Produto> produtos) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo) {
                return produtos.get(i);
            }
        }
        return null;
    }

//cancelarConta (se ainda não tem itens cadastrados)
    public void cancelarConta(List<Conta> contas) {

        System.out.println("Digite o número da mesa:");
        int numDaMesa = scan.nextInt();

        for (int i = 0; i < contas.size(); i++) {
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
    public void fecharConta(List<Conta> contas) {

        System.out.println("Digite o número da mesa:");
        int numDaMesa = scan.nextInt();

        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumeroDaMesa() == numDaMesa) {
                System.out.println(" ---- Nota Fiscal ---- ");
                System.out.println(LocalDate.now());
                System.out.println(LocalTime.now());
                System.out.println(" ---- Fechamento da Conta Mesa " + numDaMesa + "  ---- ");
                System.out.println(" ---- Produtos Consumidos ---- ");
                
                for (int j = 0; j < contas.get(i).getItensDaConta().size(); j++) {

                    System.out.println("Quantidade: " + contas.get(i).getItensDaConta().get(j).getQuantidade());
                    System.out.println("Produto: " + contas.get(i).getItensDaConta().get(j).getProduto().getTipoDeProduto());
                }
                
                System.out.println(" ---- Valor total da conta: " + contas.get(i).getValorConta() + " ---- ");
            }
        }
    }

}
