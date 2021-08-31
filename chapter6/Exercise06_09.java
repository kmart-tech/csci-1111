/*
Kevin Martinsen
CSCI 1111 - OOP 1
08/31/2021

Exercise 6-9: feet and meters conversion (non-object approach)
*/
public class Exercise06_09 {
	public static void main(String[] args) {
		System.out.println("Test output for feet and meters conversion.");
		
		System.out.println("Feet    Meters        Meters   Feet");
		System.out.println("-------------------------------------");
		for (int i = 1; i <= 10; i ++) {
			double meter = 15 + 5 * i;
			System.out.printf("%4.1f    %-4.3f         %.1f     %.3f\n",(double)i,footToMeter((double)i),meter, meterToFoot(meter));
		}
	}
	public static double footToMeter(double foot) {
		return foot * 0.305;
	}
	public static double meterToFoot(double meter) {
		return meter * 3.279;
	}
}