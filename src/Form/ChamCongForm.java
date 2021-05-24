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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import  java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public ChamCongForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNam = new javax.swing.JTextField();
        cbThang = new com.toedter.calendar.JMonthChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangCong = new javax.swing.JTable();
        tiemKiem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Chọn tháng:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Chọn năm:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BẢNG CHẤM CÔNG");

        txtNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbThang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbThang.setMonth(0);

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

        tiemKiem.setText("Tìm Kiếm");
        tiemKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiemKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(462, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(221, 221, 221))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tiemKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tiemKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(cbThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void timkiemTheoNgayThang(){
        System.out.println(date);
        String sql = "select MaNV from HOPDONG where NgayKy < '"+date+"'";
        ListNV.clear();
        Connection ketNoi = KetNoiDB.getConnection();
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                 ListNV.add(rs.getString("MaNV"));
                 System.out.println(rs.getString("MaNV"));
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
            String MaCong = MaNV+"-"+date;
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
            }
            rs.close();
            st.close();
            ketNoi.close();
        } catch (SQLException e) {
                     }
       
    }
    private void tiemKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiemKiemActionPerformed
        // TODO add your handling code here:
        java.util.Date checkData=new java.util.Date();
        SimpleDateFormat datefm=new SimpleDateFormat("yyyy-MM-dd");
        nam = Integer.parseInt(txtNam.getText());
        thang = cbThang.getMonth() + 1;
        date = nam+"-"+thang+"-01";   
        String a = datefm.format(checkData);
        try {
            Date date1 = datefm.parse(date);
            Date date2 = datefm.parse(a);
            if(date1.compareTo(date2) <= 0){
                timkiemTheoNgayThang();
                for (int i = 0; i < ListNV.size(); i++) {
                    themCong((String) ListNV.get(i));
                 }
                hienThiData();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Vượt quá ngày của hiện tại");
            }
        } catch (ParseException ex) {
            Logger.getLogger(ChamCongForm.class.getName()).log(Level.SEVERE, null, ex);
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
    public  void themSoNgayLamViec(String maNV){
           String  tam = JOptionPane.showInputDialog("Số ngày làm việc");
           int ngayLamViec = Integer.parseInt(tam);
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
         
    }
    private void bangCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangCongMouseClicked
        // TODO add your handling code here:
        int index = bangCong.getSelectedRow();
        String tamNV = (String) bangCong.getValueAt(index, 0);
        themSoNgayLamViec(tamNV);
        hienThiData();
    }//GEN-LAST:event_bangCongMouseClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tiemKiem;
    private javax.swing.JTextField txtNam;
    // End of variables declaration//GEN-END:variables
}
