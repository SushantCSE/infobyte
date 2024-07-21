import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 3;  // Number of rounds
        int totalScore = 0;

        System.out.println("Welcome to 'Guess the Number' game!");

        for (int round = 1; round <= rounds; round++) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + round + ": Guess a number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {
                attempts++;
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += (MAX_ATTEMPTS - attempts + 1) * 10;  // Points based on remaining attempts
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("The number is higher than " + userGuess);
                } else {
                    System.out.println("The number is lower than " + userGuess);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + randomNumber);
            }

            System.out.println("End of Round " + round);
        }

        System.out.println("Game Over! Your total score is: " + totalScore);
        scanner.close();
    }
}
