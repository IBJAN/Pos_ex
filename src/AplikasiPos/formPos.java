/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplikasiPos;

import AplikasiPos.Pos;
import AplikasiPos.Poscontrol;
import javax.swing.JOptionPane;

/**
 *
 * @author CATUR WARGA COMPUTER
 */
public class formPos extends javax.swing.JFrame {

    private boolean tanya = true;
    Poscontrol pc = new Poscontrol();

    /**
     * Creates new form formPos
     */
    public formPos() {
        initComponents();
        clear();
    }
    private void clear() {
        tfkb.setEnabled(true);
        
        tfkb.setText("");
        tfnb.setText("");
        tfnb.setText("");
        cbpengirim.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        read();
    }

    private void read() {
        pc.read(tblbarang);
    }
      private boolean validasi() {
        if (tfkb.getText().isEmpty()
                || tfnb.getText().isEmpty()
                || (!jb1.isSelected()&&!jb2.isSelected() && !jb3.isSelected()&&!jb4.isSelected())
                || cbpengirim.getSelectedIndex() == 0) {

            return false ;
        }
        return true;
    }

    private void save() {
        if (validasi()) {
            if (tanya) {
                create();
            } else {
                update();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Inputan belum diisi!");
        }

    }

    private void create() {
        Pos p = new Pos();
        p.setKd_Barang(Integer.valueOf(tfkb.getText()));
        p.setNama_Barang(tfnb.getText());

        if (jb1.isSelected()) {
            p.setJenis_Barang("Pakaian");
        } else if (jb2.isSelected()) {
            p.setJenis_Barang("Peralatan");
        } else if (jb3.isSelected()) {
            p.setJenis_Barang("Obat-obatan");
        } else {
            p.setJenis_Barang("Makanan");
        }
        p.setJenis_Pengiriman(cbpengirim.getSelectedItem().toString());

        pc.create(p);
        clear(); //ganti dengan clear agar di refresh setelah di inputkan
//        clear();
    }

    private void update() {
        Pos p = new Pos();
        p.setKd_Barang(Integer.valueOf(tfkb.getText()));
        p.setNama_Barang(tfnb.getText());
        if (jb1.isSelected()) {
            p.setJenis_Barang("Pakaian");
        } else if (jb2.isSelected()) {
            p.setJenis_Barang("Peralatan");
        } else if (jb3.isSelected()) {
            p.setJenis_Barang("Obat-obatan");
        } else {
            p.setJenis_Barang("Makanan");
        }
        p.setJenis_Pengiriman(cbpengirim.getSelectedItem().toString());
        pc.update(p);
        clear();
        tanya=true;
    }
    private void loadData() {
        int select = tblbarang.getSelectedColumnCount();
        if (select > 0) {
            int pilih = JOptionPane.NO_OPTION;
            pilih = JOptionPane.showConfirmDialog(rootPane, "yakin akan mengubah", "informasi", JOptionPane.YES_NO_OPTION);

            if (pilih == JOptionPane.YES_OPTION) {
                int row = this.tblbarang.getSelectedRow();
                tfkb.setText(tblbarang.getValueAt(row, 0).toString());
                tfnb.setText(tblbarang.getValueAt(row, 1).toString());
                  if (tblbarang.getValueAt(row, 2).toString().equals("Pakaian")) {
                    jb1.setSelected(true);
                }else if (tblbarang.getValueAt(row, 2).toString().equals("Peralatan")){
                    jb2.setSelected(true);
                }else if (tblbarang.getValueAt(row, 2).toString().equals("Obat-obatan")){
                    jb3.setSelected(true);
                }else if (tblbarang.getValueAt(row, 2).toString().equals("Makanan")){
                    jb4.setSelected(true);
                }
                  
                cbpengirim.setSelectedItem(tblbarang.getValueAt(row, 3).toString());

                tfkb.setEnabled(false);
                
                tanya = false;
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "DATA BELUM DIPILIH!");
        }
    }
    
    private void delete() {
        int select = tblbarang.getSelectedRowCount();
        if (select > 0) {
            int pilihan = JOptionPane.NO_OPTION;
            pilihan = JOptionPane.showConfirmDialog(rootPane, "Apakah Benar akan menghapus!", "Informasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.YES_OPTION) {
                int row = tblbarang.getSelectedRow();

                int kd = Integer.valueOf(tblbarang.getValueAt(row, 0).toString());
                pc.delete(kd);
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Data belum dipilih!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfkb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfnb = new javax.swing.JTextField();
        jb1 = new javax.swing.JRadioButton();
        jb3 = new javax.swing.JRadioButton();
        jb2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbpengirim = new javax.swing.JComboBox<String>();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbarang = new javax.swing.JTable();
        jb4 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APLIKASI POS");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel7.setFont(new java.awt.Font("Rockwell Condensed", 2, 11)); // NOI18N
        jLabel7.setText("24-november 2020");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\CATUR WARGA COMPUTER\\Downloads\\rsz_1rsz_1rsz_1pngwingcom_2.png")); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\CATUR WARGA COMPUTER\\Downloads\\rsz_1rsz_kisspng-pos-indonesia-persero-pt-joint-stock-company-ma-vector-peta-indonesia-5b3fd2607ee3112271893715309092805197.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jLabel2.setText("Kode Barang");

        jLabel3.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jLabel3.setText("Nama Barang");

        buttonGroup1.add(jb1);
        jb1.setText("Pakaian");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jb3);
        jb3.setText("Obat-obatan");
        jb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jb2);
        jb2.setText("Peralatan");
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jLabel4.setText("Jenis Barang");

        jLabel5.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jLabel5.setText("Jenis Pengiriman");

        cbpengirim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih -", "TRANSFER", "COD" }));
        cbpengirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpengirimActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tblbarang.setBackground(new java.awt.Color(255, 153, 51));
        tblbarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblbarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblbarang.setToolTipText("");
        tblbarang.setGridColor(new java.awt.Color(255, 102, 0));
        jScrollPane1.setViewportView(tblbarang);

        buttonGroup1.add(jb4);
        jb4.setText("Makanan");
        jb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbpengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jb1)
                                .addGap(18, 18, 18)
                                .addComponent(jb2)
                                .addGap(18, 18, 18)
                                .addComponent(jb3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jb4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfkb, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfnb, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfnb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb1)
                        .addComponent(jb2)
                        .addComponent(jb3)
                        .addComponent(jb4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbpengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb1ActionPerformed

    private void jb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb3ActionPerformed

    private void jb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb2ActionPerformed

    private void cbpengirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpengirimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbpengirimActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        save();
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb4ActionPerformed

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
            java.util.logging.Logger.getLogger(formPos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbpengirim;
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
    private javax.swing.JRadioButton jb1;
    private javax.swing.JRadioButton jb2;
    private javax.swing.JRadioButton jb3;
    private javax.swing.JRadioButton jb4;
    private javax.swing.JTable tblbarang;
    private javax.swing.JTextField tfkb;
    private javax.swing.JTextField tfnb;
    // End of variables declaration//GEN-END:variables
}
