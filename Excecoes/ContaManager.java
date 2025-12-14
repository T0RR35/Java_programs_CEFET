public class ContaManager {

    public static void main(String args[]){
        Conta minhaConta = new Conta();
        minhaConta.deposita(100);
        minhaConta.setLimite(200);

        try {
            minhaConta.saca(1000);
        } catch(ContaExcessao e) {
            System.out.println("Erro capturado -> " + e);
        }
    }
}

class Conta {
    private int saldo = 0;
    private int limite = 0;

    // Adiciona saldo
    public void deposita(int num){
        saldo += num;
        System.out.println("Depósito: +" + num + " | Saldo atual: " + saldo);
    }

    // Define um limite de crédito (tipo cheque especial)
    public void setLimite(int num){
        this.limite = num;
    }

    // Saca um valor da conta
    public void saca(int num) throws ContaExcessao {
        if (saldo + limite < num) {
            // Se tentar sacar mais que o permitido, lança exceção
            throw new ContaExcessao(num);
        } else {
            saldo -= num;
            System.out.println("Saque: -" + num + " | Saldo atual: " + saldo);
        }
    }
}

// Exceção personalizada para operações inválidas
class ContaExcessao extends Exception {
    int num;

    public ContaExcessao(int num) {
        this.num = num;
    }

    public String toString(){
        return "Tentativa de saque inválida: " + num;
    }
}
