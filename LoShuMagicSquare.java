//BS'D
/*
The Lo Shu Magic Square is a grid with 3 rows and 3 columns, shown in Figure 7-31. The
Lo Shu Magic Square has the following properties:
•	 The grid contains the numbers 1 through 9 exactly.
•	 The sum of each row, each column, and each diagonal all add up to the same number.
This is shown in Figure 7-32.
In a program you can simulate a magic square using a two-dimensional array. Write a
method that accepts a two-dimensional array as an argument, and determines whether the
array is a Lo Shu Magic Square. Test the function in a program
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LoShuMagicSquare {
    public static void main(String[] args) {
        int[][] array = new int[3][3];
        fillArray(array);
        printArray(array);

        if(isMagicSquare(array))
            System.out.println("This square is a magic square!");
        else
            System.out.println("This square is just a regular square");

    }
    public static void fillArray(int[][] array) {
        Random rand = new Random();
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[1].length; j++)
                array[i][j] = rand.nextInt(9)+1;
        return;
    }
    public static void printArray(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
        return;
    }
    public static boolean isMagicSquare(int[][] array) {
        int rowTotal = 0;
        int colTotal = 0;
        int diagTotal = array[0][0] + array[1][1] + array[2][2];
        ArrayList<Integer> totals = new ArrayList<>();

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++)
                rowTotal += array[i][j];
            totals.add(rowTotal);
            rowTotal = 0;
        }

        for(int i = 0; i < array[0].length; i++) {
            for(int j = 0; j < array.length; j++)
                colTotal += array[j][i];
            totals.add(colTotal);
            colTotal = 0;
        }

        totals.add(diagTotal);
        boolean isLoShu = false;
        for(int i = 1; i < totals.size(); i++) {
            if(totals.get(i) != diagTotal){
                isLoShu = false;
                break;
            }
            else
                isLoShu = true;
        }
        return isLoShu;
    }
}
