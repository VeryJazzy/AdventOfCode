package Day3;

public class Day3Skier {

    private String[] skiMap;
    private int currentDown;
    private int currentAcross;

    public Day3Skier(String[] skiMap) {
        this.skiMap = skiMap;
        this.currentDown = 0;
        this.currentAcross = 0;
    }

    public long checkRoute(int distanceAcross, int distanceDown) {
        int trees = 0;

        while (currentDown < skiMap.length) {
            if (skiMap[currentDown].charAt(currentAcross) == '#') {
                trees++;
            }
            moveToNextLocation(distanceAcross, distanceDown);
            generateMap();
        }

        resetSkier();
        return trees;
    }

    public void moveToNextLocation(int distanceAcross, int distanceDown) {
        currentAcross += distanceAcross;
        currentDown += distanceDown;
    }

    public void generateMap() {
            currentAcross = currentAcross % skiMap[0].length();
    }

    public void resetSkier() {
        currentAcross = 0;
        currentDown = 0;
    }
}
