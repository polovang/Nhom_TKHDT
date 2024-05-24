package view;
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
private 	Connection connection ;
	public  DAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-DG8QK26\\NGUYENVANVANG:1433;databaseName=Tkhdt;encrypt=true;trustServerCertificate=true";
			connection = DriverManager.getConnection(url, "sa", "123456");
			if(connection != null) {
				System.out.println("Ket noi thanh cong");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

	}
    public boolean addStudent(Student s){
        
        String sql = "INSERT INTO tblStudent(ID, name, dob, address, phone, email, mark) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getID());
            ps.setString(2, s.getName());
            ps.setDate(3, new Date(s.getDob().getTime()));
            ps.setString(4, s.getAddress());
            ps.setString(5, s.getPhone());
            ps.setString(6, s.getEmail());
            ps.setFloat(7, s.getMark());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<Student> getListStudent(){
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM tblStudent";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student s = new Student();
                s.setID(rs.getString("ID"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setMark(rs.getFloat("mark"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        new DAO();
    }


}

