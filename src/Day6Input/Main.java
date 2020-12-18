package Day6Input;

import Utility.FileUtil;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.customsForms();
    }

    public void customsForms() {
        String puzzleInput = FileUtil.readFile("C:\\Users\\VeryJazzy\\Desktop\\adventCode1\\Resources\\Day6Input.txt");
        String[] groups = puzzleInput.split("\r\n\r\n");

        part1(groups);

        part2(groups);
    }

    public void part1(String[] groups) {
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




























    public void part2(String[] groups) {
        int sumOfYeses = 0;

        for (String group : groups) {
            sumOfYeses += countIfEveryoneSaysYesToAQuestion(group);
        }
        System.out.println(sumOfYeses);
    }


    public int countIfEveryoneSaysYesToAQuestion(String group) {
        String[] people = group.split("\r\n");
        HashSet<Character> charsToCompare = new HashSet<>(stringToCharArrList(people[0]));

        for (String person : people) {
             ArrayList<Character> personArrList = stringToCharArrList(person);
             ArrayList<Character> toRemove = new ArrayList<Character>();
             for (char c : charsToCompare) {
                 if (!personArrList.contains(c)) {
                     toRemove.add(c);
                 }
             }
             charsToCompare.removeAll(toRemove);
        }

        return charsToCompare.size();
    }

    public ArrayList<Character> stringToCharArrList(String s) {
        ArrayList<Character> arrList = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            arrList.add(c);
        }
        return arrList;
    }







}
