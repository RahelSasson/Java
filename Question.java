import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Question {
    private String triviaQuestion;
    private String[] answers;
    private int correctAnswer;
    public Question(String TRIVIA_QUESTION, String[] ANSWERS, int CORRECT_ANSWER) {
        this.triviaQuestion = TRIVIA_QUESTION;
        this.answers = ANSWERS;
        this.correctAnswer = CORRECT_ANSWER;
    }
    public String getTriviaQuestion() {
        return triviaQuestion;
    }
    public void getAnswers() {
        for(int i = 0; i < answers.length; i++)
            System.out.println(answers[i]);
    }
    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
