package task;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Restrant {
    public static void main(String[] args) {
        ArrayBlockingQueue toWaitress = new ArrayBlockingQueue(6);
        ArrayBlockingQueue toCoook = new ArrayBlockingQueue(6);
        ArrayBlockingQueue toClient = new ArrayBlockingQueue(4);
        ArrayList<Client> clients = new ArrayList<Client>();
        for (int i=0;i<10;i++){
            Client cl= new Client("client "+i,toWaitress,toClient);
            clients.add(cl);
        }
        ArrayList<Waitress> surv = new ArrayList<Waitress>();
        for (int i=0;i<10;i++){
            Waitress wt= new Waitress("Waitress "+i,toWaitress,toCoook);
            surv.add(wt);
        }
        ArrayList<Coock> surv2 = new ArrayList<Coock>();
        for (int i=0;i<10;i++){
            Coock cK= new Coock( "Coock "+i,toCoook,toClient);
            surv2.add(cK);
        }


            for(Client client:clients){
                new Thread( client).start();
            }
            for (Waitress waitress: surv){
                new Thread(waitress).start();
            }
            for (Coock coock:surv2){
                new Thread(coock).start();
            }

    }
}

class Client implements Runnable{
    public String name;
    ArrayBlockingQueue toWaitress;
    ArrayBlockingQueue toClient;

    public Client(String name, ArrayBlockingQueue toWaitress, ArrayBlockingQueue toClient) {
        this.name = name;
        this.toWaitress = toWaitress;
        this.toClient = toClient;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            while (!Thread.currentThread().isInterrupted()){
            Order order = new Order();
            System.out.println(name + " Делает заказ " +order );

            try {
                toWaitress.put(order);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                toClient.removeIf(o->equals(order));
                System.out.println("Забррал у поворов заказ" +order);
                            Thread.currentThread().interrupt();

            }
        }
    }
}

class Waitress implements Runnable{
    public String  name;
    ArrayBlockingQueue toWaitress;
    ArrayBlockingQueue toCoook;

    public Waitress(String name, ArrayBlockingQueue toWaitress, ArrayBlockingQueue toCoook) {
        this.name = name;
        this.toWaitress = toWaitress;
        this.toCoook = toCoook;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Order order = (Order) toWaitress.take();
                Thread.sleep(20);
                toCoook.put(order);
                System.out.println("Официант"+ name + " передал повору заказ " +order);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class Coock implements Runnable{
    public String  name;
    ArrayBlockingQueue toClient;
    ArrayBlockingQueue toCoook;

    public Coock(String name, ArrayBlockingQueue toClient, ArrayBlockingQueue toCoook) {
        this.name = name;
        this.toClient = toClient;
        this.toCoook = toCoook;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Order order = (Order) toCoook.take();
                System.out.println("Повар " + name+ " принял заказ " +order);
                Thread.sleep(300);
                toClient.put(order);
                System.out.println("Повар " + name+ " приготовил заказ " +order);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
