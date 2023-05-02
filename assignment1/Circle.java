public class Circle extends Shapes{
    public Circle(Point center, int length)
    {
        super("C", center, length);
    }

    public boolean insideTheShape(Point p)
    {  
        return (Math.sqrt(((p.x - center.x) * (p.x - center.x)) + ((p.y - center.y) * (p.y - center.y)))) < length;
    }
}
