package Day6Input;

import java.util.ArrayList;

public class Person {

    private ArrayList<Character> answers;

    public Person(String answers) {
      this.answers = extractAnswers(answers);
    }

    private ArrayList<Character> extractAnswers(String answers) {
        ArrayList<Character> charArr = new ArrayList<Character>();
        for (char c : answers.toCharArray()) {
            charArr.add(c);
        }
        return charArr;
    }

    public ArrayList<Character> getAnswers() {
        return answers;
    }

}

