public class GreetingMain {
    public static void main(String[] args) {
        Greeting greet = (name) -> {
            String nameCaps = name.toUpperCase();
            return "Greeting " + nameCaps;
        };

        System.out.println(greet.sayHello("World"));
    }
}
