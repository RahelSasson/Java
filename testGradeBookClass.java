import java.util.ArrayList;

public class testGradeBookClass {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Yuji");
        names.add("Kaneki");
        names.add("Shikamaru");
        names.add("Johan");
        names.add("Goku");

        GradeBook grades = new GradeBook(names);
        grades.setTestScores();
        grades.setAverage();
        System.out.println(grades.toString());
    }
}
