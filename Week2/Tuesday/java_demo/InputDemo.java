import java.util.Scanner;

public class InputDemo {
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.next();
        System.out.println("Welcome: " + name);
    }
}
