import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Employee markus = new Employee("Markus","Lego",2500,32);
        System.out.println(markus);
        List<Employee> emplis = Employee.employeeGenerator(25);
       for (int i =0; i<emplis.size(); i++){
           System.out.println(emplis.get(i));
       }
//       EmplyeeSorter byName = new EmplyeeSorter();
//       byName.setSortingBy(EmplyeeSorter.Order.Name);
//        Collections.sort(emplis,byName);
//        System.out.println("After sort");
//        for (int i =0; i<emplis.size(); i++){
//            System.out.println(emplis.get(i));
//        }
//
        EmpolyeSorterNum tr1 = new EmpolyeSorterNum(EmpolyeSorterNum.Order.Name, EmpolyeSorterNum.Order.Sallary, EmpolyeSorterNum.Order.Age, EmpolyeSorterNum.Order.Company);
        Collections.sort(emplis,tr1);
        System.out.println("After sort");
        for (int i =0; i<emplis.size(); i++){
            System.out.println(emplis.get(i));
        }




    }
}
