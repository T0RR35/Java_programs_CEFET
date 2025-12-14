import java.util.*;

public class Main {
    public static void main(String[] args) {
		Conexao conexao = new Conexao();
		List<Pessoa> pessoas = conexao.buscaPessoas();

		for(Pessoa pessoa : pessoas){
			System.out.println(pessoa.toString());
		}

		conexao.fechaConexao();
	}
}
