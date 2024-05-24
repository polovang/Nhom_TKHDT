package tkhdt;

import java.util.Date;

public class Bac_Si extends NhanVienYTe {
	private int namKinhNghiem;

	public Bac_Si(String id, String hoTen, Date ngaySinh, int soDThoai, String khoa, int namKinhNghiem) {
		super(id, hoTen, ngaySinh, soDThoai, khoa);
		this.namKinhNghiem = namKinhNghiem;
	}

}
