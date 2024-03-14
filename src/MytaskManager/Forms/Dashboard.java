
package MytaskManager.Forms;

import MytaskManager.Database.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends javax.swing.JPanel {
        private Timer timer;
        PreparedStatement p;
  
    public Dashboard() {
        initComponents();
        try {
            Database.getInstance().ConnectToDatabase();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        setOpaque(false);
        populateTable();
        times();
        updateDeadline();
        updateCompleted();
        updatetodo();
//        updateLabelCounts();
        userId.setVisible(false); 
         
         timer = new Timer(5000, (e) -> {
            populateTable();
//            updateLabelCounts();
        });
        timer.start();
         
    }
    public void updateDeadline(){
        try {
            String sql = "SELECT * FROM deadlinedata WHERE userId = ?";
            String sqlv1 = "SELECT COUNT(*) FROM deadlinedata WHERE userId = ?";
            p = Database.getInstance().getConnection().prepareStatement(sql);
           p = Database.getInstance().getConnection().prepareStatement(sqlv1);
          
            p.setString(1, userId.getText());
            ResultSet rsDeadline = p.executeQuery();
            rsDeadline.next();
            int deadlineCount = rsDeadline.getInt(1);
             jLabel4.setText("" + deadlineCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateCompleted(){
        try {
            String sql2 = "SELECT COUNT(*) FROM completed WHERE userId = ?";
            String sqlv2 = "SELECT COUNT(*) FROM completed WHERE userId = ?";
            p = Database.getInstance().getConnection().prepareStatement(sql2);
            p = Database.getInstance().getConnection().prepareStatement(sqlv2);
            p.setString(1, userId.getText());
            ResultSet rsCompleted = p.executeQuery();
            rsCompleted.next();
            int completedCount = rsCompleted.getInt(1);
            jLabel1.setText("" + completedCount);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public  void updatetodo(){
        try {
                        
            String sql3 = "SELECT COUNT(*) FROM todo WHERE userId = ?";
            String sqlv3 = "SELECT COUNT(*) FROM todo WHERE userId = ?";
            p = Database.getInstance().getConnection().prepareStatement(sql3);
            p = Database.getInstance().getConnection().prepareStatement(sqlv3);
            p.setString(1, userId.getText());
            ResultSet rsTodo = p.executeQuery();
            rsTodo.next();
            int todoCount = rsTodo.getInt(1);
            jLabel9.setText("" + todoCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//          public void updateLabelCounts() {
//        try {
////            Class.forName("com.mysql.cj.jdbc.Driver");
////            Connection MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");         
////            PreparedStatement psDeadline = MyCon.prepareStatement("SELECT COUNT(*) FROM deadlinedata WHERE userId = ?");
//
////            String sql = "SELECT * FROM deadlinedata WHERE userId = ?";
////            String sqlv2 = "SELECT COUNT(*) FROM deadlinedata WHERE userId = ?";
////            p = Database.getInstance().getConnection().prepareStatement(sql);
////           p = Database.getInstance().getConnection().prepareStatement(sqlv2);
////          
////            p.setString(1, userId.getText());
////            ResultSet rsDeadline = p.executeQuery();
////            rsDeadline.next();
////            int deadlineCount = rsDeadline.getInt(1);
//            
////            String sql2 = "SELECT COUNT(*) FROM completed WHERE userId = ?";
////            PreparedStatement pcompleted = Database.getInstance().getConnection().prepareStatement(sql2);
////            PreparedStatement psCompleted = p.prepareStatement("SELECT COUNT(*) FROM completed WHERE userId = ?");
////            psCompleted.setString(1, userId.getText());
////            ResultSet rsCompleted = psCompleted.executeQuery();
////            rsCompleted.next();
////            int completedCount = rsCompleted.getInt(1);
////            
////            String sql3 = "SELECT COUNT(*) FROM todo WHERE userId = ?";
////            p = Database.getInstance().getConnection().prepareStatement(sql3);
////            PreparedStatement psTodo = p.prepareStatement("SELECT COUNT(*) FROM todo WHERE userId = ?");
////            psTodo.setString(1, userId.getText());
////            ResultSet rsTodo = psTodo.executeQuery();
////            rsTodo.next();
////            int todoCount = rsTodo.getInt(1);
//            
////            jLabel9.setText("" + todoCount);
////            jLabel4.setText("" + deadlineCount);
////            jLabel1.setText("" + completedCount);
//            
//            p.close();
//        } catch (ClassNotFoundException | SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    
          
          
     public void populateTable(){
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
//            PreparedStatement ps = MyCon.prepareStatement("SELECT * FROM todo WHERE userId = ?");

            String sql = "SELECT * FROM todo WHERE userId = ?";
            PreparedStatement p = Database.getInstance().getConnection().prepareStatement(sql);
            p.setString(1,userId.getText());           
            ResultSet rs = p.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String task = rs.getString("task");
                
                model.addRow(new Object[]{task});
            }

            jTable5.setModel(model);
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    Timer t ;
    SimpleDateFormat st ;
    
    public void times(){
    
     t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {        
                Date dt = new Date();
                st = new SimpleDateFormat("HH:mm a");

                String currentTime = st.format(dt);
                t_time.setText(currentTime);
                
                
                int currentHour = Integer.parseInt(currentTime.split(":")[0]);
               
                if (currentHour >= 0 && currentHour < 12) {
                   
                    ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/morning.png"));
                    changeimage.setIcon(icon);
                    dayGreetings.removeAll();
                    dayGreetings.repaint();
                    dayGreetings.revalidate();
                    dayGreetings.setText("Good Morning");
                }
              
                else if (currentHour >= 12 && currentHour < 18) {
                  
                    ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/afternoon.png"));
                    changeimage.setIcon(icon);
                    dayGreetings.removeAll();
                    dayGreetings.repaint();
                    dayGreetings.revalidate();
                    dayGreetings.setText("Good Afternoon");
                }
              
                else {
                  
                    ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/evening.png"));
                    changeimage.setIcon(icon);
                    dayGreetings.removeAll();
                    dayGreetings.repaint();
                    dayGreetings.revalidate();
                    dayGreetings.setText("Good Evening");
                }
            }
        });
        t.start();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new MytaskManager.Components.PanelRound();
        dayGreetings = new javax.swing.JLabel();
        t_time = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        changeimage = new javax.swing.JLabel();
        panelRound3 = new MytaskManager.Components.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        panelRound4 = new MytaskManager.Components.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelRound7 = new MytaskManager.Components.PanelRound();
        calendar1 = new CalendarUI.calendar.Calendar();
        panelRound5 = new MytaskManager.Components.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        userId = new javax.swing.JLabel();

        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(90);
        panelRound1.setRoundTopRight(90);

        dayGreetings.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dayGreetings.setForeground(new java.awt.Color(142, 117, 117));
        dayGreetings.setText("Good morning ");

        t_time.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        t_time.setForeground(new java.awt.Color(142, 117, 117));
        t_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t_time.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Admin");

        changeimage.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        changeimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/morning.png"))); // NOI18N

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(t_time, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeimage))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dayGreetings, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(dayGreetings, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(t_time, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(changeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelRound3.setRoundBottomLeft(90);
        panelRound3.setRoundBottomRight(90);
        panelRound3.setRoundTopLeft(90);
        panelRound3.setRoundTopRight(90);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(142, 117, 117));
        jLabel2.setText("Mytask");

        jTable5.setBackground(new java.awt.Color(242, 242, 242));
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
        jScrollPane1.setViewportView(jTable5);

        jLabel9.setForeground(new java.awt.Color(117, 118, 116));

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelRound4.setRoundBottomLeft(90);
        panelRound4.setRoundBottomRight(90);
        panelRound4.setRoundTopLeft(90);
        panelRound4.setRoundTopRight(90);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(142, 117, 117));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Statistics");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/circle3.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/circle2.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(117, 118, 116));
        jLabel5.setText("Completed");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(117, 118, 116));
        jLabel7.setText("Deadline");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3))
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        panelRound7.setRoundBottomLeft(90);
        panelRound7.setRoundBottomRight(90);
        panelRound7.setRoundTopLeft(90);
        panelRound7.setRoundTopRight(90);

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        panelRound5.setRoundBottomLeft(90);
        panelRound5.setRoundBottomRight(90);
        panelRound5.setRoundTopLeft(90);
        panelRound5.setRoundTopRight(90);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(142, 117, 117));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Statistics");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel8)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        userId.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userId))
                    .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(userId)))
                        .addGap(6, 6, 6)
                        .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CalendarUI.calendar.Calendar calendar1;
    public javax.swing.JLabel changeimage;
    private javax.swing.JLabel dayGreetings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable5;
    private MytaskManager.Components.PanelRound panelRound1;
    private MytaskManager.Components.PanelRound panelRound3;
    private MytaskManager.Components.PanelRound panelRound4;
    private MytaskManager.Components.PanelRound panelRound5;
    private MytaskManager.Components.PanelRound panelRound7;
    private javax.swing.JLabel t_time;
    public javax.swing.JLabel userId;
    // End of variables declaration//GEN-END:variables
}
