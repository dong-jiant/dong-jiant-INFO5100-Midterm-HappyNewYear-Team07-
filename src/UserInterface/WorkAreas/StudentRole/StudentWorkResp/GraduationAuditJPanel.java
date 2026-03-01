/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole.StudentWorkResp;

import Business.Business;
import Business.Profiles.StudentProfile;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * @author Yiru Chen
 */
public class GraduationAuditJPanel extends javax.swing.JPanel {

    private static final int REQUIRED_CREDITS = 30;

    private JPanel userProcessContainer;
    private Business business;
    private StudentProfile student;

    /**
     */
    public GraduationAuditJPanel(JPanel container, Business b, StudentProfile sp) {
        initComponents();
        this.userProcessContainer = container;
        this.business = b;
        this.student = sp;
        runAudit();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitle       = new javax.swing.JLabel();
        lblCompleted   = new javax.swing.JLabel();
        lblRequired    = new javax.swing.JLabel();
        lblPending     = new javax.swing.JLabel();
        lblStatus      = new javax.swing.JLabel();
        valCompleted   = new javax.swing.JLabel();
        valRequired    = new javax.swing.JLabel();
        valPending     = new javax.swing.JLabel();
        valStatus      = new javax.swing.JLabel();
        progressBar    = new javax.swing.JProgressBar();
        btnRefresh     = new javax.swing.JButton();
        btnBack        = new javax.swing.JButton();

        // Title
        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18));
        lblTitle.setText("Graduation Audit");

        // Labels
        lblCompleted.setText("Completed Credits:");
        lblRequired.setText("Required Credits:");
        lblPending.setText("Credits Still Needed:");
        lblStatus.setFont(new java.awt.Font("Dialog", 1, 13));
        lblStatus.setText("Status:");

        // Value labels (filled in by runAudit)
        valCompleted.setText("0");
        valRequired.setText(String.valueOf(REQUIRED_CREDITS));
        valPending.setText("0");
        valStatus.setFont(new java.awt.Font("Dialog", 1, 13));
        valStatus.setText("-");

        // Progress bar
        progressBar.setMaximum(REQUIRED_CREDITS);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        // Refresh button
        btnRefresh.setBackground(new java.awt.Color(102, 153, 255));
        btnRefresh.setForeground(java.awt.Color.WHITE);
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runAudit();
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
                .addGap(50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCompleted, 180, 180, 180)
                        .addGap(20)
                        .addComponent(valCompleted, 80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRequired, 180, 180, 180)
                        .addGap(20)
                        .addComponent(valRequired, 80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPending, 180, 180, 180)
                        .addGap(20)
                        .addComponent(valPending, 80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus, 180, 180, 180)
                        .addGap(20)
                        .addComponent(valStatus, 200, 200, 200))
                    .addComponent(progressBar, 350, 350, 350)
                    .addComponent(btnRefresh))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15)
                .addComponent(btnBack)
                .addGap(10)
                .addComponent(lblTitle)
                .addGap(30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompleted).addComponent(valCompleted))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRequired).addComponent(valRequired))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPending).addComponent(valPending))
                .addGap(20)
                .addComponent(progressBar, 25, 25, 25)
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus).addComponent(valStatus))
                .addGap(20)
                .addComponent(btnRefresh)
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>

    // ---------------------------------------------------------------
    // Logic
    // ---------------------------------------------------------------

    /**
     */
    private void runAudit() {
        if (student == null || student.getPerson() == null) {
            valStatus.setText("Invalid session");
            return;
        }

        String studentId = student.getPerson().getPersonId();
        int completed = business.getEnrollmentDirectory().completedCredits(studentId);
        int pending   = Math.max(0, REQUIRED_CREDITS - completed);

        valCompleted.setText(String.valueOf(completed));
        valRequired.setText(String.valueOf(REQUIRED_CREDITS));
        valPending.setText(String.valueOf(pending));

        // Update progress bar
        progressBar.setValue(Math.min(completed, REQUIRED_CREDITS));
        progressBar.setString(completed + " / " + REQUIRED_CREDITS + " credits");

        // Update status with colour feedback
        if (pending == 0) {
            valStatus.setText("✓ Eligible for Graduation");
            valStatus.setForeground(new java.awt.Color(0, 150, 0));
        } else {
            valStatus.setText("In Progress — " + pending + " credits needed");
            valStatus.setForeground(new java.awt.Color(200, 100, 0));
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        CardLayout cl = (CardLayout) userProcessContainer.getLayout();
        cl.previous(userProcessContainer);
    }

    // Variables declaration
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel lblCompleted;
    private javax.swing.JLabel lblPending;
    private javax.swing.JLabel lblRequired;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel valCompleted;
    private javax.swing.JLabel valPending;
    private javax.swing.JLabel valRequired;
    private javax.swing.JLabel valStatus;
}
