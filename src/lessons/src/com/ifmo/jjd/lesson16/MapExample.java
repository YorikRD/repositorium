package com.ifmo.jjd.lesson16;

import java.lang.ref.WeakReference;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User cbf = new User("cbf", "12443", Role.USER);
        User asd = new User("asd", "2625", Role.ADMIN);
        User rty = new User("rty", "8734", Role.USER);
        User bnm = new User("bnm", "2688", Role.ADMIN);

        // maps are primary different is by Key type:
        // 1. Map Keys must be unicK!
        // 2. Each key cal lead only to one value.
        // 3. Maps are not collections.

        //Mapas hear are NOT Thread-safe:
        //The most popular are HashMap<K,V> && TreeMap<K,V>

        //HAshMap Specifics:
        //1. Keeps keys in hashtable (by hachcode of keys)
        //2. High speed efficiency (faster the all besidse enum map)
        //3. May use null as key.
        //4. Order of datakeeping differs from adding order.

        //<Ket type, Value type>
        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(asd.getLogin(),bnm);
        userHashMap.put(asd.getLogin(),asd); // hear we overriden value for used key
        userHashMap.put(null,null);
        userHashMap.put(cbf.getLogin(),cbf);
        System.out.println(userHashMap);
        //if keys are different objects but their hascode is the same, it is called collision. Collision is resoved by links method.
        userHashMap.remove("asd");
        userHashMap.remove("rty",cbf); // hear pair must be true both.
        // replace form version java8

        userHashMap.replace("try", null);
        userHashMap.replace("cbf",null, cbf);

        // rommove and replace by pairs works if key&value are bouth present and are in table.

        System.out.println(userHashMap.get("cbf"));
        // if key is not present method below which returns value by default given in it
        System.out.println(userHashMap.getOrDefault("uuu", cbf));

        System.out.println(userHashMap.containsKey("uuu"));
        System.out.println(userHashMap.containsValue(cbf));

        System.out.println("---MapIteration---");
        for (Map.Entry<String, User> pair: userHashMap.entrySet()){ // hear we iteratr a Set collection of Entry
            //Entry is a specific data type contain ing key a value, works only for reading
            System.out.println("The key: "+pair.getKey());
            System.out.println("The value: "+pair.getValue());
        }

        //Specifics EnumMap:
        //1  - uses (enum) as keys
        //2 - null cannot be used as a key
        //3 - All keys must be from single enum
        //4 - all vlues are kept as array of size of enums number.
        // 4.1 - the order of keeping data is the same as key order in enum.
        //5. For returning value is used th index of key(in inner enum data)
        //6 returns key by this index.
        //vals[key.ordinal()]

        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class); //to the Constructor of thise class we should put a link to enum class.
        enumMap.put(Role.USER,new ArrayList(Arrays.asList(cbf,rty))); //Arrays.asList returns us list fron array, or several objects
        enumMap.put(Role.ADMIN,new ArrayList(Arrays.asList(asd,bnm)));

        System.out.println(enumMap.get(Role.USER));

        for (User user :  enumMap.get(Role.ADMIN)) {
            System.out.println(user.getLogin());
        }

        User newUser = new User("newUser","111", Role.USER);
        enumMap.get(newUser.getRole()).add(newUser);

        User someUser = new User("newUser","111", Role.USER);
        WeakReference<User> weakReference = new WeakReference<>(someUser);
        someUser = null;
        //if there is few memory left the weak refferences will be deleted. By trashCleaner.

        WeakHashMap<Object, String> weakHashMap =new WeakHashMap<>(); // Used preferbly for cash data.
        Object weakKey = new Object();
        String weakVal = "String";
        weakHashMap.put(weakKey,weakVal);
        System.out.println(weakHashMap);
        System.out.println(weakHashMap.size());
        weakKey = null;
        weakVal = null;
        System.gc();
        System.out.println(weakHashMap);
        System.out.println(weakHashMap.size());

        // Treemap:
        // 1. Treemap is a map which keeps data in order of sorted keys.
        //2. base on black-red tree algorithm
        //3. null cannot be used as a key.
        //4. class instznces of which are used as keys must impliment the comparable interface. Or we must put Comparator to a constructor.

        userHashMap.remove(null);

        TreeMap<String, User> userTreeMap = new TreeMap<>(userHashMap);
        userTreeMap.put("asd",asd);










    }
}
