package BOJ;

import java.util.*;

public class Scnnaer {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        list.add(new Person("A",1,1));
        list.add(new Person("B",1,2));
        list.add(new Person("C",2,2));

        Collections.sort(list);

        for(Person p : list){
            System.out.println(p.name + " "+ p.w +" " + p.h);
        }

        
    }

   
    
}

/**
 * Person
 */
class Person implements Comparable<Person> {
    
    String name;
    int w;
    int h;

    public Person(String name, int w, int h){
        this.name = name;
        this.w = w;
        this.h = h;
    }

    @Override
    public int compareTo(Person o) {

        if (this.w > o.w && this.h > o.h) {
            return 1;
        }
        // TODO Auto-generated method stub
        return -1;
    }

    
    
}
