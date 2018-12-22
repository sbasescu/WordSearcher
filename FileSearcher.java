import java.io.*;
import java.util.*;

public class FileSearcher {
	static BinarySearchTree<Word> words = new BinarySearchTree<Word>(); //Initializes a binary search tree that
	//will hold all the words in all the files as word objects

	public static void main(String[] args) throws IOException {
		File f = new File(args[0]); //f = name of directory
		scanFiles(f); //calls scanFiles on the name of directory
		boolean go = true; //will be set to false when user wants to quit
		while (go) {
			Scanner kb = new Scanner(System.in);
			System.out.println("Please enter a command (a, s, or q)>>");
			String command = kb.nextLine();
			if (command.equals("a")) { 
				words.printTree(); //will print out all the elements in order of the Binary Search Tree
			}	
			else if (command.equals("s")) { 
				System.out.println("Word to find>>");
				String str = kb.nextLine();
				Word search = new Word();
				search.setWord(str); //word object search now has user input as its word string
				if (words.contains(search)) { //if word appears in the binary search tree
					Word found = words.find(search);
					System.out.println(found); //prints the list of files in which the word appears
				}
				else //if words does not contain the word being searched
					System.out.println(search.getWord() + " is not found");
			}
			else //if command.equals("q")
				go = false; //leaves the while loop 
		}
	}
	/*
	 * Scans through all the files in a directory and adds every word in those files to a Binary Search Tree
	 */
	public static void scanFiles (File folder) throws IOException {

		File [] list = folder.listFiles(); //gets array of all folders in the parameter 
		for (int i = 0; i < list.length; i++) { //loops through all folders in the parameter
			if(!list[i].isHidden()){
				if (list[i].isDirectory())
					scanFiles(list[i]); //recursively calls scanFiles if the parameter is a directory
				else { //if parameter is a text file
					Scanner fr = new Scanner(list[i]); 
					while (fr.hasNext()) { //scans through document element by element
						Word w = new Word(); //creates word object for each element in the file
						String str = fr.next(); 
						String temp = ""; //will become the string for the word without punctuation
						for (int j = 0; j < str.length(); j++) {
							if (Character.isLetter(str.charAt(j)) || Character.isDigit(str.charAt(j))) {
								temp += str.charAt(j); //temp now consists of all the characters in a word
								//that are letters or numbers
							}
						}
						w.setWord(temp);
						if (words.contains(w)) { //if the BST already contains the word object
							Word g = words.find(w); //gets the word object in the BST
							g.add(list[i].getName()); //adds the name of the file that the word appears in to 
							//the word's fileList
						}
						else { //if the BST does not contain the word object
							w.add(list[i].getName()); //adds the name of the file that the word appears in to 
							//the words fileList
							words.insert(w); //inserts the word into the BST
						}	
					}
				}
			}
		}
	}
}

