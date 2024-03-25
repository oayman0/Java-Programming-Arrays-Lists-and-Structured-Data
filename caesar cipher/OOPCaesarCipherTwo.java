
/**
 * Write a description of OOPCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OOPCaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int k1;
    private int k2;
    public OOPCaesarCipherTwo(int key1, int key2){
         k1 = key1;
         k2 = key2;
         alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
         shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
    }
    public String encrypt(String input){
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
    public String decrypt (String input){
        OOPCaesarCipherTwo cc = new OOPCaesarCipherTwo(26 - k1, 26 - k2);
        String output = cc.encrypt(input);
        return output;
    }
}
