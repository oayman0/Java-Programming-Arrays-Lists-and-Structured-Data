
/**
 * Write a description of TestOOPCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestOOPCaesarCipherTwo {
    public String halfOfString(String message, int start){
        StringBuilder output = new StringBuilder();
        for(int i = start; i < message.length(); i+=2){
            output.append(message.charAt(i));
        }
        return output.toString();
    }
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
    public int getKey(String s){
       int[] freqs = countLetters(s);  
       int maxDex = maxIndex(freqs); 
       int dkey = maxDex -4;
        if(maxDex < 4){
          dkey = 26-(4 - maxDex);      
        }
       return dkey; 
    }
    public void simpleTests(){
        FileResource resource = new FileResource();
        String input = resource.asString();
        OOPCaesarCipherTwo cc = new OOPCaesarCipherTwo(21, 8);
        String encrypted = cc.encrypt(input);
        String decrypted = cc.decrypt(encrypted);
        //System.out.println("Encrypted text: " + encrypted);
        //System.out.println("Decrypted Text:" + decrypted);
        
        //String breaked = breakCaesarCipher(encrypted);
        //System.out.println("Auto Decrypted Text:" + breaked);
        
        
        String test = breakCaesarCipher(input);
        System.out.println("Decrypted the encrypted Text:" + test);
    }
    public String breakCaesarCipher(String input){
        String sub1 = halfOfString(input, 0);
        String sub2 = halfOfString(input, 1);
        int key1 = getKey(sub1);
        int key2 = getKey(sub2);
        System.out.println("The first key is " + key1);
        System.out.println("The Second key is " + key2);
        OOPCaesarCipherTwo cc = new OOPCaesarCipherTwo(key1, key2);
        String message = cc.decrypt(input);
        return message;
    }
    
}
