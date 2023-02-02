//BS'D
/*
Write a program that lets the user enter four quarterly sales figures for six divisions of a
company. The figures should be stored in a two-dimensional array. Once the figures are
entered, the program should display the following data for each quarter:
•	 A list of the sales figures by division
•	 Each division’s increase or decrease from the previous quarter (this will not be displayed for the first quarter)
•	 The total sales for the quarter
•	 The company’s increase or decrease from the previous quarter (this will not be displayed for the first quarter)
•	 The average sales for all divisions that quarter
•	 The division with the highest sales for that quarter
 */
import java.util.Random;

public class QuarterlySalesStatistics {
    public static void main(String[] args) {

        double[][] salesStatistics = new double[4][6];
        Random rand = new Random();
        for(int i = 0; i < salesStatistics[0].length; i++) {
            for(int j = 0; j < salesStatistics.length; j++)
                salesStatistics[j][i] = rand.nextDouble(2000)+1;
        }
        salesByDivision(salesStatistics);
        printIncreaseDecrease(salesStatistics);
        printSalesPerQuarter(salesStatistics);
    }
    public static void salesByDivision(double[][] salesStatistics) {
        for(int i = 0; i < salesStatistics[0].length; i++) {
            System.out.print("Division " + (i+1) + ": ");
            for(int j = 0; j < salesStatistics.length; j++)
                System.out.print(String.format("%.2f",salesStatistics[j][i]) + " ");
            System.out.println();
        }
        return;
    }

    public static void printIncreaseDecrease(double[][] salesStatistics) {
        double[] printDivisionStats = new double[4];
        for(int i = 0; i < 6; i++){
            printDivisionStats = increaseOrDecrease(salesStatistics, i);
            System.out.print("Increase or Decrease for Division " + (i+1) + " ");
            for(int j = 0; j < printDivisionStats.length; j++) {
                System.out.print(((printDivisionStats[j] > 0) ? "+" + String.format("%.2f",printDivisionStats[j]) :
                String.format("%.2f",printDivisionStats[j]))+ " ");
            }
            System.out.println();
        }
    }
    public static double[] increaseOrDecrease(double[][] salesStatistics, int division) {
        double[] divisionStatistics = new double[4];
        //for (int i = 0; i < salesStatistics[division].length; i++) {
            for (int j = 1; j < salesStatistics.length; j++){
                if (salesStatistics[j][division] < salesStatistics[j - 1][division])
                    divisionStatistics[j] = -(salesStatistics[j - 1][division] - salesStatistics[j][division]);
                else
                    divisionStatistics[j] = salesStatistics[j][division] - salesStatistics[j-1][division];
        }
        return divisionStatistics;
    }

    public static void printSalesPerQuarter(double[][] salesStatistics) {
        double previousSum = 0;
        for(int i = 0; i < salesStatistics.length; i++) {
            double sum = 0;
            double change = 0;
            double highest = 0;
            int highestIndex = 0;
            for (int j = 0; j < salesStatistics[i].length; j++) {
                sum += salesStatistics[i][j];
                if (salesStatistics[i][j] > highest) {
                    highest = salesStatistics[i][j];
                    highestIndex = j;
                }
            }
            if (i > 0) {
                if (sum < previousSum)
                    change = -(previousSum - sum);
                else
                    change = +(sum - previousSum);
            }
            double average = sum / 6;
            System.out.println("Sum of sales for Quarter " + (i + 1) + " is: " + String.format("%.2f", sum) + " change from previous quarter: " + String.format("%.2f", change) + " Average sales: " + String.format("%.2f", average));
            previousSum = sum;
            System.out.println("Division " + (highestIndex + 1) + " had the highest sales: " + String.format("%.2f",highest));
        }
        return;
    }

}
