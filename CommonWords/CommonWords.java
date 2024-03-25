/**
 * Count common words in Shakespeare's works
 * 
 * @author Duke Software Team
 * @version 1.0
 */
import edu.duke.*;

public class CommonWords{
    public String[] getCommon(){
        FileResource resource = new FileResource("data/common.txt");
        String[] common = new String[20];
        int index = 0;
        for(String s : resource.words()){
            common[index] = s;
            index += 1;
        }
        return common;
    }
    
    public int indexOf(String[] list, String word) {
        for (int k=0; k<list.length; k++) {
            if (list[k].equals(word)) {
                   return k;
               }
           }
        return -1;
    }
    
    public void countWords(FileResource resource, String[] common, int[] counts){
        for(String word : resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common,word);
            if (index != -1) {
                counts[index] += 1;
            }
        }
    }
    void countShakespeare(){
        //String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
            //          "likeit.txt", "macbeth.txt", "romeo.txt"};
        String[] plays = {"small.txt"};
        String[] common = getCommon();
        int[] counts = new int[common.length];
        for(int k=0; k < plays.length; k++){
            FileResource resource = new FileResource("data/" + plays[k]);
            countWords(resource,common,counts);
            System.out.println("done with " + plays[k]);
        }
        
        for(int k=0; k < common.length; k++){
            System.out.println(common[k] + "\t" + counts[k]);
        }
    }
    
    public void _countShakespeare(){
        String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
            "likeit.txt", "macbeth.txt", "romeo.txt"};
        String[] common = _getCommon();
        int[] counts = new int[common.length];
        for(int i = 0; i < plays.length; i++){
            FileResource resource = new FileResource("data/" + plays[i]);
            for(String s : resource.words()){
                for(int j = 0; j < common.length; j++){
                    if(common[j].toLowerCase().equals(s.toLowerCase())){
                        counts[j]++;
                        break;
                    }                   
                }
            
            }
            System.out.println("For the play "+ plays[i]);
            for(int k = 0; k < common.length; k++){
                System.out.println(common[k] +" was found " + counts[k]+" times.");
            }
            
        }
        
    }
    public String[] _getCommon(){
        FileResource resource = new FileResource("data/common.txt");
        String[] words = new String[20];
        int index = 0;
        for(String s : resource.words()){
            words[index] = s;
            index++;
        }
        return words;
    }
    
    
}
