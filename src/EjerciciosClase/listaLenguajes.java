package EjerciciosClase;

import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;
import java.util.LinkedList;

class listaLenguajesProgramacion extends JFrame {

    DefaultListModel modelo = new DefaultListModel();
    static LinkedList<String> listaLenguajesProgramacion = new LinkedList<>();

    public listaLenguajesProgramacion(){
        System.out.println("Programa elaborado por Erika Perez Garcia");
        initComponents();
        listaLenguajesProgramacion.add("C++");
        listaLenguajesProgramacion.add("Python");
        listaLenguajesProgramacion.add("JAVA");
        listaLenguajesProgramacion.add("PHP");
        listaLenguajesProgramacion.add("Matlab");
        TlenarlistaLenguajesProgramacion();
    }

    private void TlenarlistaLenguajesProgramacion() {
        modelo.removeAllElements();
        for (int i= 0; i< listaLenguajesProgramacion.size(); i++) {
            modelo.addElement(listaLenguajesProgramacion.get(i));
        }
    }

    private void initComponents() {
        JLabel labelG = new JLabel();
        lbLTitulo = new JLabel();
// Características de la ventana
        getContentPane().setBackground(Color.YELLOW);
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo (null);
// Establecer un layout de 2 renglones y una columna
        setLayout(new GridLayout(2, 1, 20, 20));
// Características del titulo
        lbLTitulo.setFont(new Font("Arial", 0, 35));
        lbLTitulo.setText ("Lenguajes De Programacion");
        lbLTitulo.setForeground(Color.BLACK);
        lbLTitulo.setPreferredSize (new Dimension(900, 48));
        lbLTitulo.setHorizontalAlignment (SwingConstants.CENTER);
        add(lbLTitulo);

        JList JListlenguajes = new JList<>();
        JListlenguajes.setPreferredSize(new Dimension(60, 30));
        JListlenguajes.setVisibleRowCount(5); // muestra cinco filas a la vez
        JListlenguajes.setModel (modelo);

        JPanel panelParteInferior = new JPanel();
        panelParteInferior.setBackground(Color.white);
        panelParteInferior.setLayout(new GridLayout(1, 2, 20, 20));
        add(panelParteInferior);

        panelParteInferior.add(add(new JScrollPane(JListlenguajes)));

// Panel donde se colocaran los botones

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.white);
        panelBotones.setLayout(new GridLayout(4, 1, 10, 10));
        panelParteInferior.add(panelBotones);

        // Se establecen los botones y se agregan al panel
        JButton btnAgregar = new JButton ("Agregar");
        //Formato del boton
        btnAgregar.setFont(new Font("Arial Black", Font.PLAIN, 16));
        btnAgregar.setBackground(Color.YELLOW);
        btnAgregar.setFocusPainted(false);

        JButton  btnAgregarFinal = new JButton("Agregar al final");
        btnAgregarFinal.setFont(new Font("Arial Black", Font.PLAIN, 16));
        btnAgregarFinal.setBackground(Color.YELLOW);
        btnAgregarFinal.setFocusPainted(false);

        JButton btnAgregarInicio = new JButton("Agregar al inicio");
        btnAgregarInicio.setFont(new Font("Arial Black", Font.PLAIN, 16));
        btnAgregarInicio.setBackground(Color.YELLOW);
        btnAgregarInicio.setFocusPainted(false);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Arial Black", Font.PLAIN, 16));
        btnSalir.setBackground(Color.YELLOW);
        btnSalir.setFocusPainted(false);

        //Eventos
        btnAgregar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        btnAgregarActionPerformed(event);
                    }
                }
        );
        btnAgregarFinal.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        btnAgregarFinalActionPerformed(event);
                    }
                }
        );
        btnAgregarInicio.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        btnAgregarInicioActionPerformed(event);
                    }
                }
        );
        btnSalir.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        btnSalirActionPerformed(event);
                    }
                }
        );
        panelBotones.add(btnAgregar);
        panelBotones.add(btnAgregarInicio);
        panelBotones.add(btnAgregarFinal);
        panelBotones.add(btnSalir);
    }

    private void btnSalirActionPerformed(ActionEvent event) {
        System.exit(0);

    }

    private void btnAgregarInicioActionPerformed(ActionEvent event) {
        String lenguaje = JOptionPane.showInputDialog("Escribe un lenguaje: ");
        if (lenguaje.equals("")|| lenguaje == null){
        }
        listaLenguajesProgramacion.addFirst(lenguaje);
        TlenarlistaLenguajesProgramacion();
    }
    private void btnAgregarFinalActionPerformed(ActionEvent event) {
        String lenguaje = JOptionPane.showInputDialog("Escribe un lenguaje: ");
        if (lenguaje.equals("")|| lenguaje == null){
        }
        listaLenguajesProgramacion.addLast(lenguaje);
        TlenarlistaLenguajesProgramacion();
    }

    private void btnAgregarActionPerformed(ActionEvent event) {
        String lenguaje = JOptionPane.showInputDialog("Escribe un lenguaje: ");
        if (lenguaje.equals("")|| lenguaje == null){
        }
        listaLenguajesProgramacion.add(lenguaje);
        TlenarlistaLenguajesProgramacion();
    }
    public static void main(String[] args ){
        new listaLenguajesProgramacion().setVisible(true);
    }

    JLabel lbLTitulo = new JLabel();

}