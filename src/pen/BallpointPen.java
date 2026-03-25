package pen;

public class BallpointPen extends AbstractPen {

    public BallpointPen(String brand, String color) {
        super(brand, color, new Ink(500));
    }

    public BallpointPen(String brand, String color, int inkCapacity) {
        super(brand, color, new Ink(inkCapacity));
    }

    @Override
    protected int inkCostPerChar() {
        return 1;
    }
}
