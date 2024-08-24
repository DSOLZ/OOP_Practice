import java.io.*;

public class WriterTests {

	public static void main(String[] args) {

		File text1 = new File("text1.txt");
		File text2 = new File("text2.txt");
		File text3 = new File("text3.txt");
		try {

			
		//Comparing the performance of a FileWriter and a BufferedWriter
			double start1 = System.nanoTime();
			FileWriter fw1 = new FileWriter(text1);

			for (int i = 0; i < Math.pow(2, 20); i++) {
				fw1.write(i + "");
			}

			fw1.close();
			double end1 = System.nanoTime();
			System.out.println(end1 - start1);
			
			
			double start2 = System.nanoTime();
			
			FileWriter fw2 = new FileWriter(text2);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			//BufferedWriter is constructed on another Writer object
			
			for (int i = 0; i < Math.pow(2, 20); i++) {
				bw2.write(i + "");
			}

			bw2.close();
			double end2 = System.nanoTime();
			System.out.println(end2 - start2);
			
		//bw3 overwrites a file
			FileWriter fw3 = new FileWriter(text3);
			BufferedWriter bw3 = new BufferedWriter(fw3);
			
			bw3.write("This is also line 1. ");
			bw3.newLine();
			bw3.write("This is also line 2. ");
			
			bw3.close();
			
		//bw4 appends a file
			FileWriter fw4 = new FileWriter(text3, true);
			BufferedWriter bw4 = new BufferedWriter(fw4);
			
			bw4.newLine();
			bw4.write("This is line 3.");
			
			
			bw4.close();
			
		} catch (IOException ioe) {
			System.out.println("text1 doesn't exist.");
		}

	}

}