package Day15;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getNthNumber(2020,List.of(0,6,1,7,2,19,20)));
    }

    public int getNthNumber(int n, List<Integer> turnsOG) {
        ArrayList<Integer> turns = new ArrayList<>(turnsOG);

        for (int i = turns.size(); i < n; i++) {
            turns.add(nextNumber(turns));
        }
        return turns.get(turns.size() - 1);
    }

    public int nextNumber(List<Integer> turns) {
        int lastNumber = turns.get(turns.size() - 1);
        if (countOccurrences(turns, lastNumber) == 1) {
            return 0;
        }
        return howManyTurnsApartAreNumbers(turns, lastNumber);
    }

    public int howManyTurnsApartAreNumbers(List<Integer> turns, int lastNumber) {
        for (int i = turns.size() - 2; i > -1; i--) {
            if (turns.get(i) == lastNumber) {
                return (turns.size() - 1) - i;
            }
        }
        throw new RuntimeException("error");
    }

    public int countOccurrences(List<Integer> turns, int lastNumber) {
        int count = 0;
        for (int number : turns) {
            if (number == lastNumber) {
                count++;
            }
        }
        return count;
    }
}
