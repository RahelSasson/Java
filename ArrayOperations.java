//BS'D
/*
Write a program with an array that is initialized with test data. Use any primitive data type
of your choice. The program should also have the following methods:
•	 getTotal. This method should accept a one-dimensional array as its argument and
return the total of the values in the array.
•	 getAverage. This method should accept a one-dimensional array as its argument and
return the average of the values in the array.
•	 getHighest. This method should accept a one-dimensional array as its argument and
return the highest value in the array.
•	 getLowest. This method should accept a one-dimensional array as its argument and
return the lowest value in the array.
 */
public class ArrayOperations {
    int[] numbers;

    public ArrayOperations(int[] NUMBERS) {
        this.numbers = NUMBERS;
    }
    public int getTotal(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum += numbers[i];
        return sum;
    }

    public double getAverage(int[] numbers) {
        double average = (double)(this.getTotal(numbers)/numbers.length);
        return average;
    }
    public int getHighest(int[] numbers) {
        int highest = numbers[0];
        for(int i = 1; i < numbers.length; i++)
            if(numbers[i] > highest)
                highest = numbers[i];
        return highest;
    }
    public int getLowest(int[] numbers) {
        int lowest = numbers[0];
        for(int i = 1; i < numbers.length; i++)
            if(numbers[i] < lowest)
                lowest = numbers[i];
        return lowest;
    }

}
