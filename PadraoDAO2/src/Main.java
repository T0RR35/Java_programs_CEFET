import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String[]> dados = Conexao.carregarDados("tabela.csv");

        TabelaGUI janela = new TabelaGUI(dados);
        janela.setVisible(true);

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        int index = 0;

        for (String[] dado : dados) {
            Pessoa pessoa = new Pessoa();
            pessoa.setMatricula(Integer.valueOf(dado[0]));
            pessoa.setNome(dado[1]);
            pessoa.setEmail(dado[2]);
            pessoa.setSenha(dado[3]);
            pessoa.setCargo(dado[4]);
            if (dado[5] != null)
                pessoa.setTurma(dado[5]);
            if (dado[6] != null)
                pessoa.setTurma(dado[6]);
            pessoas.add(pessoa);
        }

        while(janela.isActive()){
            index = janela.mostrarDado(pessoas.get(index));
        }
    }
}
