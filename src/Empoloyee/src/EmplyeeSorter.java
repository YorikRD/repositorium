import java.util.ArrayList;
import java.util.Comparator;

public class EmplyeeSorter implements Comparator<Employee> {
    public enum Order {Name,Company,Age,Sallary}
    private Order sortingBy = Order.Name;

    public void setSortingBy(Order sortingBy) {
        this.sortingBy = sortingBy;
    }

    @Override
    public int compare(Employee employee, Employee t1) {
        switch (sortingBy){
            case Name: return employee.getName().compareTo(t1.getName());
            case Company: return employee.getCompany().compareTo(t1.getCompany());
            case Age: return employee.getAge() - t1.getAge();
            case Sallary: return employee.getSalary() -t1.getSalary();
        }
        return 0;
    }
}
class EmpolyeSorterNum implements Comparator<Employee> {
    public enum Order {Name, Company, Age, Sallary}

    private ArrayList<Order> sortingbynum = new ArrayList();
    private Order sort1 = Order.Name;
    private Order sort2 = Order.Sallary;
    private Order sort3 = Order.Age;
    private Order sort4 = Order.Company;

    public EmpolyeSorterNum(Order sort1, Order sort2, Order sort3, Order sort4) {
        this.sort1 = sort1;
        this.sort2 = sort2;
        this.sort3 = sort3;
        this.sort4 = sort4;
        sortingbynum.add(sort1);
        sortingbynum.add(sort2);
        sortingbynum.add(sort3);
        sortingbynum.add(sort4);
        System.out.println("Алгоритм сортировки выглядит как :");
        for (int i=0; i<sortingbynum.size(); i++){
            System.out.println(sortingbynum.get(i));
        }
    }


    @Override
    public int compare(Employee employee, Employee t1) {
        int value1 = 0;
        switch (sortingbynum.get(0)) {
            case Name:{
                value1 = employee.getName().compareTo(t1.getName());
            break;}
            case Company:
                {value1 = employee.getCompany().compareTo(t1.getCompany());
                break;}
            case Age:
                {value1 = employee.getAge() - t1.getAge();
                break;}
            case Sallary:
                {value1 = employee.getSalary() - t1.getSalary();
                break;}
        }
        if (value1 == 0) {
            int value2 = 0;
            switch (sortingbynum.get(1)) {
                case Name:
                    {value2 = employee.getName().compareTo(t1.getName());
                    break;}
                case Company:
                    {value2 = employee.getCompany().compareTo(t1.getCompany());
                    break;}
                case Age:
                   { value2 = employee.getAge() - t1.getAge();
                   break;}
                case Sallary:
                    {value2 = employee.getSalary() - t1.getSalary();
                    break;}
            }
            if (value2 == 0) {
                int value3 = 0;
                switch (sortingbynum.get(2)) {
                    case Name:
                        {value3 = employee.getName().compareTo(t1.getName());
                        break;}
                    case Company:
                        {value3 = employee.getCompany().compareTo(t1.getCompany());
                        break;}
                    case Age:
                       { value3 = employee.getAge() - t1.getAge();
                       break;}
                    case Sallary:
                       { value3 = employee.getSalary() - t1.getSalary();
                       break;}
                }
                if (value3 == 0) {
                    int value4 = 0;
                    switch (sortingbynum.get(3)) {
                        case Name:
                           { value4 = employee.getName().compareTo(t1.getName());
                           break;}
                        case Company:
                            {value4 = employee.getCompany().compareTo(t1.getCompany());
                            break;}
                        case Age:
                            {value4 = employee.getAge() - t1.getAge();
                            break;}
                        case Sallary:
                            {value4 = employee.getSalary() - t1.getSalary();
                            break;}
                    }
                    return value4;
                } else {
                    return value3;
                }
            } else {
                return value2;
            }
        } else {
            return value1;
        }
    }
}
