/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package RegistrationSystem;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import RegistrationSystem.Register;

/**
 *
 * @author USER
 */
public class Course extends javax.swing.JFrame {
      private Register register;
    private Update transactionSlip;
    private StudentInfo students;
private static int id = 0; // Make id static

public Course() {
    this.register = register;
    this.students = students; // Assign the received instance of StudentInfo to the students variable
    
    initComponents();
     DefaultTableModel collegeModel = DataLog.getTblSchool();
    for (int ids = 0; ids < collegeModel.getRowCount(); ids++) {
    String college = (String) collegeModel.getValueAt(ids, 1); // Assuming college name is in the second column (index 1)
    txtCollege.setText(college); // Assuming txtCollege is a JTextField to display the college name
    String course = (String) checkColumnValue(collegeModel, "College", id);
    if ("CEAS".equals(course)) {
        cbCourse.removeItem("BSEED");
        cbCourse.removeItem("BSSED");
        cbCourse.removeItem("BSPSY");
        cbCourse.addItem("BSEED");
        cbCourse.addItem("BSSED");
        cbCourse.addItem("BSPSY");
    } else if ("CBAA".equals(course)) {
        cbCourse.removeItem("BSA");
        cbCourse.removeItem("BSBA");
        cbCourse.addItem("BSA");
        cbCourse.addItem("BSBA");
    } else if ("CCE".equals(course)) {
        cbCourse.removeItem("BSCS");
        cbCourse.removeItem("BSCPE");
        cbCourse.removeItem("BSECE");
        cbCourse.removeItem("BSIE");
        cbCourse.removeItem("BSIT");
        cbCourse.addItem("BSCS");
        cbCourse.addItem("BSCPE");
        cbCourse.addItem("BSECE");
        cbCourse.addItem("BSIE");
        cbCourse.addItem("BSIT");
    } else if ("CON".equals(course)) {
        cbCourse.removeItem("BSA");
        cbCourse.removeItem("BSBA");
        cbCourse.addItem("BSA");
        cbCourse.addItem("BSBA");
    }
}
}

//      DefaultTableModel collegeModel = DataLog.getTblSchool();
//         String course = 
//                 (String) checkColumnValue(collegeModel,"College",id);
//         if(course == "CEAS")
//         {
//             cbCourse.addItem("Manok");
//         }
   public static Object checkColumnValue(DefaultTableModel table, String columnName, int rowIndex) {
        // Get the column index based on the column name
        int columnIndex = table.findColumn(columnName);

        // Check if the column index is valid
        if (columnIndex == -1) {
            System.out.println("Column not found.");
            return null;
        }

        // Check if the row index is valid
        if (rowIndex < 0 || rowIndex >= table.getRowCount()) {
            System.out.println("Row index out of bounds.");
            return null;
        }

        // Get the value at the specified row and column
        Object value = table.getValueAt(rowIndex, columnIndex);

        // Process the value as needed
        System.out.println("Value at row " + rowIndex + ", column '" + columnName + "': " + value);

//        // Example condition check
//        if (value != null && value.equals(condition)) {
//            System.out.println(columnName);
//            return value;
//        } else {
//            System.out.println("Condition not met!");
//        }
        return value;
    }
    

