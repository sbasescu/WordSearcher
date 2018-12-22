import java.util.*;

public class Word implements Comparable<Word>{
	private String text = "";
	private ArrayList<String> fileList = new ArrayList<String>();
	
	/*
	 * Setter for word object's word
	 */
	public void setWord(String w) {
		text = w;
	}
	/*
	 * Getter for word object's word
	 */
	public String getWord() {
		return text;
	}
	/*
	 * Setter for word object's fileList
	 */
	public void setFileList(ArrayList<String> s) {
		this.fileList = s;
	}
	/*
	 * Getter for word object's fileList 
	 */
	public ArrayList<String> getFileList() {
		return fileList;
	}
	/*
	 * compareTo method for Word objects that compares their text        
	 */
	public int compareTo(Word other) {
		return text.compareTo(other.getWord());
	}
	/*
	 * Adds a string (which will be the name of a file that holds the word) to the word's fileList
	 */
	public void add (String f) {
		fileList.add(f);
	}
	
	/*
	 * toString method for the word object that prints out the word along with the files that contain it
	 */
	public String toString() {
		String allFiles = "";
		for (int i = 0; i < fileList.size(); i++) {
			allFiles += fileList.get(i) + " ";
		}
		return ("files containing " + text + ": " + allFiles);
	}	
}
