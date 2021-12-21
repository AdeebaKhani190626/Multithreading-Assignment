package Assignment03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Multithreading{

	public static void main(String[] args) throws InterruptedException {
		
		//int no_of_files = args.length;
		int no_of_files = 3;
		String [] fileNames = new String[no_of_files];
		fileNames[0] = "Vocabulary.txt";
		fileNames[1] = "InputFile1.txt";
		fileNames[2] = "InputFile2.txt";
		
		System.out.println("\nNo of Files = " + no_of_files);
		
		/* File Names and No. of Files Entered*/
		for(int i=0;i<no_of_files;i++)
		{
			//fileNames[i] = args[i];
			System.out.println("File " + (i+1) + " : " + fileNames[i]);
		}
		
		BST bst = new BST();
		Word [] w = new Word[1000];
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do
		{
			System.out.println("\n\n--------------------------------------------------------------");
			System.out.println("                ASSIGNMNET 3: MULTITHREADING                  ");
			System.out.println("--------------------------------------------------------------");
			
			System.out.println("1. Displaying BST build from Vocabulary File.");
			System.out.println("2. Displaying Vectors build from Input files.");
			System.out.println("2. Viewing Match words and its frequency");
			System.out.println("4. Searching a query->It should display all the files query found in.");
			System.out.println("5. Exiting");
			
			System.out.print("\nEnter choice : ");
			ch = sc.nextInt();
			try 
			{
	    		if(ch >= 6 )
	    			throw new ChoiceException("Invalid choice");
			}catch(ChoiceException e)
			{
    			System.err.println(e);
    		}
	    		
			switch(ch)
			{
			case 1:
			{
				/* Vocabulary Thread */
				Runnable r = new VocabularyThread(bst,w);
				Thread task = new Thread(r);
				task.start();
				task.join();
				break;
			}
			case 2:
			{
				/* InputFile1 Thread */
				Runnable r1 = new InputFile1Thread(bst,w);
				Thread task1 = new Thread(r1);
				task1.start();
				task1.join();
				
				/* InputFile2 Thread */
				Runnable r2 = new InputFile2Thread(bst,w);
				Thread task2 = new Thread(r2);
				task2.start();
				task2.join();
				
				break;
			}
			case 3:
			{
				break;
			}
			case 4:
			{
				DataBaseQuery dbq = new DataBaseQuery();
				//dbq.Connection();
				
				Scanner scs = new Scanner(System.in);
				String Query;
				System.out.print("Enter a Query: ");
				Query = scs.nextLine();
				break;
			}
			case 5:
			{
				System.out.println("\nExiting ... ");
				break;
			}
			default:
			{
				System.out.println("\nInvalid Choice Entered ... ");
				break;
			}
			}
		}while(ch != 5);
	}	
}
