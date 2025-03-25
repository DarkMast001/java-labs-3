package org.example.general_dop;

public class PersonComparator implements MyComparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return new PersonAgeComparator() { }
                .thenComparing(new PersonNameComparator() { })
                .compare(o1, o2);
    }
}
