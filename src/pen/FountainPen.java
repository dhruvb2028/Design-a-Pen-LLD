package pen;

public class FountainPen extends AbstractPen {

    public FountainPen(String brand, String color) {
        super(brand, color, new Ink(300));
    }

    public FountainPen(String brand, String color, int inkCapacity) {
        super(brand, color, new Ink(inkCapacity));
    }

    @Override
    protected int inkCostPerChar() {
        return 2;
    }
}
