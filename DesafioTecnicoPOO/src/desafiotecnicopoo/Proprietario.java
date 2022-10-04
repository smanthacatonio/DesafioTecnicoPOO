package desafiotecnicopoo;

public class Proprietario {

    public Proprietario() {
    }

    public Gerente cadastrarGerente(String nome, String endereco, String telefone, int cpf) {
        Gerente gerente = new Gerente(nome, endereco, telefone, cpf);
        return gerente;
    }

//    public void imprimeDadosGerente(List<Gerente> gerentes) {
//        for (int i = 0; i < gerentes.size(); i++) {
//            System.out.println("Nome: " + gerentes.get(i).getNome() + ";  Endereço: " + gerentes.get(i).getEndereco() +
//                    "; Telefone: " + gerentes.get(i).getTelefone() + "; CPF: " + gerentes.get(i).getCpf());
//        }
//    }
}
