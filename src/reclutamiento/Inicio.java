
package reclutamiento;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * @author Giuliana Carnevalle, Bautista Venier y Alan Sebastian Schimpf
 */

public class Inicio extends javax.swing.JFrame {
    
    public static String user = "";
    String password = "";

    /**
     * Creates new form Inicio
     */
    
    public Inicio() {
        initComponents();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);                                        //el usuario no puede modificar las dimensiones del jframeform
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);
        
    }
    
    @Override
    public Image getIconImage(){                    //cambiamos el icono del jframeform
    
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/iconoAR.png"));
        return retValue;
        
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
        jLabel3 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_contraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AR logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setText("Email:");

        jLabel3.setText("Contraseña:");

        jButton1.setText("Iniciar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txt_contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        user = txt_email.getText().trim();
        password = txt_contraseña.getText().trim();
        
        if (!user.equals("") && !password.equals("")) {
            
            
            try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "";
            String usuario = "system";
            String pass = "admin";

            Connection cn = DriverManager.getConnection(url, usuario, pass);
            PreparedStatement pst = cn.prepareStatement("select * from usuarios where email = ?");
            pst.setString(1, txt_email.getText().trim());
            
            ResultSet rs = pst.executeQuery(); 
            
                if (rs.next()) {
                    
                    String secretKey = "hrzhgua";
                    Inicio mMain = new Inicio();
                    String cadenaDesencriptada = mMain.decode(secretKey, rs.getString("contraseña"));
                    
                    if (cadenaDesencriptada.equalsIgnoreCase(txt_contraseña.getText())) {
                        
                        if (txt_email.getText().equalsIgnoreCase("adrian") && txt_contraseña.getText().equalsIgnoreCase("adrian")) {
                            
                            //SuperAdministrador newFrame = new SuperAdministrador();
                            //newFrame.setVisible(true);                                     //hace visible la vantana
                            //this.dispose();
                            
                        } else {
                            
                            //Principal newFrame = new Principal();
                            //newFrame.setVisible(true);                                     //hace visible la vantana
                            //this.dispose();
                            
                        }
                        
                    } else {
                        
                        txt_email.setBackground(Color.red);
                        txt_contraseña.setBackground(Color.red);
                        
                        JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
                        
                        txt_email.setBackground(Color.white);
                        txt_contraseña.setBackground(Color.white);
                        
                        txt_email.setText("");
                        txt_contraseña.setText("");
                        
                    }
                    
                } else {
                    
                        txt_email.setBackground(Color.red);
                        txt_contraseña.setBackground(Color.red);
                        
                        JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
                        
                        txt_email.setBackground(Color.white);
                        txt_contraseña.setBackground(Color.white);
                        
                        txt_email.setText("");
                        txt_contraseña.setText("");
                    
                }
            

            } catch (SQLException e) {
                
                System.err.println("Error con el boton iniciar sesion. " + e );
                JOptionPane.showMessageDialog(null, "Error al iniciar sesion!!. Contacte al administrador");
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
            
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        user = txt_email.getText().trim();
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "";
            String usuario = "system";
            String pass = "admin";

            Connection cn = DriverManager.getConnection(url, usuario, pass);
            PreparedStatement pst = cn.prepareStatement("select * from usuarios where email = ?");
            pst.setString(1, txt_email.getText().trim());
            
            ResultSet rs = pst.executeQuery();

            if(txt_email.getText().isEmpty() || txt_contraseña.getText().isEmpty()){
            
                JOptionPane.showMessageDialog(null, "Debe Completar todos los campos");
                
            
            }else{
                
                if(!rs.next()){
                
                    PreparedStatement pst1 = cn.prepareStatement("insert into usuarios values (?,?)");
                
                    String secretKey = "hrzhgua";
                    Inicio mMain = new Inicio();
                    String cadenaAEncriptar = txt_contraseña.getText().trim();
                    String cadenaEncriptada = mMain.encode(secretKey, cadenaAEncriptar);
            
                    pst1.setString(1, txt_email.getText().trim());
                    pst1.setString(2, cadenaEncriptada);

                    pst1.executeUpdate();                                          //se ejecutan las lineas que le enviamos a la base de datos
                
                    txt_email.setBackground(Color.green);
                    txt_contraseña.setBackground(Color.green);
                
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                
                    txt_email.setBackground(Color.white);
                    txt_contraseña.setBackground(Color.white);
                
                    txt_email.setText("");
                    txt_contraseña.setText("");
                
                }else{
                
                    txt_email.setBackground(Color.red);
                    txt_contraseña.setBackground(Color.red);
                    
                    JOptionPane.showMessageDialog(null, "El usuario ya fue registrado");
                    
                    txt_email.setBackground(Color.white);
                    txt_contraseña.setBackground(Color.white);
                    
                    txt_email.setText("");
                    txt_contraseña.setText("");
                
                }
            
            }

        } catch (SQLException e) {
            
            System.err.println("Error con el boton registrar. " + e );
            JOptionPane.showMessageDialog(null, "Error al registrar usuario!!. Contacte al administrador");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    
    public String encode(String secretKey, String cadena) {
        
        String encriptacion = "";
        
        try {
            
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = cadena.getBytes("utf-8");
            byte[] buf = cifrado.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64Bytes);
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Error al codificar el password");
            
        }
        
        return encriptacion;
        
    }
        
    public String decode(String secretKey, String cadenaEncriptada) {
        
        String desencriptacion = "";
        
        try {
            
            byte[] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            desencriptacion = new String(plainText, "UTF-8");

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al decodificar el password");
            
        }
        return desencriptacion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txt_contraseña;
    private javax.swing.JTextField txt_email;
    // End of variables declaration//GEN-END:variables
}
