/*
Write a RainFall class that stores the total rainfall for each of 12 months into an array of
doubles. The program should have methods that return the following:
•	 the total rainfall for the year
•	 the average monthly rainfall
•	 the month with the most rain
•	 the month with the least rain
Demonstrate the class in a complete program.
Input Validation: Do not accept negative numbers for monthly rainfall figures
 */
import java.util.Scanner;
public class Rainfall {

public static void main(String[] args) {

    int[] rainfall = new int[12];
    Scanner s = new Scanner(System.in);
    int n = 0;
    for(int i = 0; i < rainfall.length; i++) {
        System.out.println("Enter rainfall for month " + (i + 1));
        n = s.nextInt();
        if (n < 0) {
            System.out.println("rainfall cannot be negative");
            System.out.println("would you like to try again (y/n)");
            char c = s.next().charAt(0);
            if (c == 'y') {
                System.out.println("Enter rainfall for month " + (i + 1));
                n = s.nextInt();
            } else
                n = 0;
        }

        rainfall[i] = n;
    }

        int total = 0;
        int averageMonthly = 0;
        int min = rainfall[0];
        int max = rainfall[0];
        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 0; i < rainfall.length; i++) {
            total += rainfall[i];
            if(min > rainfall[i]) {
                min = rainfall[i];
                minIndex = i;
            }
            if(max < rainfall[i]) {
                max = rainfall[i];
                maxIndex = i;
            }
        }

        averageMonthly = total/rainfall.length;
        System.out.println("Total Rain: " + total + " Average Monthly: " + averageMonthly);
        System.out.println("Maximum rain in month " + maxIndex + " : " + max);
        System.out.println("Minimum rain in month " + minIndex + " : " + min);

        for(int i = 0; i < rainfall.length; i++)
            System.out.println ((i+1) + ". " + rainfall[i]);

    }
}
