package com.practice;

public class DuplicateArray 
{  
    public static void main(String[] args) 
    {      
          
//        int [] arr = {1, 2,2,3,2,2, 3, 4};   
//          
//        for(int i = 0; i < arr.length; i++) 
//        {  
//            for(int j = i + 1; j < arr.length; j++) 
//            {  
//                if(arr[i] == arr[j])  
//                    System.out.println(arr[j]);  
//            }  
//        }  
    	
    	
    	int arr[]= {1,2,3,4,2,3,2,3};
    	
    	for(int i=0;i<arr.length;i++)
    	{
    		int count=0;
    		for(int j=i+1;j<arr.length;j++)
    		{
    			if(arr[i]==arr[j])
    			{
    				count++;
    				System.out.println(arr[i]+" "+count);
    			}
    			
    		}
    	}
    }  
}  
//for (int i = 0; i < s; i++) 
//{
//  int c = 0; // Reset the count for each element
//  for (int j = i + 1; j < s; j++) 
//  {
//      if (arr[i] == arr[j]) 
//      {
//          c++;
//          System.out.println(arr[j]);
//      }
//     
//  }
//}