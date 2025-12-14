//Rafael Ferreira Torres Modesto questão 3

import java.util.Scanner;

public class Aluno{

    public String nome;
    public int idade;
    public String identidade;

    void defineIdentidade(String valor){
        if(valor.length() >= 5){
            identidade = valor;
        } else{
            System.out.println("A identidade deve ter ao menos 5 caracteres");
        }
    }

    String pegaIdentidade(){
        return identidade;
    }

    public static void main(String[] args){
        Aluno aluno1 = new aluno();

        String aux = "";
        Scanner entrada = new Scanner(System.in);

        //dados do aluno 1
        System.out.println("Entre com o nome do aluno: ");
        aluno1.nome = entrada.nextLine();
        System.out.println("Entre com a idade do aluno: ");
        aluno1.idade = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Entre com a identidade do aluno (mais de 5 caracteres): ");
        aux = entrada.nextLine();
        aluno1.defineIdentidade(aux);
        System.out.print("O aluno 1, de nome " + aluno1.nome + " tem idade " + aluno1.idade);
        System.out.println("Identidade: " + aluno1.pegaIdentidade());


        //dados do aluno 2
        Aluno aluno2;
        aluno2 = new aluno();
        System.out.println("Entre com o nome do aluno: ");
        aluno2.nome = entrada.nextLine();
        System.out.println("Entre com a idade do aluno: ");
        aluno2.idade = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Entre com a identidade do aluno (mais de 5 caracteres): ");
        aux = entrada.nextLine();
        aluno2.defineIdentidade(aux);
        System.out.print("O aluno 2, de nome " + aluno1.nome + " tem idade " + aluno1.idade);
        System.out.println("Identidade: " + aluno1.pegaIdentidade());
    }
}
