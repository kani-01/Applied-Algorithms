
public class CountInversions {
	
void  MERGESORT(int arr[],int p, int r){
	
	if ( p <  r)
	{
	int  q = p + r / 2;
	MERGESORT(arr,p,r);
	MERGESORT(arr,q+1,r);
	Merge(arr,p,q,r);
	
		 
	 }

}

void Merge(int arr[], int p, int q , int r) {
	
	int n= p+q-1;
	int n2=r-q;
	int L[]= new int [n];
	int R[]=new int [n2];
	for (int i=1;i<n;i++) {
		L[i]= arr[p+i-1];
		
	}
	for (int j=1;j<n2;j++)
	{
		R[j]=arr[q+j];
	}
	int i=1; int j = 1; int s=0;
	int k = p;
	for(k=0;k<r;k++) {
		if (L[i]<R[j]);
		{
			arr[k]=L[i];
			i=i++;
			s=s++; //for inversion count
		}
		else //why is it giving error here?
		{
			arr[k]=R[j];
			j=j++;
			s=s++;
		}
		
	}
	
	
}
void printArray(int arr[]) {
	int l=arr.length;
	for(int i=0;i<l;i++) {
		
		System.out.print(arr[i]);
		//where do i PRINT s variable that is the count of inversions?
	}
		
}

public static void main(String args[]) {
	int arr[]= {12,87,9,0,666,78};
	CountInversions ci = new CountInversions();
	ci.MERGERSORT(arr,0,arr.length-1);
	ci.printArray(arr);
	
	
	
}
}