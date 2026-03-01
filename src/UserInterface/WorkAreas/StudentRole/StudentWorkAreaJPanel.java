/*
 * WorkAreaJPanel.java
 * Student Use Case - Main Navigation Panel
 *
 * @author Yiru Chen
 */
package UserInterface.WorkAreas.StudentRole;

import Business.Business;
import Business.Profiles.StudentProfile;
import Business.UserAccounts.UserAccount;
import UserInterface.WorkAreas.StudentRole.StudentWorkResp.CourseworkManagementJPanel;
import UserInterface.WorkAreas.StudentRole.StudentWorkResp.CourseRegistrationJPanel;
import UserInterface.WorkAreas.StudentRole.StudentWorkResp.GraduationAuditJPanel;
import UserInterface.WorkAreas.StudentRole.StudentWorkResp.ViewTranscriptJPanel;
import UserInterface.WorkAreas.StudentRole.StudentWorkResp.StudentProfileJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Yiru Chen
 */
public class StudentWorkAreaJPanel extends javax.swing.JPanel {

    javax.swing.JPanel CardSequencePanel;
    Business business;
    StudentProfile student;
    private UserAccount studentAccount;

    public StudentWorkAreaJPanel(Business b, StudentProfile spp, JPanel clp) {
        this(b, spp, clp, null);
    }

    public StudentWorkAreaJPanel(Business b, StudentProfile spp, JPanel clp, UserAccount account) {
        business = b;
        this.CardSequencePanel = clp;
        student = spp;
        studentAccount = account;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        btnCoursework   = new javax.swing.JButton();
        btnGraduation   = new javax.swing.JButton();
        btnRegistration = new javax.swing.JButton();
        jLabel1         = new javax.swing.JLabel();
        btnTranscript   = new javax.swing.JButton();
        btnPorfile      = new javax.swing.JButton();

        setForeground(new java.awt.Color(51, 51, 51));

        btnCoursework.setBackground(new java.awt.Color(102, 153, 255));
        btnCoursework.setFont(getFont());
        btnCoursework.setForeground(new java.awt.Color(255, 255, 255));
        btnCoursework.setText("Coursework Management");
        btnCoursework.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCoursework.setMaximumSize(new java.awt.Dimension(200, 40));
        btnCoursework.setMinimumSize(new java.awt.Dimension(20, 23));
        btnCoursework.setPreferredSize(new java.awt.Dimension(240, 30));
        btnCoursework.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseworkIdentifyResourceAssetsActionPerformed(evt);
            }
        });

        btnGraduation.setBackground(new java.awt.Color(102, 153, 255));
        btnGraduation.setFont(getFont());
        btnGraduation.setForeground(new java.awt.Color(255, 255, 255));
        btnGraduation.setText("Graduation Audit");
        btnGraduation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGraduation.setMaximumSize(new java.awt.Dimension(200, 40));
        btnGraduation.setMinimumSize(new java.awt.Dimension(20, 20));
        btnGraduation.setPreferredSize(new java.awt.Dimension(240, 25));
        btnGraduation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraduationActionPerformed(evt);
            }
        });

        btnRegistration.setBackground(new java.awt.Color(102, 153, 255));
        btnRegistration.setFont(getFont());
        btnRegistration.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistration.setText("Registration");
        btnRegistration.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistration.setMaximumSize(new java.awt.Dimension(200, 40));
        btnRegistration.setMinimumSize(new java.awt.Dimension(20, 20));
        btnRegistration.setPreferredSize(new java.awt.Dimension(240, 25));
        btnRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrationActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24));
        jLabel1.setText("My Student Portal");

        btnTranscript.setBackground(new java.awt.Color(102, 153, 255));
        btnTranscript.setFont(getFont());
        btnTranscript.setForeground(new java.awt.Color(255, 255, 255));
        btnTranscript.setText("Transcript");
        btnTranscript.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTranscript.setMaximumSize(new java.awt.Dimension(200, 40));
        btnTranscript.setMinimumSize(new java.awt.Dimension(20, 20));
        btnTranscript.setPreferredSize(new java.awt.Dimension(240, 25));
        btnTranscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranscriptActionPerformed(evt);
            }
        });

        btnPorfile.setBackground(new java.awt.Color(102, 153, 255));
        btnPorfile.setFont(getFont());
        btnPorfile.setForeground(new java.awt.Color(255, 255, 255));
        btnPorfile.setText("My Profile");
        btnPorfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPorfile.setMaximumSize(new java.awt.Dimension(200, 40));
        btnPorfile.setMinimumSize(new java.awt.Dimension(20, 20));
        btnPorfile.setPreferredSize(new java.awt.Dimension(240, 25));
        btnPorfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnGraduation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(btnCoursework, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(btnPorfile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTranscript, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(btnRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addContainerGap(548, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCoursework, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGraduation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTranscript, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(btnPorfile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>

    /*
     */
    private void navigateTo(JPanel panel, String name) {
        CardSequencePanel.add(panel, name);
        CardLayout cl = (CardLayout) CardSequencePanel.getLayout();
        cl.show(CardSequencePanel, name);
    }


    private void btnCourseworkIdentifyResourceAssetsActionPerformed(java.awt.event.ActionEvent evt) {
        if (student == null) return;
        CourseworkManagementJPanel panel = new CourseworkManagementJPanel(CardSequencePanel, business, student);
        navigateTo(panel, "Coursework");
    }

    private void btnGraduationActionPerformed(java.awt.event.ActionEvent evt) {
        if (student == null) return;
        GraduationAuditJPanel panel = new GraduationAuditJPanel(CardSequencePanel, business, student);
        navigateTo(panel, "Graduation");
    }

    private void btnRegistrationActionPerformed(java.awt.event.ActionEvent evt) {
        if (student == null) return;
        CourseRegistrationJPanel panel = new CourseRegistrationJPanel(CardSequencePanel, business, student);
        navigateTo(panel, "Registration");
    }

    private void btnTranscriptActionPerformed(java.awt.event.ActionEvent evt) {
        if (student == null) return;
        ViewTranscriptJPanel panel = new ViewTranscriptJPanel(CardSequencePanel, business, student);
        navigateTo(panel, "Transcript");
    }

    private void btnPorfileActionPerformed(java.awt.event.ActionEvent evt) {
        if (student == null) return;
        StudentProfileJPanel panel = new StudentProfileJPanel(CardSequencePanel, business, student);
        navigateTo(panel, "Profile");
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnCoursework;
    private javax.swing.JButton btnGraduation;
    private javax.swing.JButton btnPorfile;
    private javax.swing.JButton btnRegistration;
    private javax.swing.JButton btnTranscript;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}
