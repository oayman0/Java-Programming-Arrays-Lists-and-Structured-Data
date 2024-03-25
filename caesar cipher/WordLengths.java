
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts){
        for(String s : resource.words()){
            int count = s.length();
            if(!Character.isLetter(s.charAt(0))){
                count--;
            }
            if(!Character.isLetter(s.charAt(s.length() - 1))){
                count--;
            }
            if(count > 0 && count < 31){
                counts[count]++;
            }
        }
    } 
    
    public void testCountWordLengths(){
        FileResource resource = new FileResource("data/manywords.txt");
        int[] counts = new int[31];
        countWordLengths(resource, counts);
        for(int i = 1; i < counts.length; i++){
            if(counts[i]>0){
                System.out.println("The words with length: " + i + " is " + counts[i]);
            }        
        }
        int maxIndex = indexOfMax(counts);
        System.out.println("The max found count is " + maxIndex);
        
    }
    
    public int indexOfMax(int[] values){
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
}
