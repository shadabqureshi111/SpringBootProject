package com.practice;

public class ReverseString 
{
	public static void main(String[] args) 
	{
		String s="shadab";
		char c[]=s.toCharArray();
		int count=0;
		String rev="";
//		for(int i=s.length()-1;i>=0;i--)
//		{
//			char r=s.charAt(i);
//			
//			rev=rev+r;
//		}
//		System.out.println(rev);
		
		
		for(char cc :c)
		{
			count++;
		}
		
		for(int i=count-1;i>=0;i--)
		{
			char n=s.charAt(i);
			rev=rev+n;
		}
		System.out.println(rev);
	}

}
