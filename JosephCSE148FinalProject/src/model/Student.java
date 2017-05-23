package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person implements Serializable{
	private ArrayList<String> coursesTook;
	private ArrayList<String> coursesTaking;
	private ArrayList<String> coursesNeeded;
	private double gpa;
	private double creditsTaking;
	private String major;
	// whatever is int construcorts that the minimum to create a student 
	public Student(String firstName, String lastName) {
		super(firstName, lastName);
	}
	public ArrayList<String> getCoursesTook() {
		return coursesTook;
	}

	public void setCoursesTook(ArrayList<String> coursesTook) {
		this.coursesTook = coursesTook;
	}

	public ArrayList<String> getCoursesTaking() {
		return coursesTaking;
	}

	public void setCoursesTaking(ArrayList<String> coursesTaking) {
		this.coursesTaking = coursesTaking;
	}

	public ArrayList<String> getCoursesNeeded() {
		return coursesNeeded;
	}

	public void setCoursesNeeded(ArrayList<String> coursesNeeded) {
		this.coursesNeeded = coursesNeeded;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa)  {
		this.gpa = gpa;
	}
//	public ArrayList<String> getCoursesNeeded(){
//		
//	}
//	public double getCreditsByCourseTaking(){	
//		
//	}
	public double getCreditsTaking() {
		return creditsTaking;
	}

	public void setCreditsTaking(double creditsTaking) {
		this.creditsTaking = creditsTaking;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return  super.toString() + "Student [coursesTook=" + coursesTook + ", coursesTaking=" + coursesTaking + ", coursesNeeded="
				+ coursesNeeded + ", gpa=" + gpa +  ", creditsTaking=" + creditsTaking + ", major=" + major
				+ "]";
	}
}
	


