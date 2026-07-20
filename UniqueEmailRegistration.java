import java.util.HashSet;
import java.util.Scanner;

public class UniqueEmailRegistration {

    public static boolean isValidEmail(String email) {
        return email != null
                && email.contains("@")
                && email.contains(".")
                && !email.contains(" ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<String> emails = new HashSet<>();

        int choice;

        do {
            System.out.println();
            System.out.println("Email Registration System");
            System.out.println("-------------------------");
            System.out.println("1. Register Email");
            System.out.println("2. View Registered Emails");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter email: ");
                    String email = input.nextLine().trim().toLowerCase();

                    if (!isValidEmail(email)) {
                        System.out.println("Invalid email Format.");
                    } else if (emails.contains(email)) {
                        System.out.println("Email already registered.");
                    } else {
                        emails.add(email);
                        System.out.println("Email registered successfully.");
                    }
                    break;

                case 2:
                    System.out.println();
                    System.out.println("Registered Emails");
                    System.out.println("-----------------");

                    if (emails.isEmpty()) {
                        System.out.println("No emails registered.");
                    } else {
                        for (String registeredEmail : emails) {
                            System.out.println(registeredEmail);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        input.close();
    }
}
