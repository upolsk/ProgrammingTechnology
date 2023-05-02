public class Square extends Shapes {

    public Square(Point center, int length)
    {
        super("S", center, length);
    }

    public boolean insideTheShape(Point p)
    {
        return ((center.x - length < p.x && p.x < center.x + length) && 
           (center.y - length < p.y && p.y < center.y + length));
    }

    
}
