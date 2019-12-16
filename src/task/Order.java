package task;

import java.lang.reflect.Array;
import java.util.Objects;
import java.util.Random;

public class Order {
    public  String name;
    public  int price;
    static String[] nomb = {"Жаркое", "Салат", "Десерт", "Напиток"};

    public Order() {
        Random random = new Random();
        name = nomb[random.nextInt(3)];
        price = random.nextInt(20);
            }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return price == order.price &&
                name.equals(order.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
