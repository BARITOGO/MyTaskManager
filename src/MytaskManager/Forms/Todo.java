
package MytaskManager.Forms;


import MytaskManager.Controller.userController;
//import static MytaskManager.Forms.Completed.populateTable;
import MytaskManager.LoginPage.signUp;
import MytaskManager.Main.Main;
import MytaskManager.Model.ModelUser;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.raven.datechooser.DateChooser;
import com.raven.swing.TimePicker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.Timestamp;


public class Todo extends javax.swing.JPanel {
    
    
     Connection MyCon;
     PreparedStatement ps;
     ResultSet rs;
     private DefaultTableCellRenderer centerRenderer;;
     private DateChooser mdate;
     private DateChooser mdeadline;
     private String userId = "yourUserId";
     private Timer timer;
    

    public Todo() {
     
        initComponents();
        setOpaque(false);
        todoid.setText(userId);
        populateTable();
        centerRenderer = new DefaultTableCellRenderer();
        tableTextCenter();
        todoid.setVisible(false);
        
        panelRound5.setVisible(false);
        add.setVisible(false);
        mdate = new DateChooser();
        mdeadline = new DateChooser();
        mdate.setTextField(date);
        mdeadline.setTextField(deadline);
        
        
         timer = new Timer(5000, (e) -> {
            populateTable();
        });
        timer.start();
        
    }

    public void setCurrentUserId(String userId) {
        
        todoid.setText(userId);
        populateTable(); 
    }
    
    
    
    private void tableTextCenter() {
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
 
     public void populateTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
            PreparedStatement ps = MyCon.prepareStatement("SELECT * FROM todo WHERE userId = ?");
            ps.setString(1,todoid.getText());
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String task = rs.getString("task");
                String date = rs.getString("date");
                String deadline = rs.getString("deadline");
                String time = rs.getString("time");
                model.addRow(new Object[]{task, date, deadline, time});
            }

