package tkhdt;

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
	
	

}
