package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Kelas.Barang;
import Kelas.Vendor;
import Kelas.Kategori;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FrameBarang extends javax.swing.JPanel {

    private boolean isTableSelection = false;

    public FrameBarang() {
        initComponents();
        loadTable();
        reset();

        comboBoxvendor();
        comboBoxkategori();
        AutoCompleteDecorator.decorate(cbVendor);
        AutoCompleteDecorator.decorate(cbKategori);

    }

    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Merk");
        model.addColumn("Vendor");
        model.addColumn("Kategori");
        model.addColumn("Status");
        model.addColumn("Jenis");
        model.addColumn("Jumlah");

        try {
            Barang brg = new Barang();
            ResultSet data = brg.tampilBarang();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("ID"),
                    data.getString("Nama"),
                    data.getString("Merk"),
                    data.getString("Vendor"),
                    data.getString("Kategori"),
                    data.getString("Status"),
                    data.getString("Jenis"),
                    data.getString("Jumlah"),});

            }

        } catch (SQLException sQLException) {

        }

        tblBarang.setModel(model);
    }

    void reset() {
        // autoID();
        txtIDBarang.setEditable(true);
        txtNamaBarang.setText(null);
        txtMerk.setText(null);
        cbVendor.setSelectedItem(null);
        cbKategori.setSelectedItem(null);
        cbStatus.setSelectedItem(null);
        cbJenis.setSelectedItem(null);
        txtJumlah.setText(null);
    }

    void comboBoxvendor() {

        try {
            Vendor ven = new Vendor();
            ResultSet data = ven.tampilComBoxVendor();

            while (data.next()) {
                String isi = data.getString("nama_vendor");
                cbVendor.addItem(isi);
            }

        } catch (SQLException ex) {

        }

    }

    void comboBoxkategori() {

        try {
            Kategori kat = new Kategori();
            ResultSet data = kat.tampilComBoxKategori();

            while (data.next()) {
                String isi = data.getString("nama_kategori");
                cbKategori.addItem(isi);
            }

        } catch (SQLException ex) {

        }

    }

//    void autoID() {
//        try {
//            Barang brg = new Barang();
//            String id = brg.autoID(); // Memanggil method autoID() dari class Kategori
//            txtIDBarang.setText(id); // Set ID ke text field
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error saat membuat ID: " + e.getMessage());
//        }
//    }
    // Aksi tombol Tambah
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDBarang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMerk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbVendor = new javax.swing.JComboBox<>();
        cbKategori = new javax.swing.JComboBox<>();
        cbStatus = new javax.swing.JComboBox<>();
        cbJenis = new javax.swing.JComboBox<>();
        txtJumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setText("ID Barang");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nama Barang");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Merk");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Vendor");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Kategori");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Status");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Jenis");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Jumlah");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        cbVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVendorActionPerformed(evt);
            }
        });

        cbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriActionPerformed(evt);
            }
        });

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baru", "Rusak", "Lama" }));

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleh Dipinjam", "Tidak Boleh Dipinjam" }));

        tblBarang.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBarang);

        btnTambah.setText("TAMBAH");
        btnTambah.setBackground(new java.awt.Color(255, 255, 51));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("UBAH");
        btnUbah.setBackground(new java.awt.Color(153, 153, 255));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.setBackground(new java.awt.Color(153, 153, 0));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnExcel.setText("Export to Excel");
        btnExcel.setBackground(new java.awt.Color(255, 102, 102));
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnUbah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
            Barang brg = new Barang();
            Vendor ven = new Vendor();
            Kategori kat = new Kategori();
            brg.setId_barang(txtIDBarang.getText());
            brg.setNama_barang(txtNamaBarang.getText());
            brg.setMerk(txtMerk.getText());
            ven.setNama_vendor(cbVendor.getSelectedItem().toString());
            kat.setNama_kategori(cbKategori.getSelectedItem().toString());
            brg.setStatus(cbStatus.getSelectedItem().toString());
            brg.setJenis(cbJenis.getSelectedItem().toString());
            brg.setJumlah(Integer.parseInt(txtJumlah.getText()));

            ResultSet datavendor = ven.KonversiVendor();
            ResultSet datakategori = kat.KonversiKategori();

            if (datavendor.next()) {
                String isivendor = datavendor.getString("id_vendor");
                brg.setId_vendor(isivendor);
            }
            if (datakategori.next()) {
                String isikategori = datakategori.getString("id_kategori");
                brg.setId_kategori(isikategori);
            }
            brg.tambahBarang();
        } catch (SQLException sQLException) {
            System.out.println("data tidak masuk");
        }
        loadTable();
        reset();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try {
            Barang brg = new Barang();
            Vendor ven = new Vendor();
            Kategori kat = new Kategori();
            brg.setId_barang(txtIDBarang.getText());
            brg.setNama_barang(txtNamaBarang.getText());
            brg.setMerk(txtMerk.getText());
            ven.setNama_vendor(cbVendor.getSelectedItem().toString());
            kat.setNama_kategori(cbKategori.getSelectedItem().toString());
            brg.setStatus(cbStatus.getSelectedItem().toString());
            brg.setJenis(cbJenis.getSelectedItem().toString());
            brg.setJumlah(Integer.parseInt(txtJumlah.getText()));

            ResultSet datavendor = ven.KonversiVendor();
            ResultSet datakategori = kat.KonversiKategori();

            if (datavendor.next()) {
                String isivendor = datavendor.getString("id_vendor");
                brg.setId_vendor(isivendor);
            }
            if (datakategori.next()) {
                String isikategori = datakategori.getString("id_kategori");
                brg.setId_kategori(isikategori);
            }
            brg.ubahBarang();
        } catch (SQLException sQLException) {
            System.out.println("data tidak masuk");
        }
        loadTable();
        reset();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed

        try {
            Barang brg = new Barang();
            brg.setId_barang(txtIDBarang.getText()); // ID yang berasal dari tabel
            brg.hapusBarang();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan: " + sQLException.getMessage());
        }

        // Reset dan reload tabel setelah hapus
        reset();
        loadTable();

    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
