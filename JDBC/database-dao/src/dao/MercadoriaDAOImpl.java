package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Mercadoria;

public class MercadoriaDAOImpl implements MercadoriaDAO {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/test";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "root";
	
	static final String INSERT = "INSERT INTO mercadoria (nome, quant, preco) VALUES (?, ?, ?)";
	static final String UPDATE = "UPDATE mercadoria SET quant=?, preco=? where nome=?";
	static final String FIND_BY_NAME = "SELECT * FROM mercadoria WHERE nome=?";
	static final String FIND_ALL = "SELECT * FROM mercadoria";
	
	@Override
	public int create(Mercadoria m) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int ret=0;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, m.getNome());
			pstmt.setInt(2, m.getQuantidade());
			pstmt.setDouble(3, m.getPreco());
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return ret;
	}
	@Override
	public int update(Mercadoria m) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int ret=0;
		try {
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setInt(1, m.getQuantidade());
			pstmt.setDouble(2, m.getPreco());
			pstmt.setString(3, m.getNome());
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return ret;
	}
	@Override
	public Mercadoria findByName(String nome) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		Mercadoria m = null;
		
		try {
			pstmt = conn.prepareStatement(FIND_BY_NAME);
			pstmt.setString(1, nome);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				m = new Mercadoria();
				m.setNome(rs.getString(1));
				m.setQuantidade(rs.getInt(2));
				m.setPreco(rs.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return m;
	}
	@Override
	public List<Mercadoria> findAll() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		List<Mercadoria> l = new ArrayList<Mercadoria>();
		
		try {
			pstmt = conn.prepareStatement(FIND_ALL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Mercadoria m = new Mercadoria();
				m.setNome(rs.getString(1));
				m.setQuantidade(rs.getInt(2));
				m.setPreco(rs.getDouble(3));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return l;
	}
	
	Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(
					DB_URL,USER,PASS);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	void close (Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	void close (Statement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
