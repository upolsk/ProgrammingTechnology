import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Main {  public static void main(String[] args) {

    Database db = new Database();
    try {
        System.out.println("Give the name of the file: ");
        // Scanner sc = new Scanner(System.in);
        // String fileName = sc.next();
        String fileName = System.console().readLine("Enter the file: ");
        db.read(fileName);
    } catch (FileNotFoundException ex) {
        System.out.println("File not found!");
        System.exit(-1);
    } catch (InvalidInputException ex) {
        System.out.println("Invalid input!");
        System.exit(-1);
    } catch (NoSuchElementException ex)
    {
        System.out.println("Empty file or Invalid starting!");
        System.exit(-1);
    }
    
    db.report();
    db.numberOFShapes();
    
}
}
