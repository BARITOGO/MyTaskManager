
package MytaskManager.Forms;


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
     Connection MyCon;
     PreparedStatement ps;
     ResultSet rs;
     private DefaultTableCellRenderer centerRenderer;;
     private Timer timer;
     private String userId = "yourUserId";
    
    public Completed() {
        initComponents();
        setOpaque(false);
        compid.setText(userId);
        populateTable();
        centerRenderer = new DefaultTableCellRenderer();
        tableTextCenter();
          
          
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
            PreparedStatement ps = MyCon.prepareStatement("SELECT * FROM completed WHERE userId = ?");
            ps.setString(1,compid.getText());
            ResultSet rs = ps.executeQuery();

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
            MyCon.close();
        } catch (ClassNotFoundException | SQLException ex) {
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
                        .addGap(307, 307, 307))
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
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel compid;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private MytaskManager.Components.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
