package elements;

import visitors.ShapeVisitor;

public final class Triangle implements Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        ShapeValidation.requirePositiveFinite(sideA);
        ShapeValidation.requirePositiveFinite(sideB);
        ShapeValidation.requirePositiveFinite(sideC);

        double largest = Math.max(sideA, Math.max(sideB, sideC));
        double smallest = Math.min(sideA, Math.min(sideB, sideC));
        double middle;

        if (largest == sideA) {
            middle = Math.max(sideB, sideC);
        } else if (largest == sideB) {
            middle = Math.max(sideA, sideC);
        } else {
            middle = Math.max(sideA, sideB);
        }

        if (smallest <= largest - middle) {
            throw new IllegalArgumentException(
                    "The sides must form a valid triangle."
            );
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitTriangle(this);
    }
}