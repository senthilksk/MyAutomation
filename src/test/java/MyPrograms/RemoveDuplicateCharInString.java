package MyPrograms;

import org.testng.annotations.Test;

public class RemoveDuplicateCharInString {
	
	
	@Test
	public void charOnce() {			
		String name="Ramanan";
		System.out.println("Given String - "+name);
		int len= name.length();		
		for(int i=0;i<len;i++) {			
			for(int j=i+1;j<len;j++) {						
					if(name.charAt(i)==name.charAt(j)) {					
						String s=String.valueOf(name.charAt(i));
						name=name.replace(s, "");						
						len= name.trim().length();					
						i--;
						break;
			}
		}
		}
		System.out.println("After removing - "+name);
	}
	
	@Test
	public void charCountInString() {			
		String name="Ramanan";
		String orgName=name;
		System.out.println("Given String - "+name);
		int len= name.length();	
		
		for(int i=0;i<len;i++) {	
			int count =1;
			for(int j=i+1;j<len;j++) {						
					if(name.charAt(i)==name.charAt(j)) {					
						count++;
			}
		}
				System.out.println("Number of character(s) "+name.charAt(i)+" in "+orgName+" is "+count);
				String s=String.valueOf(name.charAt(i));
				name=name.replace(s, "");						
				len= name.trim().length();					
				i--;			
		}		
	}

}
