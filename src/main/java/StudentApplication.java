/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static RegistrationSystem.Course.checkColumnValue;

/**
 *
 * @author USER
 */
public class StudentApplication extends javax.swing.JFrame {
  
    public StudentApplication() {
        initComponents();
       String selectedCollege = (String) cbCourse.getSelectedItem();
        cbCourse1.removeAllItems();
        
     cbCourse.addActionListener((java.awt.event.ActionEvent evt) -> {
         String course = (String) cbCourse.getSelectedItem();
         cbCourse1.removeAllItems();
         if ("CEAS".equals(course)) {
             cbCourse1.addItem("BSEED");
             cbCourse1.addItem("BSSED");
             cbCourse1.addItem("BSPSY");
         } else if ("CBAA".equals(course)) {
             cbCourse1.addItem("BSA");
             cbCourse1.addItem("BSBA");
         } else if ("CCE".equals(course)) {
             cbCourse1.addItem("BSCS");
             cbCourse1.addItem("BSCPE");
             cbCourse1.addItem("BSECE");
             cbCourse1.addItem("BSIE");
             cbCourse1.addItem("BSIT");
         } else if ("CON".equals(course)) {
             cbCourse1.addItem("BSN");
         }
        });
    }
      public int Transpo() {
        int transportFee = cbTranspo2.isSelected() ? 200 : 0;
        System.out.println("Transport Fee: " + transportFee);
        return transportFee;
    }

    // Check if hostel is selected
    public int Hostel() {
        int hostelFee = cbHostel2.isSelected() ? 500 : 0;
        System.out.println("Hostel Fee: " + hostelFee);
        return hostelFee;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        cbCourse = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbCourse1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        cbTranspo2 = new javax.swing.JCheckBox();
        cbHostel2 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGmail = new javax.swing.JTextField();
        txtMobileNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBirthdate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 18))); // NOI18N

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CEAS", "CBAA", "CCE", "CON" }));
        cbCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCourseActionPerformed(evt);
            }
        });

        jLabel1.setText("College");

        cbCourse1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jLabel3.setText("Course");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Service", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 18))); // NOI18N

        cbTranspo2.setText("Transport");
        cbTranspo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTranspo2ActionPerformed(evt);
            }
        });

        cbHostel2.setText("Hostel");

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Optional*");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbHostel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTranspo2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTranspo2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHostel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setText("Last Name");

        jLabel5.setText("First Name");

        jLabel6.setText("Email");

        jLabel7.setText("Mobile Number");

        jLabel8.setText("Birthdate");

        txtBirthdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthdateActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("*Follow 00/00/0000");

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMobileNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(cbCourse1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLastname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(cbCourse, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(cbCourse1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
            
String lastname = txtLastname.getText();
String firstname = txtFirstName.getText();
String mobileNumber = txtMobileNumber.getText();
String email = txtGmail.getText();
String birthdate = txtBirthdate.getText();
String college = (String) cbCourse.getSelectedItem();
String course = (String) cbCourse1.getSelectedItem();
int transportFee = Transpo();
int hostelFee = Hostel();
String miscs = null;

// Validation checks
if (!lastname.matches("[a-zA-Z]+")) {
    // Lastname should not contain numbers
    JOptionPane.showMessageDialog(null, "Lastname should not contain numbers");
    return;
}

if (!firstname.matches("[a-zA-Z]+")) {
    // Firstname should not contain numbers
    JOptionPane.showMessageDialog(null, "Firstname should not contain numbers");
    return;
}

if (!mobileNumber.matches("\\d+")) {
    // Mobile number should only contain digits
    JOptionPane.showMessageDialog(null, "Mobile number should only contain digits");
    return;
}

if (!email.matches(".+@gmail\\.com")) {
    // Email should be a valid Gmail address
    JOptionPane.showMessageDialog(null, "Email should be a valid Gmail address");
    return;
}

if (!birthdate.matches("\\d{2}/\\d{2}/\\d{4}")) {
    // Birthdate should follow the format mm/dd/yyyy
    JOptionPane.showMessageDialog(null, "Birthdate should follow the format mm/dd/yyyy");
    return;
}

// Calculate miscs based on transportFee and hostelFee
try {
    if (transportFee == 0 && hostelFee != 0) {
        miscs = String.valueOf(hostelFee);
    } else if (transportFee != 0 && hostelFee == 0) {
        miscs = String.valueOf(transportFee);
    } else if (transportFee != 0 && hostelFee != 0) {
        miscs = String.valueOf(transportFee+hostelFee);
    } else {
        miscs = "None";
    }
} catch (Exception e) {

}
int dialogResult = JOptionPane.showConfirmDialog(null, "Is this the correct information?", "Warning", JOptionPane.YES_NO_OPTION);
if (dialogResult == JOptionPane.YES_OPTION) {
    DefaultTableModel collegeModel = DataLog.getTblSchool();
    DefaultTableModel courseModel = DataLog.getTblCourse();
    DefaultTableModel studentModel = DataLog.getTblStudent();
}
else{
    return;
}


try {
    DataLog.addEntryStudent(college);
     DataLog.addEntryToCollegeStudent(college,course,miscs);
     DataLog.addEntryToStudentUser(lastname,firstname,mobileNumber,email,college,course);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid ID format");
}

     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCourseActionPerformed

    private void cbTranspo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTranspo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTranspo2ActionPerformed

    private void txtBirthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Window window = new Window();
       window.setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox<String> cbCourse;
    private static javax.swing.JComboBox<String> cbCourse1;
    public javax.swing.JCheckBox cbHostel2;
    public javax.swing.JCheckBox cbTranspo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JTextField txtBirthdate;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtMobileNumber;
    // End of variables declaration//GEN-END:variables
}
