package Tareas.Uso_Hilos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormularioFamilia extends JFrame {
    private JButton familiaBtn;

    public FormularioFamilia() {
        setTitle("Formulario Familia");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel preguntasPanel = new JPanel();
        preguntasPanel.setLayout(new GridLayout(10, 6));

        JLabel[] labels = new JLabel[8];
        JTextField[] textFields = new JTextField[8];

        for (int i = 0; i < 8; i++) {
            labels[i] = new JLabel();
            textFields[i] = new JTextField();
            preguntasPanel.add(labels[i]);
            preguntasPanel.add(textFields[i]);
        }

        add(preguntasPanel, BorderLayout.CENTER);

        JButton puntuacionBtn = new JButton("Submit");
        puntuacionBtn.setEnabled(false);
        puntuacionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int score = calcularPuntuacion();
                JOptionPane.showMessageDialog(null, "Puntuación: " + score, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        add(puntuacionBtn, BorderLayout.SOUTH);

        familiaBtn = new JButton("Familia");
        familiaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaFamilia();
            }
        });
        add(familiaBtn, BorderLayout.NORTH);

        agregarPreguntas();

        pack();
        setLocationRelativeTo(null);
    }

    private void agregarPreguntas() {
        String[] questions = {
                "1) Anne is Paul's",
                "2) Jason and Emily are their",
                "3) Paul is Anne's",
                "4) Jason is Anne's",
                "5) Emily is Paul's",
                "6) Jason is Emily's",
                "7) Emily is Jason's",
                "8) Paul and Anne are Jason's"
        };

        for (int i = 0; i < questions.length; i++) {
            JLabel label = (JLabel) ((JPanel) getContentPane().getComponent(0)).getComponent(i * 2);
            label.setText(questions[i]);
        }
    }

    private int calcularPuntuacion() {
        int puntuacion = 0;
        String[] respuestasCorrectas = {
                "wife",
                "children",
                "husband",
                "son",
                "daughter",
                "brother",
                "sister",
                "parents"
        };

        for (int i = 0; i < respuestasCorrectas.length; i++) {
            JTextField textField = (JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(i * 2 + 1);
            String respuesta = textField.getText().trim().toLowerCase();
            if (respuesta.equals(respuestasCorrectas[i])) {
                puntuacion += 1;
            }
        }
        return puntuacion;
    }

    private void mostrarVentanaFamilia() {
        JFrame ventanaFamilia = new JFrame("Familia");
        ventanaFamilia.setSize(500, 400);
        ventanaFamilia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaFamilia.setLayout(new GridLayout(4, 2, 10, 10));

        JButton esposaBtn = new JButton("Esposa: Anne");
        esposaBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        ventanaFamilia.add(esposaBtn);

        JButton esposoBtn = new JButton("Esposo: Paul");
        esposoBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        ventanaFamilia.add(esposoBtn);

        JButton hijoBtn = new JButton("Hijo: Jason");
        hijoBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        ventanaFamilia.add(hijoBtn);

        JButton hijaBtn = new JButton("Hija: Emily");
        hijaBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        ventanaFamilia.add(hijaBtn);

        JButton hermanoBtn = new JButton("Hermano: Jason");
        hermanoBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        ventanaFamilia.add(hermanoBtn);

        JButton hermanaBtn = new JButton("Hermana: Emily");
        hermanaBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        ventanaFamilia.add(hermanaBtn);

        JButton padresBtn = new JButton("Padres: Anne, Paul");
        padresBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        ventanaFamilia.add(padresBtn);

        JButton hijosBtn = new JButton("Hijos: Jason, Emily");
        hijosBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        ventanaFamilia.add(hijosBtn);

        JButton volverBtn = new JButton("Volver");
        volverBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaFamilia.dispose();
            }
        });
        ventanaFamilia.add(volverBtn);

        ventanaFamilia.setLocationRelativeTo(null);
        ventanaFamilia.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormularioFamilia().setVisible(true);
            }
        });
    }
}