/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.io.IOException;

/**
 *
 * 
 */
public interface editAppointment {
    void AppointmentDose1(int id, String [] input) throws IOException;
    void AppointmentDose2(int id, String [] input) throws IOException;
    void addToTable(String line) throws IOException;
    void removeAppointment(String line) throws IOException;
}

