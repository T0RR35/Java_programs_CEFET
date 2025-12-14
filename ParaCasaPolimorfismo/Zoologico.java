import java.util.ArrayList;

public class Zoologico {
	public static void main(String[] args) {
		Mamifero mama;
		Cachorro cachorro;
		Vaca vaca;

		mama = new Gato();
		cachorro = new Cachorro("Snoopy");
		vaca = new Vaca();

		mama.mamar();
		cachorro.mamar();
		vaca.mamar();

		mama.emitirSom();
		cachorro.emitirSom();
		vaca.emitirSom();

		ArrayList<Mamifero> lista = new ArrayList<Mamifero>();
		lista.add(new Gato());
		lista.add(new Cachorro("Snoopy"));
		lista.add(new Vaca());

		for(Mamifero mamifero : lista){
			mamifero.mamar();
			mamifero.emitirSom();
		}
	}
}