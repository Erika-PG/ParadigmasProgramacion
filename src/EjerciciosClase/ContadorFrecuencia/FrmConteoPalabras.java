package EjerciciosClase.ContadorFrecuencia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class FrmConteoPalabras extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Map<String, Integer> frecuencias = new HashMap<>();
    private AbstractButton tabla;

    // se declara el constructor del formulario
    public FrmConteoPalabras() {
        initComponents();
        crearMapa();
        llenarTabla();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        // crea una tabla
        JTable table = new JTable(model);
        model.addColumn("Palabra");
        model.addColumn("No. de Ocurrencias");

        // crea el contenedor de la tabla con barra de desplazamiento
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // caracteristicas de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);

        setTitle("Frecuencia de la palabras de un archivo de texto");
        setLocationRelativeTo(null);

        // agregar botón para seleccionar archivo
        JButton btnSeleccionarArchivo = new JButton("Seleccionar archivo");
        btnSeleccionarArchivo.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Seleccione un archivo de texto");
            int seleccion = chooser.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = chooser.getSelectedFile();
                leerArchivo(archivo);
            }
        });
        panel.add(btnSeleccionarArchivo, BorderLayout.SOUTH);
        setContentPane(panel);
    }

    private void leerArchivo(File archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                for (String palabra : palabras) {
                    palabra = palabra.replaceAll("[^a-zA-Z]+", "").toLowerCase();
                    if (!palabra.isEmpty()) {
                        if (frecuencias.containsKey(palabra)) {
                            int cuenta = frecuencias.get(palabra);
                            frecuencias.put(palabra, cuenta + 1);
                        } else {
                            frecuencias.put(palabra, 1);
                        }
                    }
                }
            }
            llenarTabla();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Archivo no encontrado: " + archivo.getName());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage());
        }
    }

    private void crearMapa() {
        // no se necesita este método para la versión con selección de archivo
    }

    private void llenarTabla(){
        // limpiar tabla
        model.setRowCount(0);

        // se pasan los datos de frecuencias a la JTable
        Object[] fila = new Object[2];
        Set<String> claves = frecuencias.keySet();
        //ordena las claves
        TreeSet<String> clavesOrdenadas = new TreeSet<>(claves);
        for(String clave : clavesOrdenadas) {
            fila[0] = clave;
            fila[1] = frecuencias.get(clave);
            model.addRow(fila);
        }
    }

    // se declara el metodo main para ejecutar el formulario
    public static void main(String[] args) {
        new FrmConteoPalabras().setVisible(true);
    }
}