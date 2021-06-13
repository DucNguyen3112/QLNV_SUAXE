/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Form.Xuli.KetNoiDB;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author StarScream
 */
public class ChamCongForm extends javax.swing.JDialog {

    /** Creates new form ChamCongForm */
    private   String date = "";
    private  int thang=0, nam=0;
    private  HashMap  DanhSachTraLuong = new HashMap();
    private   ArrayList ListNV = new ArrayList();
    private  HashMap NVvoiMaCong = new HashMap();
    private  HashMap MaCongvoiNgayLam = new HashMap();
    private int luongCB = 250000;
    public ChamCongForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        LocalDate localDate = LocalDate.now();
        if (localDate.getMonthValue() == 1 )
        {
            int tamp = localDate.getYear() - 1;
            txtNam.setText(String.valueOf(tamp));
            cbThang.setMonth(11);
        }
        txtNam.setText(String.valueOf(localDate.getYear()));
        cbThang.setMonth(localDate.getMonthValue() - 2);
        nam = Integer.parseInt(txtNam.getText());
        thang = cbThang.getMonth() + 1; 
        hienThiData();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    public void layDuLieuCong(){
        String sql = "select MaCong,MaNV,NgayCong from CONG where (Thang = "+thang+"and Nam ="+nam+")";
        Connection ketNoi = KetNoiDB.getConnection();
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            NVvoiMaCong.clear();
            MaCongvoiNgayLam.clear();
            while(rs.next()){
                NVvoiMaCong.put(rs.getString("MaNV"), rs.getString("MaCong"));
                MaCongvoiNgayLam.put(rs.getString("MaCong"), rs.getInt("NgayCong"));
            }
            rs.close();
            st.close();
            ketNoi.close();
        } catch (SQLException e) {
                     }
       
    }
      public void tinhToanLuong(){
        layDuLieuCong();
        String sql = "insert into THANHTOANLUONG(MaTTL,MaNV,MaCong,ThucLinh,MaHD,TrangThai) values(?,?,?,?,?,?)";
        Connection ketNoi = KetNoiDB.getConnection();
        for (Object i : NVvoiMaCong.keySet()) {
        try {
                
                    PreparedStatement ps = ketNoi.prepareStatement(sql);
                    String MaCong = (String) NVvoiMaCong.get(i);
                    String MaTTL = "TTL"+MaCong;
                    int ngayCong = (int) MaCongvoiNgayLam.get(MaCong);
                    int ThucLinh = luongCB * TTLForm.traVeHeSoLuong((String) i) * ngayCong + TTLForm.traVeTienThuong((String) i)- TTLForm.traVeTienPhat((String) i);
                    String MaHD = TTLForm.traVeMaHD((String) i );
                    ps.setString(1, MaTTL);
                    ps.setString(2, (String) i);
                    ps.setString(3, MaCong);
                    ps.setInt(4, ThucLinh);
                    ps.setString(5, MaHD);
                    ps.setInt(6, 0);
                    ps.executeQuery();
                    ps.close();
         ketNoi.close();
        } catch (Exception e) {
        }
        }
    }
      public void updateLuong(String MaCong , String maNv,int ngayLamViec){
        String sql = "UPDATE THANHTOANLUONG SET THUCLINH = ? where MaTTL = ?";
        Connection ketNoi = KetNoiDB.getConnection();
        //for (Object i : NVvoiMaCong.keySet()) 
        try {
                    PreparedStatement ps = ketNoi.prepareStatement(sql);
                    String MaTTL = "TTL"+MaCong;
                    int ThucLinh = luongCB * TTLForm.traVeHeSoLuong(maNv) * ngayLamViec + TTLForm.traVeTienThuong(maNv)- TTLForm.traVeTienPhat(maNv);
                    ps.setInt(1, ThucLinh);
                    ps.setString(2, MaTTL);
                    ps.executeQuery();
                    ps.close();
                    ketNoi.close();
        } catch (Exception e) {
        }
    }
    public static boolean kiemTraNhapSo(String so){
            Pattern pattern = Pattern.compile("\\d*");
            Matcher matcher = pattern.matcher(so);
            if (matcher.matches()) {
                return true;
            } else
            {
                return false;
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        huy = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangCong = new javax.swing.JTable();
        tiemKiem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNam = new javax.swing.JTextField();
        cbThang = new com.toedter.calendar.JMonthChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 567, -1, -1));

        jLabel3.setBackground(new java.awt.Color(217, 156, 121));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BẢNG CHẤM CÔNG");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 90));

        jPanel1.setBackground(new java.awt.Color(217, 156, 121));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        huy.setText("Quay lại");
        huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyActionPerformed(evt);
            }
        });
        jPanel1.add(huy, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 453, 80, 30));

        bangCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Số ngày làm"
            }
        ));
        bangCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangCongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bangCong);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 668, 325));

        tiemKiem.setText("Tìm Kiếm");
        tiemKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiemKiemActionPerformed(evt);
            }
        });
        jPanel1.add(tiemKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Chọn năm:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Chọn tháng:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, 30));

        txtNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 130, 30));

        cbThang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbThang.setMonth(0);
        jPanel1.add(cbThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 710, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void timkiemTheoNgayThang(){
        String sql = "select MaNV from HOPDONG where NgayKy <= '"+date+"'";
        ListNV.clear();
        Connection ketNoi = KetNoiDB.getConnection();
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                 ListNV.add(rs.getString("MaNV"));
            }
            rs.close();
            st.close();
            ketNoi.close();
        } catch (SQLException e) {
                     }
        
    }
    public void themCong(String MaNV){
            String sql = "insert into CONG(MaCong,MaNV,NgayCong,Thang,Nam) values(?,?,?,?,?)";
            Connection ketNoi = KetNoiDB.getConnection();
            String MaCong = MaNV+nam+thang;
            try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, MaCong);
            ps.setString(2,MaNV);
            ps.setInt(3, 0);
            ps.setInt(4, cbThang.getMonth()+1);
            ps.setInt(5,nam);
            ps.executeQuery();
           ps.close();
           ketNoi.close();
        } catch (Exception e) {
        }
    }
    public void hienThiData(){
        String sql = "select MaCong,MaNV,NgayCong from CONG where (Thang = "+thang+"and Nam ="+nam+")";
        Connection ketNoi = KetNoiDB.getConnection();
        DefaultTableModel model=(DefaultTableModel) bangCong.getModel();
        model.setRowCount(0);
        DanhSachTraLuong.clear();
        int ktHienThi = 0;
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Vector data;
            while(rs.next()){
                 DanhSachTraLuong.put(rs.getString("MaCong"), rs.getString("MaNV"));
                 data = new Vector();
                 data.addElement(rs.getString("MaNV"));
                 data.addElement(PhanCongForm.getTenNhanVien(rs.getString("MaNV")));
                 data.addElement(rs.getString("NgayCong"));
                 model.addRow(data);    
                 ktHienThi = 1;
            }
            rs.close();
            st.close();
            ketNoi.close();
        } catch (SQLException e) {
                     }
        if(ktHienThi == 0 ){
         JOptionPane.showMessageDialog(rootPane, "No data");
        }
    }
    private void tiemKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiemKiemActionPerformed
        // TODO add your handling code here:
        nam = Integer.parseInt(txtNam.getText());
        thang = cbThang.getMonth() + 1;
        if((thang == 4 || thang == 6 || thang == 9 ||thang == 11)){
            date = nam+"-"+thang+"-31";  
        }
        if ((thang == 1 || thang == 3 || thang == 5 ||thang == 7 ||thang  == 8 || thang == 10 || thang == 12)){
            date = nam+"-"+thang+"-30";  
        }
        else {
            date = nam+"-"+thang+"-28";
        }  
        LocalDate localDate = LocalDate.now();
        timkiemTheoNgayThang();
            if(thang <= localDate.getMonthValue()){
                for (int i = 0; i < ListNV.size(); i++) {
                    themCong((String) ListNV.get(i));
                 }
                hienThiData();    
                tinhToanLuong();
            }    
            else{
                JOptionPane.showMessageDialog(rootPane, "Vượt quá ngày của hiện tại");
            }
        
    }//GEN-LAST:event_tiemKiemActionPerformed
    public String traVeMaCong(String NV){
        for (Object i : DanhSachTraLuong.keySet()) {
            if (NV.equals(DanhSachTraLuong.get(i))){
                return (String) i;
            }
        }
        return null;
    }
    public  void themSoNgayLamViec(){
          // String  tam = JOptionPane.showInputDialog("Số ngày làm việc");
    bangCong.getModel().addTableModelListener(new TableModelListener() {
             public void tableChanged(TableModelEvent tableModelEvent) {
             if(bangCong.isEditing()){
               int index =bangCong.getSelectedRow();
               String maNV = (String) bangCong.getValueAt(index, 0);
               String tam = (String) bangCong.getValueAt(index, 2);
               if(kiemTraNhapSo(tam)){
               int ngayLamViec = Integer.parseInt(tam);
               if((thang == 4 || thang == 6 || thang == 9 ||thang == 11) && ngayLamViec > 31){
                   JOptionPane.showMessageDialog(rootPane, "Số ngày vượt quá 31 ngày");
                   bangCong.getModel().removeTableModelListener(this);
                   hienThiData();
               }
               else if ((thang == 1 || thang == 3 || thang == 5 ||thang == 7 ||thang  == 8 || thang == 10 || thang == 12) && ngayLamViec > 30) {
                   JOptionPane.showMessageDialog(rootPane, "Số ngày vượt quá 30 ngày");
                   bangCong.getModel().removeTableModelListener(this);
                   hienThiData();
               }
               else if (thang == 2 && ngayLamViec > 28) {
                   JOptionPane.showMessageDialog(rootPane, "Số ngày vượt quá 28 ngày");
                   bangCong.getModel().removeTableModelListener(this);
                   hienThiData();
               }
               else{
                      String tampCong = traVeMaCong(maNV);
                      String sql = "UPDATE CONG SET NgayCong = ? where (MaCong = ? and MaNV= ?)";
                      Connection ketNoi = KetNoiDB.getConnection();
                   try {
                            PreparedStatement ps = ketNoi.prepareStatement(sql);
                            ps.setInt(1, ngayLamViec);
                            ps.setString(2,tampCong);
                            ps.setString(3, maNV);
                            ps.executeUpdate();
                            ps.close();
                            ketNoi.close();
                     } catch (Exception e) {
                        }
                   updateLuong(tampCong,maNV,ngayLamViec);
                  } 
            }
           else {
               JOptionPane.showMessageDialog(rootPane, "Nhập vào phải là số");
               bangCong.getModel().removeTableModelListener(this);
               hienThiData();
             }
                 }
            }
        });
           
   }
    public void themNgayCong(){
        LocalDate localDate = LocalDate.now();
        if (thang == localDate.getMonthValue()){
            themSoNgayLamViec();
            hienThiData();
        }
        if (thang+1 < localDate.getMonthValue()){
            JOptionPane.showMessageDialog(rootPane, "Không được sửa công của tháng :"+thang)    ;
        }
    }
    private void bangCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangCongMouseClicked
        // TODO add your handling code here:
         themNgayCong(); 
    }//GEN-LAST:event_bangCongMouseClicked

    private void huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_huyActionPerformed

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
            java.util.logging.Logger.getLogger(ChamCongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChamCongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChamCongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChamCongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChamCongForm dialog = new ChamCongForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable bangCong;
    private com.toedter.calendar.JMonthChooser cbThang;
    private javax.swing.JButton huy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tiemKiem;
    private javax.swing.JTextField txtNam;
    // End of variables declaration//GEN-END:variables
}
