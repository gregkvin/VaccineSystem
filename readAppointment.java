/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * 
 */

public interface readAppointment {
    String[] readID() throws IOException;
    String[] readDate() throws IOException;
    String[] readTime() throws IOException;
    String[] readCtr() throws IOException;
    String[] readRemarks() throws IOException;
    int searchID(String id) throws IOException;
    ArrayList<Integer> searchRemarks(String status) throws IOException;
}

