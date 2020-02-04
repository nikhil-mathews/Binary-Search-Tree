
import java.util.ArrayList;
import java.lang.*;
import java.util.Scanner;  

public class BST
{	static int N;
	public static void main(String args[]){  

		ArrayList<Integer> A = new ArrayList<Integer>();
		
		//Press enter to exit
		while(true)
		{
			System.out.println("A is "+A);
			System.out.printf("Give a Number: ");
			Scanner myObj = new Scanner(System.in);
			String s = myObj.nextLine(); if(s.isEmpty()) {System.out.println("Exit...");break;};
			int i = Integer.parseInt(s);
			if (A.isEmpty()) {A.add(i); continue;}
			int leftp=0,rightp=A.size()-1;
			
			while (rightp>leftp+1)
			{	
				if(i>=A.get((rightp+leftp)/2))		leftp = (rightp+leftp)/2;
				else rightp = (rightp+leftp)/2;
			} 

			if(A.get(leftp)<i && A.get(rightp)>=i) A.add(rightp, i);
			else if(A.get(rightp)<i) A.add(rightp+1, i);
			else A.add(leftp, i);
			
			N=A.size()-1;
			recursion(A);
			
		}
		
	}
	
	public static void recursion(ArrayList<Integer> A)
	{
		int n = A.size()-1;
		if (n==N) System.out.println("Root is: "+(A.get(n/2)));
		else System.out.println("Leaf is: "+(A.get(n/2)));
		
		if(A.size()>2)
		{
			System.out.println("Left Sub Leaf is: "+(A.get((n-2)/4)));
			ArrayList<Integer> L = new ArrayList<Integer>();
			for(int i=0;i<n/2;i++) L.add(A.get(i));
			
			System.out.println("Right Sub Leaf is: "+(A.get((3*n+2)/4)));
			ArrayList<Integer> R = new ArrayList<Integer>();
			for(int i=(n/2)+1;i<n+1;i++) R.add(A.get(i));
			
			recursion(L);
			recursion(R);
			
		}
		
		else if(A.size()>1){
				System.out.println("Right Sub Leaf is: "+(A.get(1+n/2)));
		} 
		
	}
	
}