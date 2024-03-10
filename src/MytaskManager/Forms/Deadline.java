
package MytaskManager.Forms;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.toedter.calendar.JDateChooser;
import com.raven.datechooser.DateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;

public class Deadline extends javax.swing.JPanel {

    Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    private DefaultTableCellRenderer centerRenderer;;
    private Timer timer;
    private String userId = "yourUserId";
    
    public Deadline() {
        initComponents();
        setOpaque(false);
        populateTable();
        centerRenderer = new DefaultTableCellRenderer();
        tableTextCenter();
        deadid.setVisible(false);  
          
          timer = new Timer(5000, (e) -> {
            populateTable();
        });
        timer.start();
          
    }
    
     public void setCurrentUserId(String userId) {
        
        deadid.setText(userId);
        populateTable(); 
    }
    
   
    
    
     private void tableTextCenter() {
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable3.getColumnCount(); i++) {
            jTable3.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
     
     
    
 public void populateTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
            PreparedStatement ps = MyCon.prepareStatement("SELECT * FROM deadlinedata WHERE userId = ?");
             ps.setString(1,deadid.getText());
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String task = rs.getString("task");
                String deadline = rs.getString("deadline");
                model.addRow(new Object[]{task,deadline});
            }

            jTable3.setModel(model);
            MyCon.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new MytaskManager.Components.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        deadid = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(90);
        panelRound1.setRoundTopRight(90);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Deadline!");

        jTable3.setForeground(new java.awt.Color(117, 118, 116));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "task", "deadline"
            }
        ));
        jTable3.setToolTipText("");
        jTable3.setSelectionForeground(new java.awt.Color(117, 118, 116));
        jScrollPane1.setViewportView(jTable3);

        deadid.setText("jLabel2");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/check.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(deadid)
                        .addGap(161, 609, Short.MAX_VALUE))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(deadid)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    int selectedRow = jTable3.getSelectedRow();
    if (selectedRow != -1) { 
        String task = jTable3.getValueAt(selectedRow, 0).toString();
        String deadline = jTable3.getValueAt(selectedRow, 1).toString();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
            
            PreparedStatement deleteFromDeadlinedata = MyCon.prepareStatement("DELETE FROM deadlinedata WHERE task = ? AND deadline = ?");
            deleteFromDeadlinedata.setString(1, task);
            deleteFromDeadlinedata.setString(2, deadline);
            int rowsAffected = deleteFromDeadlinedata.executeUpdate();

            if (rowsAffected > 0) {
                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                model.removeRow(selectedRow);
                jTable3.setModel(model);
                JOptionPane.showMessageDialog(this, "Success");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the row from deadlinedata", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (MyCon != null) {
                    MyCon.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error closing connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to complete", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyTaskManager/icon/check2.png")));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
       jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyTaskManager/icon/check.png")));
    }//GEN-LAST:event_jLabel2MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel deadid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable3;
    private MytaskManager.Components.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
