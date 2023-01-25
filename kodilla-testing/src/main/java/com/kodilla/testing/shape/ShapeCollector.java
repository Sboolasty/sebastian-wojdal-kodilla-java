package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    ArrayList<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
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
                result.append(shape.getShapeName()).append(", ");
        }
        return result.toString();
    }
}