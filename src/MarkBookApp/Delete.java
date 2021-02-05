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
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils; //IMPORT RS2XML.JAR 

/**
 *
 * @author khalil
 */
public class Delete extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    int id;
    /**
     * Creates new form Delete
     */
    public Delete() {
        initComponents();
        getContentPane().setBackground(new Color(0, 105, 255));
        invisible();
    }
    
    public void invisible(){
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
    }
    
    public void visible(){
        //SET START SCREEN OBJECTS INVISIBLE
        lblTitle.setVisible(false);
        txtDelete.setVisible(false);
        cmdSearch.setVisible(false);
        tblStudent.setVisible(false);
        
        
        //SET NEW FORM OBJECT VISIBLE
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
    
    public void start(){
        //SET START SCREEN OBJECTS INVISIBLE
        lblTitle.setVisible(true);
        txtDelete.setVisible(true);
        cmdSearch.setVisible(true);
        tblStudent.setVisible(true);
    }
    
    public void Delete(){
        //CONSTRAIN - ID YOU ARE LOOKING FOR
            try{
                id = Integer.parseInt(txtDelete.getText());
            }
            catch(NumberFormatException err){
                JOptionPane.showMessageDialog(Delete.this, "Must enter a number");
            }
            
            //GET DATA FROM RESULT SET
            try{
                PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");
                ps.setInt(1, id);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(Delete.this, "Record Deleted.", "MarkBook", JOptionPane.INFORMATION_MESSAGE);

                txtDelete.setText("");

            
                //REFRESH JTABLE
                refresh();
                //CLOSE CONNECTION
                con.close();
                stmt.close();
                rs.close();
                
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(Delete.this, e.getMessage());
            }
            
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
                id = Integer.parseInt(txtDelete.getText());
            }
            catch(NumberFormatException err){
                JOptionPane.showMessageDialog(Delete.this, "Must enter a number");
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
                if(searchID == id){
                    JOptionPane.showMessageDialog(Delete.this, "Match Found", "MarkBook", JOptionPane.INFORMATION_MESSAGE);
                    found = true;
                    break;
                }
                
            } while( rs.next() != false);
            
            if(found == false)
                JOptionPane.showMessageDialog(Delete.this, "ID not Found!");
            else{
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
                JOptionPane.showMessageDialog(Delete.this, e.getMessage());
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void refresh(){
        try {
            String sql = "SELECT * FROM students";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            tblStudent.setModel(DbUtils.resultSetToTableModel(rs));
        }
       catch(SQLException e){
           JOptionPane.showMessageDialog(Delete.this, e.getMessage());
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        studentsPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("studentsPU").createEntityManager();
        coursemarksQuery = java.beans.Beans.isDesignTime() ? null : studentsPUEntityManager.createQuery("SELECT c FROM Coursemarks c");
        coursemarksList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : coursemarksQuery.getResultList();
        coursemarksQuery1 = java.beans.Beans.isDesignTime() ? null : studentsPUEntityManager.createQuery("SELECT c FROM Coursemarks c");
        coursemarksList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : coursemarksQuery1.getResultList();
        lblID = new javax.swing.JLabel();
        lblT1 = new javax.swing.JLabel();
        txtProject = new javax.swing.JTextField();
        lblPM = new javax.swing.JLabel();
        cmdSearch = new javax.swing.JButton();
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
        txtDelete = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtFirst = new javax.swing.JTextField();
        txtTest1 = new javax.swing.JTextField();
        lblT2 = new javax.swing.JLabel();
        cmdDelete = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        cmdNewSearch = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Delete Student");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/MarkBookApp/book2.png"))); // NOI18N

        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID:");

        lblT1.setForeground(new java.awt.Color(255, 255, 255));
        lblT1.setText("Test1:");

        txtProject.setBackground(new java.awt.Color(240, 240, 240));
        txtProject.setForeground(new java.awt.Color(0, 153, 255));
        txtProject.setEnabled(false);

        lblPM.setForeground(new java.awt.Color(255, 255, 255));
        lblPM.setText("Project Mark:");

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

        txtLast.setBackground(new java.awt.Color(240, 240, 240));
        txtLast.setForeground(new java.awt.Color(0, 153, 255));
        txtLast.setEnabled(false);

        txtPaper1.setBackground(new java.awt.Color(240, 240, 240));
        txtPaper1.setForeground(new java.awt.Color(0, 153, 255));
        txtPaper1.setEnabled(false);

        txtPaper2.setBackground(new java.awt.Color(240, 240, 240));
        txtPaper2.setForeground(new java.awt.Color(0, 153, 255));
        txtPaper2.setEnabled(false);

        lblP1.setForeground(new java.awt.Color(255, 255, 255));
        lblP1.setText("Paper1:");

        lblFN.setForeground(new java.awt.Color(255, 255, 255));
        lblFN.setText("First Name:");

        lblLN.setForeground(new java.awt.Color(255, 255, 255));
        lblLN.setText("Last Name:");

        lblP2.setForeground(new java.awt.Color(255, 255, 255));
        lblP2.setText("Paper2:");

        txtAssignment.setBackground(new java.awt.Color(240, 240, 240));
        txtAssignment.setForeground(new java.awt.Color(0, 153, 255));
        txtAssignment.setEnabled(false);

        txtTest2.setBackground(new java.awt.Color(240, 240, 240));
        txtTest2.setForeground(new java.awt.Color(0, 153, 255));
        txtTest2.setEnabled(false);
        txtTest2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTest2ActionPerformed(evt);
            }
        });

        lblAM.setForeground(new java.awt.Color(255, 255, 255));
        lblAM.setText("Assignment Mark:");

        txtDelete.setForeground(new java.awt.Color(0, 153, 255));

        tblStudent.setBackground(new java.awt.Color(0, 153, 255));
        tblStudent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        tblStudent.setForeground(new java.awt.Color(255, 255, 255));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, coursemarksList1, tblStudent);
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
        jTableBinding.bind();
        tblStudent.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblStudentPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudent);

        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Type the ID# of the student to delete");

        txtID.setBackground(new java.awt.Color(240, 240, 240));
        txtID.setForeground(new java.awt.Color(0, 153, 255));
        txtID.setEnabled(false);

        txtFirst.setBackground(new java.awt.Color(240, 240, 240));
        txtFirst.setForeground(new java.awt.Color(0, 153, 255));
        txtFirst.setEnabled(false);

        txtTest1.setBackground(new java.awt.Color(240, 240, 240));
        txtTest1.setForeground(new java.awt.Color(0, 153, 255));
        txtTest1.setEnabled(false);

        lblT2.setForeground(new java.awt.Color(255, 255, 255));
        lblT2.setText("Test2:");

        cmdDelete.setBackground(new java.awt.Color(0, 153, 255));
        cmdDelete.setForeground(new java.awt.Color(255, 255, 255));
        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/DeleteItem.Image.png"))); // NOI18N
        cmdDelete.setText("Delete");
        cmdDelete.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdDelete)
                                .addGap(81, 81, 81)
                                .addComponent(cmdClose))
                            .addComponent(lblTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPM)
                            .addComponent(lblT1)
                            .addComponent(lblAM)
                            .addComponent(lblFN)
                            .addComponent(lblID)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLN)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(cmdNewSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblT2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblP1)
                                .addComponent(lblP2)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPaper1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPaper2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTest2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProject, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdSearch))
                    .addContainerGap(470, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFN)
                            .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLN)
                            .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblT1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblT2))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPaper1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPaper2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblP2)))
                            .addComponent(lblP1))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdDelete)
                            .addComponent(cmdClose))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdNewSearch)
                        .addGap(82, 82, 82))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(272, Short.MAX_VALUE)
                    .addComponent(txtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(cmdSearch)
                    .addGap(142, 142, 142)))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSearchActionPerformed

       DoConnect();
       
    }//GEN-LAST:event_cmdSearchActionPerformed

    private void txtTest2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTest2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTest2ActionPerformed

    private void tblStudentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblStudentPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblStudentPropertyChange

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        try{
            con.close();
            stmt.close();
            rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(Delete.this, e.getMessage());
        }
        this.dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        
        int response = JOptionPane.showConfirmDialog(Delete.this, "Do you want to delete id# -" + id + "?", "MarkBook", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(response == JOptionPane.YES_OPTION){
            Delete();   
            invisible(); 
            start();
        }
        else if(response == JOptionPane.NO_OPTION){ 
            invisible(); 
            start();
        }
                  
        
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdNewSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewSearchActionPerformed
        invisible(); 
        start();
    }//GEN-LAST:event_cmdNewSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdNewSearch;
    private javax.swing.JButton cmdSearch;
    private java.util.List<MarkBookApp.Coursemarks> coursemarksList;
    private java.util.List<MarkBookApp.Coursemarks> coursemarksList1;
    private javax.persistence.Query coursemarksQuery;
    private javax.persistence.Query coursemarksQuery1;
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
