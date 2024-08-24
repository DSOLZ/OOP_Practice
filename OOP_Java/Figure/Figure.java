public abstract class Figure implements HasArea {
	private int x;
	private int y;
	private static final int DEFAULT_COORDINATE = 0;

	public Figure() {
		setX(DEFAULT_COORDINATE);
		setY(DEFAULT_COORDINATE);
	}

	public Figure(int startX, int startY) {
		setX(startX);
		setY(startY);
	}

	public int getX() {
		return x;
	}

	public void setX(int newX) {
		x = newX;
	} 

	public int getY() {
		return y;
	}

	public void setY(int newY) {
		y = newY;
	} 

    public int compareTo(Figure f1){
        
        int diff = (int) (getArea() - f1.getArea());
        return diff;
    }

    public abstract double getArea();

	public abstract void draw();

}