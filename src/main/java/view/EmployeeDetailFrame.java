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

public class EmployeeDetailFrame extends BaseFrame {
    private final Employee employee;

    
    public EmployeeDetailFrame(Employee employee) {
        super("Employee Details - " + employee.getId(), 500, 600);
        this.employee = employee;
        initUI();
    }

    @Override
    protected void initUI() {
        setLayout(new BorderLayout());
        
        // Main Container with padding
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Displaying Information using the Employee's Getters
        int row = 0;
        addDetailRow(contentPanel, gbc, "Employee ID:", employee.getId(), row++);
        addDetailRow(contentPanel, gbc, "Full Name:", employee.getFullName(), row++);
        addDetailRow(contentPanel, gbc, "Position:", employee.getPosition(), row++);
        addDetailRow(contentPanel, gbc, "Basic Salary:", String.format("PHP %,.2f", employee.getBasicSalary()), row++);
        
        gbc.gridy = row++; // Move to the next available row
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Make button span across both columns
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 5, 5, 5); // Add extra space above the button

        JButton btnPayroll = new JButton("Compute Payroll");
        btnPayroll.setBackground(UIConstants.PRIMARY_BLUE);
        btnPayroll.setForeground(Color.WHITE);
    
        // Logic to open the Payroll Entry Frame
        btnPayroll.addActionListener(e -> {
            new PayrollEntryFrame(this.employee).setVisible(true);
        });

        contentPanel.add(btnPayroll, gbc);
        
        // Show the deduction logic we built in Step 2
        double sss = new model.SSSDeduction().calculate(employee.getBasicSalary());
        addDetailRow(contentPanel, gbc, "Est. SSS Deduction:", String.format("PHP %,.2f", sss), row++);

        add(new JScrollPane(contentPanel), BorderLayout.CENTER);

        // Close Button at bottom
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> dispose());
        add(btnClose, BorderLayout.SOUTH);
    }

    // A helper method to keep the layout code clean
    private void addDetailRow(JPanel panel, GridBagConstraints gbc, String label, String value, int row) {
        gbc.gridy = row;
        gbc.gridx = 0;
        panel.add(new JLabel(label), gbc);
        
        gbc.gridx = 1;
        JLabel valLabel = new JLabel(value);
        valLabel.setFont(UIConstants.BOLD_FONT);
        panel.add(valLabel, gbc);
    }
    
}

