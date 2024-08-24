import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {

	private ArrayList<Book> bookList;

	public BookStore(String fileName) throws IOException {

		bookList = new ArrayList<Book>();

		File input = new File(fileName);
		Scanner s1 = new Scanner(input);

		while (s1.hasNextLine()) {

			String s = s1.nextLine();
			String[] info = s.split(",");

			Book b = new Book(info[0], info[1], Double.parseDouble(info[2]));

			bookList.add(b);

		}

		s1.close();
	}

	public String toString() {

		String output = "[";
//		for (Book b: bookList) {
//			
//			output += b.toString();
//			
//		}

		for (int i = 0; i < bookList.size(); i++) {

			output += bookList.get(i).toString();

			if (i != bookList.size() - 1) {
				output += ",\n";
			} else {
				output += "]";
			}

		}

		return output;

	}

	public ArrayList<Book> searchForTitle(String keyword) {

		ArrayList<Book> output = new ArrayList<Book>();

		for (Book b : bookList) {

			if (b.getTitle().contains(keyword)) {
				output.add(b.clone());
			}

		}

		return output;

	}

	public void deleteFromBookstore(String keyword) {
		
//		for (int j = 0; j< bookList.size();j++) {
//			for (int i = 0; i < bookList.size(); i++) {
//				if (bookList.get(i).getTitle().contains(keyword)) {
//					bookList.remove(i);
//				}
//			}
//		}
		
		ArrayList<Book> toRemove = new ArrayList<Book>();

		for (Book b : bookList) {

			if (b.getTitle().contains(keyword)) {
				toRemove.add(b);
			}

		}
		
		bookList.removeAll(toRemove);

	}
	
	public void sortByAuthor() {
		bookList.sort(null);
	}
	
	public void sortByTitle() {
		bookList.sort(new CompareTitle());
	}

	public void sortByPrice() {
		bookList.sort(new ComparePrice().reversed());
	}
}