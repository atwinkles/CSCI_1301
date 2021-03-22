import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nThis is an example of using the \"Scanner\" class in Java.");
        System.out.println("Please type a number below:");

        int n;
        n = keyboard.nextInt();

        System.out.println("You typed " + n + "!\n");
    }
}
