package Day7;

import Utility.FileUtil;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    private ArrayList<Bag> bagList;

    public static void main(String[] args) {
        Main main = new Main();
        String bagRules = FileUtil.readFile("C:\\Users\\VeryJazzy\\Desktop\\adventCode1\\Resources\\Day7Input.txt");
        main.start(bagRules);
    }

    public void start(String bagRules) {
        this.bagList = createBags(bagRules);
        Bag shinyGold = findShinyGold();
        System.out.println(countInnerBags(shinyGold));


////part1
//        int bagsThatCanContainGoldShinies = 0;
//        for (Bag bag : bagList) {
//            if (checkContents(bag)) {
//                bagsThatCanContainGoldShinies++;
//            }
//        }
//        System.out.println(bagsThatCanContainGoldShinies);
    }

    public boolean checkContents(Bag bag) {
        if (bag.contains("shiny gold")) {
            return true;
        }

        for (String containedBagName : bag.getContents().keySet()) {
            Bag aBag = getBagFromBagList(containedBagName);

            if (checkContents(aBag)) {
                return true;
            }
        }
        return false;
    }

    public Bag getBagFromBagList(String containedBagName) {
        Bag innerBag = new Bag(containedBagName);

        for (Bag aBag : bagList) {
            if (aBag.equals(innerBag)) {
                return aBag;
            }
        }
        throw new RuntimeException("Bag not in list");
    }


    public ArrayList<Bag> createBags(String bagRules) {
        String[] rules = bagRules.split("\r\n");
        ArrayList<Bag> bagList = new ArrayList<>();

        for (String rule : rules) {
            Bag bag = turnRuleIntoBag(rule);
            bagList.add(bag);
        }

        return bagList;
    }

    public Bag turnRuleIntoBag(String rule) {
        String[] ruleParts = rule.split("\\s");
        Bag bag = new Bag(ruleParts[0] + " " + ruleParts[1]);

        for (int i = 4; i < ruleParts.length; i += 4) {
            if (ruleParts[i].equals("no")) {
                break;
            }
            bag.addContents(ruleParts[i + 1] + " " + ruleParts[i + 2], Integer.parseInt(ruleParts[i]));
        }
        return bag;
    }

    public int countInnerBags(Bag bag) {
        int bagsInThisBag = 0;

        //go into current backpack
        for (Map.Entry<String, Integer> entry : bag.getContents().entrySet()) { //iterate through contained backpacks
            String currentBagName = entry.getKey();
            int amountOfCurrentBags = entry.getValue();
            Bag containedBag = getBagFromBagList(currentBagName);

            if (containedBag.getContents().isEmpty()) {
                bagsInThisBag += amountOfCurrentBags;
            } else {
                bagsInThisBag += amountOfCurrentBags;
                bagsInThisBag += (amountOfCurrentBags * countInnerBags(containedBag));
            }

        }

        return bagsInThisBag;


//        throw new RuntimeException("countInnerBags problem");
    }


    public Bag findShinyGold() {
        for (Bag bag : bagList) {
            if (bag.getName().equals("shiny gold")) {
                return bag;
            }
        }
        throw new RuntimeException("shiny gold not found in list");
    }

}
