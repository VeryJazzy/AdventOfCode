package Day5;

public class BoardingPass {

    private int row;
    private int column;
    private int id;

    public BoardingPass(String seat) {
        this.row = findRow(seat.substring(0,7));
        this.column = findColumn(seat.substring(7));
        this.id = row * 8 + column;
    }

    private int findRow(String rowSubstring) {
        char[] ticketRow = rowSubstring.toCharArray();
        return binaryPartitionSearch(ticketRow,0,127,'F');
    }

    private int findColumn(String columnSubstring) {
        char[] ticketColumn = columnSubstring.toCharArray();
        return binaryPartitionSearch(ticketColumn,0,7,'L');
    }

    private int binaryPartitionSearch(char[] axisArray, int low, int high, char frontOrLeft) {
        int middle = (high + low) / 2;

        for (char direction : axisArray) {
            if (direction == frontOrLeft) {
                high = middle;
            } else {
                low = middle + 1;
            }
            middle = (high + low) / 2;
        }
        return high;
    }


    @Override
    public String toString() {
        return "BoardingPass{" +
                "row=" + row +
                ", column=" + column +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }
}
