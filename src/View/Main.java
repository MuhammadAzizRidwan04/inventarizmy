
package View;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author M. Aziz Ridwan
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pKegori = new javax.swing.JPanel();
        bKategori = new javax.swing.JLabel();
        ITM = new javax.swing.JLabel();
        pVendor = new javax.swing.JPanel();
        bVendor = new javax.swing.JLabel();
        pDataBarang = new javax.swing.JPanel();
        bDataBarang = new javax.swing.JLabel();
        pPeminjaman = new javax.swing.JPanel();
        bPeminjaman = new javax.swing.JLabel();
        pPeminjam = new javax.swing.JPanel();
        bPeminjam = new javax.swing.JLabel();
        pConten = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(0, 255, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pKegori.setBackground(new java.awt.Color(255, 255, 255));

        bKategori.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bKategori.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        bKategori.setText("KATEGORI");
        bKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bKategoriMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bKategoriMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bKategoriMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pKegoriLayout = new javax.swing.GroupLayout(pKegori);
        pKegori.setLayout(pKegoriLayout);
        pKegoriLayout.setHorizontalGroup(
            pKegoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pKegoriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bKategori)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pKegoriLayout.setVerticalGroup(
            pKegoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pKegoriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bKategori)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        ITM.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ITM.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        ITM.setText("INVENTARIS ITM");

        pVendor.setBackground(new java.awt.Color(255, 255, 255));

        bVendor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bVendor.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        bVendor.setText("VENDOR");
        bVendor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bVendorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bVendorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bVendorMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pVendorLayout = new javax.swing.GroupLayout(pVendor);
        pVendor.setLayout(pVendorLayout);
        pVendorLayout.setHorizontalGroup(
            pVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVendorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bVendor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pVendorLayout.setVerticalGroup(
            pVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVendorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bVendor)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pDataBarang.setBackground(new java.awt.Color(255, 255, 255));

        bDataBarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bDataBarang.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        bDataBarang.setText("DATA BARANG");
        bDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bDataBarangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bDataBarangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bDataBarangMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pDataBarangLayout = new javax.swing.GroupLayout(pDataBarang);
        pDataBarang.setLayout(pDataBarangLayout);
        pDataBarangLayout.setHorizontalGroup(
            pDataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bDataBarang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDataBarangLayout.setVerticalGroup(
            pDataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bDataBarang)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pPeminjaman.setBackground(new java.awt.Color(255, 255, 255));

        bPeminjaman.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bPeminjaman.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        bPeminjaman.setText("PEMINJAMAN");
        bPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bPeminjamanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bPeminjamanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bPeminjamanMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pPeminjamanLayout = new javax.swing.GroupLayout(pPeminjaman);
        pPeminjaman.setLayout(pPeminjamanLayout);
        pPeminjamanLayout.setHorizontalGroup(
            pPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPeminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bPeminjaman)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPeminjamanLayout.setVerticalGroup(
            pPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPeminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bPeminjaman)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pPeminjam.setBackground(new java.awt.Color(255, 255, 255));

        bPeminjam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bPeminjam.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        bPeminjam.setText("PEMINJAM");
        bPeminjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bPeminjamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bPeminjamMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bPeminjamMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pPeminjamLayout = new javax.swing.GroupLayout(pPeminjam);
        pPeminjam.setLayout(pPeminjamLayout);
        pPeminjamLayout.setHorizontalGroup(
            pPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPeminjamLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(bPeminjam)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPeminjamLayout.setVerticalGroup(
            pPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPeminjamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bPeminjam)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(ITM)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pKegori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDataBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(pPeminjam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ITM)
                .addGap(106, 106, 106)
                .addComponent(pKegori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(pPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(pPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(554, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addComponent(pVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(375, Short.MAX_VALUE)))
        );

        pConten.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        pConten.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Banner", 3, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MY INVENTARIZM");
        pConten.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pConten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pConten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bVendorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVendorMouseEntered
        pVendor.setBackground(new Color(245, 245, 245));
        
    }//GEN-LAST:event_bVendorMouseEntered

    private void bVendorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVendorMouseExited
         pVendor.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_bVendorMouseExited

    private void bVendorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVendorMousePressed
        pConten.removeAll();
        pConten.add(new FrameVendor());
        pConten.repaint();
        pConten.revalidate();
        pVendor.setBackground(new Color(173, 216, 230));
    }//GEN-LAST:event_bVendorMousePressed

    private void bKategoriMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKategoriMouseEntered
        pKegori.setBackground(new Color(245, 245, 245));
    }//GEN-LAST:event_bKategoriMouseEntered

    private void bKategoriMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKategoriMouseExited
        pKegori.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_bKategoriMouseExited

    private void bKategoriMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKategoriMousePressed
        pConten.removeAll();
        pConten.add(new FrameKategori());
        pConten.repaint();
        pConten.revalidate();
        pKegori.setBackground(new Color(173, 216, 230));
    }//GEN-LAST:event_bKategoriMousePressed

    private void bDataBarangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDataBarangMouseEntered
        pDataBarang.setBackground(new Color(245, 245, 245));
    }//GEN-LAST:event_bDataBarangMouseEntered

    private void bDataBarangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDataBarangMouseExited
        pDataBarang.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_bDataBarangMouseExited

    private void bDataBarangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDataBarangMousePressed
        pConten.removeAll();
        pConten.add(new FrameBarang());
        pConten.repaint();
        pConten.revalidate();
        pDataBarang.setBackground(new Color(173, 216, 230));
    }//GEN-LAST:event_bDataBarangMousePressed

    private void bPeminjamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamMouseEntered
        pPeminjam.setBackground(new Color(245, 245, 245));
    }//GEN-LAST:event_bPeminjamMouseEntered

    private void bPeminjamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamMouseExited
         pPeminjam.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_bPeminjamMouseExited

    private void bPeminjamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamMousePressed
        pConten.removeAll();
        pConten.add(new FramePeminjam());
        pConten.repaint();
        pConten.revalidate();
        pPeminjam.setBackground(new Color(173, 216, 230));
    }//GEN-LAST:event_bPeminjamMousePressed

    private void bPeminjamanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamanMouseEntered
         pPeminjaman.setBackground(new Color(245, 245, 245));
    }//GEN-LAST:event_bPeminjamanMouseEntered

    private void bPeminjamanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamanMouseExited
        pPeminjaman.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_bPeminjamanMouseExited

    private void bPeminjamanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamanMousePressed
        pConten.removeAll();
        pConten.add(new FramePeminjaman());
        pConten.repaint();
        pConten.revalidate();
        pPeminjaman.setBackground(new Color(245,245,245));
    }//GEN-LAST:event_bPeminjamanMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            UIManager.put("Button.arc", 15);
            UIManager.put("TextComponent.arc", 15);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ITM;
    private javax.swing.JLabel bDataBarang;
    private javax.swing.JLabel bKategori;
    private javax.swing.JLabel bPeminjam;
    private javax.swing.JLabel bPeminjaman;
    private javax.swing.JLabel bVendor;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pConten;
    private javax.swing.JPanel pDataBarang;
    private javax.swing.JPanel pKegori;
    private javax.swing.JPanel pPeminjam;
    private javax.swing.JPanel pPeminjaman;
    private javax.swing.JPanel pVendor;
    // End of variables declaration//GEN-END:variables
}
