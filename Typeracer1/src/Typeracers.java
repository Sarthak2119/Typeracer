
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarthak
 */
public class Typeracers extends javax.swing.JFrame {
StyledDocument doc= new DefaultStyledDocument();
StyledDocument doc2= new DefaultStyledDocument();
int i=0;
String str="typeracer is a very popular game, to improve typing speeds for people new to\n" +
"computers. The game presents the user with a paragraph in English, which is to be\n" +
"typed as fast as possible.";
int prev=0;
volatile int timeelapsed=0;
int correct=0,bestspeed=0;

/**
     * Creates new form Typeracer
     */
    public Typeracers() {
        initComponents();
      //  System.out.println(str.length());
        label1.setFont(new Font("Serif", Font.BOLD, 16));
        label1.setForeground(Color.RED);
        pane1.setText("");
        pane2.setText(str);
        pane2.setForeground(Color.blue);
        pane2.setEditable(false);       
        speedtext.setEditable(false);
        speedbar.setString("");
        progressbar.setStringPainted(true);
        speedbar.setStringPainted(true);
        new Thread()
        {
            public void run()
            {
                while(true)
                {
                    progressbar.setValue((int)(i*100.0/(str.length()-1)));
                }
            }
        }.start();
        new Thread()
        {
            public void run()
            {
                try {
                    while(true)
                    {
                        timeelapsed++;
                        timelabel.setText(""+timeelapsed);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Typeracers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        new Thread()
        {
            public void run()
            {
                while(true)
                {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Typeracers.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int l=0;
                    l=pane1.getText().length()-prev;
                    if(l<0)
                        l=0;
                    prev=pane1.getText().length();
                    if(2*l>bestspeed)
                        bestspeed=2*l;
                    speedtext.setText(2*l+"(CPS)"); 
                    speedbar.setValue(10*l);
                }
            }
        }.start();
        //progresslabel.setFont(new Font("Serif", Font.PLAIN, 12));
///        pane1.setCursor(null);
//        Cursor cur=new Cursor
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pane1 = new javax.swing.JTextPane(doc);
        jScrollPane2 = new javax.swing.JScrollPane();
        pane2 = new javax.swing.JTextPane(doc2);
        progressbar = new javax.swing.JProgressBar();
        speedbar = new javax.swing.JProgressBar();
        speedtext = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        progresslabel = new javax.swing.JLabel();
        speedlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        timelabel = new javax.swing.JLabel();
        backbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pane1MouseDragged(evt);
            }
        });
        pane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pane1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pane1MouseClicked(evt);
            }
        });
        pane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pane1KeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pane1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(pane1);

        jScrollPane2.setViewportView(pane2);

        label1.setText("TYPERACER");

        progresslabel.setText("Current Progress:");

        speedlabel.setText("Current Speed:");

        jLabel1.setText("TIME ELAPSED:");

        timelabel.setText(" ");

        backbutton.setText("HOME");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(progresslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(speedlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(speedtext, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(speedbar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(jLabel1)
                                .addGap(81, 81, 81)
                                .addComponent(timelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 80, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(backbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progresslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(speedbar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(speedlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(speedtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(timelabel))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pane1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1KeyReleased
        // TODO add your handling code here:
        if(i==str.length()-1)
        {
            String one,two;
            one=pane2.getText();
            two=pane1.getText();
            int len=one.length();
            for(int i=0;i<len;i++)
            {
                if(one.charAt(i)==two.charAt(i))
                    correct++;
            }
            Resultguest obj=new Resultguest((len*60.0)/timeelapsed, bestspeed*60, timeelapsed, (double)(correct)/len);
            obj.setLocationRelativeTo(null);
            obj.setVisible(true);
            dispose();
            return;
        }    
        int ch=(int)evt.getKeyChar();
    //    System.out.println(""+ch);
        if(ch==8)
            return ;
        if(ch==65535)
        {  pane1.setCaretPosition(i);return;}
        if((char)ch==str.charAt(i))
        {
             //pane1.setText(pane1.getText());
    //        int x=(pane1.getText()).length();
    //        System.out.println(i+" "+x);
            SimpleAttributeSet set=new SimpleAttributeSet();
            StyleConstants.setForeground(set, Color.blue);
            doc.setCharacterAttributes(i,1, set,true);
    //        System.out.println(pane1.getText()+" right "+ (char)ch);
            i++;
        }
        else
        {   
    //        int x=doc.getLength();
    //        System.out.println(i+"WRONG "+x);
            SimpleAttributeSet set=new SimpleAttributeSet();
            StyleConstants.setForeground(set, Color.red);
            doc.setCharacterAttributes(i,1, set,true);
    //        System.out.println(str.charAt(i)+" WRONG    "+ (char)ch);
            i++;  
        }
        SimpleAttributeSet set=new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.yellow);
        doc2.setCharacterAttributes(i-1,1, set,true);
    }//GEN-LAST:event_pane1KeyReleased

    private void pane1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1KeyTyped
        // TODO add your handling code here:
        int ch=(int)evt.getKeyChar();
       // System.out.println("Hello "+ch);
        if(ch==8&&i>0)
        {   
            i--;
            SimpleAttributeSet set=new SimpleAttributeSet();
            StyleConstants.setForeground(set, Color.BLUE);
            doc2.setCharacterAttributes(i,1, set,true);
        }
    }//GEN-LAST:event_pane1KeyTyped

    private void pane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane1MouseClicked
        // TODO add your handling code here:
        pane1.setCaretPosition(i);
    }//GEN-LAST:event_pane1MouseClicked

    private void pane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane1MousePressed
        // TODO add your handling code here:
        pane1.setCaretPosition(i);
    }//GEN-LAST:event_pane1MousePressed

    private void pane1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane1MouseDragged
        // TODO add your handling code here:
        pane1.setCaretPosition(i);
    }//GEN-LAST:event_pane1MouseDragged

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        // TODO add your handling code here:
        Home obj=new Home();
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_backbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JTextPane pane1;
    private javax.swing.JTextPane pane2;
    private javax.swing.JProgressBar progressbar;
    private javax.swing.JLabel progresslabel;
    private javax.swing.JProgressBar speedbar;
    private javax.swing.JLabel speedlabel;
    private javax.swing.JTextField speedtext;
    private javax.swing.JLabel timelabel;
    // End of variables declaration//GEN-END:variables
}
