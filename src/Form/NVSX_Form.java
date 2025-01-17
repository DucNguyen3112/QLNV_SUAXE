/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import static Form.LeTanform.traVeTenDichVu;
import Form.Xuli.KetNoiDB;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author StarScream
 */
public class NVSX_Form extends javax.swing.JFrame {

    /** Creates new form NVSX_Form */
    public static String dataSuaDichVu = "", dataHoanThanhDichVu = "";

    public NVSX_Form() {
        initComponents();
        setLocationRelativeTo(null);
        lbTenNVSX.setText(LoginForm.ten);
        loadDataPhanCong();
        loadDataHoanThanh();
    }

    public static String traVeDongXe(String bienSoXe) {
        String sql = "select HieuXe from Xe where BienSoXe = '" + bienSoXe + "'";
        Connection ketNoi = KetNoiDB.getConnection();
        String tamp = null;
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tamp = rs.getString("HieuXe");
            }
            st.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException e) {
        }
        return tamp;
    }

    public void loadDataPhanCong() {
        //them ma nhan vien vao
        String sql = "select BienSoXe, MaDV,NgayGiolamDV,NgayGioHT,MoTa from CT_SDDV where MaNV = '"+LoginForm.MaNV+"'";
        Connection ketNoi = KetNoiDB.getConnection();
        tbPhanCongNV.setDefaultEditor(Object.class, null);
        DefaultTableModel model = (DefaultTableModel) tbPhanCongNV.getModel();
        model.setRowCount(0);
        ArrayList<String> locBienSoXe = new ArrayList<String>();
        locBienSoXe.clear();
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Vector data;
            while (rs.next()) {
                String tamBienSoXe = rs.getString("BienSoXe");
                if (!locBienSoXe.contains(tamBienSoXe) & (rs.getString("NgayGioHT") == null)) {
                    data = new Vector();
                    data.addElement(tamBienSoXe);
                    data.addElement(traVeDongXe(tamBienSoXe));
                    String tenDv = traVeTenDichVu(rs.getString("BienSoXe"));
                    data.addElement(tenDv);
                    data.addElement(rs.getString("NgayGiolamDV"));
                    data.addElement(rs.getString("MoTa"));
                    model.addRow(data);
                    locBienSoXe.add(tamBienSoXe);
                }
            }
            rs.close();
            st.close();
            ketNoi.close();
        } catch (SQLException e) {
        }

    }

    public void loadDataHoanThanh() {
        //them ma nhan vien vao
        String sql = "select BienSoXe, MaDV,NgayGioHT,MoTa from CT_SDDV where MaNV = '"+LoginForm.MaNV+"'";
        Connection ketNoi = KetNoiDB.getConnection();
        tbHoanThanh.setDefaultEditor(Object.class, null);
        DefaultTableModel model = (DefaultTableModel) tbHoanThanh.getModel();
        model.setRowCount(0);
        ArrayList<String> locBienSoXe = new ArrayList<String>();
        locBienSoXe.clear();
        java.util.Date date = new java.util.Date();
        SimpleDateFormat datefm = new SimpleDateFormat("yyyy-MM-dd");
        String ngayHienTai = datefm.format(date);
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Vector data;
            while (rs.next()) {
                String tamBienSoXe = rs.getString("BienSoXe");
                if (!locBienSoXe.contains(tamBienSoXe) & (rs.getString("NgayGioHT") != null)) {
                    String ngay = rs.getString("NgayGioHT");
                    int index = ngay.indexOf(" ");
                    String ngayHoanThanh =ngay.substring(0,index);
                    if(ngayHienTai.equals(ngayHoanThanh)){
                            data = new Vector();
                            data.addElement(tamBienSoXe);
                            data.addElement(traVeDongXe(tamBienSoXe));
                            String tenDv = traVeTenDichVu(rs.getString("BienSoXe"));
                            data.addElement(tenDv);
                            data.addElement(rs.getString("NgayGioHT"));
                            data.addElement(rs.getString("MoTa"));
                            model.addRow(data);
                            locBienSoXe.add(tamBienSoXe);
                }
               }
            }
            rs.close();
            st.close();
            ketNoi.close();
        } catch (SQLException e) {
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbTenNVSX = new javax.swing.JLabel();
        btnHoanThanh = new javax.swing.JButton();
        btnSuaDichVu = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhanCongNV = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoanThanh = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 516));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_mechanic_110px.png"))); // NOI18N
        jLabel1.setText("NHÂN VIÊN SỬA XE");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 37, 200, 131));

        lbTenNVSX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTenNVSX.setForeground(new java.awt.Color(255, 255, 255));
        lbTenNVSX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenNVSX.setText("jLabel2");
        lbTenNVSX.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbTenNVSXMouseMoved(evt);
            }
        });
        lbTenNVSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTenNVSXMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbTenNVSXMouseExited(evt);
            }
        });
        jPanel1.add(lbTenNVSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 174, 200, -1));

        btnHoanThanh.setBackground(new java.awt.Color(0, 0, 36));
        btnHoanThanh.setForeground(new java.awt.Color(255, 255, 255));
        btnHoanThanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_profile_50px.png"))); // NOI18N
        btnHoanThanh.setText("HOÀN THÀNH");
        btnHoanThanh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHoanThanh.setPreferredSize(new java.awt.Dimension(200, 50));
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });
        jPanel1.add(btnHoanThanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, -1));

        btnSuaDichVu.setBackground(new java.awt.Color(0, 0, 36));
        btnSuaDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_profile_50px.png"))); // NOI18N
        btnSuaDichVu.setText("CHỈNH SỬA DỊCH VỤ");
        btnSuaDichVu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSuaDichVu.setPreferredSize(new java.awt.Dimension(200, 50));
        btnSuaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDichVuActionPerformed(evt);
            }
        });
        jPanel1.add(btnSuaDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 160, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setPreferredSize(new java.awt.Dimension(963, 616));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("BẢNG PHÂN CÔNG LÀM DỊCH VỤ"));

        tbPhanCongNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Biển số", "Dòng xe", "Dịch vụ", "Giờ tiếp nhận", "Mô tả"
            }
        ));
        tbPhanCongNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhanCongNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPhanCongNV);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("HOÀN THÀNH"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbHoanThanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Biển số", "Dòng xe", "Dịch vụ", "Giờ hoàn thành", "Mô tả"
            }
        ));
        jScrollPane2.setViewportView(tbHoanThanh);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 840, 220));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String chondBienSoXe() {
        int index = tbPhanCongNV.getSelectedRow();
        return (String) tbPhanCongNV.getValueAt(index, 0);
    }

    private void btnSuaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDichVuActionPerformed
        // TODO add your handling code here:
        tbPhanCongNV.getSelectionModel().clearSelection();
        if (dataSuaDichVu.equals(""))
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn xe để sửa dịch vụ");
        else {
            new SuaDV_Form(this, rootPaneCheckingEnabled).setVisible(true);
            loadDataPhanCong();
            dataHoanThanhDichVu = "";
        }
    }//GEN-LAST:event_btnSuaDichVuActionPerformed

    private void tbPhanCongNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhanCongNVMouseClicked
        // TODO add your handling code here:
        dataSuaDichVu = chondBienSoXe();
        dataHoanThanhDichVu = dataSuaDichVu;
    }//GEN-LAST:event_tbPhanCongNVMouseClicked

    public void themThoiGianHoanThanh() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat datefm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sql = "UPDATE CT_SDDV SET  NgayGioHT = ? " + "where BienSoXe = ?";
        Connection ketNoi = KetNoiDB.getConnection();
        try {
            PreparedStatement pr = ketNoi.prepareStatement(sql);
            pr.setString(1, datefm.format(date));
            pr.setString(2, dataHoanThanhDichVu);
            if (pr.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Xe đã hoàn thành");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi!không thành công");
            }
        } catch (Exception e) {
        }

    }
    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed
        // TODO add your handling code here:
        if (dataHoanThanhDichVu.equals(""))
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn xe để hoàn thành dịch vụ");

        else {
            int index = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc hoàn thành xe chưa");
            if (index == 0) {
                themThoiGianHoanThanh();
                loadDataHoanThanh();
                loadDataPhanCong();
            }
        }
    }//GEN-LAST:event_btnHoanThanhActionPerformed

    private void lbTenNVSXMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTenNVSXMouseMoved
        lbTenNVSX.setForeground(Color.blue);
    }//GEN-LAST:event_lbTenNVSXMouseMoved

    private void lbTenNVSXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTenNVSXMouseExited
        lbTenNVSX.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbTenNVSXMouseExited

    private void lbTenNVSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTenNVSXMouseClicked
       new TuyChinhFrom(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_lbTenNVSXMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NVSX_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NVSX_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NVSX_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NVSX_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NVSX_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoanThanh;
    private javax.swing.JButton btnSuaDichVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTenNVSX;
    private javax.swing.JTable tbHoanThanh;
    private javax.swing.JTable tbPhanCongNV;
    // End of variables declaration//GEN-END:variables

    private void and(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
