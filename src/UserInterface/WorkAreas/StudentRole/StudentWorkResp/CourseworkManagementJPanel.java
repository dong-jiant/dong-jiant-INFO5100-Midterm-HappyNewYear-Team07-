/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole.StudentWorkResp;

import Business.Business;
import Business.Profiles.StudentProfile;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * @author Yiru Chen
 */
public class CourseworkManagementJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    private StudentProfile student;

    public CourseworkManagementJPanel(JPanel container, Business b, StudentProfile sp) {
        initComponents();
        this.userProcessContainer = container;
        this.business = b;
        this.student = sp;
        refreshSubmissionTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitle      = new javax.swing.JLabel();
        lblCourseId   = new javax.swing.JLabel();
        txtCourseId   = new javax.swing.JTextField();
        lblAssignment = new javax.swing.JLabel();
        txtAssignment = new javax.swing.JTextField();
        btnSubmit     = new javax.swing.JButton();
        jScrollPane1  = new javax.swing.JScrollPane();
        tblSubmissions = new javax.swing.JTable();
        btnBack       = new javax.swing.JButton();
        lblHistory    = new javax.swing.JLabel();

        // Title
        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18));
        lblTitle.setText("Coursework Management");

        // Course ID input
        lblCourseId.setText("Course ID:");
        txtCourseId.setColumns(20);

        // Assignment name input
        lblAssignment.setText("Assignment Name:");
        txtAssignment.setColumns(20);

        // Submit button
        btnSubmit.setBackground(new java.awt.Color(102, 153, 255));
        btnSubmit.setForeground(java.awt.Color.WHITE);
        btnSubmit.setText("Submit Assignment");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        // Submissions history table
        lblHistory.setText("Submission History:");
        tblSubmissions.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "Course ID", "Assignment Name" }
        ) {
            public boolean isCellEditable(int row, int col) { return false; }
        });
        jScrollPane1.setViewportView(tblSubmissions);

        // Back button
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        // Layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCourseId, 120, 120, 120)
                        .addGap(10)
                        .addComponent(txtCourseId, 200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAssignment, 120, 120, 120)
                        .addGap(10)
                        .addComponent(txtAssignment, 200, 200, 200))
                    .addComponent(btnSubmit)
                    .addComponent(lblHistory)
                    .addComponent(jScrollPane1, 450, 450, 450))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15)
                .addComponent(btnBack)
                .addGap(10)
                .addComponent(lblTitle)
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourseId)
                    .addComponent(txtCourseId))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAssignment)
                    .addComponent(txtAssignment))
                .addGap(15)
                .addComponent(btnSubmit)
                .addGap(20)
                .addComponent(lblHistory)
                .addGap(8)
                .addComponent(jScrollPane1, 160, 160, 160)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>


    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {
        // Validate session
        if (student == null || student.getPerson() == null) {
            JOptionPane.showMessageDialog(this, "Invalid student session.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String courseId = txtCourseId.getText().trim();
        String assignmentName = txtAssignment.getText().trim();

        // Null / empty checks
        if (courseId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Course ID cannot be empty.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (assignmentName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Assignment name cannot be empty.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String studentId = student.getPerson().getPersonId();
        boolean success = business.getEnrollmentDirectory().submitAssignment(studentId, courseId, assignmentName);

        if (!success) {
            JOptionPane.showMessageDialog(this,
                "Submission failed. Make sure you are enrolled in course: " + courseId,
                "Submission Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
            "Assignment \"" + assignmentName + "\" submitted successfully for " + courseId + "!",
            "Success", JOptionPane.INFORMATION_MESSAGE);

        // Clear inputs and refresh table
        txtCourseId.setText("");
        txtAssignment.setText("");
        refreshSubmissionTable();
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        CardLayout cl = (CardLayout) userProcessContainer.getLayout();
        cl.show(userProcessContainer, "student");
    }

    private void refreshSubmissionTable() {
        DefaultTableModel model = (DefaultTableModel) tblSubmissions.getModel();
        model.setRowCount(0);

        if (student == null || student.getPerson() == null) return;

        String studentId = student.getPerson().getPersonId();
        ArrayList<String> submissions = business.getEnrollmentDirectory().getSubmittedAssignments(studentId);

        for (String entry : submissions) {
            // entry format: "COURSEID - AssignmentName"
            String[] parts = entry.split(" - ", 2);
            if (parts.length == 2) {
                model.addRow(new Object[]{ parts[0], parts[1] });
            } else {
                model.addRow(new Object[]{ entry, "" });
            }
        }
    }

    // Variables declaration
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAssignment;
    private javax.swing.JLabel lblCourseId;
    private javax.swing.JLabel lblHistory;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblSubmissions;
    private javax.swing.JTextField txtAssignment;
    private javax.swing.JTextField txtCourseId;
}
