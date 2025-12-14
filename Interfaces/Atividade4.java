public class Atividade4 {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente();
        cc.deposita(100);
        Tributavel t = cc;
        System.out.println(t.calculaTributos());
    }
}

interface Conta {
    double getSaldo();
    void deposita(double valor);
    void retira(double valor);
    void atualiza(double taxaSelic);
}

interface Tributavel {
    double calculaTributos();
}
    
interface ContaTributavel extends Conta, Tributavel {
}

class ContaCorrente implements ContaTributavel {
    double saldo;

    public double getSaldo(){
        return saldo;
    }

    public void deposita(double valor){
        saldo += valor;
    }

    public void retira(double valor){
        saldo -= valor;
    }

    public void atualiza(double taxaSelic){
    }

    public double calculaTributos() {
        return this.saldo * 0.01;
    }
}
