
package MytaskManager.Forms;



import MytaskManager.Components.Riddle;
import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Riddletab extends javax.swing.JFrame {
     private Timer timer;
    Timer t ;
    SimpleDateFormat st ;
     private Riddle randomRiddle;
     private String currentRiddle;
    public Riddletab() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        initComponents();
     
        jTextPane2.setBorder(null);
        jTextPane2.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane2.setBorder(null);
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        
         times();
       displayRiddle();
        
    }
    
         public void displayRiddle(){
        randomRiddle = Riddle.getRiddle();
        jTextPane2.setText(randomRiddle.getQuestion());   
        jTextField1.setVisible(true);
        jLabel1.setVisible(true);
        saveCurrentRiddle();

 try {
        FileWriter writer = new FileWriter("riddle.txt");
        writer.write(randomRiddle.getQuestion());
        writer.close();
        currentRiddle = randomRiddle.getQuestion();
    } catch (IOException e) {
        e.printStackTrace();
    }

  
    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            try {
                FileWriter writer = new FileWriter("riddle.txt");
                writer.write(randomRiddle.getQuestion());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });
    }

private void saveCurrentRiddle() {
    try {
        FileWriter writer = new FileWriter("riddle.txt");
        writer.write(randomRiddle.getQuestion());
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
private void loadCurrentRiddle() {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("riddle.txt"));
        String riddle = reader.readLine();
        reader.close();
        if (riddle != null) {
            randomRiddle = Riddle.getRiddle();
            jTextPane2.setText(randomRiddle.getQuestion());
            jTextField1.setVisible(true);
            jLabel1.setVisible(true);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public void times() {
    t = new Timer(1000, (ActionEvent e) -> {
        Calendar cal = Calendar.getInstance();
        int currentHour = cal.get(Calendar.HOUR_OF_DAY);
        int currentMinute = cal.get(Calendar.MINUTE);
        int currentSecond = cal.get(Calendar.SECOND);

        
        
        if (currentHour == 0 && currentMinute == 0 && currentSecond == 0) {
            displayRiddle();
         
        }
   
        Date date = new Date();
        st = new SimpleDateFormat("HH:mm a");
        String currentTime = st.format(date);
      
        
    });
    t.start();
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new MytaskManager.Components.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        Riddlelabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Done");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        Riddlelabel.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        Riddlelabel.setForeground(new java.awt.Color(142, 117, 117));
        Riddlelabel.setText("Riddle of the Day");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jTextPane2.setBorder(null);
        jTextPane2.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        jTextPane2.setForeground(new java.awt.Color(153, 153, 153));
        jTextPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextPane2.setOpaque(false);
        jScrollPane2.setViewportView(jTextPane2);

        jTextField1.setOpaque(true);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(142, 117, 117));
        jLabel2.setText("Answer:");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(Riddlelabel))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Riddlelabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    this.hide();
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        String userAnswer = jTextField1.getText().trim().toLowerCase();
        String correctAnswer = randomRiddle.getAnswer().toLowerCase();

        if (userAnswer.isEmpty()) {

        } else if (userAnswer.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(this, "Amazing! You are a Genius", "Correct", JOptionPane.INFORMATION_MESSAGE);

            jTextField1.setVisible(false);
            jLabel1.setVisible(false);
            jTextPane2.setText("Waiting for another riddle...");
            jTextField1.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Try again!", "Wrong!", JOptionPane.ERROR_MESSAGE);
            jTextField1.setText("");
        }

        jTextField1.selectAll();
    }//GEN-LAST:event_jTextField1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Riddle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Riddle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Riddle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Riddle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Riddletab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Riddlelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane2;
    private MytaskManager.Components.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
