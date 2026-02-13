/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Vladimir Bernardo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// INHERITANCE: We extend BaseFrame instead of JFrame
public class LoginFrame extends BaseFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {
        // Calls the BaseFrame constructor: Title, Width, Height
        super("MotorPH Login", 350, 250);
        initUI();
    }

    @Override // POLYMORPHISM: Implementing the UI specific to Login
    protected void initUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Employee ID:"), gbc);
        
        txtUsername = new JTextField(15);
        gbc.gridx = 1;
        add(txtUsername, gbc);

        // Password
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);
        
        txtPassword = new JPasswordField(15);
        gbc.gridx = 1;
        add(txtPassword, gbc);

        // Login Button
        btnLogin = new JButton("Login");
        btnLogin.setBackground(UIConstants.PRIMARY_BLUE);
        btnLogin.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(btnLogin, gbc);

        // Logic for the button
        btnLogin.addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String user = txtUsername.getText();
        String pass = new String(txtPassword.getPassword());

        if (user.equals("admin") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            this.dispose(); // Close login
            new EmployeeMainFrame().setVisible(true); // Open Dashboard
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

