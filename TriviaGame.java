//BS'D
/*
In this programming challenge, you will create a simple trivia game for two players. The
program will work like this:
•	 Starting with player 1, each player gets a turn at answering 5 trivia questions. (There
are 10 questions, 5 for each player.) When a question is displayed, four possible
answers are also displayed. Only one of the answers is correct, and if the player selects
the correct answer, he or she earns a point.
•	 After answers have been selected for all of the questions, the program displays the
number of points earned by each player and declares the player with the highest number of points the winner.
494 Chapter 7 Arrays and the ArrayList Class
You are to design a Question class to hold the data for a trivia question. The Question class
should have String fields for the following data:
•	 A trivia question
•	 Possible answer 1
•	 Possible answer 2
•	 Possible answer 3
•	 Possible answer 4
•	 The number of the correct answer (1, 2, 3, or 4)
The Question class should have appropriate constructor(s), accessor, and mutator methods.
The program should create an array of 10 Question objects, one for each trivia question. (If
you prefer, you can use an ArrayList instead of an array.) Make up your own trivia questions on the subject or subjects of your choice for the objects.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) throws FileNotFoundException {

        File myFile = new File("questions.txt");
        Scanner s = new Scanner(myFile);
        ArrayList<Question> questionsAndAnswers = new ArrayList<>();

        while (s.hasNext()) {
            for (int i = 0; i < 10; i++) {
                String question = s.nextLine();
                String[] answers = new String[4];
                int correctAns = 0;
                for (int j = 0; j < answers.length; j++) {
                    String str = s.nextLine();
                    if (str.charAt(str.length() - 1) == '!') {
                        str = str.replaceAll("!", " ");
                        correctAns = j + 1;
                    }
                    answers[j] = str;
                }
                questionsAndAnswers.add(new Question(question, answers, correctAns));
            }
        }

        int player1 = amountCorrect(questionsAndAnswers, 1);
        int player2 = amountCorrect(questionsAndAnswers, 2);
        System.out.println("Player 1 Points: " + player1 + "  Player 2 Points: " + player2);
        if (player1 > player2)
            System.out.println("Player 1 wins!");
        else if (player2 > player1)
            System.out.println("Player 2 wins!");
        else
            System.out.println("Its a tie!");




}

    public static int amountCorrect(ArrayList<Question> questionsAndAnswers, int player) {
        int start;
        int end;
        if(player == 1) {
            start = 0;
            end = questionsAndAnswers.size() /2;
        }
        else {
            start = questionsAndAnswers.size() /2;
            end = questionsAndAnswers.size();
        }

        int countCorrect = 0;
        Scanner user = new Scanner(System.in);
        for(int i = start; i < end; i++) {
            System.out.println(questionsAndAnswers.get(i).getTriviaQuestion());
            questionsAndAnswers.get(i).getAnswers();
            System.out.println("Enter number of correct answer");
            int n = user.nextInt();
            if(n == questionsAndAnswers.get(i).getCorrectAnswer())
                countCorrect++;
        }
        return countCorrect;
    }
}
