/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oodj_assignment.Appointment;
import oodj_assignment.User;
import oodj_assignment.People_Menu;
import oodj_assignment.modify;

/*
 *
 * 
 */
public class People_Appointment extends javax.swing.JFrame {
    
    public People_Appointment(String idi, String username) throws IOException {
        initComponents();
        setResizable(false);
        setData(idi);
        
 
    }
   
   private void setData(String idi) throws IOException{
       User read = new User();
        String path = "login.txt";
        int myid = Integer.parseInt(idi);
        myid = myid - 1; 
        String date = read.readFirstDate(path)[myid]; 
        String times = read.readFirstTime(path)[myid]; 
        String ctr = read.readFirstDateCtr(path)[myid]; 
        String stat = read.readFirstStatus(path)[myid]; 
        String date2 = read.readSecondDate(path)[myid]; 
        String time2 = read.readSecondTime(path)[myid]; 
        String ctr2 = read.readSecondDateCtr(path)[myid]; 
        String stat2 = read.readSecondStatus(path)[myid];
        previewDose1(stat, date, times, ctr, idi);
        previewDose2(date2, time2, ctr2, stat2, idi);
        
   }
   
   private void previewDose1(String stat, String date, String times, String ctr, String idi){
       if(date.equals("TBA") && stat.equals("NO")){
           //set visible true
           remarks.setVisible(true);
           
           //set visible false
           guide1.setVisible(false); guide2.setVisible(false); guide3.setVisible(false);
           date1.setVisible(false); time1.setVisible(false); venue1.setVisible(false);
           
           //button
           confirm.setVisible(false); cancel.setVisible(false);
           
           //miscellaneous
           title.setVisible(false); completed.setVisible(false);
           text.setVisible(false); id.setVisible(false);
           jTabbedPane2.setEnabledAt(1, false); text1.setVisible(false);
           
       } else if (!date.equals("TBA") && stat.equals("NO")){
           //set text
           date1.setText(date); time1.setText(times); venue1.setText(ctr); id.setText(idi);
           text1.setText("Cancelled appointments will be rescheduled.");
           
           //set visible true
           guide1.setVisible(true); guide2.setVisible(true); guide3.setVisible(true);
           date1.setVisible(true); time1.setVisible(true); venue1.setVisible(true);
           text1.setVisible(true);
           
           //set visible false
           remarks.setVisible(false);
           
           //button
           confirm.setVisible(true); cancel.setVisible(true);    
           
           //miscellaneous
           title.setVisible(true); completed.setVisible(false);
           text.setVisible(true); id.setVisible(true); text1.setVisible(false);
           jTabbedPane2.setEnabledAt(1, false);
           
       } else if(!date.equals("TBA") && stat.equals("CONFIRMED")){
           //set text
           date1.setText(date); time1.setText(times); venue1.setText(ctr); 
           text1.setText("Any missed appointments would be cancelled.");
           
           //set visible true
           guide1.setVisible(true); guide2.setVisible(true); guide3.setVisible(true);
           date1.setVisible(true); time1.setVisible(true); venue1.setVisible(true);
           
           //set visible false
           remarks.setVisible(false); 
           
           //button
           confirm.setVisible(false); cancel.setVisible(false);    
           
           //miscellaneous
           title.setVisible(true); completed.setVisible(false);
           text.setText("Appointment confirmed.");
           text.setVisible(true); 
           text1.setVisible(true);
           id.setVisible(false); 
           jTabbedPane2.setEnabledAt(1, false);
           
       } else if(!date.equals("TBA") && stat.equals("DONE")) {
           //set visible true
           completed.setVisible(true);
           
           //set visible false
           guide1.setVisible(false); guide2.setVisible(false); guide3.setVisible(false);
           date1.setVisible(false); time1.setVisible(false); venue1.setVisible(false);
           remarks.setVisible(false);
           
           //button
           confirm.setVisible(false); cancel.setVisible(false);  
           
           //miscellaneous
           title.setVisible(false); text1.setVisible(false);
           text.setVisible(false); id.setVisible(false); 
       }
       
   }
   
