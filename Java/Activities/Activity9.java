package activities;

import java.util.ArrayList;
import java.util.Iterator;

public class Activity9 {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Rajesh");
		myList.add("Mahesh");
		myList.add("Kailesh");
		myList.add("Lanka");
		myList.add("Rama");

		System.out.println("Original ArrayList : " + myList); 
		System.out.println("3rd element in the list is: " + myList.get(2));
		System.out.println("Is Lanka present in arrayList: " + myList.contains("Lanka"));
        System.out.println("Size of ArrayList: " + myList.size());
		myList.remove(4);
        System.out.println("Size of new ArrayList: " + myList.size());

	}

}
