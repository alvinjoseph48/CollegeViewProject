package view;

import java.util.ArrayList;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Course;
import model.MasterCourseBag;

public class CoursePane {
	private GridPane coursePane;
	private GridPane idCoursePane;
	private Label courseNumberLbl;
	private TextField courseNumberField;
	private Label courseTitleLbl;
	private TextField courseTitleField;
	private Label courseDescriptionLbl;
	private TextArea courseDescriptionArea;
	private Label courseCreditLbl;
	private TextField courseCreditField;
	private Label textbookISBNLbl;
	private TextField textbookISBNField;
	private Label progromOutputLbl;
	private TextArea programOutput;
	private Label idProgromOutputLbl;
	private TextArea idProgramOutput;
	private Label idCourseLbl;
	private TextField idCourseField;
	private Button addBtn;
	private Button findBtn;
	private Button removeBtn;
	private Button updateBtn;
	private MasterCourseBag b1;
	private Course[] courseBag;
	private Button update;

	public CoursePane() {
		update = new Button("Click to Update");
		progromOutputLbl = new Label("Program Output");
		programOutput = new TextArea();
		idProgromOutputLbl = new Label("Program Output");
		idProgramOutput = new TextArea();
		coursePane = new GridPane();
		idCoursePane = new GridPane();
		courseNumberLbl = new Label("Course Number:");
		courseNumberField = new TextField();
		courseTitleLbl = new Label("Course Title:");
		courseTitleField = new TextField();
		courseDescriptionLbl = new Label("Course Description");
		courseDescriptionArea = new TextArea();
		courseCreditLbl = new Label("Course Credit:");
		courseCreditField = new TextField();
		textbookISBNLbl = new Label("Textbook ISBN:");
		textbookISBNField = new TextField();
		idCourseLbl = new Label("Course Number:");
		idCourseField = new TextField();
		courseBag = new Course[10];
		b1 = new MasterCourseBag(courseBag);
		addBtn = new Button("Insert");
		findBtn = new Button("Find");
		removeBtn = new Button("Remove");
		updateBtn = new Button(" Update");
		coursePane.setVgap(10);
		coursePane.setHgap(10);
		coursePane.setPadding(new Insets(10, 20, 20, 10));

		courseDescriptionArea.setMaxHeight(100);
		courseDescriptionArea.setMaxWidth(175);

		coursePane.add(courseTitleLbl, 1, 0);
		coursePane.add(courseTitleField, 2, 0);
		coursePane.add(courseNumberLbl, 1, 1);
		coursePane.add(courseNumberField, 2, 1);
		coursePane.add(updateBtn, 3, 1);
		coursePane.add(update, 4, 4);
		coursePane.add(courseCreditLbl, 1, 2);
		coursePane.add(courseCreditField, 2, 2);
		coursePane.add(courseDescriptionLbl, 1, 3);
		coursePane.add(courseDescriptionArea, 2, 3);
		coursePane.add(textbookISBNLbl, 1, 4);
		coursePane.add(textbookISBNField, 2, 4);
		coursePane.add(addBtn, 3, 4);
		coursePane.add(progromOutputLbl, 1, 5);
		coursePane.add(programOutput, 2, 5, 5, 5);

		idCoursePane.setVgap(10);
		idCoursePane.setHgap(10);
		idCoursePane.setPadding(new Insets(10, 20, 20, 10));
		idCoursePane.add(idCourseLbl, 0, 0);
		idCoursePane.add(idCourseField, 1, 0);
		idCoursePane.add(findBtn, 2, 0);
		idCoursePane.add(removeBtn, 3, 0);
		idCoursePane.add(idProgromOutputLbl, 0, 2);
		idCoursePane.add(idProgramOutput, 1, 2, 5, 5);

	}

	public void saveAction() {
		b1.writeFile();
		programOutput.setText("FILE SAVED \n");
	}

	public void loadAction() {
		b1.readFile();
		programOutput.setText("FILE LOADED \n " + b1 + "\n");
	}

