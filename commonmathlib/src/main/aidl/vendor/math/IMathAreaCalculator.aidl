// IMathAreaCalculator.aidl
package vendor.math;

// Declare any non-default types here with import statements

interface IMathAreaCalculator {
    /**
     * Calculates the area of a square.
     * @param side Length of the square's side.
     * @return Area of the square.
     */
    int calculateSquareArea(int side);

    /**
     * Calculates the area of a rectangle.
     * @param length Length of the rectangle.
     * @param width Width of the rectangle.
     * @return Area of the rectangle.
     */
    int calculateRectangleArea(int length, int width);

    /**
     * Calculates the area of a triangle.
     * @param base Base of the triangle.
     * @param height Height of the triangle.
     * @return Area of the triangle.
     */
    int calculateTriangleArea(int base, int height);

    /**
     * Calculates the area of a circle.
     * Uses integer approximation of π = 3.
     * @param radius Radius of the circle.
     * @return Area of the circle.
     */
    int calculateCircleArea(int radius);

    /**
     * Returns the name of the service.
     * @return The service name.
     */
    String getServiceName();
}