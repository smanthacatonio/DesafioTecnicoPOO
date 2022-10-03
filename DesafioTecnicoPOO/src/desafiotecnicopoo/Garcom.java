package desafiotecnicopoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Garcom extends Funcionario {

    private int identidade;
    private int matricula;


    public Garcom(String nome, String endereco, String telefone, int identidade, int matricula) {
        super(nome, endereco, telefone);
        this.identidade = identidade;
        this.matricula = matricula;
    }

    public Garcom() {
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

    //Conta relativa à mesa
    public void realizarPedido(List<Conta> contas, List<Produto> produtos, int numDaMesa, int codigo, int quantidade) {

        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumeroDaMesa() == numDaMesa) {

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
                    double valor = produto.getPreco() * quantidade;
                    contas.get(i).calcularValorConta(valor);
                    return; //sair do método
                } else {
                    System.out.println("Produto não cadastrado. Tente novamente.");
                    return;
                }
            }
        }
        System.out.println("Mesa não está com conta aberta. Favor digitar número da mesa novamente");
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
    public void cancelarConta(List<Conta> contas, int numDaMesa) {

        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumeroDaMesa() == numDaMesa) {
                if (contas.get(i).getItensDaConta().isEmpty()) {
                    contas.remove(i);
                    //enviar alerta de  cancelamento pro gerente

                    System.out.println("A conta foi cancelada com sucesso.");
                    return;
                }
            } else {
                System.out.println("Já existe pedido lançado. Não é possível cancelar a conta.");
                return;
            }
        }
        System.out.println("Mesa não está com conta aberta. Favor digitar número da mesa novamente");
    }

// emitirCancelamentoGerente


    //fecharConta
    public void fecharConta(List<Conta> contas, int numDaMesa) {

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
                return;
            }
        }
        System.out.println("Mesa não está com conta aberta. Favor digitar número da mesa novamente");
    }

}
