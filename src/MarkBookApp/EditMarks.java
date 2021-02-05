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
public class EditMarks extends javax.swing.JInternalFrame {
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    int txtBoxID;
    /**
     * Creates new form EditMarks
     */
    public EditMarks() {
        
        getContentPane().setBackground(new Color(0, 105, 255));
        //CODE TO REMOVE TITLE BAR AND BORDER
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
        this.setPreferredSize(new java.awt.Dimension(1064, 559));
        initComponents();
        invisible();
    }
    
    public void invisible(){
        
        //SET LABELS INVISIBLE
        lblTitle1.setVisible(false);
        lblID.setVisible(false);
        lblFN.setVisible(false);
        lblLN.setVisible(false);
        lblT1.setVisible(false);
        lblT2.setVisible(false);
        lblAM.setVisible(false);
        lblPM.setVisible(false);
        lblP1.setVisible(false);
        lblP2.setVisible(false);
        
        //SET BTN INVISIBLE
        cmdUpdate.setVisible(false);
        cmdNewSearch.setVisible(false);
        
        //SET TEXT FIELDS INVISIBLE
        txtFirst.setVisible(false);
        txtID.setVisible(false);
        txtLast.setVisible(false);
        txtPaper1.setVisible(false);
        txtPaper2.setVisible(false);
        txtAssignment.setVisible(false);
        txtProject.setVisible(false);
        txtTest1.setVisible(false);
        txtTest2.setVisible(false);
    }
    
    public void visible(){
         
                //SET LABELS VISIBLE
                lblTitle1.setVisible(false);
                lblID.setVisible(true);
                lblFN.setVisible(true);
                lblLN.setVisible(true);
                lblT1.setVisible(true);
                lblT2.setVisible(true);
                lblAM.setVisible(true);
                lblPM.setVisible(true);
                lblP1.setVisible(true);
                lblP2.setVisible(true);

                //SET BTN VISIBLE
                cmdUpdate.setVisible(true);
                cmdNewSearch.setVisible(true);

                //SET TEXT FIELDS VISIBLE
                txtFirst.setVisible(true);
                txtID.setVisible(true);
                txtLast.setVisible(true);
                txtPaper1.setVisible(true);
                txtPaper2.setVisible(true);
                txtAssignment.setVisible(true);
                txtProject.setVisible(true);
                txtTest1.setVisible(true);
                txtTest2.setVisible(true);
                        
                //SET USED LABELS INVISIBLE
                lblTitle2.setVisible(false);        
                txtSearch.setVisible(false);
                cmdSearch.setVisible(false);
    }

