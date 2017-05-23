package view;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import model.BodyBag;
import model.Person;

public class BottomButtonsPane {
	private GridPane insertPane;
	private GridPane buttonsPane;

	private Button insertBtn;
	private Button removeBtn;
	private Button updateBtn;
	private Button searchBtn;
	private Button clearBtn;
	private Button studentBtn;
	private Button facultyBtn;
	private TextField idSearchField;
	private TextField buttonsPaneOutput;
	private Label outputLbl;
	private Label idSearchLbl;
	private Person p1;
	private Person p2;
	private Person p3;

	// private BodyBag b1;
	public BottomButtonsPane() {
		buttonsPane = new GridPane();
		insertBtn = new Button("Insert");
		removeBtn = new Button("Remove");
		updateBtn = new Button("Update");
		searchBtn = new Button("Search");
		clearBtn = new Button("Clear Fields");
		studentBtn = new Button("Student");
		facultyBtn = new Button("Faculty");
		idSearchField = new TextField();
		idSearchLbl = new Label("Your ID:");
		outputLbl = new Label("Output");
		buttonsPaneOutput = new TextField();
		buttonsPane.add(idSearchLbl, 0, 0);
		buttonsPane.add(idSearchField, 1, 0);
		buttonsPane.add(searchBtn, 2, 0);
		buttonsPane.add(updateBtn, 3, 0);
		buttonsPane.add(removeBtn, 4, 0);
		buttonsPane.add(outputLbl, 0, 1);
		buttonsPane.add(buttonsPaneOutput, 1, 1);
		buttonsPane.setVgap(10);
		buttonsPane.setHgap(25);
		buttonsPane.setPadding(new Insets(5, 10, 10, 20));

		insertPane = new GridPane();
		insertPane.add(facultyBtn, 0, 0);
		insertPane.add(studentBtn, 1, 0);
		insertPane.add(insertBtn, 2, 0);
		insertPane.add(clearBtn, 3, 0);

		insertPane.setVgap(10);
		insertPane.setHgap(10);
		insertPane.setPadding(new Insets(10));
		idSearchLbl.setTextFill(javafx.scene.paint.Color.BLUE);
	}

	public Button getRemoveBtn() {
		return removeBtn;
	}

	public Button getSearchBtn() {
		return searchBtn;
	}

	public TextField getIdSearchField() {
		return idSearchField;
	}

	public void setText(String s) {
		this.idSearchField.setText(s);
	}
	public void setRemoveAction(BodyBag bodyBag) {
		p1 = bodyBag.removeById(idSearchField.getText());
		if (p1 == null) {
			buttonsPaneOutput.setText("INVALID ID!");
		} 
	}

	public TextField getButtonsPaneOutput() {
		return buttonsPaneOutput;
	}
	public Person updateAction(BodyBag bodyBag) {
			String searchById = idSearchField.getText();
			p3 = bodyBag.searchById(searchById);
			if (p3 == null) {
				buttonsPaneOutput.setText("INVALID ID!");
			}
			return p3;
			
	}

	public Person getP3() {
		return p3;
	}

	public void setSearchAction(BodyBag bodyBag) {
			p2 = bodyBag.searchById(idSearchField.getText());
			if (p2 == null) {
				buttonsPaneOutput.setText("INVALID ID!");
			}
	}
	public Person getP2() {
		return p2;
	}

	public void removeDisable(){
		buttonsPaneOutput.clear();
		removeBtn.setDisable(false);
		searchBtn.setDisable(true);
		updateBtn.setDisable(true);
	}
	public void searchDisable(){
		buttonsPaneOutput.clear();
		removeBtn.setDisable(true);
		searchBtn.setDisable(false);
		updateBtn.setDisable(true);
	}

	public void setClearyAction(TopPersonPane topPersonPane , MiddleStudentPane middleStudentPane , MiddleFacultyPane middleFacultyPane) {
		clearBtn.setOnAction(e -> {
			topPersonPane.getFirstNameField().clear();
			topPersonPane.getLastNameField().clear();
			topPersonPane.getPhoneField().clear();
			topPersonPane.getIdField().clear();
			topPersonPane.getAddressPane().getStreetNameField().clear();
			topPersonPane.getAddressPane().getCityField().clear();
			topPersonPane.getAddressPane().getStateList().refresh();
			topPersonPane.getAddressPane().getStreetNumberField().clear();
			topPersonPane.getAddressPane().getZip().clear();
			middleStudentPane.getGpaField().clear();
			middleStudentPane.getCoursesNeededArea().clear();
			middleStudentPane.getCoursesTakingList().refresh();
			middleStudentPane.getCreditsTakingField().clear();
			middleStudentPane.getMajor().refresh();
			middleStudentPane.getCoursesTookList().refresh();
			middleFacultyPane.getSalaryField().clear();
			middleFacultyPane.getRankField().clear();
			middleFacultyPane.getCoursesTeachingField().clear();
		});
	}

	public GridPane getButtonsPane() {
		return buttonsPane;
	}

	public Button getStudentBtn() {
		return studentBtn;
	}

	public Button getFacultyBtn() {
		return facultyBtn;
	}

	public Person getP1() {
		return p1;
	}

	public Button getUpdateBtn() {
		return updateBtn;
	}

	public Button getInsertBtn() {
		return insertBtn;
	}

	public Button getClearBtn() {
		return clearBtn;
	}

	public GridPane getInsertPane() {
		return insertPane;
	}

	public void facultyInsertDisable() {
		getInsertBtn().setDisable(false);
		removeBtn.setDisable(true);
		studentBtn.setDisable(true);
		getSearchBtn().setDisable(true);
		getUpdateBtn().setDisable(true);
	}

}
