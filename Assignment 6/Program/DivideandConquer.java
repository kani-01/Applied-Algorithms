/*
 * @Student		: Kanimozhi Kalaichelvan
 * @Professor	: Cong Pu
 * @Marshall ID	: 901881363
 * @Date		: 7 Nov 2018
 * @Course		: CS620 Applied Algorithms
 * @Program		: Divide & Conquer
 */

// Class to Perform MergeSort and Counting Number of Inversions using MergeSort
public class DivideandConquer {
	
//	private static int[] inputsequence = {4,3,2,1}; //{5,4,3,2,1};
	private static int[] inputsequence = {4,2,1,3,7,6,5,8}; //{4,2,1,3,7,6,5,8,0};
	private static int count=0;
	
//	Function to perform Merge an Array into SubArrays until element size is 1 (when size=1 -> performs merging) and pass the array to MergeSort Function
	public void mergesort(int[] inputsequence, int p, int r) 
	{
//		Until P reaches Q -> Returns Function when element size is 1
		if(p<r)
		{
//			Middle pointer -> q
			int q = (p+r)/2;
//			System.out.println("Q is "+q);
//			Split Left SubArray into further SubArrays until element size is 1
			mergesort(inputsequence, p, q);
//			Split Right SubArray into further SubArrays until element size is 1
			mergesort(inputsequence, q+1,r);
//			Once the Element size is 1 Function returns to previous calling Function and performs Merge
			merge(inputsequence,p,q,r);
		}
	}
	
//	Function to perform Merging of sorted SubArrays
	public void merge(int[] inputsequence,int p, int q, int r) 
	{
		int n1 = q - p + 1; 
	    int n2 = r - q; 
		int i,j;
//		Declare Left & Right SubArray to copy the Iteration's sub-elements
		int[] L1 = new int[n1+1];
		int[] R1 = new int[n2+1];
//		Copy Elements to Left SubArray of the Iteration
		for(int k=0;k<n1;k++) 
		{
			L1[k]= inputsequence[p+k];
		}		
//		Copy Elements to Right SubArray of the Iteration
		for(int m=0;m<n2;m++)
		{
			R1[m]= inputsequence[q+m+1];
		}
		L1[n1]= 100;
		R1[n2]= 100;
		
		i=0;
		j=0;
		
		int s = p;	
//		while Left and Right SubArray has elements that has not been placed in Merged Array
		while (i < n1 && j < n2) 
        { 
/* 			If element in Left SubArray is smaller then Right pointing element, 
* 			place it in Merged Array, increment Left pointer
*/
			if(L1[i]<=R1[j])
			{
				inputsequence[s]=L1[i];
				i++;
			}
/*			If element in Right SubArray is smaller than Left pointing element, 
*			place it in Merged Array, increment Right pointer
*/			else
			{
				inputsequence[s]=R1[j];
				j++;
				count = count + n1-i;
			}
			s++;
		}
//	Copy left out elements in remaining SubArray after OTHER SubArray is finished
		 while (i < n1) 
	        { 
			 inputsequence[s] = L1[i]; 
	            i++; 
	            s++; 
	        } 
		 
	        while (j < n2) 
	        { 
	        	inputsequence[s] = R1[j]; 
	            j++; 
	            s++; 
	        } 
	}
	
//	MAIN Function where program starts Execution
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p,q,r;
		p = 0;
		r = inputsequence.length-1;
//		q = (r-p)/2;
//		System.out.println("p is : "+p+" q is : "+q+" r is :"+r);
		System.out.println("The input Sequence is : ");
		for(int h=0;h<inputsequence.length;h++)
			System.out.print(inputsequence[h]+" ");
		
//		Instantiate DivideandConquer Class and call MergeSort Function
		DivideandConquer dc = new DivideandConquer();
		dc.mergesort(inputsequence,p,r);
		
		System.out.println();
		System.out.println("The Ordered Sequence is : ");
		for(int h=0;h<inputsequence.length;h++)
			System.out.print(inputsequence[h]+" ");
		
//		Print out the Number of Inversions
		System.out.println();
		System.out.println("The number of inversions is "+count);
		
	}

}