    public void start(){
                //SET LABELS BACK TO START
                lblTitle2.setVisible(true);        
                txtSearch.setVisible(true);
                cmdSearch.setVisible(true);
    }
    public void DoConnect(){
        
        boolean found = false;
        //CREATES A NEW SEARCH FORM TO DISPLAY RESULTS
        try{
            //CONNECT TO XAMPP DATABASE 
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/mycourse?zeroDateTimeBehavior=convertToNull";
            String user = "root";
            String password = "";
           
            con = DriverManager.getConnection(url, user, password);
            
            //CONSTRAIN - ID YOU ARE LOOKING FOR
            try{
                txtBoxID = Integer.parseInt(txtSearch.getText());
            }
            catch(NumberFormatException err){
                JOptionPane.showMessageDialog(EditMarks.this, "Must enter a number");
            }
                
            //EXECUTE SQL STATEMENTS
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM students";
            rs = stmt.executeQuery(sql);
            
            
            rs.next();
            //CHECKS IF ID IS FOUND IN RS
            //WHILE RECORDS ARE FOUND IN RS
            //CHECK FOR A MATCH
            
            do{
                
                //GET ID FROM THE ROW
                int searchID = rs.getInt(1);
                
                /*COMPARE WITH TEXT BOX
                IF MATCH FOUND BREAK OUT OF LOOP
                */
                if(searchID == txtBoxID){
                    JOptionPane.showMessageDialog(EditMarks.this, "Match Found", "MarkBook", JOptionPane.INFORMATION_MESSAGE);
                    found = true;
                    break;
                }
                
            } while( rs.next() != false);
            
            if(found == false)
                JOptionPane.showMessageDialog(EditMarks.this, "ID not Found!");
            else{
                //SHOW NEW FORM
                visible();
                
                //DISPLAY INFORMATION IN TEXTFIELDS
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
                

            }
                
        
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(EditMarks.this, "Error:" + e.getMessage());
        }  
        
        
        catch(Exception e){
            JOptionPane.showMessageDialog(EditMarks.this, "Error:" + e.getMessage());
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

        lblTitle2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cmdSearch = new javax.swing.JButton();
        lblTitle1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtFirst = new javax.swing.JTextField();
        txtLast = new javax.swing.JTextField();
        txtPaper1 = new javax.swing.JTextField();
        txtPaper2 = new javax.swing.JTextField();
        lblP1 = new javax.swing.JLabel();
        lblFN = new javax.swing.JLabel();
        lblP2 = new javax.swing.JLabel();
        txtTest2 = new javax.swing.JTextField();
        lblLN = new javax.swing.JLabel();
        txtAssignment = new javax.swing.JTextField();
        lblT1 = new javax.swing.JLabel();
        txtProject = new javax.swing.JTextField();
        lblT2 = new javax.swing.JLabel();
        lblAM = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtTest1 = new javax.swing.JTextField();
        lblPM = new javax.swing.JLabel();
        cmdUpdate = new javax.swing.JButton();
        cmdNewSearch = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Edit Marks");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/MarkBookApp/book2.png"))); // NOI18N

        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("Enter the student's ID number to search:");

        txtSearch.setForeground(new java.awt.Color(0, 153, 255));

        cmdSearch.setBackground(new java.awt.Color(0, 153, 255));
        cmdSearch.setForeground(new java.awt.Color(255, 255, 255));
        cmdSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/find (1).png"))); // NOI18N
        cmdSearch.setText("Search");
        cmdSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        cmdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSearchActionPerformed(evt);
            }
        });

        lblTitle1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("Student Information");

        txtID.setForeground(new java.awt.Color(0, 153, 255));
        txtID.setEnabled(false);

        txtFirst.setForeground(new java.awt.Color(0, 153, 255));

        txtLast.setForeground(new java.awt.Color(0, 153, 255));

        txtPaper1.setForeground(new java.awt.Color(0, 153, 255));

        txtPaper2.setForeground(new java.awt.Color(0, 153, 255));

        lblP1.setForeground(new java.awt.Color(255, 255, 255));
        lblP1.setText("Paper1:");

        lblFN.setForeground(new java.awt.Color(255, 255, 255));
        lblFN.setText("First Name:");

        lblP2.setForeground(new java.awt.Color(255, 255, 255));
        lblP2.setText("Paper2:");

        txtTest2.setForeground(new java.awt.Color(0, 153, 255));
        txtTest2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTest2ActionPerformed(evt);
            }
        });

        lblLN.setForeground(new java.awt.Color(255, 255, 255));
        lblLN.setText("Last Name:");

        txtAssignment.setForeground(new java.awt.Color(0, 153, 255));

        lblT1.setForeground(new java.awt.Color(255, 255, 255));
        lblT1.setText("Test1:");

        txtProject.setForeground(new java.awt.Color(0, 153, 255));

        lblT2.setForeground(new java.awt.Color(255, 255, 255));
        lblT2.setText("Test2:");

        lblAM.setForeground(new java.awt.Color(255, 255, 255));
        lblAM.setText("Assignment Mark:");

        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID:");

        txtTest1.setForeground(new java.awt.Color(0, 153, 255));

        lblPM.setForeground(new java.awt.Color(255, 255, 255));
        lblPM.setText("Project Mark:");

        cmdUpdate.setBackground(new java.awt.Color(0, 153, 255));
        cmdUpdate.setForeground(new java.awt.Color(255, 255, 255));
        cmdUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edit (1).png"))); // NOI18N
        cmdUpdate.setText("Update");
        cmdUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        cmdNewSearch.setBackground(new java.awt.Color(0, 153, 255));
        cmdNewSearch.setForeground(new java.awt.Color(255, 255, 255));
        cmdNewSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/find (1).png"))); // NOI18N
        cmdNewSearch.setText("New Search");
        cmdNewSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        cmdNewSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewSearchActionPerformed(evt);
            }
        });

        cmdClose.setBackground(new java.awt.Color(0, 153, 255));
        cmdClose.setForeground(new java.awt.Color(255, 255, 255));
        cmdClose.setText("Close");
        cmdClose.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(lblTitle1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblPM)
                                            .addComponent(lblAM)
                                            .addComponent(lblP1))
                                        .addGap(60, 60, 60))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblID)
                                                        .addComponent(lblFN))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblT1)
                                                        .addComponent(lblLN)
                                                        .addComponent(lblT2))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(lblP2)))
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
                                    .addComponent(txtPaper2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitle2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmdSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(cmdUpdate))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdNewSearch)
                                .addGap(36, 36, 36)
                                .addComponent(cmdClose)))))
                .addContainerGap(356, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFN)
                    .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLN)
                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblT1)
                    .addComponent(txtTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblT2)
                    .addComponent(txtTest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAM)
                            .addComponent(txtAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPM)
                            .addComponent(txtProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPaper1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblP1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPaper2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblP2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle2)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(cmdUpdate)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdNewSearch)
                    .addComponent(cmdClose))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSearchActionPerformed
        
        DoConnect(); 
        
        
    }//GEN-LAST:event_cmdSearchActionPerformed

    private void txtTest2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTest2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTest2ActionPerformed

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        //GET DATA FROM FIELDS AND VALIDATE IT
        double test1 = 0.0;
        double test2 = 0.0;
        double assignment = 0.0;
        double project = 0.0;
        double paper1 = 0.0;
        double paper2 = 0.0;

        boolean valid = true;

        try{
            test1 = Double.parseDouble(txtTest1.getText());
            test2 = Double.parseDouble(txtTest2.getText());
            assignment = Double.parseDouble(txtAssignment.getText());
            project = Double.parseDouble(txtProject.getText());
            paper1 = Double.parseDouble(txtPaper1.getText());
            paper2 = Double.parseDouble(txtPaper2.getText());
        }
        catch(NumberFormatException err){
            JOptionPane.showMessageDialog(EditMarks.this, "Must enter a valid number", "MarkBook", JOptionPane.ERROR_MESSAGE);
            valid = false;
        }

        if(valid){
            try{
                //UPDATE ROWS
                rs.updateDouble("test_1", test1);
                rs.updateDouble("test_2", test2);
                rs.updateDouble("assignment", assignment);
                rs.updateDouble("project", project);
                rs.updateDouble("paper_1", paper1);
                rs.updateDouble("paper_2", paper2);

                rs.updateRow();
                
                con.close();
                stmt.close();
                rs.close();
                //SHOW SUCCESS MESSAGE
                JOptionPane.showMessageDialog(EditMarks.this, "Successfully updated the record!", "MarkBook", JOptionPane.INFORMATION_MESSAGE);
                
                
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(EditMarks.this, e.getMessage());
            }
            
            
            
        }

        
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdNewSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewSearchActionPerformed
        invisible();
        start();
    }//GEN-LAST:event_cmdNewSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdNewSearch;
    private javax.swing.JButton cmdSearch;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JLabel lblAM;
    private javax.swing.JLabel lblFN;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLN;
    private javax.swing.JLabel lblP1;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblPM;
    private javax.swing.JLabel lblT1;
    private javax.swing.JLabel lblT2;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JTextField txtAssignment;
    private javax.swing.JTextField txtFirst;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLast;
    private javax.swing.JTextField txtPaper1;
    private javax.swing.JTextField txtPaper2;
    private javax.swing.JTextField txtProject;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTest1;
    private javax.swing.JTextField txtTest2;
    // End of variables declaration//GEN-END:variables
}
