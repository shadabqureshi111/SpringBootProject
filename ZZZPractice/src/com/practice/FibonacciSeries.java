package com.practice;

public class FibonacciSeries 
{
	public static void main(String[] args)
	{
		int fn=0;
		int sn=1;
		int next=0;
		
		for(int i=0;i<=10;i++)
		{
			System.out.println(fn);
			next=fn+sn;
			fn=sn;
			sn=next;
			
		}
		
	}

}
