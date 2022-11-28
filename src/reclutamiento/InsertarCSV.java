
package reclutamiento;

import clases.conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static reclutamiento.Inicio.permiso;

/**
 * @author Giuliana Carnevalle, Bautista Venier y Alan Sebastian Schimpf
 */

public class InsertarCSV extends javax.swing.JFrame {
    
    public static DefaultTableModel aux = null;
    JTable tabla, tabla1;
    public int A = 1, B = 100, count = 0;
    int mayor = 1, igual = 0, paginacion = 0, tamaño = 0, resto = 0, a = 0, D = 0, H = 299;

    public InsertarCSV() {
        initComponents();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);                                        //el usuario no puede modificar las dimensiones del jframeform
        setTitle("Insertar CSV");
        setLocationRelativeTo(null);
        
        CargarCSV eliminar = new CargarCSV();                                                 //Comunicacion con el JFrame CargarCSV
       
        try {

            Connection cn = conexion.conectar();
            
            PreparedStatement pst1 = cn.prepareStatement("select id from candidatos");
            ResultSet rs1 = pst1.executeQuery();
            
            if (rs1.next()) {
                
                if(mayor < rs1.getInt("id")){
                    
                    mayor = rs1.getInt("id");
                        
                }
                
                while(rs1.next()){
                    
                    if(mayor < rs1.getInt("id")){
                    
                        mayor = rs1.getInt("id");
                        
                    }           
                } 
                
                mayor = mayor + 1;
                
            }
            
            cn.close();
            
        } catch (SQLException e) {
            
            System.err.println("Error con la busqueda del identificador. " + e );
            JOptionPane.showMessageDialog(null, "Error al buscar el identificador!!. Contacte al administrador");
            
        }
        
        DefaultTableModel dfm = new DefaultTableModel();
        tabla = this.nuevos;
        tabla.setModel(dfm);
        
        dfm.setColumnIdentifiers(new Object[]{"Nombre","Apellido","Email","Perfil"});
        
        DefaultTableModel dfm1 = new DefaultTableModel();
        tabla1 = this.duplicados;
        tabla1.setModel(dfm1);
        
        dfm1.setColumnIdentifiers(new Object[]{"Nombre","Apellido","Email","Perfil"});
        
        while(paginacion == 0){
            
            paginacion = 1;
        
            try {
            
            Connection cn = conexion.conectar();
                    
            PreparedStatement pst = cn.prepareStatement("select * from \n" +
                                      "(select nombre, apellido, email, perfil, ROW_NUMBER()" +
                                      "over (order by id) R from candidatos)\n" +
                                      "where R between ? and ?");    
            
            pst.setInt(1, A);
            pst.setInt(2, B);
            
            ResultSet rs = pst.executeQuery();
            
            Object cabeceras [] = {"Nombre", "Apellido", "Email", "Perfil"};
            aux = new DefaultTableModel(cabeceras, 0);
            Object [] elemento = new Object[4];
            
            count = 0;
                        
            while(rs.next()){
            
                elemento[0] = rs.getString("nombre");
                elemento[1] = rs.getString("apellido");
                elemento[2] = rs.getString("email");
                elemento[3] = rs.getString("perfil"); 
                    
                aux.addRow(elemento);
                
                count = count + 1;
                
            }
            
            for (int j = 0; j < aux.getRowCount(); j++) {
                            
                for (int i = 0; i < eliminar.modeloTabla.getRowCount(); i++) {
                        
                    if (aux.getValueAt(j, 0).toString().toLowerCase().equalsIgnoreCase(eliminar.modeloTabla.getValueAt(i, 0).toString().toLowerCase())
                                    && aux.getValueAt(j, 1).toString().toLowerCase().equalsIgnoreCase(eliminar.modeloTabla.getValueAt(i, 1).toString().toLowerCase())) {
                            
                        igual = 1;
                        a = i;
                            
                    }
                }
                
                if(igual == 1){
                    
                    dfm1.addRow(new Object[]{eliminar.modeloTabla.getValueAt(a, 0).toString().toLowerCase(),
                        eliminar.modeloTabla.getValueAt(a, 1).toString().toLowerCase(),
                        eliminar.modeloTabla.getValueAt(a, 2).toString().toLowerCase(),
                        eliminar.modeloTabla.getValueAt(a, 3).toString().toLowerCase()});
                    
                }
                
                igual = 0;
                a = 0;
                
                paginacion = 0;
                
            }
                        
                A = A + 100;
                B = B + 100;
                
                cn.close();
                    
            } catch (SQLException e) {
            
                System.err.println("Error con el boton agregar candidato. " + e );
                JOptionPane.showMessageDialog(null, "Error al agregar el/la candidato/a!!. Contacte al administrador");
            
            }
            
        }
        
