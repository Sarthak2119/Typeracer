
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Statement;
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
public class Typeracersm extends javax.swing.JFrame {
StyledDocument doc= new DefaultStyledDocument();
StyledDocument doc2= new DefaultStyledDocument();
DataInputStream [] scan=new DataInputStream[3];
DataOutputStream [] print=new DataOutputStream[3];
int i=0;
String str="typeracer is a very popular game, to improve typing speeds for people new to computers.";
int prev=0,score;
volatile int timeelapsed=0;
int correct=0,bestspeed=0;
volatile int flag7=0;
int accuracy,averagespeed,playerno;
String username;
Statement stmt;
/**
     * Creates new form Typeracer
     */
    public Typeracersm(String use,Statement stm,DataInputStream [] sca,DataOutputStream [] prin,int flag) {
        initComponents();
        username=use;
        playerno=flag;
        stmt=stm;
        if(flag==1)
            type.setText("Server");
        else
            type.setText("Client:" +flag);
        scan[0]=sca[0];
        scan[1]=sca[1];
        scan[2]=sca[2];
        print[0]=prin[0];
        print[1]=prin[1];
        print[2]=prin[2];
        label1.setFont(new Font("Serif", Font.BOLD, 16));
        label1.setForeground(Color.RED);
        pane1.setText("");
        pane2.setText(str);
        pane2.setForeground(Color.blue);
        pane2.setEditable(false);       
        speedtext.setEditable(false);
        speedbar.setString("");
        progressbar.setStringPainted(true);
        player1progress.setStringPainted(true);
        player1progress1.setStringPainted(true);
        player1progress2.setStringPainted(true);
        player1progress3.setStringPainted(true);
        speedbar.setStringPainted(true);
        new Thread()
        {
            public void run()
            {
                while(true)
                {
                    int val=(int)(i*100.0/(str.length()-1));
                    int val1=0,val2=0,val3=0,val4=0;
                    progressbar.setValue(val);
                    
                    if(flag!=1)
                    {
                        try {
                            print[0].writeUTF(""+val);
                            String st;
                            st=scan[0].readUTF();
                            if(st.equals("complete"))
                            {
                                System.out.println("client complete");
                                Thread.sleep(2000);
                                clientend();
                                break;
                            }
                            else
                            {
                                val1=Integer.parseInt(st);
                                val2=Integer.parseInt(scan[0].readUTF());
                                val3=Integer.parseInt(scan[0].readUTF());
                                val4=Integer.parseInt(scan[0].readUTF());
                            }
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Typeracersm.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Typeracersm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        try {
                            val1=val;
                            val2=Integer.parseInt(scan[0].readUTF());
                            val3=Integer.parseInt(scan[1].readUTF());
                            val4=Integer.parseInt(scan[2].readUTF());
                            if(val1==100&&val2==100&&val3==100&&val4==100)
                            {
                                System.out.println("complete");
                                print[0].writeUTF("complete");
                                print[1].writeUTF("complete");
                                print[2].writeUTF("complete");
                                serverend();
                                break;
                            }
                            print[0].writeUTF(""+val1);
                            print[1].writeUTF(""+val1);
                            print[2].writeUTF(""+val1);
                            print[0].writeUTF(""+val2);
                            print[1].writeUTF(""+val2);
                            print[2].writeUTF(""+val2);
                            print[0].writeUTF(""+val3);
                            print[1].writeUTF(""+val3);
                            print[2].writeUTF(""+val3);
                            print[0].writeUTF(""+val4);
                            print[1].writeUTF(""+val4);
                            print[2].writeUTF(""+val4);
                        } catch (IOException ex) {
                            Logger.getLogger(Typeracersm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    player1progress.setValue(val1);   
                    player1progress1.setValue(val2);
                    player1progress2.setValue(val3);
                    player1progress3.setValue(val4);
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
                        if(flag7==1)
                            break;
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
                    if(flag7==1)
                        break;
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
    }

    public void serverend()
    {
    try {
        int [] pl=new int[4];
        pl[0]=score;
        while(!scan[0].readUTF().equals("score"));
        pl[1]=Integer.parseInt(scan[0].readUTF());
        while(!scan[1].readUTF().equals("score"));
        pl[2]=Integer.parseInt(scan[1].readUTF());
        while(!scan[2].readUTF().equals("score"));
        pl[3]=Integer.parseInt(scan[2].readUTF());
        
        print[0].writeUTF(""+pl[0]);
        print[0].writeUTF(""+pl[1]);
        print[0].writeUTF(""+pl[2]);
        print[0].writeUTF(""+pl[3]);
        
        print[1].writeUTF(""+pl[0]);
        print[1].writeUTF(""+pl[1]);
        print[1].writeUTF(""+pl[2]);
        print[1].writeUTF(""+pl[3]);
        
        print[2].writeUTF(""+pl[0]);
        print[2].writeUTF(""+pl[1]);
        print[2].writeUTF(""+pl[2]);
        print[2].writeUTF(""+pl[3]);
        
        Resultmulti obj=new Resultmulti(playerno,username,stmt,pl,averagespeed, bestspeed, accuracy, timeelapsed,score);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        dispose();
    } catch (IOException ex) {
        Logger.getLogger(Typeracersm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void clientend()
    {
        try {
            if(flag7==0)
            {
                correct=0;
                flag7=1;
                String one,two;
                one=pane2.getText();
                two=pane1.getText();
                System.out.println("upperpane"+one.length());
                System.out.println("lowerpane"+two.length());
                int len=one.length();
                for(int i=0;i<len;i++)
                {
                    if(one.charAt(i)==two.charAt(i))
                        correct++;
                }
                double x;
                //bestspeed*=60;
                accuracy=(correct*100)/len;
                x=accuracy/100.0;
                averagespeed=(len*60)/timeelapsed;
                score=(int)(x*(1000.0-timeelapsed/2));
                System.out.println("length"+len+"\tcorrect"+correct+"\taccuracy"+accuracy+"\ttime"+timeelapsed);
                pane1.setEditable(false);
            }
            
            print[0].writeUTF("score");
            print[0].writeUTF(""+score);
            int []pl=new int [4];

            pl[0]=Integer.parseInt(scan[0].readUTF());
            pl[1]=Integer.parseInt(scan[0].readUTF());
            pl[2]=Integer.parseInt(scan[0].readUTF());
            pl[3]=Integer.parseInt(scan[0].readUTF());
            System.out.println(averagespeed+"\t"+bestspeed+"\t"+accuracy+"\t"+correct+"\t"+score+"\t"+playerno);
            Resultmulti obj=new Resultmulti(playerno,username,stmt,pl,averagespeed, bestspeed, accuracy, timeelapsed,score);
            obj.setLocationRelativeTo(null);
            obj.setVisible(true);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(Typeracersm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
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
        player1name = new javax.swing.JLabel();
        player1progress = new javax.swing.JProgressBar();
        player1speed = new javax.swing.JLabel();
        player1speed1 = new javax.swing.JLabel();
        player1progress1 = new javax.swing.JProgressBar();
        player1name1 = new javax.swing.JLabel();
        player1speed2 = new javax.swing.JLabel();
        player1progress2 = new javax.swing.JProgressBar();
        player1name2 = new javax.swing.JLabel();
        player1speed3 = new javax.swing.JLabel();
        player1progress3 = new javax.swing.JProgressBar();
        player1name3 = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        timelabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

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

        player1name.setText("PLAYER1:");

        player1speed.setText(" ");

        player1speed1.setText(" ");

        player1name1.setText("PLAYER2:");

        player1speed2.setText(" ");

        player1name2.setText("PLAYER3:");

        player1speed3.setText(" ");

        player1name3.setText("PLAYER4:");

        type.setText(" ");

        timelabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(timelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(player1name, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(player1progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(player1speed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(player1progress1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(player1name1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(player1speed1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(player1progress2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(player1name2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(player1speed2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(player1progress3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(player1name3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(player1speed3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(progresslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(speedlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(speedtext, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(speedbar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(type)
                    .addComponent(timelabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(progresslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(speedlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(speedtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(speedbar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(player1name)
                        .addGap(18, 18, 18)
                        .addComponent(player1progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(player1speed)
                        .addGap(18, 18, 18)
                        .addComponent(player1name1)
                        .addGap(18, 18, 18)
                        .addComponent(player1progress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(player1speed1)
                        .addGap(18, 18, 18)
                        .addComponent(player1name2)
                        .addGap(18, 18, 18)
                        .addComponent(player1progress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(player1speed2)
                        .addGap(18, 18, 18)
                        .addComponent(player1name3)
                        .addGap(18, 18, 18)
                        .addComponent(player1progress3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(player1speed3)))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pane1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pane1KeyReleased
        // TODO add your handling code here:
        if(i==str.length()-1)
        {
            pane1.setEditable(false);
            flag7=1;
            String one,two;
            one=pane2.getText();
            two=pane1.getText();
            System.out.println("upperpane"+one.length());
            System.out.println("lowerpane"+two.length());
            int len=one.length();
            correct=0;
            for(int i=0;i<len;i++)
            {
                if(one.charAt(i)==two.charAt(i))
                    correct++;
            }
            double x;
            //bestspeed*=60;
            accuracy=(correct*100)/len;
            x=accuracy/100.0;
            averagespeed=(len*60)/timeelapsed;
            score=(int)(x*(1000.0-timeelapsed/2));
            System.out.println("length"+len+"\tcorrect"+correct+"\taccuracy"+accuracy+"\ttime"+timeelapsed);
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
        if(flag7==1)
        {
            return;
        }
        int ch=(int)evt.getKeyChar();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JTextPane pane1;
    private javax.swing.JTextPane pane2;
    private javax.swing.JLabel player1name;
    private javax.swing.JLabel player1name1;
    private javax.swing.JLabel player1name2;
    private javax.swing.JLabel player1name3;
    private javax.swing.JProgressBar player1progress;
    private javax.swing.JProgressBar player1progress1;
    private javax.swing.JProgressBar player1progress2;
    private javax.swing.JProgressBar player1progress3;
    private javax.swing.JLabel player1speed;
    private javax.swing.JLabel player1speed1;
    private javax.swing.JLabel player1speed2;
    private javax.swing.JLabel player1speed3;
    private javax.swing.JProgressBar progressbar;
    private javax.swing.JLabel progresslabel;
    private javax.swing.JProgressBar speedbar;
    private javax.swing.JLabel speedlabel;
    private javax.swing.JTextField speedtext;
    private javax.swing.JLabel timelabel;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
