public class BookList {

	private int size;
	private Book[] bookArray;
	private final static int DEFAULT_SIZE = 10;

	public BookList() {
		bookArray = new Book[DEFAULT_SIZE];
		size = 0;
	}

	public BookList(int arrayLength) {
		bookArray = new Book[arrayLength];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == bookArray.length;
	}

	public boolean isThere(Book b) {
		for (Book book : bookArray) {
			if (book != null && book.equals(b)) {
				return true;
			}
		}
		return false;
	}

	public Book get(int index) {

		try {
			return bookArray[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("index out of bounds");
		}
		return null;

	}

	public int search(Book b) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (bookArray[i].equals(b)) {
				index = i;
				return index;
			}
		}
		return index;
	}

	public void remove(Book b) {

		int index = search(b);
		if (index == -1) {
			return;
		}

		for (int i = index; i < size - 1; i++) {
			bookArray[i] = bookArray[i + 1];
		}

		size--;

	}

	public void add(Book b) {

		if (isThere(b)) { // To prevent duplicates
			return;
		}

		if (isFull()) {
			Book[] newBookArray = new Book[size * 2];
			for (int i = 0; i < size; i++) {
				newBookArray[i] = bookArray[i];
			}
			bookArray = newBookArray;
		}

		bookArray[size] = b.clone();
		size++;
	}

	public void add(Book b, int index) {

		if (isThere(b)) {
			return;
		}

		if (index >= size) {
			add(b);
			return;
		}

		index = Math.max(0, index); // prevent negative index

		if (isFull()) {
			Book[] newBookArray = new Book[size * 2];
			for (int i = 0; i < size; i++) {
				newBookArray[i] = bookArray[i];
			}
			bookArray = newBookArray;
		}

		for (int i = size - 1; i >= index; i--) {
			bookArray[i + 1] = bookArray[i];
		}

		bookArray[index] = b.clone();
		size++;

	}

	public String toString() {

		String output = "[";

		for (int i = 0; i < size; i++) {

			output += bookArray[i].toString();

			if (i != size - 1) {
				output += ",\n";
			} else {
				output += "]";
			}

		}

		return output;
	}

	public void SortByAuthor() { // Insertion sort algorithm

		for (int i = 1; i < size; i++) {
			Book key = bookArray[i];
			int j = i - 1;
			while (j >= 0 && bookArray[j].compareTo(key) > 0) {
				bookArray[j + 1] = bookArray[j];
				j--;
			}
			bookArray[j + 1] = key;
		}

	}

	public void SortByTitle() { // using selection sort algorithm

		for (int i = 0; i < size; i++) { // select the min between index i to n-1
			Book min = bookArray[i];
			int minIndex = i;

			for (int j = i + 1; j < size; j++) {
				if (bookArray[j].getTitle().compareTo(min.getTitle()) < 0) {
					min = bookArray[j];
					minIndex = j;
				}
			}

			Book temp = bookArray[minIndex]; // swap min with index i
			bookArray[minIndex] = bookArray[i];
			bookArray[i] = temp;

		}

	}

	public void SortByPrice() { // using bubble sort algorithm

		for (int i = 0; i < size; i++) {
			for (int j = size - 1; j > i; j--) {
				if (new ComparePrice().compare(bookArray[j], bookArray[j - 1]) < 0) {
					Book temp = bookArray[j];
					bookArray[j] = bookArray[j - 1];
					bookArray[j - 1] = temp;
				}
			}
		}
	}

}