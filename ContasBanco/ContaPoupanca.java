public class ContaPoupanca extends Conta{
    private float rendimento;

    ContaPoupanca(int id, String nome, float saldo, float rendimento){
        super(id, nome, saldo);
        this.rendimento = rendimento;
    }

    public float calculaRendimento(){
        return verificaSaldo() * rendimento/100;
    }

    @Override
    public String toString(){
        return String.format(super.toString() + "; " + Float.toString(rendimento));
    }
}
