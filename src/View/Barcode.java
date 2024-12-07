package View;

import Kelas.Barang;
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

public class Barcode extends javax.swing.JPanel {

    /**
     * Creates new form Barcode
     */
    public Barcode() {
        initComponents();
        reset();
        loadTable();
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

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(QR_read, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(93, 93, 93))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(306, 306, 306)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(QR_path, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(112, 112, 112)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(qr_text)
                                        .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))))
                            .addGap(33, 33, 33)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCetak))
                            .addGap(49, 49, 49)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                .addComponent(labelBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(35, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGap(25, 25, 25)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(QR_path, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(QR_read, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24))
            );

            add(jPanel1, "card2");
        }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed

        try {
            // Membaca teks dari txtNama untuk digunakan sebagai nama file
            String namaFile = txtNama.getText().trim(); // Ambil teks dari txtNama dan hilangkan spasi ekstra

            if (namaFile.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong!");
                return; // Jika txtNama kosong, hentikan proses
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

            // Menyimpan gambar barcode ke dalam file PNG dengan nama yang diambil dari txtNama
            String Path_name = "D:\\Java\\Myinventarizm\\src\\Barcode\\"; // Tentukan path penyimpanan
            FileOutputStream fout = new FileOutputStream(new File(Path_name + (namaFile + ".PNG")));
            fout.write(barcodeData);
            fout.flush();
            fout.close();

            // Menampilkan pesan sukses
            JOptionPane.showMessageDialog(null, "Barcode Berhasil Dicetak dengan nama file: " + namaFile + ".PNG");

            // Reset (jika ada fungsi reset yang perlu dipanggil)
            //reset();

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }


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
        qr_text.setEditable(false);

        qr_text.setVisible(true);
        qr_text.setVisible(true);
        txtNama.setText(NamaBarang);

    }//GEN-LAST:event_tblBarcodeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField QR_path;
    private javax.swing.JLabel QR_read;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBarcode;
    private javax.swing.JTextField qr_text;
    private javax.swing.JTable tblBarcode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
