import pen.BallpointPen;
import pen.FountainPen;
import pen.Pen;

public class Main {
    public static void main(String[] args) {
        Pen ballpoint = new BallpointPen("Parker", "blue");
        ballpoint.start();
        ballpoint.write("Hello, World!");
        ballpoint.write("LLD Design");
        ballpoint.close();
        ballpoint.refill();

        System.out.println();

        Pen fountain = new FountainPen("Montblanc", "black", 30);
        fountain.start();
        fountain.write("Hello");
        fountain.close();

        try {
            fountain.write("should fail");
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        fountain.refill();
        fountain.start();
        fountain.write("After refill");
        fountain.close();
    }
}
