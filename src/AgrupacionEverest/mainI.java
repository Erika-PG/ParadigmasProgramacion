package AgrupacionEverest;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class mainI {


    public static void main(String[] args) {

        Archivo archivo = new Archivo("muertes_everest.txt");
        List<Monte> listaMuertes = archivo.leerDeArchivo();

        // Crear JComboBox y agregar opciones de agrupación
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Agrupar por nacionalidad");
        comboBox.addItem("Agrupar por causa de muerte");
        comboBox.addItem("Agrupar por ubicación");

        // Agregar ActionListener al JComboBox
        comboBox.addActionListener(e -> {
            String seleccion = (String) comboBox.getSelectedItem();
            String textoMostrar = "";
            switch (seleccion) {
                case "Agrupar por nacionalidad":
                    textoMostrar = mostrarPorNacionalidad(listaMuertes);
                    break;
                case "Agrupar por causa de muerte":
                    textoMostrar = mostrarPorCausa(listaMuertes);
                    break;
                case "Agrupar por ubicación":
                    textoMostrar = mostrarPorUbicacion(listaMuertes);
                    break;
            }
            JTextArea textArea = new JTextArea(textoMostrar, 20, 100);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            JFrame frame = new JFrame("Muertes en el Everest");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel();
            panel.add(scrollPane);
            frame.add(panel);
            frame.pack();
            frame.setVisible(true);
        });

        // Crear JFrame y agregar JComboBox
        JFrame frame = new JFrame("Muertes en el Everest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(comboBox);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static String mostrarPorNacionalidad(List<Monte> listaMuertes) {
        Map<String, List<Monte>> agruparPorNacionalidad =
                listaMuertes.stream()
                        .collect(Collectors.groupingBy(Monte::getNacionalidad));
        StringBuilder sb = new StringBuilder();
        agruparPorNacionalidad.forEach(
                (nacionalidad, listaMuertesNacionalidad) -> {
                    sb.append(nacionalidad).append(":\n");
                    for (Monte muerte : listaMuertesNacionalidad) {
                        sb.append(String.format("  %s (%.1f años) - %s, %s (%s)%n",
                                muerte.getNombre(), muerte.getEdad(), muerte.getCausaMuerte(),
                                muerte.getUbicacion(), muerte.getFecha()));
                    }
                    sb.append("-".repeat(140)).append("\n");
                });
        return sb.toString();
    }

    public static String mostrarPorCausa(List<Monte> listaMuertes) {
        Map<String, List<Monte>> agruparPorCausa =
                listaMuertes.stream()
                        .collect(Collectors.groupingBy(Monte::getCausaMuerte));
        StringBuilder sb = new StringBuilder();
        agruparPorCausa.forEach(
                (causa, listaMuertesCausa) -> {
                    sb.append(causa).append(":\n");
                    for (Monte muerte : listaMuertesCausa){
                            sb.append(String.format("  %s (%.1f años) - %s, %s (%s)%n",
                                    muerte.getNombre(), muerte.getEdad(), muerte.getUbicacion(),
                                    muerte.getNacionalidad(), muerte.getFecha()));
                }
                sb.append("-".repeat(140)).append("\n");
    });
    return sb.toString();
}

    public static String mostrarPorUbicacion(List<Monte> listaMuertes) {
        Map<String, List<Monte>> agruparPorUbicacion =
                listaMuertes.stream()
                        .collect(Collectors.groupingBy(Monte::getUbicacion));
        StringBuilder sb = new StringBuilder();
        agruparPorUbicacion.forEach(
                (ubicacion, listaMuertesUbicacion) -> {
                    sb.append(ubicacion).append(":\n");
                    for (Monte muerte : listaMuertesUbicacion) {
                        sb.append(String.format("  %s (%.1f años) - %s, %s (%s)%n",
                                muerte.getNombre(), muerte.getEdad(), muerte.getCausaMuerte(),
                                muerte.getNacionalidad(), muerte.getFecha()));
                    }
                    sb.append("-".repeat(140)).append("\n");
                });
        return sb.toString();
    }
}



