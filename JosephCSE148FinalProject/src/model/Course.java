package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {

	private String courseNumber;
	private String courseTitle;
	private String courseDescription;
	private double courseCredits;
	private ArrayList<String> textbooks = new ArrayList<>();

	public Course(String courseNumber, String courseTitle) {
		super();
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public Double getCourseCredits() {
		return courseCredits;
	}

	public void setCourseCredits(Double courseCredits) {
		this.courseCredits = courseCredits;
	}

	public ArrayList<String> getTextbooks() {
		return textbooks;
	}

	public void setTextbooks(ArrayList<String> textbooks) {
		this.textbooks = textbooks;
	}

	@Override
	public String toString() {
		return "Course [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle + ", courseDescription="
				+ courseDescription + ", courseCredits=" + courseCredits + ", textbooks=" + textbooks + "]";
	}

}
