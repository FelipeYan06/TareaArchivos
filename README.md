# # Aplicación que permita cargar un archivo de tipo .json, mostrarlo en un textArea y editar el objeto
## Felipe Yan Santos ISC 4B

## Se crea el frame para la interfaz gráfica.

Se inserta TxtArea un textArea y botones para buscar, guardar y eliminar el archivo json.

[![Captura-de-pantalla-2023-05-12-153853.png](https://i.postimg.cc/8knGYm6x/Captura-de-pantalla-2023-05-12-153853.png)](https://postimg.cc/QV5v95Sq)

## Instrucciones para el botón archivo.

Al dar clic en el botón se abre un cuadro de dialogo para buscar el archivo dentro del equipo. Esto se hace con el
JFileChooser, luego el FileNameExtensionFilter, es para colocar el tipo de archivo que se desea buscar, es este caso 
json. La ruta se coloca en un txtEdit y el contenido del archivo se va insertando caracter por caracter dentro del
txtArea, para ello el while. El TryCatch es para cachar los errores respecto al archivo.

```
    private void btnArchivoMouseClicked(java.awt.event.MouseEvent evt) {                                        
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

    }

```

## Instrucciones para el botón archivo.

Una vez traido el contenido del archivo en el txtArea, se puede modificar ahi mismo. Para guardar los cambios y se
refleje el achivo original se pulsa este botón. A través del método PrintWriter del paquete IO, se imprime un nuevo
archivo con el texto del txtArea. El tryCatch es para atrapar los errores por si no se ha encontrado un archivo.
El logger es para dar información de esto en la consola.

```
    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {                                        
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
    }
```

## Instrucciones para el botón eliminar.

Al dar clic en este botón se elimina el archivo en la ubicación de donde estaba. Esto con el método delete() de la clase
File.

```
private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {                                         
    System.out.println("Inico eliminar archivo");
    File archivo = new File(this.txtArchivo.getText());
    if (archivo.delete()) {
        System.out.println("Archivo borrado: " + archivo.getName());
        txtArchivo.setText("");
    } else {
        System.out.println("Error al borrar el archivo");
    }
}                                        

```

## Funcionamiento de la aplicación. 

1- Al dar clic en el botón archivo:

[![dialogoo.png](https://i.postimg.cc/fT8hdjw8/dialogoo.png)](https://postimg.cc/bsSMcnSn)

[![Texto-en-txt-Area.png](https://i.postimg.cc/9QstgKmz/Texto-en-txt-Area.png)](https://postimg.cc/rDCrKhtL)

2- Archivo modificado, dar clic al botón guardar.

[![modificaci-n.png](https://i.postimg.cc/LsRhs3vN/modificaci-n.png)](https://postimg.cc/FYWhWcML)

[![guardado.png](https://i.postimg.cc/90qcbDJD/guardado.png)](https://postimg.cc/y3sqY8qK)

3- Eliminar archivo

[![delete.png](https://i.postimg.cc/g0TJKbmB/delete.png)](https://postimg.cc/cKf0sjKQ)
