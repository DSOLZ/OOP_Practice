public class Circle extends Figure {
	private int radius;
	private static final int DEFAULT_RADIUS = 1;

	public Circle() {
		setRadius(DEFAULT_RADIUS);
	}

	public Circle(int startX, int startY, int startRadius) {
		super(startX, startY);
		setRadius(startRadius);
	}

	public void setRadius(int newRadius) {
		if (newRadius > 0)
			radius = newRadius;
		else
			radius = DEFAULT_RADIUS;
	}

	public int getRadius() {
		return radius;
	}
    
    public double getArea(){
        return Math.PI * radius * radius;
    }
	
	public void draw() {
		System.out.println("Circle (" + getX() + "," + getY() + ") radius=" + getRadius());
	}
}