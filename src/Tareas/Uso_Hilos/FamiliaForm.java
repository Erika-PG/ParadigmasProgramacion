package Tareas.Uso_Hilos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;


public class FamiliaForm extends JFrame{
    private JLabel lblEsposo, lblEsposa, lblParents, lblChildren, lblHermano, lblHermana;
    private JTextField txtEsposo, txtEsposa, txtParents, txtChildren, txtHermano, txtHermana;

    private JLabel lblPregunta;
    private JTextField txtRespuesta;
    private JButton btnEnviar;
    private String[] preguntas = {
            "Anne is Paul's __________",
            "Jason and Emily are their _________",
            "Paul is Anne's _________",
            "Jason is Anne's _________",
            "Emily is Paul's _________",
            "Jason is Emily's _________",
            "Emily is Jason's __________",
            "Paul and Anne are Jason´s__________"
    };
    private String[] respuestas = {
            "Wife",
            "Hermanos",
            "Padre y Madre",
            "Jason y Emily",
            "Hermano y Hermana"
    };


    public FamiliaForm() {
        setTitle("Formulario Familia");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 3));

        lblEsposo = new JLabel("Esposo:");
        lblEsposa = new JLabel("Esposa:");
        lblParents = new JLabel("Padres de familia:");
        lblChildren = new JLabel("Hijos:");
        lblHermano = new JLabel("Hermano:");
        lblHermana = new JLabel("Hermana:");

        txtEsposo = new JTextField();
        txtEsposa = new JTextField();
        txtParents = new JTextField();
        txtChildren = new JTextField();
        txtHermano = new JTextField();
        txtHermana = new JTextField();

        add(lblEsposo);
        add(txtEsposo);
        add(lblEsposa);
        add(txtEsposa);
        add(lblParents);
        add(txtParents);
        add(lblChildren);
        add(txtChildren);
        add(lblHermano);
        add(txtHermano);
        add(lblHermana);
        add(txtHermana);

        setVisible(true);

        FamiliaThread familiaThread = new FamiliaThread();
        familiaThread.start();
    }

    private class FamiliaThread extends Thread {
        @Override
        public void run() {
            try {
                // Espera de la obtención de datos de la familia de forma simulada
                Thread.sleep(2000);

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        txtEsposo.setText("Paul");
                        txtEsposa.setText("Anne");
                        txtParents.setText("Paul y Anne");
                        txtChildren.setText("Jason y Emily");
                        txtHermano.setText("Jason");
                        txtHermana.setText("Emily");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FamiliaForm();
            }
        });
    }
}
