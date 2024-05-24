package tkhdt;


	import java.sql.Connection;
	import java.sql.DriverManager;

	public class ConnectSQL {
		public Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://localhost:1433;databaseName=NuocGiaiKhat;trustServerCertificate=true";
				connection = DriverManager.getConnection(url, "sa", "123456");
				if(connection != null) {
					System.out.println("Ket noi thanh cong");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
			return connection;
		}
		
		public static void main(String[] args) {
			System.out.println();
		}
	}
