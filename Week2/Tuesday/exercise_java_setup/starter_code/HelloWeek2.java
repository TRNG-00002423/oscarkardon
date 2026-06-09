//openjdk 21.0.8 2025-07-15 LTS
package Week2.Tuesday.exercise_java_setup.starter_code;

public class HelloWeek2 {
    public static void main(String[] args) {
        if (args.length >= 1){
            System.out.println("Hello, " + args[0] + "!");
        }
        else{
            System.out.println("Hello, trainee!");
        }
        System.out.println(Runtime.getRuntime());
    }
}
