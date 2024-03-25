
/**
 * Write a description of TestOOPCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestOOPCaesarCipher {
    public int[] countLetters(String encrypted){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        encrypted = encrypted.toLowerCase();
        int[] freqs = new int[26];
        for(int i = 0; i < encrypted.length(); i++){
            if(Character.isLetter(encrypted.charAt(i))){
                int index = alph.indexOf(encrypted.charAt(i));
                freqs[index] ++;
            }
        }
        return freqs;
    }
    public int maxIndex(int[] values){
        int maxValue = 0;
        int maxIndex = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i] > maxValue){
                maxValue = values[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public void simpleTests (){
        FileResource resource = new FileResource();
        String input = resource.asString();
        OOPCaesarCipher cc = new OOPCaesarCipher(15);
        String encrypted = cc.encrypt(input);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted Text:" + decrypted);
        
        String breaked = breakCaesarCipher(encrypted);
        System.out.println("Auto Decrypted Text:" + breaked);
    }
     public String breakCaesarCipher(String input){
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4){
          dkey = 26-(4 - maxDex);      
        }
        OOPCaesarCipher cc = new OOPCaesarCipher(dkey);
        String message = cc.decrypt(input);
        return message;
    }
    
}
