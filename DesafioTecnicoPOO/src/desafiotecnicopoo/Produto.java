package desafiotecnicopoo;

public class Produto {

    private TipoDeProduto tipoDeProduto;
    private double preco;
    private int codigo;

    public Produto(TipoDeProduto tipoDeProduto, float preço, int codigo) {
        this.tipoDeProduto = tipoDeProduto;
        this.preco = preco;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public TipoDeProduto getTipoDeProduto() {
        return tipoDeProduto;
    }

    public void setTipoDeProduto(TipoDeProduto tipoDeProduto) {
        this.tipoDeProduto = tipoDeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
