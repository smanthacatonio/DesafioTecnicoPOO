package desafiotecnicopoo;

public class Proprietario {

    public Proprietario() {
    }

    public Gerente cadastrarGerente(String nome, String endereco, String telefone, int cpf) {
        Gerente gerente = new Gerente(nome, endereco, telefone, cpf);
        return gerente;
    }

}
