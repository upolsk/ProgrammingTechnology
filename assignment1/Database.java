import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    private final ArrayList<Shapes> shapes;

    public Database() {
        shapes = new ArrayList<>();
    }

    public void read(String filename) throws FileNotFoundException, InvalidInputException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        int numShapes = sc.nextInt();
        
        while (sc.hasNext()) {
            Shapes shape;
            switch (sc.next()) {
                case "S":
                    shape = new Square(new Point(sc.nextInt(), sc.nextInt()), sc.nextInt());
                    break;
                case "C":
                    shape = new Circle(new Point(sc.nextInt(), sc.nextInt()), sc.nextInt());
                    break;
                case "H":
                    shape = new Hexagon(new Point(sc.nextInt(), sc.nextInt()), sc.nextInt());
                    break;
                case "T":
                    shape = new Triangle(new Point(sc.nextInt(), sc.nextInt()), sc.nextInt());
                    break;
                default:
                    throw new InvalidInputException();
            }
            shapes.add(shape);
        }
        }
    
    
    public void report() {
        System.out.println("Shapes in the file:");
        for (Shapes s : shapes) {
            System.out.println(s.toString());
        }
    }

    public void numberOFShapes(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the x: ");
    int x = sc.nextInt();
    System.out.println("Enter the y: ");
    int y = sc.nextInt();
    Point p = new Point(x, y);
    int count = 0;
    for(Shapes s: shapes){
      if(s.insideTheShape(p))
      {
        count++;
        System.out.println(s);
      }
    }
    System.out.println(count + " shapes contain the given point.");
}

}

