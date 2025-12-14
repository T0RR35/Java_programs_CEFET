import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoMaisSimples{

	public ConexaoMaisSimples() throws FileNotFoundException{
		
		// Conexão com o driver JDBC
		String nomeJDBC = "jdbc:mysql://localhost/discdb";
		String configTimeZone = "?useTimezone=true&serverTimezone=UTC";
		String nomeUser = "root";
		String password = "";

		try {
		
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver"); 

		Connection con = 
			DriverManager.getConnection(nomeJDBC+configTimeZone, nomeUser, password);

		// Acessa um banco de dados específico.
		Statement st = con.createStatement();
		st.executeUpdate("USE " + "discdb");

		// Faz a consulta SQL
		String pedido = "select musica.Titulo, artista.Nome from musica\n" + //
						"join faixa on musica.CodMus = faixa.CodMus\n" + //
						"join disco on faixa.CodDisco = disco.CodDisco\n" + //
						"join artista on disco.CodArt = artista.CodArt;";
		
		ResultSet rs = st.executeQuery(pedido);

		// Mostra os resultados da consulta
		int numeroLinhas = 1;

		FileOutputStream out = new FileOutputStream("MusicasEartistas.txt");
		PrintStream ps = new PrintStream(out);

		while (rs.next()) {
			System.out.println("REGISTRO: " + numeroLinhas );

			System.out.print("\nMusica: ");
			System.out.println(rs.getString("Titulo"));
			
			System.out.print("Autor: ");
			System.out.println(rs.getString("Nome"));	
			

			ps.println("REGISTRO: " + numeroLinhas );
			ps.println("\nMusica: ");
			ps.println(rs.getString("Titulo"));
			ps.println("Autor: ");
			ps.println(rs.getString("Nome"));

			numeroLinhas++;
		}
		ps.close();
		
		/*	
		String sql = "Insert INTO Pensamentos(Texto, Autor) "
				+ "VALUES ('Penso, logo sei isso!', 'Eu');";		
		
		int linhasAlteradas = st.executeUpdate(sql);

		System.out.println(linhasAlteradas);
	 	*/
		st.close();
		con.close();
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}

	}

	public static void main(String[] args) {
		try{
			new ConexaoMaisSimples();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

}
