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

public class PayslipFrame extends BaseFrame {
    
    public PayslipFrame(Employee emp, double gross, double deductions, double net) {
        super("Official Payslip", 400, 500);
        
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        panel.add(new JLabel("MOTOR PH CORPORATION"));
        panel.add(new JLabel("Employee: " + emp.getFullName()));
        panel.add(new JLabel("Gross Pay: PHP " + String.format("%,.2f", gross)));
        panel.add(new JLabel("Total Deductions: PHP " + String.format("%,.2f", deductions)));
        
        JLabel lblNet = new JLabel("NET PAY: PHP " + String.format("%,.2f", net));
        lblNet.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblNet.setForeground(Color.RED);
        panel.add(lblNet);

        add(panel, BorderLayout.CENTER);
        
        JButton btnPrint = new JButton("Print / Close");
        btnPrint.addActionListener(e -> dispose());
        add(btnPrint, BorderLayout.SOUTH);
    }

    @Override
    protected void initUI() {
        // Handled in constructor for this simple view
    }
    
}
