package textgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator = new Random();
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
	
		
		 String[] words = sourceText.split("\\s+");
	        starter = words[0];
	        ListNode prevWord = new ListNode(starter);

	        for(int i=1; i<words.length; i++){

	            boolean isIn = false;
	            String word = words[i];

	            for(ListNode n: wordList){
	                if(n.getWord().equals(prevWord.getWord())){
	                    n.addNextWord(word);
	                    isIn = true; break;}
	            }if(!isIn){
	                wordList.add(prevWord);
	                prevWord.addNextWord(word);
	            }prevWord = new ListNode(word);
          if(i==words.length-1){
	                if(wordList.contains(prevWord)){
	                    wordList.get(wordList.size()-1).addNextWord(prevWord.getWord()); return;
	                }wordList.add(prevWord);
	                prevWord.addNextWord(starter);
	            }
	        }
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		  if(wordList.size() == 0 || numWords == 0){ return ""; }

	        String currWord = starter;
	        String output = currWord;

	        int i=1;
	        while(i < numWords){
	            for(ListNode n: wordList){
	                if(n.getWord().equals(currWord)){
	                    currWord = n.getRandomNextWord(rnGenerator);
	                    output = output + " " + currWord;
	                    break;
	                }
	            }i++;
	        }return output;
	}
	
	
	
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		 wordList = new LinkedList<>();
	        starter = "";
	        train(sourceText);
	}
	

	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	
/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{

	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		return nextWords.get(generator.nextInt(nextWords.size()));
	    
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}
}

