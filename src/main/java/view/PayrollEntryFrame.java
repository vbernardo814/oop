/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Vladimir Bernardo
 */
import model.Employee;
import javax.swing.*;
import java.awt.*;

public class PayrollEntryFrame extends BaseFrame {
    private final Employee employee;
    private JTextField txtHours;
    private JButton btnCompute;

    public PayrollEntryFrame(Employee employee) {
        super("Compute Payroll - " + employee.getFullName(), 400, 300);
        this.employee = employee;
        initUI();
    }

    @Override
    protected void initUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Input Label
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Hours Worked:"), gbc);

        // Input Field
        txtHours = new JTextField(10);
        gbc.gridx = 1;
        add(txtHours, gbc);

        // Compute Button
        btnCompute = new JButton("Generate Payslip");
        btnCompute.setBackground(UIConstants.PRIMARY_BLUE);
        btnCompute.setForeground(Color.WHITE);
        gbc.gridy = 1; gbc.gridx = 0; gbc.gridwidth = 2;
        add(btnCompute, gbc);

        btnCompute.addActionListener(e -> handleCompute());
    }

    private void handleCompute() {
        try {
            double hours = Double.parseDouble(txtHours.getText());
            double gross = hours * employee.getHourlyRate();
            
            // Logic: Calculate total deductions using our OOP Interface
            double totalDeductions = employee.getTotalDeductions(gross);
            double netPay = gross - totalDeductions;

            // Open the final Payslip View
            new PayslipFrame(employee, gross, totalDeductions, netPay).setVisible(true);
            this.dispose();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for hours.");
        }
    }
    
}
