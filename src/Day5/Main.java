package Day5;

import Utility.FileUtil;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.seatScanner();
    }

    public void seatScanner() {
        String puzzleInput = FileUtil.readFile("C:\\Users\\VeryJazzy\\Desktop\\adventCode1\\Resources\\day5.txt");
        String[] boardingPasses = puzzleInput.split("\n");
        ArrayList<Integer> seatIDs = new ArrayList<Integer>();

        int largestSeatID = 0;
        for (String seat : boardingPasses) {
            BoardingPass bp = new BoardingPass(seat);
            seatIDs.add(bp.getId());
            if (bp.getId() > largestSeatID) {
                largestSeatID = bp.getId();
            }
        }
        System.out.println("Largest seat ID: " + largestSeatID);

        int mySeatID = findMySeat(seatIDs);
        System.out.println("My seat ID: " + mySeatID);
    }


    public int findMySeat(ArrayList<Integer> seatIDs) {
        Collections.sort(seatIDs);

        for (int i = 0; i < seatIDs.size(); i++) {
            System.out.println(seatIDs.get(i));
        }


        return 0;
    }


}

