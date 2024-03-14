
package MytaskManager.Forms;


import MytaskManager.Database.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;



public class Completed extends javax.swing.JPanel {
     PreparedStatement p;
     ResultSet rs;
     private DefaultTableCellRenderer centerRenderer;;
     private Timer timer;
     private String userId = "yourUserId";
    
    public Completed() {
        initComponents();
        try {
            Database.getInstance().ConnectToDatabase();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        setOpaque(false);
        compid.setText(userId);
        populateTable();
        centerRenderer = new DefaultTableCellRenderer();
        tableTextCenter();
        compid.setVisible(false);  
        jButton1.setVisible(false);  
        
        
          timer = new Timer(5000, (e) -> {
            populateTable();
        });
        timer.start();
        
    }
    
    
     public void setCurrentUserId(String userId) {
        
        compid.setText(userId);
        populateTable(); 
    }
    
    
     private void tableTextCenter() {
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    

    
     public void populateTable(){
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
//            PreparedStatement ps = MyCon.prepareStatement("SELECT * FROM completed WHERE userId = ?");
            String sql = "SELECT * FROM completed WHERE userId = ?";
            p = Database.getInstance().getConnection().prepareStatement(sql);
            p.setString(1,compid.getText());
            
            ResultSet rs = p.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String task = rs.getString("task");
                String date = rs.getString("date");
                String deadline = rs.getString("deadline");
                String time =rs.getString("time");
                model.addRow(new Object[]{task, date,  deadline, time});
            }

            jTable2.setModel(model);
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new MytaskManager.Components.PanelRound();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        compid = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setForeground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(90);
        panelRound1.setRoundTopRight(90);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 204, 51));
        jTextField1.setText("Completed!");
        jTextField1.setBorder(null);

        jTable2.setForeground(new java.awt.Color(117, 118, 116));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Todo", "Date", "Deadline", "TIme"
            }
        ));
        jTable2.setSelectionForeground(new java.awt.Color(117, 118, 116));
        jTable2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable2ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        compid.setText("jLabel1");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(compid)
                        .addGap(109, 109, 109)
                        .addComponent(jButton1)
                        .addGap(123, 123, 123))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGap(36, 36, 36))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(compid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable2ComponentShown

        
    }//GEN-LAST:event_jTable2ComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      int selectedRow = jTable2.getSelectedRow();
    if (selectedRow != -1) { 
        String task = jTable2.getValueAt(selectedRow, 0).toString();
        String date = jTable2.getValueAt(selectedRow, 1).toString();
        String deadline = jTable2.getValueAt(selectedRow, 2).toString();
        String time = jTable2.getValueAt(selectedRow, 3).toString();

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
            // Prepare the delete statement
            String sql = "SELECT * FROM completed WHERE userId = ?";
            p = Database.getInstance().getConnection().prepareStatement(sql);
            String sqlv1 = "DELETE FROM completed WHERE task = ? AND date = ? AND deadline = ? AND time = ?";
            p = Database.getInstance().getConnection().prepareStatement(sqlv1);
//            PreparedStatement deleteFromDeadlinedata = MyCon.prepareStatement("");
            p.setString(1, task);
            p.setString(2, date);
             p.setString(3, deadline);
              p.setString(4, time);

            // Execute the delete statement
            int rowsAffected = p.executeUpdate();

            // Check if the deletion was successful
            if (rowsAffected > 0) {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.removeRow(selectedRow);
                jTable2.setModel(model);
                
                JOptionPane.showMessageDialog(this, "Success");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the row from deadlinedata", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to complete", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel compid;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private MytaskManager.Components.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
