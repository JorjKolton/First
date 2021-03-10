import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyClass {
    public static void main(String[] args) {
        ArrayList <Integer> ali = new ArrayList<>();
        ali.add(1);
        ali.add(5);
        ali.add(6);
        ali.add(2);
        ali.add(4);
        ali.add(3);
        Stream<Integer> stri = ali.stream().sorted().filter(n -> n % 2 == 0)
                .filter(n -> n > 2);
        Spliterator<Integer> spl = stri.spliterator();
        spl.forEachRemaining(System.out::println);
//        TreeMap <String,Integer> salary = new TreeMap<>(Comparator.comparing(Function.identity(), String::compareTo));
//
//        salary.put("Igor Matvienko",28000);
//        salary.put("Maksim Panarin",70000);
//        salary.put("Sergey Sobchenko",100);
//        salary.put("Oleg Sobchenko",8000);
//
//        for (Map.Entry<String,Integer> me : salary.entrySet()) {
//            System.out.print("\n" +me.getKey()+" salary for month is ");
//            System.out.println(me.getValue()+ " uah");
//        }
//
        ArrayList<Friends> al = new ArrayList<>();
        al.add(new Friends("Igor", "Matvienko", "32", "Kharkov"));
        al.add(new Friends("Maksim", "Panarin", "33", "Kharkov"));
        al.forEach(System.out::println);

        Stream <Year> years = al.stream().filter(n -> n.name.equals("Igor"))
                .map(n -> new Year(n.secondName));
        List <Year> soname = years.collect(Collectors.toList());
        soname.forEach(n -> System.out.println(n.age));
    }
}

class Friends {
    protected String name;
    protected String secondName;
    protected String age;
    protected String city;

    Friends(String n, String sn, String a, String c) {
        name = n;
        secondName = sn;
        age = a;
        city = c;
    }

    public String toString() {
        return "\n" + name + " " + secondName + "\n" + age + " years old" + "\n" + city;
    }
}

class Year {
    protected String age;

    Year(String a) {
        age = a;
    }
}