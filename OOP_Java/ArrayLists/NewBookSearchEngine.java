import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NewBookSearchEngine {

	public static void main(String[] args) throws IOException{
		
		BookList BL = new BookList(5);
		System.out.println(BL.isEmpty());
		
		File input = new File("bookInput.txt");
		Scanner s1 = new Scanner(input);
		while (s1.hasNextLine()) {

			String s = s1.nextLine();
			String[] info = s.split(",");

			Book b = new Book(info[0], info[1], Double.parseDouble(info[2]));

			BL.add(b);

		}
		
		s1.close();
		
		System.out.println(BL);
		System.out.println();
//		
		Book b0 = new Book("Intro to HTML", "James", 029.490);
		System.out.println(BL.isThere(b0));
		System.out.println(BL.search(b0));
//		BL.add(b0);
		BL.remove(b0);
		
		System.out.println(BL);
		System.out.println( );
		System.out.println(BL.size());
		
		Book b1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K.Rowling", 29.99);
		BL.add(b1, 3);
		System.out.println(BL);
		System.out.println(BL.size());
		

	}

}