package Day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeClassTest {

    @Test
    void ifShinyGoldIsEmptyReturn0() {
        String rule = "shiny gold bags contain no other bags.";
        SomeClass someClass = new SomeClass();
        assertEquals(0,someClass.countInnerBags(rule));
    }

    @Test
    void ifShinyGoldContainsOneBagTypeCountBagType() {
        String rule = "shiny gold bags contain 2 dark red bags.";
        SomeClass someClass = new SomeClass();
        assertEquals(2,someClass.countInnerBags(rule));
    }

    @Test
    void ifShinyGoldContainsTwoBagTypesCountBagTypes() {
        String rule = "mirrored beige bags contain 4 pale gold bags, 1 pale aqua bag.";
        SomeClass someClass = new SomeClass();
        assertEquals(5,someClass.countInnerBags(rule));
    }

    @Test
    void ifShinyGoldContainsThreeBagTypesCountBagTypes() {
        String rule = "dark brown bags contain 5 shiny gold bags, 3 faded crimson bags, 1 mirrored gray bag.";
        SomeClass someClass = new SomeClass();
        assertEquals(9,someClass.countInnerBags(rule));
    }

    @Test
    void ifShinyGoldContainsFourBagTypesCountBagTypes() {
        String rule = "shiny lavender bags contain 5 vibrant magenta bags, 1 bright turquoise bag, 2 shiny beige bags, 4 pale tan bags.";
        SomeClass someClass = new SomeClass();
        assertEquals(12,someClass.countInnerBags(rule));
    }

    @Test
    void BagsAreTurnedIntoBagObjects() {
        String rule = "shiny lavender bags contain 5 vibrant magenta bags, 1 bright turquoise bag, 2 shiny beige bags, 4 pale tan bags.";
        SomeClass someClass = new SomeClass();
        assertEquals(12,someClass.countInnerBags(rule));
    }

//    @Test
//    void ifAContainedBagIsInTheRulesReadTheInnerBagAswell() {
//        String rule = "shiny gold bags contain 1 dark red bags.\r\ndark red bags contain no other bags.";
//        SomeClass someClass = new SomeClass();
//        assertEquals(1,someClass.countInnerBags(rule));
//    }
}