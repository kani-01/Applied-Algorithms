class reverseFirstk
{
   static int queSize=10;
   static int k=4;
   private int maxSize;        // size of stack array
   private long[] stackArray;
   private int top;            // top of stack
//--------------------------------------------------------------
   public reverseFirstk(int s)         // constructor
   {
      maxSize = s;             // set array size
      stackArray = new long[maxSize];  // create array
      top = -1;                // no items yet
   }
//--------------------------------------------------------------
   public void push(long j)    // put item on top of stack
   {
      stackArray[++top] = j;     // increment top, insert item
   }
//--------------------------------------------------------------
   public long pop()           // take item from top of stack
   {
      return stackArray[top--];  // access item, decrement top
   }
//--------------------------------------------------------------
   public long peek()          // peek at top of stack
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
		long array1[]= {2,4,5,8,10,13,15,16,17,20};
		reverseFirstk myStack = new reverseFirstk(k);
		for(int j=0;j<k;j++)
		myStack.push(array1[j]);
		for(int j=0;j<k;j++)
		array1[j]=myStack.pop();
		for(int j=0;j<array1.length;j++)
		System.out.println(array1[j]);
		
	}
}
	
	

