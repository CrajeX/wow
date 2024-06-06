/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package RegistrationSystem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author USER
 */
public class DataLog extends javax.swing.JFrame {
  
    DataLog() {
        initComponents();
        updateCourseFrameVisibility();
        updateStudentFrameVisibility();
    }
public static void Admin(boolean choice) {
    jMenu1.setEnabled(choice);
    jMenu2.setEnabled(choice);
    jMenu3.setEnabled(choice);
     setTableFocusable(tblSchool, choice);
        setTableFocusable(tblCourse, choice);
        setTableFocusable(tblStudent, choice);
}
 private static void setTableFocusable(javax.swing.JTable table, boolean choice) {
        table.setEnabled(choice);
        table.setFocusable(choice);

        // Set cell editors to null to make the table non-editable
        if (!choice) {
            TableColumnModel columnModel = table.getColumnModel();
            for (int column = 0; column < columnModel.getColumnCount(); column++) {
                columnModel.getColumn(column).setCellEditor(null);
            }
        }
    }
public static void updateCourseFrameVisibility() {
        DefaultTableModel collegeModel = getTblSchool();
        DefaultTableModel courseModel = getTblCourse();
        DefaultTableModel studentModel = getTblStudent();

        if (courseModel.getRowCount() < collegeModel.getRowCount() && courseModel.getRowCount() == studentModel.getRowCount()) {
            // Show the Course frame
            jMenuItem2.setEnabled(true);
        } else {
            // Hide the Course frame
            jMenuItem2.setEnabled(false);
        }
    }
public static void updateCollegeFrameVisibility() {
        DefaultTableModel collegeModel = getTblSchool();
        DefaultTableModel courseModel = getTblCourse();
        DefaultTableModel studentModel = getTblStudent();

        if (courseModel.getRowCount() == collegeModel.getRowCount() && courseModel.getRowCount() ==  studentModel.getRowCount()) {
            // Show the Course frame
            jMenuItem1.setEnabled(true);
        } else {
            // Hide the Course frame
            jMenuItem1.setEnabled(false);
        }
    }
public static void updateStudentFrameVisibility() {
        DefaultTableModel collegeModel = getTblSchool();
        DefaultTableModel courseModel = getTblCourse();
          DefaultTableModel studentModel = getTblStudent();

        if (studentModel.getRowCount() < collegeModel.getRowCount()&& studentModel.getRowCount() < courseModel.getRowCount()) {
            // Show the Course frame
            jMenuItem3.setEnabled(true);
        } else {
            // Hide the Course frame
            jMenuItem3.setEnabled(false);
        }
    }

private static int currentId = 1;
private static int CourseId = 1;
private static int StudentId = 1;

public static void addEntry(String college) {
    DefaultTableModel tableModel = (DefaultTableModel) tblSchool.getModel();
    
    // Check if ID 1 exists
    if (!idExists(1, tableModel)) {
        resetIds(tableModel, 1);
    }

    Object[] rowData = {currentId++, college};
    tableModel.addRow(rowData);
}

public static void addEntryToCollege(String college, String course, String misc) {
    DefaultTableModel tableModel = (DefaultTableModel) tblCourse.getModel();
    
    // Check if ID 1 exists
    if (!idExists(1, tableModel)) {
        resetIds(tableModel, 1);
    }

    Object[] rowData = {CourseId++, college, course, misc};
    tableModel.addRow(rowData);
}

public static void addEntryToStudent(String lastname, String firstname, String mobile, String gmail, String college, String course) {
    DefaultTableModel tableModel = (DefaultTableModel) tblStudent.getModel();
    
    // Check if ID 1 exists
    if (!idExists(1, tableModel)) {
        resetIds(tableModel, 1);
    }

    Object[] rowData = {StudentId++, lastname, firstname, mobile, gmail, college, course};
    tableModel.addRow(rowData);
}

// Utility method to check if an ID exists in a table
private static boolean idExists(int id, DefaultTableModel tableModel) {
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        if ((int) tableModel.getValueAt(i, 0) == id) {
            return true;
        }
    }
    return false;
}

// Utility method to reset all IDs to a specific value
public static void addEntryStudent(String college) {
    DefaultTableModel tableModel = (DefaultTableModel) tblSchool.getModel();

    // Ensure unique IDs starting from the highest current ID
    updateIds(tableModel);

    // Add the new entry
    Object[] rowData = {currentId++, college};
    tableModel.addRow(rowData);
}

public static void addEntryToCollegeStudent(String college, String course, String misc) {
    DefaultTableModel tableModel = (DefaultTableModel) tblCourse.getModel();
     
    // Ensure unique IDs starting from the highest current ID
    updateIds(tableModel);

    // Add the new entry
    Object[] rowData = {CourseId++, college, course, misc};
    tableModel.addRow(rowData);
}

public static void addEntryToStudentUser(String lastname, String firstname, String mobile, String gmail, String college, String course) {
    DefaultTableModel tableModel = (DefaultTableModel) tblStudent.getModel();

    // Ensure unique IDs starting from the highest current ID
    updateIds(tableModel);

    // Check if a similar record already exists
    if (isDuplicateRecord(lastname, firstname, tableModel)) {
        JOptionPane.showMessageDialog(null, "A similar record already exists. Ask admin to change the data");
        deleteEntryFromAllTables(StudentId);
        return;
    }

    // Add the new entry
    Object[] rowData = {StudentId++, lastname, firstname, mobile, gmail, college, course};
    tableModel.addRow(rowData);
}

