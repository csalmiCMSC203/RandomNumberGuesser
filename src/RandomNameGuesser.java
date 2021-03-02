import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor:
 * Description: This application will receive a guess and report if the guess is the random number that was generated.  
 * The application will narrow down the choices according to the previous guesses and continue to prompt the user to 
 * enter a guess until they guess correctly.
 * Due: 03/01/2021
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Cherise Salmi
*/

public class RandomNameGuesser {

	public static void main(String[] args) {
		int nextGuess;
		Scanner keyboard = new Scanner(System.in);
		
		//Ask user if they want to play and check their answer.
		System.out.println("This application will ask you to guess a random number between 0 and 100.\nWould you like to play?");
		String userPlay = keyboard.nextLine();
		// If user does not enter yes or no, keep asking them to enter yes or no. Do this until they enter yes/no.
		while (!(userPlay.equalsIgnoreCase("yes") || userPlay.equalsIgnoreCase("no"))) 
		{
			System.out.println("Please enter yes or no.");
			userPlay = keyboard.nextLine();
		}
		// If user enter yes, run ask them to guess a number. This will keep going until the are correct. If no display good bye and program ends.
		if (userPlay.equalsIgnoreCase("yes")) 
		{
			String userPlayAgain;
			do
			{
				int random = RNG.rand();
				int lowGuess = 0, highGuess = 100;
				System.out.println("Enter your first guess.");
				//This will run until user guess correctly
				do {
					nextGuess = keyboard.nextInt();
					if (RNG.inputValidation(nextGuess, lowGuess, highGuess)) 
					{
						if (nextGuess < random) {
							lowGuess = nextGuess;
						}
						else if(nextGuess >random) {
							highGuess = nextGuess;
						}
							Compares(nextGuess, random, lowGuess, highGuess);
							
					}
					
				}while(!(nextGuess == random) );
				
				System.out.println("Try Again? (Yes or No)");
				userPlayAgain = keyboard.nextLine();
				userPlayAgain = keyboard.nextLine();
				
			}while(Play(userPlayAgain));
			System.out.println("Good Bye!\nBy Cherise Salmi");
		}
		else 
			System.out.println("Good Bye!\nBy Cherise Salmi");
		
	}
	/* 
	 * This method will compare if the user input is a higher guess or lower guess than the random number.
	 */
	public static void Compares(int nextGuess, int random, int lowGuess, int highGuess) {
		int numTry = RNG.getCount();
		if (nextGuess == random) {
			System.out.println("Congratulations! You are correct.\nNumber of guesses are " + numTry + ".");
		}
		else if (nextGuess < random) {
			System.out.println("Number of guesses are " + numTry + ".\nYour guess is too low.\nEnter your next guess between " +
			lowGuess +  " and " + highGuess + ".");
		}
		else if (nextGuess > random) {
			System.out.println("Number of guesses are " + numTry + ".\nYour guess is too high.\nEnter your next guess between " +
			lowGuess +  " and " + highGuess + ".");
		}
	}
	//This method will make sure that the user entered yes or no
	
	public static boolean Play(String userPlayAgain) {
		
		if (userPlayAgain.equalsIgnoreCase("yes"))
			return true;
		else 
			return false;
	}
}
