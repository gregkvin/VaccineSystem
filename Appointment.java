/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class Appointment implements readAppointment, editAppointment {
    FileHandle fh = new FileHandle();
    String path = "temp.txt";
    String path2 = "login.txt";
    String path3 = "appointment.txt";
    
    
    @Override
    public void AppointmentDose1(int id, String[] input) throws IOException {
        try {
            User u = new User();
            this.path = path;
            this.path2 = path2;
            modify read = new modify();
            FileWriter fr = read.setWrite(path);
            String [] ida = u.readID(path2); String [] namee = u.readName(path2); 
            String [] usernamee = u.readUsername(path2); String [] passwordd = u.readPass(path2);
            String [] level = u.readLevel(path2); String [] dobb = u.readDOB(path2);
            String [] emaill = u.readEmail(path2);String [] nation = u.readNation(path2); 
            String [] statuss = u.readStatus(path2);
            String [] date = u.readFirstDate(path2); 
            String [] time = u.readFirstTime(path2);
            String [] ctr = u.readFirstDateCtr(path2);
            String [] stat = u.readFirstStatus(path2); 
            String [] date2 = u.readSecondDate(path2); 
            String [] time2 = u.readSecondTime(path2);
            String [] ctr2 = u.readSecondDateCtr(path2); 
            String [] stat2 = u.readSecondStatus(path2);
            
            int line = read.readLineNumber("login.txt");
            int myid = read.readUserData(id);
            System.out.println(myid);
            
            for(int i = 0; i < line; i++){
                String modify = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i]  + "-" + 
                        input[0] + "-" + input[1] + "-" + input[2] + "-" + input[3] + "-" + 
                        date2[i] + "-" + time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit2 = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + "Partial" + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + "DONE" + "-" + 
                        date2[i] + "-" + time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                        
                if((i != myid) && (i != (line-1)) ){                 
                      fr.write(modify);
                      fr.write("\n");
                    
                } else if((i != myid) && (i == (line-1))){
                      fr.write(modify);

                } else {
                    if(date[i].equals("TBA") && input[3].equals("NO") || 
                            !date[i].equals("TBA") && input[3].equals("NO")){
                      fr.write(edit);
                      fr.write("\n");
                    } else if(input[3].equals("DONE")){
                        fr.write(edit2);
                        fr.write("\n");
                    }
            }
            }
            fr.flush();
            fr.close();
            read.removeOldFile(path,path2);
        }
        catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    @Override
    public void AppointmentDose2(int id, String[] input) throws IOException {
        try {
            User u = new User();
            this.path = path;
            this.path2 = path2;
            modify read = new modify();
            FileWriter fr = read.setWrite(path);
            String [] ida = u.readID(path2); String [] namee = u.readName(path2); 
            String [] usernamee = u.readUsername(path2); String [] passwordd = u.readPass(path2);
            String [] level = u.readLevel(path2); String [] dobb = u.readDOB(path2);
            String [] emaill = u.readEmail(path2);String [] nation = u.readNation(path2); 
            String [] statuss = u.readStatus(path2);
            String [] date = u.readFirstDate(path2); 
            String [] time = u.readFirstTime(path2);
            String [] ctr = u.readFirstDateCtr(path2);
            String [] stat = u.readFirstStatus(path2); 
            String [] date2 = u.readSecondDate(path2); 
            String [] time2 = u.readSecondTime(path2);
            String [] ctr2 = u.readSecondDateCtr(path2); 
            String [] stat2 = u.readSecondStatus(path2);
            
            int line = read.readLineNumber("login.txt");
            int myid = read.readUserData(id);
            System.out.println(myid);
            
            for(int i = 0; i < line; i++){
                String modify = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i]  + "-" + 
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + 
                        input[0] + "-" + input[1] + "-" + input[2] + "-" + input[3];
                
                String edit2 = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + "Fully" + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + 
                        date2[i] + "-" + time2[i] + "-" + ctr2[i] + "-" + "DONE";
                        
                if((i != myid) && (i != (line-1)) ){                 
                      fr.write(modify);
                      fr.write("\n");
                    
                } else if((i != myid) && (i == (line-1))){
                      fr.write(modify);

                } else {
                    if(date2[i].equals("TBA") && input[3].equals("NO") || !date2[i].equals("TBA") && input[3].equals("NO")){
                      fr.write(edit);
                      fr.write("\n");
                    } else if(input[3].equals("DONE")){
                        fr.write(edit2);
                        fr.write("\n");
                    }
            }
            }
            fr.flush();
            fr.close();
            read.removeOldFile(path,path2);
        }
        catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void addToTable(String line) throws IOException {
        FileHandle fh = new FileHandle();
        PrintWriter pr = fh.setAppend(path3);
        pr.println("");
        pr.print(line);
        pr.flush();
        pr.close();
        
    }
         
            
    @Override
    public void removeAppointment(String line) throws IOException {
        remove r = new remove();
        String path = path3;
        int id = 0;
        r.removeRecord(line, path, id);
        
    }

   
    @Override
    public String[] readID() throws IOException{
        FileReader fs = fh.setRead(path3);
        int line = fh.readLineNumber(path3);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] id = new String[line];    
        while(n < line){
            id[n] = fh.getSplit(path3, n, demo)[0];
            n=n+1;
        }
        fs.close();
        return id;
    }
    
    
    @Override
    public String[] readDate() throws IOException {
        FileReader fs = fh.setRead(path3);
        int line = fh.readLineNumber(path3);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] date = new String[line];    
        while(n < line){
            date[n] = fh.getSplit(path3, n, demo)[1];
            n=n+1;
        }
        fs.close();
        return date;
    }
    
    @Override
    public String[] readTime() throws IOException {
        FileReader fs = fh.setRead(path3);
        int line = fh.readLineNumber(path3);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] time = new String[line];    
        while(n < line){
            time[n] = fh.getSplit(path3, n, demo)[2];
            n=n+1;
        }
        fs.close();
        return time;
    }
    
    @Override
    public String[] readCtr() throws IOException {
        FileReader fs = fh.setRead(path3);
        int line = fh.readLineNumber(path3);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] ctr = new String[line];    
        while(n < line){
            ctr[n] = fh.getSplit(path3, n, demo)[3];
            n=n+1;
        }
        fs.close();
        return ctr;
    }
    
    @Override
    public String[] readRemarks() throws IOException {
        FileReader fs = fh.setRead(path3);
        int line = fh.readLineNumber(path3);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] remarks = new String[line];    
        while(n < line){
            remarks[n] = fh.getSplit(path3, n, demo)[4];
            n=n+1;
        }
        fs.close();
        return remarks;
    }

    @Override
    public int searchID(String id) {
        try {
            FileHandle fh = new FileHandle();
            File f = new File(path3);
            Scanner sc = new Scanner(f);
            String line; int n = 0;
            String [] userID = readID(); 
            int length = fh.readLineNumber(path3);
            
            
            while(sc.hasNextLine() && n < length){
                line = sc.nextLine(); 
                if(id.equals(userID[n])){
                    return n;
                } 
                
                n = n + 1;
            }   
                
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1; 
    }
    
    @Override
    public ArrayList<Integer> searchRemarks(String status){
        try {
            FileHandle fh = new FileHandle();
            File f = new File(path3);
            Scanner sc = new Scanner(f);
            String line; int n = 0;
            int i = 0;
            ArrayList<Integer> id=new ArrayList<Integer>();
            
            String [] ctr = readCtr();
            String [] remarks = readRemarks();
            int length = fh.readLineNumber(path3);
            
            while(sc.hasNextLine() && n < length){
                line = sc.nextLine();
                if(remarks[n].equals(status) && status.equals("1st Dose")){
                    id.add(n);
                } else if(remarks[n].equals(status) && status.equals("2nd Dose")){
                    id.add(n);
                }
               n = n + 1; 
            }
            return id;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
}
    
    



}

