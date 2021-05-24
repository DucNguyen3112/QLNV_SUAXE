/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Form.Xuli.KetNoiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author StarScream
 */
public class ThuongForm extends javax.swing.JDialog {

    /** Creates new form ThuongForm */
    private String MaNVThuong="";
    private String MaThuong="";
    private HashMap ListThuong; 
    public ThuongForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        MaNVThuong =AdminForm.maNV;
        loadDaTa();
    }
    public void loadLoaiKhenThuong̣̣̣̣̣(){
         CBKhenThuong.removeAllItems();
         ListThuong = new HashMap();
         ListThuong.clear();
         String sql = "select MaThuong,TenThuong from THUONG";
         Connection ketNoi = KetNoiDB.getConnection();
         try {
             Statement st = ketNoi.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 ListThuong.put(rs.getString("MaThuong"), rs.getString("TenThuong"));
                 CBKhenThuong.addItem(rs.getString("TenThuong"));
             }
             CBKhenThuong.addItem("Thêm loại thưởng");
             st.close();
             rs.close();
             ketNoi.close();
         } catch (Exception e) {
         }
 
       }
       public void loadDaTa(){
           txtMaNV.setText(MaNVThuong);
           txtHoTen.setText(PhanCongForm.getTenNhanVien(MaNVThuong));
           loadLoaiKhenThuong̣̣̣̣̣();
       }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CTThuong = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        CBKhenThuong = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        ngayThuong = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jtienThuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Lưu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 70, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nội dung khen thưởng:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        txtMaNV.setEditable(false);
        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 360, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Huỷ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 70, -1));

        CTThuong.setColumns(20);
        CTThuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CTThuong.setRows(5);
        jScrollPane1.setViewportView(CTThuong);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 360, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KHEN THƯỞNG");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 54));

        CBKhenThuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CBKhenThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBKhenThuongActionPerformed(evt);
            }
        });
        getContentPane().add(CBKhenThuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 230, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Số tiền thưởng");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Họ và tên:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtHoTen.setEditable(false);
        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 360, 30));

        ngayThuong.setDateFormatString("dd,MM,yyyy");
        ngayThuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(ngayThuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 230, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Loại khen thưởng:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        jtienThuong.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(jtienThuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 210, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ngày khen thưởng:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void themThuong(String s){
            String sql = "insert into THUONG(MaThuong,TenThuong) values(?,?)";
            Connection ketNoi = KetNoiDB.getConnection();
            Random rd = new Random();
            MaThuong = "Thuong" + (String.valueOf(rd.nextInt(1000)));
            try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, MaThuong);
            ps.setString(2,s);
            if (ps.executeUpdate()>0) {
                JOptionPane.showMessageDialog(this, "Thêm thưởng thành công!");
            }else{
                JOptionPane.showMessageDialog(this, "Lỗi!Không thành công");
            }
           ps.close();
           ketNoi.close();
        } catch (Exception e) {
        }
        
    }
    public  String traVeMaThuong̣̣(String s){
            for (Object i : ListThuong.keySet()) {
                    System.out.println(ListThuong.get(i));  
                    if(s.equals(ListThuong.get(i)))
                            return (String) i;
                
            }
       return null;
    }
    private void CBKhenThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBKhenThuongActionPerformed
        // TODO add your handling code here:
        if(CBKhenThuong.getSelectedItem().equals("Thêm loại thưởng")){
                 String  inputThuong = JOptionPane.showInputDialog("Thêm loại thưởng");
                 if(inputThuong != null)
                 {
                     themThuong(inputThuong);
                     loadLoaiKhenThuong̣̣̣̣̣();
                 }
            }
       else{
                   MaThuong= traVeMaThuong̣̣((String) CBKhenThuong.getSelectedItem());     
            } 
    }//GEN-LAST:event_CBKhenThuongActionPerformed
    public void luuThuong(){
       SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
       String date = sdf1.format(ngayThuong.getDate());
       int Tien = Integer.parseInt(jtienThuong.getText());
       String sql ="INSERT INTO CTTHUONG(MaNV,MaThuong,CTThuong,SoTien,NgayThuong)  VALUES(?,?,?,?,?)";
       Connection ketNoi =KetNoiDB.getConnection();
        try {
                     PreparedStatement ps = ketNoi.prepareStatement(sql);
                     ps.setString(1, MaNVThuong);
                     ps.setString(2,MaThuong);
                     ps.setString(3, CTThuong.getText());
                     ps.setInt(4, Tien);
                     ps.setString(5, date);
                   if(ps.executeUpdate() > 0 )
                       JOptionPane.showMessageDialog(rootPane, "Thưởng thành công");
                   else 
                      JOptionPane.showMessageDialog(rootPane, "Thưởng thất bại");
                   ps.close();                   
                   ketNoi.close();
        } catch (Exception e) {
                   JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        luuThuong();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ThuongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThuongForm dialog = new ThuongForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> CBKhenThuong;
    private javax.swing.JTextArea CTThuong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtienThuong;
    private com.toedter.calendar.JDateChooser ngayThuong;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    // End of variables declaration//GEN-END:variables
}
