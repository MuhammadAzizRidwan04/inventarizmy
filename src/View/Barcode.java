package View;

import Kelas.Barang;
import com.barcodelib.barcode.Linear;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Barcode extends javax.swing.JPanel {

    /**
     * Creates new form Barcode
     */
    public Barcode() {
        initComponents();
        reset();
        loadTable();
        isiTanggalOtomatis();
        txtcaribarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String keyword = txtcaribarang.getText().trim(); // Ambil teks pencarian
                cariBarang(keyword); // Panggil metode pencarian
            }
        });
    }

    void reset() {
        qr_text.setText("");
        txtNama.setText("");
        labelBarcode.setIcon(null);
    }

    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Barang");
        model.addColumn("Nama Barang");

        try {
            Barang brg = new Barang();
            ResultSet data = brg.tampilBarang();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("ID"),
                    data.getString("Nama"),});

            }

        } catch (SQLException sQLException) {

        }

        tblBarcode.setModel(model);
    }

    private void cariBarang(String keyword) {
        // Membuat model untuk JTable
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Barang");
        model.addColumn("Nama Barang");

        try {
            Barang brg = new Barang(); // Instansiasi kelas Barang
            ResultSet data = brg.cariBarang(keyword); // Panggil metode dari kelas Barang

            // Memasukkan data ke dalam JTable
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_barang"), // ID Barang
                    data.getString("nama_barang") // Nama Barang
                // Jumlah
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        tblBarcode.setModel(model);
    }

    private void isiTanggalOtomatis() {
        // Format tanggal yang diinginkan
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Mendapatkan tanggal saat ini
        LocalDate tanggalSaatIni = LocalDate.now();

        // Mengisi txtTanggal dengan tanggal yang diformat
        txtTanggal.setText(tanggalSaatIni.format(formatter));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        qr_text = new javax.swing.JTextField();
        btnCetak = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        QR_read = new javax.swing.JLabel();
        QR_path = new javax.swing.JTextField();
        labelBarcode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarcode = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtcaribarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtJumlahCetak = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));

        btnCetak.setBackground(new java.awt.Color(255, 255, 0));
        btnCetak.setText("Cetak Barcode");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnRead.setBackground(new java.awt.Color(204, 255, 204));
        btnRead.setText("Baca Barcode");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        QR_read.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        QR_read.setForeground(new java.awt.Color(255, 255, 255));
        QR_read.setText("QR_read");

        QR_path.setText("D:\\Java\\Myinventarizm\\src\\Barcode\\");

            labelBarcode.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
            labelBarcode.setForeground(new java.awt.Color(255, 255, 255));
            labelBarcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            labelBarcode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("ID");

            jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(255, 255, 255));
            jLabel2.setText("Nama");

            tblBarcode.setBackground(new java.awt.Color(0, 153, 153));
            tblBarcode.setForeground(new java.awt.Color(255, 255, 255));
            tblBarcode.setModel(new javax.swing.table.DefaultTableModel(
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
            tblBarcode.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblBarcodeMouseClicked(evt);
                }
            });
            jScrollPane1.setViewportView(tblBarcode);

            jButton1.setBackground(new java.awt.Color(255, 153, 153));
            jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jButton1.setForeground(new java.awt.Color(255, 255, 255));
            jButton1.setText("New Barcode");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(255, 255, 255));
            jLabel3.setText("Cari");

            jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(255, 255, 255));
            jLabel4.setText("Jumlah Cetak");

            txtTanggal.setEditable(false);
            txtTanggal.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtTanggalActionPerformed(evt);
                }
            });

            jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(255, 255, 255));
            jLabel5.setText("Tgl. Cetak");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(QR_read, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                            .addGap(58, 58, 58)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(QR_path, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                                .addComponent(txtJumlahCetak)
                                                .addComponent(qr_text)
                                                .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                                .addComponent(txtTanggal))))
                                    .addGap(33, 33, 33)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCetak))
                                    .addGap(49, 49, 49))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtcaribarang, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                .addComponent(labelBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(jScrollPane1)))
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(qr_text, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtJumlahCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(QR_read, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(QR_path, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(0, 17, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcaribarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24))
            );

            add(jPanel1, "card2");
        }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
            // Membaca teks dari txtNama untuk digunakan sebagai dasar nama file
            String namaFile = txtNama.getText().trim(); // Ambil teks dari txtNama dan hilangkan spasi ekstra
            String jumlahCetakStr = txtJumlahCetak.getText().trim(); // Ambil jumlah cetak dari txtJumlahCetak
            String tanggal = txtTanggal.getText().trim(); // Ambil tanggal dari txtTanggal

            if (namaFile.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong!");
                return; // Jika txtNama kosong, hentikan proses
            }

            if (jumlahCetakStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Jumlah cetak tidak boleh kosong!");
                return; // Jika txtJumlahCetak kosong, hentikan proses
            }

            if (tanggal.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tanggal tidak boleh kosong!");
                return; // Jika txtTanggal kosong, hentikan proses
            }

            // Parsing jumlah cetak menjadi integer
            int jumlahCetak;
            try {
                jumlahCetak = Integer.parseInt(jumlahCetakStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Jumlah cetak harus berupa angka!");
                return; // Jika jumlah cetak tidak valid, hentikan proses
            }

            if (jumlahCetak <= 0) {
                JOptionPane.showMessageDialog(null, "Jumlah cetak harus lebih dari 0!");
                return; // Jika jumlah cetak kurang dari atau sama dengan 0, hentikan proses
            }

            // Membuat barcode berdasarkan teks yang dimasukkan di qr_text
            ByteArrayOutputStream out = QRCode.from(qr_text.getText())
                    .to(ImageType.PNG).stream();

            // Mengonversi ByteArrayOutputStream ke dalam byte array
            byte[] barcodeData = out.toByteArray();

            // Mengonversi byte array menjadi ImageIcon
            ImageIcon barcodeIcon = new ImageIcon(barcodeData);

            // Mengubah ukuran gambar barcode sesuai dengan ukuran yang diinginkan
            Image barcodeImage = barcodeIcon.getImage();
            Image scaledImage = barcodeImage.getScaledInstance(281, 259, Image.SCALE_SMOOTH);

            // Menampilkan gambar yang telah diubah ukurannya ke dalam labelBarcode
            labelBarcode.setIcon(new ImageIcon(scaledImage));

            // Menyimpan file sebanyak jumlah cetak
            String pathName = "D:\\QRCode\\"; // Tentukan path penyimpanan
            for (int i = 1; i <= jumlahCetak; i++) {
                // Membuat nama file dengan tambahan tanggal dan nomor cetak
                String fileName = pathName + namaFile + "_" + tanggal + "_" + i + ".PNG";
                FileOutputStream fout = new FileOutputStream(new File(fileName));
                fout.write(barcodeData);
                fout.flush();
                fout.close();
            }

            // Menampilkan pesan sukses
            JOptionPane.showMessageDialog(null, "Barcode berhasil dicetak sebanyak " + jumlahCetak + " file!");

            // Reset (jika ada fungsi reset yang perlu dipanggil)
            //reset();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }

//        try {
//            // Membaca teks dari txtNama untuk digunakan sebagai dasar nama file
//            String namaFile = txtNama.getText().trim(); // Ambil teks dari txtNama dan hilangkan spasi ekstra
//            String jumlahCetakStr = txtJumlahCetak.getText().trim(); // Ambil jumlah cetak dari txtJumlahCetak
//
//            if (namaFile.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong!");
//                return; // Jika txtNama kosong, hentikan proses
//            }
//
//            if (jumlahCetakStr.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Jumlah cetak tidak boleh kosong!");
//                return; // Jika txtJumlahCetak kosong, hentikan proses
//            }
//
//            // Parsing jumlah cetak menjadi integer
//            int jumlahCetak;
//            try {
//                jumlahCetak = Integer.parseInt(jumlahCetakStr);
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Jumlah cetak harus berupa angka!");
//                return; // Jika jumlah cetak tidak valid, hentikan proses
//            }
//
//            if (jumlahCetak <= 0) {
//                JOptionPane.showMessageDialog(null, "Jumlah cetak harus lebih dari 0!");
//                return; // Jika jumlah cetak kurang dari atau sama dengan 0, hentikan proses
//            }
//
//            // Membuat barcode berdasarkan teks yang dimasukkan di qr_text
//            ByteArrayOutputStream out = QRCode.from(qr_text.getText())
//                    .to(ImageType.PNG).stream();
//
//            // Mengonversi ByteArrayOutputStream ke dalam byte array
//            byte[] barcodeData = out.toByteArray();
//
//            // Mengonversi byte array menjadi ImageIcon
//            ImageIcon barcodeIcon = new ImageIcon(barcodeData);
//
//            // Mengubah ukuran gambar barcode sesuai dengan ukuran yang diinginkan
//            Image barcodeImage = barcodeIcon.getImage();
//            Image scaledImage = barcodeImage.getScaledInstance(281, 259, Image.SCALE_SMOOTH);
//
//            // Menampilkan gambar yang telah diubah ukurannya ke dalam labelBarcode
//            labelBarcode.setIcon(new ImageIcon(scaledImage));
//
//            // Menyimpan file sebanyak jumlah cetak
//            String pathName = "D:\\QRCode\\"; // Tentukan path penyimpanan
//            for (int i = 1; i <= jumlahCetak; i++) {
//                String fileName = pathName + namaFile + "_" + i + ".PNG";
//                FileOutputStream fout = new FileOutputStream(new File(fileName));
//                fout.write(barcodeData);
//                fout.flush();
//                fout.close();
//            }
//
//            // Menampilkan pesan sukses
//            JOptionPane.showMessageDialog(null, "Barcode berhasil dicetak sebanyak " + jumlahCetak + " file!");
//
//            // Reset (jika ada fungsi reset yang perlu dipanggil)
//            //reset();
//        } catch (Exception e) {
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
//        }
//        try {
//            // Membaca teks dari txtNama untuk digunakan sebagai nama file
//            String namaFile = txtNama.getText().trim(); // Ambil teks dari txtNama dan hilangkan spasi ekstra
//
//            if (namaFile.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong!");
//                return; // Jika txtNama kosong, hentikan proses
//            }
//
//            // Membuat barcode berdasarkan teks yang dimasukkan di qr_text
//            ByteArrayOutputStream out = QRCode.from(qr_text.getText())
//                    .to(ImageType.PNG).stream();
//
//            // Mengonversi ByteArrayOutputStream ke dalam byte array
//            byte[] barcodeData = out.toByteArray();
//
//            // Mengonversi byte array menjadi ImageIcon
//            ImageIcon barcodeIcon = new ImageIcon(barcodeData);
//
//            // Mengubah ukuran gambar barcode sesuai dengan ukuran yang diinginkan
//            Image barcodeImage = barcodeIcon.getImage();
//            Image scaledImage = barcodeImage.getScaledInstance(281, 259, Image.SCALE_SMOOTH);
//
//            // Menampilkan gambar yang telah diubah ukurannya ke dalam labelBarcode
//            labelBarcode.setIcon(new ImageIcon(scaledImage));
//
//            // Menyimpan gambar barcode ke dalam file PNG dengan nama yang diambil dari txtNama
//            String Path_name = "D:\\QRCode\\"; // Tentukan path penyimpanan
//            FileOutputStream fout = new FileOutputStream(new File(Path_name + (namaFile + ".PNG")));
//            fout.write(barcodeData);
//            fout.flush();
//            fout.close();
//
//            // Menampilkan pesan sukses
//            JOptionPane.showMessageDialog(null, "Barcode Berhasil Dicetak dengan nama file: " + namaFile + ".PNG");
//
//            // Reset (jika ada fungsi reset yang perlu dipanggil)
//            //reset();
//        } catch (Exception e) {
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
//        }
//        try {
//            Linear barcode = new Linear();
//            barcode.setType(Linear.CODE128B);
//            barcode.setData(qr_text.getText());
//            barcode.setI(19.0f);
//            String fname = qr_text.getText();
//            barcode.renderBarcode("D:\\" + fname +".png");
//            
//            
//            
//            
//        } catch (Exception e) {
//        }

    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        try {

            InputStream barcodeInputStream = new FileInputStream(QR_path.getText());
            BufferedImage barBufferedImage = ImageIO.read(barcodeInputStream);

            LuminanceSource source = new BufferedImageLuminanceSource(barBufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Reader reader = new MultiFormatReader();
            Result result = reader.decode(bitmap);

            QR_read.setText(result.getText());

        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnReadActionPerformed

    private void tblBarcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarcodeMouseClicked
        int baris = tblBarcode.rowAtPoint(evt.getPoint());
        String ID = tblBarcode.getValueAt(baris, 0).toString();
        String NamaBarang = tblBarcode.getValueAt(baris, 1).toString();

        // Set data ke form
        qr_text.setText(ID);

        txtNama.setText(NamaBarang);

    }//GEN-LAST:event_tblBarcodeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed
        isiTanggalOtomatis();
    }//GEN-LAST:event_txtTanggalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField QR_path;
    private javax.swing.JLabel QR_read;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBarcode;
    private javax.swing.JTextField qr_text;
    private javax.swing.JTable tblBarcode;
    private javax.swing.JTextField txtJumlahCetak;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtcaribarang;
    // End of variables declaration//GEN-END:variables
}
