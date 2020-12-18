package Day6;

import Utility.FileUtil;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.customsForms();
    }

    public void customsForms() {
        String puzzleInput = FileUtil.readFile("C:\\Users\\VeryJazzy\\Desktop\\adventCode1\\Resources\\Day6Input.txt");
        ArrayList<Group> groups = populateGroups(puzzleInput);

        QuestionsAnyoneAnsweredYes(groups);
        QuestionsEveryoneAnsweredYes(groups);
    }


    private ArrayList<Group> populateGroups(String puzzleInput) {
        ArrayList<Group> groups = new ArrayList<Group>();

        for (String g : puzzleInput.split("\r\n\r\n")) {
            Group group = new Group(g);
            groups.add(group);
        }
        return groups;
    }

    public void QuestionsAnyoneAnsweredYes(ArrayList<Group> groups) {

        int sumOfYeses = 0;
        for (Group group : groups) {
            sumOfYeses += countUniqueChars(group);
        }
        System.out.println(sumOfYeses);
    }

    public int countUniqueChars(Group group) {
        Set<Character> uniqueChars = new HashSet<Character>();

        for (Person p : group.getPeople()) {
               uniqueChars.addAll(p.getAnswers());
        }
        return uniqueChars.size();
    }

    public void QuestionsEveryoneAnsweredYes(ArrayList<Group> groups) {
        int sumOfYeses = 0;

        for (Group group : groups) {
            sumOfYeses += countRecurringChars(group);
        }
        System.out.println(sumOfYeses);
    }


    public int countRecurringChars(Group group) {
        ArrayList<Character> firstPersonsAnswers = group.getPeople().get(0).getAnswers();
        HashSet<Character> possibleRecurringAnswers = new HashSet<Character>(firstPersonsAnswers);

        for (Person person : group.getPeople()) {

            Iterator<Character> iterator = possibleRecurringAnswers.iterator();
            while (iterator.hasNext()) {
                char answer = iterator.next();
                if (!person.getAnswers().contains(answer)) {
                    iterator.remove();
                }
            }
        }
        return possibleRecurringAnswers.size();
    }











}
