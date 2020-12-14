package Day4;

import java.util.List;

public class airportScanner {


    public boolean requiredFields(Passport passport) {
        if (passport.getEcl() == null) {
            return false;
        }
        if (passport.getEyr() == null) {
            return false;
        }
        if (passport.getHcl() == null) {
            return false;
        }
        if (passport.getPid() == null) {
            return false;
        }
        if (passport.getIyr() == null) {
            return false;
        }
        if (passport.getByr() == null) {
            return false;
        }
        if (passport.getHgt() == null) {
            return false;
        }
        return true;
    }

    public boolean checkFields(Passport passport) {
        if (!checkHcl(passport.getHcl())) {
            return false;
        }
        if (!checkHgt(passport.getHgt())) {
            return false;
        }
        if (!checkEyr(passport.getEyr())) {
            return false;
        }
        if (!checkIyr(passport.getIyr())) {
            return false;
        }
        if (!checkPid(passport.getPid())) {
            return false;
        }
        if (!checkByr(passport.getByr())) {
            return false;
        }
        if (!checkEcl(passport.getEcl())) {
            return false;
        }
        return true;
    }

    private boolean checkNumberRange(String info, int i, int i2) {
        try {
            if (Integer.parseInt(info) >= i && Integer.parseInt(info) <= i2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkByr(String info) {
        return checkNumberRange(info, 1920, 2002);
    }

    public boolean checkIyr(String info) {
        return checkNumberRange(info, 2010, 2020);
    }

    public boolean checkEyr(String info) {
        return checkNumberRange(info, 2020, 2030);
    }

    public boolean checkHgt(String info) {
        try {
            String measurement = info.substring(info.length() - 2);
            int value = Integer.parseInt(info.substring(0, info.length() - 2));
            if (measurement.equals("cm")) {
                if (value >= 150 && value <= 193) {
                    return true;
                }
            } else if (measurement.equals("in")) {
                if (value >= 59 && value <= 76) {
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }

    public boolean checkHcl(String info) {
        return info.matches("#[0-9a-f]{6}");
    }

    public boolean checkEcl(String info) {
       return List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(info);
    }

    public boolean checkPid(String info) {
        return info.matches("\\d{9}");
    }


}
