package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MiddleStudentPane {
	private GridPane studentPane;
	private ListView<String> coursesTookList;
	private ListView<String> coursesTakingList;
	private TextArea coursesNeededArea;
	private ListView<String> major;
	private TextField creditsTakingField;
	private TextField gpaField;

	private Label CoursesTookLbl;
	private Label coursesTakingLbl;
	private Label gpaLbl;
	private Label majorLbl;
	private Label coursesNeededLbl;
	private Label creditsTakingLbl;
	private Label studentLbl;
	final ObservableList<String> courses;
	private ArrayList<String> coursesTakingArrayList;
	private ArrayList<String> coursesTookArrayList;

	public MiddleStudentPane() {

		courses = FXCollections.observableArrayList("CSE111", "CSE118", "CSE148", "CSE222", "CSE246", "CSE248",
				"MAT141", "MAT142", "MAT205", "MAT210", "BIO150", "BIO152", "PHY132", "PHY232", "CHE133", "CHE134",
				"HIS101", "ENG101", "ENG102", "PED141");

		ObservableList<String> major1 = FXCollections.observableArrayList("CSE", "PHYISCS", "MATH", "ENGLISH",
				"HISTORY", "BIOLOGY");

		coursesTookList = new ListView<String>(courses);
		coursesTakingList = new ListView<String>(courses);
		coursesTookList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		coursesTakingList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		major = new ListView<String>(major1);
		coursesTookList.setMaxSize(100, 75);
		coursesTakingList.setMaxSize(100, 75);
		major.setMaxSize(100, 75);

		coursesNeededArea = new TextArea();
		coursesNeededArea.setMaxSize(150, 50);
		creditsTakingField = new TextField();
		gpaField = new TextField();
		creditsTakingLbl = new Label("Credits Taking");
		coursesNeededLbl = new Label("Courses Needed");
		studentLbl = new Label("FOR STUDENTS ONLY");
		studentLbl.setTextFill(Color.FIREBRICK);
		majorLbl = new Label("Major");
		gpaLbl = new Label("Gpa");
		coursesTakingLbl = new Label("Courses Taking");
		CoursesTookLbl = new Label("Courses Took");
		
		getCoursesTakingArrayList();
		getCoursesTookArrayList();
		
		studentPane = new GridPane();
		studentPane.add(gpaLbl, 0, 1);
		studentPane.add(gpaField, 1, 1);
		studentPane.add(majorLbl, 0, 2);
		studentPane.add(major, 1, 2);
		studentPane.add(CoursesTookLbl, 0, 3);
		studentPane.add(coursesTookList, 1, 3);
		studentPane.add(coursesTakingLbl, 0, 4);
		studentPane.add(coursesTakingList, 1, 4);
		studentPane.add(creditsTakingLbl, 0, 5);
		studentPane.add(creditsTakingField, 1, 5);
		studentPane.add(coursesNeededLbl, 0, 6);
		studentPane.add(coursesNeededArea, 1, 6);
		studentPane.add(studentLbl, 1, 0);
		studentPane.setPadding(new Insets(15, 15, 15, 15));
		studentPane.setVgap(5);
		studentPane.setHgap(5);
	}

	public ArrayList<String> getCoursesTakingArrayList() {
		coursesTakingList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
				ObservableList<String> tokens = coursesTakingList.getSelectionModel().getSelectedItems();
				coursesTakingArrayList = new ArrayList<>();
				coursesTakingArrayList.addAll(tokens);
			}
		});
		if (coursesTakingArrayList == null) {
			return null;
		}
		return coursesTakingArrayList;
	}
	public ArrayList<String> getCoursesTookArrayList() {
		coursesTookList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
				ObservableList<String> tokens = coursesTookList.getSelectionModel().getSelectedItems();
				coursesTookArrayList = new ArrayList<>();
				coursesTookArrayList.addAll(tokens);
			}
		});
		if (coursesTookArrayList == null) {
			return null;
		}
		return coursesTookArrayList;
	}

	public TextField getGpaField() {
		return gpaField;
	}

	public GridPane getStudentPane() {
		return studentPane;
	}

	public ListView<String> getCoursesTookList() {
		return coursesTookList;
	}

	public ListView<String> getCoursesTakingList() {
		return coursesTakingList;
	}

	public TextArea getCoursesNeededArea() {
		return coursesNeededArea;
	}

	public ListView<String> getMajor() {
		return major;
	}

	public TextField getCreditsTakingField() {
		return creditsTakingField;
	}

	public Label getCreditsTakingLbl() {
		return creditsTakingLbl;
	}

}
