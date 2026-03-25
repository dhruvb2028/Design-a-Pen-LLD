package pen;

public abstract class AbstractPen implements Pen {
    private final String brand;
    private final String color;
    protected Ink ink;
    protected PenState state;

    protected AbstractPen(String brand, String color, Ink ink) {
        this.brand = brand;
        this.color = color;
        this.ink = ink;
        this.state = PenState.CLOSED;
    }

    @Override
    public void start() {
        if (state == PenState.OPEN) {
            throw new IllegalStateException("Pen is already open.");
        }
        if (state == PenState.EMPTY) {
            throw new IllegalStateException("Pen is empty. Please refill.");
        }
        state = PenState.OPEN;
        System.out.println(brand + " pen (" + color + ") is now open.");
    }

    @Override
    public void write(String text) {
        if (state != PenState.OPEN) {
            throw new IllegalStateException("Pen must be open to write.");
        }
        if (!ink.hasInk()) {
            state = PenState.EMPTY;
            throw new IllegalStateException("Ink ran out while writing.");
        }
        ink.consume(inkCostPerChar() * text.length());
        System.out.println("Writing: " + text + " [Ink left: " + ink.getLevel() + "]");
    }

    @Override
    public void close() {
        if (state == PenState.CLOSED) {
            throw new IllegalStateException("Pen is already closed.");
        }
        state = PenState.CLOSED;
        System.out.println(brand + " pen capped.");
    }

    @Override
    public void refill() {
        if (state == PenState.OPEN) {
            throw new IllegalStateException("Close the pen before refilling.");
        }
        ink.refill();
        state = PenState.CLOSED;
        System.out.println(brand + " pen refilled. Ink level: " + ink.getLevel() + "/" + ink.getCapacity());
    }

    protected abstract int inkCostPerChar();

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public PenState getState() {
        return state;
    }
}
