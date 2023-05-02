import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShapesTest {
    @Test
    public void testPoint() {
        Point p = new Point(3, 3);
        assertEquals(3, p.getX());
        assertEquals(3, p.getY());
    }

    @Test
    public void testTriangle()
    {
        Triangle s = new Triangle(new  Point(2, 4), 8);
        assertNotEquals(0, s.length);
        assertEquals("T", s.category);
        assertTrue(s.insideTheShape(new Point(1, 5)));
        assertFalse(s.insideTheShape(new Point(7, 12)));

    }

    @Test
    public void testCircle()
    {
        Circle s = new Circle(new  Point(5, 3), 9);
        Circle c = new Circle(new  Point(2, 7), 8);
        assertNotEquals(new Point(8, 9), c.center);
        assertEquals(9, s.length);
        assertFalse(s.insideTheShape(new Point(13, 15)));
        assertTrue(s.insideTheShape(new Point(3, 5)));
        
    }

    @Test
    public void testSquare()
    {
        Square s = new Square(new  Point(-2, -3), 9);
        Square c = new Square(new  Point(4, 0), 2);
        assertNotEquals(new Point(8, 9), c.center);
        assertEquals(9, s.length);
        assertFalse(s.insideTheShape(new Point(13, 15)));
        assertTrue(c.insideTheShape(new Point(3, 1)));
        
    }

    @Test
    public void testHexagon()
    {
        Hexagon s = new Hexagon(new  Point(-5, 3), 9);
        Hexagon c = new Hexagon(new  Point(2, -7), 18);
        assertNotEquals(new Point(8, 9), c.center);
        assertEquals(9, s.length);
        assertFalse(s.insideTheShape(new Point(1, 15)));
        assertTrue(c.insideTheShape(new Point(3, -5)));
        
    }
    


}
