package tkhdt;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
	public static void main(String[] args) {
		String connectionURL = "jdbc:sqlserver://DESKTOP-DG8QK26\\NGUYENVANVANG:1433;databaseName=NuocGiaiKhat;user=sa;password=123456;encrypt=true;trustServerCertificate=true";
		try {
			System.out.println("Connecting to the server......");
			try (Connection connection = DriverManager.getConnection(connectionURL)) {
				System.out.println("Connected to the Server.");
			}
		} catch (Exception e) {
			System.out.println("Can not connected to the Server !!!");
			e.printStackTrace();
		}
	}

}