//        int baris = tblBarang.rowAtPoint(evt.getPoint());
//        String ID = tblBarang.getValueAt(baris, 0).toString();
//        String NamaBarang = tblBarang.getValueAt(baris, 1).toString();
//        String Merk = tblBarang.getValueAt(baris, 2).toString();
//        String Vendor = tblBarang.getValueAt(baris, 3).toString();
//        String Kategori = tblBarang.getValueAt(baris, 4).toString();
//        String Status = tblBarang.getValueAt(baris, 5).toString();
//        String Jenis = tblBarang.getValueAt(baris, 6).toString();
//        String Jumlah = tblBarang.getValueAt(baris, 7).toString();
//
//        txtIDBarang.setText(ID);
//        //txtIDBarang.setEditable(false);
//        txtNamaBarang.setText(NamaBarang);
//        txtMerk.setText(Merk);
//        cbVendor.setSelectedItem(Vendor);
//        cbKategori.setSelectedItem(Kategori);
//        cbStatus.setSelectedItem(Status);
//        cbJenis.setSelectedItem(Jenis);
//        txtJumlah.setText(Jumlah);

        isTableSelection = true; // Mulai seleksi dari tabel
        try {
            int baris = tblBarang.rowAtPoint(evt.getPoint());
            String ID = tblBarang.getValueAt(baris, 0).toString();
            String NamaBarang = tblBarang.getValueAt(baris, 1).toString();
            String Merk = tblBarang.getValueAt(baris, 2).toString();
            String Vendor = tblBarang.getValueAt(baris, 3).toString();
            String Kategori = tblBarang.getValueAt(baris, 4).toString();
            String Status = tblBarang.getValueAt(baris, 5).toString();
            String Jenis = tblBarang.getValueAt(baris, 6).toString();
            String Jumlah = tblBarang.getValueAt(baris, 7).toString();

            // Set data ke form
            txtIDBarang.setText(ID);
            txtIDBarang.setEditable(true);
            txtNamaBarang.setText(NamaBarang);
            txtMerk.setText(Merk);
            cbVendor.setSelectedItem(Vendor);
            cbKategori.setSelectedItem(Kategori);
            cbStatus.setSelectedItem(Status);
            cbJenis.setSelectedItem(Jenis);
            txtJumlah.setText(Jumlah);

        } finally {
            isTableSelection = false; // Selesai seleksi dari tabel
        }


    }//GEN-LAST:event_tblBarangMouseClicked

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed

    }//GEN-LAST:event_btnExcelActionPerformed

    private void cbVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVendorActionPerformed
//        String vendorName = cbVendor.getSelectedItem() != null ? cbVendor.getSelectedItem().toString() : "";
//        String kategoriName = cbKategori.getSelectedItem() != null ? cbKategori.getSelectedItem().toString() : "";
//
//        try {
//            Barang barang = new Barang();
//            if (vendorName.isEmpty() || kategoriName.isEmpty()) {
//                txtIDBarang.setText("");
//            } else {
//
//                String fullID = barang.generateFullID(vendorName, kategoriName);
//                txtIDBarang.setText(fullID);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        if (isTableSelection) {
            return; // Jangan eksekusi jika dipicu oleh klik tabel
        }
        String vendorName = cbVendor.getSelectedItem() != null ? cbVendor.getSelectedItem().toString() : "";
        String kategoriName = cbKategori.getSelectedItem() != null ? cbKategori.getSelectedItem().toString() : "";

        try {
            Barang barang = new Barang();
            if (vendorName.isEmpty() || kategoriName.isEmpty()) {
                txtIDBarang.setText("");
            } else {
                String fullID = barang.generateFullID(vendorName, kategoriName);
                txtIDBarang.setText(fullID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_cbVendorActionPerformed

    private void cbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKategoriActionPerformed
//        String vendorName = cbVendor.getSelectedItem() != null ? cbVendor.getSelectedItem().toString() : "";
//        String kategoriName = cbKategori.getSelectedItem() != null ? cbKategori.getSelectedItem().toString() : "";
//
//        try {
//            Barang barang = new Barang();
//            if (vendorName.isEmpty() || kategoriName.isEmpty()) {
//                txtIDBarang.setText("");
//            } else {
//
//                String fullID = barang.generateFullID(vendorName, kategoriName);
//                txtIDBarang.setText(fullID);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
        if (isTableSelection) {
            return; // Jangan eksekusi jika dipicu oleh klik tabel
        }
        String vendorName = cbVendor.getSelectedItem() != null ? cbVendor.getSelectedItem().toString() : "";
        String kategoriName = cbKategori.getSelectedItem() != null ? cbKategori.getSelectedItem().toString() : "";

        try {
            Barang barang = new Barang();
            if (vendorName.isEmpty() || kategoriName.isEmpty()) {
                txtIDBarang.setText("");
            } else {
                String fullID = barang.generateFullID(vendorName, kategoriName);
                txtIDBarang.setText(fullID);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }//GEN-LAST:event_cbKategoriActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbVendor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtIDBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtMerk;
    private javax.swing.JTextField txtNamaBarang;
    // End of variables declaration//GEN-END:variables
}
