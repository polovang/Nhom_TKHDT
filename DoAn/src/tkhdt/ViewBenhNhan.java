/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkhdt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Than
 */
public class ViewBenhNhan extends javax.swing.JFrame {

	private ArrayList<BenhNhan> list;
	DefaultTableModel model;
	private JMenu capthuoc, trangchu, quanli, laplich, dangxuat;
    private JMenuItem thongTinBenhAn;
	/**
	 * Creates new form StudentView
	 */
	public ViewBenhNhan() {
		initComponents();
		this.setLocationRelativeTo(null);
		list = new BenhVien().getListBenhNhan();
		model = (DefaultTableModel) jTable1.getModel();

		model.setColumnIdentifiers(
				new Object[] { "STT", "ID", "Tên Bệnh Nhân", "Ngày Sinh", "SĐT", "Gioi Tinh"});

		showTable();
	}


	public void showTable() {
		for (BenhNhan b : list) {
			model.addRow(new Object[] { i++, b.getId(),b.getTen(),b.getNgaySinh(),b.getSdt(),b.getGioiTinh() });
		}
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(trangchu = new JMenu("Trang Chủ"));
		bar.add(quanli = new JMenu("Quan Li Thong Tin"));
		quanli.add(thongTinBenhAn=new JMenuItem("Thông Tin Bệnh Án"));
		bar.add(laplich = new JMenu("Lap Lich Kham"));
		bar.add(capthuoc = new JMenu("Cap Phat Thuoc"));
		bar.add(dangxuat = new JMenu("Dang Xuat"));
		texId = new javax.swing.JTextField();
		texTen = new javax.swing.JTextField();
		texNgaySinh = new javax.swing.JTextField();
		texSDT = new javax.swing.JTextField();
		texGioiTinh = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("HỆ THỐNG QUẢN LÝ BỆNH NHÂN VÀ PHÁT THUỐC");

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
		jLabel1.setText("QUAN LÝ THÔNG TIN BỆNH NHÂN");

		jLabel2.setText("ID");

		jLabel3.setText("Tên Bệnh Nhân: ");

		jLabel4.setText("Ngày Sinh: ");

		jLabel5.setText("SĐT: ");

		jLabel6.setText("Gioi Tinh: ");

		jButton1.setText("THÊM");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton2.setText("CẬP NHẬP");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton3.setText("XÓA");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		thongTinBenhAn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {

		}));
	
		jScrollPane1.setViewportView(jTable1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
		    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(layout.createSequentialGroup()
		            .addContainerGap()
		            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addGroup(layout.createSequentialGroup().addGap(44, 44, 44)
		                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                        .addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel4)
		                        .addComponent(jLabel5).addComponent(jLabel6))
		                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                        .addComponent(texId).addComponent(texTen).addComponent(texNgaySinh)
		                        .addComponent(texSDT).addComponent(texGioiTinh,javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                .addGroup(layout.createSequentialGroup().addGap(53, 53, 53).addComponent(jButton1)
		                    .addGap(38, 38, 38).addComponent(jButton2).addGap(38, 38, 38).addComponent(jButton3,
		                        javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
		            .addGap(18, 18, 18)
		            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
		            .addContainerGap())
		        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
		            layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jLabel1,
		                javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addGap(360, 360, 360))
		);
		layout.setVerticalGroup(
		    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(18, 18, 18)
		            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
		                .createSequentialGroup()
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel2).addComponent(texId, javax.swing.GroupLayout.PREFERRED_SIZE,
		                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addGap(18, 18, 18)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel3).addComponent(texTen, javax.swing.GroupLayout.PREFERRED_SIZE,
		                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addGap(18, 18, 18)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel4).addComponent(texNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
		                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addGap(18, 18, 18)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel5).addComponent(texSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
		                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addGap(18, 18, 18)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jLabel6).addComponent(texGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
		                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
		                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(jButton1).addComponent(jButton3))
		                .addComponent(jButton2).addGap(73, 73, 73))
		                .addGroup(layout.createSequentialGroup()
		                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390,
		                        javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addContainerGap(54, Short.MAX_VALUE)))));

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		texId.setText("");
		texTen.setText("");
		texNgaySinh.setText("");
		texSDT.setText("");
		texGioiTinh.setText("");
		
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		BenhNhan b = new BenhNhan();
		b.setId(texId.getText());
		b.setTen(texTen.getText());
		b.setSdt(texNgaySinh.getText());
		b.setGioiTinh(texGioiTinh.getText());
		try {
			b.setNgaySinh(new SimpleDateFormat("dd/MM/yyyy").parse(texNgaySinh.getText()));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
     if (new BenhVien().addBenhNhan(b)) {
			JOptionPane.showMessageDialog(rootPane, "Add Success!");
			list.add(b); 
		} else {
			JOptionPane.showMessageDialog(rootPane, "Student's ID cannot be duplicated!");
		}
		showResult();
	}

	int i = 1;

	public void showResult() {
		BenhNhan b = list.get(list.size() - 1);
		model.addRow(new Object[] { i++, b.getId(),b.getTen(),b.getNgaySinh(),b.getSdt(),b.getGioiTinh() });
	}


private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
	int select =jTable1.getSelectedRow();
String iD = list.get(select).getId();
	if(select>=0) {
		model.removeRow(select);
BenhVien benhVien = new BenhVien();
benhVien.DeleteRow(iD);
		list.remove(select);

	}else {
		JOptionPane.showMessageDialog(rootPane, "Vui Lòng Chọn !");
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
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ViewBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ViewBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ViewBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ViewBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ViewBenhNhan().setVisible(true);
			}
		});
	}
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField texId;
	private javax.swing.JTextField texTen;
	private javax.swing.JTextField texNgaySinh;
	private javax.swing.JTextField texSDT;
	private javax.swing.JTextField texGioiTinh;
	//Benh An
	private void thongTinBenhAn(java.awt.event.ActionEvent evt) {
		
	}

}
