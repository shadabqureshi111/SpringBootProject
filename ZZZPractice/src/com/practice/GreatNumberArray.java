package com.practice;

public class GreatNumberArray 
{
	public static void main(String[] args) 
	{
		int arr[]= {10,3,4,6};
//		int min=arr[0];
//		int temp;
//		for(int i=0;i<arr.length;i++)
//		{
//			if(min>arr[i])
//			{
//				temp=arr[i];
//				
//				min=temp;
//			}
//		}
//		System.out.println(min);
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(arr[arr.length-3]);
	}
	

}
