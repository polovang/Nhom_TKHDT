package tkhdt;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ViewBenhAn extends javax.swing.JFrame {

    private ArrayList<BenhAn> list;
    private DefaultTableModel model;

    public ViewBenhAn() {
        initComponents();
        setLocationRelativeTo(null);

        model = (DefaultTableModel) jTable1.getModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Người Thăm Khám", "Ngày Khám", "Tên Bệnh"});
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HỆ THỐNG QUẢN LÝ BỆNH NHÂN VÀ PHÁT THUỐC");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("THÔNG TIN BỆNH ÁN");

        jLabel2.setText("ID");

        jLabel3.setText("Tên Bệnh Án: ");

        jButton1.setText("KIỂM TRA");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jButton2.setText("CẬP NHẬP");
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Người Thăm Khám", "Ngày Khám", "Tên Bệnh"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                            
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(texId)
                            .addComponent(texTen, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton1)
                        .addGap(38, 38, 38)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(360, 360, 360)));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(texId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(texTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
       
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(54, Short.MAX_VALUE))))
        );

        pack();

         }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String id =texId.getText();
        String ten = texTen.getText();
       new BenhNhan().themBenhAn(id, ten);
       texId.setText("");
       texTen.setText("");
       model.setRowCount(0);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       String id = texId.getText();
       BenhNhan benhNhan = new BenhNhan();
       BenhAn an =benhNhan.kiemTranBenhAn(id);
       if(an!=null) {
    	   model.setRowCount(0);
    	   Object[] rowData = {an.getId(),an.getNguoiThamKham(),an.getNgayKham(),an.getTenBenh()};
           model.addRow(rowData);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBenhNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new ViewBenhAn().setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField texId;
    private javax.swing.JTextField texTen;
}
