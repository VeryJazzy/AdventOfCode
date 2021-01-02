package Day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getNthNumber(30000000,List.of(0,14,6,20,1,4)));
    }

    public int getNthNumber(int n, List<Integer> turnsOG) {
        HashMap<Integer,Integer> turnsMap = populateMap(n,turnsOG);
        int currentLastNumber = turnsOG.get(turnsOG.size() - 1);

        for (int i = turnsOG.size(); i < n; i++) {
            int nextNumber = calculateNextNumber(turnsMap, currentLastNumber, i - 1);
            turnsMap.put(currentLastNumber,i - 1);
            currentLastNumber = nextNumber;
        }
        return currentLastNumber;
    }

    public static HashMap<Integer, Integer> populateMap(int size, List<Integer> turnsOG) {
        HashMap<Integer,Integer> turnsMap = new HashMap<>(size);
        for (int i = 0; i < turnsOG.size() - 1; i++) {
            turnsMap.put(turnsOG.get(i), i);
        }
        return turnsMap;
    }


    public int calculateNextNumber(HashMap<Integer,Integer> turnsMap, int lastNumber, int currentPosition) {
        Integer indexOfLastNumber = turnsMap.get(lastNumber);
        if (indexOfLastNumber == null ) {
            return 0;
        }
        return currentPosition - indexOfLastNumber;
    }















}
