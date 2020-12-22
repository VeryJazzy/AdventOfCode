package Day7;

public class SomeClass {

    public int countInnerBags(String rule) {
        //now with our new tests we will need to start turning the rules into bag objects

        String[] splitRule = rule.split("\\s");
        if (splitRule[4].equals("no")) {
            return 0;
        }
        int count = 0;
        for (int i = 4; i < splitRule.length; i += 4) {
            count += Integer.parseInt(splitRule[i]);
        }
        return count;
    }



}
