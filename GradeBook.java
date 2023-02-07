import java.util.ArrayList;
import java.util.Scanner;

public class GradeBook {
    private ArrayList<String> studentNames;
    private char[] grades;
    private double[][] testScores;
    private double[] averages;

    public GradeBook(ArrayList<String> STUDENT_NAMES) {
        this.studentNames = STUDENT_NAMES;
        this.grades = new char[5];
        this.testScores = new double[5][4];
        this.averages = new double[5];
    }

    public void setTestScores() { 
        Scanner s = new Scanner(System.in);
            for (int j = 0; j < testScores.length; j++) {
                System.out.println("enter scores for student: " + studentNames.get(j));
                for (int k = 0; k < testScores[j].length; k++) {
                    System.out.println("enter score " + (k + 1) + ": ");
                    testScores[j][k] = s.nextDouble();
                }
            }
        return;
    }

    //drops lowest score and assigns grade
    public void setAverage() {
        double lowest = testScores[0][0];
        boolean lowestExists = false;
        double sum = 0;
        for(int i = 0; i < testScores.length; i++) {
            for (int j = 0; j < testScores[i].length; j++) {
                sum += testScores[i][j];
                if(testScores[i][j] < lowest) {
                    lowest = testScores[i][j];
                    lowestExists = true;
                }
            }

            double average = 0;
            if(lowestExists == false)
                average = (sum/4);
            else
                average = ((sum-lowest) / 3);

            averages[i] = average;
            setGrade(average, i);

            sum = 0;
            lowest = testScores[i][0];
            lowestExists = false;
        }
    return;
    }

    public void setGrade(double average, int index) {
        char grade = ' ';
        if(average >= 90 && average <= 100)
            grade = 'A';
        else if(average >= 80 && average <= 89)
            grade = 'B';
        else if(average >= 70 && average <= 79)
            grade = 'C';
        else if(average >= 60 && average <= 69)
            grade = 'D';
        else if(average >= 0 && average <= 59)
            grade = 'F';

        grades[index] = grade;
    }

    public double getAverage(String student) {
        for(int i = 0; i < studentNames.size(); i++)
            if(studentNames.get(i).equalsIgnoreCase(student))
                return averages[i];
        return -1;
    }

    public char getGrade(String student) {
        for(int i = 0; i < studentNames.size(); i++)
            if(studentNames.get(i).equalsIgnoreCase(student))
                return grades[i];
        return ' ';
    }

    public String toString() {
        String s = "";

        for (int i = 0; i < studentNames.size(); i++) {
            s += studentNames.get(i) + "\n";
            for (int j = 0; j < testScores.length; j++) {
                for (int k = 0; k < testScores[j].length; k++)
                    s += testScores[i][k] + " ";
                s += "\nAverage Score: " + getAverage(studentNames.get(i)) + " Grade: " + getGrade(studentNames.get(i)) + "\n";
                break;
            }
        }
        return s;
    }

}
