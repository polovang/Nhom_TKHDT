package tkhdt;

import java.util.ArrayList;
import java.util.Date;

public class DonThuoc implements QuanLyDonThuoc {
	private String idDonThuoc;
	private ArrayList<Thuoc> dsThuoc;
	private Date ngaykeDon;
	private Bac_Si bacSiKeDon;
	private boolean daDuocPhat;

	public DonThuoc(String idDonThuoc, ArrayList<Thuoc> dsThuoc, Date ngaykeDon, Bac_Si bacSiKeDon,
			boolean daDuocPhat) {
		super();
		this.idDonThuoc = idDonThuoc;
		this.dsThuoc = dsThuoc;
		this.ngaykeDon = ngaykeDon;
		this.bacSiKeDon = bacSiKeDon;
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

	public double tienThuoc() {
		return 0.0;
	}

}
