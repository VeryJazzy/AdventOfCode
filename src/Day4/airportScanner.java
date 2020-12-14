package Day4;

public class airportScanner {

    private String[] requiredFields = {"ecl", "eyr", "hcl", "pid", "iyr", "byr", "hgt"};

    public boolean validatePassport(Passport passport) {
        for (String field : requiredFields) {
            if (!(passport.getDataMap().containsKey(field))) {
                return false;
            }
        }
        return true;
    }









}
