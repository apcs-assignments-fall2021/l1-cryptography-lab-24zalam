import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String newss="";
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        String alph2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i=0; i<=message.length()-1;i++) {
            int smth = alphabet.indexOf(message.charAt(i));
            if (smth==-1) {
                smth = alph2.indexOf(message.charAt(i));
            if (smth == -1) {
                newss=newss+message.charAt(i);
                continue;
                }
                int smth2 = (3+smth) % 26;
                char ch = alph2.charAt(smth2);
                newss = newss + ch;
                continue;
            }
            int smth2 = (3+smth) % 26;
            char ch = alphabet.charAt(smth2);
            newss = newss + ch;
        }
        return newss;
        }




    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String news="";
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        String alph2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i=0; i<=message.length()-1;i++) {
            int smth = alphabet.indexOf(message.charAt(i));
            if (smth==-1) {
                smth = alph2.indexOf(message.charAt(i));
                if (smth == -1) {
                    news=news+message.charAt(i);
                    continue;
                }
                int smth2 = ((smth-3) +26)% 26;
                char ch = alph2.charAt(smth2);
                news = news + ch;
                continue;
            }
            int smth2 = ((smth-3)+26)% 26;
            char ch = alphabet.charAt(smth2);
            news = news + ch;
        }
        return news;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String newss="";
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        String alph2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i=0; i<=message.length()-1;i++) {
            int smth = alphabet.indexOf(message.charAt(i));
            if (smth==-1) {
                smth = alph2.indexOf(message.charAt(i));
                if (smth == -1) {
                    newss=newss+message.charAt(i);
                    continue;
                }
                int smth2 = (key+smth) % 26;
                char ch = alph2.charAt(smth2);
                newss = newss + ch;
                continue;
            }
            int smth2 = (key+smth) % 26;
            char ch = alphabet.charAt(smth2);
            newss = newss + ch;
        }
        return newss;
    }



    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String newstring="";
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        String alph2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i=0; i<message.length();i++) {
            int alphchar = alphabet.indexOf(message.charAt(i));
            if (alphchar==-1) {
                alphchar = alph2.indexOf(message.charAt(i));
                if (alphchar == -1) {
                    newstring=newstring+message.charAt(i);
                    continue;
                }
                int smth2 = ((alphchar-key)+26) % 26;
                char ch = alph2.charAt(smth2);
                newstring = newstring + ch;
                continue;
            }
            int smth2 = ((alphchar-key)+26) % 26;
            char ch = alphabet.charAt(smth2);
            newstring = newstring + ch;
        }
        return newstring;
    }




    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
