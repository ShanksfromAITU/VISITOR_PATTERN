package elements;

import visitors.ShapeVisitor;

public interface Shape {
    void accept(ShapeVisitor visitor);
}