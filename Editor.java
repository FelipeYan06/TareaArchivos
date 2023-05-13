
package proyectoio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Felipe Yan
 */
public class Editor extends javax.swing.JFrame {

    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtArchivo = new javax.swing.JTextField();
        btnArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaEntrada = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnArchivo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnArchivo.setText("Archivo");
        btnArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArchivoMouseClicked(evt);
            }
        });

        txtAreaEntrada.setColumns(20);
        txtAreaEntrada.setRows(5);
        jScrollPane1.setViewportView(txtAreaEntrada);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnArchivo)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(251, 251, 251)
                                .addComponent(btnGuardar)))
                        .addContainerGap(49, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArchivo))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArchivoMouseClicked
        System.out.println("Inico de la carga de archivo");
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos json","json");
        fc. setFileFilter(filter);
        int seleccion = fc. showOpenDialog(this);
        if(seleccion == JFileChooser.CANCEL_OPTION){
            
        }else if(seleccion == JFileChooser.APPROVE_OPTION){
            File archivoSeleccionado = fc.getSelectedFile();
            this.txtArchivo.setText( archivoSeleccionado.getAbsolutePath());
            
            try( FileReader fr = new FileReader(archivoSeleccionado)){
                String cadena = "";
                int valor = fr.read();
                while (valor != -1){
                    cadena += (char) valor;
                    valor = fr.read();
                }
                this.txtAreaEntrada.setText(cadena);
            } catch(IOException e){
        e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnArchivoMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        System.out.println("Inico guardar archivo");
        File archivo = new File(this.txtArchivo.getText());
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(txtAreaEntrada.getText());
            escribir.close();
        } catch (FileNotFoundException ex) {
        java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE
        , null, ex);
        

        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        System.out.println("Inico eliminar archivo");
        File archivo = new File(this.txtArchivo.getText());
        if (archivo.delete()) {
            System.out.println("Archivo borrado: " + archivo.getName());
            txtArchivo.setText("");
        } else {
            System.out.println("Error al borrar el archivo");
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

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
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtArchivo;
    private javax.swing.JTextArea txtAreaEntrada;
    // End of variables declaration//GEN-END:variables
}
