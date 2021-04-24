/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Form.Xuli.KetNoiDB;
import java.sql.*;
import java.awt.Color;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author StarScream
 */
public class LeTanform extends javax.swing.JFrame {

    /** Creates new form LeTanform */
    public LeTanform() {
        initComponents();
        setSize(1200, 680);
        setTitle("Phân công dịch vụ");
         lbTenLT.setText(LoginForm.ten);
        setLocationRelativeTo(null);
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
        lbTenLT = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTiepNhan = new javax.swing.JButton();
        btnPhanCong1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhanCong = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbNVBD = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbXe = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(getPreferredSize());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_front_desk_110px.png"))); // NOI18N
        jLabel1.setText("TIẾP TÂN");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 29, 200, 137));

        lbTenLT.setForeground(new java.awt.Color(255, 255, 255));
        lbTenLT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenLT.setText("jLabel2");
        jPanel1.add(lbTenLT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 172, 200, 21));

        btnSua.setBackground(new java.awt.Color(51, 0, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_delete_document_50px.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSua.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 200, -1));

        btnXoa.setBackground(new java.awt.Color(51, 0, 51));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_profile_50px.png"))); // NOI18N
        btnXoa.setText("XOÁ");
        btnXoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnXoa.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 200, -1));

        btnTiepNhan.setBackground(new java.awt.Color(51, 0, 51));
        btnTiepNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnTiepNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_audit_50px_1.png"))); // NOI18N
        btnTiepNhan.setText("TIẾP NHẬN");
        btnTiepNhan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTiepNhan.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel1.add(btnTiepNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, -1));

        btnPhanCong1.setBackground(new java.awt.Color(51, 0, 51));
        btnPhanCong1.setForeground(new java.awt.Color(255, 255, 255));
        btnPhanCong1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_audit_50px_1.png"))); // NOI18N
        btnPhanCong1.setText("PHÂN CÔNG");
        btnPhanCong1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPhanCong1.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel1.add(btnPhanCong1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 200, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(46, 46, 46));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 0), new java.awt.Color(102, 102, 0)));

        tbPhanCong.setBackground(new java.awt.Color(102, 102, 102));
        tbPhanCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Biển số xe", "Tên nhân viên", "Dịch vụ", "Thời gian đem vào"
            }
        ));
        jScrollPane1.setViewportView(tbPhanCong);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Bảng phân công");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 950, 270));

        jPanel4.setBackground(new java.awt.Color(46, 46, 46));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 0), new java.awt.Color(102, 102, 0)));

        tbNVBD.setBackground(new java.awt.Color(102, 102, 102));
        tbNVBD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Giới tính", "Trạng thái"
            }
        ));
        jScrollPane3.setViewportView(tbNVBD);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Bảng nhân viên bảo dưỡng");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 470, 310));

        jPanel5.setBackground(new java.awt.Color(46, 46, 46));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 0), new java.awt.Color(102, 102, 0)));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bảng xe máy");

        tbXe.setBackground(new java.awt.Color(102, 102, 102));
        tbXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Biển số xe", "Dòng xe", "Chủ xe"
            }
        ));
        jScrollPane4.setViewportView(tbXe);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 470, 310));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
    public Vector KtBienSoXe(){
        Connection ketNoi = KetNoiDB.getConnection();
        String sql = "select BienSoXe from CT_SDDV";
        Vector data = new Vector();
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                data.add(rs.getString("BienSoXe"));
            }
            rs.close();
            st.close();
            ketNoi.close();
        } catch (SQLException e) {
                     }
       return data;
    } 
    public boolean  checkBienSoXe(String s, Vector<String> a ){
        for (String i : a)
        {
                if (i.equals(s)) {
                    return false;
                }
        }   
        return true;
    }
    public void loadDBXe(){
        String sql="select BienSoXe,HieuXe,ChuXe from XE";
        Connection   con = KetNoiDB.getConnection();
        //DefaultTableModel model=(DefaultTableModel) tbDsnv.getModel();
        tbXe.setDefaultEditor(Object.class, null);
        DefaultTableModel model=(DefaultTableModel) tbXe.getModel();
        
        try {
            Statement st=null;
            ResultSet rs=null;
            st=con.createStatement();
            rs=st.executeQuery(sql);
            Vector data;
            Vector dataClone = KtBienSoXe();
            System.out.println(dataClone);
            while (rs.next()) {   
                String s = rs.getString("BienSoXe");
                if (checkBienSoXe(s, dataClone)){
                data=new Vector();
                data.addElement(s);
                data.addElement(rs.getString("HieuXe"));
                data.addElement(rs.getString("ChuXe"));
                System.out.println(data +"Data o day");
                model.addRow(data);
               }
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
           
        }
    } 
    
     
    public Vector KtMaNV(){
        Connection ketNoi = KetNoiDB.getConnection();
        String sql = "select MaNV from CT_SDDV";
        Vector data = new Vector();
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                data.add(rs.getString("MaNV"));
            }
            rs.close();
            st.close();
            ketNoi.close();
        } catch (SQLException e) {
           
        }
       return data;
    }
    
    public boolean  checkMaNv(String s, Vector<String> a ){
        for (String i : a)
        {
                if (i.equals(s)) {
                    return false;
                }
        }   
        return true;
    }
    public  void loadNVBaoDuong(){
        String sql="select MaNV,HoTen,GioiTinh from NHANVIEN where ChucVu = 2";
        Connection   con = KetNoiDB.getConnection();
        //DefaultTableModel model=(DefaultTableModel) tbDsnv.getModel();
        tbNVBD.setDefaultEditor(Object.class, null);
        DefaultTableModel model=(DefaultTableModel) tbNVBD.getModel();
        
        try {
            Statement st=null;
            ResultSet rs=null;
            st=con.createStatement();
            rs=st.executeQuery(sql);
            Vector data;
            Vector dataClone = KtMaNV();
            System.out.println(dataClone);
            while (rs.next()) {   
                String s = rs.getString("MaNV");
                if (!checkMaNv(s, dataClone)){
                data=new Vector();
                data.addElement(s);
                data.addElement(rs.getString("HoTen"));
                 switch (rs.getInt("GioiTinh")) {
                    case 0 -> data.addElement("Nam");
                    case 1 -> data.addElement("Nữ");
                    case 3 -> data.addElement("Khác");
                }
                data.addElement("Bận");
                model.addRow(data);
               }
                else {
                data=new Vector();
                data.addElement(s);
                data.addElement(rs.getString("HoTen"));
                 switch (rs.getInt("GioiTinh")) {
                    case 0 -> data.addElement("Nam");
                    case 1 -> data.addElement("Nữ");
                    case 3 -> data.addElement("Khác");
                }
                data.addElement("Rãnh");
                model.addRow(data);
                }
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            
            
        }
        
        
        
    }
    public String getTenDv(String s){
        String sql = "select TenDV from DICHVU where MaDV = 1 ";
        Connection ketNoi = KetNoiDB.getConnection();
        String tamp = null;
        try {
            Statement st = ketNoi.createStatement();
            ResultSet rs  =st.executeQuery(sql);
            while (rs.next()){
                tamp = rs.getString("TenDV"); 
                System.out.println(tamp);
            }  
            st.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException e) {
        }
        return tamp;
    }
    public void loadDataPhanCong(){
        String sql = "select BienSoXe, MaNV, MaDV,NgayGiolamDV from CT_SDDV";
        Connection ketNoi = KetNoiDB.getConnection();
        tbPhanCong.setDefaultEditor(Object.class, null);
        DefaultTableModel model=(DefaultTableModel) tbPhanCong.getModel();
        try {
               Statement st = ketNoi.createStatement();
               ResultSet rs = st.executeQuery(sql);
               Vector data;
               while(rs.next()){
                   data =new Vector();
                   data.addElement(rs.getString("BienSoXe"));
                   data.addElement(rs.getString("MaNV"));
                   String tenDv = getTenDv(rs.getString("MaDV"));
                   data.addElement(tenDv);
                   data.addElement(rs.getString("NgayGiolamDV"));
                   model.addRow(data);
               }
            rs.close();
            st.close();
            ketNoi.close();
        } catch (SQLException e) {
        }
        
    }

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
            java.util.logging.Logger.getLogger(LeTanform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeTanform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeTanform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeTanform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LeTanform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPhanCong1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTiepNhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbTenLT;
    private javax.swing.JTable tbNVBD;
    private javax.swing.JTable tbPhanCong;
    private javax.swing.JTable tbXe;
    // End of variables declaration//GEN-END:variables
}
