package Tareas.Mapas.HilosC;

import Hilos.EscrituraLenta;

public class Conversacion {
    public static void main(String[] args) {
        String dialog1Memg = "megm: Hi, there!\n";
        String dialog1Kathyo = "kathyo: Hi Meg!\n";
        String dialog2Memg = "megm: What are you doing?\n";
        String dialog2Kathyo = """
                kathyo: I'm sitting on my bed with my laptop. I'm doing my homework
                """;
        String dialog3Megm = "megm: What are you working on?\n";
        String dialog3Kathyo = """
                kathyo: I'm writing an essay for Spanish class. :) where are you?
                """;
        String dialog4Memg = """
                megm: I'm in a café with my friend Carmen. I'm having coffee, and she's talking on\s
                      the phone outside. How is your family?
                """;
        String dialog4Kathyo = """
                kathyo: The're all fine! My father's whatching a baseball game with his\s
                        friends. My mother is out shopping.
                """;
        String dialog5Megm = "megm: Where's your brother?\n";
        String dialog5Kathyo = """
                kathyo: John's playing soccer in the park. Oh, wait. My phone is ringing. My mother's calling me.\s
                         I have to go! Bye!
                """;
        String dialog6Megm = "megm: OK! Bye!";

        EscrituraLenta.escribir(dialog1Memg, 20);
        pausa(2000);
        EscrituraLenta.escribir(dialog1Kathyo, 20);
        pausa(2000);
        EscrituraLenta.escribir(dialog2Memg, 20);
        pausa(2000);
        EscrituraLenta.escribir(dialog2Kathyo, 20);
        pausa(2000);
        EscrituraLenta.escribir(dialog3Megm,20);
        pausa(2000);
        EscrituraLenta.escribir(dialog3Kathyo, 20);
        pausa(2000);
        EscrituraLenta.escribir(dialog4Memg, 20);
        pausa(2000);
        EscrituraLenta.escribir(dialog4Kathyo, 20);
        pausa(2000);
        EscrituraLenta.escribir(dialog5Megm,20);
        pausa(2000);
        EscrituraLenta.escribir(dialog5Kathyo, 20);
        pausa(2000);
        EscrituraLenta.escribir(dialog6Megm,20);
    }
    public static void pausa(int tiempo){
        System.out.println();
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
