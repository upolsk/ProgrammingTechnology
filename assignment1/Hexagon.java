public class Hexagon extends Shapes{
    public Hexagon(Point center, int length)
    {
        super("H", center, length);
    }

    public boolean insideTheShape(Point p)
    {
        int hor = center.x + length;
        int ver = center.y + length;
        int q2x = Math.abs(p.x - center.x);
        int q2y = Math.abs(p.y - center.y);
        if (q2x > hor || q2y > ver) return false;
        return ver * 2 * hor - ver * q2x - 2* hor * q2y >= 0;
    }
}
