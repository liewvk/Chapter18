import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarksCollectionSystem {

    public static int readValidMark(Scanner input, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int mark = Integer.parseInt(input.nextLine());

                if (mark >= 0 && mark <= 100) {
                    return mark;
                } else {
                    System.out.println("Mark must be between 0 and 100.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("How many marks do you want to enter? ");
            int count = Integer.parseInt(input.nextLine());

            for (int i = 1; i <= count; i++) {
                int mark = readValidMark(input, "Enter mark " + i + ": ");
                marks.add(mark);
            }
        }

        int total = 0;
        int highest = marks.get(0);
        int lowest = marks.get(0);

        for (int mark : marks) {
            total += mark;

            if (mark > highest) {
                highest = mark;
            }

            if (mark < lowest) {
                lowest = mark;
            }
        }

        double average = total / (double) marks.size();

        System.out.println();
        System.out.println("Marks Report");
        System.out.println("------------");
        System.out.println("Marks  : " + marks);
        System.out.println("Total  : " + total);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest : " + lowest);
    }
}
