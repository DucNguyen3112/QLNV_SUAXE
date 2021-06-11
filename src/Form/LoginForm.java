/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Form.Xuli.KetNoiDB;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author StarScream
 */
public class LoginForm extends javax.swing.JFrame {

    /** Creates new form LoginForm */
    public LoginForm() {
        initComponents();
        setSize(800, 438);
        setTitle("Đăng nhập");
        setLocationRelativeTo(null);
    }
    public static String ten = "";
    public static String MaNV = "";

    private void kiemTraTaiKhoan() {
        Connection con = KetNoiDB.getConnection();
        String sql = "select * from NHANVIEN,TAIKHOAN where "
                + "TAIKHOAN.MaNV=NHANVIEN.MaNV AND TAIKHOAN.MaNV = '" + txtMaTK.getText() + "'";
        String usr = "";
        String pass = "";
        String ChucVu = "";
        char[] mkcx;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                usr = rs.getString(13);
                pass = rs.getString(14);
                ChucVu = rs.getString(12);
                ten = rs.getString(2);

            }
            MaNV = usr;
            rs.close();
            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        mkcx = new char[pass.length()];
        for (int i = 0; i < pass.length(); i++) {
            mkcx[i] = pass.charAt(i);
        }
        if (usr.equals(txtMaTK.getText()) && Arrays.equals(txtMK.getPassword(), mkcx)) {
            Arrays.fill(mkcx, '0');
            if (ChucVu.equals("0")) {
                this.dispose();
                new AdminForm().setVisible(true);
            } else if (ChucVu.equals("1")) {
                this.dispose();
                new LeTanform().setVisible(true);
            } else if (ChucVu.equals("2")) {
                this.dispose();
                new NVSX_Form().setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!Vui lòng thử lại.");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaTK = new javax.swing.JTextField();
        txtMK = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnDong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 0));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CHƯƠNG TRÌNH QUẢN LÍ NHÂN VIÊN");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TRUNG TÂM BẢO HÀNH XE MÁY");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sevicecenter.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 49, 400, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_user_30px_1.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 125, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/password.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        txtMaTK.setBackground(new java.awt.Color(0, 0, 0));
        txtMaTK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaTK.setForeground(new java.awt.Color(255, 255, 255));
        txtMaTK.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMaTK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaTKKeyPressed(evt);
            }
        });
        jPanel2.add(txtMaTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 125, 241, 30));

        txtMK.setBackground(new java.awt.Color(0, 0, 0));
        txtMK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMK.setForeground(new java.awt.Color(255, 255, 255));
        txtMK.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMKKeyPressed(evt);
            }
        });
        jPanel2.add(txtMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 241, 30));

        btnDangNhap.setBackground(new java.awt.Color(0, 51, 204));
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_login_30px.png"))); // NOI18N
        btnDangNhap.setText("ĐĂNG NHẬP");
        btnDangNhap.setPreferredSize(new java.awt.Dimension(110, 30));
        btnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDangNhapMouseClicked(evt);
            }
        });
        jPanel2.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 319, 290, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 240, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 240, 10));

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_macos_close_30px.png"))); // NOI18N
        btnDong.setText("jLabel7");
        btnDong.setPreferredSize(new java.awt.Dimension(30, 30));
        btnDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDongMouseClicked(evt);
            }
        });
        jPanel2.add(btnDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, 30));

        getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDongMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnDongMouseClicked

    private void btnDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMouseClicked

        kiemTraTaiKhoan();
    }//GEN-LAST:event_btnDangNhapMouseClicked

    private void txtMaTKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaTKKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMK.requestFocus();
        }
    }//GEN-LAST:event_txtMaTKKeyPressed

    private void txtMKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMKKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtMaTK.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Không được bỏ trống tài khoản!");
                return;
            }
            else if (txtMaTK.getText().length()>=20) {
                JOptionPane.showMessageDialog(rootPane, "Tài khoản đăng nhập không vượt quá 20 kí tự!");
                return;
            }
            if (txtMK.getPassword().length>=50||txtMK.getPassword().length<6) {
                JOptionPane.showMessageDialog(rootPane, "Mật khẩu phải từ 6 đến 50 kí tự!");
                return;
            }
            kiemTraTaiKhoan();
        }
        //System.out.println(txtMK.getText());
    }//GEN-LAST:event_txtMKKeyPressed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel btnDong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JTextField txtMaTK;
    // End of variables declaration//GEN-END:variables
}
