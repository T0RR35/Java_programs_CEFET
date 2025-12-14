public class Gravacao extends Biblioteca{
    protected String titulo;
    protected String midia;

    @Override
    public String toString(){
        return String.format(super.toString() + "; " + titulo + "; " + midia);
    }
}
