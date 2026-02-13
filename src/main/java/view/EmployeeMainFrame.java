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
import model.EmployeeDatabase;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter; 
import javax.swing.event.DocumentEvent; 
import javax.swing.event.DocumentListener; 
import java.awt.*;

public class EmployeeMainFrame extends BaseFrame {
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> sorter; // 1. Add this field

    public EmployeeMainFrame() {
        super("MotorPH - Employee Management", 1200, 600);
        initUI();
        loadTableData();
    }

    @Override
    protected void initUI() {
        setLayout(new BorderLayout());

        // Header Panel
        JPanel header = new JPanel(new GridLayout(2, 1)); 
        header.setBackground(UIConstants.PRIMARY_BLUE);
        
        JLabel title = new JLabel("Employee Dashboard", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        header.add(title);

        
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setOpaque(false); // Keeps the blue background
        JLabel lblSearch = new JLabel("Search: ");
        lblSearch.setForeground(Color.WHITE);
        JTextField txtSearch = new JTextField(20);
        searchPanel.add(lblSearch);
        searchPanel.add(txtSearch);
        header.add(searchPanel);
        
        add(header, BorderLayout.NORTH);

        // Table setup
        String[] columns = {"ID", "Last Name", "First Name", "Position", "Contact", "Dept", "SSS", "PhilHealth", "TIN", "Pag-IBIG"};
        tableModel = new DefaultTableModel(columns, 0);
        employeeTable = new JTable(tableModel);
        
        // INITIALIZE THE SORTER             
        sorter = new TableRowSorter<>(tableModel);
        employeeTable.setRowSorter(sorter);

        // SEARCH LOGIC
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filter(); }
            public void removeUpdate(DocumentEvent e) { filter(); }
            public void changedUpdate(DocumentEvent e) { filter(); }
            
            private void filter() {
                String text = txtSearch.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });

        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    
                    int viewRow = employeeTable.getSelectedRow();
                    if (viewRow != -1) {
                        int modelRow = employeeTable.convertRowIndexToModel(viewRow);
                        String id = tableModel.getValueAt(modelRow, 0).toString();
                        
                        model.Employee emp = model.EmployeeDatabase.findById(id);
                        if (emp != null) {
                            new EmployeeDetailFrame(emp).setVisible(true);
                        }
                    }
                }
            }
        });
        
        add(new JScrollPane(employeeTable), BorderLayout.CENTER);
    }

    private void loadTableData() {
        tableModel.setRowCount(0);
        for (Employee emp : EmployeeDatabase.getAll()) {
            tableModel.addRow(new Object[]{
                emp.getId(),
                emp.getLastName(),
                emp.getFirstName(),
                emp.getPosition(),
                emp.getContactInfo(),
                emp.getDepartment(),
                emp.getSss(),
                emp.getPhilHealth(),
                emp.getTin(),
                emp.getPagibig()
            });
        }
    }

}
