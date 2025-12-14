public class Atividade3 {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente();
        cc.deposita(100);

        ContaPoupanca cp = new ContaPoupanca();
        cp.deposita(50);
    }
}

interface Conta {
    double getSaldo();
    void deposita(double valor);
    void retira(double valor);
    void atualiza(double taxaSelic);
}
    
class ContaCorrente implements Conta {
        
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
}
        
class ContaPoupanca implements Conta {
        
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
}