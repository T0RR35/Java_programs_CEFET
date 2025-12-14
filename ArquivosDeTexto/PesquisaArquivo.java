/*import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PesquisaArquivo {
	public static void main(String[] args) {

		for (String entrada : args) {
			try {
				questao1(entrada);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void questao1(String entrada) throws FileNotFoundException {
		File getCSVFiles = new File(entrada);
		Scanner sc = new Scanner(getCSVFiles);
		Scanner scLinha = new Scanner(System.in);
		sc.useDelimiter("\n");
		String token = "", palavraASerProcurada;

		int linha = 1;

		System.out.println("digite uma palavra a ser procurada: ");
		palavraASerProcurada = scLinha.nextLine();

		while (sc.hasNext()) {
			token = sc.nextLine();
			String result[] = token.split(" ");

			for(String palavra : result){
				if (palavraASerProcurada.equals(palavra)) {
					System.out.println("A palavra aparece na linha " + linha);
				}
			}
			linha++;
		}
		sc.close();
		scLinha.close();
	}
}
*/