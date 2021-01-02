package Day15;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {


    @Test
    void ifPreviousNumberWasTheFirstTimeSpokenGive0() {
        ArrayList<Integer> turns = new ArrayList<>(Arrays.asList(0,3,6));
        Main main = new Main();
        int nextNumber = main.getNthNumber(4, turns);
        assertEquals(0,nextNumber);
    }

    @Test
    void ifPreviousNumberSpokenBefore_HowManyTurnsApartFromLastTimeBeforeThatSpoken() {
        ArrayList<Integer> turns = new ArrayList<>(Arrays.asList(0,3,6,0));
        Main main = new Main();
        int nextNumber = main.getNthNumber(5, turns);
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
    void parseListToMap() {
        HashMap<Integer,Integer> hm = Main.populateMap(4, List.of(1,2,3,4,4,5));
        assertEquals(0, hm.get(1));
        assertEquals(1, hm.get(2));
        assertEquals(2, hm.get(3));
        assertEquals(4, hm.get(4));
        assertEquals(null,hm.get(5));
    }

    @Test
    void part2Working() {
        Main main = new Main();
        assertEquals(175594,main.getNthNumber(30000000,List.of(0,3,6)));
    }






}