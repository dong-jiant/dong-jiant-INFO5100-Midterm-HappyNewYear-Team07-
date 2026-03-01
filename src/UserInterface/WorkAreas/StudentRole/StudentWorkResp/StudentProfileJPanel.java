/*
 * Student Profile Panel
 * Allows student to view and edit their personal profile information.
 *
 * @author Yiru Chen
 */
package UserInterface.WorkAreas.StudentRole.StudentWorkResp;

import Business.Business;
import Business.Profiles.StudentProfile;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Yiru Chen
 */
public class StudentProfileJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    private StudentProfile student;

    public StudentProfileJPanel(JPanel container, Business b, StudentProfile sp) {
        initComponents();
        this.userProcessContainer = container;
        this.business = b;
        this.student = sp;
        loadProfile();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitle    = new javax.swing.JLabel();
        lblName     = new javax.swing.JLabel();
        lblEmail    = new javax.swing.JLabel();
        lblDept     = new javax.swing.JLabel();
        lblHobbies  = new javax.swing.JLabel();
        lblInterests= new javax.swing.JLabel();
        lblProgress = new javax.swing.JLabel();

        valName     = new javax.swing.JLabel();
        valEmail    = new javax.swing.JLabel();
        valDept     = new javax.swing.JLabel();

        txtHobbies  = new javax.swing.JTextField();
        txtInterests= new javax.swing.JTextField();
        txtProgress = new javax.swing.JTextField();

        btnSave     = new javax.swing.JButton();
        btnBack     = new javax.swing.JButton();

        // Title
        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18));
        lblTitle.setText("My Profile");

        // Static labels
        lblName.setText("Name:");
        lblEmail.setText("Email:");
        lblDept.setText("Department:");
        lblHobbies.setText("Hobbies:");
        lblInterests.setText("Interests:");
        lblProgress.setText("Academic Progress:");

        // Read-only value labels
        valName.setText("-");
        valEmail.setText("-");
        valDept.setText("-");

        // Editable fields
        txtHobbies.setColumns(25);
        txtInterests.setColumns(25);
        txtProgress.setColumns(25);

        // Save button
        btnSave.setBackground(new java.awt.Color(102, 153, 255));
        btnSave.setForeground(java.awt.Color.WHITE);
        btnSave.setText("Save Changes");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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

        int labelW = 160;
        int valW   = 300;

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName, labelW, labelW, labelW)
                        .addGap(10).addComponent(valName, valW, valW, valW))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmail, labelW, labelW, labelW)
                        .addGap(10).addComponent(valEmail, valW, valW, valW))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDept, labelW, labelW, labelW)
                        .addGap(10).addComponent(valDept, valW, valW, valW))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHobbies, labelW, labelW, labelW)
                        .addGap(10).addComponent(txtHobbies, valW, valW, valW))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInterests, labelW, labelW, labelW)
                        .addGap(10).addComponent(txtInterests, valW, valW, valW))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProgress, labelW, labelW, labelW)
                        .addGap(10).addComponent(txtProgress, valW, valW, valW))
                    .addComponent(btnSave))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15)
                .addComponent(btnBack)
                .addGap(10)
                .addComponent(lblTitle)
                .addGap(25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName).addComponent(valName))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail).addComponent(valEmail))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDept).addComponent(valDept))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHobbies).addComponent(txtHobbies))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInterests).addComponent(txtInterests))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProgress).addComponent(txtProgress))
                .addGap(20)
                .addComponent(btnSave)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void loadProfile() {
        if (student == null || student.getPerson() == null) return;

        valName.setText(safe(student.getPerson().getName()));
        valEmail.setText(safe(student.getPerson().getEmail()));
        valDept.setText(safe(student.getPerson().getDepartment()));
        txtHobbies.setText(safe(student.getHobbies()));
        txtInterests.setText(safe(student.getInterests()));
        txtProgress.setText(safe(student.getAcademicProgress()));
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        if (student == null) return;

        String hobbies  = txtHobbies.getText().trim();
        String interests= txtInterests.getText().trim();
        String progress = txtProgress.getText().trim();

        if (progress.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Academic Progress cannot be empty.",
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        student.setHobbies(hobbies);
        student.setInterests(interests);
        student.setAcademicProgress(progress);

        JOptionPane.showMessageDialog(this,
            "Profile updated successfully!",
            "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        CardLayout cl = (CardLayout) userProcessContainer.getLayout();
        cl.show(userProcessContainer, "student");
    }

    private String safe(String s) {
        return s == null ? "" : s;
    }

    // Variables declaration
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblDept;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHobbies;
    private javax.swing.JLabel lblInterests;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtHobbies;
    private javax.swing.JTextField txtInterests;
    private javax.swing.JTextField txtProgress;
    private javax.swing.JLabel valDept;
    private javax.swing.JLabel valEmail;
    private javax.swing.JLabel valName;
}
