package MyPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class CollectionsPgms {
	
	
	@Test
	public void stackMethod() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		System.out.println(stack);
		System.out.println(stack.peek());  // last added item is in top
		stack.pop();  // ii removes the top element
		System.out.println(stack.peek());		
		stack.add(9);   
		System.out.println(stack);
		System.out.println(stack.peek());  
	}

	@Test
	public void linkedListMethod() {
		
		List<Integer> linkedlist = new LinkedList<Integer>();
		linkedlist.add(5);
		linkedlist.add(0);
		linkedlist.add(7);
		linkedlist.add(1);
		linkedlist.add(5);								//allow duplicate value
		linkedlist.add(null);							//allow null value
		System.out.println("Linkedlist "+linkedlist);    // maintain insertion order, faster for manipulating
	}
	
	@Test
	public void arrayListMethod() {
		
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		arraylist.add(5);
		arraylist.add(0);
		arraylist.add(7);
		arraylist.add(1);
		arraylist.add(5);								//allow duplicate value
		arraylist.add(null);							//allow null value
		System.out.println("Arraylist :"+arraylist);    // maintain insertion order, slow for manipulating, good for fetching data
	}
	
	
	@Test
	public void hashSetMethod() {
		
		Set<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(5);
		hashSet.add(0);
		hashSet.add(7);
		hashSet.add(1);
		hashSet.add(5);								// will not support duplicate value
		hashSet.add(null);							// supports null value
		System.out.println("HashSet :"+hashSet);    // maintain random/sorting order
	}
	
	@Test
	public void linkedhashSetMethod() {
		
		Set<Integer> linkedhashSet = new LinkedHashSet<Integer>();
		linkedhashSet.add(5);
		linkedhashSet.add(0);
		linkedhashSet.add(7);
		linkedhashSet.add(1);
		linkedhashSet.add(5);									// will not support duplicate value
		linkedhashSet.add(null);								// supports null value
		System.out.println("LinkedHashSet :"+linkedhashSet);    // maintain insertion order
	}
	
	@Test
	public void treeSetMethod() {
		
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(5);
		treeSet.add(0);
		treeSet.add(7);
		treeSet.add(1);
		treeSet.add(5);									// will not support duplicate value						
		//treeSet.add(null);							// will not allow null value
		System.out.println("TreeSet :"+treeSet);    // maintain sorting order
	}
	
	
	
	
	@Test
	public void hashMapMethod() {
		
		Map<Integer,String> hashmap = new HashMap<Integer,String>();
		hashmap.put(5,"Srinivas");
		hashmap.put(9,"Kasiammal");
		hashmap.put(6,"Anitha");
		hashmap.put(2,"Kandasamy");
		hashmap.put(9,"Senthil");
		hashmap.put(0,"Ram");
		hashmap.put(1,"");
		hashmap.put(null,"Sundari");				// supports null key and values
		hashmap.put(null,"kumar");
		System.out.println("Hashmap :"+hashmap);    // maintain random/sorting order  No duplicate key but with replace the latest value
	System.out.println(hashmap.keySet());
	System.out.println(hashmap.values());
	}
	
	@Test
	public void linkedhashMapMethod() {
		
		Map<Integer,String> linkedhashmap = new LinkedHashMap<Integer,String>();
		linkedhashmap.put(5,"Srinivas");
		linkedhashmap.put(9,"Kasiammal");
		linkedhashmap.put(6,"Anitha");
		linkedhashmap.put(2,"Kandasamy");
		linkedhashmap.put(9,"Senthil");
		linkedhashmap.put(0,"Ram");
		linkedhashmap.put(1,"");
		linkedhashmap.put(null,"Sundari");						// supports null key and values
		linkedhashmap.put(null,"kumar");
		System.out.println("LinkedHashmap :"+linkedhashmap);    // maintain insertion order No duplicate key but with replace the latest value
	}
	
	@Test
	public void treeMapMethod() {
		
		Map<Integer,String> treemap = new TreeMap<Integer,String>();
		treemap.put(5,"Srinivas");
		treemap.put(9,"Kasiammal");
		treemap.put(6,"Anitha");
		treemap.put(2,"Kandasamy");
		treemap.put(9,"Senthil");
		treemap.put(0,"Ram");
		treemap.put(1,"");
		//treemap.put(null,"Sundari");				// will not allow null key but allow null values
		System.out.println("Treemap :"+treemap);    // maintain sorting order No duplicate key but with replace the latest value
	}
}
