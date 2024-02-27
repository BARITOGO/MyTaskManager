
package MytaskManager.Forms;

import MytaskManager.Controller.addtaskcontroller;
import MytaskManager.Database.Database;
import MytaskManager.Model.ModelAddTask;
import com.raven.datechooser.DateChooser;
import java.sql.SQLException;
import library.database.DatabaseConnection;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class addTask extends javax.swing.JPanel {

    private DateChooser mdate;
    private DateChooser mdeadline; 
    private Todo todo;
    private addtaskcontroller addTask;
    Connection MyCon;
    PreparedStatement ps;
    ResultSet rs;
    
    public addTask() {
         initComponents();
         setOpaque(false);
         mdate = new DateChooser();
         mdeadline = new DateChooser();
         todo = new Todo();
         mdate.setTextField(date);
         mdeadline.setTextField(deadline);
         addTask = new addtaskcontroller();
//         init();
    }
//    private void init() {
//       try {
//           DatabaseConnection.getInstance().ConnectToDatabase();
//       } catch (ClassNotFoundException |SQLException e) {
//          e.printStackTrace();
//       }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        panelRound1 = new MytaskManager.Components.PanelRound();
        panelGradient1 = new MytaskManager.Components.PanelGradient();
        panelRound2 = new MytaskManager.Components.PanelRound();
        ass = new javax.swing.JLabel();
        task = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        deadline = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        ass2 = new javax.swing.JLabel();
        ass1 = new javax.swing.JLabel();
        ass3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        back = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        userID = new javax.swing.JLabel();
        uID = new javax.swing.JLabel();

        timePicker1.setForeground(new java.awt.Color(186, 230, 151));
        timePicker1.setDisplayText(time);

        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(90);
        panelRound1.setRoundTopRight(90);

        panelRound2.setRoundBottomLeft(90);
        panelRound2.setRoundBottomRight(90);
        panelRound2.setRoundTopLeft(90);
        panelRound2.setRoundTopRight(90);

        ass.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ass.setForeground(new java.awt.Color(142, 117, 117));
        ass.setText("Task:");

        task.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        task.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(142, 117, 117)));

        date.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        date.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(142, 117, 117)));

        deadline.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deadline.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(142, 117, 117)));

        time.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        time.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(142, 117, 117)));

        ass2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ass2.setForeground(new java.awt.Color(142, 117, 117));
        ass2.setText("Date:");

        ass1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ass1.setForeground(new java.awt.Color(142, 117, 117));
        ass1.setText("Deadline:");

        ass3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ass3.setForeground(new java.awt.Color(142, 117, 117));
        ass3.setText("Time:");

        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(142, 117, 117));
        jToggleButton1.setText("Add");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        back.setForeground(new java.awt.Color(142, 117, 117));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(142, 117, 117));
        jToggleButton2.setText("Select");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        userID.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        userID.setForeground(new java.awt.Color(142, 117, 117));
        userID.setText("userID");

        uID.setText("124");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(ass1))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(ass2))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(date)
                                    .addComponent(task)
                                    .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(userID)
                                    .addComponent(ass))))
                        .addGap(36, 36, 36)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                                .addComponent(ass3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton2)
                                .addGap(37, 37, 37))
                            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(time)
                            .addComponent(uID))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(userID)
                        .addGap(12, 12, 12)
                        .addComponent(ass))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(uID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ass3)
                            .addComponent(jToggleButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(task, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ass2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jToggleButton1)
                .addGap(7, 7, 7)
                .addComponent(ass1)
                .addGap(1, 1, 1)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    todo.populateTable();
    }//GEN-LAST:event_backActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
     timePicker1.showPopup(ass, 100, 100);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        SimpleDateFormat date1 = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date deadLine = date1.parse(deadline.getText());
            Date sDate = date1.parse(date.getText());
             addTask.addtasktodatabase(new ModelAddTask(uID.getText(), task.getText(), sDate, deadLine, time.getText()));
     
        } catch (ParseException ex) {
            Logger.getLogger(addTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
     
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ass;
    private javax.swing.JLabel ass1;
    private javax.swing.JLabel ass2;
    private javax.swing.JLabel ass3;
    public javax.swing.JToggleButton back;
    private javax.swing.JTextField date;
    private javax.swing.JTextField deadline;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private MytaskManager.Components.PanelGradient panelGradient1;
    private MytaskManager.Components.PanelRound panelRound1;
    private MytaskManager.Components.PanelRound panelRound2;
    private javax.swing.JTextField task;
    private javax.swing.JTextField time;
    private com.raven.swing.TimePicker timePicker1;
    private javax.swing.JLabel uID;
    private javax.swing.JLabel userID;
    // End of variables declaration//GEN-END:variables
}
