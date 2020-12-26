package Day8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class aClassTest {

    @Test
    void whenRulesAreAccPosOnlyAddThemUp() {
        String[] rules = {"acc +100", "acc +1", "acc +20"};
        Counter counter = new Counter();
        assertEquals(121, counter.countAccumulator(rules));
    }

    @Test
    void whenRulesAreAccPosAndNegAddThemUp() {
        String[] rules = {"acc +1", "acc +1", "acc +2", "acc -10", "acc +15", "acc -10"};
        Counter counter = new Counter();
        assertEquals(-1, counter.countAccumulator(rules));
    }

    @Test
    void skipsOpWhenRuleIsNop() {
        String[] rules = {"acc +1", "nop +0", "acc +2", "nop +0", "acc +15", "acc -10"};
        Counter counter = new Counter();
        assertEquals(8, counter.countAccumulator(rules));
    }

    @Test
    void singleJumpTest() {
        String[] rules = {"acc +1", "jmp +2", "acc +2", "acc +3", "acc +10"};
        Counter counter = new Counter();
        assertEquals(14, counter.countAccumulator(rules));
    }

    @Test
    void doubleJumpTest() {
        String[] rules = {"acc +1", "jmp +2", "acc +2", "acc +3", "acc +10", "jmp +3", "acc +3", "acc +10", "acc +10"};
        Counter counter = new Counter();
        assertEquals(24, counter.countAccumulator(rules));
    }

//    @Test
//    void backwardsJumpShouldEndProgram() {
//        String[] rules = {"acc +1", "acc +2", "acc +3", "jmp -3", "acc +10"};
//        Counter counter = new Counter();
//        assertEquals(6, counter.countAccumulator(rules));
//    }

    @Test
    void changeJumpToNopToContinue() {
        String[] rules = {"acc +1", "acc +2", "acc +3", "jmp -3", "acc +10"};
        Counter counter = new Counter();
        assertEquals(16, counter.countAccumulator(rules));
    }


}