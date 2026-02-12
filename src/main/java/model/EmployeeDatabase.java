/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Vladimir Bernardo
 */
import java.io.*;
import java.util.*;

public class EmployeeDatabase {
    private static List<Employee> employeeList = new ArrayList<>();

    // REPLACE YOUR OLD LOAD METHOD WITH THIS ONE:
    public static void load(String path) {
        // This will show you EXACTLY where the computer is looking for the file
        System.out.println("Attempting to load file from: " + new File(path).getAbsolutePath());
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); // Skip header
            int count = 0;
            String line;
            while ((line = br.readLine()) != null) {
                // Splits by comma, but ignores commas inside quotes
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                employeeList.add(new Employee(data));
                count++;
            }
            System.out.println("Successfully loaded " + count + " employees!");
        } catch (Exception e) { 
            System.err.println("Error loading CSV: " + e.getMessage());
            // If the file isn't found, this will print the detailed error
            e.printStackTrace(); 
        }
    }

    public static List<Employee> getAll() { return employeeList; }

    public static Employee findById(String searchId) {
        for (Employee emp : employeeList) { 
            if (emp.getId().equals(searchId)) {
                return emp;
            }
        }
        return null; 
    }
}
