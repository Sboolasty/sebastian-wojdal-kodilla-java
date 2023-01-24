package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    ArrayList<Shape> shapes = new ArrayList<>();
    int addFigure(Shape shape) {
        shapes.add(shape);
        return shapes.contains(shape) ? 0 : -1;
    }

    int removeFigure(Shape shape) {
        shapes.remove(shape);
        return shapes.contains(shape) ? -1 : -0;
    }

    Shape getFigure(int n) {
        return shapes.get(n-1);
    }

    String showFigures() {
        StringBuilder result = new StringBuilder();
        int i = shapes.size() - 1;
        for (Shape shape : shapes) {
            if (i-- == 0)
                result.append(shape.getShapeName());
            else
                result.append(shape.getShapeName()).append(", ");
        }
        return result.toString();
    }
}