package be.cegeka.marsrover.domain;

public enum Orientation {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private final int offsetX;
    private final int offsetY;

    Orientation(int offsetX, int offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public Orientation left() {
        int index = ordinal() - 1;
        if (index < 0)
            index += values().length;
        return values()[index % values().length];
    }

    public Orientation right() {
        return values()[(ordinal() + 1) % values().length];
    }
}
