package oodj_assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Vaccine {
    FileHandle fh = new FileHandle();
    String path = "vaccine.txt";
    String path2 = "temp.txt";
    private int row_no;
    
    public String getPath(String path) throws IOException {
        return path;
    }
    
    public int getRowNumber(){
        return this.row_no;
    }
    
    public void setRowNumber(int row){
        this.row_no = row;
    }
    
    public String[] readVacID(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] vacID = new String[line];    
        while(n < line){
            vacID[n] = fh.getSplit(path, n, demo)[0];
            n=n+1;
        }
        fs.close();
        return vacID;
    }
    
     public String[] readVac(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] vac = new String[line];    
        while(n < line){
            vac[n] = fh.getSplit(path, n, demo)[1];
            n=n+1;
        }
        fs.close();
        return vac;
    }
     
     public String[] readVacQty(String path) throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] qty = new String[line];    
        while(n < line){
            qty[n] = fh.getSplit(path, n, demo)[2];
            n=n+1;
        }
        fs.close();
        return qty;
    }
     
     public void appendVaccine(String[]input) throws IOException{
        FileHandle fh = new FileHandle();
        PrintWriter pr = fh.setAppend(path);
        pr.println("");pr.print(input[0]);pr.print("-");pr.print(input[1]);
        pr.print("-");pr.print(input[2]);
        pr.flush();
        pr.close();
     }
     
     public void modifyVaccine(int row, String[]input) throws IOException {
         modify read = new modify();
         FileWriter fr = read.setWrite(path2);
         BufferedReader bf = new BufferedReader(new FileReader(path));
         String[] vaccineID = readVacID(path);
         String [] vaccine = readVac(path); String [] qty = readVacQty(path);
         int line = read.readLineNumber(path);
         for(int i = 0; i < line; i++){
                if((i != row) && (i != (line-1)) ){
                    fr.write(vaccineID[i]);fr.write("-");fr.write(vaccine[i]);
                    fr.write("-");fr.write(qty[i]);fr.write("\n");
                } else if((i != row) && (i == (line-1))){
                    fr.write(vaccineID[i]);fr.write("-");fr.write(vaccine[i]);
                    fr.write("-");fr.write(qty[i]);
                } else{
                    fr.write("");fr.write(input[0]);fr.write("-");fr.write(input[1]);fr.write("-");
                    fr.write(input[2]);fr.write("\n");
                } 
            }
            fr.flush();
            fr.close();
            read.removeOldFile(path2,path);
        }
     
     public boolean checkDuplicate(String vaccine){
           try {
            FileHandle fh = new FileHandle();
            File f = new File(path);
            Scanner sc = new Scanner(f);
            String line; int n = 0;
            String [] vaccin = readVac(path); 
            int length = fh.readLineNumber(path);
            
            while(sc.hasNextLine() && n < length){
                line = sc.nextLine(); 
                if(vaccine.equals(vaccin[n])){
                    return true;
                } 
                
                n = n + 1;
            }   
                
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
           
        return false; 
    }
     
   public boolean checkAvailability(String vaccinee, int qty) throws FileNotFoundException, IOException{
       FileHandle fh = new FileHandle();
       File f = new File(path);
       Scanner sc = new Scanner(f);
       String line; int n = 0;
       String [] vaccine = readVac(path);
       String [] qtyarray = readVacQty(path);
       int length = fh.readLineNumber(path);
       
       while(n < length){
           if(vaccinee.equals(vaccine[n])){
               if(Integer.parseInt(qtyarray[n]) <= 100 || Integer.parseInt(qtyarray[n]) <= qty){
                   return true;
               } 
           }
           
           n = n+1;
       }
       return false;
     }
}
