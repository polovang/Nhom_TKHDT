package tkhdt;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewHoaDon extends javax.swing.JFrame {

	private ArrayList<BenhAn> list;
	private DefaultTableModel model;

	public ViewHoaDon() {
		initComponents();
		setLocationRelativeTo(null);

		model = (DefaultTableModel) jTable1.getModel();
		model.setColumnIdentifiers(new Object[] { "STT","Tên Thuốc", "Mô Tả", "Số Lượng", "Giá", "Thành Tiền" });
	}

	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(new JMenu("Trang Chủ"));
		bar.add(new JMenu("Quản Lí Thông Tin")).add(new JMenuItem("Thông Tin Bệnh Án"));
		bar.add(new JMenu("Lập Lịch Khám"));
		bar.add(new JMenu("Cấp Phát Thuốc"));
		bar.add(new JMenu("Đăng Xuất"));
		texId = new javax.swing.JTextField();
		texTen = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("HỆ THỐNG QUẢN LÝ BỆNH NHÂN VÀ PHÁT THUỐC");

	

		jLabel2.setText("ID");

		jLabel3.setText("Mã Hóa Đơn: ");
		jLabel4.setText("");
		
		jLabel5.setText("ID Bệnh Nhân: ");
		jLabel6.setText("");
		
		jLabel7.setText("Ngày Thanh Toán: ");
		jLabel8.setText("");
		
		jLabel9.setText("Người Phát Thuốc: ");
		jLabel10.setText("");

		jButton1.setText("Tra Cứu");
		jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Người Thăm Khám", "Ngày Khám", "Tên Bệnh" }));
		jScrollPane1.setViewportView(jTable1);

		JPanel jPanelp = new JPanel(new BorderLayout());
		JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jPanel.add(jLabel2);
		jPanel.add(texId = new JTextField(20));
		jPanel.add(jButton1);
		jPanelp.add(jPanel, BorderLayout.NORTH);

		JPanel jPanel_ = new JPanel(new BorderLayout());
		jPanel_.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Hóa Đơn"));
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new GridLayout(4,2));
		jPanel1.add(jLabel3);
		jPanel1.add(jLabel4);
		jPanel1.add(jLabel5);
		jPanel1.add(jLabel6);
		jPanel1.add(jLabel7);
		jPanel1.add(jLabel8);
		jPanel1.add(jLabel9);
		jPanel1.add(jLabel10);
		jLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel6.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel8.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
		jPanel_.add(jPanel1, BorderLayout.NORTH);

		JScrollPane jScrollPane = new JScrollPane(jTable1);
		jPanel_.add(jScrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel(new GridLayout(1,2));
		panel.add(jLabel11= new JLabel("Thành Tiền:"));
		panel.add(texTT= new JTextField(5));
		texTT.setEditable(false);
		jPanel_.add(panel, BorderLayout.SOUTH);
		jPanelp.add(jPanel_, BorderLayout.CENTER);
	
		add(jPanelp, BorderLayout.CENTER);

		setSize(new Dimension(700, 500));
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	    String id = texId.getText();
	    if (id.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập ID");
	        return;
	    }
	    
	    DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); 
	    model.setRowCount(0); 
	    
	    HoaDon hoaDon = new HoaDon();
	    HoaDon don = hoaDon.inHoaDon(id);
	    if (don != null) {
	    	jLabel4.setText(don.getId());
	    	jLabel6.setText(don.getId_BN());
	    	jLabel10.setText(don.getNvPhatThuoc());
	    
	    	
	    	String reAsString = String.valueOf(don.getTongTienHoaDon());
	    	texTT.setText(reAsString+" VND");

	    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd//MM/yyyy");
	    	jLabel8.setText(dateFormat.format(don.getNgayThanhToan()));
	        int i = 1;
	        for (Thuoc thuoc : don.getDonThuoc().getDsThuoc()) {
	            Object[] rowData = {i++, thuoc.getTenThuoc(), thuoc.getMoTa(), thuoc.getSoLuong(), thuoc.getGia(),thuoc.tienThuoc()};
	            model.addRow(rowData); 
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn với ID: " + id);
	    }
	}


	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ViewBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(() -> new ViewHoaDon().setVisible(true));
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField texId;
	private javax.swing.JTextField texTen;
	private javax.swing.JTextField texTT;

}
