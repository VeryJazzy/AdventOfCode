package Day4;

public class Passport {

    private String ecl;
    private String eyr;
    private String hcl;
    private String pid;
    private String iyr;
    private String cid;
    private String byr;
    private String hgt;

    public Passport(String dataString) {
        String[] linedData = dataString.split("\\s");
        populateFields(linedData);
    }

    private void populateFields(String[] linedData) {
        for (String line : linedData) {
            String info = line.substring(4);
            switch (line.substring(0,3)) {
                case "ecl":
                    this.ecl = info;
                    break;
                case "eyr":
                    this.eyr = info;
                    break;
                case "hcl":
                    this.hcl = info;
                    break;
                case "pid":
                    this.pid = info;
                    break;
                case "iyr":
                    this.iyr = info;
                    break;
                case "cid":
                    this.cid = info;
                    break;
                case "byr":
                    this.byr = info;
                    break;
                case "hgt":
                    this.hgt = info;
                    break;
            }
        }
    }


    public String getEcl() {
        return ecl;
    }

    public String getEyr() {
        return eyr;
    }

    public String getHcl() {
        return hcl;
    }

    public String getPid() {
        return pid;
    }

    public String getIyr() {
        return iyr;
    }

    public String getCid() {
        return cid;
    }

    public String getByr() {
        return byr;
    }

    public String getHgt() {
        return hgt;
    }
}
