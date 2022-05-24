package oodj_assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
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
public class Centre extends Vaccine {
    FileHandle fh = new FileHandle();
    String path = "centre.txt";
    String path2 = "vaccine.txt";
    
    public String[] ReadCtrID() throws IOException {
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] ID = new String[line];
        while(n < line){
            ID[n] = fh.getSplit(path, n, demo)[0];
            n=n+1;
        }
        fs.close();
        return ID;  
    }
    
    public String[] ReadCentre() throws IOException {
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[] demo = fh.declareArray();
        int n = 0;
        String [] centre = new String[line];
        while(n < line){
            centre[n] = fh.getSplit(path, n, demo)[1];
            n=n+1;
        }
        fs.close();
        return centre;  
    }
    
    public String[] ReadVaccine() throws IOException {
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] vac = new String[line];
        while(n < line){
            vac[n] = fh.getSplit(path, n, demo)[2];
            n=n+1;
        }
        fs.close();
        return vac;  
    }
    
    public String[] readQtyCtr() throws IOException{
        FileReader fs = fh.setRead(path);
        int line = fh.readLineNumber(path);
        String[]demo = fh.declareArray();
        int n = 0;
        String[] qty = new String[line];
        while(n < line){
            qty[n] = fh.getSplit(path, n, demo)[3];
            n=n+1;
        }
        fs.close();
        return qty;  
    }
    
    public String getCentrePath(){
        return "centre.txt";
    }
    
    public void appendCentre(String path, String[]input) throws IOException{
        PrintWriter pr = fh.setAppend(path);
        pr.println("");pr.print(input[0]);pr.print("-");
        pr.print(input[1]);pr.print("-");pr.print(input[2]);pr.print("-");
        pr.print(input[3]);
        pr.flush();
        pr.close();
    }
    
    public boolean checkDuplicate(String centre){
           try {
            FileHandle fh = new FileHandle();
            File f = new File(path);
            Scanner sc = new Scanner(f);
            String line; int n = 0;
            String[] centree = ReadCentre(); 
            int length = fh.readLineNumber(path);
            
            while(sc.hasNextLine() && n < length){
                line = sc.nextLine(); 
                if(centre.equals(centree[n])){
                    return true;
                } 
                n = n + 1;
            }   
                
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return false; 
    }
    
    public void modifyCentre(int id, String input) throws IOException{
        String path2 = "temp.txt";
        String path3 = "centre.txt";
        Login l = new Login();
        Vaccine v = new Vaccine();
        modify read = new modify();
        FileWriter fr = read.setWrite(path2);
        
        String [] ctrID = ReadCtrID();
        String [] centree = ReadCentre(); 
        String [] vacc = ReadVaccine();
        String [] vacqty = readQtyCtr();
        
        int line = read.readLineNumber(path3);
        
        
        for(int i = 0; i < line; i++){
                String modify = ctrID[i] + "-" + centree[i] + "-" + vacc[i] + "-" + vacqty[i];
                
                
                if((i != id) && (i != (line-1)) ){                 
                      fr.write(modify);
                      fr.write("\n");
                    
                } else if((i != id) && (i == (line-1))){
                      fr.write(modify);

                } else {
                      fr.write(input);
                      fr.write("\n");
                }
            }
        fr.flush();
        fr.close();
        read.removeOldFile(path2,path3);
        } 
    
    public int searchCtr(String centre) {
        try {
            FileHandle fh = new FileHandle();
            File f = new File(path);
            Scanner sc = new Scanner(f);
            String line; int n = 0;
            String [] centree = ReadCentre(); 
            int length = fh.readLineNumber(path);
            
            
            while(sc.hasNextLine() && n < length){
                line = sc.nextLine(); 
                if(centre.contains(centree[n])){
                    return n;
                } 
                
                n = n + 1;
            }   
                
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1; 
        
    }
        

    
        public ArrayList<Integer> searchVaccine(String vaccin){
            try {
            FileHandle fh = new FileHandle();
            File f = new File(path);
            Scanner sc = new Scanner(f);
            String line; int n = 0;
            int i = 0;
            ArrayList<Integer> id=new ArrayList<Integer>();
            String [] vaccine = readVac(path2);
            String [] vacctr = ReadVaccine();
            int length = fh.readLineNumber(path2);
            int length2 = fh.readLineNumber(path);
            
            
            while(sc.hasNextLine() && i < length){
                line = sc.nextLine();
                if(vaccin.equals(vaccine[i])){
                    while(n < length2){
                        if(vaccin.equals(vacctr[n])){
                        id.add(n); 
                       }
                       n = n + 1;
                    } 
                }
               i = i + 1; 
               
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

class VaccineSupply extends Vaccine {
    String path2 = "temp.txt";
    String path3 = "vaccine.txt";
    
    public void updateVaccine(String[]input,int qty){
        FileWriter fr = null;
        try {
            Vaccine v = new Vaccine();
            modify read = new modify();
            fr = read.setWrite(path2);
            BufferedReader bf = new BufferedReader(new FileReader(path3));
            String[] vaccineID = readVacID(path3);
            String [] vaccine = readVac(path3);
            String [] qtyarray = readVacQty(path3);
            int line = read.readLineNumber(path3);
            int n = 0;
            while(n < line){
                if(input[2].equals(vaccine[n])){
                    int no = n;
                    int qtyfinal = Integer.parseInt(qtyarray[no]) - Integer.parseInt(input[3]);
                    for(int i = 0; i < line; i++){
                        if((i != no) && (i != (line-1)) ){
                            fr.write(vaccineID[i]);fr.write("-");fr.write(vaccine[i]);
                            fr.write("-");fr.write(qtyarray[i]);fr.write("\n");
                        } else if((i != no) && (i == (line-1))){
                            fr.write(vaccineID[i]);fr.write("-");fr.write(vaccine[i]);
                            fr.write("-");fr.write(qtyarray[i]);
                        } else {
                            fr.write("");fr.write(vaccineID[no]);fr.write("-");fr.write(vaccine[no]);fr.write("-");
                            fr.write(Integer.toString(qtyfinal));fr.write("\n");
                        }
                    }
                }
                n= n + 1;
            }  
            fr.flush();
            fr.close();
            read.removeOldFile(path2,path3);
        } catch (IOException ex) {
            Logger.getLogger(Centre.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Centre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    
    
    public void addVaccine(String[]input,int qty){
        FileWriter fr = null;
        try {
            Vaccine v = new Vaccine();
            modify read = new modify();
            fr = read.setWrite(path2);
            BufferedReader bf = new BufferedReader(new FileReader(path3));
            String[] vaccineID = readVacID(path3);
            String [] vaccine = readVac(path3);
            String [] qtyarray = readVacQty(path3);
            int line = read.readLineNumber(path3);
            int n = 0;
            while(n < line){
                if(input[2].equals(vaccine[n])){
                    int no = n;
                    int qtyfinal = Integer.parseInt(qtyarray[no]) + Integer.parseInt(input[3]);
                    for(int i = 0; i < line; i++){
                        if((i != no) && (i != (line-1)) ){
                            fr.write(vaccineID[i]);fr.write("-");fr.write(vaccine[i]);
                            fr.write("-");fr.write(qtyarray[i]);fr.write("\n");
                        } else if((i != no) && (i == (line-1))){
                            fr.write(vaccineID[i]);fr.write("-");fr.write(vaccine[i]);
                            fr.write("-");fr.write(qtyarray[i]);
                        } else {
                            fr.write("");fr.write(vaccineID[no]);fr.write("-");fr.write(vaccine[no]);fr.write("-");
                            fr.write(Integer.toString(qtyfinal));fr.write("\n");
                        }
                    }
                }
                n= n + 1;
            }  
            fr.flush();
            fr.close();
            read.removeOldFile(path2,path3);
        } catch (IOException ex) {
            Logger.getLogger(Centre.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Centre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    
    public ArrayList<Integer> searchVaccineQty(int qty){
            try {
            Centre c = new Centre();
            FileHandle fh = new FileHandle();
            File f = new File(path);
            Scanner sc = new Scanner(f);
            String line; 
            
            int n = 0;
            ArrayList<Integer> id=new ArrayList<Integer>();
            String [] vacqty = c.readQtyCtr();
            int length = fh.readLineNumber(path);
            
            while(sc.hasNextLine() && n < length){
                line = sc.nextLine();
                if(qty <= Integer.parseInt(vacqty[n])){
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
        
     
    
        

