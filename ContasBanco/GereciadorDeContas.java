import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GereciadorDeContas {

    static int qntContaNormal = 0, qntContaPoupanca = 0, qntContaEspecial = 0;
    public static void main(String args[]) {
        try {
            questao2();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void questao2() throws FileNotFoundException {
        File getCSVFiles = new File("assets/contas.csv");
        Scanner scArquivo = new Scanner(getCSVFiles);

        ArrayList<ContaPoupanca> contasPoupancas = new ArrayList<>();
        ArrayList<ContaEspecial> contasEspecias = new ArrayList<>();
        ArrayList<Conta> contasNormais = new ArrayList<>();

        scArquivo.nextLine(); //pega a primeira linha e joga fora

        while (scArquivo.hasNextLine()) {
            String linha = scArquivo.nextLine();
            String[] dados = linha.split(",",-1);

            if(dados[3].equals("") && dados[4].equals("")){ 
                Conta conta = new Conta(Integer.valueOf(dados[0]), dados[1], Float.valueOf(dados[2]));
                contasNormais.add(conta);
                qntContaNormal++;
            }
            else if(dados[3].equals("")){
                ContaPoupanca conta = new ContaPoupanca(Integer.valueOf(dados[0]), dados[1], Float.valueOf(dados[2]), Float.valueOf(dados[4]));
                contasPoupancas.add(conta);
                qntContaPoupanca++;
            }
            else if(dados[4].equals("")){
                ContaEspecial conta = new ContaEspecial(Integer.valueOf(dados[0]), dados[1], Float.valueOf(dados[2]), Float.valueOf(dados[3]));
                contasEspecias.add(conta);
                qntContaEspecial++;
            }
        }
        scArquivo.close();

        Iterator<ContaEspecial> iterEspecial = contasEspecias.iterator();
        Iterator<ContaPoupanca> iterPoupanca = contasPoupancas.iterator();
        Iterator<Conta> iterNormal = contasNormais.iterator();

        System.out.println("Contas Especiais: ");
        for(int i = 0; i < contasEspecias.size(); i++){
            ContaEspecial conta = iterEspecial.next();
            System.out.println(conta);
        }

        System.out.println("\nContas Poupancas: ");
        for(int i = 0; i < contasPoupancas.size(); i++){
            ContaPoupanca conta = iterPoupanca.next();
            System.out.println(conta);
        }

        System.out.println("\nContas Normais: ");
        for(int i = 0; i < contasNormais.size(); i++){
            Conta conta = iterNormal.next();
            System.out.println(conta);
        }
        System.out.println("\n");

        mostraQuantidadeDeCadaConta();
        //mostraOsCalculosDeRendimento(&contasPoupancas, iterPoupanca);
    }

    public static void mostraQuantidadeDeCadaConta(){
        System.out.println("Quantidade de Contas Normais: " + qntContaNormal);
        System.out.println("Quantidade de Contas Poupancas: " + qntContaPoupanca);
        System.out.println("Quantidade de Contas Especiais: " + qntContaEspecial);
        System.out.println("\n");
    }

    /*public static void mostraOsCalculosDeRendimento(ArrayList<ContaPoupanca> contasPoupancas, Iterator<ContaPoupanca> iterPoupanca){
        System.out.println("\nContas Poupancas com calculo de rendimento: ");
        for(int i = 0; i < contasPoupancas.size(); i++){
            ContaPoupanca conta = iterPoupanca.next();
            System.out.println(conta.calculaRendimento());
        }
    }*/
}
