package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
	private String firstName;
	private String lastName;
	private String id;
	private String phone;
	private Address address;
	private static int idNumber = 1; // static variable (aka class level
										// variable) all the objects of this
										// class share the same value

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		File file = new File("id.txt");
		try {
			Scanner input = new Scanner(file); // opens the file to read
			idNumber = input.nextInt();
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		//post increment
		id = String.valueOf(idNumber++); // did not change id to int because its
		// more flexible like f for faculty s for student etc
		this.id = id;
		try {
			PrintWriter pw = new PrintWriter("id.txt"); // if not shown where save in project folder										
			pw.write(idNumber + " ");
			pw.close(); // does not save until close
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", phone=" + phone
				+ ", address=" + address.toString() + "]";
	}

}
