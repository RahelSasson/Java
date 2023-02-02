//BS'D
/*
Create a class with a method that accepts a charge account number as its argument. The
method should determine whether the number is valid by comparing it to the following list
of valid charge account numbers:
5658845 4520125 7895122 8777541 8451277 1302850
8080152 4562555 5552012 5050552 7825877 1250255
1005231 6545231 3852085 7576651 7881200 4581002
These numbers should be stored in an array or an ArrayList object. Use a sequential search
to locate the number passed as an argument. If the number is in the array, the method
should return true, indicating the number is valid. If the number is not in the array, the
method should return false, indicating the number is invalid.
 */
import java.util.ArrayList;
import java.util.Arrays;
public class ChargeAccountValidation {
    private ArrayList<Integer> accountNumbers;

    public ChargeAccountValidation() {
        this.setAccountNumbers();;
    }
    private void setAccountNumbers() {
        this.accountNumbers = new ArrayList<>(Arrays.asList(
                5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
                8080152, 4562555, 5552012, 5050552, 7825877, 1250255,
                1005231, 6545231, 3852085, 7576651, 7881200, 4581002));
        return;
    }

    public boolean isNumberPresent(int number) {
        for(int i = 0; i < accountNumbers.size(); i++) {
            if(accountNumbers.get(i) == number)
                return true;
        }
        return false;
    }

    public ArrayList<Integer> getAccountNumbers() {
        return accountNumbers;
    }

}

