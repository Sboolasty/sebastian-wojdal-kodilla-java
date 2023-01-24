package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
@DisplayName("ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {
    @Nested
    @DisplayName("Tests for adding/removing figures")
    class TestAddRemove {
        @Test
        @DisplayName("Test for adding figure")
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape theShape = new Triangle("Triangle 1", 100);

            //When
            int result = shapeCollector.addFigure(theShape);

            //Then
            Assertions.assertEquals(0, result);
        }
        @Test
        @DisplayName("Test for removing figure")
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape theShape = new Triangle("Triangle 1", 100);
            shapeCollector.addFigure(theShape);

            //When
            int result = shapeCollector.removeFigure(theShape);

            //Then
            Assertions.assertEquals(0, result);
        }

    }
    @Nested
    @DisplayName("Tests for listing")
    class TestListing {
        @Test
        @DisplayName("Test for getting figure")
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape theShape = new Triangle("Triangle 1", 100);
            shapeCollector.addFigure(theShape);

            //When
            Shape retrivedShape;
            retrivedShape = shapeCollector.getFigure(1);

            //Then
            Assertions.assertEquals(retrivedShape, theShape);
        }
        @Test
        @DisplayName("Test for showing figures")
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape theShape = new Triangle("Triangle 1", 100);
            shapeCollector.addFigure(theShape);

            //When
            String result = shapeCollector.showFigures();

            //Then
            Assertions.assertEquals("Triangle 1", result);
        }
    }
}