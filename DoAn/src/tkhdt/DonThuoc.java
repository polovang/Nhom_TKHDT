package tkhdt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DonThuoc implements QuanLyDonThuoc {
	private String idDonThuoc;
	private List<Thuoc> dsThuoc= new  ArrayList<>();
	private Date ngaykeDon;
	private boolean daDuocPhat;
    
	public String getIdDonThuoc() {
		return idDonThuoc;
	}

	public void setIdDonThuoc(String idDonThuoc) {
		this.idDonThuoc = idDonThuoc;
	}

	public List<Thuoc> getDsThuoc() {
		return dsThuoc;
	}

	public void setDsThuoc(List<Thuoc> dsThuoc) {
		this.dsThuoc = dsThuoc;
	}

	public Date getNgaykeDon() {
		return ngaykeDon;
	}

	public void setNgaykeDon(Date ngaykeDon) {
		this.ngaykeDon = ngaykeDon;
	}

	public boolean isDaDuocPhat() {
		return daDuocPhat;
	}

	public void setDaDuocPhat(boolean daDuocPhat) {
		this.daDuocPhat = daDuocPhat;
	}

	@Override
	public boolean thuocTonTai(int maThuoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void themThuoc(Thuoc thuoc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xoaThuoc(Thuoc thuoc) {
		// TODO Auto-generated method stub

	}



}
