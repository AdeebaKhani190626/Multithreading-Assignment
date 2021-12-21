package Assignment03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VocabularyThread implements Runnable{
	
	BST BSTRef;
	Word [] WRef;
	
	VocabularyThread(BST bst, Word [] w)
	{
		BSTRef = bst;
		WRef = new Word[1000];
		for (int i=0; i<1000; i++)
		{
			WRef[i] = new Word();
		}
	}
	
	public void run() {
		
		synchronized (this)
		{
			int c = 0;
			String [] VocabTxt = new String [1000];
			
			/* Reading File : Vocabulary.txt */
			 try 
			 {
			      File myObj = new File("Vocabulary.txt");
			      Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) 
			      {
			    	c++;
			    	try 
					{
			    		if(c > 1000 )
			    			throw new WordLimitException("Words Exceed the specified Limit !!!");
					}catch(WordLimitException e)
					{
		    			System.err.println(e);
		    		}
			    	
			        String data = myReader.nextLine();
			        VocabTxt[c-1] = data;
			      }
			      myReader.close();
			 } catch (FileNotFoundException e)
	         {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			 }
			 VocabTxt[c] = "\0"; 
			 
			 /* Creating Tree */
			 for (int i=0; VocabTxt[i] != "\0" ; i++)
			 {
				 BSTRef.addWord(VocabTxt[i]);
			 }
			 
			 	System.out.println("--------------------------------------------------------------");
				System.out.println("                BST BUILD : INORDER TRAVERSAL                 ");
				System.out.println("--------------------------------------------------------------");
			
			 BSTRef.traverseInOrder();
			 BSTRef.SetNodes(c);
			 BSTRef.SetValues(VocabTxt); 
		}
		}
}
