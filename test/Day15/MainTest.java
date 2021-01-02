package Day15;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {


    @Test
    void ifPreviousNumberWasTheFirstTimeSpokenGive0() {
        ArrayList<Integer> turns = new ArrayList<>(Arrays.asList(0,3,6));
        Main main = new Main();
        int nextNumber = main.nextNumber(turns);
        assertEquals(0,nextNumber);
    }

    @Test
    void ifPreviousNumberSpokenBefore_HowManyTurnsApartFromLastTimeBeforeThatSpoken() {
        ArrayList<Integer> turns = new ArrayList<>(Arrays.asList(0,3,6,0));
        Main main = new Main();
        int nextNumber = main.nextNumber(turns);
        assertEquals(3,nextNumber);
    }

    @Test
    void acceptanceTest() {
        Main main = new Main();
        assertEquals(4,main.getNthNumber(9,List.of(0,3,6)));
        assertEquals(0,main.getNthNumber(10,List.of(0,3,6)));
        assertEquals(4,main.getNthNumber(9,List.of(0,3,6)));
    }


    @Test
    void part1Working() {
        Main main = new Main();
        assertEquals(436,main.getNthNumber(2020,List.of(0,3,6)));
        assertEquals(1836,main.getNthNumber(2020,List.of(3,1,2)));
    }
///////////////////////////////////////////////////////////////////////////////////////
    @Test
    void part2Working() {
        Main main = new Main();
        assertEquals(175594,main.getNthNumber(1000000,List.of(0,3,6)));
    }






}