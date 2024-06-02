package tkhdt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ViewBenhAn extends javax.swing.JFrame {

	private ArrayList<BenhAn> list;
	private DefaultTableModel model;

	public ViewBenhAn() {
		initComponents();
		setLocationRelativeTo(null);
         setSize(900,400);
		model = (DefaultTableModel) jTable1.getModel();
		model.setColumnIdentifiers(new Object[] {  "ID", "Người Thăm Khám", "Ngày Khám", "Tên Bệnh"});
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

	


		jButton1.setText("Tra Cứu");
		jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Người Thăm Khám", "Ngày Khám", "Tên Bệnh" }));
		jScrollPane1.setViewportView(jTable1);

		JPanel jPanelp = new JPanel(new BorderLayout());
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(2,1));
		JPanel panel =new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.add(jLabel1= new JLabel("ID Bệnh Nhân:"));
		panel.add(texId = new JTextField(10));
		panel.add(jButton1= new JButton("Kiểm Tra"));

		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel2.add(jLabel2= new JLabel("Tên Bệnh Nhân:"));
	    panel2.add(texTen = new JTextField(10));
		panel2.add(jButton2= new JButton("Cập Nhập"));
		jPanel.add(panel);
		jPanel.add(panel2);
		jPanelp.add(jPanel, BorderLayout.NORTH);
       
		JPanel jPanel_ = new JPanel(new BorderLayout());
		jPanel_.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông Tin Bệnh Án"));
		JScrollPane jScrollPane = new JScrollPane(jTable1);
		jPanel_.add(jScrollPane, BorderLayout.CENTER);
		jPanelp.add(jPanel_,BorderLayout.CENTER);
	   add(jPanelp);
		
		

		setSize(new Dimension(700, 500));
		jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
		jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		String id = texId.getText();
		String ten = texTen.getText();
		new BenhNhan().themBenhAn(id, ten);
		texId.setText("");
		texTen.setText("");
		model.setRowCount(0);
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
		java.awt.EventQueue.invokeLater(() -> new ViewBenhAn().setVisible(true));
	}
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
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
	private javax.swing.JTextField texTenBenh;
	}
