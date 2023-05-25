package Tareas;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class EjercicioHilos extends JFrame implements Runnable{
    private JTextArea textArea;
    private ArrayList<String> dictionary;
    private volatile boolean stopThread;

    public EjercicioHilos() {
        super("Guardado Automatico");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(new JScrollPane(textArea));

        // Leer el archivo de texto y cargar su contenido en el área de texto
        loadTextFromFile();

        // Cargar el diccionario en un ArrayList
        loadDictionary();

        // Iniciar el hilo para guardar automáticamente cada 5 segundos
        Thread saveThread = new Thread(this);
        saveThread.start();

        // Iniciar el hilo para revisar la ortografía cada 60 segundos
        Thread spellCheckThread = new Thread(new SpellCheckRunnable());
        spellCheckThread.start();
    }

    private void loadTextFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            textArea.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDictionary() {
        dictionary = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("dict.txt"))) {
            String word;
            while ((word = reader.readLine()) != null) {
                dictionary.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveTextToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void spellCheckText() {
        String text = textArea.getText();
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!dictionary.contains(word.toLowerCase())) {
                textArea.setBackground(Color.RED);
                return;
            }
        }
        textArea.setBackground(Color.WHITE);
    }

    @Override
    public void run() {
        while (!stopThread) {
            saveTextToFile();
            try {
                Thread.sleep(5000); // Guardar cada 5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class SpellCheckRunnable implements Runnable {
        @Override
        public void run() {
            while (!stopThread) {
                spellCheckText();
                try {
                    Thread.sleep(60000); // Revisar la ortografía cada 60 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EjercicioHilos form = new EjercicioHilos();
            form.setVisible(true);
        });
    }

    @Override
    public void dispose() {
        stopThread = true;
        saveTextToFile(); // Guardar una última vez antes de cerrar el formulario
        super.dispose();
    }
}
