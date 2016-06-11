
import java.awt.Color;
import java.awt.Font;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarthak
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    String user="";
    Statement stmt;
    public Profile(String username,Statement stm) {
        initComponents();
        stmt=stm;
        user=username;
        label1.setFont(new Font("Serif", Font.PLAIN, 17));
        welcomelabel.setFont(new Font("Serif", Font.PLAIN, 20));
        welcomelabel.setText("WELCOME " + username+ " TO YOUR ARENA!!!!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        welcomelabel = new javax.swing.JLabel();
        stats = new javax.swing.JButton();
        practice = new javax.swing.JButton();
        multi = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setText("Racer Profile");

        stats.setText("Statistics");
        stats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsActionPerformed(evt);
            }
        });

        practice.setText("Practice Mode ");
        practice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                practiceActionPerformed(evt);
            }
        });

        multi.setText("Multiplayer Mode");
        multi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiActionPerformed(evt);
            }
        });

        logout.setText("Logout");
        logout.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                        .addComponent(logout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(welcomelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(practice)
                                .addGap(110, 110, 110)
                                .addComponent(stats)
                                .addGap(99, 99, 99)
                                .addComponent(multi)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logout))
                .addGap(34, 34, 34)
                .addComponent(welcomelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(multi)
                    .addComponent(practice)
                    .addComponent(stats))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        Popup obj=new Popup(this);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        setEnabled(false);
        
    }//GEN-LAST:event_logoutActionPerformed

    private void multiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiActionPerformed
        // TODO add your handling code here:
        Multiplayer obj =new Multiplayer(user,stmt);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_multiActionPerformed

    private void practiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_practiceActionPerformed
        // TODO add your handling code here:
        Typeracerpractice obj =new Typeracerpractice(user,stmt);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_practiceActionPerformed

    private void statsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsActionPerformed
        // TODO add your handling code here:
        Statisticss obj=new Statisticss(user, stmt);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_statsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label1;
    private javax.swing.JButton logout;
    private javax.swing.JButton multi;
    private javax.swing.JButton practice;
    private javax.swing.JButton stats;
    private javax.swing.JLabel welcomelabel;
    // End of variables declaration//GEN-END:variables
}