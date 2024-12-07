package View;

import Kelas.Barang;
import Kelas.Peminjaman;
import Kelas.Koneksi;

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
        txtcaripeminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String keyword = txtcaripeminjaman.getText().trim(); // Ambil teks pencarian
                cariPeminjaman(keyword); // Panggil metode pencarian
            }
        });
        comboBoxPeminjam();
        comboBoxBarang();
        // Mengaktifkan AutoComplete pada combo box
        AutoCompleteDecorator.decorate(cbPeminjam);
        AutoCompleteDecorator.decorate(cbBarang);
        AutoCompleteDecorator.decorate(cbStatus);
        //dateTimePickerKembali.setDateTimePermissive(LocalDateTime.now());
        dateTimePickerPinjam.setDateTimePermissive(LocalDateTime.now());

    }
     

    private int getSelectedBarangId() {
        return Integer.parseInt(cbBarang.getSelectedItem().toString().split(" - ")[0]); 
    }
    //private DateTimePicker datepickerKembali;
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
    
    private void cariPeminjaman(String keyword) {
    // Membuat model untuk JTable
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Peminjaman");
    model.addColumn("Nama Peminjam");
    model.addColumn("Nama Barang");
    model.addColumn("Status");
    model.addColumn("Jumlah");
    model.addColumn("Tanggal Pinjam");
    model.addColumn("Tanggal Kembali");

    try {
        Peminjaman peminjam = new Peminjaman(); // Instansiasi kelas Peminjaman
        ResultSet data = peminjam.cariPeminjaman(keyword); // Panggil metode dari kelas Peminjaman

        // Memasukkan data ke dalam JTable
        while (data.next()) {
            model.addRow(new Object[]{
                data.getString("id_peminjaman"),          // ID Peminjaman
                data.getString("nama_peminjam"),          // Nama Peminjam (dari hasil JOIN)
                data.getString("nama_barang"),            // Nama Barang (dari hasil JOIN)
                data.getString("status"),                 // Status
                data.getInt("jumlah"),                    // Jumlah
                data.getDate("tanggal_pinjam"),           // Tanggal Pinjam
                data.getDate("tanggal_kembali")           // Tanggal Kembali
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }

    // Menetapkan model ke JTable untuk menampilkan hasil pencarian
    tblPeminjaman.setModel(model); 
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
        btnKembalikan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtcaripeminjaman = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIDPeminjaman = new javax.swing.JTextField();
        dateTimePickerPinjam = new com.github.lgooddatepicker.components.DateTimePicker();
        dateTimePickerKembali = new com.github.lgooddatepicker.components.DateTimePicker();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));

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
        tblPeminjaman.setBackground(new java.awt.Color(0, 153, 153));
        tblPeminjaman.setForeground(new java.awt.Color(255, 255, 255));
        tblPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeminjaman);

        cbPeminjam.setBackground(new java.awt.Color(255, 255, 0));

        cbBarang.setBackground(new java.awt.Color(255, 255, 0));

        txtJumlah.setBackground(new java.awt.Color(255, 255, 0));

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dipinjam", "Dikembalikan", " " }));
        cbStatus.setBackground(new java.awt.Color(255, 255, 0));

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

        btnKembalikan.setText("Kembalikan");
        btnKembalikan.setBackground(new java.awt.Color(255, 102, 102));
        btnKembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembalikanActionPerformed(evt);
            }
        });

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

        dateTimePickerPinjam.setBackground(new java.awt.Color(255, 255, 0));

        dateTimePickerKembali.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKembalikan, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateTimePickerPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateTimePickerKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 406, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23)
                        .addComponent(txtcaripeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtcaripeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(403, 403, 403)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnKembalikan, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addComponent(jLabel8)
                                    .addGap(33, 33, 33))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(txtIDPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
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
                            .addGap(16, 16, 16)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(17, 17, 17)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(dateTimePickerPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(11, 11, 11)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(dateTimePickerKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
//        try {
//            Peminjaman pm = new Peminjaman();
//            Peminjam p = new Peminjam();
//            Barang brg = new Barang();
//            pm.setId_peminjaman(txtIDPeminjaman.getText());
//            p.setNama(cbPeminjam.getSelectedItem().toString());
//            brg.setNama_barang(cbBarang.getSelectedItem().toString());
//            pm.setStatus(cbStatus.getSelectedItem().toString());
//            pm.setJumlah(Integer.parseInt(txtJumlah.getText()));
//            pm.setTanggal_pinjam(dateTimePickerPinjam.getDateTimePermissive()); // Ambil LocalDateTime
//            pm.setTanggal_kembali(dateTimePickerKembali.getDateTimePermissive()); // Ambil LocalDateTime
//
//            ResultSet datapeminjam = p.KonversiPeminjam();
//            ResultSet databarang = brg.KonversiBarang();
//
//            if (datapeminjam.next()) {
//                String isipeminjam = datapeminjam.getString("id_peminjam");
//                pm.setId_peminjam(isipeminjam);
//            }
//            if (databarang.next()) {
//                String isibarang = databarang.getString("id_barang");
//                pm.setId_barang(isibarang);
//            }
//            pm.tambahPeminjaman();
//        } catch (SQLException sQLException) {
//            System.out.println("data tidak masuk");
//        }
//        loadTable();
//        reset();

//try {
//        // Validasi input
//        if (cbPeminjam.getSelectedItem() == null || cbBarang.getSelectedItem() == null ||
//            cbStatus.getSelectedItem() == null || txtJumlah.getText().isEmpty() ||
//            dateTimePickerPinjam.getDateTimePermissive() == null) {
//            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        Peminjaman pm = new Peminjaman();
//        Peminjam p = new Peminjam();
//        Barang brg = new Barang();
//
//        // Set data peminjaman
//        pm.setId_peminjaman(txtIDPeminjaman.getText());
//        p.setNama(cbPeminjam.getSelectedItem().toString());
//        brg.setNama_barang(cbBarang.getSelectedItem().toString());
//        pm.setStatus(cbStatus.getSelectedItem().toString());
//        pm.setJumlah(Integer.parseInt(txtJumlah.getText()));
//        pm.setTanggal_pinjam(dateTimePickerPinjam.getDateTimePermissive());
//        pm.setTanggal_kembali(dateTimePickerKembali.getDateTimePermissive());
//
//        // Mendapatkan ID Peminjam dan ID Barang
//        ResultSet datapeminjam = p.KonversiPeminjam();
//        ResultSet databarang = brg.KonversiBarang();
//
//        if (datapeminjam.next()) {
//            String isipeminjam = datapeminjam.getString("id_peminjam");
//            pm.setId_peminjam(isipeminjam);
//        }
//        if (databarang.next()) {
//            String isibarang = databarang.getString("id_barang");
//            pm.setId_barang(isibarang);
//        }
//
//        // Menambah data peminjaman ke database
//        pm.tambahPeminjaman();
//
//        // Mengupdate tabel dan mereset input
//        loadTable();
//        reset();
//    } catch (SQLException sQLException) {
//        JOptionPane.showMessageDialog(this, "Data tidak dapat dimasukkan: " + sQLException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//    }

try {
        // Validasi input
        if (cbPeminjam.getSelectedItem() == null || cbBarang.getSelectedItem() == null ||
            cbStatus.getSelectedItem() == null || txtJumlah.getText().isEmpty() ||
            dateTimePickerPinjam.getDateTimePermissive() == null) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Peminjaman pm = new Peminjaman();
        Peminjam p = new Peminjam();
        Barang brg = new Barang();

        String namaBarang = cbBarang.getSelectedItem().toString();
        int jumlahPinjam = Integer.parseInt(txtJumlah.getText());

        // Validasi stok barang
        int stokTersedia = brg.getStokBarang(namaBarang);
        if (jumlahPinjam > stokTersedia) {
            JOptionPane.showMessageDialog(this, "Jumlah barang yang dipinjam melebihi stok tersedia!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Set data peminjaman
        pm.setId_peminjaman(txtIDPeminjaman.getText());
        p.setNama(cbPeminjam.getSelectedItem().toString());
        brg.setNama_barang(namaBarang);
        pm.setStatus(cbStatus.getSelectedItem().toString());
        pm.setJumlah(jumlahPinjam);
        pm.setTanggal_pinjam(dateTimePickerPinjam.getDateTimePermissive());
        pm.setTanggal_kembali(dateTimePickerKembali.getDateTimePermissive());

        // Mendapatkan ID Peminjam dan ID Barang
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

        // Menambah data peminjaman ke database
        pm.tambahPeminjaman();

        // Mengupdate tabel dan mereset input
        loadTable();
        reset();
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(this, "Data tidak dapat dimasukkan: " + sQLException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
//        try {
//            Peminjaman pm = new Peminjaman();
//            Peminjam p = new Peminjam();
//            Barang brg = new Barang();
//            pm.setId_peminjaman(txtIDPeminjaman.getText());
//            p.setNama(cbPeminjam.getSelectedItem().toString());
//            brg.setNama_barang(cbBarang.getSelectedItem().toString());
//            pm.setStatus(cbStatus.getSelectedItem().toString());
//            pm.setJumlah(Integer.parseInt(txtJumlah.getText()));
//            pm.setTanggal_pinjam(dateTimePickerPinjam.getDateTimePermissive()); // Ambil LocalDateTime
//            pm.setTanggal_kembali(dateTimePickerKembali.getDateTimePermissive()); // Ambil LocalDateTime
//
//            ResultSet datapeminjam = p.KonversiPeminjam();
//            ResultSet databarang = brg.KonversiBarang();
//
//            if (datapeminjam.next()) {
//                String isipeminjam = datapeminjam.getString("id_peminjam");
//                pm.setId_peminjam(isipeminjam);
//            }
//            if (databarang.next()) {
//                String isibarang = databarang.getString("id_barang");
//                pm.setId_barang(isibarang);
//            }
//            pm.ubahPeminjaman();
//        } catch (SQLException sQLException) {
//            System.out.println("data tidak masuk");
//        }
//        loadTable();
//        reset();
 try {
        // Validasi input
        if (cbPeminjam.getSelectedItem() == null || cbBarang.getSelectedItem() == null ||
            cbStatus.getSelectedItem() == null || txtJumlah.getText().isEmpty() ||
            dateTimePickerPinjam.getDateTimePermissive() == null) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Peminjaman pm = new Peminjaman();
        Peminjam p = new Peminjam();
        Barang brg = new Barang();

        // Set data peminjaman
        pm.setId_peminjaman(txtIDPeminjaman.getText());
        p.setNama(cbPeminjam.getSelectedItem().toString());
        brg.setNama_barang(cbBarang.getSelectedItem().toString());
        pm.setStatus(cbStatus.getSelectedItem().toString());
        pm.setJumlah(Integer.parseInt(txtJumlah.getText()));
        pm.setTanggal_pinjam(dateTimePickerPinjam.getDateTimePermissive());
        pm.setTanggal_kembali(dateTimePickerKembali.getDateTimePermissive());

        // Mendapatkan ID Peminjam dan ID Barang
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

        // Mengubah data peminjaman di database
        pm.ubahPeminjaman();

        // Mengupdate tabel dan mereset input
        loadTable();
        reset();
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(this, "Data tidak dapat diubah: " + sQLException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
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

//try {
//        // Validasi apakah ID peminjaman dipilih
//        if (txtIDPeminjaman.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Pilih peminjaman yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        Peminjaman pm = new Peminjaman();
//        pm.setId_peminjaman(txtIDPeminjaman.getText());
//
//        // Menghapus data peminjaman dari database
//        pm.hapusPeminjaman();
//
//        // Mengupdate tabel dan mereset input
//        loadTable();
//        reset();
//    } catch (SQLException sQLException) {
//        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + sQLException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//    }
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

            txtIDPeminjaman.setVisible(true);
            txtIDPeminjaman.setVisible(true);
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

    private void btnKembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembalikanActionPerformed
     try {
         
        // Ambil data dari form atau tabel
        String idPeminjaman = txtIDPeminjaman.getText();
        String namaBarang = cbBarang.getSelectedItem().toString();
        int jumlah = Integer.parseInt(txtJumlah.getText());

        // Ubah status menjadi "Dikembalikan"
        Peminjaman pm = new Peminjaman();
        pm.ubahStatusPeminjaman(idPeminjaman, "Dikembalikan");

        // Kembalikan stok barang
        Barang brg = new Barang();
        brg.kembalikanStok(namaBarang, jumlah);
//                    Peminjaman pm = new Peminjaman();
            pm.setId_peminjaman(txtIDPeminjaman.getText()); // ID yang berasal dari tabel
            pm.hapusPeminjaman();

        JOptionPane.showMessageDialog(this, "Barang berhasil dikembalikan!");

    } catch (SQLException ex) {
        ex.printStackTrace(); // Debugging
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
    }

    // Refresh tabel dan reset form
    loadTable();
    reset();
    }//GEN-LAST:event_btnKembalikanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembalikan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbBarang;
    private javax.swing.JComboBox<String> cbPeminjam;
    private javax.swing.JComboBox<String> cbStatus;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePickerKembali;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePickerPinjam;
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
    private javax.swing.JTable tblPeminjaman;
    private javax.swing.JTextField txtIDPeminjaman;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtcaripeminjaman;
    // End of variables declaration//GEN-END:variables
}
