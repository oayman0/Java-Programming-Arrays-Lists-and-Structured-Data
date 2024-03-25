
/**
 * Write a description of OOPCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OOPCaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public OOPCaesarCipher(int key){
         alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
         mainKey = key;
    }
    public String encrypt(String input){
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
    public String decrypt(String input){
        OOPCaesarCipher cc = new OOPCaesarCipher(26 - mainKey);
        String output = cc.encrypt(input);
        return output;
    }
}
