package Atividade4Heranca;

public class Zoologico {

	public static void main(String[] args) {

		Mamifero mama;
		Cachorro cachorro;
		Vaca vaca;
		
		mama = new Mamifero();
		cachorro = new Cachorro("Snoopy");
		vaca = new Vaca();

		System.out.println("Mamifero mama!");
		mama.mamar();
		System.out.println("Cachorro mama!");
		cachorro.mamar();
		System.out.println("Vaca mama!");
		vaca.mamar();

		System.out.println("Mamifero emite som!");
		mama.emitirSom();
		System.out.println("Cachorro emite som!");
		cachorro.emitirSom();
		System.out.println("Vac emite som!");
		vaca.emitirSom();		
	}
}

class Mamifero {
    
    Mamifero(){

    }

    void mamar(){
        System.out.println("xuc, xuc, xuc");
    }

    void emitirSom(){
        System.out.println("dahupbwud");
    }
}

class Vaca extends Mamifero{
    
    Vaca(){}

    void emitirSom(){
        System.out.println("muuuuu");
    }
}

class Cachorro extends Mamifero{
    String nome;

    Cachorro(String nome){
        this.nome = nome;
    }

    void emitirSom(){
        System.out.println("rrrrrrrr");
    }
}
