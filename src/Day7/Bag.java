package Day7;

import java.util.HashMap;

public class Bag {
    private String name;
    private HashMap<String, Integer> contents = new HashMap<>();

    public Bag(String name) {
        this.name = name;
    }

    public void addContents(String bagName, int amount) {
        if (!contents.containsKey(bagName)) {
            contents.put(bagName, amount);
        }
    }

    public boolean contains(String bagName) {
        if (contents.containsKey(bagName)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "name='" + name + '\'' +
                ", contents=" + contents +
                '}';
    }

    @Override
    public boolean equals(Object otherBag) {
        if (this == otherBag) {
            return true;
        }
        if (otherBag == null || getClass() != otherBag.getClass()) {
            return false;
        }
        Bag that = (Bag) otherBag;

        return this.name.equals(that.getName());
    }


    public String getName() {
        return name;
    }

    public HashMap<String, Integer> getContents() {
        return contents;
    }


}
