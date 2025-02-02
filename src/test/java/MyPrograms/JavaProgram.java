package MyPrograms;

import java.util.Arrays;


import org.apache.log4j.BasicConfigurator;



import org.apache.log4j.Logger;






public class JavaProgram {
	
	public static void main(String[] args) {

		
		int[] numArray = {14,22,3};
		String[] strArray = {"Camel","Zebra","Rabbit"};
		String name = "My name is Senthil";
		String revName="";
		
	//  print array directly will not display the value
		System.out.println("Array is "+Arrays.toString(numArray));	
		Arrays.sort(numArray);
		System.out.println("Array after integer sorting is "+Arrays.toString(numArray));
		System.out.println("Array is "+Arrays.toString(strArray));	
		Arrays.sort(strArray);
		System.out.println("Array after string sorting is "+Arrays.toString(strArray));
		
		for(int i=name.length()-1;i>=0;i--) {
			revName=revName+name.charAt(i);
		}
		System.out.println("The String is - "+name);
		System.out.println("Reverse of the String is - "+revName);		
		System.out.println("Lowercase of the string - "+name.toLowerCase());
		System.out.println("Uppercase of the string - "+name.toUpperCase());		
		System.out.println("Number of words in a sentence- "+name.split("\\s").length);
		System.out.println("Number of spaces in a sentence - "+(name.split("\\s").length-1));
	}

}
