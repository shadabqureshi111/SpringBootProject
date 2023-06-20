package com.practice;
class A
{
	int x=10;
	
	public void show()
	{
		System.out.println(x);
	}
		
}
class B extends A
{
	int x=20;
	
	public void show()
	{
		System.out.println(x);
	}
}

public class SameVariable 
{
	public static void main(String[] args) 
	{
		A a=new B();
		B b=(B) new A();
		System.out.println(a.x);
		a.show();
		
		System.out.println("\n\n"+b.x);
		b.show();
		
		
	}
	

}
