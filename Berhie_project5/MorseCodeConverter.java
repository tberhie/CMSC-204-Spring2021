/**
 * A MorseCodeConverter class
 * @author tsega
 * 
 * */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

    private static MorseCodeTree morseCode = new MorseCodeTree();
    public MorseCodeConverter(){
        morseCode = new MorseCodeTree();
    }
    /**
     * returns a string with all the data in the tree in LNR order with an space in between them.
     * @return the data in the tree in LNR order separated by a space
     **/
     public static String printTree() {

         ArrayList<String> morseTree = morseCode.toArrayList();
         String str = "";

         for(String letter: morseTree) {
             str = str + letter + " ";
         }

         return str.trim();
     }
    /**
     * Converts a file of Morse code into English
     * Each letter is delimited by a space (‘ ‘).
     * @param code
     * @return the english translation
     **/
    public static String convertToEnglish(String code) {
        String[] str = code.split(" / ");
        String english = "";
        String[] letters;
        for(String word: str) {
            letters = word.split(" ");
            for(String codeLetter: letters) {
                english += morseCode.fetch(codeLetter);
            }
            english = english + " ";
        }
        return english.trim();
    }
    
    /**
     * Converts a file of Morse code into English
     * Each letter is delimited by a space (‘ ‘).
     * Each word is delimited by a ‘/’.
     * @param codeFile
     * @throws FileNotFoundException
     * @return English translation
     *
     * */

    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        Scanner keyboard = new Scanner(codeFile);
        String str = "";
        while(keyboard.hasNextLine())
            str = str + keyboard.nextLine() + "\n";
            keyboard.close();
        return convertToEnglish(str.trim());
    }
}
