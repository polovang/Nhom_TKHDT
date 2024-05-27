package tkhdt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getId_BN() {
		return id_BN;
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
	public void setId_BN(String id_BN) {
		this.id_BN = id_BN;
	}
	public CapPhatThuoc getCachPhatThuoc() {
		return cachPhatThuoc;
	}
	public void setCachPhatThuoc(CapPhatThuoc cachPhatThuoc) {
		this.cachPhatThuoc = cachPhatThuoc;
	}
	public QuanLyDonThuoc getQuanLyThuoc() {
		return quanLyThuoc;
	}
	public void setQuanLyThuoc(QuanLyDonThuoc quanLyThuoc) {
		this.quanLyThuoc = quanLyThuoc;
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
		Thuoc thuoc = new Thuoc();
	    Connection connection = new DAO().getConnection();
	    try {
	        PreparedStatement st = connection.prepareStatement(
	                "SELECT DonThuoc.*,HoaDon.*,Thuoc.*, (Thuoc.gia*Thuoc.soLuong) AS Thanh Tien " +
	                "FROM BenhNhan" +
	                "JOIN HoaDon on BenhNhan.id = HoaDon.id_BN " +"JOIN DonThuoc on DonThuoc.idDonThuoc=HoaDon.id"+"JOIN Thuoc on Thuoc.maThuoc=DonThuoc.id"+
	                "WHERE BenhNhan.id = ?");
	        st.setString(1, id);
	        ResultSet rs = st.executeQuery();

	        if (rs.next()) {
	        	
	           hd.setId(rs.getString("id"));
	           hd.setId_BN(rs.getString("id_BN"));
	           hd.setNgayThanhToan(rs.getDate("ngayThanhToan"));
	           hd.setNvPhatThuoc(rs.getString("nvPhatThuoc"));
	           hd.getDonThuoc().setIdDonThuoc(rs.getString("idDonThuoc"));
	           hd.getDonThuoc().setIdDonThuoc(rs.getString("idDonThuoc"));
	           thuoc.setTenThuoc(rs.getString("tenThuoc"));
	           thuoc.setMoTa(rs.getString("moTa"));
	           thuoc.setSoLuong(rs.getInt("soLuong"));
	           thuoc.setGia(rs.getFloat("gia"));
	           
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
