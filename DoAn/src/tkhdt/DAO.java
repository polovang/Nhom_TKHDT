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

	public DAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-DG8QK26\\NGUYENVANVANG:1433;databaseName=Tkhdt;encrypt=true;trustServerCertificate=true";
			connection = DriverManager.getConnection(url, "sa", "123456");
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
