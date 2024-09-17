package engine;

/**
 * User component of the system
 * 
 * Ignore this:
 * import java.util.InputMismatchException;
 * import java.util.Scanner;
 * 
 */

/** Prompt the user to enter a positive integer. 
* Any integer greater than zero and less than Integer.MAX_VALUE is valid.
* Throw an error for incorrect input.
* This data will be stored in an object.
* 
* 
*/

/** Prompt the user to enter an output source.
* This can be a file location. This will be stored in an object.
*/

/** Prompt the user to enter delimiters. Have cases for invalid
* delimiters and blank input. For blank input set a default delimiter.
*/

/**
 * Get user input and send a compute request to the compute engine.
 */


/** Some random code. Possibly for later use.
*private int getUserInput() throws Exception {
*	Scanner sc = new Scanner(System.in);
*	System.out.println("Enter a positive integer that is greater than 0 and less than *   2,147,483,647:");
*	int input = sc.nextInt();
*	
*	try {
*		if(input < 0) {
*			sc.close();
*			throw new Exception("Input cannot be negative.");
*		} else if(input > Integer.MAX_VALUE) {
*			sc.close();
*			throw new Exception("Input cannot be larger than 2,147,483,647.");
*		} else {
*			sc.close();
*			return input;
*		}
*	} catch(InputMismatchException e) {
*		System.out.println("Invalid input.");
*		sc.close();
*	}
*	
*	return input;
*}
*
*/


public interface ProtoUser {
	
	/**
	 * 
	 * @param ProtoComputeInit to get the user input.
	 * 
	 * This method transfers the user input through the compute engine and
	 * determines if it is a valid input or not.
	 */
	
	public void prototype(ProtoDataStream data);

	
}

