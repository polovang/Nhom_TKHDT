package tkhdt;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BenhVien {
	private static BenhVien uniqueBenhVien;
	private String tenBenhVien;
	private String sdtLienLac;
	private ArrayList<NhanVienYTe> dsNhanVien;
	private DanhSachBenhNhan dsBenhNhan;
	private KhoThuoc khoThuoc;

	public BenhVien(String tenBenhVien, String sdtLienLac, ArrayList<NhanVienYTe> dsNhanVien,
			DanhSachBenhNhan dsBenhNhan, KhoThuoc khoThuoc) {
		super();
		this.tenBenhVien = tenBenhVien;
		this.sdtLienLac = sdtLienLac;
		this.dsNhanVien = dsNhanVien;
		this.dsBenhNhan = dsBenhNhan;
		this.khoThuoc = khoThuoc;
	}

	public BenhVien getBenhVien() {
		return null;

	}

	public void xoaBenhNhan(QuanLyBenhNhan benhNhan) {

	}

	public void themBenhNhan(QuanLyBenhNhan benhNhan) {

	}
}
