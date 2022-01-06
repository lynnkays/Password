/**
 * <Kaylynn Diaz-Schott>
 * 
 * <Takes in users password and then makes sure it follows certain requirements>
 */

import java.io.*;		
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException
	{
		char ch;
		String password2;
		boolean result;
		boolean digits = false;
    boolean specialC = false;
    boolean valid = false;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Valid passwords include a minimum of 8 characters that includes at least one digit and at least one of the following special characters: ! @ # $ *");

		System.out.print("\nPlease enter a Password: ");
		String password = s.nextLine();		
		
		while (password.length() <= 7) {
			System.out.println("Invalid Password - must be at least 8 characters");
     		System.out.print("\nPlease enter a Password: ");
     		password = s.nextLine();	
		}
				
   		while (valid == false) {
			for (int i = 0; i < password.length();i++) {
				ch = password.charAt(i);
				if ((Character.isDigit(ch) )){
						digits = true; 
				} 
		
				if ((Character.isDigit(ch) || ch == '!' || ch == '@' || ch == '#' || ch == '$' || ch == '*')) {
					specialC = true;
				} 
			}
				
			if (digits == false) {
				System.out.println("Invalid Password - must contain at least one digit");
				System.out.print("\nPlease enter a Password: ");
				password = s.nextLine();
			}
			if (specialC == false) {
				System.out.println("Invalid Password - must contain at least one of the following characters: ! @ # $ * ");
				System.out.print("\nPlease enter a Password: ");
				password = s.nextLine();
				
			}
			if (digits == true && specialC == true) {
				valid = true;	
			}
    	}
        

	// Write code here to verify same matching password
	do {
		System.out.print("\nPlease re-enter a Password: ");
		password2 = s.nextLine(); 
		
		if(password.equals(password2)) {
			result = true;
			System.out.println("Password setup successful");

		} else {
			result = false;
		}
		
	} while (result == false);

  s.close();

	// Encrypt/Write PW to text file here using StringBuilder
	PrintWriter output = new PrintWriter ("Password.txt"); 
	
	for (int i = 0; i < password.length();i++) {
		ch = password.charAt(i);
		int asciiVal = (int) ch;
		output.print(asciiVal + ", ");
	}

        
	// Output WID and Test Scores to the Textfile        
	output.println("\n87656786\t\t\t\t 98");
	output.println("89273641\t\t\t\t 67");
	output.println("82839485\t\t\t\t 78");
	output.println("89127364\t\t\t\t 87");
	output.println("84567456\t\t\t\t 78");
	output.println("87456767\t\t\t\t 99");
	
        
	// Close the output file     
	output.close();
        
  } // end main
} // end class	
		