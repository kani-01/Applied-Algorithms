// Sorting linkedList 
public class sortLinkedList  
{ 
    node head = null; 
    static int n;
    
    public static class node  
    { 
        int val; 
        node next; 
  
        public node(int val)  
        { 
            this.val = val; 
        } 
    } 
      
    public node sortedMerge(node a, node b)  
    { 
        node result = null; 
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
        if (a.val <= b.val)  
        { 
            result = a; 
            result.next = sortedMerge(a.next, b); 
        }  
        else 
        { 
            result = b; 
            result.next = sortedMerge(a, b.next); 
        } 
        return result; 
  
    } 
  
    public node mergeSort(node h)  
    { 
        if (h == null || h.next == null) 
        { 
            return h; 
        } 
        node middle = getMiddle(h); 
        node nextofmiddle = middle.next; 
        middle.next = null; 
        node left = mergeSort(h); 
        node right = mergeSort(nextofmiddle); 
        node sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    } 
    
    public node getMiddle(node h)  
    { 
       if (h == null) 
         return h; 
        node fastptr = h.next; 
        node slowptr = h; 
        while (fastptr != null) 
        { 
            fastptr = fastptr.next; 
            if(fastptr!=null) 
            { 
                slowptr = slowptr.next; 
                fastptr=fastptr.next; 
            } 
        } 
        return slowptr; 
    } 
    
    public static sortLinkedList removeRepeatedElement(node h) 
    {
    	node start = h;
    	node ele = h.next;
    	sortLinkedList linkedlist2 = new sortLinkedList();
		while(ele!=null) 
		{
			if(start.val!=ele.val)
    	   	{
    	   		linkedlist2.push(new node(start.val));
    	  	}
    	   	start = ele;
			ele = ele.next;
		} 
		linkedlist2.push(new node(start.val));
		return linkedlist2;
    }
  
    public void push(node node) 
    {
   		if (head == null) 
   		{
			head = node;
		} 
   		else 
   		{
			node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}
  
    public void printList(node headref)  
    { 
        while (headref != null)  
        { 
            System.out.print(headref.val + " "); 
            headref = headref.next; 
        } 
    } 
      
    public static void main(String[] args)  
    { 
        sortLinkedList linkedlist = new sortLinkedList();
        sortLinkedList linkedlist2 = new sortLinkedList();                     
        int[] arr = {5,1,7,2,1,3,9,3,10,1,3,3,3,3,10,15};
        for (int i=0; i<arr.length; i++) 
        { 
            linkedlist.push(new node(arr[i])); 
        }
        System.out.println("Linked List without sorting is :"); 
        linkedlist.printList(linkedlist.head); 
        linkedlist.head = linkedlist.mergeSort(linkedlist.head); 
        System.out.print("\nLinked List after sorting is : \n"); 
        linkedlist.printList(linkedlist.head); 
        linkedlist2 = removeRepeatedElement(linkedlist.head);
        System.out.print("\nSorted Linked List after Removing Duplicates is : \n"); 
        linkedlist2.printList(linkedlist2.head); 
    }
}
