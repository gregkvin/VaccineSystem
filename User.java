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
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
abstract class ReadUser {  
    FileHandle fh = new FileHandle();
    String path = "login.txt";
    public abstract void modifyUser(int id, String[]input);
    public abstract void modifyPassword(int id, String newpassword);
    public abstract int searchUser(String usernamee);
    public abstract ArrayList<Integer> searchStatus(String status);
    public abstract boolean checkDuplicate(String usernamee);
    
    public String[] readUsername(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] usernamee = new String[line];
        while(n < line){
            usernamee[n] = fh.getSplit(path, n, demo)[0];
            n=n+1;
        }
        fs.close();
        return usernamee;
    }
    
    public String[] readPass(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] passwordd = new String[line];
        while(n < line){
            passwordd[n] = fh.getSplit(path, n, demo)[1];
            n=n+1;
        }
        fs.close();
        return passwordd;
    }
    
    public String[] readLevel(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] level = new String[line];    
        while(n < line){
            level[n] = fh.getSplit(path, n, demo)[2];
            n=n+1;
        }
        fs.close();
        return level;
    }
        
    public String[] readID(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] id = new String[line];    
        while(n < line){
            id[n] = fh.getSplit(path, n, demo)[3];
            n=n+1;
        }
        fs.close();
        return id;
    }
    
        public String[] readName(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] name = new String[line];    
        while(n < line){
            name[n] = fh.getSplit(path, n, demo)[4];
            n=n+1;
        }
        fs.close();
        return name;
    }
        
        public String[] readStatus(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] status = new String[line];    
        while(n < line){
            status[n] = fh.getSplit(path, n, demo)[5];
            n=n+1;
        }
        fs.close();
        return status;
    }
        public String[] readDOB(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] dob = new String[line];    
        while(n < line){
            dob[n] = fh.getSplit(path, n, demo)[6];
            n=n+1;
        }
        fs.close();
        return dob;
    }
        
        public String[] readNation(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] nation = new String[line];    
        while(n < line){
            nation[n] = fh.getSplit(path, n, demo)[7];
            n=n+1;
        }
        fs.close();
        return nation;
    }
        
        public String[] readEmail(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] email = new String[line];    
        while(n < line){
            email[n] = fh.getSplit(path, n, demo)[8];
            n=n+1;
        }
        fs.close();
        return email;
        
    }
        
        public String[] readFirstDate(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] date = new String[line];    
        while(n < line){
            date[n] = fh.getSplit(path, n, demo)[9];
            n=n+1;
        }
        fs.close();
        return date;
        
    }
        
        public String[] readFirstTime(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] time = new String[line];    
        while(n < line){
            time[n] = fh.getSplit(path, n, demo)[10];
            n=n+1;
        }
        fs.close();
        return time;
        
    }
        
        public String[] readFirstDateCtr(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] fdatectr = new String[line];    
        while(n < line){
            fdatectr[n] = fh.getSplit(path, n, demo)[11];
            n=n+1;
        }
        fs.close();
        return fdatectr;
        
    }
        
        public String[] readFirstStatus(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] fstatus = new String[line];    
        while(n < line){
            fstatus[n] = fh.getSplit(path, n, demo)[12];
            n=n+1;
        }
        fs.close();
        return fstatus;
        
    }
        
        public String[] readSecondDate(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] sdate = new String[line];    
        while(n < line){
            sdate[n] = fh.getSplit(path, n, demo)[13];
            n=n+1;
        }
        fs.close();
        return sdate;
        
    }
        
        public String[] readSecondTime(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] stime = new String[line];    
        while(n < line){
            stime[n] = fh.getSplit(path, n, demo)[14];
            n=n+1;
        }
        fs.close();
        return stime;
        
    }
        
        public String[] readSecondDateCtr(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] sdatectr = new String[line];    
        while(n < line){
            sdatectr[n] = fh.getSplit(path, n, demo)[15];
            n=n+1;
        }
        fs.close();
        return sdatectr;
        
    }
        
        public String[] readSecondStatus(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] sstatus = new String[line];    
        while(n < line){
            sstatus[n] = fh.getSplit(path, n, demo)[16];
            n=n+1;
        }
        fs.close();
        return sstatus;
        
    }

}

public class User extends ReadUser {
    String path = "temp.txt";
    String path2 = "login.txt";
    
