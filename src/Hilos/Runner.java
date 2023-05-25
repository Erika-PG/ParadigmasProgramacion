package Hilos;

public class Runner implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++){
          System.out.println("Elemento "+ i);

          try {
              Thread.sleep(1000); // duerme durante 1 segundo
          } catch(InterruptedException e){
              e.printStackTrace();
          }
        }
    }
}
