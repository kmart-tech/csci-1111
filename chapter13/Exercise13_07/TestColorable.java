/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/20/2021

Exercise 13_07: Geometric Objects and Colorable interface
*/
public class TestColorable {
	public static void main(String[] args) {
		
		GeometricObject[] myObjects = {new Triangle(3, 4, 5), new Rectangle(2.6, 100.1), new Rectangle(1.53, 1.52), new Triangle(56, 58, 59), new Triangle(8, 9, 9.2)};
		
		System.out.println("Object areas and how to color in myObjects array: ");
		for (GeometricObject obj: myObjects) {
			System.out.printf("Object Area: %.2f\n", obj.getArea());
			if (obj instanceof Colorable) {
				System.out.print("How to color: ");
				((Colorable)obj).howToColor();
				System.out.println();
			}
			System.out.println();
		}
	}
}