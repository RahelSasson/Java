//BS'D
/*
In a program, write a method that accepts two arguments: an array and a number n. Assume
that the array contains integers. The method should display all of the numbers in the array
that are greater than the number n.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LargerThanN {
    public static void main(String[] args) {

        int[] array = { 5, 6, 7, 3, 2, 3, 12,23, 44, 93,27, 1, 33};
        ArrayList<Integer> larger = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a value");
        int n = s.nextInt();

        larger = largerThanN(array,n);
        if(larger.isEmpty())
            System.out.println("no values present larger than " + n);
        else
            printLarger(larger);
    }
    public static ArrayList<Integer> largerThanN(int[] array, int n) {
        ArrayList<Integer> larger = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            if(array[i] > n)
                larger.add(array[i]);
        }
        Collections.sort(larger);
        return larger;
    }
    public static void printLarger(ArrayList<Integer> larger) {
        for(int i = 0; i < larger.size(); i ++)
            System.out.println(larger.get(i) + " ");
        return;
    }
}
