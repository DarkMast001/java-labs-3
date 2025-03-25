package org.example.general_dop;

public class PersonNameComparator implements MyComparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
