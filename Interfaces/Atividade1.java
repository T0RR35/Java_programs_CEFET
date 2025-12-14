public class Atividade1{
	public static void main(String[] args) {
		
		AreaCalculavel a = new Retangulo(3,2);
		System.out.println("Retangulo: " + a.calculaArea());
		
		AreaCalculavel q = new Quadrado(3);
		System.out.println("Quadrado: " + q.calculaArea());
		
		AreaCalculavel c = new Circulo(3);
		System.out.println("Circulo: " + c.calculaArea());
	}
}

interface AreaCalculavel {
	double calculaArea();
}

class Quadrado implements AreaCalculavel {
	private int lado;

	public Quadrado(int lado) {
		this.lado = lado;
	}
	
	public double calculaArea() {
		return this.lado * this.lado;
	}
}

class Retangulo implements AreaCalculavel {
	private int largura;
	private int altura;
	
	public Retangulo(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
	}
	
	public double calculaArea() {
		return this.largura * this.altura;
	}
}

class Circulo implements AreaCalculavel{
	private double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	public double calculaArea() {
		return Math.PI * raio * raio;
	}
}
