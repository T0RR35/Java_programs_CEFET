import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Conexao {

	Connection con;

	public Conexao() {

		// Conexão com o driver JDBC
		String nomeJDBC = "jdbc:mysql://localhost/";
		String nomeUser = "root";
		String password = "";
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(nomeJDBC, nomeUser, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

	public List<Pessoa> buscaPessoas(){
		String sql = "SELECT * FROM pessoal";
		List<Pessoa> lista = new ArrayList<Pessoa>();
		try{
			Statement st = con.createStatement();
			st.executeUpdate("USE " + "bd_pessoal");
			st.execute(sql);

			ResultSet tabela = st.getResultSet();
			while(tabela.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(tabela.getString("nome"));
				pessoa.setEmail(tabela.getString("email"));
				pessoa.setSenha(tabela.getString("senha"));
				pessoa.setCargo(tabela.getString("cargo"));
				pessoa.setTurma(tabela.getString("turma"));
				pessoa.setSetor(tabela.getString("setor"));
				pessoa.setMatricula(tabela.getInt("matricula"));
				lista.add(pessoa);
			}
			st.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return lista;
	}

	public void fechaConexao(){
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
}