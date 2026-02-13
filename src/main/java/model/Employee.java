/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Vladimir Bernardo
 */
import java.util.ArrayList;
import java.util.List;

public class Employee {
    // 1. FIELDS
    private String id;
    private String lastName;
    private String firstName;
    private String position;
    private String contactInfo;
    private String department;
    private String birthday;
    private String sss;
    private String philHealth;
    private String tin;
    private String pagibig;
    private double hourlyRate;
    private double basicSalary;
    
    // This list MUST be declared here
    private List<Deduction> standardDeductions;

    // 2. CONSTRUCTOR
    public Employee(String[] data) {
        // Basic Parsing from your specific CSV columns
        this.id = data[0];         
        this.firstName = data[1];  
        this.lastName = data[2];   
        this.contactInfo = data[3];
        this.position = data[4];   
        this.department = data[5]; 
        this.birthday = data[6];    
        this.sss = data[7];         
        this.philHealth = data[8];  
        this.tin = data[9];         
        this.pagibig = data[10];
        
        this.basicSalary = 25000.0; 
        this.hourlyRate = 150.0;

        // INITIALIZE THE LIST
        this.standardDeductions = new ArrayList<>();
        this.standardDeductions.add(new SSSDeduction());
    }

    // 3. THE METHODS 
    public double getTotalDeductions(double grossIncome) {
        double total = 0;
        
        if (this.standardDeductions != null) {
            for (Deduction d : this.standardDeductions) {
                total += d.calculate(grossIncome);
            }
        }
        return total; 
    }

    // 4. GETTERS
    public String getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getFullName() { return firstName + " " + lastName; }
    public String getPosition() { return position; }
    public String getContactInfo() { return contactInfo; }
    public String getDepartment() { return department; }
    public String getBirthday() { return birthday; }
    public String getSss() { return sss; }
    public String getPhilHealth() { return philHealth; }
    public String getTin() { return tin; }
    public String getPagibig() { return pagibig; }
    public double getHourlyRate() { return hourlyRate; }
    public double getBasicSalary() { return basicSalary; }
}

