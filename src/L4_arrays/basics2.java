package L4_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class basics2 {
   static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[] m=takeInput();
   display(m);
    Arrays.sort(m);
    display(m);
	}
	
	public static int[] takeInput()
	{
		int n= scn.nextInt();
		
		int arr[]= new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i]=scn.nextInt();
		
		return arr;
	}
	public static void display(int[] arr)
	{
		for( int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	

}
