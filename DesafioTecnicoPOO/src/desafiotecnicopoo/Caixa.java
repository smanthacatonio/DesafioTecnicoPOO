package desafiotecnicopoo;

import java.util.List;

public class Caixa {

    public Caixa() {
    }

    public Conta abrirConta(int numeroDaMesa, int matriculaDoGarcom) {
        Conta conta = new Conta(numeroDaMesa, matriculaDoGarcom);
        return conta;
    }

}
