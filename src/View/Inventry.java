/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.mysql.jdbc.Statement;
import com.sun.glass.events.KeyEvent;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author achala
 */
public class Inventry extends javax.swing.JFrame {

    private String dcode;

    /**
     * Creates new form Inventry
     */
 
    public Inventry() {
        initComponents();        
        
    }
    
    
    String pnoo;
    String npno;
    
        public Inventry(String pno) {
        initComponents();
        Connect();
        
        
        this.pnoo = pno;
        npno = pnoo;
        
        lblpid.setText(npno);
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
    
    
    public void sales(){
        
        DateTimeFormatter daa = DateTimeFormatter.ofPattern("yyyy/MMM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = daa.format(now);
        
        String subtot = txtcost.getText();
        String pay = txtpay.getText();
        String balance = txtbal.getText();
        
        
        int lastinterestid = 0;
        

        
        try {
            
            String query = "insert into sales(date,subtotal,pay,balance) value(?,?,?,?)";
            pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, date);
            pst.setString(2, subtot);
            pst.setString(3, pay);
            pst.setString(4, balance);
            
            pst.executeUpdate();
            
            rs = pst.getGeneratedKeys();
            
            if(rs.next()){
                lastinterestid =rs.getInt(1);
                
                
            }
            
            int rows = viewsale.getColumnCount();
            
            String quary1 = "insert into sales_product(sales_id,pro_id,sellprice,qty,total) values(?,?,?,?,?)";
            
            pst =con.prepareStatement(quary1);
            String pres_id;
            String item_id;
            String item_name;
            String price;
            String qty;
            int total;
            
            for(int i=0; i<viewsale.getRowCount(); i++){
                
                pres_id = (String)viewsale.getValueAt(i, 0);
                item_id = (String)viewsale.getValueAt(i, 1);
                qty = viewsale.getValueAt(i, 3).toString();
                
                int qty1 = Integer.parseInt(qty);
                
                price = (String)viewsale.getValueAt(i, 4);
                total = (int)viewsale.getValueAt(i, 5);
                
                pst.setInt(1, lastinterestid);
                pst.setString(2, item_id);
                pst.setInt(3, qty1);
                pst.setString(4, price);
                pst.setInt(5, total);
                
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Record inserted!");
                
                
            }
            
            
                    
                    } catch (SQLException ex) {
            Logger.getLogger(Inventry.class.getName()).log(Level.SEVERE, null, ex);
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

        txtqty = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Usernamebar = new javax.swing.JLabel();
        Usernamebar1 = new javax.swing.JLabel();
        Usernamebar2 = new javax.swing.JLabel();
        Usernamebar3 = new javax.swing.JLabel();
        lblpid = new javax.swing.JLabel();
        txtcode = new javax.swing.JFormattedTextField();
        txtname = new javax.swing.JFormattedTextField();
        txtQTY = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewsale = new javax.swing.JTable();
        Usernamebar4 = new javax.swing.JLabel();
        Usernamebar5 = new javax.swing.JLabel();
        Usernamebar6 = new javax.swing.JLabel();
        txtcost = new javax.swing.JFormattedTextField();
        txtpay = new javax.swing.JFormattedTextField();
        txtbal = new javax.swing.JFormattedTextField();
        add = new javax.swing.JButton();
        Create1 = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventry");

        txtqty.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("Sales");

        Usernamebar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Usernamebar.setText("Prescription ID");

        Usernamebar1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Usernamebar1.setText("Drug code");

        Usernamebar2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Usernamebar2.setText("Drug Name");

        Usernamebar3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Usernamebar3.setText("qut");

        lblpid.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblpid.setForeground(new java.awt.Color(255, 51, 51));
        lblpid.setText("jLabel1");

        txtcode.setPreferredSize(new java.awt.Dimension(5, 20));
        txtcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodeActionPerformed(evt);
            }
        });
        txtcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodeKeyPressed(evt);
            }
        });

        txtname.setPreferredSize(new java.awt.Dimension(5, 20));
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        viewsale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prescription ID", "Drug code", "Drug Name", "Qty", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        viewsale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewsaleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(viewsale);

        Usernamebar4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Usernamebar4.setText("Total Cost");

        Usernamebar5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Usernamebar5.setText("Pay");

        Usernamebar6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Usernamebar6.setText("Balance");

        txtcost.setPreferredSize(new java.awt.Dimension(5, 20));
        txtcost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcostActionPerformed(evt);
            }
        });

        txtpay.setPreferredSize(new java.awt.Dimension(5, 20));
        txtpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpayActionPerformed(evt);
            }
        });

        txtbal.setPreferredSize(new java.awt.Dimension(5, 20));
        txtbal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbalActionPerformed(evt);
            }
        });

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        Create1.setText("Sales Update");
        Create1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Create1ActionPerformed(evt);
            }
        });

        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtqtyLayout = new javax.swing.GroupLayout(txtqty);
        txtqty.setLayout(txtqtyLayout);
        txtqtyLayout.setHorizontalGroup(
            txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtqtyLayout.createSequentialGroup()
                .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtqtyLayout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(jLabel1))
                    .addGroup(txtqtyLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Usernamebar)
                            .addComponent(Usernamebar1)
                            .addComponent(Usernamebar2)
                            .addComponent(Usernamebar3))
                        .addGap(41, 41, 41)
                        .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtqtyLayout.createSequentialGroup()
                                .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblpid)
                                    .addComponent(txtcode, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(55, 55, 55)
                                .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(txtqtyLayout.createSequentialGroup()
                                        .addComponent(Usernamebar4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtcost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(txtqtyLayout.createSequentialGroup()
                                        .addComponent(Usernamebar5)
                                        .addGap(85, 85, 85)
                                        .addComponent(txtpay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(txtqtyLayout.createSequentialGroup()
                                        .addComponent(Usernamebar6)
                                        .addGap(42, 42, 42)
                                        .addComponent(txtbal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(txtqtyLayout.createSequentialGroup()
                                .addComponent(txtQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Create1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(closebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(txtqtyLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        txtqtyLayout.setVerticalGroup(
            txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtqtyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtqtyLayout.createSequentialGroup()
                        .addComponent(Usernamebar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Usernamebar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Usernamebar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Usernamebar3))
                    .addGroup(txtqtyLayout.createSequentialGroup()
                        .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtqtyLayout.createSequentialGroup()
                                .addComponent(lblpid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtqtyLayout.createSequentialGroup()
                                .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Usernamebar4)
                                    .addComponent(txtcost, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Usernamebar5)
                                    .addComponent(txtpay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Usernamebar6)
                                    .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtqtyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtqtyLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(txtqtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Create1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(closebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtqty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtqty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodeActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void viewsaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewsaleMouseClicked
        // TODO add your handling code here:


        
        
        // JOptionPane.showMessageDialog(this, cno);
    }//GEN-LAST:event_viewsaleMouseClicked

    private void txtcostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcostActionPerformed

    private void txtpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpayActionPerformed

    private void txtbalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbalActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:

        String dcode = txtcode.getText();
        try {
            pst = con.prepareStatement("select * from item where itemid = ?");
            pst.setString(1, dcode);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                int currentqty;
                int sellprice;
                int qty;
                
                currentqty = rs.getInt("qty");
                sellprice = rs.getInt("sellprice");
                
                qty = Integer.parseInt(txtQTY.getValue().toString());
                
                
                int tot = sellprice * qty;
                
                
                
                if(qty >= currentqty){
                    JOptionPane.showMessageDialog(this, "Avaliable Item" + currentqty);
                    JOptionPane.showMessageDialog(this, "QTY not Enough" + currentqty);
                }
                
                else{
                    DefaultTableModel DF = (DefaultTableModel)viewsale.getModel();
                    DF.addRow(new Object[]{
                        
                        lblpid.getText(),
                        txtcode.getText(),
                        txtname.getText(),
                        sellprice,
                        txtQTY.getValue().toString(),
                        tot, 
                });
                    int sum =0;
                    for(int i =0; i<viewsale.getRowCount(); i++){
                        sum = sum + Integer.parseInt(viewsale.getValueAt(i, 5).toString());
                    }
                    
                    txtcost.setText(Integer.toString(sum));
                    txtcode.setText("");
                    txtname.setText("");
                    txtQTY.setValue(0);
                    txtcode.requestFocus();

                }
                
            }
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Inventry.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
        
        

    }//GEN-LAST:event_addActionPerformed

    private void Create1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Create1ActionPerformed
        // TODO add your handling code here:
        int pay = (Integer.parseInt(txtpay.getText()));
        int totcost = (Integer.parseInt(txtcost.getText()));
        
        int bal = pay - totcost;
        
        txtbal.setText(String.valueOf(bal));
        
        
        sales();
        
        
        
    }//GEN-LAST:event_Create1ActionPerformed

    private void txtcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodeKeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){

            String dcode = txtcode.getText();

            try {
                pst = con.prepareStatement("select * from item where itemid = ?");
                pst.setString(1, dcode);
                rs = pst.executeQuery();

                if(rs.next() == false){
                    JOptionPane.showMessageDialog(this, "Drug Not Found");
                }

                else{
                    String dname = rs.getString("itemname");
                    txtname.setText(dname.trim());
                    txtqty.requestFocus();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Inventry.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_txtcodeKeyPressed

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed

        // TODO add your handling code here:
        // Login.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        this.setVisible(false);
    }//GEN-LAST:event_closebtnActionPerformed

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
            java.util.logging.Logger.getLogger(Inventry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Create1;
    private javax.swing.JLabel Usernamebar;
    private javax.swing.JLabel Usernamebar1;
    private javax.swing.JLabel Usernamebar2;
    private javax.swing.JLabel Usernamebar3;
    private javax.swing.JLabel Usernamebar4;
    private javax.swing.JLabel Usernamebar5;
    private javax.swing.JLabel Usernamebar6;
    private javax.swing.JButton add;
    private javax.swing.JButton closebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblpid;
    private javax.swing.JSpinner txtQTY;
    private javax.swing.JFormattedTextField txtbal;
    private javax.swing.JFormattedTextField txtcode;
    private javax.swing.JFormattedTextField txtcost;
    private javax.swing.JFormattedTextField txtname;
    private javax.swing.JFormattedTextField txtpay;
    private javax.swing.JPanel txtqty;
    private javax.swing.JTable viewsale;
    // End of variables declaration//GEN-END:variables
}
