package Assignment03;

public class Word {

	protected String word;
	protected int wordCount;
	
	Word()
	{
		word = "";
		wordCount = 0;
	}
	
	public void SetString(String w)
	{
		word = w;
	}
	
	public void SetInt(int i)
	{
		wordCount += i;
	}
	
	public String GetString()
	{
		return word;
	}
	
	public int GetInt()
	{
		return wordCount;
	}
}
