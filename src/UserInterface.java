import java.util.Scanner;

public class UserInterface {
    public static Scanner input = new Scanner(System.in);


    public Integer showMenu() {
        System.out.println("+--------------------------------+");
        System.out.println("|            WELCOME             |");
        System.out.println("|            to the              |");
        System.out.println("|            Shop                |");
        System.out.println("+--------------------------------+");

        System.out.println("Make a selsection:");
        System.out.println("1) Display all products.");
        System.out.println("2) Display all products of category dress.");
        System.out.println("3) Display all products where stock < 5.");
        System.out.println("4) Display all products out of stock. ");
        System.out.println("5) Display all Users registered to this Shop");
        System.out.println("0) Exit.");

        System.out.println("Enter your choice: ");
        return Integer.parseInt(input.nextLine());

    }
}
