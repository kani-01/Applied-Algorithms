
public class reverseString {

	   private int maxSize;        // size of stack array
	   private char[] stackArray;
	   private int top;            // top of stack
	   public static String myString = "Have a Good day";
	   static char[] charArray = myString. toCharArray();
		
	//--------------------------------------------------------------
	   public reverseString(int s)         // constructor
	   {
	      maxSize = s;             // set array size
	      stackArray = new char[maxSize];  // create array
	      top = -1;                // no items yet
	   }
	//--------------------------------------------------------------
	   public void push(char j)    // put item on top of stack
	   {
	      stackArray[++top] = j;     // increment top, insert item
	   }
	//--------------------------------------------------------------
	   public char pop()           // take item from top of stack
	   {
	      return stackArray[top--];  // access item, decrement top
	   }
	//--------------------------------------------------------------
	   public char peek()          // peek at top of stack
	   {
	      return stackArray[top];
	   }
	//--------------------------------------------------------------
	   public boolean isEmpty()    // true if stack is empty
	   {
	      return (top == -1);
	   }
	//--------------------------------------------------------------
	   public boolean isFull()     // true if stack is full
	   {
	      return (top == maxSize-1);
	   }
	//--------------------------------------------------------------
	
	
	public static void main(String[] args)
	{
		
		int k = myString.length();
		reverseString myStack = new reverseString(k);
		for(int j=0;j<charArray.length;j++)
		myStack.push(charArray[j]);
		System.out.println("The original String: "+myString);
		System.out.print("The Reversed String: ");
		for(int j=0;j<charArray.length;j++)
		System.out.print(myStack.pop());
		
	}
}
