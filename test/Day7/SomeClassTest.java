package Day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeClassTest {

    @Test
    void ifShinyGoldIsEmptyReturn0() {
        String rule = "shiny gold bags contain no other bags.";
        Main main = new Main();
        main.start(rule);
        Bag shinyGoldBag = main.turnRuleIntoBag(rule);
        assertEquals(0, main.countInnerBags(shinyGoldBag));
    }

    @Test
    void ifShinyGoldContainsOneBagTypeCountBagType() {
        String rule = "shiny gold bags contain 2 dark red bags.";
        Main main = new Main();
        main.start("shiny gold bags contain 2 dark red bags.\r\ndark red bags contain no other bags");
        Bag shinyGoldBag = main.turnRuleIntoBag(rule);
        assertEquals(2, main.countInnerBags(shinyGoldBag));
    }


    @Test
    void ifShinyGoldContainsMultipleBagTypesCountBagTypes() {
        String rule = "shiny gold bags contain 5 vibrant magenta bags, 1 bright turquoise bag, 2 shiny beige bags, 4 pale tan bags.";
        Main main = new Main();
        main.start("shiny gold bags contain 5 vibrant magenta bags, 1 bright turquoise bag, 2 shiny beige bags, 4 pale tan bags.\r\nvibrant magenta bags contain no other bags\r\nbright turquoise bags contain no other bags\r\nshiny beige bags contain no other bags\r\npale tan bags contain no other bags");
        Bag shinyGoldBag = main.turnRuleIntoBag(rule);
        assertEquals(12, main.countInnerBags(shinyGoldBag));
    }


    @Test
    void IfAContainedBagAlsoContainsBagsCountThemAsWell() {
        String rule = "shiny gold bags contain 5 vibrant magenta bags";
        Main main = new Main();

        main.start("shiny gold bags contain 5 vibrant magenta bags.\r\n" +
                "vibrant magenta bags contain 2 blood red bags\r\n" +
                "blood red bags contain no other bags.");

        Bag shinyGoldBag = main.turnRuleIntoBag(rule);
        int result = main.countInnerBags(shinyGoldBag);
        assertEquals(15,result);
    }

    @Test
    void finalTest() {
        Main main = new Main();
        main.start("shiny gold bags contain 2 dark red bags.\r\n" +
                "dark red bags contain 2 dark orange bags.\r\n" +
                "dark orange bags contain 2 dark yellow bags.\r\n" +
                "dark yellow bags contain no other bags.");

        Bag shinyGoldBag = main.turnRuleIntoBag("shiny gold bags contain 2 dark red bags.");
        assertEquals(14,main.countInnerBags(shinyGoldBag));
    }

    @Test
    void finalTest2() {
        Main main = new Main();
        main.start("shiny gold bags contain 2 dark red bags.\r\n" +
                "dark red bags contain 2 dark orange bags.\r\n" +
                "dark orange bags contain 2 dark yellow bags.\r\n" +
                "dark yellow bags contain 2 dark green bags.\r\n" +
                "dark green bags contain 2 dark blue bags.\r\n" +
                "dark blue bags contain 2 dark violet bags, 4 dark black bags.\r\n" +
                //if contains.length = 2 times them
                "dark black bags contain no other bags.\r\n" +
                "dark violet bags contain no other bags.");
        Bag shinyGoldBag = main.turnRuleIntoBag("shiny gold bags contain 2 dark red bags.");
        assertEquals(254,main.countInnerBags(shinyGoldBag));
    }


    @Test
    void finalTest3() {
        Main main = new Main();
        main.start("""
                shiny gold bags contain 2 dark blue bags, 4 dark black bags.\r
                dark black bags contain 4 dark blue bags, 3 green g bags.\r
                dark blue bags contain no other bags.\r
                green g bags contain no other bags.""");
        Bag shinyGoldBag = main.turnRuleIntoBag("shiny gold bags contain 2 dark blue bags, 4 dark black bags.");
        assertEquals(34,main.countInnerBags(shinyGoldBag));
    }
}