# Word-Searcher
This program searches text files for word given by user input and lists all of the files in which the word appears. 

My program works by getting the name of the directory from the command line and calling the scanFiles method with that directory as its parameter. The scanFiles method works by going recursively going through the directory until it reaches the text files. Once it reaches a text file, it creates a filereader scanner for that file. For each word in each file, it creates a word object and  uses the object’s setter method to set the text for that word object to the word in the file (note that all punctuation is removed). It then adds that word to the Binary Search Tree initialized at the top of the class, and updates that word’s fileList to contain the name of the file that it appears in using the word object’s add method. If the Binary Search Tree already contains that word (it was found in another file) it updates the word object’s fileList to contain the name of the file that it appears in. Then, when the user types in the command “a,” my program prints the entire Tree using the printTree method, and the word object’s toString method. If the user wants to search for a word in the files (types “s” as a command), my program creates a new word object with the user’s input as its text. It then uses the BST contains method to search for that word, and if it is found, it prints out the files that contain the word. If the word does not appear in any of the files, the program tells that the word is not found.
