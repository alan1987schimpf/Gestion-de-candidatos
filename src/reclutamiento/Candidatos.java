
package reclutamiento;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Giuliana Carnevalle, Bautista Venier y Alan Sebastian Schimpf
 */

public class Candidatos extends javax.swing.JFrame {
    
    JTable tabla;
    public static String valor = ""; 
    public static int columna = 0;
    String identificador = "";

    /**
     * Creates new form Candidatos
     */
    
    public Candidatos() {
        initComponents();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);                                        //el usuario no puede modificar las dimensiones del jframeform
        setTitle("Candidatos");
        setLocationRelativeTo(null);
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "";
            String usuario = "system";
            String pass = "admin";

            Connection cn = DriverManager.getConnection(url, usuario, pass);
            
            PreparedStatement pst1 = cn.prepareStatement("select * from candidatos");
            
            ResultSet rs1 = pst1.executeQuery();
  
            DefaultTableModel dfm = new DefaultTableModel();
            tabla = this.jTable1;
            tabla.setModel(dfm);
            
            dfm.setColumnIdentifiers(new Object[]{"Nombre","Apellido","Telefono","E-mail","Linkedin","Perfil",
                "Seniority","Nivel de Ingles","Rate","Cliente","Estado","Observaciones","Fecha","Reclutadora"});
            