   private void previewDose2(String date2, String times2, String ctr2, String stat2, String idi){
       if(date2.equals("TBA") && stat2.equals("NO")){
           //set visible true
           remarks2.setVisible(true);
           
           //set visible false
           guide4.setVisible(false); guide5.setVisible(false); guide6.setVisible(false);
           date3.setVisible(false); time2.setVisible(false); venue3.setVisible(false);
           
           //button
           confirm2.setVisible(false); cancel2.setVisible(false); 
           
           //miscellaneous
           title2.setVisible(false); completed1.setVisible(false);
           text2.setVisible(false); id2.setVisible(false);
           text3.setVisible(false);
       }
       
       else if (!date2.equals("TBA") && stat2.equals("NO")){
           //set text
           date3.setText(date2); time2.setText(times2); venue3.setText(ctr2); id2.setText(idi);
           text3.setText("Cancelled appointments will be rescheduled.");
           
           //set visible true
           guide4.setVisible(true); guide5.setVisible(true); guide6.setVisible(true);
           date3.setVisible(true); time2.setVisible(true); venue3.setVisible(true);
           
           //set visible false
           remarks2.setVisible(false); 
           
           //button
           confirm2.setVisible(true); cancel2.setVisible(true);    
           
           //miscellaneous
           title2.setVisible(true); completed1.setVisible(false);
           text2.setVisible(true); id2.setVisible(true); 
           text3.setVisible(true);
       } 
       
        else if(!date2.equals("TBA") && stat2.equals("CONFIRMED")){
           //set text
           date3.setText(date2); time2.setText(times2); venue3.setText(ctr2); 
           text3.setText("Any missed appointments would be cancelled.");
           
           //set visible true
           guide4.setVisible(true); guide5.setVisible(true); guide6.setVisible(true);
           date3.setVisible(true); time2.setVisible(true); venue3.setVisible(true);
           
           //set visible false
           remarks2.setVisible(false); 
           
           //button
           confirm2.setVisible(false); cancel2.setVisible(false);    
           
           //miscellaneous
           title2.setVisible(true); completed1.setVisible(false);
           text2.setText("Appointment confirmed.");
           text2.setVisible(true); 
           text3.setVisible(true);
           id2.setVisible(false); 
           
       } else {
           //set visible true
           completed1.setVisible(true); 
           
           //set visible false
           guide4.setVisible(false); guide5.setVisible(false); guide6.setVisible(false);
           date3.setVisible(false); time2.setVisible(false); venue3.setVisible(false);
           remarks2.setVisible(false); 
           
           //button
           confirm2.setVisible(false); cancel2.setVisible(false);  
           
           //miscellaneous
           title2.setVisible(false); text3.setVisible(false);
           text2.setVisible(false); id2.setVisible(false); 
            
        }
       
   }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jMenu2 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        dateUtil1 = new com.toedter.calendar.DateUtil();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTextField1 = new javax.swing.JTextField();
        jTextFieldDateEditor1 = new com.toedter.calendar.JTextFieldDateEditor();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        guide1 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        guide2 = new javax.swing.JLabel();
        guide3 = new javax.swing.JLabel();
        venue1 = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        remarks = new javax.swing.JLabel();
        text = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        completed = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        guide4 = new javax.swing.JLabel();
        date3 = new javax.swing.JLabel();
        guide5 = new javax.swing.JLabel();
        time2 = new javax.swing.JLabel();
        guide6 = new javax.swing.JLabel();
        venue3 = new javax.swing.JLabel();
        confirm2 = new javax.swing.JButton();
        cancel2 = new javax.swing.JButton();
        remarks2 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        id2 = new javax.swing.JLabel();
        completed1 = new javax.swing.JLabel();
        text3 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jButton4.setText("jButton4");

        jMenu2.setText("jMenu2");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setText("Search by");

        jComboBox2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not", "Partial", "Fully" }));

        jTextField1.setText("jTextField1");

