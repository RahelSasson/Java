import static java.lang.Character.toUpperCase;

//BD'D
/*
The local Driver’s License Office has asked you to write a program that grades the written
portion of the driver’s license exam. The exam has 20 multiple choice questions. Here are
the correct answers:
1. B
2. D
3. A
4. A
5. C
6. A
7. B
8. A
9. C
10. D
11. B
12. C
13. D
14. A
15. D
16. C
17. C
18. B
19. D
20. A
A student must correctly answer 15 of the 20 questions to pass the exam.
Write a class named DriverExam that holds the correct answers to the exam in an array field.
The class should also have an array field that holds the student’s answers. The class should
have the following methods:
•	 passed. Returns true if the student passed the exam, or false if the student failed
•	 totalCorrect. Returns the total number of correctly answered questions
490 Chapter 7 Arrays and the ArrayList Class
•	 totalIncorrect. Returns the total number of incorrectly answered questions
•	 questionsMissed. An int array containing the question numbers of the questions that
the student missed
 */
public class DriversLicenseExam {
    private char[] examAnswers;
    private char[] studentAnswers;
    private int count;
    private int questionsMissed;

    public DriversLicenseExam(char[] STUDENT_ANSWERS) {
        this.examAnswers = new char[20];
        this.setExamAnswers();
        this.studentAnswers = STUDENT_ANSWERS;
        this.count = 0;
        this.questionsMissed = 0;
    }
    private void setExamAnswers() {
        this.examAnswers[0] = 'B';
        this.examAnswers[1] = 'D';
        this.examAnswers[2] = 'A';
        this.examAnswers[3] = 'A';
        this.examAnswers[4] = 'C';
        this.examAnswers[5] = 'A';
        this.examAnswers[6] = 'B';
        this.examAnswers[7] = 'A';
        this.examAnswers[8] = 'C';
        this.examAnswers[9] = 'D';
        this.examAnswers[10] = 'B';
        this.examAnswers[11] = 'C';
        this.examAnswers[12] = 'D';
        this.examAnswers[13] = 'A';
        this.examAnswers[14] = 'D';
        this.examAnswers[15] = 'C';
        this.examAnswers[16] = 'C';
        this.examAnswers[17] = 'B';
        this.examAnswers[18] = 'D';
        this.examAnswers[19] = 'A';

        return;
    }
    public boolean passed() {
        for(int i = 0; i < examAnswers.length; i++) {
            if(examAnswers[i] == toUpperCase(studentAnswers[i])) {
                this.count++;
            }
            if(toUpperCase(studentAnswers[i]) == 'N')
                questionsMissed++;
        }
        if(this.count >= 15 )
            return true;
        return true;
    }

    public int totalCorrect() {
        return this.count;
    }

    public int totalIncorrect() {
        return 20-this.count;
    }

    public int[] questionsMissed() {
        int[] questionsMissed = new int[this.questionsMissed];
        int index = 0;
        for(int i = 0; i < studentAnswers.length; i++) {
            if (toUpperCase(studentAnswers[i]) == 'N') {
                questionsMissed[index] = i + 1;
                index++;
            }
        }
        return questionsMissed;
        }

    public char[] getExamAnswers() {
        return examAnswers;
    }

    public char[] getStudentAnswers() {
        return studentAnswers;
    }

    public int getQuestionsMissed() {
        return questionsMissed;
    }

    public String toString() {
        String s = "Student Answers: ";
        for(int i = 0; i < studentAnswers.length; i++)
            s += studentAnswers[i] + " ";
        s += "\nExam Answers: ";
        for(int j = 0; j < examAnswers.length; j++)
            s += examAnswers[j] + " ";
        s += "\n";

        s += "Correct: " + this.totalCorrect() + " Incorrect: " + this.totalIncorrect() + "\n";
        if(this.passed())
            s += "Student Passed";
        else
            s += "Student Failed";

        return s;
    }
}
