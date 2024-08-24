public class FigureClient {
    

    public static void main(String[] args){
        Square s1 = new Square();
        Square s2 = new Square(100,200,5);

        Circle c1 = new Circle();
        Circle c2 = new Circle(300,400,5);

        Figure[] figures = {s1,s2,c1,c2};

        for(int i = 0; i < figures.length; i++){
            figures[i].draw();
        }

    

    }
}
