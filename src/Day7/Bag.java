package Day7;

import java.util.ArrayList;

public class Bag {
    private String name;
    private ArrayList<String> contents = new ArrayList<>();

    public Bag(String name) {
        this.name = name;
    }

    public void addContents(String bagName) {
        if (!contents.contains(bagName)) {
            contents.add(bagName);
        }
    }

    public boolean contains(String bagName) {
        if (contents.contains(bagName)) {
            return true;
        }
        return false;
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

    public ArrayList<String> getContents() {
        return contents;
    }


}
