public class Rectangle {
	double height = 1.0;
	double width = 1.0;

	Rectangle() {
	}

	Rectangle(double newHeight, double newWidth) {
		height = newHeight;
		width = newWidth;
	}

	public double getArea() {
		return height * width;
	}

	public double getPerimeter() {
		return 2 * (height + width);
	}
}
