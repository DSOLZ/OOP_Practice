import java.util.Random;
import java.util.Scanner;

public class EstimatePi {

	public static double estimatedPi(int tries) {

		Random myRandom = new Random(123456789);
		int hits = 0;
		for (int i = 0; i < tries; i++) {
			
			double x = myRandom.nextDouble() * 2 -1;
			double y = myRandom.nextDouble() * 2 -1;
			
			if (x*x + y*y <=1) {
				hits ++;
			}
		}
		
		double pi = 4. * hits / tries;
		return pi;
	}

	public static void main(String[] args) {

		
		Scanner myConsole = new Scanner(System.in);
		int tries = myConsole.nextInt();
		System.out.println(estimatedPi(tries));
		myConsole.close();

	}

}