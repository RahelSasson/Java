//BS'D
/*
Write a Payroll class that uses the following arrays as fields:
•	 employeeId. An array of seven integers to hold employee identification numbers. The
array should be initialized with the following numbers:
 5658845 4520125 7895122 8777541
 8451277 1302850 7580489
•	 hours. An array of seven integers to hold the number of hours worked by each
employee
•	 payRate. An array of seven doubles to hold each employee’s hourly pay rate
•	 wages. An array of seven doubles to hold each employee’s gross wages
The class should relate the data in each array through the subscripts. For example, the
number in element 0 of the hours array should be the number of hours worked by the
employee whose identification number is stored in element 0 of the employeeId array. That
same employee’s pay rate should be stored in element 0 of the payRate array.
In addition to the appropriate accessor and mutator methods, the class should have a
method that accepts an employee’s identification number as an argument and returns the
gross pay for that employee.
 */
public class Payroll {

    private int[] employeeId;
    private int[] hours;
    private double[] payRate;
    private double[] wages;

    public Payroll(){
        this.employeeId = new int[7];
        employeeId[0] = 5658845;
        employeeId[1] = 4520125;
        employeeId[2] = 7895122;
        employeeId[3] = 8777541;
        employeeId[4] = 8451277;
        employeeId[5] = 1302850;
        employeeId[6] = 7580489;
        this.hours = new int[7];
        this.payRate = new double[7];
        this.wages = new double[7];

    }

    public double getGrossPay(int ID) {
        for(int i = 0; i < employeeId.length; i++) {
            if(this.employeeId[i] == ID)
                return this.wages[i];
        }
        return -1;
    }

    public int getEmployeeId(int index) {
        return employeeId[index];
    }

    public void setHours(int index, int hours) {
        this.hours[index] = hours;
        return;
    }

    public int getHours(int index) {
        return this.hours[index];
    }

    public void setPayRate(int index, double Rate) {
        this.payRate[index] = Rate;
        return;
    }

    public double getPayRate(int index) {
        return this.payRate[index];
    }

    public void setWages() {
        for(int i = 0; i < wages.length; i++)
            this.wages[i] = hours[i] * payRate[i];
        return;
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < 7; i++) {
            s += this.getEmployeeId(i) + " " + this.getHours(i) + " " + this.getPayRate(i) + " " + this.getGrossPay(this.getEmployeeId(i)) + "\n";
        }
        return s;
    }


}
