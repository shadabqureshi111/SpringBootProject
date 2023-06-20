package com.practice;

public class ReverseInteger 
{
	public static void main(String[] args) 
	{
		int num=12345;
		int rem,rev=0;
		
		for(int i=0;i<num;num=num/10)
		{
			rem=num%10;
			rev=(rev*10)+rem;
		}
		System.out.println(rev);
		
	}

}
