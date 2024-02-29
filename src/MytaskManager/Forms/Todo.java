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
import javax.swing.table.DefaultTableCellRenderer;

public class Todo extends javax.swing.JPanel {
    
    Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    
    private DefaultTableCellRenderer centerRenderer;;
    public Todo() {
        initComponents();
          setOpaque(false);
           
          centerRenderer = new DefaultTableCellRenderer();
          tableTextCenter();
          populateTable();
    }
    
                private void tableTextCenter(){
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
            }
    public void refreshTable(){
        populateTable();
        repaint();
        revalidate();
        
        System.out.println("Table refreshed.");
    }
public void populateTable() {
    try {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        
        System.out.println("Establishing database connection...");
        Database.getInstance().ConnectToDatabase();

        
        Connection connection = Database.getInstance().getConnection();
        
        if (connection != null) {
            System.out.println("Database connection established.");

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM addtask WHERE userId = ?");
            ps.setString(1,userid.getText());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("id"));
                v.add(rs.getString("task"));
                v.add(rs.getString("date"));
                v.add(rs.getString("deadline"));
                v.add(rs.getString("time"));
                model.addRow(v);
            }
                      
            table.setModel(model);
            System.out.println("Table populated successfully.");
        } else {
            System.out.println("Database connection is null.");
        }
    } catch (SQLException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
}

public void populateTest(){
    try {
         DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        String sql = "SELECT * FROM todo";
        PreparedStatement Ps = Database.getInstance().getConnection().prepareStatement(sql);
        ResultSet Rs = Ps.executeQuery();
        
        while (Rs.next()) {
            Vector v = new Vector();
            for (int i = 0; i < 35; i++) {
                v.add(Rs.getInt("id"));
                v.add(Rs.getString("task"));
                v.add(Rs.getString("date"));
                v.add(Rs.getString("deadline"));
                v.add(Rs.getString("time"));
            }
            model.addRow(v);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new MytaskManager.Components.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        userid = new javax.swing.JLabel();

        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(90);
        panelRound1.setRoundTopRight(90);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("My Task");

        add.setBackground(new java.awt.Color(255, 234, 234));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/addtask.png"))); // NOI18N
        add.setBorder(null);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Todo", "Date", "Deadline", "TIme"
            }
        ));
        jScrollPane1.setViewportView(table);

        userid.setText("jLabel2");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(94, 857, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userid)
                .addGap(67, 67, 67))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(userid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private MytaskManager.Components.PanelRound panelRound1;
    public javax.swing.JTable table;
    public javax.swing.JLabel userid;
    // End of variables declaration//GEN-END:variables





}
