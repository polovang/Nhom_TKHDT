package tkhdt;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Than
 */
public class DAO {
	private Connection connection;
	 private static final String URL = "jdbc:sqlserver://DESKTOP-DG8QK26\\NGUYENVANVANG:1433;databaseName=Tkhdt;encrypt=true;trustServerCertificate=true;";
	    private static final String USER = "sa";
	    private static final String PASSWORD = "123456";
	public DAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			if (connection != null) {
				System.out.println("Ket noi thanh cong");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

	}

	public Connection getConnection() {
		return connection;
	}

	public static void main(String[] args) {
		new DAO();
	}

}
