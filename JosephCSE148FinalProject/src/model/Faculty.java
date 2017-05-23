package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Faculty extends Person implements Serializable{
	
	private String rank;
	private double salary;
	private ArrayList<String> coursesTeaching;
	
	public Faculty(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public ArrayList<String> getCoursesTeaching() {
		return coursesTeaching;
	}

	public void setCoursesTeaching(ArrayList<String> coursesTeaching) {
		this.coursesTeaching = coursesTeaching;
	}

	@Override
	public String toString() {
		return  super.toString()+"Faculty [rank=" + rank + ", salary=" + salary + ", coursesTeaching=" + coursesTeaching + "]";
	}
	
	
}
