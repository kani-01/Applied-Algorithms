
// Program to Search an element from a list of integers using Binary Search Technique

public class BinarySearch {
	
	private static int[] myArray = {9,7,2,4,1,5,3,10}; 
	private static int[] sortedArray; 
	private static int element,position;
	
	// Function to perform Binary Search of an Element from a list of integers
	
	/*
	 * Step 1: Binary search checks middle number of array 
	 * Step 2: If element is present stop
	 * Step 3: Else partition array into left and right sub-array, 
	 * Step 4: Check if element is larger or smaller than middle element
	 * Step 5: If element is larger choose right sub-array, if smaller choose left sub-array
	 * Repeat steps 1 to 5 until element is found
	 */
	
	public int binarySearch(int myArray[], int low, int high, int element) 
    { 
        if (high>=low) 
        { 
            int mid = low + (high - low)/2; 
            if (myArray[mid] == element) 
               return mid; 
  
            if (myArray[mid] > element) 
               return binarySearch(myArray, low, mid-1, element); 
            
            else
            return binarySearch(myArray, mid+1, high, element); 
        } 
        return -1; 
    }
	
	// Main Method

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("The Array Before Sorting is : ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+ " ");
		System.out.println("\n");
		
		/* 
		 * Binary Search can only be applied on a Sorted List of Elements
		 * Hence Employing any one (Insertion Sort here) Sorting Technique to Sort Elements
		 */
		
		InsertionSort insert = new InsertionSort();
		sortedArray = insert.insertionSort(myArray);
		System.out.println();
		System.out.print("The Array After applying Insertion Sort is : ");
		for(int i=0;i<sortedArray.length;i++)
			System.out.print(sortedArray[i]+ " ");
		System.out.println();
		
		//Element to be Searched
		element = 5;
		BinarySearch binary = new BinarySearch();
		//Call Binary Search Function to Search for the Element
		position = binary.binarySearch(sortedArray, 0, sortedArray.length-1, element);		
		System.out.println("The position of element "+element+" is: "+ position);
	}

}
