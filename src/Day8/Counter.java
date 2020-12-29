package Day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Counter {

    public int findCorrectAccumulatorNumber(String[] instructions) {
        if (checkInstructionsPass(instructions)) {
            return accumulatorCountsInstructions(instructions);
        }

        for (int i = 0; i < instructions.length; i++) {

            if (instructions[i].substring(0,3).equals("jmp") || instructions[i].substring(0,3).equals("nop")) { //easier way to write this?
                String[] newInstructions = swapOperation(instructions,i);
                if (checkInstructionsPass(newInstructions)) {
                    return accumulatorCountsInstructions(newInstructions);
                }

            }
        }
        throw new RuntimeException("Could not find which operation needed to be changed");
    }

    public int accumulatorCountsInstructions(String[] instructions) {
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

    private boolean checkInstructionsPass(String[] instructions) {
        if (accumulatorCountsInstructions(instructions) != -1) {
            return true;
        }
        return false;
    }

    public String[] swapOperation(String[] instructions, int i) {
        String[] newInstructions = Arrays.copyOf(instructions,instructions.length); //had to copy array???!
        if (instructions[i].substring(0,3).equals("jmp")) {
            newInstructions[i] = instructions[i].replace("jmp", "nop");
        } else {
            newInstructions[i] = instructions[i].replace("nop", "jmp");
        }
        return newInstructions;
    }


    private int getValue(String rule) {
        return switch (rule.length()) {
            case 6 -> Integer.parseInt(rule.substring(4, 6));
            case 7 -> Integer.parseInt(rule.substring(4, 7));
            default -> Integer.parseInt(rule.substring(4, 8));
        };
    }
}
