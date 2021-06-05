/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Form.Xuli.KetNoiDB;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author StarScream
 */
public class ThemNV extends javax.swing.JDialog {

    String filename = null;
    byte[] person_image = null;
    /** Creates new form ThemNV */
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");

    public ThemNV(java.awt.Frame parent, boolean model) {
        super(parent, model);
        Date date = new Date();
        initComponents();
        setLocationRelativeTo(null);
        rbtnNam.setSelected(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dcNgayKi.setDate(date);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnTT = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rbtnNam = new javax.swing.JRadioButton();
        rbtnNu = new javax.swing.JRadioButton();
        rbtnKhac = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDanToc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dcNgaySinh = new com.toedter.calendar.JDateChooser();
        cbChucVu = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        txtQueQuan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        dcNgayHetHan = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        txtHSL = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        dcNgayKi = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        lbHinhAnh = new javax.swing.JLabel();
        btTaiAnh = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnTT.setBackground(new java.awt.Color(144, 55, 73));

        jPanel3.setBackground(new java.awt.Color(144, 55, 73));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN CÁ NHÂN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Họ và tên:");

        txtTen.setBackground(new java.awt.Color(144, 55, 73));
        txtTen.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtTen.setForeground(new java.awt.Color(255, 255, 255));
        txtTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ngày sinh:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Giới tính:");

        rbtnNam.setBackground(new java.awt.Color(144, 55, 73));
        buttonGroup2.add(rbtnNam);
        rbtnNam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtnNam.setForeground(new java.awt.Color(255, 255, 255));
        rbtnNam.setText("Nam");

        rbtnNu.setBackground(new java.awt.Color(144, 55, 73));
        buttonGroup2.add(rbtnNu);
        rbtnNu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtnNu.setForeground(new java.awt.Color(255, 255, 255));
        rbtnNu.setText("Nữ");

        rbtnKhac.setBackground(new java.awt.Color(144, 55, 73));
        buttonGroup2.add(rbtnKhac);
        rbtnKhac.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtnKhac.setForeground(new java.awt.Color(255, 255, 255));
        rbtnKhac.setText("Khác");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CMND/CCCD:");

        txtCMND.setBackground(new java.awt.Color(144, 55, 73));
        txtCMND.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtCMND.setForeground(new java.awt.Color(255, 255, 255));
        txtCMND.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Dân tộc:");

        txtDanToc.setBackground(new java.awt.Color(144, 55, 73));
        txtDanToc.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtDanToc.setForeground(new java.awt.Color(255, 255, 255));
        txtDanToc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SDT:");

        txtSDT.setBackground(new java.awt.Color(144, 55, 73));
        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(255, 255, 255));
        txtSDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Chức vụ:");

        dcNgaySinh.setDateFormatString("dd-MM-yyyy");
        dcNgaySinh.setMaxSelectableDate(new java.util.Date(1104516076000L));
        dcNgaySinh.setMinSelectableDate(new java.util.Date(-5364683924000L));

        cbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Lễ Tân", "Nhân viên bảo dưỡng" }));
        cbChucVu.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel8))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(165, 165, 165)
                                .addComponent(jLabel7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(rbtnNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtnNu)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtnKhac))
                                    .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnNam)
                            .addComponent(rbtnNu)
                            .addComponent(rbtnKhac))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel7.setBackground(new java.awt.Color(144, 55, 73));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LIÊN HỆ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        txtQueQuan.setBackground(new java.awt.Color(144, 55, 73));
        txtQueQuan.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtQueQuan.setForeground(new java.awt.Color(255, 255, 255));
        txtQueQuan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quê quán:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Địa chỉ:");

        txtDiaChi.setBackground(new java.awt.Color(144, 55, 73));
        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtDiaChi.setForeground(new java.awt.Color(255, 255, 255));
        txtDiaChi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(txtQueQuan, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .addComponent(txtDiaChi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(144, 55, 73));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HỢP ĐỒNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ngày hết hạn:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        dcNgayHetHan.setDateFormatString("dd-MM-yyyy");
        jPanel2.add(dcNgayHetHan, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 180, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("HSL:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, -1, -1));

        txtHSL.setBackground(new java.awt.Color(144, 55, 73));
        txtHSL.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtHSL.setForeground(new java.awt.Color(255, 255, 255));
        txtHSL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtHSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 180, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Ngày kí:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        dcNgayKi.setDateFormatString("dd-MM-yyyy");
        jPanel2.add(dcNgayKi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 190, -1));

        javax.swing.GroupLayout pnTTLayout = new javax.swing.GroupLayout(pnTT);
        pnTT.setLayout(pnTTLayout);
        pnTTLayout.setHorizontalGroup(
            pnTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(pnTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnTTLayout.setVerticalGroup(
            pnTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));

        lbHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btTaiAnh.setText("Tải ảnh lên");
        btTaiAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTaiAnhMouseClicked(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });

        btnHuy.setText("Huỷ");
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btTaiAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btTaiAnh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy)
                    .addComponent(btnLuu))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1002, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 168, Short.MAX_VALUE)
                    .addComponent(pnTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked

        check:
        if (lbHinhAnh.getIcon() == null) {
            JOptionPane.showMessageDialog(rootPane, "Xin hãy chọn ảnh");
            return;
        }
        if (txtTen.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống họ tên");
            return;
        } else if (!txtTen.getText().matches("^[^0-9]{7,}$")) {
            JOptionPane.showMessageDialog(rootPane, "Họ tên không đúng xin kiểm tra lại.");
            return;
        }
        if (txtQueQuan.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống quê quán");
            return;
        } else if (!txtQueQuan.getText().matches("^[^0-9]{3,}$")) {
            JOptionPane.showMessageDialog(rootPane, "Quê quán không đúng xin kiểm tra lại.");
            return;
        }
        if (txtDanToc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống dân tộc");
            return;
        } else if (!txtDanToc.getText().matches("^[^1-9]{3,}$")) {
            JOptionPane.showMessageDialog(rootPane, "Dân tộc không đúng xin kiểm tra lại.");
            return;
        }
        if (txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống địa chỉ");
            return;
        }
        if (txtCMND.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống CMND");
            return;
        }
        if (!txtCMND.getText().matches("^[0-9]{9,12}$")) {
            JOptionPane.showMessageDialog(rootPane, "CMND không đúng xin kiểm tra lại.");
            return;
        }
        if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống số điện thoại");
            return;
        } else if (!txtSDT.getText().matches("^[0]{1}[0-9]{9}$")) {
            JOptionPane.showMessageDialog(rootPane, "Số điện thoại không đúng xin kiểm tra lại.");
            return;
        }
        if (txtHSL.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống hệ số lương");
            return;
        } else if (!txtHSL.getText().matches("^[0-9]{1}[.]{1}[0-9]{1,}$")) {
            JOptionPane.showMessageDialog(rootPane, "Hệ số lương không đúng xin kiểm tra lại");
            return;
        }
        if (cbChucVu.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Xin hãy chọn một chức vụ");
            return;
        }
        if (dcNgaySinh.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Xin hãy chọn ngày sinh");
            return;
        }
        if (dcNgayHetHan.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Xin hãy chọn ngày hết hạn hợp đồng");
            return;
        }
        String sql = "INSERT INTO NHANVIEN (MaNV,HoTen,NgaySinh,GioiTinh,SDT,DanToc,QueQuan,HinhAnh,CMND,DiaChi,TrangThai,ChucVu)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        String str;

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        try {
            //THÊM vào dbo NHANVIEN
            Connection con = KetNoiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            str = KetNoiDB.taoMaNV(cbChucVu.getSelectedIndex());
            ps.setString(1, str);
            ps.setString(2, txtTen.getText());
            date = sdf1.format(dcNgaySinh.getDate());
            ps.setString(3, date);

            if (rbtnNam.isSelected()) {
                ps.setInt(4, 0);
            }
            if (rbtnNu.isSelected()) {
                ps.setInt(4, 1);
            }
            if (rbtnKhac.isSelected()) {
                ps.setInt(4, 2);
            }

            ps.setString(5, txtSDT.getText());
            ps.setString(6, txtDanToc.getText());
            ps.setString(7, txtQueQuan.getText());
            ps.setBytes(8, person_image);
            ps.setString(9, txtCMND.getText());
            ps.setString(10, txtDiaChi.getText());
            ps.setInt(11, 1);
            ps.setInt(12, cbChucVu.getSelectedIndex());
            System.out.println(cbChucVu.getSelectedIndex());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi! Thêm nhân viên không thành công");
            }

            //thêm bào table TAIKHOAN
            String sql2 = "INSERT INTO TAIKHOAN (MaNV,MatKhau)" + "VALUES(?,?)";

            ps = con.prepareStatement(sql2);
            ps.setString(1, str);
            ps.setString(2, "123456");

            ps.execute();

            //thêm vào dboHOPDONG
            String sql3 = "INSERT INTO HOPDONG (MaHD,NgayKy,HanHD,MaNV,HSL)" + "VALUES(?,?,?,?,?)";
            PreparedStatement ps3 = con.prepareStatement(sql3);
            String maHD = "hd" + str;
            ps3.setString(1, maHD);
            ps3.setString(2, sdf1.format(dcNgayKi.getDate()));
            ps3.setString(3, sdf1.format(dcNgayHetHan.getDate()));
            ps3.setString(4, str);
            ps3.setFloat(5, Float.parseFloat(txtHSL.getText()));
            ps3.execute();
            con.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ThemNV.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace();
        }
        this.dispose();

    }//GEN-LAST:event_btnLuuMouseClicked

    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnHuyMouseClicked

    private void btTaiAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTaiAnhMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageicon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lbHinhAnh.getWidth(), lbHinhAnh.getHeight(), Image.SCALE_SMOOTH));
        lbHinhAnh.setIcon(imageicon);

        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }

            person_image = bos.toByteArray();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btTaiAnhMouseClicked

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
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ThemNV dialog = new ThemNV(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btTaiAnh;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbChucVu;
    private com.toedter.calendar.JDateChooser dcNgayHetHan;
    private com.toedter.calendar.JDateChooser dcNgayKi;
    private com.toedter.calendar.JDateChooser dcNgaySinh;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbHinhAnh;
    private javax.swing.JPanel pnTT;
    private javax.swing.JRadioButton rbtnKhac;
    private javax.swing.JRadioButton rbtnNam;
    private javax.swing.JRadioButton rbtnNu;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDanToc;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHSL;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
