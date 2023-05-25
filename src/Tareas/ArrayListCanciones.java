package Tareas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListCanciones extends JFrame {
    DefaultListModel modelo = new DefaultListModel();
    ArrayList<String> listaCanciones = new ArrayList<>();

    // Construccion de formulario
    public ArrayListCanciones(){
        initComponents();
        listaCanciones.add("Mikrokosmos");
        listaCanciones.add("ON");
        listaCanciones.add("People");
        listaCanciones.add("The Astronaut");
        listaCanciones.add("Christmas Tree");
        listaCanciones.add("Yet To Come");
        listaCanciones.add("Pied Piper");
        listaCanciones.add("Friends");
        listaCanciones.add("Permission to Dance");
        listaCanciones.add("Dis-ease");
        llenarJlistCanciones();
    }
    public void llenarJlistCanciones(){
        modelo.removeAllElements();
        for (int i = 0; i < listaCanciones.size(); i ++){
            modelo.addElement(listaCanciones.get(i));
        }
    }
    // metodos para inicializar el formulario
    private void initComponents(){
        lblTitulo = new JLabel();

        getContentPane().setBackground(Color.pink);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,1, 20, 20));
        // caracteristicas del titulo
        lblTitulo.setFont(new Font("Dialog", 0, 50));
        lblTitulo.setText("LISTA CANCIONES");
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setPreferredSize(new Dimension(200, 60));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitulo);

        JlistCanciones = new JList<>();
        JlistCanciones.setPreferredSize(new Dimension(100, 60));
        JlistCanciones.setVisibleRowCount(15);
        JlistCanciones.setModel(modelo);

        panelParteInferior = new JPanel();
        panelParteInferior.setBackground(Color.white);
        panelParteInferior.setLayout(new GridLayout(1, 2,20,20));
        add(panelParteInferior);
        panelParteInferior.add(add(new JScrollPane(JlistCanciones)));

        //panel de botones
        panelBotones = new JPanel();
        panelBotones.setBackground(Color.pink);
        panelBotones.setLayout(new GridLayout(4, 1, 10,10));
        panelParteInferior.add(panelBotones);

        // botones que se establecen en el panel
        btnAgregar = new JButton("Agregar");
        btnBuscar = new JButton("Buscar");
        btnBorrar = new JButton("Borrar");
        btnSalir = new JButton("Salir");

        //Eventos
        btnAgregar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        btnAgregarActionPerformed(event);
                    }
                }
        );
        btnBuscar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        btnBuscarActionPerformed(event);
                    }
                }
        );
        btnBorrar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        btnBorrarActionPerformed(event);
                    }
                }
        );
        btnSalir.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        btnSalirActionPerformed(event);
                    }
                }
        );
        panelBotones.add(btnAgregar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnBorrar);
        panelBotones.add(btnSalir);
    }

    public void btnAgregarActionPerformed(ActionEvent event){
        String nombreCancion = JOptionPane.showInputDialog("Escribe un nombre: ");
        if (nombreCancion.equals("") || nombreCancion == null){
            return;
        }
        listaCanciones.add(nombreCancion);
        llenarJlistCanciones();
    }
    public void btnBuscarActionPerformed(ActionEvent event){
        String nombreCancion = JOptionPane.showInputDialog("Escribe un nombre a buscar: ");
        if (nombreCancion.equals("") || nombreCancion == null){
            return;
        }
        if(listaCanciones.contains(nombreCancion)){
            JOptionPane.showMessageDialog(this, "La cancion si se encuentra");
        } else{
            JOptionPane.showMessageDialog(this, "La cancion no se encuentra");
        }
    }

    public void btnBorrarActionPerformed(ActionEvent event){
        String nombreCancion = JOptionPane.showInputDialog("Escribe la cancion a borrar");
        if(nombreCancion.equals("") || nombreCancion == null) {
            return;
        }
        Iterator<String> iterator = listaCanciones.iterator();
        while(iterator.hasNext()){
            if(nombreCancion.equals(iterator.next())){
                iterator.remove();
                JOptionPane.showMessageDialog(this, "La cancion se ha eliminado");
            }
        }
        llenarJlistCanciones();
    }
    public void btnSalirActionPerformed(ActionEvent event){
        System.exit(0);
    }

    // metodo main para ejecutar el formulario
    public static void main(String[] args) {
        new ArrayListCanciones().setVisible(true);
    }

    //declaracion de los controles del formulario
    private JList<String> JlistCanciones;
    private JLabel lblTitulo;
    private JButton btnAgregar;
    private JButton btnBuscar;
    private JButton btnBorrar;
    private JButton btnSalir;
    JPanel panelBotones;
    JPanel panelParteInferior;
}
