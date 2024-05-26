package tkhdt;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class BenhVien {
	private static BenhVien uniqueBenhVien;
	private String tenBenhVien;
	private String sdtLienLac;
	private ArrayList<NhanVienYTe> dsNhanVien;
	private DanhSachBenhNhan dsBenhNhan;
	private KhoThuoc khoThuoc;

	private DAO dao= new DAO();


public boolean addBenhNhan(BenhNhan b){
	        
	        String sql = "INSERT INTO BenhNhan(id,ten,ngaysinh,sdt,gioiTinh) "
	                + "VALUES(?,?,?,?,?)";
	        try {
	            PreparedStatement ps = dao.getConnection().prepareStatement(sql);
	            ps.setString(1, b.getId());
	            ps.setString(2, b.getTen());
	            ps.setDate(3, new Date(b.getNgaySinh().getTime()));
	            ps.setString(4, b.getSdt());
	            ps.setString(5, b.getGioiTinh());
	            return ps.executeUpdate() > 0;
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return false;
	    }

public static void DeleteRow(String Id) {
	Connection connection = new DAO().getConnection();
    try {  
        PreparedStatement st = connection.prepareStatement("DELETE FROM BenhNhan WHERE ID = ?");
        st.setString(1,Id);
        st.executeUpdate(); 
    } catch(Exception e) {
        System.out.println(e);
    }
}

	    
	    public ArrayList<BenhNhan> getListBenhNhan(){
	        ArrayList<BenhNhan> list = new ArrayList<>();
	        String sql = "SELECT * FROM BenhNhan";
	             try {
	            PreparedStatement ps = dao.getConnection().prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next())  {
	                BenhNhan benhNhan = new BenhNhan();
	                benhNhan.setId(rs.getString("id"));
	                benhNhan.setTen(rs.getString("ten"));
	                benhNhan.setNgaySinh(rs.getDate("ngaysinh"));
	                benhNhan.setSdt(rs.getString("sdt"));
	                benhNhan.setGioiTinh("gioiTinh");
	                list.add(benhNhan);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	         return list;
	    }

}
