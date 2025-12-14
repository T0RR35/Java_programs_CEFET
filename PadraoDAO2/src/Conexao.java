import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public abstract class Conexao {
    public static ArrayList<String[]> carregarDados(String caminho) {
		ArrayList<String[]> lista = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(caminho)))) {
			String linha;
			br.readLine(); // Pular o cabeÃ¯Â¿Â½alho
			while ((linha = br.readLine()) != null) {
				lista.add(linha.split(";",-1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}

    public static void salvarDados(String caminho, ArrayList<String[]> dados) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(caminho)))) {
			bw.write("matricula;nome;email;senha;cargo;turma;setor\n");
			for (String[] dado : dados) {
				bw.write(String.join(";", dado));
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
