import java.util.*;

public class Filme extends Gravacao{
    public String diretor;
    public String dataDeLancamento;
    public String distribuidor;

    Filme(){}

    Filme(String titulo, String midia, String diretor, String date, String distribuidor){
        this.titulo = titulo;
        this.midia = midia;
        this.dataDeLancamento = date;
        this.diretor = diretor;
        this.distribuidor = distribuidor;
    }

    public String toString(){
        return String.format(super.toString() + "; " + diretor + "; " + dataDeLancamento + "; " + distribuidor);
    }
}
