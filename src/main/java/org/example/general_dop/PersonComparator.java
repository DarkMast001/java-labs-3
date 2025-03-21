package org.example.general_dop;

public class PersonComparator implements MyComparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        // Сначала сравниваем по возрасту
        int ageComparison = Integer.compare(p1.getAge(), p2.getAge());
        if (ageComparison != 0) {
            return ageComparison;
        }
        // Если возраст одинаковый, сравниваем по имени
        return p1.getName().compareTo(p2.getName());
    }
}
