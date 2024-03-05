
package MytaskManager.Forms;

//import static MytaskManager.Forms.Completed.populateTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;


public class Statistic extends javax.swing.JPanel {
        private Timer timer;
    
    public Statistic() {
        initComponents();
         setOpaque(false);
         updateLabelCounts();
         populateTable1();
          populateTable2();
          populateTable3();
         
          jPanel1.setVisible(false);
           jPanel2.setVisible(false);
            jPanel3.setVisible(false);
            
            
            timer = new Timer(5000, (e) -> {
            populateTable1();
            populateTable2();
            populateTable3();
        });
        timer.start();
           
    }
    
    
    public void populateTable1(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
            PreparedStatement ps = MyCon.prepareStatement("SELECT * FROM todo");
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String task = rs.getString("task");
                
                model.addRow(new Object[]{task});
            }

            jTable1.setModel(model);
            MyCon.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        public void populateTable2(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
            PreparedStatement ps = MyCon.prepareStatement("SELECT * FROM deadlinedata");
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String task = rs.getString("task");
                
                model.addRow(new Object[]{task});
            }

            jTable4.setModel(model);
            MyCon.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            
        
        
        public void populateTable3(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
            PreparedStatement ps = MyCon.prepareStatement("SELECT * FROM completed");
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String task = rs.getString("task");
                
                model.addRow(new Object[]{task});
            }

            jTable5.setModel(model);
            MyCon.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
     public void updateLabelCounts() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
            
            PreparedStatement pstodo = MyCon.prepareStatement("SELECT COUNT(*) FROM todo");
            ResultSet rstodo = pstodo.executeQuery();
            rstodo.next();
            int todoCount = rstodo.getInt(1);
            
            
            PreparedStatement psDeadline = MyCon.prepareStatement("SELECT COUNT(*) FROM deadlinedata");
            ResultSet rsDeadline = psDeadline.executeQuery();
            rsDeadline.next();
            int deadlineCount = rsDeadline.getInt(1);
            
           
            PreparedStatement psCompleted = MyCon.prepareStatement("SELECT COUNT(*) FROM completed");
            ResultSet rsCompleted = psCompleted.executeQuery();
            rsCompleted.next();
            int completedCount = rsCompleted.getInt(1);
            
            jLabel1.setText("" + todoCount);
            jLabel2.setText("" + deadlineCount);
            jLabel3.setText("" + completedCount);
            
            MyCon.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new MytaskManager.Components.PanelRound();
        panelRound2 = new MytaskManager.Components.PanelRound();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        statid = new javax.swing.JLabel();

        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(90);
        panelRound1.setRoundTopRight(90);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setForeground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(90);
        panelRound2.setRoundBottomRight(90);
        panelRound2.setRoundTopLeft(90);
        panelRound2.setRoundTopRight(90);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 204, 51));
        jTextField1.setText("Statistics");
        jTextField1.setBorder(null);
        panelRound2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 42, -1, 44));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/circle1.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panelRound2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 211, -1, 96));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/circle2.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        panelRound2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 206, -1, 96));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/circle3.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        panelRound2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 204, -1, 96));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(117, 118, 116));
        jLabel4.setText("To-dos");
        panelRound2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 138, -1, 31));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(117, 118, 116));
        jLabel5.setText("Deadline");
        panelRound2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 138, -1, 31));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(117, 118, 116));
        jLabel6.setText("Completed");
        panelRound2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 138, -1, 29));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(117, 118, 116));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Task"
            }
        ));
        jTable1.setSelectionForeground(new java.awt.Color(117, 118, 116));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelRound2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 343, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable4.setForeground(new java.awt.Color(117, 118, 116));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Task"
            }
        ));
        jTable4.setSelectionForeground(new java.awt.Color(117, 118, 116));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelRound2.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 343, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable5.setForeground(new java.awt.Color(117, 118, 116));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Task"
            }
        ));
        jTable5.setSelectionForeground(new java.awt.Color(117, 118, 116));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelRound2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 343, -1, -1));

        statid.setText("jLabel7");
        panelRound2.add(statid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       jPanel1.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       jPanel2.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       jPanel1.setVisible(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        jPanel2.setVisible(false);
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
       jPanel3.setVisible(false);
    }//GEN-LAST:event_jTable5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    private MytaskManager.Components.PanelRound panelRound1;
    private MytaskManager.Components.PanelRound panelRound2;
    public javax.swing.JLabel statid;
    // End of variables declaration//GEN-END:variables
}
