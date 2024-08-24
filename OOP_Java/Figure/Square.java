public class Square extends Figure {
	private int length;
	private static final int DEFAULT_LENGTH = 1;

	public Square() {
		setLength(DEFAULT_LENGTH);
	}

	public Square(int startX, int startY, int startLength) {
		super(startX, startY);
		setLength(startLength);
	}

	public void setLength(int newLength) {
		if (newLength > 0)
			length = newLength;
		else
			length = DEFAULT_LENGTH;
	}

	public int getLength() {
		return length;
	}

    public double getArea(){
        return length * length;
    }

	public void draw() {
		System.out.println("Square (" + getX() + "," + getY() + ") length=" + getLength());
	}
}