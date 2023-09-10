
import java.util.Scanner;

public class CaesarCipher {

    // Encrypts the message using a Caesar cipher with the given offset
    public static String cipher(String message, int offset) {
        char[] encryptedMessage = new char[message.length()]; // Encrypted message should have the same length as the message

        for (int i = 0; i < message.length(); i++) { // Loop through each character in the message entered
            char c = message.charAt(i); //

            if (Character.isLetter(c)) { // Checks if the character is a letter
            	char startingPoint = (c >= 'A' && c <= 'Z') ? 'A' : 'a'; // Set the starting point at character A/a
                char shiftedLetter = (char) (startingPoint + (c - startingPoint + offset) % 26); // This has to be "cast" to char to prevent the data type from changing
                // The formula keeps the characters within the 26 letters of the alphabet while shifting them to the appropriate position

                encryptedMessage[i] = shiftedLetter; // The shifted letter is stored in the corresponding i position in encryptedMessage
            } else {
                encryptedMessage[i] = c; // Leave non-alphabet characters unchanged
            }
        }

        return new String(encryptedMessage); // Returns the encrypted message
    }

    public static void main(String[] args) {
        System.out.println("Please enter your message: "); //ask for message

        Scanner input = new Scanner(System.in); // Takes the message from the user
        String message = input.nextLine();

        System.out.println("Please enter your offset: "); // ask for offset

        int offset = input.nextInt(); // Takes the offset from the user
        
        String eMessage = cipher(message, offset); //runs the cipher method using the entered message and offset

        System.out.println("Encrypted Message: " + eMessage); // Outputs the encrypted message
    }
}