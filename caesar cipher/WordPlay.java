
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        String s = "aeiouAEIOU";
        if(s.indexOf(ch) != -1){
            return true;
        }else{
            return false;
        }
    }
    public void testIsVowel(){
        System.out.println(isVowel('F'));
        System.out.println(isVowel('f'));
        System.out.println(isVowel('A'));
        System.out.println(isVowel('a'));
        System.out.println(isVowel('5'));
    }
    
    public String replaceVowels (String phrase, char ch){
        StringBuilder output = new StringBuilder(phrase);
        for(int i = 0; i < output.length(); i++){
            char currChar = output.charAt(i);
            if(isVowel(currChar)){
                output.setCharAt(i, ch);
            }
        }
        return output.toString();
    }
    public void testReplaceVowels(){
        String phrase = "Hello, World!";
        System.out.println(replaceVowels(phrase, '*'));
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder output = new StringBuilder(phrase);
        for(int i = 0; i < output.length(); i++){
            char currChar = output.charAt(i);
            if(Character.toUpperCase(currChar) == Character.toUpperCase(ch)){
                if(i % 2 == 0){
                    output.setCharAt(i, '*');
                }else{
                    output.setCharAt(i, '+');
                }
                
            }
        }
        return output.toString();
    }
    public void testEmphasize(){
        String s = "dna ctgaaactga";
        String o = emphasize(s, 'A');
        System.out.println(o);
    }
}
