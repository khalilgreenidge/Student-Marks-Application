/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkBookApp;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author khalil
 */
public class DeleteStudent extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int id;
    
    /**
     * Creates new form DeleteStudent
     */
    public DeleteStudent() {
        initComponents();
        getContentPane().setBackground(new Color(0, 105, 255));
        //start();
    }
    
    public void DoConnect(){
        try{
            String user = "tutor";
            String password = "tutorAdmin";
            String url = "jdbc:derby://localhost:1527/students";
            
            //CREATE CONNECTION            
            con = DriverManager.getConnection(url, user, password);
            
            
            
            //GET DATA FROM RESULT SET
            PreparedStatement ps = con.prepareStatement("DELETE FROM coursemarks WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(DeleteStudent.this, "Record Deleted.", "MarkBook", JOptionPane.INFORMATION_MESSAGE);
            
            txtDelete.setText("");
            
            //REFRESH JTABLE
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(DeleteStudent.this, e.getMessage());
        }
    }
    
     
    
    public void start(){
        
        //SET LABELS INVISIBLE
        
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
        cmdDelete.setVisible(false);
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
        
        start2();
    }

    public void start2() {
        //SET LABELS BACK TO START
        lblTitle.setVisible(true);
        txtDelete.setVisible(true);
        cmdSearch.setVisible(true);
        tblStudent.setVisible(true);
        
    }
    
    public void newForm(){
        lblTitle.setVisible(false);
        txtDelete.setVisible(false);
        cmdSearch.setVisible(false);
        tblStudent.setVisible(false);
        
        newForm2();
    }
    
    public void newForm2(){
        lblID.setVisible(true);
        lblFN.setVisible(true);
        lblLN.setVisible(true);
        lblT1.setVisible(true);
        lblT2.setVisible(true);
        lblAM.setVisible(true);
        lblPM.setVisible(true);
        lblP1.setVisible(true);
        lblP2.setVisible(true);
        
        //SET BTN INVISIBLE
        cmdDelete.setVisible(true);
        cmdNewSearch.setVisible(true);
        
        //SET TEXT FIELDS INVISIBLE
        txtFirst.setVisible(true);
        txtID.setVisible(true);
        txtLast.setVisible(true);
        txtPaper1.setVisible(true);
        txtPaper2.setVisible(true);
        txtAssignment.setVisible(true);
        txtProject.setVisible(true);
        txtTest1.setVisible(true);
        txtTest2.setVisible(true);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        studentsPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("studentsPU").createEntityManager();
        coursemarksQuery = java.beans.Beans.isDesignTime() ? null : studentsPUEntityManager.createQuery("SELECT c FROM Coursemarks c");
        coursemarksList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : coursemarksQuery.getResultList();
        coursemarksQuery1 = java.beans.Beans.isDesignTime() ? null : studentsPUEntityManager.createQuery("SELECT c FROM Coursemarks c");
        coursemarksList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : coursemarksQuery1.getResultList();
        coursemarksQuery2 = java.beans.Beans.isDesignTime() ? null : studentsPUEntityManager.createQuery("SELECT c FROM Coursemarks c");
        coursemarksList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : coursemarksQuery2.getResultList();
        coursemarksQuery3 = java.beans.Beans.isDesignTime() ? null : studentsPUEntityManager.createQuery("SELECT c FROM Coursemarks c");
        coursemarksList3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : coursemarksQuery3.getResultList();
        cmdDelete = new javax.swing.JButton();
        txtDelete = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtFirst = new javax.swing.JTextField();
        txtLast = new javax.swing.JTextField();
        txtPaper1 = new javax.swing.JTextField();
        txtPaper2 = new javax.swing.JTextField();
        lblP1 = new javax.swing.JLabel();
        lblFN = new javax.swing.JLabel();
        lblLN = new javax.swing.JLabel();
        lblP2 = new javax.swing.JLabel();
        txtAssignment = new javax.swing.JTextField();
        txtTest2 = new javax.swing.JTextField();
        lblAM = new javax.swing.JLabel();
        txtTest1 = new javax.swing.JTextField();
        lblT2 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblT1 = new javax.swing.JLabel();
        txtProject = new javax.swing.JTextField();
        cmdNewSearch = new javax.swing.JButton();
        lblPM = new javax.swing.JLabel();
        cmdSearch = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Delete Student");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/MarkBookApp/book2.png"))); // NOI18N
        setNextFocusableComponent(cmdDelete);
        setPreferredSize(new java.awt.Dimension(713, 452));

        cmdDelete.setText("Delete");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, coursemarksList3, tblStudent);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstName}"));
        columnBinding.setColumnName("First Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("Last Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${test1}"));
        columnBinding.setColumnName("Test1");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${test2}"));
        columnBinding.setColumnName("Test2");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${assignment}"));
        columnBinding.setColumnName("Assignment");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${project}"));
        columnBinding.setColumnName("Project");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${paper1}"));
        columnBinding.setColumnName("Paper1");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${paper2}"));
        columnBinding.setColumnName("Paper2");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, coursemarksQuery, org.jdesktop.beansbinding.ELProperty.create("${}"), tblStudent, org.jdesktop.beansbinding.BeanProperty.create("updateSelectionOnSort"));
        bindingGroup.addBinding(binding);

        tblStudent.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblStudentPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudent);

        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Type the ID# of the student to delete");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblP1.setText("Paper1:");

        lblFN.setText("First Name:");

        lblLN.setText("Last Name:");

        lblP2.setText("Paper2:");

        txtTest2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTest2ActionPerformed(evt);
            }
        });

        lblAM.setText("Assignment Mark:");

        lblT2.setText("Test2:");

        lblID.setText("ID:");

        lblT1.setText("Test1:");

        cmdNewSearch.setText("New Search");
        cmdNewSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewSearchActionPerformed(evt);
            }
        });

        lblPM.setText("Project Mark:");

        cmdSearch.setText("Search");
        cmdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdSearch)
                                .addGap(102, 102, 102)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFN)
                            .addComponent(lblID)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblT2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblT1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAM, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPM, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblP1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblP2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblLN, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(1, 1, 1)))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtProject, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(4, 4, 4))
                                .addComponent(txtTest2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTest1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLast, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFirst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPaper1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPaper2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cmdNewSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdDelete)
                .addGap(58, 58, 58)
                .addComponent(jButton1)
                .addGap(167, 167, 167))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblID)
                                .addGap(13, 13, 13)
                                .addComponent(lblFN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblLN)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblT1)
                                .addGap(14, 14, 14)
                                .addComponent(lblT2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPM))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(18, 18, 18)
                        .addComponent(txtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdSearch)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblP1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblP2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPaper1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPaper2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdDelete)
                    .addComponent(cmdNewSearch)
                    .addComponent(jButton1))
                .addGap(99, 99, 99))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        //GET ID FROM TXTDELETE
        id = Integer.parseInt(txtDelete.getText());
        
        int response = JOptionPane.showConfirmDialog(DeleteStudent.this, "Do you want to delete id# -" + id + "?", "MarkBook", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(response == JOptionPane.YES_OPTION){
            DoConnect();
            
        }
        else 
            txtDelete.setText("");
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void tblStudentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblStudentPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblStudentPropertyChange

    private void txtTest2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTest2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTest2ActionPerformed

    private void cmdNewSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewSearchActionPerformed
        //start();
        //start2();
    }//GEN-LAST:event_cmdNewSearchActionPerformed

    private void cmdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSearchActionPerformed

        DoConnect();

    }//GEN-LAST:event_cmdSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdNewSearch;
    private javax.swing.JButton cmdSearch;
    private java.util.List<MarkBookApp.Coursemarks> coursemarksList;
    private java.util.List<MarkBookApp.Coursemarks> coursemarksList1;
    private java.util.List<MarkBookApp.Coursemarks> coursemarksList2;
    private java.util.List<MarkBookApp.Coursemarks> coursemarksList3;
    private javax.persistence.Query coursemarksQuery;
    private javax.persistence.Query coursemarksQuery1;
    private javax.persistence.Query coursemarksQuery2;
    private javax.persistence.Query coursemarksQuery3;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAM;
    private javax.swing.JLabel lblFN;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLN;
    private javax.swing.JLabel lblP1;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblPM;
    private javax.swing.JLabel lblT1;
    private javax.swing.JLabel lblT2;
    private javax.swing.JLabel lblTitle;
    private javax.persistence.EntityManager studentsPUEntityManager;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtAssignment;
    private javax.swing.JTextField txtDelete;
    private javax.swing.JTextField txtFirst;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLast;
    private javax.swing.JTextField txtPaper1;
    private javax.swing.JTextField txtPaper2;
    private javax.swing.JTextField txtProject;
    private javax.swing.JTextField txtTest1;
    private javax.swing.JTextField txtTest2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
