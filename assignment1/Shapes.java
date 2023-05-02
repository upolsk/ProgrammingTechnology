public abstract class Shapes {
    String category;
    Point center;
    int length;
    

    public Shapes(String category, Point center, int length)
    {
        if(length < 0) throw new IllegalArgumentException("Side length/radius can't be negative!");
        this.category = category;
        this.center = center;
        this.length = length;
    }

    @Override
    public String toString()
    {
        return "Category : " + category + ", center: x = " + center.x  + ", y =  " + center.y + ", length: " + length;
    }

    public abstract boolean insideTheShape(Point p);
    
}
