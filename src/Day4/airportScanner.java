package Day4;


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
        }if (passport.getHgt() == null) {
            return false;
        }
        return true;
    }

//    public boolean checkFields(Passport passport) {
////        for (Map.Entry<String, String> entry : passport.getDataMap().entrySet()) {
//
//            switch (entry.getKey()) {
//                case "byr":
//                    if (!(checkByr(entry.getValue()))) {
//                        return false;
//                    }
//                    break;
//                case "iyr":
//                    if (!(checkIyr(entry.getValue()))) {
//                        return false;
//                    }
//                    break;
//                case "eyr":
//                    if (!(checkEyr(entry.getValue()))) {
//                        return false;
//                    }
//                    break;
//                case "hgt":
//                    if (!(checkHgt(entry.getValue()))) {
//                        return false;
//                    }
//                    break;
//                case "hcl":
//                    if (!(checkHcl(entry.getValue()))) {
//                        return false;
//                    }
//                    break;
//                case "ecl":
//                    if (!(checkEcl(entry.getValue()))) {
//                        return false;
//                    }
//                    break;
//                case "pid":
//                    if (!(checkPid(entry.getValue()))) {
//                        return false;
//                    }
//                    break;
//            }
//
//        }
//        return true;
//
//
//    }

    public boolean checkByr(String info) {
        if (Integer.parseInt(info) > 1920 && Integer.parseInt(info) < 2002) {
            return true;
        }
        return false;
    }

    public boolean checkIyr(String info) {
        if (Integer.parseInt(info) > 2010 && Integer.parseInt(info) < 2020) {
            return true;
        }
        return false;
    }

    public boolean checkEyr(String info) {
        if (Integer.parseInt(info) > 2020 && Integer.parseInt(info) < 2030) {
            return true;
        }
        return false;
    }


    public boolean checkHgt(String info) {
        String measurement = info.substring(info.length() - 2);
        int value = Integer.parseInt(info.substring(0,info.length() - 2));
        if (measurement.equals("cm")) {
            if (value > 150 && value < 193) {
                return true;
            }
        } else if (measurement.equals("in")) {
            if (value > 59 && value < 76) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHcl(String info) {
        if (info.matches("#.{6}")) {
            return true;
        }
        return false;
    }

    public boolean checkEcl(String info) {
        if (info.equals("amb") || info.equals("blue") || info.equals("brn") || info.equals("gry") || info.equals("grn") || info.equals("hzl") || info.equals("oth")) {
            return true;
        }
        return false;
    }

    public boolean checkPid(String info) {
        if (info.matches("\\d{9}")) {
            return true;
        }
        return false;
    }


}
