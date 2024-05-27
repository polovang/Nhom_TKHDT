package tkhdt;

import java.awt.*;
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
		model.setColumnIdentifiers(new Object[] { "Tên Thuốc", "Mô Tả", "Số Lượng", "Giá" });
	}

	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
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

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
		jLabel1.setText("THÔNG TIN BỆNH ÁN");

		jLabel2.setText("ID");

		jLabel3.setText("Tên Bệnh Án: ");
		jLabel4.setText("NGUYEN VAN VANG");

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
		JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
		jPanel1.add(jLabel3);
		jPanel1.add(jLabel4);
		jPanel_.add(jPanel1, BorderLayout.NORTH);

		JScrollPane jScrollPane = new JScrollPane(jTable1);
		jPanel_.add(jScrollPane, BorderLayout.CENTER);

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
		BenhNhan benhNhan = new BenhNhan();
		BenhAn an = benhNhan.kiemTranBenhAn(id);
		List<BenhNhan> ds = BenhVien.getListBenhNhan();
		for (BenhNhan nhan : ds) {
			if (id.equals(nhan.getId()) && an != null) {
				model.setRowCount(0);
				Object[] rowData = { an.getId(), an.getNguoiThamKham(), an.getNgayKham(), an.getTenBenh() };
				model.addRow(rowData);
				break;
			}
			JOptionPane.showMessageDialog(this, "Không tìm thấy bệnh án với ID: " + id);
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
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField texId;
	private javax.swing.JTextField texTen;
}
