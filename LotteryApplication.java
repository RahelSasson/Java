//BS'D
/*
Write a Lottery class that simulates a lottery. The class should have an array of five integers
named lotteryNumbers. The constructor should use the Random class (from the Java API) to
generate a random number in the range of 0 through 9 for each element in the array. The
class should also have a method that accepts an array of five integers that represent a person’s lottery picks. The method is to compare the corresponding elements in the two arrays
and return the number of digits that match. For example, the following shows the
lotteryNumbers array and the user’s array with sample numbers stored in each. There are
two matching digits (elements 2 and 4)
In addition, the class should have a method that returns a copy of the lotteryNumbers array.
 */
import java.util.Random;
public class LotteryApplication {
    private int[] LotteryNumbers;

    public LotteryApplication() {
        this.setLotteryNumbers();

    }

    private void setLotteryNumbers() {
        this.LotteryNumbers = new int[10];
        Random rand = new Random();
        for(int i = 0; i < LotteryNumbers.length; i++)
            LotteryNumbers[i] = rand.nextInt(9);

        return;
    }

    public String getLotteryNumbers(){
        String s = "";
        for(int i = 0; i < LotteryNumbers.length; i++)
            s += LotteryNumbers[i] + " ";
        return s;
    }

    public int compareNumbers(int[] userNumbers) {
        int counter = 0;
        int temp;
        int k = 0;
        for(int i = 0; i < LotteryNumbers.length; i++) {
            for (int j = k; j < userNumbers.length; j++){
                if (LotteryNumbers[i] == userNumbers[j]) {
                    counter++;
                    temp = userNumbers[k];
                    userNumbers[k] = userNumbers[j];
                    k++;
                    userNumbers[j] = temp;
                }
            }

        }
        return counter;
    }
}
