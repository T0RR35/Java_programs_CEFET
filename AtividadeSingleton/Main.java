
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

interface gerenciador{
    void imprimePessoas();
}

class Pessoa {
    private int matricula;
    private String nome;
    private String email;
    private String senha;
    private String cargo;
    private String turma;
    private String setor;

    // Construtor da classe Aluno
    public Pessoa(int matricula, String nome, String email, String senha, String cargo, String turma, String setor) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.turma = turma;
        this.setor = setor;
    }

    // Getter para a senha
    public String getSenha() {
        return senha;
    }

    // Getter para a matrícula
    public int getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Pessoa [matricula=" + matricula + ", nome=" + nome + ", email=" + email + ", senha=" + senha
                + ", cargo=" + cargo + ", turma=" + turma + ", setor=" + setor + "]";
    }

}

class GerenciadorPessoas implements gerenciador{
    ArrayList<Pessoa> pessoas = new ArrayList<>();

    public GerenciadorPessoas() {

        // Lendo dados do arquivo CSV e populando o ArrayList de Aluno
        try (BufferedReader br = new BufferedReader(new FileReader("pessoal.csv"))) {
            String line;
            br.readLine(); // pula cabeçalho
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                int matricula = Integer.parseInt(data[0]);
                String nome = data[1];
                String email = data[2];
                String senha = data[3];
                String cargo = data[4];
                String setor = "";
                String turma = "";
                switch (cargo) {
                    case "Geral":
                        setor = data[6];
                        break;
                    case "Discente":
                        turma = data[5];
                        break;
                    default:
                        break;
                }

                pessoas.add(new Pessoa(matricula, nome, email, senha, cargo, turma, setor));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void imprimePessoas() {
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}

class Proxy implements gerenciador{

    GerenciadorPessoas gerenciador = new GerenciadorPessoas();

    public Proxy(){}

    public void tentaImprimir(int matricula){
        for(Pessoa pessoa : gerenciador.pessoas){
            if(pessoa.getMatricula() == matricula){
                imprimePessoas();
                break;
            }
        }
    }

    public void imprimePessoas(){
        gerenciador.imprimePessoas();
    }
}

public class Main {

    public static void main(String[] args) {

        int matricula;

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe sua matricula: ");
        matricula = sc.nextInt();
        sc.close();

        Proxy proxy = new Proxy();

        proxy.tentaImprimir(matricula);
    }
}