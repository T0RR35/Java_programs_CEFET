import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SubstituiPalavra {
	public static void main(String[] args) {

    if (args.length == 0) {
        System.out.println("Nenhum arquivo passado como argumento!");
        return;
    }
		for (String entrada : args) {
            
			try {
				questao2(entrada);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void questao2(String entrada) throws FileNotFoundException {
        File arquivoEntrada = new File(entrada);
        Scanner scArquivo = new Scanner(arquivoEntrada);
        Scanner scTeclado = new Scanner(System.in);

        System.out.print("Digite a palavra a ser trocada: ");
        String palavraParaTrocar = scTeclado.nextLine();

        System.out.print("Digite a palavra substituta: ");
        String palavraSubstituta = scTeclado.nextLine();

		ArrayList<String> linhas = new ArrayList<>();

        while (scArquivo.hasNextLine()) {
            String linha = scArquivo.nextLine();
            String[] palavras = linha.split(" ");

            for (int i = 0; i < palavras.length; i++) {
                if (palavras[i].equals(palavraParaTrocar)) {
                    palavras[i] = palavraSubstituta;
                }
            }

            linhas.add(String.join(" ", palavras));
        }

		scArquivo.close();
        scTeclado.close();

		FileOutputStream out = new FileOutputStream("assets/Texte.txt");
		PrintStream ps = new PrintStream(out);

		for (String linha : linhas) {
			ps.println(linha);
		}

        ps.close();
	}
}
