package Day8;

import java.util.ArrayList;
import java.util.List;

public class Counter {

    public int findCorrectAccumulatorNumber(String[] instructions) {
        if (countAccumulator(instructions) != -1) {
            return countAccumulator(instructions);
        }

        for (int i = 0; i < instructions.length; i++) {

            if (instructions[i].substring(0,3).equals("jmp") || instructions[i].substring(0,3).equals("nop")) {
                String[] newInstructions = swapOperation(instructions,i);
                if (countAccumulator(newInstructions) != -1) {
                    return countAccumulator(newInstructions);
                }
            }
        }



        throw new RuntimeException("couldnt find which op needed to be changed");
    }



    public int countAccumulator(String[] instructions) {
        int counter = 0;
        List<Integer> indexesWeHaveBeenTo = new ArrayList<>();

        for (int i = 0; i < instructions.length; i++) {

            if (indexesWeHaveBeenTo.contains(i)) {
                return -1;
            }

            indexesWeHaveBeenTo.add(i);

            String operation = instructions[i].substring(0, 3);
            int value = getValue(instructions[i]);

            switch (operation) {
                case "acc":
                    counter += value;
                    break;

                case "jmp":
                    i += value - 1;
                    break;

            }
        }
        return counter;
    }

    public String[] swapOperation(String[] instructions, int i) {
        if (instructions[i].substring(0,3).equals("jmp")) {
            instructions[i] = instructions[i].replace("jmp", "nop");
            return instructions;
        }
        instructions[i] = instructions[i].replace("nop", "jmp");
        return instructions;
    }


    private int getValue(String rule) {
        return switch (rule.length()) {
            case 6 -> Integer.parseInt(rule.substring(4, 6));
            case 7 -> Integer.parseInt(rule.substring(4, 7));
            default -> Integer.parseInt(rule.substring(4, 8));
        };
    }
}
