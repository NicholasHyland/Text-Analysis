package edu.nyu.cs.nsh263.Assignment3NicholasHyland;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Assignment number 3
 * @author Nicholas Hyland
 * @version 1.0
 *
 */

public class Assignment3NicholasHyland {

	
		public static void getWords(String f) { 
			f = f.replaceAll("\\p{P}", "");
			String[] textWordList = f.split(" ");
			
			Scanner input = new Scanner(System.in);
			
			System.out.print("Please enter a list of words to search for, separated by a comma: ");
			String words = input.nextLine();
			String[] wordList = words.split(", ");
			int[] wordListCount = new int[wordList.length]; //[0]*wordList.length;
			
			//for each word you're trying to count
				//for each word in the text file
					//check if the word in the text file == word you're currently on
						//if it is, add up the wordListCount
			
			int i = 0;
			int total = 0;
			for (String word : wordList) {
				
				for (String fileWord : textWordList) {
					if (word.equals(fileWord)) {
						wordListCount[i] += 1;
						total += 1;
					}
				}	
				i++;
			}	
			System.out.println();
			System.out.println("--------------------Analyzing text--------------------");
			System.out.println();
			System.out.println("Total number of tics: " + total);
			System.out.println("Density of tics: " + ((double)total/textWordList.length));
			System.out.println();
			System.out.println("--------------------Tic breakdown---------------------");
			System.out.println();
			for (int k = 0; k < wordList.length; k++) {
				if (wordListCount[k] == 1) {
					System.out.printf("%-11s / %2d occurence   / %10d%% of all tics\n", wordList[k],wordListCount[k], + (int)((wordListCount[k]/(double)total)*100));
				}
				else {
					System.out.printf("%-11s / %2d occurences  / %10d%% of all tics\n", wordList[k],wordListCount[k], + (int)((wordListCount[k]/(double)total)*100));
				}
			}
			
			// System.out.println();
			// getWords(f);
			
		}
		
		public static String openFile(String fileName) throws FileNotFoundException {
			Scanner textScan = new Scanner(new File("src/" + fileName));
			
			String file = "";	
			
			while (textScan.hasNextLine()) {
				file += textScan.nextLine() + " ";
			}
			
			return file;
		}
		
		public static String askForFileName() {
			
			Scanner input = new Scanner(System.in);
			
			System.out.print("What file do you want to open? ");
			String fileName = input.nextLine();
			return fileName;
			
		}
			
		public static void main(String[] args) {
			String f = "";
			String fileName = askForFileName();
			try {
				f = openFile(fileName);
				
			}
			catch (Exception e) {
				System.out.println("Sorry, couldn't find the requested file.");
				System.exit(0);
			}
			
			getWords(f);
			
		}
		
	}
