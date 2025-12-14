public class Software extends Gravacao{
    public int versao;
    public String plataforma;

    Software(){}

    Software(String titulo, String midia, int versao, String plataforma){
        this.titulo = titulo;
        this.midia = midia;
        this.versao = versao;
        this.plataforma = plataforma;
    }

    public String toString(){
        return String.format(super.toString() + "; " + Integer.toString(versao) + "; " + plataforma);
    }
}
