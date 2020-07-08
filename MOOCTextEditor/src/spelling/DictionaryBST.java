package spelling;

import java.util.TreeSet;


public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
   
	
   public DictionaryBST() {
	   dict = new TreeSet<String>();
   }
    
    /** Add this word to the dictionary
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     */
    public boolean addWord(String word) {
  
    	word = word.toLowerCase() ; 
    	if(word == null) {
    		throw new NullPointerException();
    	}
    	if(dict.size() == 0) {
    		dict.add(word);
    		return true;
    	}
    	if(dict.contains(word)) {
    		return false ;
    	}
    	dict.add(word);
        return true;
        
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String word ) {
    
    	word = word.toLowerCase() ; 
    	if(word == null) {
    		throw new NullPointerException();
    	}
    	if(dict.size() == 0) {
    		
    		return false;
    	}
        return dict.contains(word);
        
    }

}
