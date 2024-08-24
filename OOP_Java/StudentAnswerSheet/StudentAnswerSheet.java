import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StudentAnswerSheet {

	private static char[] key;

	public static void setKey(String data) {
		String[] elements = data.split(",");

        if (elements[0].equals("KEY")) {
			key = new char[elements.length];
			for (int i = 1; i < elements.length; i++) {
				key[i-1] = elements[i].charAt(0);
			}
		}
	}

	public static double getScore(char[] ans) {
		double score = 0;
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == key[i]) {
				score += 1;
			} else if (ans[i] == '?') {
				score += 0;
			} else {
				score -= 0.25;
			}
		}

		return score;
	}

	public static void main(String[] args) throws IOException{
        
        double highestScore = Integer.MIN_VALUE;
        String bestStudents = "";

        File answerSheet = new File("answers1.txt");
        Scanner myScanner = new Scanner(answerSheet);

        String data = myScanner.nextLine();
        //System.out.println(data);
        setKey(data);

        String output = "";

        while (myScanner.hasNextLine()){
            data = myScanner.nextLine();
            String [] info = data.split(",");

            String name = info[0];
            char [] answers = new char[info.length-1];

            for(int i = 1; i < info.length; i++){
                answers [i-1] = info[i].charAt(0);
            }
            double score = getScore(answers);
            if(score > highestScore) {
                highestScore = score;
                bestStudents = name;
            } else if (score == highestScore) {
                bestStudents +=" " + name;
            }

            output += name;
            for (char answer : answers ){
                output += " " + answer;
            }
            output += " score = " + score + "\n";
        }

        output += "Best Student(s): " + bestStudents;
        System.out.println(output);
	}


}