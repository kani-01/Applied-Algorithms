class algebraicOperations
{
	public static String myString = "({a+b}-[c*(d/e)]-f)";
	static char[] charArray = myString. toCharArray();
	static int m = charArray.length;
	
   private int maxSize;
   private char[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public algebraicOperations(int s)          // constructor
   {
      maxSize = s;
      queArray = new char[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
   }
//--------------------------------------------------------------
   public void insert(char j)   // put item at rear of queue
   {
      if(rear == maxSize-1)         // deal with wraparound
         rear = -1;
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item
   }
//--------------------------------------------------------------
   public char remove()         // take item from front of queue
   {
      char temp = queArray[front++]; // get value and incr front
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;                      // one less item
      return temp;
   }
//--------------------------------------------------------------
   public char peekFront()      // peek at front of queue
   {
      return queArray[front];
   }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
   {
      return (nItems==0);
   }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
   {
      return (nItems==maxSize);
   }
//--------------------------------------------------------------
   public int size()           // number of items in queue
   {
      return nItems;
   }
   
//--------------------------------------------------------------

public static void main(String[] args)
	{
		algebraicOperations myStack = new algebraicOperations(m);
		for(int j=0;j<m;j++)
		myStack.insert(charArray[j]);
		for(int j=0;j<m;j++)
		charArray[j]=myStack.remove();
		for(int j=0;j<m;j++)
		{
			if(charArray[j]!='(' && charArray[j]!=')' && charArray[j]!='{' && charArray[j]!='}' && charArray[j]!='[' && charArray[j]!=']') 
			System.out.print(charArray[j]);	
		}
	
	}
}
