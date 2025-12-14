public class ContaEspecial extends Conta{
    private float limite;

    ContaEspecial(int id, String nome, float saldo, float limite){
        super(id, nome, saldo);
        this.limite = limite;
    }

    @Override
    public boolean retira(float valor){
        return super.retira(valor);
    }

    @Override
    public float verificaSaldo(){
        return super.verificaSaldo();
    }

    @Override
    public String toString(){
        return String.format(super.toString() + "; " + Float.toString(limite));
    }
}