        for (int i = 0; i < eliminar.modeloTabla.getRowCount(); i++) {
            
            for (int j = 0; j < duplicados.getRowCount(); j++) {
                
                if (eliminar.modeloTabla.getValueAt(i, 0).toString().toLowerCase().equals(duplicados.getValueAt(j, 0).toString().toLowerCase()) &&
                       eliminar.modeloTabla.getValueAt(i, 1).toString().toLowerCase().equals(duplicados.getValueAt(j, 1).toString().toLowerCase())){
                    
                    igual = 1;
                          
                }   
            } 
            
            if(igual == 0){
                        
                dfm.addRow(new Object[]{eliminar.modeloTabla.getValueAt(i, 0).toString().toLowerCase(),
                    eliminar.modeloTabla.getValueAt(i, 1).toString().toLowerCase(),
                    eliminar.modeloTabla.getValueAt(i, 2).toString().toLowerCase(),
                    eliminar.modeloTabla.getValueAt(i, 3).toString().toLowerCase()});
                        
            }
                        
            igual = 0;
            
        }
    }
    
    @Override
    public Image getIconImage(){                    //cambiamos el icono del jframeform
    
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/iconoVEC.png"));
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

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        duplicados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        nuevos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flechaatras.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hogar.jpg"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Insertar CSV");

        duplicados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Email", "Perfil"
            }
        ));
        jScrollPane1.setViewportView(duplicados);

        nuevos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Email", "Perfil"
            }
        ));
        jScrollPane2.setViewportView(nuevos);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Nuevos");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Duplicados");

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(454, 454, 454)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        CargarCSV newFrame = new CargarCSV();
        newFrame.setVisible(true);                                     //hace visible la vantana
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (permiso.equalsIgnoreCase("superadministrador")) {
                        
            SuperAdministrador newFrame = new SuperAdministrador();
            newFrame.setVisible(true);                                     //hace visible la vantana
            this.dispose();
                    
        } else {
                        
            Principal newFrame = new Principal();
            newFrame.setVisible(true);                                     //hace visible la vantana
            this.dispose();
                        
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (nuevos.getRowCount() == 0) {
            
            JOptionPane.showMessageDialog(null, "No existen candidatos para insertar");
            
        } else {
            
            tamaño = nuevos.getRowCount() / 299;
            
            resto = nuevos.getRowCount() - (tamaño * 299);
            
            for (int j = 0; j < tamaño; j++) {
            
            try {
                
                Connection cn = conexion.conectar();
                
                for (int i = D; i < H; i++) {
                
                    PreparedStatement pst1 = cn.prepareStatement("insert into candidatos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    
                                pst1.setInt(1, mayor);
                    
                                pst1.setString(2, nuevos.getValueAt(i, 0).toString().toLowerCase());
                                pst1.setString(3, nuevos.getValueAt(i, 1).toString().toLowerCase());
                        
                                if (nuevos.getValueAt(i, 2).toString().isEmpty()) {
                            
                                    pst1.setString(5, " ");
                            
                                } else {
                            
                                    pst1.setString(5, nuevos.getValueAt(i, 2).toString());   
                            
                                }
                        
                                pst1.setString(7, nuevos.getValueAt(i, 3).toString().toLowerCase());
                    
                    
                                pst1.setString(4, " ");     
                                pst1.setString(6, " ");
                                pst1.setString(8, " ");
                                pst1.setString(9, " ");
                                pst1.setString(10, " ");
                                pst1.setString(11, " ");
                                pst1.setString(12, " ");
                                pst1.setString(13, " ");
                                pst1.setString(14, " ");
                                pst1.setString(15, " ");
                        
                                pst1.executeUpdate();                                          //se ejecutan las lineas que le enviamos a la base de datos               
                        
                                mayor = mayor + 1;
                                
                }
                
                cn.close();
                
            } catch (SQLException e) {
                
                System.err.println("Error con el boton agregar candidato. " + e );
                JOptionPane.showMessageDialog(null, "Error al agregar el/la candidato/a!!. Contacte al administrador");
                
            }
            
            D = D + 299;
            H = H + 299;
            
            }
            
            if(resto != 0){
            
                try {
                
                Connection cn = conexion.conectar();
                
                for (int i = (H - 299); i < (resto + H - 299); i++) {
                
                    PreparedStatement pst1 = cn.prepareStatement("insert into candidatos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    
                                pst1.setInt(1, mayor);
                    
                                pst1.setString(2, nuevos.getValueAt(i, 0).toString().toLowerCase());
                                pst1.setString(3, nuevos.getValueAt(i, 1).toString().toLowerCase());
                        
                                if (nuevos.getValueAt(i, 2).toString().isEmpty()) {
                            
                                    pst1.setString(5, " ");
                            
                                } else {
                            
                                    pst1.setString(5, nuevos.getValueAt(i, 2).toString());   
                            
                                }
                        
                                pst1.setString(7, nuevos.getValueAt(i, 3).toString().toLowerCase());
                    
                    
                                pst1.setString(4, " ");     
                                pst1.setString(6, " ");
                                pst1.setString(8, " ");
                                pst1.setString(9, " ");
                                pst1.setString(10, " ");
                                pst1.setString(11, " ");
                                pst1.setString(12, " ");
                                pst1.setString(13, " ");
                                pst1.setString(14, " ");
                                pst1.setString(15, " ");
                        
                                pst1.executeUpdate();                                          //se ejecutan las lineas que le enviamos a la base de datos               
                        
                                mayor = mayor + 1;
                                
                }
                
                cn.close();
                
            } catch (SQLException e) {
                
                System.err.println("Error con el boton agregar candidato. " + e );
                JOptionPane.showMessageDialog(null, "Error al agregar el/la candidato/a!!. Contacte al administrador");
                
            }

                JOptionPane.showMessageDialog(null, "Se insertaron todos los candidatos");
                duplicados = null;
                nuevos = null;
                aux = null;
            
            }else{

                JOptionPane.showMessageDialog(null, "Se insertaron todos los candidatos");
                duplicados = null;
                nuevos = null;
                aux = null;
            
            }
            
                mayor = 0;
                
                CargarCSV newFrame = new CargarCSV();
                newFrame.setVisible(true);                                     //hace visible la vantana
                this.dispose();
            
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(InsertarCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertarCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertarCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertarCSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertarCSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable duplicados;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable nuevos;
    // End of variables declaration//GEN-END:variables
}
