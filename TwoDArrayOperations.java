//BS'D
/*
Write a program that creates a two-dimensional array initialized with test data. Use any
primitive data type that you wish. The program should have the following methods:
•	 getTotal. This method should accept a two-dimensional array as its argument and
return the total of all the values in the array.
•	 getAverage. This method should accept a two-dimensional array as its argument and
return the average of all the values in the array.
•	 getRowTotal. This method should accept a two-dimensional array as its first argument and an integer as its second argument. The second argument should be the subscript of a row in the array. The method should return the total of the values in the
specified row.
•	 getColumnTotal. This method should accept a two-dimensional array as its first argument and an integer as its second argument. The second argument should be the subscript of a column in the array. The method should return the total of the values in the
specified column.
•	 getHighestInRow. This method should accept a two-dimensional array as its first
argument and an integer as its second argument. The second argument should be the
subscript of a row in the array. The method should return the highest value in the
specified row of the array.
•	 getLowestInRow. This method should accept a two-dimensional array as its first argument and an integer as its second argument. The second argument should be the subscript of a row in the array. The method should return the lowest value in the specified
row of the array.
Demonstrate each of the methods in this program
 */
import java.util.Random;

public class TwoDArrayOperations {
    public static void main(String[] args) {
        int[][] array = new int[3][5];
        fillArray(array);
        printArray(array);
        int rowSum = getRowTotal(array, 2);
        int colSum = getColumnTotal(array, 2);
        System.out.println("Row 2 Total: " + rowSum + " Column 2 Total: " +colSum);
        System.out.println("Highest in Row 2: " + highestInRow(array, 2) + "\nHighest in Column 2: " + highestInCol(array, 2));

    }

    public static void fillArray(int[][] array) {
        Random rand = new Random();
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[i].length; j++)
                array[i][j] = rand.nextInt(10);
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

    public static int getTotal(int[][] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[i].length; j++)
                sum += array[i][j];
        return sum;
    }

    public static int getRowTotal(int[][] array, int row) {
        int rowSum = 0;
        for(int i = 0; i < array[row-1].length; i++)
            rowSum += array[row-1][i];
        return rowSum;
    }
    public static int getColumnTotal(int[][] array, int col) {
        int colSum = 0;
            for(int j = 0; j < array.length; j++)
                colSum += array[j][col-1];
        return colSum;
    }

    public static int highestInRow(int[][] array, int row) {
        int highest = array[row-1][0];
        for(int i = 1; i < array[row-1].length; i++)
            if(array[row-1][i] > highest)
                highest = array[row-1][i];
        return highest;
    }

    public static int highestInCol(int[][] array, int col) {
        int highest = array[0][col-1];
        for(int j = 1; j < array.length; j++)
            if(array[j][col-1] > highest)
                highest = array[j][col-1];
        return highest;
    }
}
