
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

public class Vacantes extends javax.swing.JFrame {
    
    JTable tabla;
    public static String clientemodificar = "";
    public static String vacantemodificar = "";
    public static String fechadecomienzomodificar = "";
    public static String cantidadmodificar = "";
    public static String estadomodificar = "";
    public static String fechacierremodificar = "";
    public static String identificadormodificar = "";

    /**
     * Creates new form Clientes
     */
    
    public Vacantes() {
        initComponents();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);                 //evita que las ventanas queden en segundo plano al cerrarlas
        setResizable(false);                                        //el usuario no puede modificar las dimensiones del jframeform
        setTitle("Vacantes");
        setLocationRelativeTo(null);                         //evita que el usuario pueda redimensionar la ventana
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "";
            String usuario = "system";
            String pass = "admin";

            Connection cn = DriverManager.getConnection(url, usuario, pass);
            
            PreparedStatement pst1 = cn.prepareStatement("select * from vacantes");

            ResultSet rs1 = pst1.executeQuery();

            
            DefaultTableModel dfm = new DefaultTableModel();
            tabla = this.jTable1;
            tabla.setModel(dfm);
            
            dfm.setColumnIdentifiers(new Object[]{"Identificador","Cliente","Vacante","Fecha de comienzo",
                "Cantidad","Estado","Fecha de cierre"});
            
            if (rs1.next()) {
                
                dfm.addRow(new Object[]{rs1.getString("identificador"),rs1.getString("cliente"),rs1.getString("vacante"),rs1.getString("fechacomienzo"),
                        rs1.getString("cantidad"),rs1.getString("estado"),rs1.getString("fechacierre")});
                
                while(rs1.next()){
                
                    dfm.addRow(new Object[]{rs1.getString("identificador"),rs1.getString("cliente"),rs1.getString("vacante"),rs1.getString("fechacomienzo"),
                        rs1.getString("cantidad"),rs1.getString("estado"),rs1.getString("fechacierre")});
                          
                } 
                
            }else {
 
                JOptionPane.showMessageDialog(null, "La tabla esta vacia");
                
            }
            
        } catch (SQLException e) {
            
            System.err.println("Error con el boton Tabla Completa. " + e );
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

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Vacantes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Identificador", "Cliente", "Vacante", "Fecha de comienzo", "Cantidad", "Estado", "Fecha de cierre"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar Vacante");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar Vacante");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu1.setText("Opciones");

        jMenuItem1.setText("Candidatos");
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
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txt_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(487, 487, 487)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_buscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        AgregarVacante newFrame = new AgregarVacante();
        newFrame.setVisible(true);                                     //hace visible la vantana
        this.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        Candidatos newFrame = new Candidatos();
        newFrame.setVisible(true);                                     //hace visible la vantana
        this.dispose();    
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        Principal newFrame = new Principal();
        newFrame.setVisible(true);                                     //hace visible la vantana
        this.dispose(); 
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "";
            String usuario = "system";
            String pass = "admin";

            Connection cn = DriverManager.getConnection(url, usuario, pass);
            
            PreparedStatement pst1 = cn.prepareStatement("select * from vacantes where cliente = ?");
            PreparedStatement pst2 = cn.prepareStatement("select * from vacantes where vacante = ?");
            
            pst1.setString(1, txt_buscar.getText().trim().toLowerCase());
            pst2.setString(1, txt_buscar.getText().trim().toLowerCase());
            
            ResultSet rs1 = pst1.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            
            DefaultTableModel dfm = new DefaultTableModel();
            tabla = this.jTable1;
            tabla.setModel(dfm);
            
            dfm.setColumnIdentifiers(new Object[]{"Identificador","Cliente","Vacante","Fecha de comienzo",
                "Cantidad","Estado","Fecha de cierre"});
            
            if(!txt_buscar.getText().isEmpty()){
            
                if (rs1.next()) {
                
                    dfm.addRow(new Object[]{rs1.getString("identificador"),rs1.getString("cliente"),rs1.getString("vacante"),rs1.getString("fechacomienzo"),
                            rs1.getString("cantidad"),rs1.getString("estado"),rs1.getString("fechacierre")});
                
                    while(rs1.next()){
                
                        dfm.addRow(new Object[]{rs1.getString("identificador"),rs1.getString("cliente"),rs1.getString("vacante"),rs1.getString("fechacomienzo"),
                            rs1.getString("cantidad"),rs1.getString("estado"),rs1.getString("fechacierre")});
                          
                    } 
                
                }else if(rs2.next()){
            
                    dfm.addRow(new Object[]{rs2.getString("identificador"),rs2.getString("cliente"),rs2.getString("vacante"),rs2.getString("fechacomienzo"),
                            rs2.getString("cantidad"),rs2.getString("estado"),rs2.getString("fechacierre")});
                
                    while(rs2.next()){
                
                        dfm.addRow(new Object[]{rs2.getString("identificador"),rs2.getString("cliente"),rs2.getString("vacante"),rs2.getString("fechacomienzo"),
                            rs2.getString("cantidad"),rs2.getString("estado"),rs2.getString("fechacierre")});
                          
                    }
    
                }else {
 
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados");
                
                }
            
            }else{
            
                JOptionPane.showMessageDialog(null, "Debe ingresar un cliente o una vacante");
                
            }
            
        } catch (SQLException e) {
            
            System.err.println("Error con el boton buscar. " + e );
            JOptionPane.showMessageDialog(null, "Error al realizar la busqueda!!. Contacte al administrador");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgregarCandidato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        ModificarVacante newFrame = new ModificarVacante();
        newFrame.setVisible(true);                                     //hace visible la vantana
        this.dispose(); 
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int fila = jTable1.getSelectedRow();              //toma el valor de la fila seleccionada
        int col = jTable1.getSelectedColumn();          //toma el valor de la celda seleccionada
        
        String valorCelda = (String) jTable1.getValueAt(fila,col);
        
        if (col == 1) {
            
            identificadormodificar = (String) jTable1.getValueAt(fila,0);
            clientemodificar = valorCelda;
            vacantemodificar = (String) jTable1.getValueAt(fila,2);
            fechadecomienzomodificar = (String) jTable1.getValueAt(fila,3);
            cantidadmodificar = (String) jTable1.getValueAt(fila,4);
            estadomodificar = (String) jTable1.getValueAt(fila,5);
            fechacierremodificar = (String) jTable1.getValueAt(fila,6);
            
            
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
            
        }
        
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Vacantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vacantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vacantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vacantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vacantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
