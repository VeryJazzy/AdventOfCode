package Day7;

import Utility.FileUtil;

import java.util.ArrayList;

public class Main {

    private ArrayList<Bag> bagList;

    public static void main(String[] args) {
        Main main = new Main();
        main.collectShinies();
    }

    public void collectShinies() {
        String bagRules = FileUtil.readFile("C:\\Users\\VeryJazzy\\Desktop\\adventCode1\\Resources\\Day7Input.txt");
        this.bagList = createBags(bagRules);
        int bagsThatCanContainGoldShinies = 0;

        for (Bag bag : bagList) {
            if (checkContents(bag)) {
                bagsThatCanContainGoldShinies++;
            }
        }
        System.out.println(bagsThatCanContainGoldShinies);
    }


    public boolean checkContents(Bag bag) {
        if (bag.contains("shiny gold")) {
            return true;
        }

        for (String containedBagName : bag.getContents()) {
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

        String[] splitRule = rule.split("\\d\\s");
        String[] bagName = splitRule[0].split("\\s");
        Bag bag = new Bag(bagName[0] + " " + bagName[1]);
        for (int i = 1; i < splitRule.length; i++) {
            String[] containedBagName = splitRule[i].split("\\s");
            bag.addContents(containedBagName[0] + " " + containedBagName[1]);
        }
        return bag;
    }

}
