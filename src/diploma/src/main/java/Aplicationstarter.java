

import auxiliary.Interval;

import java.time.LocalDateTime;
import java.time.Period;

public class Aplicationstarter {
    public static void main(String[] args) {

        LocalDateTime start = LocalDateTime.of(2021,05,
                30,12,00);
        LocalDateTime finish = LocalDateTime.of(2021,05,
                30,20,00);
        Interval first = new Interval(start, finish);
        Interval second = new Interval(start.plusHours(2),finish.minusHours(1));

        Interval created = first.intersect(second);
        System.out.println("first: "+first);
        System.out.println("second: "+second);
        System.out.println("created: "+created);






    }
}