        jTextFieldDateEditor1.setText("jTextFieldDateEditor1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 50));
        jLabel2.setText("• COVID-19 VACCINATION REGISTRATION SYSTEM");

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText(" APPOINTMENT");

        jTabbedPane2.setForeground(new java.awt.Color(0, 102, 51));
        jTabbedPane2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Poppins", 3, 12)); // NOI18N
        title.setForeground(new java.awt.Color(0, 102, 51));
        title.setText("DOSE • 1");

        guide1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        guide1.setForeground(new java.awt.Color(0, 102, 51));
        guide1.setText("Date ");

        date1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        date1.setForeground(new java.awt.Color(0, 102, 51));
        date1.setText("Date");

        time1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        time1.setForeground(new java.awt.Color(0, 102, 51));
        time1.setText("Time");

        guide2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        guide2.setForeground(new java.awt.Color(0, 102, 51));
        guide2.setText("Time");

        guide3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        guide3.setForeground(new java.awt.Color(0, 102, 51));
        guide3.setText("Venue");

        venue1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        venue1.setForeground(new java.awt.Color(0, 102, 51));
        venue1.setText("Venue");

        confirm.setBackground(new java.awt.Color(255, 255, 255));
        confirm.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        confirm.setForeground(new java.awt.Color(0, 102, 51));
        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cancel.setForeground(new java.awt.Color(0, 102, 51));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        remarks.setFont(new java.awt.Font("Poppins", 1, 10)); // NOI18N
        remarks.setForeground(new java.awt.Color(0, 102, 51));
        remarks.setText("There is no appointment scheduled for you at the moment.");

        text.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        text.setForeground(new java.awt.Color(0, 102, 51));
        text.setText("This appointment is scheduled for user ID ");

        id.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        id.setForeground(new java.awt.Color(0, 102, 51));
        id.setText("ID");

        completed.setFont(new java.awt.Font("Poppins", 1, 10)); // NOI18N
        completed.setForeground(new java.awt.Color(0, 102, 51));
        completed.setText("First dose completed.");

        text1.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        text1.setForeground(new java.awt.Color(0, 102, 51));
        text1.setText("Any missed appointments would be cancelled.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(title)
                                .addGap(18, 18, 18)
                                .addComponent(completed))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(guide2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(time1))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(guide1)
                                    .addGap(42, 42, 42)
                                    .addComponent(date1)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(guide3)
                                .addGap(36, 36, 36)
                                .addComponent(venue1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(confirm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(text1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(remarks)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(completed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text)
                    .addComponent(id))
                .addGap(1, 1, 1)
                .addComponent(text1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guide1)
                    .addComponent(date1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guide2)
                    .addComponent(time1))
                .addGap(9, 9, 9)
                .addComponent(remarks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guide3)
                    .addComponent(venue1))
                .addGap(18, 18, 18)
                .addComponent(confirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dose 1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        title2.setFont(new java.awt.Font("Poppins", 3, 12)); // NOI18N
        title2.setForeground(new java.awt.Color(0, 102, 51));
        title2.setText("DOSE • 2");

        guide4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        guide4.setForeground(new java.awt.Color(0, 102, 51));
        guide4.setText("Date ");

        date3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        date3.setForeground(new java.awt.Color(0, 102, 51));
        date3.setText("Date");

        guide5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        guide5.setForeground(new java.awt.Color(0, 102, 51));
        guide5.setText("Time");

        time2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        time2.setForeground(new java.awt.Color(0, 102, 51));
        time2.setText("Time");

        guide6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        guide6.setForeground(new java.awt.Color(0, 102, 51));
        guide6.setText("Venue");

        venue3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        venue3.setForeground(new java.awt.Color(0, 102, 51));
        venue3.setText("Venue");

        confirm2.setBackground(new java.awt.Color(255, 255, 255));
        confirm2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        confirm2.setForeground(new java.awt.Color(0, 102, 51));
        confirm2.setText("Confirm");
        confirm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm2ActionPerformed(evt);
            }
        });

        cancel2.setBackground(new java.awt.Color(255, 255, 255));
        cancel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cancel2.setForeground(new java.awt.Color(0, 102, 51));
        cancel2.setText("Cancel");
        cancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel2ActionPerformed(evt);
            }
        });

        remarks2.setFont(new java.awt.Font("Poppins", 1, 10)); // NOI18N
        remarks2.setForeground(new java.awt.Color(0, 102, 51));
        remarks2.setText("There is no appointment scheduled for you at the moment.");

        text2.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        text2.setForeground(new java.awt.Color(0, 102, 51));
        text2.setText("This appointment is scheduled for user ID ");

        id2.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        id2.setForeground(new java.awt.Color(0, 102, 51));
        id2.setText("ID");

        completed1.setFont(new java.awt.Font("Poppins", 1, 10)); // NOI18N
        completed1.setForeground(new java.awt.Color(0, 102, 51));
        completed1.setText("Second dose completed.");

        text3.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        text3.setForeground(new java.awt.Color(0, 102, 51));
        text3.setText("Any missed appointments would be cancelled.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(text2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(title2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(completed1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(guide6)
                                .addGap(36, 36, 36)
                                .addComponent(venue3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(guide5)
                                    .addGap(44, 44, 44)
                                    .addComponent(time2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(guide4)
                                    .addGap(43, 43, 43)
                                    .addComponent(date3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(text3)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(remarks2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(confirm2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title2)
                    .addComponent(completed1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id2)
                    .addComponent(text2))
                .addGap(1, 1, 1)
                .addComponent(text3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guide4)
                    .addComponent(date3))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guide5)
                    .addComponent(time2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remarks2)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(venue3)
                    .addComponent(guide6))
                .addGap(18, 18, 18)
                .addComponent(confirm2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel2)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dose 2", jPanel4);

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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void confirm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm2ActionPerformed
        // TODO add your handling code here:
        User u = new User();
        Appointment a = new Appointment();
        String line = id2.getText() + "-" + date3.getText() + "-" + time2.getText() + "-" + venue3.getText() +
                "-" + "2nd Dose";
        try {
            u.confirmAppointment(Integer.parseInt(id2.getText()));
            JOptionPane.showMessageDialog(null, "You have confirmed the appointment!");
            a.addToTable(line);
            confirm2.setVisible(false); cancel2.setVisible(false); text2.setText("APPOINTMENT CONFIRMED");
            id2.setVisible(false);
        } catch (IOException ex){
            Logger.getLogger(People_Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }//GEN-LAST:event_confirm2ActionPerformed

    private void cancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel2ActionPerformed
        // TODO add your handling code here:
        User u = new User();
        try {
            u.cancelAppointment(Integer.parseInt(id2.getText()));
            JOptionPane.showMessageDialog(null, "You have cancelled the appointment!");
            confirm2.setVisible(false); cancel2.setVisible(false); text2.setText("APPOINTMENT CANCELLED");
            text2.setText("Please stay tuned for the reschedule.");
            id2.setVisible(false);
        } catch (IOException ex){
            Logger.getLogger(People_Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancel2ActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        User u = new User();
        Appointment a = new Appointment();
        String line = id.getText() + "-" + date1.getText() + "-" + time1.getText() + "-" + venue1.getText() +
                "-" + "1st Dose";
        try {
            u.confirmAppointment(Integer.parseInt(id.getText()));
            a.addToTable(line);
            JOptionPane.showMessageDialog(null, "You have confirmed the appointment!");
            confirm.setVisible(false); cancel.setVisible(false); text.setText("APPOINTMENT CONFIRMED");
            id.setVisible(false);
        } catch (IOException ex){
            Logger.getLogger(People_Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
    }//GEN-LAST:event_confirmActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        User u = new User();
        try {
            u.cancelAppointment(Integer.parseInt(id.getText()));
            JOptionPane.showMessageDialog(null, "You have cancelled the appointment!");
            confirm.setVisible(false); cancel.setVisible(false); text.setText("APPOINTMENT CANCELLED");
            text2.setText("Please stay tuned for the reschedule.");id.setVisible(false);
        } catch (IOException ex){
            Logger.getLogger(People_Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(People_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(People_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(People_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(People_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                    String idi = null;
                    String username = null;
                try {
                    new People_Appointment(idi, username).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(People_Appointment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancel;
    private javax.swing.JButton cancel2;
    private javax.swing.JLabel completed;
    private javax.swing.JLabel completed1;
    private javax.swing.JButton confirm;
    private javax.swing.JButton confirm2;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel date3;
    private com.toedter.calendar.DateUtil dateUtil1;
    private javax.swing.JLabel guide1;
    private javax.swing.JLabel guide2;
    private javax.swing.JLabel guide3;
    private javax.swing.JLabel guide4;
    private javax.swing.JLabel guide5;
    private javax.swing.JLabel guide6;
    private javax.swing.JLabel id;
    private javax.swing.JLabel id2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JTextFieldDateEditor jTextFieldDateEditor1;
    private javax.swing.JLabel remarks;
    private javax.swing.JLabel remarks2;
    private javax.swing.JLabel text;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel time1;
    private javax.swing.JLabel time2;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel venue1;
    private javax.swing.JLabel venue3;
    // End of variables declaration//GEN-END:variables
}
