package Assignment03;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;  

public class InputFile1Thread extends Word implements Runnable{

	private String [] InputFile1Txt;
	BST BSTRef;
	Word [] WRef;
	
	InputFile1Thread(BST bst, Word []w)
	{
		BSTRef = bst;
		WRef = new Word[1000];
		for (int i=0; i<1000; i++)
		{
			WRef[i] = new Word();
		}
	}
	
	public String [] GetInput1()
	{
		return InputFile1Txt;
	}
	
	public void run() 
	{
		synchronized (this)
		{
			int c = 0;
			InputFile1Txt = new String [1000];
			
			StringTokenizer StrToken;
			/* Reading File : InputFile1.txt */
			 try 
			 {
			      File myObj = new File("input.txt");
			      Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) 
			      {
			    	  	String data = myReader.nextLine();
			    	  	StrToken = new StringTokenizer(data);
			    	  	while (StrToken.hasMoreTokens())
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
				        InputFile1Txt[c-1] = StrToken.nextToken(" ");
				        InputFile1Txt[c-1].replace(".","");
			    	  	}
			      }
			      myReader.close();
			 } catch (FileNotFoundException e)
	         {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			 }
			 InputFile1Txt[c] = "\0";
			 
			 System.out.println("--------------------------------------------------------------");
			 System.out.println("                      VECTOR BUILD : FILE 1                   ");
			 System.out.println("--------------------------------------------------------------");
			 System.out.println("\nTokenizing File 1: "); 
			 for(int i=0; i<c; i++)
			 {
					System.out.println("Word " + (i+1) + " : " + InputFile1Txt[i]);
			 }
			 
			 /* Searching */
			 int wc = 0; int index = 0;
			 for(int i=0; i<c; i++)
			 {
				 if(BSTRef.SearchWord(InputFile1Txt[i]))
				 { 
					 boolean flag = true;
					 for (int i1=0; i1<1000; i1++)
					 {
						 if ((WRef[i1].GetString()).equals(InputFile1Txt[i]))
						 {
							 flag = false;
							 WRef[i1].SetInt(1);
						 }
					 }
					 
					 if (flag == true)
					 {
					 wc++;
					 WRef[index].SetString(InputFile1Txt[i]); 
					 WRef[index].SetInt(1);
					 index++;
					 }
				 }
				 else
					 ;
			 }
			 
			 System.out.println("--------------------------------------------------------------");
			 System.out.println("                    MATCH WORDS : FREQUENCY                   ");
			 System.out.println("--------------------------------------------------------------");
			 
			 for (int i=0; i<wc; i++)
			 {
				 System.out.println(WRef[i].wordCount + "             :            " + WRef[i].word);
			 }
		}
		}
}
