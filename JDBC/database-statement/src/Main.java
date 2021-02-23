import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Main {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/test";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Conectando ao banco...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Conexão com sucesso");
			System.out.println("Criando statement...");
			stmt = conn.createStatement();
			String sql_select = "SELECT * FROM mercadoria WHERE nome=?";
			String sql_insert = "INSERT INTO mercadoria VALUES (?,?,?)";
			String sql_update = "UPDATE mercadoria SET quant=?, preco=? WHERE nome=?";
			
			Scanner s = new Scanner(System.in);
			System.out.println("Escolha a opcao");
			System.out.println("1 - Criar mercadoria");
			System.out.println("2 - Atualizar mercadoria");
			System.out.println("3 - Listar por nome");

			int o = s.nextInt();
			switch (o) {
			case 1:
				String sql_insert_mod = sql_insert;
				System.out.println();
				System.out.println();
				System.out.println("Insira o nome da mercadoria");				
				sql_insert_mod = sql_insert_mod.replaceFirst("\\?", "'"+s.next()+"'");
				System.out.println("Insira a quantidade da mercadoria");
				sql_insert_mod = sql_insert_mod.replaceFirst("\\?", s.next());
				System.out.println("Insira o preco da mercadoria");
				sql_insert_mod = sql_insert_mod.replaceFirst("\\?", s.next());
				stmt.executeUpdate(sql_insert_mod);
				break;
			case 2:
				System.out.println();
				System.out.println();
				String sql_update_mod = sql_update;
				System.out.println("Insira a nova quantidade");
				sql_update_mod = sql_update_mod.replaceFirst("\\?", s.next());
				System.out.println("Insira o novo preco");
				sql_update_mod = sql_update_mod.replaceFirst("\\?", s.next());
				System.out.println("Insira o nome a ser atualizado");
				sql_update_mod = sql_update_mod.replaceFirst("\\?", "'"+s.next()+"'");
				stmt.executeUpdate(sql_update_mod);
				break;
			case 3:
				System.out.println();
				System.out.println();
				String sql_select_mod = sql_select;
				System.out.println("Insira o nome a ser pesquisado:");
				sql_select_mod = sql_select_mod.replaceFirst("\\?", "'"+s.next()+"'");
				ResultSet rs = stmt.executeQuery(sql_select_mod);
				System.out.println("RESULTADOS");
				System.out.println("----------------------------------------------------------------");
				while (rs.next()) {
					System.out.println(
							"Nome: " + rs.getString(1) + " Quantidade: " + rs.getInt(2) + " Preco: " + rs.getFloat(3));
				}
				break;
			default:
				System.out.println();
				System.out.println();
				System.out.println("Saindo do programa");
				break;
			
			}
			stmt.close();
			conn.close();
			s.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}