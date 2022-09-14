package desafiotecnicopoo;

public enum TipoDeProduto {

    BEBIDAS("Bebidas"), PETISCOS("Petiscos"), CARNES("Carnes"), AVES("Aves"), 
    MASSAS("Massas"), SOBREMESAS("Sobremesas");

    private String descricao;

    private TipoDeProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
