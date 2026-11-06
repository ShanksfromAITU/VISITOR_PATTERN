package elements;

final class ShapeValidation {

    private ShapeValidation() {
    }

    static void requirePositiveFinite(double value) {
        if (!Double.isFinite(value) || value <= 0) {
            throw new IllegalArgumentException(
                    "Shape dimension must be a positive finite number."
            );
        }
    }
}