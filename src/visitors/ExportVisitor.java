package visitors;

import elements.Circle;
import elements.Square;
import elements.Triangle;

import java.util.Locale;

public final class ExportVisitor implements ShapeVisitor {
    private final StringBuilder output = new StringBuilder();

    @Override
    public void visitCircle(Circle circle) {
        appendLine(String.format(
                Locale.US,
                "Circle: radius=%.2f",
                circle.getRadius()
        ));
    }

    @Override
    public void visitSquare(Square square) {
        appendLine(String.format(
                Locale.US,
                "Square: side=%.2f",
                square.getSide()
        ));
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        appendLine(String.format(
                Locale.US,
                "Triangle: sides=%.2f, %.2f, %.2f",
                triangle.getSideA(),
                triangle.getSideB(),
                triangle.getSideC()
        ));
    }

    private void appendLine(String line) {
        output.append(line).append(System.lineSeparator());
    }

    public String getOutput() {
        return output.toString();
    }
}