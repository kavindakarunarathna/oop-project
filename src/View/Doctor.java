/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author achala
 */
public class Doctor extends javax.swing.JFrame {

    /**
     * Creates new form Patient
     */
    public Doctor() {
        initComponents();

    }
    
    String Utype;
    int ID_1;
            
    int newID;
    
        public Doctor(int ID_1,String Utype) {
        initComponents();
        
        this.ID_1 = ID_1;
        this.Utype = Utype;
        
        
        newID = ID_1;
        //JOptionPane.showMessageDialog(this, newID);
        
        Connect();
        PID();
        dtable();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    public void Connect(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/chanelcenter", "root","");
                    
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void PID(){
        try {
            Statement s = con.createStatement();
            rs = s.executeQuery("select MAX(doctorno) from doctor");
            rs.next();
            rs.getString("MAX(doctorno)");
            
            if(rs.getString("MAX(doctorno)")== null){
                dno.setText("D001");
            }
            else{
                long id = Long.parseLong(rs.getString("MAX(doctorno)").substring(2,rs.getString("MAX(doctorno)").length()));
                id++;
                dno.setText("D"+String.format("%03d", id));
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void dtable(){
        try {
            pst = con.prepareStatement("select * from doctor where log_id = ?");
            pst.setInt(1, newID);
            
            rs = pst.executeQuery();
        
        ResultSetMetaData Rsm = rs.getMetaData();
        int c = Rsm.getColumnCount();
        
        DefaultTableModel df = (DefaultTableModel)ddetails.getModel();
        df.setRowCount(0);
        
        while(rs.next()){
            Vector v2 = new Vector();
            
            for(int i=1;i<=c;i++){
                
            
            v2.add(rs.getString("doctorno"));
            v2.add(rs.getString("name"));
            v2.add(rs.getString("special"));
            v2.add(rs.getString("qualification"));
            v2.add(rs.getString("channelfee"));
            v2.add(rs.getString("contact"));
            v2.add(rs.getString("room"));

            
            }
            df.addRow(v2);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        no = new javax.swing.JLabel();
        contactTAG = new javax.swing.JLabel();
        nameTAG = new javax.swing.JLabel();
        addressTAG = new javax.swing.JLabel();
        dname = new javax.swing.JFormattedTextField();
        spe = new javax.swing.JFormattedTextField();
        dno = new javax.swing.JLabel();
        addressTAG1 = new javax.swing.JLabel();
        addressTAG2 = new javax.swing.JLabel();
        addressTAG3 = new javax.swing.JLabel();
        qul = new javax.swing.JFormattedTextField();
        fee = new javax.swing.JFormattedTextField();
        dcontact = new javax.swing.JFormattedTextField();
        room = new javax.swing.JSpinner();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        delet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ddetails = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Doctor Registration");

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        no.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        no.setText("Doctor No");

        contactTAG.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        contactTAG.setText("Specialization");

        nameTAG.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nameTAG.setText("Doctor Name");

        addressTAG.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addressTAG.setText("Qualification");

        dname.setPreferredSize(new java.awt.Dimension(5, 20));
        dname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnameActionPerformed(evt);
            }
        });

        spe.setPreferredSize(new java.awt.Dimension(5, 20));
        spe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speActionPerformed(evt);
            }
        });

        dno.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        dno.setForeground(new java.awt.Color(255, 51, 51));
        dno.setText("jLabel1");

        addressTAG1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addressTAG1.setText("Channel fee");

        addressTAG2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addressTAG2.setText("Contact No");

        addressTAG3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addressTAG3.setText("Room No");

        qul.setPreferredSize(new java.awt.Dimension(5, 20));
        qul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qulActionPerformed(evt);
            }
        });

        fee.setPreferredSize(new java.awt.Dimension(5, 20));
        fee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeActionPerformed(evt);
            }
        });

        dcontact.setPreferredSize(new java.awt.Dimension(5, 20));
        dcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcontactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTAG)
                            .addComponent(no)
                            .addComponent(contactTAG)
                            .addComponent(addressTAG))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qul, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dname, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dno)
                            .addComponent(spe, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(addressTAG1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressTAG2)
                            .addComponent(addressTAG3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(no)
                                                    .addComponent(dno))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(nameTAG)
                                                    .addComponent(dname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(contactTAG))
                                            .addComponent(spe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(addressTAG))
                                    .addComponent(qul, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(addressTAG1))
                            .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addressTAG2))
                    .addComponent(dcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(addressTAG3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(room, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(255, 255, 255));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        delet.setBackground(new java.awt.Color(255, 255, 255));
        delet.setText("Delet");
        delet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("Doctor Registration");

        ddetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor NO", "Doctor Name", "Specialization", "Qualification", "Channel fee", "Contact No", "Room No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ddetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ddetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ddetails);
        if (ddetails.getColumnModel().getColumnCount() > 0) {
            ddetails.getColumnModel().getColumn(0).setMinWidth(2);
            ddetails.getColumnModel().getColumn(0).setPreferredWidth(5);
            ddetails.getColumnModel().getColumn(1).setPreferredWidth(20);
            ddetails.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(369, 369, 369))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delet, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dnameActionPerformed

    private void speActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_speActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        // TODO add your handling code here:
        //Login.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        String DNO = dno.getText();
        String Dname = dname.getText();
        String Spe = spe.getText();
        String Qul = qul.getText();
        String Fee = fee.getText();
        String Dcontact = dcontact.getText();
        String Room = room.getValue().toString();
        
        
        
        try {
            pst = con.prepareStatement("insert into doctor(doctorno,name,special,qualification,channelfee,contact,room,log_id)values(?,?,?,?,?,?,?,?)");
            
            pst.setString(1, DNO);
            pst.setString(2, Dname);
            pst.setString(3, Spe);
            pst.setString(4, Qul);
            pst.setString(5, Fee);
            pst.setString(6, Dcontact);
            pst.setString(7, Room);
            pst.setInt(8, newID);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Doctor Inserted Successfully!");
            
            PID();
           
            
            dname.setText("");
            spe.setText("");
            qul.setText("");
            fee.requestFocus();
            dcontact.setText("");
            room.setValue(0);
            dname.requestFocus();
             dtable();
             
             add.setEnabled(true);
            

            
          //  ptable();
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        
        
        String DNO = dno.getText();
        String Dname = dname.getText();
        String Spe = spe.getText();
        String Qul = qul.getText();
        String Fee = fee.getText();
        String Dcontact = dcontact.getText();
        String Room = room.getValue().toString();
        
        
        
        try {
            pst = con.prepareStatement("update doctor set name = ?,special = ?,qualification = ?,channelfee = ?,contact = ?,room = ? where doctorno = ?");
            

            pst.setString(1, Dname);
            pst.setString(2, Spe);
            pst.setString(3, Qul);
            pst.setString(4, Fee);
            pst.setString(5, Dcontact);
            pst.setString(6, Room);
            pst.setString(7, DNO);
            
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Doctor Updated Successfully!");
            
            PID();
           
            
            dname.setText("");
            spe.setText("");
            qul.setText("");
            fee.setText("");
            dcontact.setText("");
            room.setValue(0);
            dname.requestFocus();
             dtable();
            
             add.setEnabled(true);
            
          //  ptable();
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_updateActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_exitActionPerformed

    private void deletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletActionPerformed
        // TODO add your handling code here:
        
       String DNO = dno.getText();
       
        try {
            pst = con.prepareStatement("delete from doctor where doctorno = ?");
            

            pst.setString(1, DNO);
            
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Doctor Information deleted Successfully!");
            
            PID();
           
            
            dname.setText("");
            spe.setText("");
            qul.setText("");
            fee.setText("");
            dcontact.setText("");
            room.setValue(0);
            dname.requestFocus();
             dtable();
             add.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }//GEN-LAST:event_deletActionPerformed

    private void ddetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ddetailsMouseClicked
       // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)ddetails.getModel();
        int SelectIndex = ddetails.getSelectedRow();
        
        dno.setText(d1.getValueAt(SelectIndex, 0).toString());
        dname.setText(d1.getValueAt(SelectIndex, 1).toString());
        spe.setText(d1.getValueAt(SelectIndex, 2).toString());
        qul.setText(d1.getValueAt(SelectIndex, 3).toString());
        fee.setText(d1.getValueAt(SelectIndex, 4).toString());
        dcontact.setText(d1.getValueAt(SelectIndex, 5).toString());
        room.setValue(Integer.parseInt(d1.getValueAt(SelectIndex, 6).toString()));
        
        add.setEnabled(false);
    }//GEN-LAST:event_ddetailsMouseClicked

    private void qulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qulActionPerformed

    private void feeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feeActionPerformed

    private void dcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcontactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dcontactActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctor().setVisible(true);
           }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel addressTAG;
    private javax.swing.JLabel addressTAG1;
    private javax.swing.JLabel addressTAG2;
    private javax.swing.JLabel addressTAG3;
    private javax.swing.JLabel contactTAG;
    private javax.swing.JFormattedTextField dcontact;
    private javax.swing.JTable ddetails;
    private javax.swing.JButton delet;
    private javax.swing.JFormattedTextField dname;
    private javax.swing.JLabel dno;
    private javax.swing.JButton exit;
    private javax.swing.JFormattedTextField fee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameTAG;
    private javax.swing.JLabel no;
    private javax.swing.JFormattedTextField qul;
    private javax.swing.JSpinner room;
    private javax.swing.JFormattedTextField spe;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