	public void addBtnAction() {
		update.setDisable(true);
		updateBtn.setDisable(true);
		addBtn.setDisable(false);
		addBtn.setOnAction(event -> {
			try {
				String courseTitle = courseTitleField.getText();
				String textbookISBN = textbookISBNField.getText();
				String courseNum = courseNumberField.getText();
				String courseDescription = courseDescriptionArea.getText();
				double credits = Double.parseDouble(courseCreditField.getText());
				Course c1 = new Course(courseNum, courseTitle);
				ArrayList<String> textbooks = new ArrayList<>();
				textbooks.add(textbookISBN);
				c1.setTextbooks(textbooks);
				c1.setCourseCredits(credits);
				c1.setCourseDescription(courseDescription);
				b1.add(c1);
				programOutput.appendText("ADDED!!! \n" + c1.toString() + "\n");
				programOutput.appendText("ADDED Course to Bag: \n" + b1.toString() + "\n");
			} catch (NumberFormatException e) {
				programOutput.appendText("Credits must be a Integer  \n");
			}
			courseTitleField.clear();
			textbookISBNField.clear();
			courseNumberField.clear();
			courseDescriptionArea.clear();
			courseCreditField.clear();
		});
	}

	public void removeBtnAction() {
		removeDisable();
		removeBtn.setOnAction(event -> {
			String removeByCourseNum = idCourseField.getText();
			Course removed = b1.removeByCourseNumber(removeByCourseNum);
			if (removed != null) {
				idProgramOutput.setText("Removed Course Number: \n" + removeByCourseNum + "\n" + removed + "\n");
			} else {
				idProgramOutput.appendText("Search for a valid Course Number!! \n");
			}
			idCourseField.clear();
		});
	}

	public void searchBtnAction() {
		searchDisable();
		findBtn.setOnAction(event -> {
			String searchByCourseNum = idCourseField.getText();
			Course found = b1.SearchByCourseNumber(searchByCourseNum);
			if (found != null) {
				idProgramOutput.appendText("\n Found CourseNum:" + searchByCourseNum + "\n" + found + "\n");
			} else {
				idProgramOutput.appendText("Search for a valid Course Number!! \n");
			}
			idCourseField.clear();
		});
	}

	public void updateBtnAction() {
		addBtn.setDisable(true);
		update.setDisable(true);
		updateBtn.setDisable(false);
		updateBtn.setOnAction(event -> {
	
			String courseNum = courseNumberField.getText();
			Course updating = b1.SearchByCourseNumber(courseNum);
			if (updating == null) {
				programOutput.appendText("ENTER VALID COURSE NUMBER\n");
			} else {
				programOutput.appendText("Updating Course:\n" + updating + "\n");
				update.setDisable(false);
				updateBtn.setDisable(true);
				ArrayList<String> textbook = updating.getTextbooks();
				for (String element : textbook) {
					textbookISBNField.setText(element);
				}

				courseTitleField.setText(updating.getCourseTitle());
				courseDescriptionArea.setText(updating.getCourseDescription());
				courseNumberField.setText(updating.getCourseNumber());
				courseCreditField.setText(Double.toString(updating.getCourseCredits()));
				update.setOnAction(e -> {
					ArrayList<String> textbooks = new ArrayList<>();
					String textbookISBN = textbookISBNField.getText();
					textbooks.add(textbookISBN);
					if (textbookISBN != null) {
						updating.setTextbooks(textbooks);
					}
					String courseTitle = courseTitleField.getText();
					if (courseTitle != null) {
						updating.setCourseTitle(courseTitle);
					}
					String courseDescription = courseDescriptionArea.getText();
					if (courseDescription != null) {
						updating.setCourseDescription(courseDescription);
					}
					String updateCourseNum = courseNumberField.getText();
					if (updateCourseNum != null) {
						updating.setCourseNumber(updateCourseNum);
					}
					Double credits;
					try {
						credits = Double.parseDouble(courseCreditField.getText());
						updating.setCourseCredits(credits);
					} catch (NullPointerException b) {
						idProgramOutput.appendText("Enter valid Course Number\n");
					} catch (NumberFormatException a) {
						credits = updating.getCourseCredits();
						updating.setCourseCredits(credits);

					}
					programOutput.appendText("Updated Course: " + updating.getCourseNumber() + "\n" + updating);
					courseTitleField.clear();
					textbookISBNField.clear();
					courseNumberField.clear();
					courseDescriptionArea.clear();
					courseCreditField.clear();
				});
			}

		});

	}

	public GridPane getCoursePane() {
		return coursePane;
	}

	public void removeDisable() {
		updateBtn.setDisable(true);
		findBtn.setDisable(true);
		removeBtn.setDisable(false);
	}
	public void exportCourses(){
		b1.exportCourses();
	}

	public void searchDisable() {
		updateBtn.setDisable(true);
		findBtn.setDisable(false);
		removeBtn.setDisable(true);
	}

	public GridPane getIdCoursePane() {
		return idCoursePane;
	}
	public void importCourses(){
		b1.importCourse();
	}

	

}
