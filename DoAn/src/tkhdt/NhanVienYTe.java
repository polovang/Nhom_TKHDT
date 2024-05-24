package tkhdt;

import java.util.Date;

public abstract class NhanVienYTe {
   protected String id;
   protected String hoTen;
   protected Date ngaySinh;
   protected int soDThoai;
   protected String khoa;
public NhanVienYTe(String id, String hoTen, Date ngaySinh, int soDThoai, String khoa) {
	super();
	this.id = id;
	this.hoTen = hoTen;
	this.ngaySinh = ngaySinh;
	this.soDThoai = soDThoai;
	this.khoa = khoa;
}
   
}
