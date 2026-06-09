/**
 * Week 2 Exercise — Calculator with static methods and overloads.
 *
 * Division by zero strategy (TODO — choose and implement):
 *   Option A: print error message and return Double.NaN
 *   Option B: return 0.0 and document why (not ideal for production)
 *
 * Compile: javac Calculator.java
 * Run:     java Calculator
 */
public class Calculator {

    public static double add(double a, double b) {
       return a + b;
    }

    /** Sum of three doubles — overloads add(a,b). */
    public static double add(double a, double b, double c) {
        return a + b + c;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    //I return a NaN and notify with a print statement when dividing by 0 is attempted
    public static double divide(double a, double b) {
        if (b == 0){
            System.out.println("Divide by zero, returns NaN");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println("Showcases:");
        System.out.println("5 + 9 = " + add(5, 9));
        System.out.println("5 + 9 + 10 = " + add(5, 9, 10));
        System.out.println("20 - 9 = " + subtract(20, 9));
        System.out.println("5 * 9 = " + multiply(5, 9));
        System.out.println("10 / 5 = " + divide(10, 5));
        System.out.println("10 / 0 = " + divide(10, 0));
    }
}