            if (rs1.next()) {
                
                dfm.addRow(new Object[]{rs1.getString("nombre"),rs1.getString("apellido"),rs1.getString("telefono"),
                        rs1.getString("email"),rs1.getString("linkedin"),rs1.getString("perfil"),rs1.getString("seniority"),
                        rs1.getString("niveldeingles"),rs1.getString("rate"),rs1.getString("cliente"),rs1.getString("estado"),
                        rs1.getString("observacion"),rs1.getString("fecha"),rs1.getString("reclutador"),});
                
                while(rs1.next()){
                
                    dfm.addRow(new Object[]{rs1.getString("nombre"),rs1.getString("apellido"),rs1.getString("telefono"),
                        rs1.getString("email"),rs1.getString("linkedin"),rs1.getString("perfil"),rs1.getString("seniority"),
                        rs1.getString("niveldeingles"),rs1.getString("rate"),rs1.getString("cliente"),rs1.getString("estado"),
                        rs1.getString("observacion"),rs1.getString("fecha"),rs1.getString("reclutador"),});
                          
                } 
                
            }else {
 
                JOptionPane.showMessageDialog(null, "La tabla esta vacia");
                
            }
            
        } catch (SQLException e) {
            
            System.err.println("Error al cargar la tabla. " + e );
            JOptionPane.showMessageDialog(null, "Error al mostrar la tabla!!. Contacte al administrador");
            
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(AgregarCandidato.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
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
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Candidatos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Télefono", "E-mail", "Linkedin", "Perfil", "Seniority", "Nivel de Inglés", "Rate", "Cliente", "Estado", "Observaciones", "Fecha", "Reclutadora"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Agregar Candidato");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jButton3.setText("Modificar Candidato");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar Candidato");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ej. Nombre, Apellido, Perfil, Seniority");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tabla.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jMenu1.setText("Opciones");

        jMenuItem1.setText("Vacantes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Principal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(374, 374, 374)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_buscar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel3)
                                .addContainerGap())))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        AgregarCandidato newFrame = new AgregarCandidato();
        newFrame.setVisible(true);                                     //hace visible la vantana
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "";
            String usuario = "system";
            String pass = "admin";

            Connection cn = DriverManager.getConnection(url, usuario, pass);
            
            PreparedStatement pst1 = cn.prepareStatement("select * from candidatos where nombre = ?");
            PreparedStatement pst2 = cn.prepareStatement("select * from candidatos where apellido = ?");
            PreparedStatement pst3 = cn.prepareStatement("select * from candidatos where perfil = ?");
            PreparedStatement pst4 = cn.prepareStatement("select * from candidatos where seniority = ?");
            
            pst1.setString(1, txt_buscar.getText().trim().toLowerCase());
            pst2.setString(1, txt_buscar.getText().trim().toLowerCase());
            pst3.setString(1, txt_buscar.getText().trim().toLowerCase());
            pst4.setString(1, txt_buscar.getText().trim().toLowerCase());
            
            ResultSet rs1 = pst1.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            ResultSet rs3 = pst3.executeQuery();
            ResultSet rs4 = pst4.executeQuery();
            
            DefaultTableModel dfm = new DefaultTableModel();
            tabla = this.jTable1;
            tabla.setModel(dfm);
            
            dfm.setColumnIdentifiers(new Object[]{"Nombre","Apellido","Telefono","E-mail","Linkedin","Perfil",
                "Seniority","Nivel de Ingles","Rate","Cliente","Estado","Observaciones","Fecha","Reclutadora"});
            
            if (rs1.next()) {
                
                dfm.addRow(new Object[]{rs1.getString("nombre"),rs1.getString("apellido"),rs1.getString("telefono"),
                        rs1.getString("email"),rs1.getString("linkedin"),rs1.getString("perfil"),rs1.getString("seniority"),
                        rs1.getString("niveldeingles"),rs1.getString("rate"),rs1.getString("cliente"),rs1.getString("estado"),
                        rs1.getString("observacion"),rs1.getString("fecha"),rs1.getString("reclutador"),});
                
                while(rs1.next()){
                
                    dfm.addRow(new Object[]{rs1.getString("nombre"),rs1.getString("apellido"),rs1.getString("telefono"),
                        rs1.getString("email"),rs1.getString("linkedin"),rs1.getString("perfil"),rs1.getString("seniority"),
                        rs1.getString("niveldeingles"),rs1.getString("rate"),rs1.getString("cliente"),rs1.getString("estado"),
                        rs1.getString("observacion"),rs1.getString("fecha"),rs1.getString("reclutador"),});
                          
                } 
                
            }else if(rs2.next()){
            
                dfm.addRow(new Object[]{rs2.getString("nombre"),rs2.getString("apellido"),rs2.getString("telefono"),
                        rs2.getString("email"),rs2.getString("linkedin"),rs2.getString("perfil"),rs2.getString("seniority"),
                        rs2.getString("niveldeingles"),rs2.getString("rate"),rs2.getString("cliente"),rs2.getString("estado"),
                        rs2.getString("observacion"),rs2.getString("fecha"),rs2.getString("reclutador"),});
                
                while(rs2.next()){
                
                    dfm.addRow(new Object[]{rs2.getString("nombre"),rs2.getString("apellido"),rs2.getString("telefono"),
                        rs2.getString("email"),rs2.getString("linkedin"),rs2.getString("perfil"),rs2.getString("seniority"),
                        rs2.getString("niveldeingles"),rs2.getString("rate"),rs2.getString("cliente"),rs2.getString("estado"),
                        rs2.getString("observacion"),rs2.getString("fecha"),rs2.getString("reclutador"),});
                          
                }
    
            }else if(rs3.next()){
            
                dfm.addRow(new Object[]{rs3.getString("nombre"),rs3.getString("apellido"),rs3.getString("telefono"),
                        rs3.getString("email"),rs3.getString("linkedin"),rs3.getString("perfil"),rs3.getString("seniority"),
                        rs3.getString("niveldeingles"),rs3.getString("rate"),rs3.getString("cliente"),rs3.getString("estado"),
                        rs3.getString("observacion"),rs3.getString("fecha"),rs3.getString("reclutador"),});
                
                while(rs3.next()){
                
                    dfm.addRow(new Object[]{rs3.getString("nombre"),rs3.getString("apellido"),rs3.getString("telefono"),
                        rs3.getString("email"),rs3.getString("linkedin"),rs3.getString("perfil"),rs3.getString("seniority"),
                        rs3.getString("niveldeingles"),rs3.getString("rate"),rs3.getString("cliente"),rs3.getString("estado"),
                        rs3.getString("observacion"),rs3.getString("fecha"),rs3.getString("reclutador"),});
                          
                }
                
            }else if(rs4.next()){
            
                dfm.addRow(new Object[]{rs4.getString("nombre"),rs4.getString("apellido"),rs4.getString("telefono"),
                        rs4.getString("email"),rs4.getString("linkedin"),rs4.getString("perfil"),rs4.getString("seniority"),
                        rs4.getString("niveldeingles"),rs4.getString("rate"),rs4.getString("cliente"),rs4.getString("estado"),
                        rs4.getString("observacion"),rs4.getString("fecha"),rs4.getString("reclutador"),});
                
                while(rs4.next()){
                
                    dfm.addRow(new Object[]{rs4.getString("nombre"),rs4.getString("apellido"),rs4.getString("telefono"),
                        rs4.getString("email"),rs4.getString("linkedin"),rs4.getString("perfil"),rs4.getString("seniority"),
                        rs4.getString("niveldeingles"),rs4.getString("rate"),rs4.getString("cliente"),rs4.getString("estado"),
                        rs4.getString("observacion"),rs4.getString("fecha"),rs4.getString("reclutador"),});
                          
                }
    
            }else {
 
                JOptionPane.showMessageDialog(null, "No se encontraron resultados");
                
            }
            
        } catch (SQLException e) {
            
            System.err.println("Error con el boton buscar candidato. " + e );
            JOptionPane.showMessageDialog(null, "Error al realizar la busqueda!!. Contacte al administrador");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgregarCandidato.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        Vacantes newFrame = new Vacantes();
        newFrame.setVisible(true);                                     //hace visible la vantana
        this.dispose();       
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        Principal newFrame = new Principal();
        newFrame.setVisible(true);                                     //hace visible la vantana
        this.dispose(); 
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        if (jTable1.getSelectedColumn() == 3) {
            
            ModificarCandidato newFrame = new ModificarCandidato();
            newFrame.setVisible(true);                                     //hace visible la vantana
            this.dispose();
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Debe seleccionar un email");
            
        } 
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        
        int fila = jTable1.getSelectedRow();              //toma el valor de la fila seleccionada
        int col = jTable1.getSelectedColumn();          //toma el valor de la celda seleccionada
        
        String valorCelda = (String) jTable1.getValueAt(fila,col);
        
        if (col == 3) {
            
            valor = valorCelda;
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Debe seleccionar un email");
            
        }      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        if (jTable1.getSelectedColumn() == 3) {
            
            EliminarCandidato newFrame = new EliminarCandidato();
            newFrame.setVisible(true);                                     //hace visible la vantana
            this.dispose();
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Debe seleccionar un email");
            
        } 
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        try {
                            
            txt_buscar.setText("");

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "";
            String usuario = "system";
            String pass = "admin";

            Connection cn = DriverManager.getConnection(url, usuario, pass);
            
            PreparedStatement pst1 = cn.prepareStatement("select * from candidatos");
            
            ResultSet rs1 = pst1.executeQuery();
  
            DefaultTableModel dfm = new DefaultTableModel();
            tabla = this.jTable1;
            tabla.setModel(dfm);
            
            dfm.setColumnIdentifiers(new Object[]{"Nombre","Apellido","Telefono","E-mail","Linkedin","Perfil",
                "Seniority","Nivel de Ingles","Rate","Cliente","Estado","Observaciones","Fecha","Reclutadora"});
            
            if (rs1.next()) {
                
                dfm.addRow(new Object[]{rs1.getString("nombre"),rs1.getString("apellido"),rs1.getString("telefono"),
                        rs1.getString("email"),rs1.getString("linkedin"),rs1.getString("perfil"),rs1.getString("seniority"),
                        rs1.getString("niveldeingles"),rs1.getString("rate"),rs1.getString("cliente"),rs1.getString("estado"),
                        rs1.getString("observacion"),rs1.getString("fecha"),rs1.getString("reclutador"),});
                
                while(rs1.next()){
                
                    dfm.addRow(new Object[]{rs1.getString("nombre"),rs1.getString("apellido"),rs1.getString("telefono"),
                        rs1.getString("email"),rs1.getString("linkedin"),rs1.getString("perfil"),rs1.getString("seniority"),
                        rs1.getString("niveldeingles"),rs1.getString("rate"),rs1.getString("cliente"),rs1.getString("estado"),
                        rs1.getString("observacion"),rs1.getString("fecha"),rs1.getString("reclutador"),});
                          
                } 
                
            }else {
 
                JOptionPane.showMessageDialog(null, "La tabla esta vacia");
                
            }
            
        } catch (SQLException e) {
            
            System.err.println("Error al cargar la tabla. " + e );
            JOptionPane.showMessageDialog(null, "Error al mostrar la tabla!!. Contacte al administrador");
            
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(AgregarCandidato.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Candidatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
