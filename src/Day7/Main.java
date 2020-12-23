package Day7;

import Utility.FileUtil;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    private ArrayList<Bag> bagList;

    public static void main(String[] args) {
        Main main = new Main();
        String bagRules = FileUtil.readFile("C:\\Users\\VeryJazzy\\Desktop\\adventCode1\\Resources\\Day7Short.txt");
        main.start(bagRules);
    }

    public void start(String bagRules) {
        this.bagList = createBags(bagRules);

//        //find shiny gold
//        countInnerBags(rule1); // give shiny gold

//        int bagsThatCanContainGoldShinies = 0;
//
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

        for (int i = 4; i < ruleParts.length; i+=4) {
            if (ruleParts[i].equals("no")) {
                break;
            }
            bag.addContents(ruleParts[i+1] + " " + ruleParts[i+2], Integer.parseInt(ruleParts[i]));
        }
        return bag;
    }

    public int countInnerBags(String rule) {
        Bag bag = turnRuleIntoBag(rule);

        if (bag.getContents().isEmpty()) {
            return 0;
        }
        int count = 0;
        for (Map.Entry entry : bag.getContents().entrySet()) {
            count += (int) entry.getValue();
        }
        return count;
    }

}
