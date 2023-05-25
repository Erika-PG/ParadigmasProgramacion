package Tareas.Mapas.HilosC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pregunta {
    private static Map<String, String> questions = new HashMap<>();

    static {
        questions.put("1", "________ is writing an essay");
        questions.put("2", "________ is having a coffee");
        questions.put("3", "________ is talking on the phone");
        questions.put("4", "________is watching a baseball game");
        questions.put("5", "________ is shopping");
        questions.put("6", "________ is playing soccer");
    }
    private static Map<String, String> answers = new HashMap<>();

    static {
        answers.put("1", "Kathyo");
        answers.put("2", "Megm");
        answers.put("3", "Carmen");
        answers.put("4", "Kathyo's dad");
        answers.put("5", "Kathyo's mother");
        answers.put("6", "John");
    }

    public static void main(String[] args) {
        Thread preguntaThread = new Thread(new PreguntaThread());
        preguntaThread.start();
    }
    static class PreguntaThread implements Runnable {
        private Scanner scanner = new Scanner(System.in);

        @Override
        public void run() {
            for (String key : questions.keySet()) {
                String question = questions.get(key);
                String answer = answers.get(key);

                System.out.print("Question: ");
                escribirPregunta(question);

                System.out.println();

                System.out.print("Answer: ");
                String userAnswer = scanner.nextLine();

                if (userAnswer.equalsIgnoreCase(answer)) {
                    System.out.println("The answer is correct.");
                 } else {
                    System.out.println("Incorrect answer.");
                    System.out.println("The correct answer is: " + answer);
                }

                System.out.println();
            }
        }

        private void escribirPregunta(String pregunta) {
            char[] caracteres = pregunta.toCharArray();

            for (char c : caracteres) {
                System.out.print(c);
                pausa(50);
            }
        }

        private void pausa(int milisegundos) {
            try {
                Thread.sleep(milisegundos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
