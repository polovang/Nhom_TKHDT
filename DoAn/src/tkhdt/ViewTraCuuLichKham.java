
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkhdt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Than
 */
public class ViewTraCuuLichKham extends javax.swing.JFrame {

	private ArrayList<BenhAn> list;
	DefaultTableModel model;
	private JMenu capthuoc, trangchu, quanli, laplich, dangxuat;
	private JMenuItem thongTinBenhAn;

	/**
	 * Creates new form StudentView
	 */
	public ViewTraCuuLichKham() {
		initComponents();
		this.setLocationRelativeTo(null);
		list = new ArrayList<BenhAn>();
		model = (DefaultTableModel) jTable1.getModel();

		model = (DefaultTableModel) jTable1.getModel();
		model.setColumnIdentifiers(new Object[] { "STT","Tên Thuốc", "Mô Tả", "Số Lượng", "Giá", "Thành Tiền" });
	}

	public void createGUI() {
		JPanel jPanel = new JPanel();
		this.add(jPanel);
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel("Thông Tin Bệnh Án", JLabel.CENTER);
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(trangchu = new JMenu("Trang Chủ"));
		bar.add(quanli = new JMenu("Quan Li Thong Tin"));
		quanli.add(thongTinBenhAn = new JMenuItem("Thông Tin Bệnh Án"));
		bar.add(laplich = new JMenu("Lap Lich Kham"));
		bar.add(capthuoc = new JMenu("Cap Phat Thuoc"));
		bar.add(dangxuat = new JMenu("Dang Xuat"));
		textIdBacSi = new javax.swing.JTextField(15);

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("HỆ THỐNG QUẢN LÝ BỆNH NHÂN VÀ PHÁT THUỐC");

		jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 16));
		jLabel2.setText("ID bệnh nhân: ");
		jButton1.setText("Tìm Kiếm");
		jButton3 = new JButton();

		jButton3.setText("Cập Nhật");
		jLabel3 = new JLabel("ID Bác Sĩ:       ");
		JTextField field = new JTextField(15);
		jButton2 = new JButton("Tìm kiếm");
		JPanel jpanel = new JPanel(new FlowLayout());
		jpanel.add(jLabel3);
		jpanel.add(field);
		jpanel.add(jButton2);

		

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {

		}));

		jScrollPane1.setViewportView(jTable1);
		jScrollPane1.setPreferredSize(new Dimension(600, 300));

		JPanel searchPanel = new JPanel();
		searchPanel.setPreferredSize(new Dimension(100, 50));

		JPanel jPanel1 = new JPanel(new GridLayout(4, 1));
		jPanel1.add(jLabel1);
		jPanel1.add(searchPanel);
		this.add(jPanel1, BorderLayout.NORTH);
		jPanel1.add(jpanel);
		JPanel jPanel2 = new JPanel();
		jPanel2.add(jButton3);
		jPanel1.add(jPanel2);

		searchPanel.add(jLabel2);
		searchPanel.add(textIdBacSi);
		searchPanel.add(jButton1);

		this.add(jScrollPane1);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();

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
			java.util.logging.Logger.getLogger(ViewTraCuuLichKham.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ViewTraCuuLichKham.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ViewTraCuuLichKham.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ViewTraCuuLichKham.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ViewTraCuuLichKham().setVisible(true);
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
	private javax.swing.JTextField textIdBenhNhan;
	private javax.swing.JTextField textTenBenhNhan;
	private javax.swing.JTextField textIdBacSi;
	private javax.swing.JTextField texSDT;
	private javax.swing.JTextField textTenBacSi;

}

