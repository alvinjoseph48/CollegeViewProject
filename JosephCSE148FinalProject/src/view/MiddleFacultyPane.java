package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MiddleFacultyPane {
	GridPane facultyPane;
	Label rankLbl;
	TextField rankField;
	Label salaryLbl;
	TextField salaryField;
	Label coursesTeachingLbl;
	Label facultyLbl;
	TextField coursesTeachingField;
	
	MiddleFacultyPane(){
		facultyPane = new GridPane();
		rankLbl = new Label("Rank");
		rankField = new TextField();
		salaryLbl = new Label("Salary");
		salaryField = new TextField();
		coursesTeachingLbl = new Label("Courses Teaching");
		coursesTeachingField = new TextField();
		facultyLbl = new Label("FOR FACULTY ONLY");
		
		facultyLbl.setTextFill(Color.FIREBRICK);
		
		facultyPane.add(facultyLbl, 1, 0);
		facultyPane.add(rankLbl, 0, 1);
		facultyPane.add(rankField, 1, 1);
		facultyPane.add(coursesTeachingLbl, 0, 2);
		facultyPane.add(coursesTeachingField, 1, 2);
		facultyPane.add(salaryLbl, 0, 3);
		facultyPane.add(salaryField, 1, 3);
		
		facultyPane.setPadding(new Insets(15, 15, 15, 15));
		facultyPane.setVgap(5);
		facultyPane.setHgap(5);
	}

	public GridPane getFacultyPane() {
		return facultyPane;
	}

	public TextField getRankField() {
		return rankField;
	}

	public TextField getSalaryField() {
		return salaryField;
	}

	public TextField getCoursesTeachingField() {
		return coursesTeachingField;
	}
	
}
