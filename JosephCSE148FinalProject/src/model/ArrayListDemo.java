package model;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {

	public static void main(String[] args) {
		// int [] intList = new int [10];
		// CAN NOT STORE Primative data types only objects !!!
		// ArrayList<Integer> integerList = new ArrayList<>();
		// integerList.add(new Integer(1)) ;
		// integerList.add(new Integer(2)) ;
		//// integerList.addAll("String");
		//
		// Integer y = new Integer (1);
		// y = 2; // auto boxing because y is a reference address so java
		// //automatically make 2 a new integer behind the scene
		// //autoboxing: y == new Integer(2);
		//
		// //this case java unboxes automatically
		// int z =5;
		//
		// z=y;
		
		ArrayList<String> coursesTook = new ArrayList<>();
		coursesTook.add("CST111");
		coursesTook.add("CST 112");
		coursesTook.add("CST148");
		coursesTook.add("MAT141");
		System.out.println(coursesTook.size());
		coursesTook.isEmpty();
		coursesTook.remove("MAT141");
		System.out.println(coursesTook.size());
		System.out.println(coursesTook.contains("MAT141"));
		
		String[] array = new String [coursesTook.size()];
		coursesTook.toArray(array);
		
		System.out.println(Arrays.toString(array));
	
		//replaces it then
		coursesTook.set(0,"COL101");
		System.out.println(coursesTook);
		
		//pushes everything back
		coursesTook.add(0, "CST100");
		System.out.println(coursesTook);
		
		System.out.println(coursesTook.get(2));
		
		

	}

}
