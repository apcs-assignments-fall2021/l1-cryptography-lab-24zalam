import java.util.Scanner;



public class Vigenere {


    public static char encryptCaesarLetter(char ch, int key) {
       String str=ch+"";
       String encrypted=Caesar.encryptCaesarKey(str,key);
        return encrypted.charAt(0);
    }






//HELLO, WORLD
    //CAR
    public static String encryptVigenere(String message, String key) {
        String res = "";
        message = message.toUpperCase();
        for (int i = 0, j = 0; i < message.length(); i++)
        {
            char z =message.charAt(i);
            if (z < 'A' || z > 'Z')
                continue;
            res += (char) ((z + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
    /* String yes = "";
        message = message.toUpperCase();
        key = key.toUpperCase();
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int j = 0;
        for (int i = 0; i < message.length(); i++){
            if (alpha.indexOf(message.charAt(i)) >= 0){
                yes += alpha.charAt(alpha.indexOf(message.charAt(i)) + alpha.indexOf(key.charAt((i)%key.length())));
            }
            else{
                yes += message.charAt(i);
                j += 1;
                if(j>=key.length());
                {
                    j = 0;

*/




     public static String decryptVigenere (String message, String key) {

         String res = "";
         message = message.toUpperCase();
         for (int i = 0, j = 0; i < message.length(); i++) {
             char c = message.charAt(i);
             if (c < 'A' || c > 'Z')
                 continue;
             res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
             j = ++j % key.length();

         }
         return res;
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

