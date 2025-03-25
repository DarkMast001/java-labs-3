package org.example.general_dop;

public class PersonAgeComparator implements MyComparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