            jTable1.setModel(model);
            checkDeadline();
            MyCon.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     

     
     private void checkDeadline() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
        PreparedStatement ps = MyCon.prepareStatement("SELECT * FROM todo WHERE userId = ?");
        ps.setString(1,todoid.getText());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String task = rs.getString("task");
            String deadlineStr = rs.getString("deadline");
            LocalDate deadline = LocalDate.parse(deadlineStr, DateTimeFormatter.ofPattern("dd-MM-yyyy")); 
            LocalDate currentDate = LocalDate.now();
            long daysUntilDeadline = java.time.temporal.ChronoUnit.DAYS.between(currentDate, deadline);
           
            
            if (daysUntilDeadline <= 3) {
                PreparedStatement checkPs = MyCon.prepareStatement("SELECT COUNT(*) AS count FROM deadlinedata WHERE task = ?");
                checkPs.setString(1, task);
                ResultSet checkRs = checkPs.executeQuery();
                
                checkRs.next();
                int count = checkRs.getInt("count");
                
                if (count == 0) {
                    PreparedStatement movePs = MyCon.prepareStatement("INSERT INTO deadlinedata (userId, task, deadline, timestamp) VALUES (?, ?, ?, ?)");
                     movePs.setString(1, todoid.getText()); 
                    movePs.setString(2, task);
                    movePs.setDate(3, Date.valueOf(deadline));
                    
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    movePs.setTimestamp(4, timestamp);
                    movePs.executeUpdate();
                }
            }
        }

        MyCon.close();
    } catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
            
     
    

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        panelRound1 = new MytaskManager.Components.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        panelRound5 = new MytaskManager.Components.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        deadline = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        task = new javax.swing.JTextField();
        ass = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        todoid = new javax.swing.JLabel();

        timePicker1.setForeground(new java.awt.Color(186, 230, 151));
        timePicker1.setDisplayText(time);

        setForeground(new java.awt.Color(255, 255, 255));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setForeground(new java.awt.Color(255, 255, 255));
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

        jTable1.setForeground(new java.awt.Color(117, 118, 116));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Task", "Date", "Deadline", "TIme"
            }
        ));
        jTable1.setSelectionForeground(new java.awt.Color(117, 118, 116));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

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

        panelRound5.setBackground(new java.awt.Color(246, 245, 245));
        panelRound5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelRound5.setForeground(new java.awt.Color(204, 204, 204));
        panelRound5.setRoundBottomLeft(90);
        panelRound5.setRoundBottomRight(90);
        panelRound5.setRoundTopLeft(90);
        panelRound5.setRoundTopRight(90);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/new add.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });

        jToggleButton2.setText("select");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("time");

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("deadline");

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Date");

        task.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskActionPerformed(evt);
            }
        });

        ass.setForeground(new java.awt.Color(102, 102, 102));
        ass.setText("Task");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/done1.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(task, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2)))
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(28, 28, 28))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(task, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/add.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        todoid.setText("jLabel8");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(add)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)))
                        .addGap(54, 54, 54))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(323, 323, 323)
                        .addComponent(todoid)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(todoid)
                        .addGap(22, 22, 22)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add))
                    .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
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

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
    
       

    }//GEN-LAST:event_jTable1ComponentShown

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
 int selectedRow = jTable1.getSelectedRow();
        String task = jTable1.getValueAt(selectedRow, 0).toString();

        if (selectedRow != -1) { 
        String date = jTable1.getValueAt(selectedRow, 1).toString();
        String deadline = jTable1.getValueAt(selectedRow, 2).toString();
        String time = jTable1.getValueAt(selectedRow, 3).toString();
        
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
              ps = MyCon.prepareStatement("insert into completed (userId, task, date, deadline, time, timestamp) values (?, ?, ?, ?, ?, ?)");
            ps.setString(1,todoid.getText());
            ps.setString(2, task);
            ps.setString(3, date);
            ps.setString(4, deadline);
            ps.setString(5, time);
            
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(6, timestamp);
            ps.execute();

            PreparedStatement deleteFromDeadlinedata = MyCon.prepareStatement("DELETE FROM deadlinedata WHERE task = ?");
            deleteFromDeadlinedata.setString(1, task);
            int rowsAffected = deleteFromDeadlinedata.executeUpdate();

            PreparedStatement deleteFromTodo = MyCon.prepareStatement("DELETE FROM todo WHERE task = ?");
            deleteFromTodo.setString(1, task);
            rowsAffected = deleteFromTodo.executeUpdate();

            if (rowsAffected > 0) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(selectedRow);
                jTable1.setModel(model);
                JOptionPane.showMessageDialog(this, "Success");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the row from the database", "Error", JOptionPane.ERROR_MESSAGE);
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

        }


        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        int selectedRow = jTable1.getSelectedRow();
        DefaultTableModel model =(DefaultTableModel)jTable1.getModel();

        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
     
     
            try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         MyCon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mytask", "root", "rootV12morjana");
         ps = MyCon.prepareStatement("INSERT INTO todo (userId, task, date, deadline, time, timestamp) VALUES (?, ?, ?, ?, ?, ?)");

         ps.setString(1, todoid.getText());
         ps.setString(2, task.getText());
         ps.setString(3, date.getText());
         ps.setString(4, deadline.getText());
         ps.setString(5, time.getText());

       
         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
         ps.setTimestamp(6, timestamp);

         ps.execute();
         populateTable();
         JOptionPane.showMessageDialog(this, "Success");

     } catch (ClassNotFoundException | SQLException ex) {
         JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
     }

        
      
    

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyTaskManager/icon/add2.png")));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyTaskManager/icon/new add.png")));
    }//GEN-LAST:event_jLabel9MouseExited

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed

    }//GEN-LAST:event_timeActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
             timePicker1.showPopup(time, 100, 100);

    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void taskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskActionPerformed

    }//GEN-LAST:event_taskActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        //done
        panelRound5.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyTaskManager/icon/button (12).png")));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyTaskManager/icon/done1.png")));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
      panelRound5.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyTaskManager/icon/plus2.png")));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
         jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyTaskManager/icon/add.png")));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyTaskManager/icon/check2.png")));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
       jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyTaskManager/icon/check.png")));
    }//GEN-LAST:event_jLabel2MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton add;
    private javax.swing.JLabel ass;
    private javax.swing.JTextField date;
    private javax.swing.JTextField deadline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton2;
    private MytaskManager.Components.PanelRound panelRound1;
    private MytaskManager.Components.PanelRound panelRound5;
    private javax.swing.JTextField task;
    private javax.swing.JTextField time;
    private com.raven.swing.TimePicker timePicker1;
    public javax.swing.JLabel todoid;
    // End of variables declaration//GEN-END:variables


 


}
