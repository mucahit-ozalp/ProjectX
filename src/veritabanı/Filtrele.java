/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veritabanı;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mucah
 */
public class Filtrele extends javax.swing.JFrame {

    public Filtrele() {
        initComponents();
        setSize(700, 620);
        ArrayList<String> liste2 = new ArrayList<String>();
        liste2 = Sorgu.sorgu.filtrelerim(Sorgu.id);

        for (int i = 0; i < liste2.size(); i++) {
            c_filt.addItem(liste2.get(i));

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_filt = new javax.swing.JComboBox<>();
        t_sorgu = new javax.swing.JTextField();
        b_manuel = new javax.swing.JButton();
        b_kaydet = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        t_filtreadi = new javax.swing.JTextField();
        b_filtre = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        j_hata = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_tablo2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        t_tablo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Filtre:");

        jLabel2.setText("Ara:");

        b_manuel.setText("manuel ara");
        b_manuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_manuelActionPerformed(evt);
            }
        });

        b_kaydet.setText("kaydet");
        b_kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_kaydetActionPerformed(evt);
            }
        });

        jLabel3.setText("yeni filtre adı:");

        b_filtre.setText("ara");
        b_filtre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_filtreActionPerformed(evt);
            }
        });

        jButton1.setText("geri");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        t_tablo2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "m_id", "kullanici_adi", "yapilan_is", "tarih"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(t_tablo2);

        t_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "m_id", "baslik", "tanim", "status", "severity", "reporter_id", "mk_id", "tarih"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        t_tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_tabloMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(t_tablo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_filtreadi)
                            .addComponent(j_hata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(c_filt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(t_sorgu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_manuel)
                            .addComponent(b_filtre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_filt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(b_filtre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(t_sorgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_manuel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_filtreadi)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(b_kaydet)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j_hata, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_manuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_manuelActionPerformed

        DefaultTableModel model = (DefaultTableModel) t_tablo.getModel();
        model.setRowCount(0);

        for (def_filtre def : Sorgu.sorgu.def_filtreList(t_sorgu.getText())) {
            Object[] eklenecek = {def.getMesaj_id(), def.getBaslık(), def.getTanım(), def.getDurum(), def.getSeviye(), def.getGönderen(), def.getAlıcı(), def.getTarih()};

            model.addRow(eklenecek);

        }


    }//GEN-LAST:event_b_manuelActionPerformed

    private void b_filtreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_filtreActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) t_tablo.getModel();
        model.setRowCount(0);
        String[] dizi = ((String) c_filt.getSelectedItem()).split(" ");
        int k_id = Integer.parseInt(dizi[0]);

        for (def_filtre def : Sorgu.sorgu.def_filtreList(Sorgu.sorgu.filtre_sorgu(k_id))) {
            Object[] eklenecek = {def.getMesaj_id(), def.getBaslık(), def.getTanım(), def.getDurum(), def.getSeviye(), def.getGönderen(), def.getAlıcı(), def.getTarih()};

            model.addRow(eklenecek);

        }
        t_sorgu.setText(Sorgu.sorgu.filtre_sorgu(k_id));


    }//GEN-LAST:event_b_filtreActionPerformed

    private void b_kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_kaydetActionPerformed
        // TODO add your handling code here:
        if (t_filtreadi.getText().length() != 0 && t_sorgu.getText().length() != 0) {

            Sorgu.sorgu.sorgu_ekle(t_filtreadi.getText(), t_sorgu.getText());

        } else {
            j_hata.setText("boşlukları doldur");
        }


    }//GEN-LAST:event_b_kaydetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        Giris.giris.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t_tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_tabloMouseClicked
        // TODO add your handling code here:
        int secilen = t_tablo.getSelectedRow();

        DefaultTableModel model = (DefaultTableModel) t_tablo.getModel();
        int id = Integer.parseInt(model.getValueAt(secilen, 0).toString());

        DefaultTableModel model2 = (DefaultTableModel) t_tablo2.getModel();
        model2.setRowCount(0);
        for (History history : Sorgu.sorgu.history_cek(id)) {
            Object[] ekle = {history.getM_id(),history.getKullanici_adi(),history.getYapılan_iş(),history.getTarih()};
            model2.addRow(ekle);
        }


    }//GEN-LAST:event_t_tabloMouseClicked

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
            java.util.logging.Logger.getLogger(Filtrele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filtrele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filtrele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filtrele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filtrele().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b_filtre;
    private javax.swing.JButton b_kaydet;
    private javax.swing.JButton b_manuel;
    public javax.swing.JComboBox<String> c_filt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel j_hata;
    private javax.swing.JTextField t_filtreadi;
    private javax.swing.JTextField t_sorgu;
    private javax.swing.JTable t_tablo;
    private javax.swing.JTable t_tablo2;
    // End of variables declaration//GEN-END:variables
}
