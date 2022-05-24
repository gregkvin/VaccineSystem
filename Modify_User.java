/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oodj_assignment.User;
import oodj_assignment.modify;


/*
 *
 * 
 */
public class Modify_User extends javax.swing.JFrame {
    
    public Modify_User(String idi) throws IOException, ParseException {
        initComponents();
        setResizable(false);
        setTextField(idi);
        previewData();
        loadCentre();
        disablePastDate();
        cancelAutomatically();
    }
    
    private void setTextField(String idi) throws IOException{
        User read = new User();
        String path = "login.txt";
        int myid = Integer.parseInt(idi);
        myid = myid - 1;id.setText(idi);
        String namee = read.readName(path)[myid]; name.setText(namee);
        String usernamee = read.readUsername(path)[myid]; usernameee.setText(usernamee);
        String dobb = read.readDOB(path)[myid]; dob.setText(dobb);
        String emaill = read.readEmail(path)[myid]; email.setText(emaill);
        String nation = read.readNation(path)[myid]; nationality.setText(nation);
        String statuss = read.readStatus(path)[myid]; stslabel.setText(statuss);
        String date = read.readFirstDate(path)[myid]; date1lbl.setText(date);
        String times = read.readFirstTime(path)[myid]; time1lbl.setText(times); 
        String ctr = read.readFirstDateCtr(path)[myid]; venue1lbl.setText(ctr);
        String stat = read.readFirstStatus(path)[myid]; sts1lbl.setText(stat);
        String date2 = read.readSecondDate(path)[myid]; date2lbl.setText(date2); 
        String time2 = read.readSecondTime(path)[myid]; time2lbl.setText(time2); 
        String ctr2 = read.readSecondDateCtr(path)[myid]; venue2lbl.setText(ctr2);
        String stat2 = read.readSecondStatus(path)[myid];sts2lbl.setText(stat2);
        
        
    }
    
