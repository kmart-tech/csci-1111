/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/01/2021

Exercise 9_1: Rectangle class and objects
 */
public class Exercise09_01 {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(40,4);
        Rectangle rect2 = new Rectangle(35.9,3.5);

        System.out.println("Rectangle 1 has the following properties:");
        System.out.println("Width: " + rect1.width);
        System.out.println("Height: " + rect1.height);
        System.out.println("Height: " + rect1.getArea());
        System.out.println("Height: " + rect1.getPerimeter());

        System.out.println("Rectangle 2 has the following properties:");
        System.out.println("Width: " + rect2.width);
        System.out.println("Height: " + rect2.height);
        System.out.println("Height: " + rect2.getArea());
        System.out.println("Height: " + rect2.getPerimeter());
    }
}

class Rectangle {
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
