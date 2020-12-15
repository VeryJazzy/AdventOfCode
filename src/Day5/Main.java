package Day5;

import Utility.FileUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.seatScanner();
    }

    public void seatScanner() {
        String puzzleInput = FileUtil.readFile("C:\\Users\\VeryJazzy\\Desktop\\adventCode1\\Resources\\day5.txt");
        String[] boardingPasses = puzzleInput.split("\n");
        ArrayList<BoardingPass> bpList = new ArrayList<BoardingPass>();

        int largestSeatID = 0;
        for (String seat : boardingPasses) {
            BoardingPass bp = new BoardingPass(seat);
            bpList.add(bp);
            if (bp.getId() > largestSeatID) {
                largestSeatID = bp.getId();
            }
        }
        System.out.println("Largest seat ID: " + largestSeatID);

        int mySeatID = findMySeat(bpList);
        System.out.println("My seat ID: " + mySeatID);
    }


    public int findMySeat(ArrayList<BoardingPass> bpList) {
        Collections.sort(bpList, new BoardingPassComparator());

        int IDCounter = bpList.get(0).getId();
        for (int i = 0; i < bpList.size(); i++) {
            if (bpList.get(i).getId() != IDCounter) {
                return IDCounter;
            }
            IDCounter++;
        }
        throw new RuntimeException("oh no");
    }

    static class BoardingPassComparator implements Comparator<BoardingPass> {
        @Override
        public int compare(BoardingPass o1, BoardingPass o2) {
            return Comparator.comparing(BoardingPass::getId).compare(o1, o2);
        }
    }
}

