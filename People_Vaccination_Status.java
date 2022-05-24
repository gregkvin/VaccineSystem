/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class People_Vaccination_Status extends javax.swing.JFrame {

    public People_Vaccination_Status(String user1) throws IOException {
        initComponents();
        loadtable();
        setResizable(false);
        jMenu1.setText(user1);
        loadVaccine();
        venue1.setVisible(true);
        searchqty.setVisible(false);
        searchvac.setVisible(false);
        searchCtr.setVisible(true);
        attribute.setVisible(false);
        qty1.setVisible(false);
    }
    

    
    private void loadtable() throws IOException{
        Centre ctr = new Centre();
        modify m = new modify();
        String path = "centre.txt";
        int line = m.readLineNumber(path), n=0;
        DefaultTableModel model = (DefaultTableModel)(centreeee.getModel());
        model.setRowCount(0);
        try {
            String[] id = ctr.ReadCtrID();
            String[] centree = ctr.ReadCentre(); 
            String [] vaccineee = ctr.ReadVaccine();
            String[] qtyctr = ctr.readQtyCtr();
            while(n < line){
                model.addRow(new Object[]{centree[n], vaccineee[n], qtyctr[n]});
                n=n+1;
            }
            centreeee.setModel(model);
        } catch (Exception e){
            
        }
    }
    
    private void searchCtr() throws IOException{
        Centre c = new Centre();
        String path = "login.txt";
        int id = c.searchCtr(venue1.getText());
        if(id ==  -1){
            JOptionPane.showMessageDialog(null, "Venue not found!");
        } else {
        DefaultTableModel model = (DefaultTableModel)(centreeee.getModel());
        model.setRowCount(0);
        String[] ctrid = c.ReadCtrID();
        String[] centree = c.ReadCentre();
        String [] vaccineee = c.ReadVaccine();
        String[] qtyctr = c.readQtyCtr();
        
        model.addRow(new Object[]{centree[id], vaccineee[id], qtyctr[id]});
        centreeee.setModel(model);
    }
    }
    
    
    private void searchVac() throws IOException {
    Centre c = new Centre();
    ArrayList<Integer> id = c.searchVaccine(attribute.getSelectedItem().toString());
    int n = 0;
    DefaultTableModel model = (DefaultTableModel)(centreeee.getModel());
    model.setRowCount(0);
    String[] ctrid = c.ReadCtrID();
    String[] centree = c.ReadCentre();
    String [] vaccineee = c.ReadVaccine();
    String[] qtyctr = c.readQtyCtr();
    
    while(n < id.size()){
        model.addRow(new Object[]{centree[id.get(n)], vaccineee[id.get(n)], qtyctr[id.get(n)]});
        n = n + 1;
    }
    centreeee.setModel(model);
    
}
        
    
    private void searchQty() throws IOException {
        Centre c = new Centre();
        VaccineSupply v = new VaccineSupply();
        ArrayList<Integer> id = v.searchVaccineQty((Integer)(qty1.getValue()));
        int n = 0;
        DefaultTableModel model = (DefaultTableModel)(centreeee.getModel());
        model.setRowCount(0);
        String[] ctrid = c.ReadCtrID();
        String[] centree = c.ReadCentre();
        String [] vaccineee = c.ReadVaccine();
        String[] qtyctr = c.readQtyCtr();
    
        while(n < id.size()){
            model.addRow(new Object[]{centree[id.get(n)], vaccineee[id.get(n)], qtyctr[id.get(n)]});
            n = n + 1;
        }
        centreeee.setModel(model);
    }
    
    private void logout() throws IOException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        FileWrite fh = new FileWrite();
        String[] input = {jMenu1.getText(), "User logout successful.", dtf.format(now)};
        fh.LoggingActivity(input);
    }

    private void loadVaccine() throws IOException{
        int n=0;
        modify m = new modify();
        Vaccine v = new Vaccine();
        String vaccine [] = v.readVac("vaccine.txt");
        attribute.setModel(new javax.swing.DefaultComboBoxModel(vaccine));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jMenu2 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        centreeee = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        searchCtr = new javax.swing.JButton();
        attribute = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        attribute2 = new javax.swing.JComboBox<>();
        venue1 = new javax.swing.JTextField();
        qty1 = new javax.swing.JSpinner();
        searchvac = new javax.swing.JButton();
        searchqty = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jButton4.setText("jButton4");

        jMenu2.setText("jMenu2");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        centreeee.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        centreeee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Venue", "Vaccine", "Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        centreeee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                centreeeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(centreeee);

        jLabel2.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("• COVID-19 VACCINATION REGISTRATION SYSTEM");

        searchCtr.setBackground(new java.awt.Color(255, 255, 255));
        searchCtr.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        searchCtr.setForeground(new java.awt.Color(0, 102, 51));
        searchCtr.setText("Search");
        searchCtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCtrActionPerformed(evt);
            }
        });

        attribute.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        attribute.setForeground(new java.awt.Color(0, 102, 51));
        attribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attributeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 51));
        jLabel7.setText("Search by ");

        attribute2.setFont(new java.awt.Font("Poppins", 0, 10)); // NOI18N
        attribute2.setForeground(new java.awt.Color(0, 102, 51));
        attribute2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Venue", "Vaccine", "Qty Greater Than" }));
        attribute2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attribute2ActionPerformed(evt);
            }
        });

        venue1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        venue1.setForeground(new java.awt.Color(0, 102, 204));

        qty1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        searchvac.setBackground(new java.awt.Color(255, 255, 255));
        searchvac.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        searchvac.setForeground(new java.awt.Color(0, 102, 51));
        searchvac.setText("Search");
        searchvac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchvacActionPerformed(evt);
            }
        });

        searchqty.setBackground(new java.awt.Color(255, 255, 255));
        searchqty.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        searchqty.setForeground(new java.awt.Color(0, 102, 51));
        searchqty.setText("Search");
        searchqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchqtyActionPerformed(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(255, 255, 255));
        refresh.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        refresh.setForeground(new java.awt.Color(0, 102, 51));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        back.setForeground(new java.awt.Color(0, 102, 51));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(attribute2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(venue1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(attribute, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qty1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchCtr, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchvac, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchqty, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(attribute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attribute2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qty1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCtr)
                    .addComponent(searchvac)
                    .addComponent(searchqty)
                    .addComponent(refresh)
                    .addComponent(back))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jMenuBar1.setForeground(new java.awt.Color(0, 102, 204));
        jMenuBar1.setFont(new java.awt.Font("Poppins", 0, 10)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(0, 102, 51));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("People");
        jMenu1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(0, 102, 51));
        jMenuItem2.setText("Activity Log");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 102, 51));
        jMenuItem1.setText("Log Out");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu5.setForeground(new java.awt.Color(0, 102, 51));
        jMenu5.setText("Covid-19 Vaccine Supply");
        jMenu5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int yesno = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Are you sure want to log out?","WARNING", yesno);
        if(yesno == JOptionPane.YES_OPTION) {
            try {
                dispose();
                logout();
                new Login().setVisible(true);
                if(yesno == JOptionPane.NO_OPTION) {
                    remove(yesno);
                }
            } catch (IOException ex) {
                Logger.getLogger(People_Vaccination_Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     try {
            // TODO add your handling code here:
            dispose();
            new Logging_Activity(jMenu1.getText()).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(User_Records.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void centreeeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_centreeeeMouseClicked
        
    }//GEN-LAST:event_centreeeeMouseClicked

    private void attributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attributeActionPerformed
 
    }//GEN-LAST:event_attributeActionPerformed

    private void searchCtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCtrActionPerformed
        try {
            // TODO add your handling code here:
            searchCtr();
        } catch (IOException ex) {
            Logger.getLogger(People_Vaccination_Status.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchCtrActionPerformed

    private void attribute2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attribute2ActionPerformed
        // TODO add your handling code here:
        if(attribute2.getSelectedItem()=="Venue"){
            venue1.setVisible(true);
            searchqty.setVisible(false);
            searchvac.setVisible(false);
            searchCtr.setVisible(true);
            attribute.setVisible(false);
            qty1.setVisible(false);
        } else if (attribute2.getSelectedItem()=="Vaccine") {
            venue1.setVisible(false);
            searchvac.setVisible(true);
            attribute.setVisible(true);
            searchCtr.setVisible(false);
            qty1.setVisible(false);
            searchqty.setVisible(false);
        } else if (attribute2.getSelectedItem()=="Qty Greater Than") {
            venue1.setVisible(false);
            searchvac.setVisible(false);
            attribute.setVisible(false);
            searchCtr.setVisible(false);
            qty1.setVisible(true);
            searchqty.setVisible(true);
        }
    }//GEN-LAST:event_attribute2ActionPerformed

    private void searchvacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchvacActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            searchVac();
        } catch (IOException ex) {
            Logger.getLogger(People_Vaccination_Status.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchvacActionPerformed

    private void searchqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchqtyActionPerformed
        try {
            // TODO add your handling code here:
            searchQty();
        } catch (IOException ex) {
            Logger.getLogger(People_Vaccination_Status.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchqtyActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        try {
            // TODO add your handling code here:
            loadtable();
        } catch (IOException ex) {
            Logger.getLogger(People_Vaccination_Status.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        dispose();
        String user = jMenu1.getText();
        new People_Menu(user).setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(People_Vaccination_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(People_Vaccination_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(People_Vaccination_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(People_Vaccination_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String user1 = null;
                try {
                    new People_Vaccination_Status(user1).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(People_Vaccination_Status.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> attribute;
    private javax.swing.JComboBox<String> attribute2;
    private javax.swing.JButton back;
    private javax.swing.JTable centreeee;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner qty1;
    private javax.swing.JButton refresh;
    private javax.swing.JButton searchCtr;
    private javax.swing.JButton searchqty;
    private javax.swing.JButton searchvac;
    private javax.swing.JTextField venue1;
    // End of variables declaration//GEN-END:variables
}