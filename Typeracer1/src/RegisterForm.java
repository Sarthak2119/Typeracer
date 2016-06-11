
import java.awt.Color;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.PasswordField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarthak
 */
public class RegisterForm extends javax.swing.JFrame {

    /**
     * Creates new form RegisterForm
     */
    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";            
    static String DB_URL = "jdbc:mysql://192.168.43.241/typeracer";
    static String USER = "root";
    static String PASS = "root";
    Connection conn = null;
    Statement stmt = null; 
    public RegisterForm() {
        initComponents();
        errorlabel.setForeground(Color.red);
        errorlabel1.setForeground(Color.red);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);   
            stmt =conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        userfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passfield = new javax.swing.JPasswordField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        signbtn = new javax.swing.JButton();
        loginbtn = new javax.swing.JButton();
        errorlabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        errorlabel1 = new javax.swing.JLabel();
        repassfield = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        homebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("         Register");

        jLabel2.setText("UserName: ");

        jLabel4.setText("Password:");

        signbtn.setText("Sign Up");
        signbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signbtnActionPerformed(evt);
            }
        });

        loginbtn.setText("Login");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });

        errorlabel.setText(" ");

        jLabel5.setText("Retype Password:");

        errorlabel1.setText(" ");

        jLabel3.setText("atleast 6 characters");

        jLabel6.setText("atleast 6 characters");

        homebtn.setText("Home");
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(errorlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passfield, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(userfield)
                            .addComponent(repassfield))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(signbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(homebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(254, 254, 254))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addComponent(errorlabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorlabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(repassfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(signbtn)
                            .addComponent(loginbtn))))
                .addGap(18, 18, 18)
                .addComponent(homebtn)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signbtnActionPerformed
        try {
            errorlabel.setText("");
            errorlabel1.setText("");
            int flag=1,i;
            String username,password,repassword;
            username=userfield.getText();
            repassword=new String(repassfield.getPassword());
            password=new String(passfield.getPassword());
            if(username.length()<6)
            {
                errorlabel.setText("Username too short");
                    return;
            }
            for(i=0;i<username.length();i++)
            {
                if(username.charAt(i)==' ')
                {
                    errorlabel.setText("Username can't include spaces!!!");
                    return;
                }
            }
            if(password.length()<6)
            {
                errorlabel1.setText("Password too weak!!!");
                    return;
            }
            if(!password.equals(repassword))
            {
                errorlabel1.setText("Passwords do not match!!!");
                return;
            }
            
            String sql = "SELECT username FROM users";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                
                String usernam = rs.getString("username");
                if(usernam.equals(username))
                {
                    flag=0;
                    break;
                }
            }
            if(flag==0)
            {
                errorlabel.setText("Username already taken!!!");
            }
            else
            {
                
                sql = "INSERT INTO users (username, password) VALUES ('"+username+"', '"+password+"')";
                stmt.executeUpdate(sql);  
                userfield.setText("");
                passfield.setText("");
                repassfield.setText("");
                LoginForm obj=new LoginForm();
                obj.setLocationRelativeTo(null);
                obj.setVisible(true);
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_signbtnActionPerformed

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        // TODO add your handling code here:
        LoginForm obj=new LoginForm();
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_loginbtnActionPerformed

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        // TODO add your handling code here:
        Home obj=new Home();
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_homebtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorlabel;
    private javax.swing.JLabel errorlabel1;
    private javax.swing.JButton homebtn;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton loginbtn;
    private static javax.swing.JPasswordField passfield;
    private javax.swing.JPasswordField repassfield;
    private javax.swing.JButton signbtn;
    private static javax.swing.JTextField userfield;
    // End of variables declaration//GEN-END:variables
}