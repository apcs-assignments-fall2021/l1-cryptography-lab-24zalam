import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        String newss="";
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        String alph2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int keys=Integer.parseInt(key);

        for(int i=0; i<=message.length()-1;i++) {
            int smth = alphabet.indexOf(message.charAt(i));
            if (smth==-1) {
                smth = alph2.indexOf(message.charAt(i));
                if (smth == -1) {
                    newss=newss+message.charAt(i);
                    continue;
                }
                int smth2 = (keys+smth) % 26;
                char ch = alph2.charAt(smth2);
                newss = newss + ch;
                continue;
            }
            int smth2 = (keys+smth) % 26;
            char ch = alphabet.charAt(smth2);
            newss = newss + ch;
        }
        return newss;
    }



    public static String decryptVigenere(String message, String key) {
        String news="";
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        String alph2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int keys=Integer.parseInt(key);
        for(int i=0; i<=message.length()-1;i++) {
            int smth = alphabet.indexOf(message.charAt(i));
            if (smth==-1) {
                smth = alph2.indexOf(message.charAt(i));
                if (smth == -1) {
                    news=news+message.charAt(i);
                    continue;
                }
                int smth2 = (smth-keys) % 26;
                char ch = alph2.charAt(smth2);
                news = news + ch;
                continue;
            }
            int smth2 = (smth-keys) % 26;
            char ch = alphabet.charAt(smth2);
            news = news + ch;
        }
        return news;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
