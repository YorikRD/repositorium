package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class PortTask {
    public static void main(String[] args) {
        Semaphore pier1 = new Semaphore(5,true);
        Semaphore pier2 = new Semaphore(5,true);
        Semaphore pier3 = new Semaphore(5,true);
        Semaphore pier4 = new Semaphore(5,true);
        List<Semaphore> list = Collections.synchronizedList(new ArrayList<>());
        list.add(pier1);
        list.add(pier2);
        list.add(pier3);
        list.add(pier4);


        for (int i = 0; i < 7; i++) {
            new Thread(new ShipUnload(list)).start();
        }
    }
}

class ShipUnload implements Runnable {
    public String name;
    private List<Semaphore> port;
    static String[] nomb = {"гОРДЫЙ", "Честный", "Удачиливы", "Хитропопый", "Cale", "Tirpicc", "Yamaho", "Titcanic"};

    public ShipUnload(List<Semaphore> port) {
        Random random = new Random();
        this.port = port;
        name = nomb[random.nextInt(8)];
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                for (int i = 0; i < port.size(); i++) {

                    port.get(i).acquire(5);
                    System.out.println("Корабль " + name + " получил разрешение на причаливания и занял причал " + port.get(i));
                    Thread.sleep(2000);
                    System.out.println("Корабль " + name + " завершил погрузку и разургуку " + port.get(i));
                    port.get(i).release(5);
                    Thread.currentThread().interrupt();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
