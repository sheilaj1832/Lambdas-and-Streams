import java.util.Scanner;

public class ReplaceApp {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Welcome to the Replace vowels app");
		System.out.println();
		
		//Prompt for user data
		System.out.print("Enter a phrase to be magically converted: ");
		String s = sc.nextLine();
		System.out.println();
		
		//Create an array and assign values in one statement
		String[] vowels = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
		
		//Use an enhanced for loop
		for(String vowel : vowels)
		    s = s.replace(vowel, "*");
			System.out.println(s);		
			
		System.out.println("\nBye!");
		
		
		sc.close();
	}
}
