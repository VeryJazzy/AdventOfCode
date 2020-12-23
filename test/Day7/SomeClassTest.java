package Day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeClassTest {

    @Test
    void ifShinyGoldIsEmptyReturn0() {
        String rule = "shiny gold bags contain no other bags.";
        Main main = new Main();
        main.start(rule);
        assertEquals(0, main.countInnerBags(rule));
    }

    @Test
    void ifShinyGoldContainsOneBagTypeCountBagType() {
        String shinyGoldRule = "shiny gold bags contain 2 dark red bags.";
        Main main = new Main();
        main.start("shiny gold bags contain 2 dark red bags.\r\ndark red bags contain no other bags");
        assertEquals(2, main.countInnerBags(shinyGoldRule));
    }


    @Test
    void ifShinyGoldContainsMultipleBagTypesCountBagTypes() {
        String rule1 = "shiny gold bags contain 5 vibrant magenta bags, 1 bright turquoise bag, 2 shiny beige bags, 4 pale tan bags.";
        Main main = new Main();
        main.start("shiny gold bags contain 5 vibrant magenta bags, 1 bright turquoise bag, 2 shiny beige bags, 4 pale tan bags.\r\nvibrant magenta bags contain no other bags\r\nbright turquoise bags contain no other bags\r\nshiny beige bags contain no other bags\r\npale tan bags contain no other bags");
        assertEquals(12, main.countInnerBags(rule1));
    }


    @Test
    void IfAContainedBagAlsoContainsBagsCountThemAsWell() {
        String rule = "shiny gold bags contain 5 vibrant magenta bags";
        Main main = new Main();

        main.start("shiny gold bags contain 5 vibrant magenta bags.\r\nvibrant magenta bags contain 2 blood red bags");
        assertEquals(7,main.countInnerBags(rule));
    }

}