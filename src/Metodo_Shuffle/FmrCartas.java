package Metodo_Shuffle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FmrCartas extends JFrame{
    //Se declaran las variables que ocupará el formulario
    MazoDeCartas cartas;
    private List<Carta> listaCartas;

    //Se declara el constructor del formulario
    public FmrCartas(){
        initComponents();
        revolverCartas();
    }
    //Se declaran los métodos que ocupará el formulario por parte del usuario
    private void revolverCartas() {
        cartas =  new MazoDeCartas();
        listaCartas = cartas.getListaCartas();
        agregarImagenes();
    }

    public void agregarImagenes() {
        asignarImagen(listaCartas.get(0).toString(), imagen1);
        asignarImagen(listaCartas.get(1).toString(), imagen2);
        asignarImagen(listaCartas.get(2).toString(), imagen3);
        asignarImagen(listaCartas.get(3).toString(), imagen4);
        asignarImagen(listaCartas.get(4).toString(), imagen5);
        asignarImagen(listaCartas.get(5).toString(), imagen6);
        asignarImagen(listaCartas.get(6).toString(), imagen7);

    }//Fin de agregar imagenes

    private void asignarImagen(String nombreImagen, JLabel imagen) {
        ImageIcon picture;
        try {
            String carpeta = "cartas/";
            picture = new ImageIcon(getClass().getResource(carpeta + nombreImagen + ".png"));
            Icon imgEscalada = new ImageIcon(picture.getImage().getScaledInstance(imagen.getWidth(),
                    imagen.getHeight(), Image.SCALE_SMOOTH));
            imagen.setIcon(imgEscalada);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //Se declara un método para inicializar los componentes del formulario
    private void initComponents() {
        imagen1 = new JLabel();
        imagen2 = new JLabel();
        imagen3 = new JLabel();
        imagen4 = new JLabel();
        imagen5 = new JLabel();
        imagen6 = new JLabel();
        imagen7 = new JLabel();
        lblTitulo = new JLabel();
        btnRevolver = new JButton("Revolver cartas");
        btnRevolver.setForeground(Color.black);
        btnRevolver.setBackground(Color.white);
        btnRevolver.setFont(new Font("Dialog", 0, 30));
        btnRevolver.setPreferredSize(new Dimension(100, 60));
        btnRevolver.setHorizontalAlignment(SwingConstants.CENTER);

        //Caracteristicas de la ventana
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 1000);
        setLocationRelativeTo(null);

        //Establecer un layout de 3 renglones y una columna
        setLayout(new GridLayout(3, 1, 10, 10));

        //Caracteristicas del titulo
        lblTitulo.setFont(new Font("Dialog", 0, 48));
        lblTitulo.setText("JUEGO DE CARTAS");
        lblTitulo.setForeground(Color.white);
        lblTitulo.setPreferredSize(new Dimension(100, 60));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitulo);
        add(btnRevolver);

        //Eventos del boton
        btnRevolver.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        revolverCartas();
                    }
                }
        );

        //Panel donde se colocarán las imagenes
        panelImagenes = new JPanel();
        panelImagenes.setBackground(Color.black);
        panelImagenes.setLayout(new GridLayout(1, 5, 10, 10));
        add(panelImagenes);

        //Se establecen los tamaños de las etiquetas y se agregan al panel
        int altura = 120;
        int anchura = 80;
        imagen1.setSize(anchura, altura);
        imagen2.setSize(anchura, altura);
        imagen3.setSize(anchura, altura);
        imagen4.setSize(anchura, altura);
        imagen5.setSize(anchura, altura);
        imagen6.setSize(anchura, altura);
        imagen7.setSize(anchura, altura);
        panelImagenes.add(imagen1);
        panelImagenes.add(imagen2);
        panelImagenes.add(imagen3);
        panelImagenes.add(imagen4);
        panelImagenes.add(imagen5);
        panelImagenes.add(imagen6);
        panelImagenes.add(imagen7);
    }
    public static void main(String[] args){
        new FmrCartas().setVisible(true);
    }
    private JLabel lblTitulo;
    private JLabel imagen1;
    private JLabel imagen2;
    private JLabel imagen3;
    private JLabel imagen4;
    private JLabel imagen5;
    private JLabel imagen6;
    private JLabel imagen7;
    private JButton btnRevolver;
    JPanel panelImagenes;

}