    @Override
    public int searchUser(String usernamee) {
        try {
            FileHandle fh = new FileHandle();
            File f = new File(path2);
            Scanner sc = new Scanner(f);
            String line; int n = 0;
            String [] username = readUsername(path2); 
            int length = fh.readLineNumber(path2);
            
            
            while(sc.hasNextLine() && n < length){
                line = sc.nextLine(); 
                if(usernamee.equals(username[n])){
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
    public void modifyPassword(int id, String newpassword){
        try {
            this.path = path;
            this.path2 = path2;
            //ReadUser read = new ReadUser();
            modify read = new modify();
            FileWriter fr = read.setWrite(path);
            String [] ida = readID(path2); String [] namee = readName(path2); String [] usernamee = readUsername(path2);
            String [] passwordd = readPass(path2);String [] level = readLevel(path2); String [] dobb = readDOB(path2);
            String [] emaill = readEmail(path2);String [] nation = readNation(path2); String [] statuss = readStatus(path2);
            String [] date = readFirstDate(path2); 
            String [] time = readFirstTime(path2);
            String [] ctr = readFirstDateCtr(path2);
            String [] stat = readFirstStatus(path2); 
            String [] date2 = readSecondDate(path2); 
            String [] time2 = readSecondTime(path2);
            String [] ctr2 = readSecondDateCtr(path2); 
            String [] stat2 = readSecondStatus(path2);
            
            int line = read.readLineNumber("login.txt");
            int myid = read.readUserData(id);
            
            for(int i = 0; i < line; i++){
                String modify = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit = usernamee[i] + "-" + newpassword + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                        
                if((i != myid) && (i != (line-1)) ){                 
                      fr.write(modify);
                      fr.write("\n");
                    
                } else if((i != myid) && (i == (line-1))){
                      fr.write(modify);

                } else {
                      fr.write(edit);
                      fr.write("\n");
                }
            }
            fr.flush();
            fr.close();
            read.removeOldFile(path,path2);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    @Override
    public ArrayList<Integer> searchStatus(String status){
        try {
            FileHandle fh = new FileHandle();
            File f = new File(path2);
            Scanner sc = new Scanner(f);
            String line; int n = 0;
            int i = 0;
            ArrayList<Integer> id=new ArrayList<Integer>();
            String [] statuss = readStatus(path2);
            int length = fh.readLineNumber(path2);
            
            while(sc.hasNextLine() && n < length){
                line = sc.nextLine();
                if(statuss[n].equals(status) && status.equals("Not")){
                    id.add(n);
                } else if(statuss[n].equals(status) && status.equals("Partial")){
                    id.add(n);
                } else if(statuss[n].equals(status) && status.equals("Fully")){
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
   
    public void appendUser(String path, String[]input) throws IOException {
        FileHandle fh = new FileHandle();
        PrintWriter pr = fh.setAppend(path);
        pr.println("");pr.print(input[2]);pr.print("-");pr.print(input[3]);pr.print("-");pr.print("People");pr.print("-");
        pr.print(input[0]);pr.print("-");pr.print(input[1]);pr.print("-");
        pr.print(input[6]);pr.print("-");pr.print(input[3]);pr.print("-");
        pr.print(input[5]);pr.print("-");pr.print(input[4]);pr.print("-");pr.print("TBA");pr.print("-");
        pr.print("TBA");pr.print("-");pr.print("TBA");pr.print("-");pr.print("NO");pr.print("-");
        pr.print("TBA");pr.print("-");pr.print("TBA");pr.print("-");pr.print("TBA");pr.print("-");
        pr.print("NO");
        pr.flush();
        pr.close();
        
    }
    
    public void registerUser(String path, String[] input) throws IOException {
        FileHandle fh = new FileHandle();
        PrintWriter pr = fh.setAppend(path);
        pr.println("");pr.print(input[2]);pr.print("-");pr.print(input[3]);pr.print("-");pr.print("People");pr.print("-");
        pr.print(input[0]);pr.print("-");pr.print(input[1]);pr.print("-");
        pr.print("Not");pr.print("-");pr.print(input[4]);pr.print("-");
        pr.print(input[6]);pr.print("-");pr.print(input[5]);pr.print("-");pr.print("TBA");pr.print("-");
        pr.print("TBA");pr.print("-");pr.print("TBA");pr.print("-");pr.print("NO");pr.print("-");
        pr.print("TBA");pr.print("-");pr.print("TBA");pr.print("-");pr.print("TBA");pr.print("-");
        pr.print("NO");
        pr.flush();
        pr.close();
    }
    
    public String getID(String id){
        return id;
    }
    
    public void cancelAppointment(int id) throws IOException {
        modify read = new modify();
            FileWriter fr = read.setWrite(path);
            String [] ida = readID(path2); String [] namee = readName(path2); String [] usernamee = readUsername(path2);
            String [] passwordd = readPass(path2);String [] level = readLevel(path2); String [] dobb = readDOB(path2);
            String [] emaill = readEmail(path2);String [] nation = readNation(path2); String [] statuss = readStatus(path2);
            String [] date = readFirstDate(path2); 
            String [] time = readFirstTime(path2);
            String [] ctr = readFirstDateCtr(path2);
            String [] stat = readFirstStatus(path2); 
            String [] date2 = readSecondDate(path2); 
            String [] time2 = readSecondTime(path2);
            String [] ctr2 = readSecondDateCtr(path2); 
            String [] stat2 = readSecondStatus(path2);
    
    
    int line = read.readLineNumber("login.txt");
            int myid = read.readUserData(id);
            System.out.println(myid);
            for(int i = 0; i < line; i++){
                String modify = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        "TBA" + "-" + "TBA" + "-" + "TBA" + "-" + "NO" + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit2 = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" +  
                        "TBA" + "-" + "TBA" + "-" + "TBA" + "-" + "NO";
                
            if((i != myid) && (i != (line-1)) ){
                    fr.write(modify);
                    fr.write("\n");
                    } 
                else if((i != myid) && (i == (line-1))){
                    fr.write(modify);
                } else {
                    if((!date[i].equals("TBA") && stat[i].equals("NO")) || 
                            !date[i].equals("TBA") && stat[i].equals("CONFIRMED")) {
                        fr.write(edit);
                        fr.write("\n");
                    
                    } else if((!date2[i].equals("TBA") && stat2[i].equals("NO")) || 
                            !date2[i].equals("TBA") && stat2[i].equals("CONFIRMED")){
                        fr.write(edit2);
                        fr.write("\n");
                    }
     
                 }
                    
                }
            
            fr.flush();
            fr.close();
            read.removeOldFile(path,path2);
    }
         
    
    
    
    public void confirmAppointment(int id) throws IOException{
        modify read = new modify();
            FileWriter fr = read.setWrite(path);
            String [] ida = readID(path2); String [] namee = readName(path2); String [] usernamee = readUsername(path2);
            String [] passwordd = readPass(path2);String [] level = readLevel(path2); String [] dobb = readDOB(path2);
            String [] emaill = readEmail(path2);String [] nation = readNation(path2); String [] statuss = readStatus(path2);
            String [] date = readFirstDate(path2); 
            String [] time = readFirstTime(path2);
            String [] ctr = readFirstDateCtr(path2);
            String [] stat = readFirstStatus(path2); 
            String [] date2 = readSecondDate(path2); 
            String [] time2 = readSecondTime(path2);
            String [] ctr2 = readSecondDateCtr(path2); 
            String [] stat2 = readSecondStatus(path2);
            
            int line = read.readLineNumber("login.txt");
            int myid = read.readUserData(id);
            System.out.println(myid);
            for(int i = 0; i < line; i++){
                String modify = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + "CONFIRMED" + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit2 = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + "CONFIRMED";
                
                if((i != myid) && (i != (line-1)) ){
                    fr.write(modify);
                    fr.write("\n");
                    } 
                else if((i != myid) && (i == (line-1))){
                    fr.write(modify);
                } else {
                    if(!date[i].equals("TBA") && stat[i].equals("NO")) {
                        fr.write(edit);
                        fr.write("\n");
                    
                    } else if(!date2[i].equals("TBA") && stat2[i].equals("NO")){
                        fr.write(edit2);
                        fr.write("\n");
                    } else if(!date2[i].equals("TBA") && stat2[i].equals("NO") && (i == (line-1))){
                        fr.write(edit2);
                    }
     
                 }
                    
                }
            
            fr.flush();
            fr.close();
            read.removeOldFile(path,path2);
    }
    
    public void appointmentDone(int id, String[] input) throws IOException{
        modify read = new modify();
            FileWriter fr = read.setWrite(path);
            String [] ida = readID(path2); String [] namee = readName(path2); String [] usernamee = readUsername(path2);
            String [] passwordd = readPass(path2);String [] level = readLevel(path2); String [] dobb = readDOB(path2);
            String [] emaill = readEmail(path2);String [] nation = readNation(path2); String [] statuss = readStatus(path2);
            String [] date = readFirstDate(path2); 
            String [] time = readFirstTime(path2);
            String [] ctr = readFirstDateCtr(path2);
            String [] stat = readFirstStatus(path2); 
            String [] date2 = readSecondDate(path2); 
            String [] time2 = readSecondTime(path2);
            String [] ctr2 = readSecondDateCtr(path2); 
            String [] stat2 = readSecondStatus(path2);
            
            int line = read.readLineNumber("login.txt");
            int myid = read.readUserData(id);
            System.out.println(myid);
            for(int i = 0; i < line; i++){
                String modify = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + "Partial" + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + "DONE" + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit2 = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + "Fully" + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + "DONE";
                
                if((i != myid) && (i != (line-1)) ){
                    fr.write(modify);
                    fr.write("\n");
                    } 
                else if((i != myid) && (i == (line-1))){
                    fr.write(modify);
                } else {
                    if(!date[i].equals("TBA") && input[3].equals("CONFIRMED")) {
                        fr.write(edit);
                        fr.write("\n");
                    
                    } else if(!date2[i].equals("TBA") && input[3].equals("CONFIRMED")){
                        fr.write(edit2);
                        fr.write("\n");
                    }
     
                 }
                    
                }
            
            fr.flush();
            fr.close();
            read.removeOldFile(path,path2);
    }
    
            
    @Override
    public void modifyUser(int id, String[]input) {
        try {
            this.path = path;
            this.path2 = path2;
            //ReadUser read = new ReadUser();
            modify read = new modify();
            FileWriter fr = read.setWrite(path);
            String [] ida = readID(path2); String [] namee = readName(path2); String [] usernamee = readUsername(path2);
            String [] passwordd = readPass(path2);String [] level = readLevel(path2); String [] dobb = readDOB(path2);
            String [] emaill = readEmail(path2);String [] nation = readNation(path2); String [] statuss = readStatus(path2);
            String [] date = readFirstDate(path2); 
            String [] time = readFirstTime(path2);
            String [] ctr = readFirstDateCtr(path2);
            String [] stat = readFirstStatus(path2); 
            String [] date2 = readSecondDate(path2); 
            String [] time2 = readSecondTime(path2);
            String [] ctr2 = readSecondDateCtr(path2); 
            String [] stat2 = readSecondStatus(path2);
            
            int line = read.readLineNumber("login.txt");
            int myid = read.readUserData(id);
            
            for(int i = 0; i < line; i++){
                String modify = usernamee[i] + "-" + passwordd[i] + "-" + level[i] + "-" + ida[i] + "-" +
                        namee[i]+ "-" + statuss[i] + "-" + dobb[i] + "-" + nation[i] + "-" + emaill[i] + "-" +
                        date[i] + "-" + time[i] + "-" + ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" +
                        time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                
                String edit = input[2] + "-" + passwordd[i] + "-" + level[i] + "-" + input[0] + "-" + input[1] + "-" +
                        input[6] + "-" + input[3] + "-" + input[5] + "-" + input[4] + "-" + date[i] + "-" + time[i] + "-" + 
                        ctr[i] + "-" + stat[i] + "-" + date2[i] + "-" + time2[i] + "-" + ctr2[i] + "-" + stat2[i];
                        
                if((i != myid) && (i != (line-1)) ){                 
                      fr.write(modify);
                      fr.write("\n");
                    
                } else if((i != myid) && (i == (line-1))){
                      fr.write(modify);

                } else {
                      fr.write(edit);
                      fr.write("\n");
                }
            }
            fr.flush();
            fr.close();
            read.removeOldFile(path,path2);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    
    @Override
    public boolean checkDuplicate(String usernamee){
        try {
            FileHandle fh = new FileHandle();
            File f = new File(path2);
            Scanner sc = new Scanner(f);
            String line; int n = 0;
            String [] username = readUsername(path2); 
            int length = fh.readLineNumber(path2);
            
            
            while(sc.hasNextLine() && n < length){
                line = sc.nextLine(); 
                if(usernamee.equals(username[n])){
                    return true;
                } 
                
                n = n + 1;
            }   
                
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
    
}
        
    


