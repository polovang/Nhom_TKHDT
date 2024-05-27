package tkhdt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BenhNhan {
	private String id;
	private String ten;
	private Date ngaysinh;
	private String sdt;
	private String gioiTinh;
	private ArrayList<BenhAn> dsBenhAn;
	private ArrayList<HoaDon> dsHoaDon;
	private Loai_Benh_Nhan loaiBenhNhan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaySinh() {
		return ngaysinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaysinh = ngaySinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public BenhAn kiemTranBenhAn(String id) {
	    BenhAn an = new BenhAn();
	    Connection connection = new DAO().getConnection();
	    try {
	        PreparedStatement st = connection.prepareStatement(
	                "SELECT BenhNhan.id, BenhAn.nguoiThamKham, BenhAn.ngayKham, BenhAn.tenBenh " +
	                "FROM BenhNhan " +
	                "JOIN BenhAn on BenhNhan.id = BenhAn.id " +
	                "WHERE BenhNhan.id = ?");
	        st.setString(1, id);
	        ResultSet rs = st.executeQuery();

	        if (rs.next()) {
	             an.setId(rs.getString("id"));
	            an.setNguoiThamKham(rs.getString("nguoiThamKham"));
	            an.setNgayKham(rs.getDate("ngayKham"));
	            an.setTenBenh(rs.getString("tenBenh"));
	               } 
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    } finally {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return an;
	}
	public void themBenhAn(String id, String tenBenh) {
	    Connection connection = new DAO().getConnection();
	    try {
	        // First, get the existing list of disease names
	        PreparedStatement st1 = connection.prepareStatement(
	                "SELECT tenBenh FROM BenhAn WHERE id = ?");
	        st1.setString(1, id);
	        ResultSet rs = st1.executeQuery();
	        String existingNames = "";
	        if (rs.next()) {
	            existingNames = rs.getString("tenBenh");
	        }

	        // Append the new disease name to the existing list
	        String newNames = existingNames + ", " + tenBenh;

	        // Update the database with the new list of disease names
	        PreparedStatement st2 = connection.prepareStatement(
	                "UPDATE BenhAn SET tenBenh = ? WHERE id = ?");
	        st2.setString(1, newNames);
	        st2.setString(2, id);
	        st2.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e);
	    } finally {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

}     
	
