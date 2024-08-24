import java.util.Comparator;

public class ComparePrice implements Comparator<Book>{

	public int compare(Book b1, Book b2) {
		return (int)(b1.getPrice() - b2.getPrice());
	}
	
}