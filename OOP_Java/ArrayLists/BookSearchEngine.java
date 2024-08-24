import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class BookSearchEngine {
	
	public static void main(String[] args) throws IOException {
		BookStore bs = new BookStore("bookInput.txt");
		System.out.println("Our book collection is:");
		System.out.println(bs);
		System.out.println();

//		String keyword = JOptionPane.showInputDialog(null, "Enter a keyword to search for");
//		ArrayList<Book> results = bs.searchForTitle(keyword);
//		System.out.println("The search results for " + keyword + " are:");
//		System.out.println(results);
//		
//		for (Book b: results) {
//			b.setAuthor("Xiaolang");
//		}
//		System.out.println(bs);
		
		
//		bs.deleteFromBookstore("Intro");
		bs.sortByAuthor();
		System.out.println(bs);
		System.out.println();
		
		bs.sortByTitle();
		System.out.println(bs);
		System.out.println();
		
		bs.sortByPrice();
		System.out.println(bs);
		System.out.println();

	}
}