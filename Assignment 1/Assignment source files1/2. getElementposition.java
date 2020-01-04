
public class getElementposition {

	private static int[] array1 = {2,3,5,8,10,15,21,25,29,34};
	private static int element, maxSize, front, rear, nItems,position, k=0;
	private static int[] queArray;
	boolean flag;

	//--------------------------------------------------------------
	   public getElementposition(int s) // constructor
	   {
	      maxSize = s;
	      queArray = new int[maxSize];
	      front = 0;
	      rear = -1;
	      nItems = 0;
	   }
	//--------------------------------------------------------------
	   public void insert(int j) // put item at rear of queue
	   {
	      if(rear == maxSize-1)         // deal with wraparound
	         rear = -1;
	      queArray[++rear] = j;         // increment rear and insert
	      nItems++;                     // one more item
	   }
	//--------------------------------------------------------------
	   public static int remove()       // take item from front of queue
	   {
	      int temp = queArray[front++]; // get value and incr front
	      if(front == maxSize)          // deal with wraparound
	         front = 0;
	      nItems--;                     // one less item
	      return temp;
	   }
	//--------------------------------------------------------------
	   public static int peekFront()      // peek at front of queue
	   {
	      return queArray[front];
	   }
	//--------------------------------------------------------------
	   public static boolean isEmpty()    // true if queue is empty
	   {
	      return (nItems==0);
	   }
	//--------------------------------------------------------------
	   public static boolean isFull()     // true if queue is full
	   {
	      return (nItems==maxSize);
	   }
	//--------------------------------------------------------------
	   public static int size()           // number of items in queue
	   {
	      return nItems;
	   }
	   
	//--------------------------------------------------------------

	
	public void findelement(int ele)
	{
		element=ele;
			while(isEmpty()!=true)
			{
				int num = remove();
				if(num==element)
				{
					//if element is present print position
					System.out.println("Element "+element+" is found at "+ k + "th positon ");
					flag=true;
					break;
				}
				else if(num>=element)
				{
					//if element is not present, print the position where it has to be inserted
					System.out.println("Element "+ element +" has to be inserted at position " + k);
					flag=true;
					break;
				}
				k++;
			}
			if(flag==false)
				System.out.println("Element "+ element +" has to be inserted at position " + k);
	}
	
	public static void main(String[] args)
	{
		int x = 31;
		getElementposition ele = new getElementposition(array1.length);
		for(int k=0;k<array1.length;k++)
		ele.insert(array1[k]); //pushing array to queue
		ele.findelement(x); //finding position
		
	}
	
}
