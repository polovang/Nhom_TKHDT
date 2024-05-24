package tkhdt;

import java.util.Date;

public  class Thuoc {
	private String tenThuoc;
	private String moTa;
	private int soLuong;
    private double gia;
	public Thuoc(String tenThuoc, String moTa, int soLuong, double gia) {
		super();
		this.tenThuoc = tenThuoc;
		this.moTa = moTa;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
     
	

}
