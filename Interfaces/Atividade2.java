public class Atividade2 {
    public static void main(String[] args) {
        GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();
        SeguroDeVida sv = new SeguroDeVida();
        gerenciador.adiciona(sv);
        ContaCorrente cc = new ContaCorrente();
        cc.deposita(100);
        Tributavel t = cc;
        System.out.println(t.calculaTributos());
    }
}


interface Tributavel {
    double calculaTributos();
}
    
class Conta{
    protected double saldo;

    Conta(){
        saldo = 0;
    }
}

class ContaCorrente extends Conta implements Tributavel {

    public double calculaTributos() {
        return this.saldo * 0.01;
    }

    public void deposita(double valor){
        this.saldo += valor;
    }
}

class SeguroDeVida implements Tributavel {

    public double calculaTributos() {
        return 42;
    }
}

class GerenciadorDeImpostoDeRenda {
    private double total;
    
    void adiciona(Tributavel t) {
        System.out.println("Adicionando tributavel: " + t);
        this.total = this.total + t.calculaTributos();
    }

    public double getTotal() {
        return total;
    }
}

        