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

    @Test //part 1 test
    void backwardsJumpShouldEndProgram() {
        String[] rules = {"acc +1", "acc +2", "acc +3", "jmp -3", "acc +10"};
        Counter counter = new Counter();
        assertEquals(-1, counter.countAccumulator(rules));
    }

//    @Test
//    void inInstructionsChangeJmpToNop() {
//        String[] instructions = {"acc +1", "acc +2", "acc +3", "jmp -3", "acc +10"};
//        int i = 3;
//        Counter counter = new Counter();
//        String[] changedInstructions = counter.swapOperation(instructions, i);
//
//        assertEquals("nop -3", changedInstructions[i]);
//    }
//
//    @Test
//    void inInstructionsChangeNopToJmp() {
//        String[] instructions = {"acc +1", "acc +2", "acc +3", "nop -3", "acc +10"};
//        int i = 3;
//        Counter counter = new Counter();
//        String[] changedInstructions = counter.swapOperation(instructions, i);
//
//        assertEquals("jmp -3", changedInstructions[i]);
//    }

    @Test
    void changeJmpToNopToFinish() {
        String[] rules = {"acc +1", "acc +2", "acc +3", "jmp -3", "acc +10"};
        Counter counter = new Counter();
        assertEquals(16, counter.findCorrectAccumulatorNumber(rules));
    }

    @Test
    void changeNopToJmpToFinish() {
        String[] rules = {"acc +1", "acc +2", "acc +3", "nop +2", "jmp -3", "acc +1"};
        Counter counter = new Counter();
        assertEquals(7, counter.findCorrectAccumulatorNumber(rules));
    }
    @Test
    void changeAnotherJmpToNop() {
        String[] rules = {"nop +0", "acc +1" ,"jmp +4" ,"acc +3", "jmp -3" ,"acc -99" ,"acc +1" ,"jmp -4" ,"acc +6"};
        Counter counter = new Counter();
        assertEquals(8, counter.findCorrectAccumulatorNumber(rules));
    }







}