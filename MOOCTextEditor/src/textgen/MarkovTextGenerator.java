package textgen;

/**
 *  The interface for the MarkovTextGenerator
 
 *  
 */
public interface MarkovTextGenerator {
	
	/** Train the generator by adding the sourceText */
	public void train(String sourceText);
	
	/** Generate the text with the specified number of words */
	public String generateText(int numWords);
	
	/** Retrain the generator from scratch on the source text */
	public void retrain(String sourceText);
}
