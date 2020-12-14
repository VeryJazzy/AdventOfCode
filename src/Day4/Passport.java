package Day4;

import java.util.HashMap;

public class Passport {

    private HashMap<String,String> dataMap;

    public Passport(String dataString) {
        String[] linedData = dataString.split("\\s");
        this.dataMap = generateMap(linedData);
    }

    public HashMap<String,String> generateMap(String[] linedData) {
        HashMap<String,String> dataMap = new HashMap<String,String>();
        for (String line : linedData) {
            dataMap.put(line.substring(0,3),line.substring(4));
        }
        return dataMap;
    }


    public HashMap<String, String> getDataMap() {
        return dataMap;
    }
}
