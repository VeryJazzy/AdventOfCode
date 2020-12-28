package Day8;

import Utility.FileUtil;

public class Main {
    public static void main(String[] args) {
        String switchBootCode = FileUtil.readFile("C:\\Users\\VeryJazzy\\Desktop\\adventCode1\\Resources\\Day8Input.txt");
        String[] instructions = switchBootCode.split("\r\n");

        Counter counter = new Counter();
        System.out.println(counter.findCorrectAccumulatorNumber(instructions));
    }

}
