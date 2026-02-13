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

public class Main {
    public static void main(String[] args) {
        EmployeeDatabase.load("src/main/java/resources/employees.csv");
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}

