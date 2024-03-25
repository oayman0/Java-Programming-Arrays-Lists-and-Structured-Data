
/**
 * Write a description of Caesar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher{
    public String encrypt(String input, int key){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        StringBuilder output = new StringBuilder(input);
        for(int i = 0; i < output.length(); i++){
            char currChar = output.charAt(i);
            if(Character.isAlphabetic(currChar)){
                
                char upperCaseChar = Character.toUpperCase(currChar);
                int index = alphabet.indexOf(upperCaseChar);
                char encryptedChar = shiftedAlphabet.charAt(index);
                if(Character.isLowerCase(currChar)){
                    output.setCharAt(i, Character.toLowerCase(encryptedChar));
                }else{
                    output.setCharAt(i, encryptedChar);
                }
                
            }
        }
        return output.toString();
    }
    public void testEncrypt(){
        int key = 80;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        
    }
    
    public String encryptTwoKeys (String input, int key1, int key2){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        
        StringBuilder output = new StringBuilder(input);
        for(int i = 0; i < output.length(); i += 2){
            char currChar = output.charAt(i);
            if(Character.isAlphabetic(currChar)){
                
                char upperCaseChar = Character.toUpperCase(currChar);
                int index = alphabet.indexOf(upperCaseChar);
                char encryptedChar = shiftedAlphabet1.charAt(index);
                if(Character.isLowerCase(currChar)){
                    output.setCharAt(i, Character.toLowerCase(encryptedChar));
                }else{
                    output.setCharAt(i, encryptedChar);
                }
                
            }
        }
         for(int i = 1; i < output.length(); i += 2){
            char currChar = output.charAt(i);
            if(Character.isAlphabetic(currChar)){
                char upperCaseChar = Character.toUpperCase(currChar);
                int index = alphabet.indexOf(upperCaseChar);
                char encryptedChar = shiftedAlphabet2.charAt(index);
                if(Character.isLowerCase(currChar)){
                    output.setCharAt(i, Character.toLowerCase(encryptedChar));
                }else{
                    output.setCharAt(i, encryptedChar);
                }
                
            }
        }
        return output.toString();
    }
    public void testEncryptTwoKeys(){
        String s = encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21);
        System.out.println(s);
    }
}
