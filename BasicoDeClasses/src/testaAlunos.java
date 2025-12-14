import java.util.Scanner;
import java.io.*;

class Aluno {
	
	private String matricula, grupo, subTurma;
	private String nome, senha, senhaCensurada, email, cargo, setor;
	
	public Aluno() {
		this.matricula = "";
		this.nome = "";
		this.email = "";
		this.senha = "";
		this.cargo = "";
		this.grupo = "";
		this.setor = "";
	}
	
	public Aluno(String matricula, String nome, String email, String senha, String cargo, String grupo, String setor) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.grupo = grupo;
		this.setor = setor;
		this.senhaCensurada = "";
	}
	
	public Aluno(String nome, String matricula, String grupo, String subTurma, String senha) {
		this.matricula = matricula;
		this.grupo = grupo;
		this.subTurma = subTurma;
		this.senha = senha;
		this.nome = nome;
		senhaCensurada = "";
	}
	
	public void censuraSenha() {
		int tamanhoSenha = senha.length();
		
		for (int i = 0; i < tamanhoSenha; i++) {
			senhaCensurada = senhaCensurada + '*';
		}
	}
	
	public String toString() {
		String str = nome + "; "+ matricula +"; "+ grupo +"; "+ subTurma +"; " + senhaCensurada;
		return str;
	}

	public String toStringCSV() {
		String str = matricula + "; "+ nome +"; "+ email +"; "+ senhaCensurada +"; " + cargo +"; "+ grupo +"; "+ setor;
		return str;
	}
}

public class testaAlunos{
	
	public static void main(String[] args) throws FileNotFoundException{
		//preencheAlunosPeloTeclado();
		preencheAlunosPorCSV();
	}
	
	public static void preencheAlunosPeloTeclado() {

		Scanner scan = new Scanner(System.in);
		
		Aluno [] alunos = new Aluno[3];
		
		String matricula, grupo, subTurma;
		String nome, senha;
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Digite o nome do aluno " + (i+1) + ": ");
			nome = scan.nextLine();
			
			scan.nextLine(); //esvazia o scan
			
			System.out.println("Digite a matricula do aluno " + (i+1) + ": ");
			matricula = scan.nextLine();
			
			scan.nextLine(); //esvazia o scan
			
			System.out.println("Digite o grupo do aluno " + (i+1) + ": ");
			grupo = scan.nextLine();
			
			scan.nextLine(); //esvazia o scan
			
			System.out.println("Digite a subTurma do aluno " + (i+1) + ": ");
			subTurma = scan.nextLine();
			
			scan.nextLine(); //esvazia o scan
			
			System.out.println("Digite a senha do aluno " + (i+1) + ": ");
			senha = scan.nextLine();
			
			alunos[i] = new Aluno(nome, matricula, grupo, subTurma, senha);
			alunos[i].censuraSenha();
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Aluno " + (i+1) + ": "+ alunos[i].toString());
		}
		scan.close();
	}
	
	public static void preencheAlunosPorCSV() throws FileNotFoundException{	
	String matricula, grupo, cargo;
	String nome, senha, email, setor;
	Aluno [] alunos = new Aluno[104];
	int i = 0;

	File getCSVFiles = new File("D:\\2025\\cefet\\3 ano\\LPII\\Atividade 3 Classes\\src\\pessoal.csv");
	Scanner sc = new Scanner(getCSVFiles);
	sc.useDelimiter(";|\\n");

	sc.nextLine(); //Le a primeira linha e ignora ela

	while (sc.hasNext()){

		matricula = sc.next();
		nome = sc.next();
		email = sc.next();
		senha = sc.next();
		cargo = sc.next();
		grupo = sc.next();
		setor = sc.next();

		alunos[i] = new Aluno(matricula, nome, email, senha, cargo, grupo, setor);
		alunos[i].censuraSenha();
		System.out.println(i + " - "+ alunos[i].toStringCSV());
		i++; 
	}
	sc.close();

	}
}