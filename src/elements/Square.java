package elements;

import visitors.ShapeVisitor;

public final class Square implements Shape {
    private final double side;

    public Square(double side) {
        ShapeValidation.requirePositiveFinite(side);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitSquare(this);
    }
}