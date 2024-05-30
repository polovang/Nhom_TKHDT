package tkhdt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDon {
	private String id_BN;
	private String id;
	private Date ngayThanhToan;
	private String nvPhatThuoc;
	private CapPhatThuoc cachPhatThuoc;
	private QuanLyDonThuoc quanLyThuoc;
	private DonThuoc donThuoc;
	private Object thuoc;
	

	public String getId_BN() {
		return id_BN;
	}
	public void setId_BN(String id_BN) {
		this.id_BN = id_BN;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}
	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	public String getNvPhatThuoc() {
		return nvPhatThuoc;
	}
	public void setNvPhatThuoc(String nvPhatThuoc) {
		this.nvPhatThuoc = nvPhatThuoc;
	}
	
	public DonThuoc getDonThuoc() {
		return donThuoc;
	}
	public void setDonThuoc(DonThuoc donThuoc) {
		this.donThuoc = donThuoc;
	}
	public float tongTienThuoc() { 
		float re = 0;
		for(Thuoc thuoc : donThuoc.getDsThuoc()) {
			re+=thuoc.tienThuoc();
		}
		return re+re*(this.cachPhatThuoc.phuPhi());
	}
	public HoaDon inHoaDon(String id) {
	    HoaDon hd = new HoaDon();
	    Connection connection = new DAO().getConnection();
	    try {
	    	PreparedStatement st = connection.prepareStatement(
	    		    "SELECT Hoa_Don.*, C_Thuoc.tenThuoc, C_Thuoc.moTa, C_Thuoc.soLuong, C_Thuoc.gia, BenhNhan.ten " +
	    		    "FROM BenhNhan " +
	    		    "JOIN Hoa_Don ON BenhNhan.id = Hoa_Don.id_BN " +
	    		    "JOIN Don_Thuoc ON Don_Thuoc.idDonThuoc = Hoa_Don.id " +
	    		    "JOIN C_Thuoc ON C_Thuoc.maThuoc = Don_Thuoc.id " +
	    		    "WHERE BenhNhan.id = ?");

	        st.setString(1, id);
	        ResultSet rs = st.executeQuery();

	        if (rs.next()) {
	            hd.setId(rs.getString("id"));
	            hd.setId_BN(rs.getString("id_BN"));
	            hd.setNgayThanhToan(rs.getDate("ngayThanhToan"));
	            hd.setNvPhatThuoc(rs.getString("nvPhatThuoc"));

	        
	            if (hd.getDonThuoc() == null) {
	                hd.setDonThuoc(new DonThuoc());
	            }
	            List<Thuoc> dsThuoc = new ArrayList<>();
	          
	            do {
	                Thuoc thuoc = new Thuoc();
	                thuoc.setTenThuoc(rs.getString("tenThuoc"));
	                thuoc.setMoTa(rs.getString("moTa"));
	                thuoc.setSoLuong(rs.getInt("soLuong"));
	                thuoc.setGia(rs.getFloat("gia"));
	                dsThuoc.add(thuoc);
	            } while (rs.next()); 

	           
	            hd.getDonThuoc().setDsThuoc(dsThuoc);

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
	    return hd;
	}


	

}
