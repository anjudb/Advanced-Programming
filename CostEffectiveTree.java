import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//class Balanced Binary Search Node
class BBSTNode
{
	
	int data;
	BBSTNode left,right;
	public BBSTNode(int n){
		this.data = n;
		this.left = null;
		this.right = null;
	}
}
public class CostEffectiveTree {

	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		int n= read.nextInt();
        ArrayList<Integer> InputArray=new ArrayList<Integer>();
        
      //Insertion
        for(int i=0;i<n;i++)
        	InputArray.add(read.nextInt());
        Collections.sort(InputArray);
        
        int[] array=new int[n];
        for(int i=0;i<n;i++)
        	array[i]=InputArray.get(i);
        	
       BBSTNode root=insert(array,0, n-1);
       preOrder(root);

	}
	public static BBSTNode insert(int arr[], int start, int end)
	{
	    
	    if (start > end)
	      return null;
	 
	    int mid = (start + end)/2;
	    BBSTNode root = new BBSTNode(arr[mid]);
	 
	    root.left =  insert(arr, start, mid-1);
	 
	    root.right = insert(arr, mid+1, end);
	 
	    return root;
	}
	 
	public static void preOrder(BBSTNode node)
	{
	    if (node == null)
	        return;
	    System.out.print(node.data+" ");
	    preOrder(node.left);
	    preOrder(node.right);
	}
	
}

