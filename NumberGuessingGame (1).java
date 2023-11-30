import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerRange = 1;
        int upperRange = 100;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        int rounds = getRounds(scanner);

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round + ":");
            int secretNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = playRound(scanner, secretNumber, lowerRange, upperRange);
            totalAttempts += attempts;
            if (attempts == -1) { // Check if the round ended due to time limit
                break; // Exit the game early if time limit was reached
            }
        }

        double averageAttempts = (double) totalAttempts / rounds;
        System.out.println("\nGame Over! Your average attempts per round: " + averageAttempts);
        scanner.close();
    }

    public static int getRounds(Scanner scanner) {
        System.out.print("How many rounds do you want to play? ");
        int rounds = 0;
        while (rounds <= 0) {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // discard the invalid input
            }
            rounds = scanner.nextInt();
            if (rounds <= 0) {
                System.out.println("Please enter a positive number.");
            }
        }
        return rounds;
    }

    public static int playRound(Scanner scanner, int secretNumber, int lowerRange, int upperRange) {
        int attempts = 0;
        long startTime = System.currentTimeMillis();
        long timeLimit = 60000; // 60 seconds in milliseconds
        int maxAttempts = 10; // Maximum attempts per round

        while (true) {
            long currentTime = System.currentTimeMillis();
            // Check if time limit exceeded
            if (currentTime - startTime > timeLimit) {
                System.out.println("Time's up! You didn't guess the number within 60 seconds.");
                return -1; // Return -1 to indicate the time limit was reached
            }

            // Check if maximum attempts are exceeded
            if (attempts >= maxAttempts) {
                System.out.println("You've reached the maximum number of attempts. The number was " + secretNumber);
                return attempts;
            }

            System.out.print("Guess the number between " + lowerRange + " and " + upperRange + ": ");
            int userGuess = scanner.nextInt(); // Assume the user always enters an integer
            attempts++;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
                return attempts;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }
        }
    }
}
