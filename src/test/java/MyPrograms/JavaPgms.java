package MyPrograms;

import java.util.Scanner;

import org.testng.annotations.Test;

public class JavaPgms {

	Scanner sc = new Scanner(System.in);

	@Test
	public void factorial() {

		//int num = 6 ;
		int fact =1;
		int	num=sc.nextInt();
		for(int i=1;i<=num;i++) {
			fact=fact*i;
		}
		System.out.println("Factorial of a number "+num+" is "+fact);
	}

	@Test
	public void vowels(){

		//String name="Senthilkumar";
		int count=0;
		String name=sc.next();
		for(char c:name.toLowerCase().toCharArray()) {
			if(c=='a' ||
					c=='e' ||
					c=='i' ||
					c=='o' ||
					c=='u') {
				count++;
			}
		}
		System.out.println("Number of vowels in "+name+" is "+count);
	}
	
	@Test
	public void swapWithThirdVariable() {		
		int a=10, b=20,c;
		System.out.println("Before Swap "+a +" "+b);
		c=a;
		a=b;
		b=c;		
		System.out.println("After Swap "+a +" "+b);
	}
	
	@Test
	public void swapWithoutThirdVariable() {		
		int a=10, b=20;
		System.out.println("Before Swap "+a +" "+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("After Swap "+a +" "+b);
	}

	
	@Test
	public void reverseString() {
		
		   String s = "Geeks";
		   System.out.println("String is "+s);
	        StringBuilder res = new StringBuilder();
	        res.append(s);
	        res.reverse();
	        System.out.println("Reverse String is "+res);
	}
}