    private void disablePastDate(){
        //dose 1
        Date d = new Date();
        dateedit.getJCalendar().setMinSelectableDate(d);
        
        //dose 2
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 14);
        dateedit2.getJCalendar().setMinSelectableDate(c.getTime());
    }
    
    private void loadCentre() throws IOException{
        Centre c = new Centre();
        String[] ctr = c.ReadCentre();
        venue.setModel(new javax.swing.DefaultComboBoxModel(ctr));
        venue2.setModel(new javax.swing.DefaultComboBoxModel(ctr));
    }
    
    private void previewData(){
        //pane
        jTabbedPane2.setEnabledAt(2, false);
        
        //functions
        previewProfile();
        
        previewDose1();
        
        previewDose2();
    }
    
    
    private void previewProfile(){
        //profile 
        id.setEditable(false);name.setEditable(false);usernameee.setEditable(false);dob.setEditable(false);
        email.setEditable(false); nationality.setEditable(false);stslabel.setVisible(true);status.setVisible(false);
        edit.setVisible(true); remarks.setVisible(false); remarks1.setVisible(false);
        
        //button
        preview.setVisible(false); save.setVisible(false);
    }
    
    private void previewDose1(){
        //dose 1
        //set visible: true
        date1lbl.setVisible(true); time1lbl.setVisible(true); venue1lbl.setVisible(true); sts1lbl.setVisible(true);
        
        //set visible: false
        dateedit.setVisible(false); time.setVisible(false); venue.setVisible(false); done1.setVisible(false);
        
        //conditions
        if(sts1lbl.getText().equals("NO")){
            editappoint1.setVisible(true);
            editsts1.setVisible(false);
        } else if(sts1lbl.getText().equals("CONFIRMED")){
            editappoint1.setVisible(false);
            editsts1.setVisible(true);
            remarks.setVisible(true);
        } else {
            editappoint1.setVisible(false);
            editsts1.setVisible(false);
            remarks.setText("First dose completed!");
            jTabbedPane2.setEnabledAt(2, true);
            remarks.setVisible(true); 
        }
        
        //button
        preview1.setVisible(false); previewstat1.setVisible(false);save1.setVisible(false);
    }
   
    private void previewDose2(){
        //dose 2
        //set visible: true
        date2lbl.setVisible(true); time2lbl.setVisible(true); venue2lbl.setVisible(true);sts2lbl.setVisible(true);
        
        //set visible: false
        dateedit2.setVisible(false); time2.setVisible(false); venue2.setVisible(false); done2.setVisible(false);
        
        //conditions
        if(sts2lbl.getText().equals("NO")){
            editappoint2.setVisible(true);
            editsts2.setVisible(false);
        } else if(sts2lbl.getText().equals("CONFIRMED")){
            editappoint2.setVisible(false);
            editsts2.setVisible(true);
            remarks1.setVisible(true);
        } else {
            editappoint2.setVisible(false);
            editsts2.setVisible(false);
            remarks1.setText("Second dose completed!");
            remarks1.setVisible(true);
        }  
        
        //button
        preview2.setVisible(false); previewstat2.setVisible(false);save2.setVisible(false);
    }
    
    private void editPersonnel(){
        //set editable
        id.setEditable(true);name.setEditable(true);usernameee.setEditable(true);dob.setEditable(true);
        email.setEditable(true); nationality.setEditable(true); status.setVisible(true);
        status.setSelectedItem(stslabel); stslabel.setVisible(false); preview.setVisible(true);
        
        //set visible false
        edit.setVisible(false); save.setVisible(false);
        
        
    }
    
    private void editAppointment1() throws ParseException{
        //set date
        String dd = date1lbl.getText();
        if(!date1lbl.getText().equals("TBA")){
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dd);
            dateedit.setDate(date);   
        }  
        
        //set text/item
        time.setSelectedItem(time1lbl.getText()); venue.setSelectedItem(venue1lbl.getText());
        
        //set visible: true
        dateedit.setVisible(true); time.setVisible(true); venue.setVisible(true); sts1lbl.setVisible(true);
        
        //set visible: false
        date1lbl.setVisible(false); time1lbl.setVisible(false); venue1lbl.setVisible(false);done1.setVisible(false);
        
        //button
        editappoint1.setVisible(false); editsts1.setVisible(false);preview1.setVisible(true); save1.setVisible(false); 
        
    }
    
    
    private void editStatus1() {
        //set visible: true
        done1.setVisible(true);
        
        //set visible: false
        sts1lbl.setVisible(false);
        
        //button
        editappoint1.setVisible(false); editsts1.setVisible(false);
        preview1.setVisible(false); previewstat1.setVisible(true); save1.setVisible(false);
        
    }
    
    private void previewStatus1(){
        //set visible: true
        if(done1.isSelected()){
            sts1lbl.setText("DONE");
        } else {
            sts1lbl.setText("CONFIRMED");
        }
        sts1lbl.setVisible(true);
        
        //set visible: false
        done1.setVisible(false);
        
        //button
        editappoint1.setVisible(false); editsts1.setVisible(true);
        preview1.setVisible(false); previewstat1.setVisible(false); save1.setVisible(true);
    }
    
    private void editAppointment2() throws ParseException{
        //set date
        String dd = date2lbl.getText();
        if(!date2lbl.getText().equals("TBA")){
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dd);
            dateedit2.setDate(date);   
        }  
        
        //set text/item
        time2.setSelectedItem(time2lbl.getText()); venue2.setSelectedItem(venue2lbl.getText());
        
        //set visible: true
        dateedit2.setVisible(true); time2.setVisible(true); venue2.setVisible(true); sts2lbl.setVisible(true);
        
        //set visible: false
        date2lbl.setVisible(false); time2lbl.setVisible(false); venue2lbl.setVisible(false);done2.setVisible(false);
        
        //button
        editappoint2.setVisible(false); editsts2.setVisible(false);preview2.setVisible(true); save2.setVisible(false); 
        
    }
    
     private void editStatus2() {
        //set visible: true
        done2.setVisible(true);
        
        //set visible: false
        sts2lbl.setVisible(false);
        
        //button
        editappoint2.setVisible(false); editsts2.setVisible(false);
        preview2.setVisible(false); previewstat2.setVisible(true); save2.setVisible(false);
        
    }
     
    private void previewStatus2(){
        //set visible: true
        if(done2.isSelected()){
            sts2lbl.setText("DONE");
        } else {
            sts2lbl.setText("CONFIRMED");
        }
        sts2lbl.setVisible(true);
        
        //set visible: false
        done2.setVisible(false);
        
        //button
        editappoint2.setVisible(false); editsts2.setVisible(true);
        preview2.setVisible(false); previewstat2.setVisible(false); save2.setVisible(true);
    }
    
    private void cancelAutomatically() throws ParseException, IOException{
        User u = new User();
        Appointment a = new Appointment();
        String now = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        Date today = new SimpleDateFormat("dd/MM/yyyy").parse(now);
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DATE, 1);
        String dt = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(dt);
        if(!date1lbl.getText().equals("TBA")){
        //1st dose
        String dd = date1lbl.getText();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dd);
        if(sts1lbl.getText().equals("CONFIRMED") && d.compareTo(date)>0){
            String line = id.getText() + "-" + date1lbl.getText() + "-" + 
                           time1lbl.getText() + "-" + venue1lbl.getText() +
                "-" + "1st Dose";
                   a.removeAppointment(line);
            u.cancelAppointment(Integer.parseInt(id.getText()));
            
        }
        }else if(!date2lbl.getText().equals("TBA")){
        //2nd dose
        String dd2 = date2lbl.getText();
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(dd2); 
         if (sts2lbl.getText().equals("CONFIRMED") && d.compareTo(date2)>0){
           String line = id.getText() + "-" + date2lbl.getText() + "-" + 
                           time2lbl.getText() + "-" + venue2lbl.getText() +
                "-" + "2nd Dose";
                   a.removeAppointment(line);
            u.cancelAppointment(Integer.parseInt(id.getText())); 
        }
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
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        usernameee = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dob = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        nationality = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        stslabel = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        edit = new javax.swing.JButton();
        preview = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dateedit = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        time = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        venue = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        editappoint1 = new javax.swing.JButton();
        date1lbl = new javax.swing.JLabel();
        venue1lbl = new javax.swing.JLabel();
        sts1lbl = new javax.swing.JLabel();
        editsts1 = new javax.swing.JButton();
        time1lbl = new javax.swing.JLabel();
        remarks = new javax.swing.JLabel();
        preview1 = new javax.swing.JButton();
        save1 = new javax.swing.JButton();
        previewstat1 = new javax.swing.JButton();
        done1 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dateedit2 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        time2 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        venue2 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        date2lbl = new javax.swing.JLabel();
        venue2lbl = new javax.swing.JLabel();
        sts2lbl = new javax.swing.JLabel();
        time2lbl = new javax.swing.JLabel();
        editappoint2 = new javax.swing.JButton();
        editsts2 = new javax.swing.JButton();
        remarks1 = new javax.swing.JLabel();
        preview2 = new javax.swing.JButton();
        save2 = new javax.swing.JButton();
        done2 = new javax.swing.JCheckBox();
        previewstat2 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("• COVID-19 VACCINATION REGISTRATION SYSTEM");

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("USER DATA");

        jTabbedPane2.setForeground(new java.awt.Color(0, 102, 204));
        jTabbedPane2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("ID");

        id.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setText("Name");

        name.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText("Username");

        usernameee.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 204));
        jLabel10.setText("Date of Birth");

        dob.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setText("Email");

        email.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 204));
        jLabel12.setText("Nationality");

        nationality.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("Vacc. Status");

        stslabel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        stslabel.setForeground(new java.awt.Color(0, 102, 204));
        stslabel.setText("Sts");

        status.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not", "Partial", "Fully" }));

        edit.setBackground(new java.awt.Color(255, 255, 255));
        edit.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        edit.setForeground(new java.awt.Color(0, 102, 204));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        preview.setBackground(new java.awt.Color(255, 255, 255));
        preview.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        preview.setForeground(new java.awt.Color(0, 102, 204));
        preview.setText("Preview");
        preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        save.setForeground(new java.awt.Color(0, 102, 204));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(260, 260, 260))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(stslabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameee, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(usernameee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(stslabel)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Profile", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Poppins", 3, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 204));
        jLabel14.setText("DOSE 1");

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 204));
        jLabel15.setText("Date");

        dateedit.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 204));
        jLabel16.setText("Time");

        time.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        time.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00" }));

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 204));
        jLabel17.setText("Venue");

        venue.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        venue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CIDB Convention Centre", "Bukit Jalil Stadium" }));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("Status");

        editappoint1.setBackground(new java.awt.Color(255, 255, 255));
        editappoint1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        editappoint1.setForeground(new java.awt.Color(0, 102, 204));
        editappoint1.setText("Edit Appointment");
        editappoint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editappoint1ActionPerformed(evt);
            }
        });

        date1lbl.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        date1lbl.setForeground(new java.awt.Color(0, 102, 204));
        date1lbl.setText("Date");

        venue1lbl.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        venue1lbl.setForeground(new java.awt.Color(0, 102, 204));
        venue1lbl.setText("Ven");

        sts1lbl.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        sts1lbl.setForeground(new java.awt.Color(0, 102, 204));
        sts1lbl.setText("Ven");

        editsts1.setBackground(new java.awt.Color(255, 255, 255));
        editsts1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        editsts1.setForeground(new java.awt.Color(0, 102, 204));
        editsts1.setText("Edit Status ");
        editsts1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editsts1ActionPerformed(evt);
            }
        });

        time1lbl.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        time1lbl.setForeground(new java.awt.Color(0, 102, 204));
        time1lbl.setText("Time");

        remarks.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        remarks.setForeground(new java.awt.Color(0, 102, 204));
        remarks.setText("Confirmed appointments cannot be modified further.");

        preview1.setBackground(new java.awt.Color(255, 255, 255));
        preview1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        preview1.setForeground(new java.awt.Color(0, 102, 204));
        preview1.setText("Preview");
        preview1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preview1ActionPerformed(evt);
            }
        });

        save1.setBackground(new java.awt.Color(255, 255, 255));
        save1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        save1.setForeground(new java.awt.Color(0, 102, 204));
        save1.setText("Save");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });

        previewstat1.setBackground(new java.awt.Color(255, 255, 255));
        previewstat1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        previewstat1.setForeground(new java.awt.Color(0, 102, 204));
        previewstat1.setText("Preview");
        previewstat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewstat1ActionPerformed(evt);
            }
        });

        done1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        done1.setText("DONE");
        done1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(previewstat1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel21))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(dateedit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(date1lbl))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(venue, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(venue1lbl))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(time1lbl))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(sts1lbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(done1))))
                            .addComponent(remarks)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editappoint1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editsts1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(preview1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(dateedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date1lbl))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time1lbl))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(venue, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venue1lbl))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(sts1lbl)
                    .addComponent(done1))
                .addGap(18, 18, 18)
                .addComponent(remarks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(editappoint1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editsts1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preview1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewstat1)
                .addGap(21, 21, 21))
        );

        jTabbedPane2.addTab("Dose 1", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Poppins", 3, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 204));
        jLabel18.setText("DOSE 2");

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText("Date");

        dateedit2.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 204));
        jLabel20.setText("Time");

        time2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        time2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00" }));

        jLabel22.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 204));
        jLabel22.setText("Venue");

        venue2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        venue2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CIDB Convention Centre", "Bukit Jalil Stadium" }));

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 204));
        jLabel23.setText("Status");

        date2lbl.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        date2lbl.setForeground(new java.awt.Color(0, 102, 204));
        date2lbl.setText("Date");

        venue2lbl.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        venue2lbl.setForeground(new java.awt.Color(0, 102, 204));
        venue2lbl.setText("Ven");

        sts2lbl.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        sts2lbl.setForeground(new java.awt.Color(0, 102, 204));
        sts2lbl.setText("Ven");

        time2lbl.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        time2lbl.setForeground(new java.awt.Color(0, 102, 204));
        time2lbl.setText("Time");

        editappoint2.setBackground(new java.awt.Color(255, 255, 255));
        editappoint2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        editappoint2.setForeground(new java.awt.Color(0, 102, 204));
        editappoint2.setText("Edit Appointment");
        editappoint2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editappoint2ActionPerformed(evt);
            }
        });

        editsts2.setBackground(new java.awt.Color(255, 255, 255));
        editsts2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        editsts2.setForeground(new java.awt.Color(0, 102, 204));
        editsts2.setText("Edit Status ");
        editsts2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editsts2ActionPerformed(evt);
            }
        });

        remarks1.setFont(new java.awt.Font("Poppins", 2, 10)); // NOI18N
        remarks1.setForeground(new java.awt.Color(0, 102, 204));
        remarks1.setText("Confirmed appointments cannot be modified further.");

        preview2.setBackground(new java.awt.Color(255, 255, 255));
        preview2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        preview2.setForeground(new java.awt.Color(0, 102, 204));
        preview2.setText("Preview");
        preview2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preview2ActionPerformed(evt);
            }
        });

        save2.setBackground(new java.awt.Color(255, 255, 255));
        save2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        save2.setForeground(new java.awt.Color(0, 102, 204));
        save2.setText("Save");
        save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save2ActionPerformed(evt);
            }
        });

        done2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        done2.setText("DONE");

        previewstat2.setBackground(new java.awt.Color(255, 255, 255));
        previewstat2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        previewstat2.setForeground(new java.awt.Color(0, 102, 204));
        previewstat2.setText("Preview");
        previewstat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewstat2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(venue2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(venue2lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addComponent(dateedit2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10))
                                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addComponent(time2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(6, 6, 6)))
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(time2lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                                    .addComponent(date2lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(sts2lbl)
                                        .addGap(18, 18, 18)
                                        .addComponent(done2)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(remarks1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(237, 255, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editappoint2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editsts2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(preview2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(previewstat2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(dateedit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date2lbl))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time2lbl))
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(venue2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venue2lbl))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(sts2lbl)
                    .addComponent(done2))
                .addGap(18, 18, 18)
                .addComponent(remarks1)
                .addGap(16, 16, 16)
                .addComponent(editappoint2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editsts2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(save2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preview2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewstat2)
                .addGap(23, 23, 23))
        );

        jTabbedPane2.addTab("Dose 2", jPanel5);

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        back.setForeground(new java.awt.Color(0, 102, 204));
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(back)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void previewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewActionPerformed
        previewProfile();
        stslabel.setText(status.getSelectedItem().toString());
        save.setVisible(true);
    }//GEN-LAST:event_previewActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        User u = new User();
        Appointment a = new Appointment();
        String [] input = {id.getText(),name.getText(),usernameee.getText(),dob.getText(),email.getText(),
            nationality.getText(),stslabel.getText()};
        
        if(id.getText().equals(" ")||name.getText().equals(" ")|| usernameee.getText().equals(" ")||
                dob.getText().equals(" ")|| email.getText().equals(" ")||
                nationality.getText().equals(" ")|| stslabel.getText().equals(" ")){
            JOptionPane.showMessageDialog(null, "Incomplete credentials, you have not fill one or more information.");
        } else {
            u.modifyUser(Integer.parseInt(id.getText()), input);
            JOptionPane.showMessageDialog(null, "Saved successfully!\nPress REFRESH to update table.");
            save.setVisible(false);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void editappoint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editappoint1ActionPerformed
        try {
            editAppointment1();
        } catch (ParseException ex) {
            Logger.getLogger(Modify_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editappoint1ActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        editPersonnel();
    }//GEN-LAST:event_editActionPerformed

    private void editsts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editsts1ActionPerformed
        editStatus1();
    }//GEN-LAST:event_editsts1ActionPerformed

    private void editappoint2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editappoint2ActionPerformed
        try {
            editAppointment2();
        } catch (ParseException ex) {
            Logger.getLogger(Modify_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editappoint2ActionPerformed

    private void editsts2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editsts2ActionPerformed
        // TODO add your handling code here:
        editStatus2();
    }//GEN-LAST:event_editsts2ActionPerformed

    private void preview1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preview1ActionPerformed
        Date dates = dateedit.getDate();
        if(dates == null){
            JOptionPane.showMessageDialog(null, "Incomplete credentials, you have not fill one or more information.");
        } else {
        previewDose1();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(dateedit.getDate());
        date1lbl.setText(date);
        time1lbl.setText(time.getSelectedItem().toString());
        venue1lbl.setText(venue.getSelectedItem().toString());
        save1.setVisible(true);
        }
    }//GEN-LAST:event_preview1ActionPerformed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed

           try {
               User u = new User();
               Appointment a = new Appointment();
               String[] input = {date1lbl.getText(), time1lbl.getText(), venue1lbl.getText(), sts1lbl.getText()};
               a.AppointmentDose1(Integer.parseInt(id.getText()), input);
               if(input[3].equals("DONE")){
                   editsts1.setVisible(false);
                   String line = id.getText() + "-" + date1lbl.getText() + "-" + 
                           time1lbl.getText() + "-" + venue1lbl.getText() +
                "-" + "1st Dose";
                   a.removeAppointment(line);
               } 
               JOptionPane.showMessageDialog(null, "Appointment saved successfully!");
               save1.setVisible(false);
               
           } catch (IOException ex) {
               Logger.getLogger(Modify_User.class.getName()).log(Level.SEVERE, null, ex);
           }
    
    }//GEN-LAST:event_save1ActionPerformed

    private void preview2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preview2ActionPerformed
        previewDose2();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(dateedit2.getDate());
        date2lbl.setText(date);
        time2lbl.setText(time2.getSelectedItem().toString());
        venue2lbl.setText(venue2.getSelectedItem().toString());
        save2.setVisible(true);
    }//GEN-LAST:event_preview2ActionPerformed

    private void save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save2ActionPerformed
        try {
               Appointment a = new Appointment();
               String[] input = {date2lbl.getText(), time2lbl.getText(), venue2lbl.getText(), sts2lbl.getText()};
               a.AppointmentDose2(Integer.parseInt(id.getText()), input);
               JOptionPane.showMessageDialog(null, "Appointment saved successfully!");
               save2.setVisible(false);
               if(input[3].equals("DONE")){
                   editsts2.setVisible(false);
                   String line = id.getText() + "-" + date2lbl.getText() + "-" + 
                           time2lbl.getText() + "-" + venue2lbl.getText() +
                "-" + "2nd Dose";
                   a.removeAppointment(line);
               }
               
           } catch (IOException ex) {
               Logger.getLogger(Modify_User.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_save2ActionPerformed

    private void previewstat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewstat1ActionPerformed
        // TODO add your handling code here:
        previewStatus1();
    }//GEN-LAST:event_previewstat1ActionPerformed

    private void previewstat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewstat2ActionPerformed
        // TODO add your handling code here:
        previewStatus2();
    }//GEN-LAST:event_previewstat2ActionPerformed

    private void done1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_done1ActionPerformed

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
            java.util.logging.Logger.getLogger(Modify_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modify_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modify_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modify_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    String idi = null;
                try {
                    new Modify_User(idi).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Modify_User.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Modify_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel date1lbl;
    private javax.swing.JLabel date2lbl;
    private com.toedter.calendar.DateUtil dateUtil1;
    private com.toedter.calendar.JDateChooser dateedit;
    private com.toedter.calendar.JDateChooser dateedit2;
    private javax.swing.JTextField dob;
    private javax.swing.JCheckBox done1;
    private javax.swing.JCheckBox done2;
    private javax.swing.JButton edit;
    private javax.swing.JButton editappoint1;
    private javax.swing.JButton editappoint2;
    private javax.swing.JButton editsts1;
    private javax.swing.JButton editsts2;
    private javax.swing.JTextField email;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nationality;
    private javax.swing.JButton preview;
    private javax.swing.JButton preview1;
    private javax.swing.JButton preview2;
    private javax.swing.JButton previewstat1;
    private javax.swing.JButton previewstat2;
    private javax.swing.JLabel remarks;
    private javax.swing.JLabel remarks1;
    private javax.swing.JButton save;
    private javax.swing.JButton save1;
    private javax.swing.JButton save2;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JLabel sts1lbl;
    private javax.swing.JLabel sts2lbl;
    private javax.swing.JLabel stslabel;
    private javax.swing.JComboBox<String> time;
    private javax.swing.JLabel time1lbl;
    private javax.swing.JComboBox<String> time2;
    private javax.swing.JLabel time2lbl;
    private javax.swing.JTextField usernameee;
    private javax.swing.JComboBox<String> venue;
    private javax.swing.JLabel venue1lbl;
    private javax.swing.JComboBox<String> venue2;
    private javax.swing.JLabel venue2lbl;
    // End of variables declaration//GEN-END:variables
}
