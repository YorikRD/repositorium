package com.ifmo.jjd.lesson15.collection;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Student student1 = new Student("Петр", "Алексеев", 18);
        Student student2 = new Student("Екатерина", "Еремина", 20);
        Student student3 = new Student("Денис", "Попов", 22);
        Student student4 = new Student("Петр", "Попов", 22);
        //Collections are used to store data.
        //1 - It is not wise to use multythread collections in singthread programs.
        // reversed is obvious it will case mistakes.
        //2 - Seveal collections allow to atroe only unick elements, several allow to store identical elements.
        //3 - Collectins differ bey the order they store data< several can store data in order of adding, sveral in othe order.
        //4 - Collections may store data in sorted order.
        //All collections in todays lesson are Thread UNSAFE. Collections and MAP s are not child/parrent

        // all collectrions impliment collection interface.
        // the next level are interfaces List / Queue/Set.
        //each collection is exempalr of some class.(Collection type)
        // read home: collection methods, list, set. Docs for java7.
        System.out.println("---LinkedList---");
        // specifics
        // 1 . the elements order is settarn. The first elemenr added will be kept first.
        // 2. can store null
        // 3. Allowes storing identical elements.

        List<Student> list = new LinkedList<>(); //only List-interface methods.
        Collection<Student> collection= new LinkedList<>(); //only Collection-interface methods.
        LinkedList<Student> students =new LinkedList<>();
        students.add(student1);// elem ading to the end of the list. unlimited numer of elem (capped with memory)
        students.add(student2);
        students.add(student1);
        students.add(1,student3); // student3 elem is added to position 1 (indexes os strted with zero)
//        students.add(90, student3); //index out of bonds exeption.
        students.addFirst(null);
        students.addLast(student2);
        System.out.println(students);
        System.out.println(students.size());
        // add dont erase elem it adds elem to position then moves all with index higher to give him space
        // returning elems:
        System.out.println(students.get(0)); // for emty collection. Index out of bonds Exeption
        System.out.println(students.getFirst()); // for emty collection. NosuchElem Exeption.
        System.out.println(students.getLast());// for emty collection. NosuchElem Exeption.

//         elements removing.
        students.removeFirst(); // deletes and returns link to removed object
        students.removeLast();
        students.remove(student1); // returns boolean and if true removes first instance of object.
        System.out.println(students.size());
        students.remove(null);
        System.out.println("After romoval " +students);
        // LinkedList - двунправленный связанный списокю
        // for /rmove equals method must be overriden.




        System.out.println("---ArrayList---"); // in most cases it is more prefereble than LinkedList.
        // specificsL
        // 1. its realised at the basis of Array. it is dinamicly modified array.
        // 2. can store null
        // 3. Allowes storing identical elements.
        // the order is ass added.

        ArrayList<Student> studentArrayList = new ArrayList<>();
        // initialy an array of ten elements null is created.
        studentArrayList = new ArrayList<>(30); // is crated with initial inside array saze. the formula for size changing is not controlable
        System.out.println(studentArrayList.size()); //0
        studentArrayList.add(student1);
        studentArrayList.add(0,student2);
        studentArrayList.add(1,student1); // the input in the center is long opertion.
        studentArrayList.add(null);
        System.out.println(studentArrayList.size()); //
        System.out.println(studentArrayList);
        studentArrayList.trimToSize(); // no args rquired removes only empty elements.
        System.out.println("sublist: "+ studentArrayList.subList(1,3)); // thirst included secind execluded. // return List
        //returning elements
        System.out.println(studentArrayList.get(2)); // by index
        studentArrayList.remove(2); // returns link to deleting object
        studentArrayList.remove(student1); // returns true/false if true removes
        System.out.println("after remving " + studentArrayList);
        //methof remove(Object o) usese equals method.

        studentArrayList.addAll(students);// adds all from other collectiob

        Student[] arr = {student1, student2};
        studentArrayList.addAll(Arrays.asList(arr));

        studentArrayList.removeAll(Arrays.asList(arr));

        System.out.println("---Set---");
        //Specifics:
        //Interfcae Set :
        //1. used for keeping ONLY unic elements
        //2. methods equal & hashcode must be overriden.
        //3. Set has no .get methods (no get methods is declared in collection interface)

        // Specifics HashSet:
        //1. based on a hashTable uses elements of Maps.
        //2. oreder of kept elements may differ from adding order;
        //3. may keep null (always be on a first position)

        HashSet<Student> studentHashSet = new HashSet<>(studentArrayList);
        System.out.println(studentHashSet);
        studentHashSet.add(student1);
        studentHashSet.remove(student2); //studentHashSet.removeAll()





        // Specifics LinkedHashSet:
        //1. based on a hashTable uses elements of Maps.
        //2. oreder of kept elements is the same of element adding;
        //3. may keep null (always be on a first position)

        // Specifics TreeSet:
        //1.Keeps elements sorted via compare method
        //2. based on black-red tree algorithm
        //3. cannot keep null.

        // for adding elements to treeset  they must:
        // var1: the class must impliment Comparable interface and override its method compareTo/

        //var2: give the constructor a Comparator -class exemplar;

        TreeSet<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(student1);
        studentTreeSet.add(student2);
        studentTreeSet.add(student3);

        Comparator<Student> studentComparator1 = new StudentNameComparator().thenComparing(new StudentAgeComparator());
        TreeSet<Student> trs = new TreeSet<>(studentComparator1);
        trs.add(student1);
        trs.add(student2);
        trs.add(student3);
        trs.add(student4);

        for (Student studend : trs) { // here we can do everithing but removing. removing will throw exeption
//            trs.remove(studend);

        }




    }

}
