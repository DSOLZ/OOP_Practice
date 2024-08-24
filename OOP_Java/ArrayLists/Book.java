
public class Book implements Comparable<Book> {
	private String title;
	private String author;
	private double price;

	public Book() {
		setTitle("Default Title");
		setAuthor("Default Author");
		setPrice(10);
	}

	public Book(String newTitle, String newAuthor, double newPrice) {
		setTitle(newTitle);
		setAuthor(newAuthor);
		setPrice(newPrice);
	}

	public Book clone() {
		Book newBook = new Book(this.getTitle(), this.getAuthor(), this.getPrice());
		return newBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String t) {
		if (t != null)
			title = t;
	}

	public void setAuthor(String a) {
		if (a != null)
			author = a;
	}

	public void setPrice(double p) {
		if (p > 0)
			price = p;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public int compareTo(Book that) {
		return this.author.compareTo(that.author);
	}

	public boolean equals (Book that) {
		return title.equals(that.title) && author.equals(that.author) && price == that.price;
	}

	public String toString() {
		return ("title: " + title + "\t" + "author: " + author + "\t" + "price: " + price);
	}

}