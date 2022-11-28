
package reclutamiento;

import clases.conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static reclutamiento.Inicio.permiso;

/**
 * @author Giuliana Carnevalle, Bautista Venier y Alan Sebastian Schimpf
 */

public class PDFvacantes extends javax.swing.JFrame {
    
    public int cant = 0;

    /**
     * Creates new form PDFvacantes
     */
    
    public PDFvacantes() {
        initComponents();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);                                        //el usuario no puede modificar las dimensiones del jframeform
        setTitle("Vacantes PDF");
        setLocationRelativeTo(null);
        
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        check_identificador = new javax.swing.JCheckBox();
        check_cliente = new javax.swing.JCheckBox();
        check_vacante = new javax.swing.JCheckBox();
        check_fechacomienzo = new javax.swing.JCheckBox();
        check_cantidad = new javax.swing.JCheckBox();
        check_estado = new javax.swing.JCheckBox();
        check_fechacierre = new javax.swing.JCheckBox();

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

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Vacantes PDF ");

        check_identificador.setText("Indentificador");

        check_cliente.setText("Cliente");

        check_vacante.setText("Vacante");

        check_fechacomienzo.setText("Fecha de Comienzo");

        check_cantidad.setText("Cantidad");

        check_estado.setText("Estado");
        check_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_estadoActionPerformed(evt);
            }
        });

        check_fechacierre.setText("Fecha de Cierre");
        check_fechacierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_fechacierreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check_fechacomienzo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(check_cliente)
                                .addGap(77, 77, 77)
                                .addComponent(check_estado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(check_identificador)
                                .addGap(40, 40, 40)
                                .addComponent(check_cantidad))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(check_vacante)
                                .addGap(72, 72, 72)
                                .addComponent(check_fechacierre)))))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_identificador)
                    .addComponent(check_cantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_cliente)
                    .addComponent(check_estado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_vacante)
                    .addComponent(check_fechacierre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(check_fechacomienzo)
                .addGap(59, 59, 59)
                .addComponent(jButton1)
                .addGap(4, 4, 4)
                .addComponent(jLabel2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Vacantes newFrame = new Vacantes();
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
        
        if(check_identificador.isSelected()){    cant = cant + 1;   }
        if(check_cliente.isSelected()){    cant = cant + 1;   }
        if(check_vacante.isSelected()){    cant = cant + 1;   }
        if(check_fechacomienzo.isSelected()){    cant = cant + 1;   }
        if(check_cantidad.isSelected()){    cant = cant + 1;   }
        if(check_estado.isSelected()){    cant = cant + 1;   }
        if(check_fechacierre.isSelected()){    cant = cant + 1;   }
        
        Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Vacantes.pdf"));
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Formato creado por Giuliana Carnevalle, Bautista Venier y Alan Sebastian Schimpf © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Vacantes \n\n");

            documento.open();
            documento.add(parrafo);                                   //agrego el parrafo al documento

            PdfPTable tabla = new PdfPTable(cant);
            
            if(check_identificador.isSelected()){  tabla.addCell("Identificador");    }
            if(check_cliente.isSelected()){    tabla.addCell("Cliente");  }
            if(check_vacante.isSelected()){    tabla.addCell("Vacante");  }
            if(check_fechacomienzo.isSelected()){    tabla.addCell("Fecha de Comienzo");  }
            if(check_cantidad.isSelected()){    tabla.addCell("Cantidad");  }
            if(check_estado.isSelected()){    tabla.addCell("Estado");  }
            if(check_fechacierre.isSelected()){    tabla.addCell("Fecha de Cierre");  }
            
            for (int i = 0; i < cant; i++) {
                
                tabla.addCell(" ");
                
            }

            try {

                Connection cn = conexion.conectar();
                
                PreparedStatement pst = cn.prepareStatement("select * from vacantes");
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                
                    do {                        
                        
                        if(check_identificador.isSelected()){  tabla.addCell(rs.getString(1));    }
                        if(check_cliente.isSelected()){    tabla.addCell(rs.getString(2));  }
                        if(check_vacante.isSelected()){    tabla.addCell(rs.getString(3));  }
                        if(check_fechacomienzo.isSelected()){    tabla.addCell(rs.getString(4));  }
                        if(check_cantidad.isSelected()){    tabla.addCell(rs.getString(5));  }
                        if(check_estado.isSelected()){    tabla.addCell(rs.getString(6));  }
                        if(check_fechacierre.isSelected()){    tabla.addCell(rs.getString(7));  }
                        
                    } while (rs.next());
                    
                    documento.add(tabla);
                    
                    cant = 0;
                
                }else{
                
                    JOptionPane.showMessageDialog(null, "La lista esta vacia");
                
                }
                
            } catch (DocumentException | SQLException e) {
                
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (HeadlessException e) {
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(AgregarCandidato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void check_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_estadoActionPerformed

    private void check_fechacierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_fechacierreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_fechacierreActionPerformed

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
            java.util.logging.Logger.getLogger(PDFvacantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDFvacantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDFvacantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDFvacantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PDFvacantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check_cantidad;
    private javax.swing.JCheckBox check_cliente;
    private javax.swing.JCheckBox check_estado;
    private javax.swing.JCheckBox check_fechacierre;
    private javax.swing.JCheckBox check_fechacomienzo;
    private javax.swing.JCheckBox check_identificador;
    private javax.swing.JCheckBox check_vacante;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
