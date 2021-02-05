/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkBookApp;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author khalil
 */
public class AddFinalMarks1 extends javax.swing.JInternalFrame {

    //CREATE GLOBAL VARIABLES
    Connection con;
    Statement stmt;
    ResultSet rs;

    /**
     * Creates new form AddFinalMarks
     */
    public AddFinalMarks1() {
        getContentPane().setBackground(new Color(0, 105, 255));
        //CODE TO REMOVE TITLE BAR AND BORDER
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
        this.setPreferredSize(new java.awt.Dimension(1064, 559));
        initComponents();
        DoConnect();
    }

    public void DoConnect() {

        try {
            //CONNECT TO XAMPP DATABASE 
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/mycourse?zeroDateTimeBehavior=convertToNull";
            String user = "root";
            String password = "";

            con = DriverManager.getConnection(url, user, password);

            //EXECUTE SOME SQL AND LOAD THE RECORDS INTO THE RESULT SET
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM students ORDER BY last_name ASC";
            rs = stmt.executeQuery(sql);

            //SET CURSOR
            rs.first();

            //GET DATA FROM RESULTSET
            int id = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);

            String sID = String.valueOf(id);
            //DISPLAY RECORDS TO THE TEXTFIELDS
            txtID.setText(sID);
            txtFirst.setText(firstName);
            txtLast.setText(lastName);
            txtTest1.setText(Double.toString(rs.getDouble(4)));
            txtTest2.setText(Double.toString(rs.getDouble(5)));
            txtAssignment.setText(Double.toString(rs.getDouble(6)));
            txtProject.setText(Double.toString(rs.getDouble(7)));
            txtPaper1.setText(Double.toString(rs.getDouble(8)));
            txtPaper2.setText(Double.toString(rs.getDouble(9)));

        } catch (Exception e) { //CREATES OBJECT CALLED "E"
            JOptionPane.showMessageDialog(AddFinalMarks1.this, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTest1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTest2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAssignment = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtProject = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmdFirst = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmdLast = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmdUpdate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmdClose = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        cmdPrev = new javax.swing.JButton();
        txtFirst = new javax.swing.JTextField();
        cmdNext = new javax.swing.JButton();
        txtLast = new javax.swing.JTextField();
        txtPaper1 = new javax.swing.JTextField();
        txtPaper2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 255));
        setClosable(true);
        setForeground(new java.awt.Color(0, 153, 255));
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Add Final Marks");
        setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/MarkBookApp/book2.png"))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");

        txtTest1.setForeground(new java.awt.Color(0, 153, 255));
        txtTest1.setEnabled(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name:");

        txtTest2.setForeground(new java.awt.Color(0, 153, 255));
        txtTest2.setEnabled(false);
        txtTest2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTest2ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Last Name:");

        txtAssignment.setForeground(new java.awt.Color(0, 153, 255));
        txtAssignment.setEnabled(false);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Test1:");

        txtProject.setForeground(new java.awt.Color(0, 153, 255));
        txtProject.setEnabled(false);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Test2:");

        cmdFirst.setBackground(new java.awt.Color(0, 153, 255));
        cmdFirst.setForeground(new java.awt.Color(255, 255, 255));
        cmdFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/MoveFirstItem.Image.png"))); // NOI18N
        cmdFirst.setText("First");
        cmdFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdFirstActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Assignment Mark:");

        cmdLast.setBackground(new java.awt.Color(0, 153, 255));
        cmdLast.setForeground(new java.awt.Color(255, 255, 255));
        cmdLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/MoveLastItem.Image.png"))); // NOI18N
        cmdLast.setText("Last");
        cmdLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLastActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Project Mark:");

        cmdUpdate.setBackground(new java.awt.Color(0, 153, 255));
        cmdUpdate.setForeground(new java.awt.Color(255, 255, 255));
        cmdUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edit (1).png"))); // NOI18N
        cmdUpdate.setText("Update");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Add Final Marks");

        cmdClose.setBackground(new java.awt.Color(0, 153, 255));
        cmdClose.setForeground(new java.awt.Color(255, 255, 255));
        cmdClose.setText("Close");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        txtID.setForeground(new java.awt.Color(0, 153, 255));
        txtID.setEnabled(false);

        cmdPrev.setBackground(new java.awt.Color(0, 153, 255));
        cmdPrev.setForeground(new java.awt.Color(255, 255, 255));
        cmdPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/MovePreviousItem.Image.png"))); // NOI18N
        cmdPrev.setText("Previous");
        cmdPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPrevActionPerformed(evt);
            }
        });

        txtFirst.setForeground(new java.awt.Color(0, 153, 255));
        txtFirst.setEnabled(false);

        cmdNext.setBackground(new java.awt.Color(0, 153, 255));
        cmdNext.setForeground(new java.awt.Color(255, 255, 255));
        cmdNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/MoveNextItem.Image.png"))); // NOI18N
        cmdNext.setText("Next");
        cmdNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNextActionPerformed(evt);
            }
        });

        txtLast.setForeground(new java.awt.Color(0, 153, 255));
        txtLast.setEnabled(false);

        txtPaper1.setForeground(new java.awt.Color(0, 153, 255));

        txtPaper2.setForeground(new java.awt.Color(0, 153, 255));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Paper1:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Paper2:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdClose))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel9))
                                        .addGap(60, 60, 60))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel5))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(jLabel10)))
                                        .addGap(54, 54, 54)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAssignment)
                                    .addComponent(txtLast)
                                    .addComponent(txtFirst)
                                    .addComponent(txtTest1)
                                    .addComponent(txtTest2)
                                    .addComponent(txtProject)
                                    .addComponent(txtID)
                                    .addComponent(txtPaper1)
                                    .addComponent(txtPaper2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdPrev)
                                .addGap(18, 18, 18)
                                .addComponent(cmdNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdLast)))))
                .addContainerGap(383, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaper1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaper2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdFirst)
                    .addComponent(cmdLast)
                    .addComponent(cmdPrev)
                    .addComponent(cmdNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdUpdate)
                    .addComponent(cmdClose))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTest2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTest2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTest2ActionPerformed

    private void cmdFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdFirstActionPerformed
        //GET DATA FROM RESULTSET
        try {
            rs.first();

            txtID.setText(Integer.toString(rs.getInt(1)));
            txtFirst.setText(rs.getString(2));
            txtLast.setText(rs.getString(3));
            txtTest1.setText(Double.toString(rs.getDouble(4)));
            txtTest2.setText(Double.toString(rs.getDouble(5)));
            txtAssignment.setText(Double.toString(rs.getDouble(6)));
            txtProject.setText(Double.toString(rs.getDouble(7)));
            txtPaper1.setText(Double.toString(rs.getDouble(8)));
            txtPaper2.setText(Double.toString(rs.getDouble(9)));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(AddFinalMarks1.this, e.getMessage());
        }
    }//GEN-LAST:event_cmdFirstActionPerformed

    private void cmdLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLastActionPerformed
        //GET DATA FROM RESULTSET AND ADD TO TEXT FIELDS
        try {
            rs.last();

            txtID.setText(Integer.toString(rs.getInt(1)));
            txtFirst.setText(rs.getString(2));
            txtLast.setText(rs.getString(3));
            txtTest1.setText(Double.toString(rs.getDouble(4)));
            txtTest2.setText(Double.toString(rs.getDouble(5)));
            txtAssignment.setText(Double.toString(rs.getDouble(6)));
            txtProject.setText(Double.toString(rs.getDouble(7)));
            txtPaper1.setText(Double.toString(rs.getDouble(8)));
            txtPaper2.setText(Double.toString(rs.getDouble(9)));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(AddFinalMarks1.this, e.getMessage());
        }
    }//GEN-LAST:event_cmdLastActionPerformed

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        //GET DATA FROM FIELDS AND VALIDATE IT
        double paper1 = 0.0;
        double paper2 = 0.0;

        boolean valid = true;

        try {
            paper1 = Double.parseDouble(txtPaper1.getText());
            paper2 = Double.parseDouble(txtPaper2.getText());

        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(AddFinalMarks1.this, "Must enter a number", "MarkBook", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }

        if (valid) {
            try {
                //UPDATE ROWS
                rs.updateDouble(8, paper1);
                rs.updateDouble(9, paper2);

                rs.updateRow();

                //SHOW SUCCESS MESSAGE
                JOptionPane.showMessageDialog(AddFinalMarks1.this, "Successfully updated the record!", "MarkBook", JOptionPane.INFORMATION_MESSAGE);
                cmdNextActionPerformed(evt);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(AddFinalMarks1.this, e.getMessage());
            }
        } else {
            //CLEAR FIELDS
            txtPaper1.setText("");
            txtPaper2.setText("");

        }

    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        //
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(AddFinalMarks1.this, e.getMessage());
        }
        this.dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPrevActionPerformed
        //GET DATA FROM RESULT SET
        try {
            if (rs.previous()) {
                txtID.setText(Integer.toString(rs.getInt(1)));
                txtFirst.setText(rs.getString(2));
                txtLast.setText(rs.getString(3));
                txtTest1.setText(Double.toString(rs.getDouble(4)));
                txtTest2.setText(Double.toString(rs.getDouble(5)));
                txtAssignment.setText(Double.toString(rs.getDouble(6)));
                txtProject.setText(Double.toString(rs.getDouble(7)));
                txtPaper1.setText(Double.toString(rs.getDouble(8)));
                txtPaper2.setText(Double.toString(rs.getDouble(9)));
            } else {
                rs.next();
                JOptionPane.showMessageDialog(AddFinalMarks1.this, "You have reached the begginning of the file", "MarkBook",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(AddFinalMarks1.this, e.getMessage());
        }

    }//GEN-LAST:event_cmdPrevActionPerformed

    private void cmdNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNextActionPerformed
        //GO TO NEXT ROW
        try {

            if (rs.next()) {
                //GET DATA FROM RESULT SET and DISPLAY DATA IN TEXT FIELDS
                txtID.setText(Integer.toString(rs.getInt(1)));
                txtFirst.setText(rs.getString(2));
                txtLast.setText(rs.getString(3));
                txtTest1.setText(Double.toString(rs.getDouble(4)));
                txtTest2.setText(Double.toString(rs.getDouble(5)));
                txtAssignment.setText(Double.toString(rs.getDouble(6)));
                txtProject.setText(Double.toString(rs.getDouble(7)));
                txtPaper1.setText(Double.toString(rs.getDouble(8)));
                txtPaper2.setText(Double.toString(rs.getDouble(9)));
            } else {
                rs.previous();
                JOptionPane.showMessageDialog(AddFinalMarks1.this, "End of file", "MarkBook", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(AddFinalMarks1.this, e.getMessage());
        }

    }//GEN-LAST:event_cmdNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdFirst;
    private javax.swing.JButton cmdLast;
    private javax.swing.JButton cmdNext;
    private javax.swing.JButton cmdPrev;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAssignment;
    private javax.swing.JTextField txtFirst;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLast;
    private javax.swing.JTextField txtPaper1;
    private javax.swing.JTextField txtPaper2;
    private javax.swing.JTextField txtProject;
    private javax.swing.JTextField txtTest1;
    private javax.swing.JTextField txtTest2;
    // End of variables declaration//GEN-END:variables
}