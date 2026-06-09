package  Week2.Friday.exercise_control_flow.starter_code;
import java.util.Scanner;

/**
 * Week 2 Exercise — menu-driven console (implement the menu loop).
 *
 * Compile: javac TicketMenu.java
 * Run:     java TicketMenu
 */
public class TicketMenu {

    public static void main(String[] args) {
        String[] tickets = {"BUG-101 Login timeout", "BUG-102 CSV import", "BUG-103 flaky assertion"};
        int[] priorities = {2, 2, 2}; // stretch: update in menu option 2

        try (Scanner scanner = new Scanner(System.in)) {
            // print menu: 1=list 2=set priority 3=summary 4=quit
            boolean menuOpen = true;
            while(menuOpen){
                System.out.println("menu: 1=list 2=set priority 3=summary 4=quit");
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a number from the menu");
                    scanner.nextLine();
                    continue;
                }
                int input = scanner.nextInt();
                scanner.nextLine();
                
                switch(input){
                    case 1:
                        list(tickets, priorities);
                        break;
                    case 2:
                        updatePriority(tickets, priorities, scanner);
                        break;
                    case 3:
                        summary(tickets);
                        break; 
                    case 4:
                        System.out.println("Ending menu, goodbye");
                        menuOpen = false;
                        break;      
                    default:
                        System.out.println("Invalid menu option.");
                        break; 
                }
            }   
        }  
    }

    public static void list(String[] tickets, int[] priorities){
        for (int i = 0; i < tickets.length; i++) {
            System.out.println(i + ": " + tickets[i] + " (priority " + priorities[i] + ")");
        }
    }

    public static void updatePriority(String[] tickets, int[] priorities, Scanner scanner){
        System.out.println("Please provide a ticket index to update priority:");
        if (!scanner.hasNextInt()) {
            System.out.println("Please enter a number");
            scanner.nextLine();
        }
        int ticketIndex = scanner.nextInt();
        while(ticketIndex > tickets.length - 1|| ticketIndex < 0){
            System.out.println("Invalid index: Choose from 0 to " + (tickets.length - 1));
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number");
                scanner.nextLine();
                continue;
            }
            ticketIndex = scanner.nextInt();
        }
        System.out.println("Please provide a priority for this ticket:");
        if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        int priority = scanner.nextInt();
        while(priority > 3 || priority < 1){
            System.out.println("Invalid priority: Choose from 1 to 3");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number");
                scanner.nextLine();
                continue;
            }
            priority = scanner.nextInt();
        }
        priorities[ticketIndex] = priority;
    }

    public static void summary(String[] tickets){
        String label = (tickets.length == 1) ? " ticket" : " tickets";
        System.out.println(tickets.length + label);   
    }
}