/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Form.Xuli.KetNoiDB;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author StarScream
 */
public class PhanCongForm extends javax.swing.JDialog {

    private String bienSoXe, MaNV, MaDV = "", TenDV, maDVCombox;
    private String dataPhanCong = "";
    private String chonDichVuXoaString = "";
    /** Creates new form PhanCongForm */
    private HashMap bangDV;
    private HashMap listDV = new HashMap();
    private HashMap dataNhanVien;

    public PhanCongForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.dataPhanCong = LeTanform.dataBangPhanCong;
        if (dataPhanCong.equals("")) {
            this.MaNV = LeTanform.MaNVPhanCong;
            this.bienSoXe = LeTanform.phanCongBienSoXe;
            loadData();
        } else {
            loadDataEdit();
        }
    }

    public void loadData() {

        jBienSoXE.setText(bienSoXe);
        String tenNV = getTenNhanVien(MaNV);
        jHovaTen.setText(tenNV);
        loadDataComboxDV();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    public static String getTenNhanVien(String s) {
        String sql = "select HoTen from NHANVIEN where MaNV = '" + s + "'";
        Connection ketNoi = KetNoiDB.getConnection();
        String tamp = null;
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tamp = rs.getString("HoTen");
            }
            st.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException e) {
        }
        return tamp;
    }

    public void loadDataComboxDV() {
        jCBoxDV.removeAllItems();
        bangDV = new HashMap();
        bangDV.clear();
        String sql = "select MaDV,TenDV from DICHVU";
        Connection ketNoi = KetNoiDB.getConnection();
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                bangDV.put(rs.getString("TenDV"), rs.getString("MaDV"));
                jCBoxDV.addItem(rs.getString("TenDV"));
            }
            jCBoxDV.addItem("Thêm dịch vụ");
            st.close();
            rs.close();
            ketNoi.close();
        } catch (Exception e) {
        }

    }

    public void themDichVu(String tenDV) {
        String sql = "insert into DICHVU(MaDV,TenDV) values(?,?)";
        Connection ketNoi = KetNoiDB.getConnection();
        Random rd = new Random();
        maDVCombox = (String.valueOf(rd.nextInt(1000)));
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, maDVCombox);
            ps.setString(2, tenDV);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Thêm dịch vụ thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi!Không thành công");
            }
            ps.close();
            ketNoi.close();
        } catch (Exception e) {
        }

    }

    public String getMaDV(String TenDV) {
        for (Object i : bangDV.keySet()) {
            if (i.equals(TenDV)) {
                MaDV = (String) bangDV.get(i);
            }
        }
        return MaDV;
    }

    public void themCT_SDDV() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat datefm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        int check = 0;
        for (Object i : listDV.keySet()) {
            MaDV = (String) listDV.get(i);
            try {
                String sql = "INSERT INTO CT_SDDV(BienSoXe,MaNV,MaDV,NgayGiolamDV,NgayGioHT,MoTa)  VALUES(?,?,?,?,?,?)";
                Connection ketNoi = KetNoiDB.getConnection();
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, bienSoXe);
                ps.setString(2, MaNV);
                ps.setString(3, MaDV);
                ps.setString(4, datefm.format(date));
                ps.setString(5, null);
                ps.setString(6, jMota.getText());
                check = ps.executeUpdate();
                ps.close();
                ketNoi.close();
            } catch (Exception e) {
            }
        }
        if (check > 0) {
            JOptionPane.showMessageDialog(this, "Đã phân công nhân viên thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi !! Chưa thêm dịch vụ!");
        }

    }

    public void suaCT_SDDV() {
        int check = 0;
        for (Object i : listDV.keySet()) {
            MaDV = (String) listDV.get(i);
            try {
                String sql = "INSERT INTO CT_SDDV(BienSoXe,MaNV,MaDV,NgayGiolamDV,NgayGioHT,MoTa)  VALUES(?,?,?,?,?,?)";
                Connection ketNoi = KetNoiDB.getConnection();
                PreparedStatement ps = ketNoi.prepareStatement(sql);
                ps.setString(1, bienSoXe);
                ps.setString(2, MaNV);
                ps.setString(3, MaDV);
                ps.setString(4, luuThoiGian);
                ps.setString(5, null);
                ps.setString(6, jMota.getText());
                check = ps.executeUpdate();
                ps.close();
                ketNoi.close();
            } catch (Exception e) {
            }
        }
        if (check > 0) {
            JOptionPane.showMessageDialog(this, "Đã phân công nhân viên thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi !! Không thành công!");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCBoxDV = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMota = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBienSoXE = new javax.swing.JTextField();
        jHovaTen = new javax.swing.JTextField();
        btnSDDV = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBDichVu = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Dịch vụ:");

        jCBoxDV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCBoxDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxDVActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PHÂN CÔNG LÀM DỊCH VỤ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mô tả:");

        jMota.setColumns(5);
        jMota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMota.setRows(5);
        jScrollPane1.setViewportView(jMota);

        jButton1.setText("PHÂN CÔNG");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("HUỶ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Biển số xe:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Họ tên NVBD:");

        jBienSoXE.setEditable(false);
        jBienSoXE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jHovaTen.setEditable(false);
        jHovaTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSDDV.setText("THÊM");
        btnSDDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSDDVActionPerformed(evt);
            }
        });

        TBDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ"
            }
        ));
        TBDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBDichVuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TBDichVu);

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCBoxDV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSDDV))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1)
                            .addComponent(jBienSoXE)
                            .addComponent(jHovaTen))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBienSoXE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHovaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBoxDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSDDV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void xoaTruocKhiSua() {
        String sql = "Delete from CT_SDDV where BienSoXe = '" + dataPhanCong + "'";
        Connection ketNoi = KetNoiDB.getConnection();
        try {
            PreparedStatement st = ketNoi.prepareStatement(sql);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }

    }

    public String traVeTenDichVu(String maDV) {
        for (Object i : bangDV.keySet()) {
            if (maDV.equals(bangDV.get(i))) {
                return (String) i;
            }
        }
        return null;
    }

    public void editCT_SDDV() {
        xoaTruocKhiSua();
        bienSoXe = dataPhanCong;
        suaCT_SDDV();

    }
    public String luuThoiGian = "";

    public void loadDataVaoBangDichVu() {
        String sql = "select MaNV,MaDV,NgayGioLamDV from CT_SDDV where BienSoXe = '" + dataPhanCong + "'";
        Connection ketNoi = KetNoiDB.getConnection();
        listDV.clear();
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MaNV = rs.getString("MaNV");
                listDV.put(traVeTenDichVu(rs.getString("MaDV")), rs.getString("MaDV"));
                luuThoiGian = rs.getString("NgayGioLamDV");
            }
            st.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException e) {
        }

    }

    public void loadDataEdit() {

        jBienSoXE.setText(dataPhanCong);
        loadDataComboxDV();
        loadDataVaoBangDichVu();
        themDichVuVaoBang();
        String sql = "SELECT MaNV,MoTa from CT_SDDV WHERE BienSoXe = '" + dataPhanCong + "'";
        Connection ketNoi = KetNoiDB.getConnection();
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String tenNV = getTenNhanVien(rs.getString("MaNV"));
                jHovaTen.setText(tenNV);
                jMota.setText(rs.getString("MoTa"));
            }
            rs.close();
            st.close();
            ketNoi.close();
        } catch (SQLException e) {
        }

    }


    private void jCBoxDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxDVActionPerformed
        // TODO add your handling code here:
        if (jCBoxDV.getSelectedItem().equals("Thêm dịch vụ")) {
            String inputDV = JOptionPane.showInputDialog("Thêm dịch vụ");
            if (inputDV != null) {
                themDichVu(inputDV);
                loadDataComboxDV();
            }
        } else {
            TenDV = (String) jCBoxDV.getSelectedItem();
            getMaDV(TenDV);
        }
    }//GEN-LAST:event_jCBoxDVActionPerformed

    public void KtTenNhanVien() {
        Connection ketNoi = KetNoiDB.getConnection();
        String sql = "select MaNV,HoTen from NHANVIEN";
        MaNV = "";
        dataNhanVien = new HashMap();
        dataNhanVien.clear();
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dataNhanVien.put(rs.getString("HoTen"), rs.getString("MaNV"));
            }
            st.close();
            rs.close();
            ketNoi.close();
        } catch (Exception e) {
        }
        for (Object i : dataNhanVien.keySet()) {
            if (i.equals(jHovaTen.getText())) {
                MaNV = (String) dataNhanVien.get(i);
            }
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (dataPhanCong.equals("")) {
            themCT_SDDV();
            setVisible(false);
        } else {
            KtTenNhanVien();
            if (!jBienSoXE.getText().equals(dataPhanCong)) {
                JOptionPane.showMessageDialog(rootPane, "Không được thay đổi biển số xe đã phân công !!!");
            } else if (MaNV.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Không có nhân viên !!!");
            } else {
                editCT_SDDV();
                setVisible(false);
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    public void themDichVuVaoBang() {
        DefaultTableModel model = (DefaultTableModel) TBDichVu.getModel();
        model.setRowCount(0);
        Vector thayThe;
        int count = 0;
        for (Object i : listDV.keySet()) {
            thayThe = new Vector();
            count++;
            thayThe.addElement(count);
            thayThe.addElement(listDV.get(i));
            thayThe.addElement(i);
            model.addRow(thayThe);
        }
    }
    private void btnSDDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSDDVActionPerformed
        // TODO add your handling code here:
        String tam = (String) jCBoxDV.getSelectedItem();
        listDV.put(tam, getMaDV(tam));
        themDichVuVaoBang();
    }//GEN-LAST:event_btnSDDVActionPerformed
    public String chonDichVuTrongBangCanXoa() {
        int index = TBDichVu.getSelectedRow();
        return (String) TBDichVu.getValueAt(index, 2);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (chonDichVuXoaString == "") {
            JOptionPane.showMessageDialog(rootPane, "Chọn dịch vụ để xóa");
        } else {
            int check = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa dịch vụ");
            if (check == 0) {
                listDV.remove(chonDichVuXoaString);
            }
        }
        themDichVuVaoBang();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TBDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBDichVuMouseClicked
        // TODO add your handling code here:
        chonDichVuXoaString = chonDichVuTrongBangCanXoa();
    }//GEN-LAST:event_TBDichVuMouseClicked

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
            java.util.logging.Logger.getLogger(PhanCongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhanCongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhanCongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhanCongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PhanCongForm dialog = new PhanCongForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBDichVu;
    private javax.swing.JButton btnSDDV;
    private javax.swing.JTextField jBienSoXE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCBoxDV;
    private javax.swing.JTextField jHovaTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextArea jMota;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
