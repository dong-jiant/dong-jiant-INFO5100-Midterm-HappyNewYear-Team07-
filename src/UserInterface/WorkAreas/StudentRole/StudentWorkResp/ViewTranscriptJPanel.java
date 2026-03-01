/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole.StudentWorkResp;

import Business.Academic.Enrollment;
import Business.Business;
import Business.Profiles.StudentProfile;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yiru Chen
 */
public class ViewTranscriptJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    private StudentProfile student;

    /**
     * Constructor — initialises components and loads transcript data.
     *
     * @param container CardLayout parent panel
     * @param b         shared Business object
     * @param sp        logged-in StudentProfile
     */
    public ViewTranscriptJPanel(JPanel container, Business b, StudentProfile sp) {
        initComponents();
        this.userProcessContainer = container;
        this.business = b;
        this.student = sp;
        loadTranscript();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitle     = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTranscript = new javax.swing.JTable();
        lblSummary   = new javax.swing.JLabel();
        btnRefresh   = new javax.swing.JButton();
        btnBack      = new javax.swing.JButton();

        // Title
        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18));
        lblTitle.setText("My Transcript");

        // Transcript table — not editable
        tblTranscript.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "Course ID", "Course Name", "Credits", "Grade" }
        ) {
            public boolean isCellEditable(int row, int col) { return false; }
        });
        jScrollPane1.setViewportView(tblTranscript);

        // Summary label (GPA / credit count shown below table)
        lblSummary.setFont(new java.awt.Font("Dialog", 0, 12));
        lblSummary.setText("Total courses: 0  |  Completed credits: 0");

        // Refresh button
        btnRefresh.setBackground(new java.awt.Color(102, 153, 255));
        btnRefresh.setForeground(java.awt.Color.WHITE);
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadTranscript();
            }
        });

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
                    .addComponent(jScrollPane1, 520, 520, 520)
                    .addComponent(lblSummary)
                    .addComponent(btnRefresh))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15)
                .addComponent(btnBack)
                .addGap(10)
                .addComponent(lblTitle)
                .addGap(15)
                .addComponent(jScrollPane1, 200, 200, 200)
                .addGap(10)
                .addComponent(lblSummary)
                .addGap(15)
                .addComponent(btnRefresh)
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>

    // ---------------------------------------------------------------
    // Logic
    // ---------------------------------------------------------------

    /**
     * Loads all enrollment records for the current student into the table.
     * Shows grade as numeric value or "In Progress" if not yet graded.
     */
    private void loadTranscript() {
        DefaultTableModel model = (DefaultTableModel) tblTranscript.getModel();
        model.setRowCount(0);

        if (student == null || student.getPerson() == null) {
            lblSummary.setText("Invalid student session.");
            return;
        }

        String studentId = student.getPerson().getPersonId();
        ArrayList<Enrollment> enrollments =
                business.getEnrollmentDirectory().getEnrollmentsForStudent(studentId);

        int completedCredits = 0;

        for (Enrollment e : enrollments) {
            String grade;
            if (e.getGradePoint() == null) {
                grade = "In Progress";
            } else {
                grade = String.valueOf(e.getGradePoint());
                if (e.getGradePoint() >= 1.0) {
                    completedCredits += e.getCredits();
                }
            }
            model.addRow(new Object[]{
                e.getCourseId(),
                e.getCourseName(),
                e.getCredits(),
                grade
            });
        }

        lblSummary.setText("Total courses: " + enrollments.size()
                + "  |  Completed credits: " + completedCredits);
    }

    /** Navigate back to the Student Work Area. */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        CardLayout cl = (CardLayout) userProcessContainer.getLayout();
        cl.previous(userProcessContainer);
    }

    // Variables declaration
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSummary;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblTranscript;
}