// Utility method to reset all IDs to a specific value
private static void resetIds(DefaultTableModel tableModel, int startId) {
    int id = startId;
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        tableModel.setValueAt(id++, i, 0);
    }
}

// Utility method to update the static ID counters based on the highest current ID
private static void updateIds(DefaultTableModel tableModel) {
    int maxId = 0;
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        int currentRowId = (int) tableModel.getValueAt(i, 0);
        if (currentRowId > maxId) {
            maxId = currentRowId;
        }
    }
    currentId = maxId + 1;
    CourseId = maxId + 1;
    StudentId = maxId + 1;
}


// Utility method to check if a similar record exists in the table
private static boolean isDuplicateRecord(String college, DefaultTableModel tableModel, int columnIndex) {
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        if (tableModel.getValueAt(i, columnIndex).equals(college)) {
            return true;
        }
    }
    return false;
}

// Overloaded utility method to check if a similar record exists in the table for student entries
private static boolean isDuplicateRecord(String lastname, String firstname, DefaultTableModel tableModel) {
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        if (tableModel.getValueAt(i, 1).equals(lastname) && tableModel.getValueAt(i, 2).equals(firstname)) {
            return true;
        }
    }
    return false;
}

    public static void deleteEntryFromAllTables(int id) {
    deleteEntryFromTable(tblSchool, id);
    deleteEntryFromTable(tblCourse, id);
    deleteEntryFromTable(tblStudent, id);
}

// Method to delete a row by ID and decrement subsequent IDs in a given table
private static void deleteEntryFromTable(JTable table, int id) {
    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
    int rowCount = tableModel.getRowCount();

    // Find and remove the row with the given ID
    for (int i = 0; i < rowCount; i++) {
        if ((int) tableModel.getValueAt(i, 0) == id) {
            tableModel.removeRow(i);
            rowCount--;
            // Decrement IDs of subsequent rows
            for (int j = i; j < rowCount; j++) {
                tableModel.setValueAt(j + 1, j, 0); // Assuming ID is in the first column (index 0)
            }
            break;
        }
    }
}


    private static boolean isDuplicateRecords(String value, DefaultTableModel tableModel, int columnIndex) {
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String existingValue = (String) tableModel.getValueAt(row, columnIndex);
            if (value.equals(existingValue)) {
                return true; // A similar record already exists
            }
        }
        return false; // No similar record found
    }

    private static boolean isDuplicateRecords(String lastname, String firstname, DefaultTableModel tableModel) {
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String existingLastname = (String) tableModel.getValueAt(row, 1);
            String existingFirstname = (String) tableModel.getValueAt(row, 2);
            if (lastname.equals(existingLastname) && firstname.equals(existingFirstname)) {
                return true; // A similar record already exists
            }
        }
        return false; // No similar record found
    }
      public static DefaultTableModel getTblSchool() {
        return (DefaultTableModel) tblSchool.getModel();
    }
     public static DefaultTableModel getTblCourse() {
       return (DefaultTableModel) tblCourse.getModel();
    }
      public static DefaultTableModel getTblStudent() {
       return (DefaultTableModel) tblStudent.getModel();
    }
     
    public boolean idExistsInColumn(Object id, JTable table) {
    int idColumnIndex = findColumnByName("id", table); // Assuming the column name is "id"

    if (idColumnIndex == -1) {
        // "id" column not found
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSchool = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCourse = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LogOut = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        tblSchool.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Id", "College"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSchool);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        tblCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Id", "College", "Course", "Misc"
            }
        ));
        jScrollPane3.setViewportView(tblCourse);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Id", "Last Name", "First Name", "Mobile ", "Gmail", "College", "Course"
            }
        ));
        jScrollPane1.setViewportView(tblStudent);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Account");

        LogOut.setText("Log-Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        jMenu1.add(LogOut);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Management");

        jMenuItem1.setText("College");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Course");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Student");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Update");

        jMenuItem4.setText("Update");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Delete");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        DataLog.Admin(false);
        new Next(null).setVisible(true);
        
    }//GEN-LAST:event_LogOutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
    // Pass the existing DataLog instance to the Register constructor
    Register register = new Register();
    register.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed


    // Show or create a new Course frame
    Course course = new Course();
    course.setVisible(true);


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    StudentInfo student = new StudentInfo();
    student.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
     System.exit(0);
        }
        else{
            return;
        }

    }//GEN-LAST:event_ExitActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       Update update = new Update();
       update.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        DeleteRow delete = new DeleteRow();
        delete.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JMenuItem Exit;
    private static javax.swing.JMenuItem LogOut;
    private static javax.swing.JMenu jMenu1;
    private static javax.swing.JMenu jMenu2;
    private static javax.swing.JMenu jMenu3;
    private static javax.swing.JMenuBar jMenuBar1;
    private static javax.swing.JMenuItem jMenuItem1;
    private static javax.swing.JMenuItem jMenuItem2;
    private static javax.swing.JMenuItem jMenuItem3;
    private static javax.swing.JMenuItem jMenuItem4;
    private static javax.swing.JMenuItem jMenuItem5;
    private static javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel jPanel2;
    private static javax.swing.JPanel jPanel3;
    private static javax.swing.JPanel jPanel4;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTable tblCourse;
    private static javax.swing.JTable tblSchool;
    private static javax.swing.JTable tblStudent;
    // End of variables declaration//GEN-END:variables
}
