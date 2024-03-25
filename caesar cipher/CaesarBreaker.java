
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarBreaker {
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
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex -4;
        if(maxDex < 4){
          dkey = 26-(4 - maxDex);      
        }
        String message = cc.encrypt(encrypted, 26 - dkey);
        return message;
    }
    public void testDecrypt(){
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt("etwo ipher cr CaesarBreaker class.", 15);
        System.out.println(decrypt(message));
    }
    public String halfOfString(String message, int start){
        StringBuilder output = new StringBuilder();
        for(int i = start; i < message.length(); i+=2){
            output.append(message.charAt(i));
        }
        return output.toString();
    }
    public void testHalfOfString(){
        System.out.println(halfOfString("Qbkm Zgis", 0));
        System.out.println(halfOfString("Qbkm Zgis", 1));
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
    public String decryptTwoKeys(String encrypted){
        String sub1 = halfOfString(encrypted, 0);
        String sub2 = halfOfString(encrypted, 1);
        int key1 = getKey(sub1);
        int key2 = getKey(sub2);
        System.out.println("The first key is " + key1);
        System.out.println("The Second key is " + key2);
        CaesarCipher cc = new CaesarCipher();
        String message1 = cc.encrypt(sub1, 26 - key1);
        String message2 = cc.encrypt(sub2, 26 - key2);
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < message1.length(); i++){
            output.append(message1.charAt(i));
            if(i < message2.length()){
                output.append(message2.charAt(i));
            }
        }
        return output.toString();
    }
    public void testDecryptTwoKeys(){
        FileResource resource = new FileResource("data/wordsLotsOfEsEncrypted.txt");
        String output = decryptTwoKeys(resource.asString());
        System.out.println(output);
    }
    
}