    //    }
             public boolean idExistsInColumn( Object id,JTable table) {
        int idColumnIndex = findColumnByName("id",table); // Assuming the column name is "Id"

        if (idColumnIndex == -1) {
            // "Id" column not found
            return false;
        }

        return columnContainsValue(table, idColumnIndex, id);
    }
          private int findColumnByName(String columnName, JTable table) {
        TableModel model = table.getModel();
        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equals(columnName)) {
                return i;
            }
        }
        return -1;
    }

   private boolean columnContainsValue(JTable table, int columnIndex, Object value) {
    // Get the table model from the JTable instance
    TableModel model = table.getModel();

    // Iterate through rows of the table
    for (int row = 0; row < model.getRowCount(); row++) {
        // Get the value at the specified cell
        Object cellValue = table.getValueAt(row, columnIndex);

        // Check if the cell value equals the given value
        if (cellValue != null && cellValue.equals(value)) {
            return true;
        }
    }

    return false;
}
//    public String DataModel() {
//        if (cbCS1.isSelected()) {
//            return "1500";
//        } else if (cbIT1.isSelected()) {
//            return "2000";
//        } else if (cbHM1.isSelected()) {
//            return "3000";
//        } else if (cbTM1.isSelected()) {
//            return "4000";
//        } else if (cbPSY1.isSelected()) {
//            return "4500";
//        } else if (cbBA1.isSelected()) {
//            return "5500";
//        } else if (cbA1.isSelected()) {
//            return "3500";
//        } else if (cbN1.isSelected()) {
//            return "2500";
//        } else {
//            return "0"; // Default or no selection
//        }
//    }
//
//    public String DataName() {
//        if (cbCS1.isSelected()) {
//            return "Computer Science";
//        } else if (cbIT1.isSelected()) {
//            return "Information Technology";
//        } else if (cbHM1.isSelected()) {
//            return "Hotel Management";
//        } else if (cbTM1.isSelected()) {
//            return "Tourism";
//        } else if (cbPSY1.isSelected()) {
//            return "Psychology";
//        } else if (cbBA1.isSelected()) {
//            return "Bachelor of Arts";
//        } else if (cbA1.isSelected()) {
//            return "Agriculture";
//        } else if (cbN1.isSelected()) {
//            return "Nursing";
//        } else {
//            return "None"; // Default or no selection
//        }
//    }


    public int Transpo() {
        int transportFee = cbTranspo1.isSelected() ? 200 : 0;
        System.out.println("Transport Fee: " + transportFee);
        return transportFee;
    }

    // Check if hostel is selected
    public int Hostel() {
        int hostelFee = cbHostel1.isSelected() ? 500 : 0;
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

        cbCS = new javax.swing.JCheckBox();
        cbIT = new javax.swing.JCheckBox();
        cbHM = new javax.swing.JCheckBox();
        cbTM = new javax.swing.JCheckBox();
        cbBA = new javax.swing.JCheckBox();
        cbPSY = new javax.swing.JCheckBox();
        cbA = new javax.swing.JCheckBox();
        cbN = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        cbTranspo = new javax.swing.JCheckBox();
        cbHostel = new javax.swing.JCheckBox();
        bgCourses = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        cbTranspo1 = new javax.swing.JCheckBox();
        cbHostel1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtCollege = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbCourse = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        cbCS.setText("BSCS");
        cbCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCSActionPerformed(evt);
            }
        });

        cbIT.setText("BSIT");
        cbIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbITActionPerformed(evt);
            }
        });

        cbHM.setText("BSHM");

        cbTM.setText("BSTM");
        cbTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTMActionPerformed(evt);
            }
        });

        cbBA.setText("BSBA");
        cbBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBAActionPerformed(evt);
            }
        });

        cbPSY.setText("BSPSY");
        cbPSY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPSYActionPerformed(evt);
            }
        });

        cbA.setText("BSA");
        cbA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAActionPerformed(evt);
            }
        });

        cbN.setText("BSN");
        cbN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(153, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Service", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 24))); // NOI18N

        cbTranspo.setText("Transport");
        cbTranspo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTranspoActionPerformed(evt);
            }
        });

        cbHostel.setText("Hostel");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTranspo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHostel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(cbTranspo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHostel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 98, 38));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Service", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 18))); // NOI18N

        cbTranspo1.setText("Transport");
        cbTranspo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTranspo1ActionPerformed(evt);
            }
        });

        cbHostel1.setText("Hostel");

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Optional*");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbHostel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTranspo1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTranspo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHostel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 113, -1));

        txtCollege.setFocusable(false);
        jPanel1.add(txtCollege, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 220, 30));

        jLabel2.setText("College");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        cbCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jPanel1.add(cbCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 220, 30));

        jLabel3.setText("Course");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int transportFee = Transpo();
        int hostelFee = Hostel();
        String hostel = String.valueOf(hostelFee);
        String selectedValue = (String) cbCourse.getSelectedItem();
        DefaultTableModel collegeModel = DataLog.getTblSchool();
        String college = String.valueOf(collegeModel.getValueAt(id, 1));
        String misc;
//    // Debugging output
        System.out.println("College: " + college);
         System.out.println("Selected: " + selectedValue);
//    System.out.println("Selected Course Fee: " + selectedCourseFee);
//    System.out.println("Transport Fee: " + transportFee);
//    System.out.println("Hostel Fee: " + hostelFee);
    try {
            if(transportFee == 0 && hostelFee != 0){
                    misc = hostel;
                }
                else if(transportFee != 0 && hostelFee == 0){
                    misc = String.valueOf(transportFee);
                }
               else if(transportFee != 0 && hostelFee != 0){
                    misc = String.valueOf(transportFee+hostelFee);
                }
                 else{
                   misc="None";
               }
         this.dispose();
         DataLog.addEntryToCollege(college,selectedValue,misc);
         id++;
         DataLog.updateCourseFrameVisibility();
         DataLog.updateCollegeFrameVisibility();
         DataLog.updateStudentFrameVisibility();
    } 
    catch (NumberFormatException e) {
        System.err.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCSActionPerformed

    private void cbITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbITActionPerformed

    private void cbTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTMActionPerformed

    private void cbBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBAActionPerformed

    private void cbPSYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPSYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPSYActionPerformed

    private void cbAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAActionPerformed

    private void cbNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNActionPerformed

    private void cbTranspoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTranspoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTranspoActionPerformed

    private void cbTranspo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTranspo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTranspo1ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCourses;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JCheckBox cbA;
    public javax.swing.JCheckBox cbBA;
    public javax.swing.JCheckBox cbCS;
    private static javax.swing.JComboBox<String> cbCourse;
    public javax.swing.JCheckBox cbHM;
    public javax.swing.JCheckBox cbHostel;
    public javax.swing.JCheckBox cbHostel1;
    public javax.swing.JCheckBox cbIT;
    public javax.swing.JCheckBox cbN;
    public javax.swing.JCheckBox cbPSY;
    public javax.swing.JCheckBox cbTM;
    public javax.swing.JCheckBox cbTranspo;
    public javax.swing.JCheckBox cbTranspo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private static javax.swing.JTextField txtCollege;
    // End of variables declaration//GEN-END:variables
}
