package task;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Restrant {
    public static void main(String[] args) {
        LinkedBlockingDeque<Order> toWaitress = new LinkedBlockingDeque<>(6);
        LinkedBlockingDeque<Order> toCoook = new LinkedBlockingDeque<>(6);
        ArrayBlockingQueue<Order> toClient = new ArrayBlockingQueue<>(10);
        ArrayList<Client> clients = new ArrayList<>();
        for (int i=0;i<6;i++){
            Client cl= new Client("client "+i,toWaitress,toClient);
            clients.add(cl);
        }
        ArrayList<Waitress> surv = new ArrayList<Waitress>();
        for (int i=0;i<2;i++){
            Waitress wt= new Waitress("Waitress "+i,toWaitress,toCoook);
            surv.add(wt);
        }
        ArrayList<Coock> cooks = new ArrayList<Coock>();
            for (int i=0;i<5;i++){
               Coock ck = new Coock("Cookc"+i,toCoook,toClient);
               cooks.add(ck);
        }

        for (Client client : clients) {
            new Thread(client).start();
        }
        for (Waitress waitress : surv) {
            new Thread(waitress).start();
        }
        for (Coock coock : cooks) {
            new Thread(coock).start();
        }


    }
}

class Client implements Runnable{
    public String name;
    LinkedBlockingDeque toWaitress;
    ArrayBlockingQueue toClient;

    public Client(String name, LinkedBlockingDeque toWaitress, ArrayBlockingQueue toClient) {
        this.name = name;
        this.toWaitress = toWaitress;
        this.toClient = toClient;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Runs" + name);
        while (!Thread.currentThread().isInterrupted()){
            while (!Thread.currentThread().isInterrupted()){
            Order order = new Order();
            System.out.println(name + " Делает заказ " +order );

            try {
                toWaitress.put(order);
                Thread.sleep(200);
                System.out.println("Client takes "+toClient.take());
                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }


            }
        }
    }
}

class Waitress implements Runnable{
    public String  name;
    LinkedBlockingDeque toWaitress;
    LinkedBlockingDeque toCoook;

    public Waitress(String name, LinkedBlockingDeque toWaitress, LinkedBlockingDeque toCoook) {
        this.name = name;
        this.toWaitress = toWaitress;
        this.toCoook = toCoook;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Runs"+ name);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Order order = (Order) toWaitress.take();
                Thread.sleep(20);
                toCoook.put(order);
                System.out.println("Официант"+ name + " передал повору заказ " +order);
                System.out.println("Состояние очереди заказов от клиента" + toWaitress);
                System.out.println("Состояние очереди заказов на кухню" + toCoook);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class Coock implements Runnable{
    public String  name;
        LinkedBlockingDeque toCoook;
    ArrayBlockingQueue toClient;

    public Coock(String name, LinkedBlockingDeque toCoook, ArrayBlockingQueue toClient) {
        this.name = name;
        this.toClient = toClient;
        this.toCoook = toCoook;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Runs " + name);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Order order = (Order) toCoook.take();
                System.out.println("Повар " + name+ " принял заказ " +order);
                Thread.sleep(30);
                toClient.put(order);
                System.out.println("Повар " + name+ " приготовил заказ " +order);
                System.out.println("Очередь заказов к клиенту " + toClient );
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
