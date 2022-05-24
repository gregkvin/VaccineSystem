/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */

class FileWrite extends FileHandle {
    String path = "logging.txt";
    public void LoggingActivity(String [] input) throws IOException{
        FileHandle fh = new FileHandle();
        
        int line = fh.readLineNumber(path);
        PrintWriter pr = fh.setAppend(path);
        if(line == 0){
            pr.print(input[0]);pr.print("-");pr.print(input[1]);pr.print("-");pr.print(input[2]);
        } else {
            pr.println("");pr.print(input[0]);pr.print("-");pr.print(input[1]);pr.print("-");pr.print(input[2]);
        }
        pr.flush();
        pr.close(); 
    }
    
    public void resetLoggingActivity() throws IOException{
        new FileWriter(path, false).close();
    }
   
    public String[] readUser(String path) throws IOException{
        FileHandle fh = new FileHandle();
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] user = new String[line];    
        while(n < line){
            user[n] = fh.getSplit(path, n, demo)[0];
            n=n+1;
        }
        fs.close();
        return user;
    }
    
    public String[] readRemarks(String path) throws IOException{
        FileHandle fh = new FileHandle();
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] remarks = new String[line];    
        while(n < line){
            remarks[n] = fh.getSplit(path, n, demo)[1];
            n=n+1;
        }
        fs.close();
        return remarks;
    }
    
    public String[] readTime(String path) throws IOException{
        FileHandle fh = new FileHandle();
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] time = new String[line];    
        while(n < line){
            time[n] = fh.getSplit(path, n, demo)[2];
            n=n+1;
        }
        fs.close();
        return time;
    }
}

public class modify extends FileHandle{
    
    public void removeOldFile(String path, String path2){
        File f = new File(path2);
        f.delete();
        
        File f1 = new File(path);
        f1.renameTo(f);
    }
    
    public int readUserData(int id) throws IOException {
        int myid = id - 1;
        return myid;
    }
    
    public int getUserID(String [] usernameee, String username) throws IOException {
        modify mh = new modify();
        int line = mh.readLineNumber("login.txt");
            for(int a = 0; a < line; a++){
                if(username.equals(usernameee[a])){
                   return a;
                }
            }
            return -1;
    }
    
    public void setAppointmentData(int id) throws IOException {
        int myid = id;
    }
    
    public int getAppointmentData(int id) throws IOException {
        return id;
    }
   
}
    
class remove extends FileHandle{
    String path = "temp.txt";
    
    public void removeRecord(String input, String path2, int id) throws IOException{
        modify read = new modify();
        FileWriter fr = read.setWrite(path);
        BufferedReader br = read.setReadLines(path2);
        String line;

        
        while((line = br.readLine())!=null){
            if(!line.trim().equals(input)){
                fr.write(line);
                fr.write("\n");
            }
        }
        fr.flush();
        fr.close();
        read.removeOldFile(path,path2);
    }   
    }

class FileHandle{
    public FileReader setRead(String path) throws IOException{
        File file = new File(path);
        FileReader fr = new FileReader(file);
        return fr;
    }
    
    public BufferedReader setReadLines(String path) throws IOException {
        FileReader fr = setRead(path);
        BufferedReader br = new BufferedReader(fr);
        return br;
    }
    
    public FileWriter setWrite(String path) throws IOException{
        FileWriter fw = new FileWriter(path);
        return fw;
    }
    
    public PrintWriter setAppend(String path) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        BufferedWriter br = new BufferedWriter(fw);
        PrintWriter pr = new PrintWriter(br);
        return pr;
    }
    
    public int readLineNumber(String path) throws IOException {
        FileReader fs = setRead(path);
        LineNumberReader li = new LineNumberReader(fs);
        li.skip(Long.MAX_VALUE);
        int line = li.getLineNumber();
        return line;
    }
    
    public String[] declareArray() throws IOException {
        String[]demo = new String[9];
        return demo;
    }
    
    public String [] getSplit(String path,int n, String[] demo) throws IOException {
        String specific_line_text = Files.readAllLines(Paths.get(path)).get(n);
        demo = specific_line_text.split("-");
        return demo;
    }
    
    public String autoIncrement(String path, String [] id) throws IOException{
        int line = readLineNumber(path);
        int idi = Integer.parseInt(id[line-1]);
        int auto = idi + 1;
        return String.valueOf(auto);
    }
}

        
    
    

  
