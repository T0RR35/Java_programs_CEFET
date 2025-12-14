public class Conta {
    private int id;
    private String nome;
    private float saldo;

    Conta(){
        id = 0;
        nome = "";
        saldo = 0;
    }

    Conta(int id, String nome, float saldo){
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
    }

    public float verificaSaldo(){
        return saldo;
    }

    public boolean retira(float valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    public void deposita(float valor){
        saldo += valor;
    }

    @Override
    public String toString(){
        return String.format(Integer.toString(id) + "; " + nome + "; " + Float.toString(saldo));
    }
}
