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
	private String loaiPhatThuoc;

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

	public String getLoaiPhatThuoc() {
		return loaiPhatThuoc;
	}

	public void setLoaiPhatThuoc(String b) {
		this.loaiPhatThuoc = b;
	}

	public float tongTienThuoc() {
		float re = 0;
		if (cachPhatThuoc != null && donThuoc != null && donThuoc.getDsThuoc() != null) {
			for (Thuoc thuoc : donThuoc.getDsThuoc()) {
				re += thuoc.tienThuoc();
			}
			return re ;
		} else {

			return 0;
		}
	}

	public HoaDon inHoaDon(String id) {
		HoaDon hd = new HoaDon();
		Connection connection = new DAO().getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(
					"SELECT Hoa_Don.*, C_Thuoc.tenThuoc, C_Thuoc.moTa, C_Thuoc.soLuong, C_Thuoc.gia, BenhNhan.ten, (C_Thuoc.soLuong*C_Thuoc.gia)"
							+ "FROM BenhNhan " + "JOIN Hoa_Don ON BenhNhan.id = Hoa_Don.id_BN "
							+ "JOIN Don_Thuoc ON Don_Thuoc.idDonThuoc = Hoa_Don.id "
							+ "JOIN C_Thuoc ON C_Thuoc.maThuoc = Don_Thuoc.id " + "WHERE BenhNhan.id = ?");
			PreparedStatement st2 = connection.prepareStatement(
					"SELECT C_Thuoc.maThuoc,  SUM(C_Thuoc.soLuong * C_Thuoc.gia * (1 - Don_Thuoc.GiamGia))"
							+ "FROM BenhNhan " + "JOIN Hoa_Don ON BenhNhan.id = Hoa_Don.id_BN "
							+ "JOIN Don_Thuoc ON Don_Thuoc.idDonThuoc = Hoa_Don.id "
							+ "JOIN C_Thuoc ON C_Thuoc.maThuoc = Don_Thuoc.id " + "WHERE BenhNhan.id = ?"
							+ "Group by C_Thuoc.maThuoc");
			st.setString(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				hd.setId(rs.getString("id"));
				hd.setId_BN(rs.getString("id_BN"));
				hd.setNgayThanhToan(rs.getDate("ngayThanhToan"));
				hd.setNvPhatThuoc(rs.getString("nvPhatThuoc"));
                hd.setLoaiPhatThuoc(rs.getString("loaiPhatThuoc"));
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
					thuoc.tienThuoc();

					dsThuoc.add(thuoc);
					//hd.tongTienThuoc();
				} while (rs.next());

				hd.getDonThuoc().setDsThuoc(dsThuoc);
                float re =0;
                if(getLoaiPhatThuoc().equals("Buu Dien")) {
                	  re=  (float) (hd.tongTienThuoc() +hd.tongTienThuoc()*0.3);
                }
                
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
