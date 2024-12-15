package View;

import Kelas.Kategori;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Kelas.Vendor;
import javax.swing.JOptionPane;

public class FrameVendor extends javax.swing.JPanel {

    public FrameVendor() {
        initComponents();
        loadTable();
        reset();
        txtcarinamavendor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String keyword = txtcarinamavendor.getText().trim(); // Ambil teks pencarian
                cariVendor(keyword); // Panggil metode pencarian
            }
        });

    }

    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Vendor");
        model.addColumn("Nama Vendor");
        model.addColumn("Alamat");
        model.addColumn("Nama CP");
        model.addColumn("No.Tlp");
        model.addColumn("Email");

        try {
            Vendor ven = new Vendor();
            ResultSet data = ven.tampilVendor();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_vendor"),
                    data.getString("nama_vendor"),
                    data.getString("alamat"),
                    data.getString("nama_cp"),
                    data.getString("no_tlp"),
                    data.getString("email"),});

            }

        } catch (SQLException sQLException) {

        }

        tblVendor.setModel(model);
    }

    void reset() {
        autoID();
       // txtIdVendor.setEditable(false);
        txtNamaVendor.setText(null);
        txtAlamat.setText(null);
        txtNamaCP.setText(null);
        txtNoTlp.setText(null);
        txtEmail.setText(null);
    }

    void autoID() {
        try {
            Vendor ven = new Vendor();
            String id = ven.autoID(); // Memanggil method autoID() dari class Kategori
            txtIdVendor.setText(id); // Set ID ke text field
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saat membuat ID: " + e.getMessage());
        }
    }

    void cariVendor(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Vendor");
        model.addColumn("Nama Vendor");
        model.addColumn("Alamat");
        model.addColumn("Nama CP");
        model.addColumn("No.Tlp");
        model.addColumn("Email");

        try {
            Vendor ven = new Vendor(); // Instansiasi kelas Vendor
            ResultSet data = ven.cariVendor(keyword); // Panggil metode dari kelas Vendor

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_vendor"),
                    data.getString("nama_vendor"),
                    data.getString("alamat"),
                    data.getString("nama_cp"),
                    data.getString("no_tlp"),
                    data.getString("email"),});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        tblVendor.setModel(model); // Set hasil pencarian ke tabel
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNamaVendor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNamaCP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNoTlp = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendor = new javax.swing.JTable();
        txtIdVendor = new javax.swing.JLabel();
        txtcarinamavendor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nama Vendor");

        txtNamaVendor.setBackground(new java.awt.Color(255, 255, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alamat");

        txtAlamat.setBackground(new java.awt.Color(255, 255, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama CP");

        txtNamaCP.setBackground(new java.awt.Color(255, 255, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("No.TLP");

        txtNoTlp.setBackground(new java.awt.Color(255, 255, 0));

        txtEmail.setBackground(new java.awt.Color(255, 255, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");

        btnTambah.setBackground(new java.awt.Color(255, 255, 51));
        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(153, 153, 255));
        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(153, 153, 0));
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tblVendor.setBackground(new java.awt.Color(0, 153, 153));
        tblVendor.setForeground(new java.awt.Color(255, 255, 255));
        tblVendor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVendor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendor);

        txtIdVendor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtIdVendor.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        txtIdVendor.setText("Id Vendor");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cari");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 168, Short.MAX_VALUE)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdVendor)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAlamat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNoTlp, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNamaCP, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNamaVendor)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(txtcarinamavendor, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcarinamavendor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaCP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoTlp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdVendor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
            Vendor ven = new Vendor();
            ven.setId_vendor(txtIdVendor.getText());
            ven.setNama_vendor(txtNamaVendor.getText());
            ven.setAlamat(txtAlamat.getText());
            ven.setNama_cp(txtNamaCP.getText());
            ven.setNo_tlp(txtNoTlp.getText());
            ven.setEmail(txtEmail.getText());

            ven.tambahVendor();
        } catch (SQLException sQLException) {
        }

        loadTable();
        reset();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try {
            Vendor ven = new Vendor();
            ven.setId_vendor(txtIdVendor.getText());
            ven.setNama_vendor(txtNamaVendor.getText());
            ven.setAlamat(txtAlamat.getText());
            ven.setNama_cp(txtNamaCP.getText());
            ven.setNo_tlp(txtNoTlp.getText());
            ven.setEmail(txtEmail.getText());

            ven.ubahVendor();
        } catch (SQLException sQLException) {
        }

        loadTable();
        reset();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            Vendor ven = new Vendor();
            ven.setId_vendor(txtIdVendor.getText());

            ven.hapusVendor();
        } catch (SQLException sQLException) {
        }

        loadTable();
        reset();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblVendorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendorMouseClicked
        int baris = tblVendor.rowAtPoint(evt.getPoint());
        String idVendor = tblVendor.getValueAt(baris, 0).toString();
        String namaVendor = tblVendor.getValueAt(baris, 1).toString();
        String alamat = tblVendor.getValueAt(baris, 2).toString();
        String namaCP = tblVendor.getValueAt(baris, 3).toString();
        String noTLP = tblVendor.getValueAt(baris, 4).toString();
        String email = tblVendor.getValueAt(baris, 5).toString();

        txtIdVendor.setText(idVendor);
       //txtIdVendor.setEditable(false);
        txtIdVendor.setVisible(true);
        txtIdVendor.setVisible(true);
        txtNamaVendor.setText(namaVendor);
        txtAlamat.setText(alamat);
        txtNamaCP.setText(namaCP);
        txtNoTlp.setText(noTLP);
        txtEmail.setText(email);
    }//GEN-LAST:event_tblVendorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendor;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtIdVendor;
    private javax.swing.JTextField txtNamaCP;
    private javax.swing.JTextField txtNamaVendor;
    private javax.swing.JTextField txtNoTlp;
    private javax.swing.JTextField txtcarinamavendor;
    // End of variables declaration//GEN-END:variables
}
