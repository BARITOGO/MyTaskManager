/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MytaskManager.Forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Dashboard extends javax.swing.JPanel {
  
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        setOpaque(false);
        times();
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
                
                // Get current hour in 24-hour format
                int currentHour = Integer.parseInt(currentTime.split(":")[0]);
                
                // Check if current time is past 6 PM (18:00)
                 // Check if it's morning (after 12 AM and before 12 PM)
                if (currentHour >= 0 && currentHour < 12) {
                    // Load and set the morning icon for changeimage JLabel
                    ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/morning.png"));
                    changeimage.setIcon(icon);
                    dayGreetings.removeAll();
                    dayGreetings.repaint();
                    dayGreetings.revalidate();
                    dayGreetings.setText("Good Morning");
                }
                // Check if it's afternoon (after 12 PM and before 6 PM)
                else if (currentHour >= 12 && currentHour < 18) {
                    // Load and set the afternoon icon for changeimage JLabel
                    ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/afternoon.png"));
                    changeimage.setIcon(icon);
                    dayGreetings.removeAll();
                    dayGreetings.repaint();
                    dayGreetings.revalidate();
                    dayGreetings.setText("Good Afternoon");
                }
                // Check if it's evening (after 6 PM)
                else {
                    // Load and set the evening icon for changeimage JLabel
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
        panelRound4 = new MytaskManager.Components.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        panelRound5 = new MytaskManager.Components.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        panelRound6 = new MytaskManager.Components.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        panelRound7 = new MytaskManager.Components.PanelRound();
        jCalendar1 = new com.toedter.calendar.JCalendar();

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
        changeimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Forms/afternoon-image.png"))); // NOI18N

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
                        .addGap(18, 18, 18)
                        .addComponent(changeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dayGreetings, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                        .addComponent(changeimage)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelRound3.setRoundBottomLeft(90);
        panelRound3.setRoundBottomRight(90);
        panelRound3.setRoundTopLeft(90);
        panelRound3.setRoundTopRight(90);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(142, 117, 117));
        jLabel2.setText("Mytask");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        panelRound4.setRoundBottomLeft(90);
        panelRound4.setRoundBottomRight(90);
        panelRound4.setRoundTopLeft(90);
        panelRound4.setRoundTopRight(90);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(142, 117, 117));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Statistics");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        panelRound5.setRoundBottomLeft(90);
        panelRound5.setRoundBottomRight(90);
        panelRound5.setRoundTopLeft(90);
        panelRound5.setRoundTopRight(90);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Deadline");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(87, 87, 87))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        panelRound6.setRoundBottomLeft(90);
        panelRound6.setRoundBottomRight(90);
        panelRound6.setRoundTopLeft(90);
        panelRound6.setRoundTopRight(90);

        jLabel5.setText("completed");

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(49, 49, 49)
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changeimage;
    private javax.swing.JLabel dayGreetings;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private MytaskManager.Components.PanelRound panelRound1;
    private MytaskManager.Components.PanelRound panelRound3;
    private MytaskManager.Components.PanelRound panelRound4;
    private MytaskManager.Components.PanelRound panelRound5;
    private MytaskManager.Components.PanelRound panelRound6;
    private MytaskManager.Components.PanelRound panelRound7;
    private javax.swing.JLabel t_time;
    // End of variables declaration//GEN-END:variables
}
