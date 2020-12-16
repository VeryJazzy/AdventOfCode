package Day6Input;

import Utility.FileUtil;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.customsForms();
    }

    public void customsForms() {
        String puzzleInput = FileUtil.readFile("C:\\Users\\VeryJazzy\\Desktop\\adventCode1\\Resources\\Day6Input.txt");
        String[] groups = puzzleInput.split("\r\n\r\n");

        int sumOfYeses = 0;
        for (String group : groups) {
            sumOfYeses += countYeses(group);
        }
        System.out.println(sumOfYeses);


    }

    public int countYeses(String group) {
        Set<Character> uniqueChars = new HashSet<Character>();
        for (char c : group.toCharArray()) {
            if (c != '\r' && c != '\n') {
                uniqueChars.add(c);
            }
        }
        return uniqueChars.size();
    }
}
