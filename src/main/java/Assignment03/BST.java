package Assignment03;

public class BST {

	private String data;
	private String[] values;
	private int nodeCount;
    private BST left;
    private BST right;
    
    /* Constructor */
    public BST() {
        this.data = null;
        this.left = null;
        this.right = null;
    }
     
    /* Parameterized Constructor */
    public BST (String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public void SetValues(String [] data)
    {
    	values = new String[nodeCount];
    	for (int i=0; i<nodeCount; i++)
    	{
    		values[i] = data[i];
    	}
    }
    
    public String[] GetValues()
    {
    	return values;
    }
    
    public int GetCount()
    {
    	return nodeCount;
    }
    
    public void SetNodes(int c)
    {
    	nodeCount = c;
    }
    
    public void addWord(String data) {
        if (this.data == null) 
        {
            this.data = data;
        }
        else
        {
            if (this.data.compareTo(data) > 0) // -1 (this.data (apple) < data (banana)
            {
                if (this.left != null)
                {
                    this.left.addWord(data);
                } 
                else
                {
                    this.left = new BST(data);
                }
 
            }
            else
            {
                if (this.right != null)
                {
                    this.right.addWord(data);
                }
                else
                {
                    this.right = new BST(data);
                }
 
            }
        }
    }
    
    public boolean SearchWord(String word)
    {
    	for (int i=0; i<nodeCount; i++)
    	{
    		if (word.equals(values[i]))
    		{
    			return true;
    		}
    	}
		return false;
    }
    
    public void CheckingBST(String [] VocabTxt, int c)
    {
    	/* Lexicographic order of Strings */
    	for(int i = 0; i < c-1; ++i) {  
	         for (int j = i + 1; j < c; ++j) {  
	            if (VocabTxt[i].compareTo(VocabTxt[j]) > 0) {  
	               String temp = VocabTxt[i];  
	               VocabTxt[i] = VocabTxt[j];  
	               VocabTxt[j] = temp;  
	            }  
	         }  
	      }  
		
		System.out.println("\n\nSorted !!! ");
		for (int i=0; VocabTxt[i] != "\0" ; i++)
		 {
			System.out.println(VocabTxt[i]);
		 }
    }
 
    public void traverseInOrder() {
        if (this.left != null) {
            this.left.traverseInOrder();
        }
        System.out.println(this.data);
        if (this.right != null) {
            this.right.traverseInOrder();
        }
    }
}
