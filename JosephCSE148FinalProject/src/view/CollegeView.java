package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CollegeView extends Application {
	private BorderPane collegePane;
	private Menu fileMenu;
	private Menu insertMenu;
	private Menu searchMenu;
	private Menu removeMenu;
	private Menu updateMenu;
	private Menu exportFile;
	private Menu importFile;
	private MenuBar menuBar;
	private MenuItem save;
	private MenuItem load;
	private MenuItem exit;
	private MenuItem insertStudent;
	private MenuItem insertFaculty;
	private MenuItem insertCourse;
	private MenuItem insertTextbook;
	private MenuItem removeStudent;
	private MenuItem removeFaculty;
	private MenuItem removeCourse;
	private MenuItem removeTextbook;
	private MenuItem searchStudent;
	private MenuItem searchFaculty;
	private MenuItem searchCourse;
	private MenuItem searchTextbook;
	private MenuItem updateStudent;
	private MenuItem updateFaculty;
	private MenuItem updateCourse;
	private MenuItem updateTextbook;
	private CheckMenuItem exportStudent;
	private CheckMenuItem exportFaculty;
	private CheckMenuItem exportCourse;
	private CheckMenuItem exportTextbook;
	private CheckMenuItem importStudent;
	private CheckMenuItem importFaculty;
	private CheckMenuItem importCourse;
	private CheckMenuItem importTextbook;
	CoursePane coursePane;
	BottomButtonsPane bottomButtonsPane;
	TextbookPane textbookPane;
	PersonPane personPane;
	@Override
	public void start(Stage primaryStage) throws Exception {
		collegePane = new BorderPane();
		fileMenu = new Menu("File");
		searchMenu = new Menu("Search");
		removeMenu = new Menu("Remove");
		insertMenu = new Menu("Insert");
		updateMenu = new Menu("Update");
		insertStudent = new MenuItem("Student");
		insertFaculty = new MenuItem("Faculty");
		insertCourse = new MenuItem("Course");
		insertTextbook = new MenuItem("Textbook");
		removeStudent = new MenuItem("Student");
		removeFaculty = new MenuItem("Faculty");
		removeCourse = new MenuItem("Course");
		removeTextbook = new MenuItem("Textbook");
		searchStudent = new MenuItem("Student");
		searchFaculty = new MenuItem("Faculty");
		searchCourse = new MenuItem("Course");
		searchTextbook = new MenuItem("Textbook");
		updateStudent = new MenuItem("Student");
		updateFaculty = new MenuItem("Faculty");
		updateCourse = new MenuItem("Course");
		updateTextbook = new MenuItem("Textbook");
		exportStudent = new CheckMenuItem("Student");
		exportFaculty = new CheckMenuItem("Faculty");
		exportCourse = new CheckMenuItem("Course");
		exportTextbook = new CheckMenuItem("Textbook");
		importStudent = new CheckMenuItem("Student");
		importFaculty = new CheckMenuItem("Faculty");
		importCourse = new CheckMenuItem("Course");
		importTextbook = new CheckMenuItem("Textbook");
		setMenuBar(new MenuBar());
		save = new MenuItem("Save");
		load = new MenuItem("Load");
		exit = new MenuItem("Exit");
		exportFile = new Menu("Export");
		importFile = new Menu("Import");
		exportFile.getItems().addAll(exportStudent, exportFaculty, exportCourse, exportTextbook);
		importFile.getItems().addAll(importStudent, importFaculty, importCourse, importTextbook);
		fileMenu.getItems().addAll(save, load, exportFile, importFile, new SeparatorMenuItem(), exit);
		insertMenu.getItems().addAll(insertStudent, insertFaculty, insertCourse, insertTextbook);
		searchMenu.getItems().addAll(searchStudent, searchFaculty, searchCourse, searchTextbook);
		updateMenu.getItems().addAll(updateStudent, updateFaculty, updateCourse, updateTextbook);
		removeMenu.getItems().addAll(removeStudent, removeFaculty, removeCourse, removeTextbook);
		getMenuBar().getMenus().addAll(fileMenu, insertMenu, searchMenu, updateMenu, removeMenu);
		collegePane.setTop(getMenuBar());
		getMenuBar().prefWidthProperty().bind(primaryStage.widthProperty());
		coursePane = new CoursePane();
		textbookPane = new TextbookPane();
		personPane = new PersonPane();
		bottomButtonsPane = new BottomButtonsPane();
		// loads when opening project 
		coursePane.loadAction();
		textbookPane.loadAction();
		personPane.loadAction();
		
		save.setOnAction(e -> {
			coursePane.saveAction();
			textbookPane.saveAction();
			personPane.saveAction();
		});
		load.setOnAction(e -> {
			coursePane.loadAction();
			textbookPane.loadAction();
			personPane.loadAction();
		});
		exit.setOnAction(e -> {
			//saves when exits program 
			coursePane.saveAction();
			textbookPane.saveAction();
			personPane.saveAction();
			Platform.exit();
		});
		exportStudent.setOnAction(e -> {
			personPane.exportStudent();
		});
		exportFaculty.setOnAction(e -> {
			personPane.exportFaculty();
		});
		exportTextbook.setOnAction(e -> {
			textbookPane.exportTextbook();
		});
		exportCourse.setOnAction(e -> {
			coursePane.exportCourses();

		});
		importStudent.setOnAction(e -> {
			personPane.importPerson();
		});
		importFaculty.setOnAction(e -> {
			personPane.importPerson();
		});
		importTextbook.setOnAction(e -> {
			textbookPane.importTextbook();
		});
		importCourse.setOnAction(e -> {
			coursePane.importCourses();
		});
		insertFaculty.setOnAction(e -> {
			personPane.facultyDisable();
			collegePane.setCenter(personPane.getPersonPane());
		});
		insertStudent.setOnAction(e -> {
			personPane.studentDisable();
			collegePane.setCenter(personPane.getPersonPane());
		});
		insertTextbook.setOnAction(e -> {
			collegePane.setCenter(textbookPane.getTextbookPane());
			textbookPane.insertBtnAction();
		});
		insertCourse.setOnAction(e -> {
			collegePane.setCenter(coursePane.getCoursePane());
			coursePane.addBtnAction();
		});
		updateTextbook.setOnAction(e -> {
			collegePane.setCenter(textbookPane.getTextbookIdPane());
			textbookPane.updateBtnAction();
		});
		updateCourse.setOnAction(e -> {
			collegePane.setCenter(coursePane.getCoursePane());
			coursePane.updateBtnAction();
		});
		updateFaculty.setOnAction(e -> {
			collegePane.setCenter(bottomButtonsPane.getButtonsPane());
			updateDisable();
			bottomButtonsPane.getUpdateBtn().setOnAction(e1 -> {
				bottomButtonsPane.updateAction(personPane.getB1());
				if (bottomButtonsPane.getP3() == null) {
					return;
				}
				collegePane.setCenter(personPane.getPersonPane());
				personPane.updateAction2(bottomButtonsPane);
				BTNDisable();
				
			});
		});
		updateStudent.setOnAction(e -> {

			collegePane.setCenter(bottomButtonsPane.getButtonsPane());
			updateDisable();
			bottomButtonsPane.getUpdateBtn().setOnAction(e1 -> {

				bottomButtonsPane.updateAction(personPane.getB1());
				if (bottomButtonsPane.getP3() == null) {
					return;
				}
				collegePane.setCenter(personPane.getPersonPane());
				personPane.updateAction2(bottomButtonsPane);
				BTNDisable();
			});

		});
		searchCourse.setOnAction(e -> {
			collegePane.setCenter(coursePane.getIdCoursePane());
			coursePane.searchBtnAction();
		});
		searchTextbook.setOnAction(e -> {
			collegePane.setCenter(textbookPane.getTextbookIdPane());
			textbookPane.searchBtnAction();
		});
		searchStudent.setOnAction(e -> {
			searchAction();
		});
		searchFaculty.setOnAction(e -> {
			searchAction();
		});
		removeCourse.setOnAction(e -> {
			collegePane.setCenter(coursePane.getIdCoursePane());
			coursePane.removeBtnAction();
		});
		removeTextbook.setOnAction(e -> {
			collegePane.setCenter(textbookPane.getTextbookIdPane());
			textbookPane.removeBtnAction();
		});
		removeStudent.setOnAction(e -> {
			removeAction();

		});
		removeFaculty.setOnAction(e -> {
			removeAction();
		});

		Scene myScene = new Scene(collegePane, 650, 470);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}

	public void removeAction() {
		bottomButtonsPane.removeDisable();
		collegePane.setCenter(bottomButtonsPane.getButtonsPane());
		bottomButtonsPane.getRemoveBtn().setOnAction(e1 -> {
			bottomButtonsPane.setRemoveAction(personPane.getB1());
			if (bottomButtonsPane.getP1() == null) {
				return;
			}
			collegePane.setCenter(personPane.getPersonPane());
			personPane.getPersonPane().getChildren().remove(personPane.getMiddleFacultyPane());
			personPane.getPersonPane().getChildren().remove(personPane.getMiddleStudentPane());
			personPane.setRemoveAction(bottomButtonsPane.getP1());
		});
	}

	public void searchAction() {
		bottomButtonsPane.searchDisable();
		collegePane.setCenter(bottomButtonsPane.getButtonsPane());
		bottomButtonsPane.getSearchBtn().setOnAction(e1 -> {
			bottomButtonsPane.setSearchAction(personPane.getB1());
			if (bottomButtonsPane.getP2() == null) {
				return;
			}
			collegePane.setCenter(personPane.getPersonPane());
			personPane.setSearchAction(bottomButtonsPane.getP2());
		});
	}

	public void getPane() {
		collegePane.setCenter(personPane.getPersonPane());
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public void btnDisable() {
		bottomButtonsPane.getUpdateBtn().setDisable(false);
		bottomButtonsPane.getFacultyBtn().setDisable(false);
		bottomButtonsPane.getInsertBtn().setDisable(false);
		bottomButtonsPane.getClearBtn().setDisable(false);
		bottomButtonsPane.getStudentBtn().setDisable(false);
		bottomButtonsPane.getSearchBtn().setDisable(false);
		bottomButtonsPane.getRemoveBtn().setDisable(false);
	}
	public void BTNDisable() {
		bottomButtonsPane.getUpdateBtn().setDisable(true);
		bottomButtonsPane.getFacultyBtn().setDisable(true);
		bottomButtonsPane.getInsertBtn().setDisable(true);
		bottomButtonsPane.getClearBtn().setDisable(true);
		bottomButtonsPane.getStudentBtn().setDisable(true);
		bottomButtonsPane.getSearchBtn().setDisable(true);
		bottomButtonsPane.getRemoveBtn().setDisable(true);
	}

	public void updateDisable() {
		bottomButtonsPane.getUpdateBtn().setDisable(false);
		bottomButtonsPane.getSearchBtn().setDisable(true);
		bottomButtonsPane.getRemoveBtn().setDisable(true);
	}

	public BorderPane getCollegePane() {
		return collegePane;
	}

}
