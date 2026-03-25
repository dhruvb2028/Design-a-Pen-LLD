package pen;

public class Ink {
    private final int capacity;
    private int level;

    public Ink(int capacity) {
        this.capacity = capacity;
        this.level = capacity;
    }

    public boolean hasInk() {
        return level > 0;
    }

    public void consume(int amount) {
        if (amount > level) {
            throw new IllegalStateException("Not enough ink.");
        }
        level -= amount;
    }

    public void refill() {
        level = capacity;
    }

    public int getLevel() {
        return level;
    }

    public int getCapacity() {
        return capacity;
    }
}
