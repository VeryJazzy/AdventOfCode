package Day8;

import java.util.ArrayList;
import java.util.List;

public class Counter {

    public int countAccumulator(String[] instructions) {
        int counter = 0;
        List<Integer> indexesWeHaveBeenTo = new ArrayList<>();

        for (int i = 0; i < instructions.length; i++) {

            if (indexesWeHaveBeenTo.contains(i)) {
               break;
            }
            indexesWeHaveBeenTo.add(i);

            String rule = instructions[i];
            String operation = rule.substring(0, 3);
            int value = getValue(rule);

            switch (operation) {
                case "acc":
                    counter += value;
                    break;
                case "jmp":
//                    if (indexesWeHaveBeenTo.contains(i += value)) {
//                        break;
//                    } else {
                        i += value - 1;
//                    }
                    break;
            }
        }
        return counter;
    }

    private int getValue(String rule) {
        if (rule.length() == 6) {
            return Integer.parseInt(rule.substring(4, 6));
        } else if (rule.length() == 7) {
            return Integer.parseInt(rule.substring(4, 7));
        } else {
            return Integer.parseInt(rule.substring(4, 8));
        }
    }
}
