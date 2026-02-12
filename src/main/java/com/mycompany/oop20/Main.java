/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop20;

/**
 *
 * @author Vladimir Bernardo
 */
import model.EmployeeDatabase;
import view.LoginFrame;

// 2. Only one public class (Make sure the file name matches this name)
public class Main {
    public static void main(String[] args) {
        // 1. Load Data first
        // Double check this path matches where your CSV is stored!
        EmployeeDatabase.load("src/main/java/resources/employees.csv");
        
        // 2. Open Login
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
