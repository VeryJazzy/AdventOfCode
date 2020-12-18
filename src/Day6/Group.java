package Day6;

import java.util.ArrayList;

public class Group {
    private ArrayList<Person> people;

    public Group(String group) {
        this.people = extractPeople(group);
    }

    private ArrayList<Person> extractPeople(String group) {
        ArrayList<Person> people = new ArrayList<Person>();
        for (String line : group.split("\r\n")) {
         Person person = new Person(line);
         people.add(person);
        }
        return people;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }
}
