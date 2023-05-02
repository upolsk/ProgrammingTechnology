
public class Triangle extends Shapes {
    public Triangle(Point center, int length)
    {
        super("T", center, length);
    }

    public boolean insideTheShape(Point p)
    {
        return (center.x - length < p.x && p.x + p.y < center.x + length && 
        (center.y - length < p.y && p.x + p.y < center.y + length));
    }
     
}
