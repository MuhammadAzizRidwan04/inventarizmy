package View;

import Kelas.Barang;
import Kelas.Peminjaman;

import Kelas.Peminjam;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FramePeminjaman extends javax.swing.JPanel {

    public FramePeminjaman() {
        initComponents();
        loadTable();
        reset();
        comboBoxPeminjam();
        comboBoxBarang();
        // Mengaktifkan AutoComplete pada combo box
        AutoCompleteDecorator.decorate(cbPeminjam);
        AutoCompleteDecorator.decorate(cbBarang);
        AutoCompleteDecorator.decorate(cbStatus);
        dateTimePickerKembali.setDateTimePermissive(LocalDateTime.now());
        dateTimePickerPinjam.setDateTimePermissive(LocalDateTime.now());

    }
    private DateTimePicker datepickerKembali;
    private DateTimePicker datepickerPinjam;

    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Peminjaman");
        model.addColumn("Peminjam");
        model.addColumn("Barang");
        model.addColumn("Status");
        model.addColumn("Jumlah");
        model.addColumn("Tgl.Pinjam");
        model.addColumn("Tgl.Kembali");

        try {
            Peminjaman pm = new Peminjaman();
            ResultSet data = pm.tampilPeminjaman();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("ID"),
                    data.getString("Peminjam"),
                    data.getString("Barang"),
                    data.getString("Status"),
                    data.getString("Jumlah"),
                    data.getString("Tanggal_Pinjam"),
                    data.getString("Tanggal_Kembali"),});

            }

        } catch (SQLException sQLException) {

        }

        tblPeminjaman.setModel(model);
    }

    void reset() {
        autoID();
        txtIDPeminjaman.setEditable(true);
        cbPeminjam.setSelectedItem(null);
        cbBarang.setSelectedItem(null);
        cbStatus.setSelectedItem(null);
        txtJumlah.setText(null);
        cbStatus.setSelectedItem(null);
        dateTimePickerPinjam.clear();
        dateTimePickerKembali.clear();
    }

    void comboBoxPeminjam() {

        try {
            Peminjam p = new Peminjam();
            ResultSet data = p.tampilComBoxPeminjam();

            while (data.next()) {
                String isi = data.getString("nama");
                cbPeminjam.addItem(isi);
            }

        } catch (SQLException ex) {

        }

    }

    void comboBoxBarang() {

        try {
            Barang brg = new Barang();
            ResultSet data = brg.tampilComBoxBarang();

            while (data.next()) {
                String isi = data.getString("nama_barang");
                cbBarang.addItem(isi);
            }

        } catch (SQLException ex) {

        }

    }

    void autoID() {
        try {
            Peminjaman pm = new Peminjaman();
            String id = pm.autoID(); // Memanggil method autoID() dari class Kategori
            txtIDPeminjaman.setText(id); // Set ID ke text field
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saat membuat ID: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeminjaman = new javax.swing.JTable();
        cbPeminjam = new javax.swing.JComboBox<>();
        cbBarang = new javax.swing.JComboBox<>();
        txtJumlah = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIDPeminjaman = new javax.swing.JTextField();
        dateTimePickerPinjam = new com.github.lgooddatepicker.components.DateTimePicker();
        dateTimePickerKembali = new com.github.lgooddatepicker.components.DateTimePicker();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        tblPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeminjaman);

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dipinjam", "Dikembalikan", " " }));

        jLabel1.setText("Peminjam");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Barang");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Status");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Jumlah");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Tgl.Pinjam");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Tgl.Kembali");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        btnTambah.setText("Tambah");
        btnTambah.setBackground(new java.awt.Color(255, 255, 51));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.setBackground(new java.awt.Color(153, 153, 255));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        jButton3.setText("Kembalikan");
        jButton3.setBackground(new java.awt.Color(255, 102, 102));

        btnHapus.setText("Hapus");
        btnHapus.setBackground(new java.awt.Color(153, 153, 0));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel7.setText("Cari");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Id Peminjaman");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJumlah)
                    .addComponent(cbPeminjam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIDPeminjaman)
                    .addComponent(dateTimePickerPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateTimePickerKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtIDPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dateTimePickerPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dateTimePickerKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
            Peminjaman pm = new Peminjaman();
            Peminjam p = new Peminjam();
            Barang brg = new Barang();
            pm.setId_peminjaman(txtIDPeminjaman.getText());
            p.setNama(cbPeminjam.getSelectedItem().toString());
            brg.setNama_barang(cbBarang.getSelectedItem().toString());
            pm.setStatus(cbStatus.getSelectedItem().toString());
            pm.setJumlah(Integer.parseInt(txtJumlah.getText()));
            pm.setTanggal_pinjam(dateTimePickerPinjam.getDateTimePermissive()); // Ambil LocalDateTime
            pm.setTanggal_kembali(dateTimePickerKembali.getDateTimePermissive()); // Ambil LocalDateTime

            ResultSet datapeminjam = p.KonversiPeminjam();
            ResultSet databarang = brg.KonversiBarang();

            if (datapeminjam.next()) {
                String isipeminjam = datapeminjam.getString("id_peminjam");
                pm.setId_peminjam(isipeminjam);
            }
            if (databarang.next()) {
                String isibarang = databarang.getString("id_barang");
                pm.setId_barang(isibarang);
            }
            pm.tambahPeminjaman();
        } catch (SQLException sQLException) {
            System.out.println("data tidak masuk");
        }
        loadTable();
        reset();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try {
            Peminjaman pm = new Peminjaman();
            Peminjam p = new Peminjam();
            Barang brg = new Barang();
            pm.setId_peminjaman(txtIDPeminjaman.getText());
            p.setNama(cbPeminjam.getSelectedItem().toString());
            brg.setNama_barang(cbBarang.getSelectedItem().toString());
            pm.setStatus(cbStatus.getSelectedItem().toString());
            pm.setJumlah(Integer.parseInt(txtJumlah.getText()));
            pm.setTanggal_pinjam(dateTimePickerPinjam.getDateTimePermissive()); // Ambil LocalDateTime
            pm.setTanggal_kembali(dateTimePickerKembali.getDateTimePermissive()); // Ambil LocalDateTime

            ResultSet datapeminjam = p.KonversiPeminjam();
            ResultSet databarang = brg.KonversiBarang();

            if (datapeminjam.next()) {
                String isipeminjam = datapeminjam.getString("id_peminjam");
                pm.setId_peminjam(isipeminjam);
            }
            if (databarang.next()) {
                String isibarang = databarang.getString("id_barang");
                pm.setId_barang(isibarang);
            }
            pm.ubahPeminjaman();
        } catch (SQLException sQLException) {
            System.out.println("data tidak masuk");
        }
        loadTable();
        reset();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            Peminjaman pm = new Peminjaman();
            pm.setId_peminjaman(txtIDPeminjaman.getText()); // ID yang berasal dari tabel
            pm.hapusPeminjaman();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan: " + sQLException.getMessage());
        }

        // Reset dan reload tabel setelah hapus
        reset();
        loadTable();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeminjamanMouseClicked
        int baris = tblPeminjaman.rowAtPoint(evt.getPoint());
        if (baris >= 0) {
            String ID = tblPeminjaman.getValueAt(baris, 0).toString();
            String Peminjam = tblPeminjaman.getValueAt(baris, 1).toString();
            String Barang = tblPeminjaman.getValueAt(baris, 2).toString();
            String Status = tblPeminjaman.getValueAt(baris, 3).toString();
            String Jumlah = tblPeminjaman.getValueAt(baris, 4).toString();
            String tglpinjam = tblPeminjaman.getValueAt(baris, 5).toString();
            String tglkembali = tblPeminjaman.getValueAt(baris, 6).toString();

            txtIDPeminjaman.setText(ID);
            txtIDPeminjaman.setEditable(false);
            cbPeminjam.setSelectedItem(Peminjam);
            cbBarang.setSelectedItem(Barang);
            cbStatus.setSelectedItem(Status);
            txtJumlah.setText(Jumlah);

            // Debugging
            System.out.println("tglpinjam: " + tglpinjam);
            System.out.println("tglkembali: " + tglkembali);

            try {
                // Gunakan format yang sesuai untuk tanggal dan waktu
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                // Mengonversi tglpinjam dari String ke LocalDateTime, pastikan string tidak kosong
                LocalDateTime tanggalPinjam = null;
                if (tglpinjam != null && !tglpinjam.trim().isEmpty()) {
                    tanggalPinjam = LocalDateTime.parse(tglpinjam, formatter);
                }

                // Menangani nilai tglkembali yang kosong atau null
                LocalDateTime tanggalKembali = null;
                if (tglkembali != null && !tglkembali.trim().isEmpty() && !tglkembali.equals("null")) {
                    tanggalKembali = LocalDateTime.parse(tglkembali, formatter);
                }

                // Set ke DateTimePicker
                if (tanggalPinjam != null) {
                    dateTimePickerPinjam.setDateTimePermissive(tanggalPinjam);
                }
                if (tanggalKembali != null) {
                    dateTimePickerKembali.setDateTimePermissive(tanggalKembali);
                }

            } catch (DateTimeParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan dalam mengonversi tanggal. Pastikan format tanggal sudah benar.");
            }
        }


    }//GEN-LAST:event_tblPeminjamanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbBarang;
    private javax.swing.JComboBox<String> cbPeminjam;
    private javax.swing.JComboBox<String> cbStatus;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePickerKembali;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePickerPinjam;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblPeminjaman;
    private javax.swing.JTextField txtIDPeminjaman;
    private javax.swing.JTextField txtJumlah;
    // End of variables declaration//GEN-END:variables
}
