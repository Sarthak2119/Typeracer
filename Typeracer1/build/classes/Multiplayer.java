
import java.awt.datatransfer.StringSelection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarthak
 */
public class Multiplayer extends javax.swing.JFrame {

    /**
     * Creates new form Multiplayer
     */
    DataInputStream [] scan=new DataInputStream[3];
    DataOutputStream [] print=new DataOutputStream[3];
    Socket [] socket=new Socket[3];
    InputStream [] in=new InputStream[3];
    OutputStream [] out =new OutputStream[3];
    ServerSocket sock;
    int j;

    String user;
    //Socket socket;
    Connection conn = null;
    Statement stmt = null;
    volatile int flag=0;
    public Multiplayer(String use,Statement stm) {
        initComponents();
        stmt=stm;
        user=use;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //stmt =conn.createStatement();
            DefaultListModel model2=new DefaultListModel();
            connectlist.setModel(model2);
            String sql="SELECT * FROM activeservers",usernam,ip;
            ResultSet result=stmt.executeQuery(sql);
            while(result.next())
            {
                usernam=result.getString("username");
                ip=result.getString("ip");
                model2.addElement(usernam +":"+ip);
            }           
            stopserver.setEnabled(false);
        } catch (SQLException ex) {
            //System.out.println("sql access error");
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
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

        startbtn = new javax.swing.JButton();
        connectbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        startlist = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        connectlist = new javax.swing.JList();
        refresh = new javax.swing.JButton();
        backtoprofile = new javax.swing.JButton();
        stopserver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startbtn.setText("Start Server");
        startbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startbtnActionPerformed(evt);
            }
        });

        connectbtn.setText("Connect to Server");
        connectbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectbtnActionPerformed(evt);
            }
        });

        startlist.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(startlist);

        connectlist.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        connectlist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(connectlist);

        refresh.setText("Refresh List");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        backtoprofile.setText("Back");
        backtoprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtoprofileActionPerformed(evt);
            }
        });

        stopserver.setText("Stop Server");
        stopserver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopserverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(startbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(connectbtn)
                .addGap(114, 114, 114))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(stopserver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh)
                .addGap(148, 148, 148))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backtoprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backtoprofile)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startbtn)
                    .addComponent(connectbtn))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh)
                    .addComponent(stopserver))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startbtnActionPerformed
        // TODO add your handling code here:
        //String sql="INSERT INTO activeservers (username, ip)VALUES ('"+user+"', 'localhost')";
        /*try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try {
            connectbtn.setEnabled(false);
            Socket socketmain=new Socket("192.168.43.241",3000);
            DataOutputStream outmain=new DataOutputStream(socketmain.getOutputStream());
            outmain.writeUTF(user);
            socketmain.close();
            sock =new ServerSocket(5000);
            startbtn.setEnabled(false);
            stopserver.setEnabled(true);
            j=0;
            DefaultListModel model=new DefaultListModel();
            startlist.setModel(model);
            new Thread()
            {
                public void run()
                {   
                    while(true)
                    {
                        try {
                            socket[j] = sock.accept();
                            
                        } catch (IOException ex) {
                            break;
                            //Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            in[j] =socket[j].getInputStream();
                            scan[j]=new DataInputStream(in[j]);
                            out[j] =socket[j].getOutputStream();
                            print[j]=new DataOutputStream(out[j]);
                            model.addElement(socket[j].getInetAddress());
                            startlist.setModel(model);
                            j++;
                            if(j==3)
                                break;
                        } catch (IOException ex) {
                            Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            
                    }
                    if(flag==0)
                    {
                        try {
                            print[0].writeUTF("2");
                            print[1].writeUTF("3");
                            print[2].writeUTF("4");
                            String sql="DELETE FROM activeservers WHERE username = '"+user+"'";
                            stmt.executeUpdate(sql);
                            Typeracersm obj=new Typeracersm(user,stmt,scan,print,1);
                            obj.setLocationRelativeTo(null);
                            obj.setVisible(true);
                            dispose();
                        } catch (IOException ex) {
                            Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }.start();
        } catch (IOException ex) {
            Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_startbtnActionPerformed

    private void connectbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectbtnActionPerformed
        try {
            // TODO add your handling code here:
            if(connectlist.isSelectionEmpty())
                return;
            connectbtn.setEnabled(false);
            startbtn.setEnabled(false);
            String getip=(String) connectlist.getSelectedValue();
            String ip=" ";int i;
            for(i=getip.length()-1;i>=0;i--)
            {
                if(getip.charAt(i)==':')
                    break;
            }
            i--;
            while(getip.charAt(i)!='/')
            {
                ip=getip.charAt(i)+ip;
                i--;
            }
            System.out.println(ip);
            socket[0] =new Socket(ip, 5000);
            in[0]=socket[0].getInputStream();
            out[0] =socket[0].getOutputStream();
            scan[0]=new DataInputStream(in[0]);
            print[0]=new DataOutputStream(out[0]);
            new Thread(){
                public void run()
                {
                    try {
                        int res=Integer.parseInt(scan[0].readUTF());
                        {
                            Typeracersm obj=new Typeracersm(user,stmt,scan,print,res);
                            obj.setLocationRelativeTo(null);
                            obj.setVisible(true);
                            dispose();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        } catch (IOException ex) {
            Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_connectbtnActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        try {
            // TODO add your handling code here:
            DefaultListModel model2=new DefaultListModel();
            connectlist.setModel(model2);
            String sql="SELECT * FROM activeservers",usernam,ip;
            ResultSet result=stmt.executeQuery(sql);
            while(result.next())
            {
                usernam=result.getString("username");
                ip=result.getString("ip");
                model2.addElement(usernam +":"+ip);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshActionPerformed

    private void backtoprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtoprofileActionPerformed
        // TODO add your handling code here:
        String sql="DELETE FROM activeservers WHERE username = '"+user+"'";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        Profile obj =new Profile(user,stmt);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_backtoprofileActionPerformed

    private void stopserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopserverActionPerformed
        try {
            // TODO add your handling code here:
            flag=1;
            String sql="DELETE FROM activeservers WHERE username = '"+user+"'";
            stmt.executeUpdate(sql);
            sock.close();
            startbtn.setEnabled(true);
            connectbtn.setEnabled(true);
            stopserver.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Multiplayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stopserverActionPerformed
   /* public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Multiplayer("sarthak").setVisible(true);
            }
        });
    }
    */
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backtoprofile;
    private javax.swing.JButton connectbtn;
    private javax.swing.JList connectlist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refresh;
    private javax.swing.JButton startbtn;
    private javax.swing.JList startlist;
    private javax.swing.JButton stopserver;
    // End of variables declaration//GEN-END:variables
}
