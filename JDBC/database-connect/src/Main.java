import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



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
			System.out.println();
			System.out.println();
			ResultSet rs = stmt.executeQuery("SELECT * FROM mercadoria");
			System.out.println("RESULTADOS");
			System.out.println("----------------------------------------------------------------");
			while (rs.next()) {
				System.out.println(
						"Nome: " + rs.getString(1) + " Quantidade: " + rs.getInt(2) + " Preco: " + rs.getFloat(3));
			}
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}