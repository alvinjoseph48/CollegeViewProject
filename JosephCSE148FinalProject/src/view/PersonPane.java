package view;

import java.util.ArrayList;

import exceptionHandling.GpaTooBigException;
import exceptionHandling.PhoneNumberException;
import exceptionHandling.ZipCodeException;
import model.Address;
import model.BodyBag;
import model.Faculty;
import model.Person;
import model.Student;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PersonPane {
	TopPersonPane topPersonPane;
	GridPane personPane;
	BottomButtonsPane bottomButtonsPane;
	MiddleStudentPane middleStudentPane;
	MiddleFacultyPane middleFacultyPane;
	
	BodyBag b1;
	Student s1;
	Faculty f1;
	Person p1;
	Person p2;
	private String firstName;
	private String lastName;
	private String phone;
	private String streetNumber;
	private String streetName;
	private String city;
	private String zip;
	private Address a1;
	private String state;

	public PersonPane() {
		topPersonPane = new TopPersonPane();
		personPane = new GridPane();
		bottomButtonsPane = new BottomButtonsPane();
		middleStudentPane = new MiddleStudentPane();
		middleFacultyPane = new MiddleFacultyPane();
		insertFacultyAction();
		insertStudentAction();
		b1 = new BodyBag();
		 loadAction();
		saveAction();
		bottomButtonsPane.setClearyAction(topPersonPane, middleStudentPane, middleFacultyPane);
		personPane.add(topPersonPane.getPersonPane(), 0, 0);
		personPane.add(bottomButtonsPane.getInsertPane(), 0, 1);
		personPane.add(topPersonPane.getIdPane(), 0, 2);
		personPane.add(topPersonPane.getProgramOutputPane(), 0, 4);
	}

	public GridPane getPersonPane() {
		return personPane;
	}

	public void insertStudentAction() {
		bottomButtonsPane.getStudentBtn().setOnAction(e -> {
			firstName = null;
			lastName = null;
			phone = null;
			streetNumber = null;
			streetName = null;
			city = null;
			state = null;
			zip = null;
			a1 = null;
			insertAction();
			if (zip.toCharArray().length != 5 || isNumeric(zip) == false) {
				try {
					throw new ZipCodeException();
				} catch (ZipCodeException e1) {
					topPersonPane.getProgramOutput().appendText(e1.getMessage());
					return;
				}
			}
			if (phone.toCharArray().length != 10 || isNumeric(phone) == false) {
				try {
					throw new PhoneNumberException();
				} catch (PhoneNumberException e1) {
					topPersonPane.getProgramOutput().appendText(e1.getMessage());
					return;
				}
			}
			if (firstName.isEmpty() || lastName.isEmpty()) {
				topPersonPane.getProgramOutput().appendText("Insert First and Last Name!\n");
				return;
			}
			bottomButtonsPane.getInsertBtn().setDisable(false);
			bottomButtonsPane.getStudentBtn().setDisable(true);
			bottomButtonsPane.getFacultyBtn().setDisable(true);
			s1 = new Student(firstName, lastName);
			s1.setPhone(phone);
			topPersonPane.getIdField().setText(s1.getId());
			s1.setAddress(a1);
			personPane.getChildren().remove(middleFacultyPane.getFacultyPane());
			personPane.add(middleStudentPane.getStudentPane(), 2, 0);
			bottomButtonsPane.getInsertBtn().setOnAction(b -> {
				bottomButtonsPane.getInsertBtn().setDisable(true);
				String major = middleStudentPane.getMajor().getSelectionModel().getSelectedItem();
				try {
					Double gpa = Double.parseDouble(middleStudentPane.getGpaField().getText());
					if (gpa > 4.0 || gpa < 0.0) {
						try {
							throw new GpaTooBigException();
						} catch (GpaTooBigException e1) {
							topPersonPane.getProgramOutput().appendText(e1.getMessage());
							bottomButtonsPane.getInsertBtn().setDisable(false);
							return;
						}
					} else {
						double creditsTaking = Double.parseDouble(middleStudentPane.getCreditsTakingField().getText());
						s1.setGpa(gpa);
						s1.setCreditsTaking(creditsTaking);
						s1.setMajor(major);

						s1.setCoursesTaking(middleStudentPane.getCoursesTakingArrayList());
						s1.setCoursesTook(middleStudentPane.getCoursesTookArrayList());

						String coursesNeeded = middleStudentPane.getCoursesNeededArea().getText();
						ArrayList<String> coursesNeededArrayList = new ArrayList<>();
						for (String string : coursesNeeded.split(",")) {
							coursesNeededArrayList.add(string);
						}
						s1.setCoursesNeeded(coursesNeededArrayList);
						b1.insert(s1);
						// topPersonPane.getProgramOutput().appendText("Student
						// Inserted:\n" + s1.toString() + "\n");
						topPersonPane.getProgramOutput().appendText("\nBodyBag: \n" + b1 + "\n");
						bottomButtonsPane.getStudentBtn().setDisable(false);
						bottomButtonsPane.getClearBtn().setDisable(false);
						personPane.getChildren().remove(middleStudentPane.getStudentPane());
					}
				} catch (NumberFormatException e1) {
					topPersonPane.getProgramOutput().appendText("GPA AND CREDITS MUST BE A NUMBER\n");
					bottomButtonsPane.getFacultyBtn().setDisable(true);
					bottomButtonsPane.getStudentBtn().setDisable(true);
					bottomButtonsPane.getClearBtn().setDisable(true);
					bottomButtonsPane.getInsertBtn().setDisable(false);
					return;
				}
			});
		});
	}

	public void importPerson() {
		b1.importPerson();
	}

	public void insertAction() {
		firstName = topPersonPane.getFirstNameField().getText();
		lastName = topPersonPane.getLastNameField().getText();
		phone = topPersonPane.getPhoneField().getText();
		streetNumber = topPersonPane.getStreetNumber().getText();
		streetName = topPersonPane.getStreetName().getText();
		city = topPersonPane.getCity();
		state = topPersonPane.getState().getSelectionModel().getSelectedItem();
		zip = topPersonPane.getZip().getText();
		a1 = new Address();
		a1.setCity(city);
		a1.setState(state);
		a1.setStreetName(streetName);
		a1.setStreetNumber(streetNumber);
		a1.setZip(zip);
	}

	public void insertFacultyAction() {
		bottomButtonsPane.getFacultyBtn().setOnAction(e -> {
			firstName = null;
			lastName = null;
			phone = null;
			streetNumber = null;
			streetName = null;
			city = null;
			state = null;
			zip = null;
			a1 = null;
			insertAction();
			if (zip.toCharArray().length != 5 || isNumeric(zip) == false) {
				try {
					throw new ZipCodeException();
				} catch (ZipCodeException e1) {
					topPersonPane.getProgramOutput().appendText(e1.getMessage());
					return;
				}
			}
			if (phone.toCharArray().length != 10 || isNumeric(phone) == false) {
				try {
					throw new PhoneNumberException();
				} catch (PhoneNumberException e1) {
					topPersonPane.getProgramOutput().appendText(e1.getMessage());
					return;
				}
			}
			if (firstName.isEmpty() || lastName.isEmpty()) {
				topPersonPane.getProgramOutput().appendText("Insert First and Last Name!\n");
				return;
			}
			bottomButtonsPane.getStudentBtn().setDisable(true);
			bottomButtonsPane.getFacultyBtn().setDisable(true);
			bottomButtonsPane.getInsertBtn().setDisable(false);
			personPane.getChildren().remove(middleStudentPane.getStudentPane());
			personPane.add(middleFacultyPane.getFacultyPane(), 2, 0);
			f1 = new Faculty(firstName, lastName);
			f1.setPhone(phone);
			topPersonPane.getIdField().setText(f1.getId());
			f1.setAddress(a1);
			b1.insert(f1);

		});
		bottomButtonsPane.getInsertBtn().setOnAction(e -> {
			try {
				double salary = Double.parseDouble(middleFacultyPane.getSalaryField().getText());
				f1.setSalary(salary);
			} catch (NumberFormatException e1) {
				topPersonPane.getProgramOutput().setText("Salary must be a number\n");
				return;
			}
			String rank = middleFacultyPane.getSalaryField().getText();
			String coursesTeaching = middleFacultyPane.getCoursesTeachingField().getText();
			ArrayList<String> coursesTeachingArrayList = new ArrayList<>();
			for (String string : coursesTeaching.split(",")) {
				coursesTeachingArrayList.add(string);
			}
			f1.setRank(rank);
			f1.setCoursesTeaching(coursesTeachingArrayList);
			bottomButtonsPane.getFacultyBtn().setDisable(false);
			bottomButtonsPane.getClearBtn().setDisable(false);
			bottomButtonsPane.getInsertBtn().setDisable(true);
			bottomButtonsPane.getStudentBtn().setDisable(true);
			personPane.getChildren().remove(middleFacultyPane.getFacultyPane());
			// topPersonPane.getProgramOutput().setText("Inserted Faculty:\n" +
			// f1 + "\n");
			topPersonPane.getProgramOutput().appendText("\nBag " + b1 + "\n");
		});
	}

	public void updateAction2(BottomButtonsPane bottomButtonsPane) {
		Person p1 = bottomButtonsPane.getP3();
		Button update2 = new Button("Update");
		if (p1 instanceof Student) {
			Student person = (Student) p1;
			topPersonPane.getZip().setText(person.getAddress().getZip());
			topPersonPane.getStreetNumber().setText(person.getAddress().getStreetNumber());
			topPersonPane.getFirstNameField().setText(person.getFirstName());
			topPersonPane.getLastNameField().setText(person.getLastName());
			topPersonPane.getIdField().setText(person.getId());
			topPersonPane.getPhoneField().setText(person.getPhone());
			topPersonPane.getStreetName().setText(person.getAddress().getStreetName());
			topPersonPane.getAddressPane().getCityField().setText(person.getAddress().getCity());
			personPane.add(middleStudentPane.getStudentPane(), 2, 0);
			middleStudentPane.getGpaField().setText(Double.toString(((Student) person).getGpa()));
			middleStudentPane.getCreditsTakingField().setText(Double.toString(((Student) person).getCreditsTaking()));
			ArrayList<String> coursesNeeded = ((Student) person).getCoursesNeeded();
			String coursesNeeeded = "";
			for (String s : coursesNeeded) {
				coursesNeeeded += s + ",";
				middleStudentPane.getCoursesNeededArea().setText(coursesNeeeded);
			}
			buttonDisable();
			personPane.add(update2, 1, 3);
			update2.setOnAction(e1 -> {

				person.setFirstName(topPersonPane.getFirstNameField().getText());
				person.setLastName(topPersonPane.getLastNameField().getText());
				phone = topPersonPane.getPhoneField().getText();
				Address a2 = new Address();
				String city = topPersonPane.getAddressPane().getCityField().getText();
				String state = topPersonPane.getState().getSelectionModel().getSelectedItem();
				String streetName = topPersonPane.getAddressPane().getStreetNumberField().getText();
				String streetNumber = topPersonPane.getAddressPane().getStreetNumberField().getText();
				String zip = topPersonPane.getAddressPane().getZip().getText();
				if (zip.toCharArray().length != 5 || isNumeric(zip) == false) {
					try {
						throw new ZipCodeException();
					} catch (ZipCodeException e2) {
						topPersonPane.getProgramOutput().appendText(e2.getMessage());
						return;
					}
				}
				if (phone.toCharArray().length != 10 || isNumeric(phone) == false) {
					try {
						throw new PhoneNumberException();
					} catch (PhoneNumberException e2) {
						topPersonPane.getProgramOutput().appendText(e2.getMessage());
						return;
					}
				}
				person.setPhone(phone);
				a2.setCity(city);
				a2.setState(state);
				a2.setStreetName(streetName);
				a2.setStreetNumber(streetNumber);
				a2.setZip(zip);
				person.setAddress(a2);
				if (middleStudentPane.getGpaField().getText().isEmpty() == false) {
					Double gpa = Double.parseDouble(middleStudentPane.getGpaField().getText());
					person.setGpa(gpa);
				}
				if (middleStudentPane.getCreditsTakingField().getText() != null) {
					Double credits = Double.parseDouble(middleStudentPane.getCreditsTakingField().getText());
					person.setCreditsTaking(credits);
				}
				if (middleStudentPane.getCoursesNeededArea() != null) {
					String coursesNeededUpdate = middleStudentPane.getCoursesNeededArea().getText();
					ArrayList<String> coursesNeededUpdateArr = new ArrayList<>();
					for (String string : coursesNeededUpdate.split(",")) {
						coursesNeededUpdateArr.add(string);
					}
					person.setCoursesNeeded(coursesNeededUpdateArr);
				}
				String major = middleStudentPane.getMajor().getSelectionModel().getSelectedItem();
				person.setMajor(major);
				person.setCoursesTaking(middleStudentPane.getCoursesTakingArrayList());
				person.setCoursesTook(middleStudentPane.getCoursesTookArrayList());
				personPane.getChildren().remove(middleStudentPane.getStudentPane());
				personPane.getChildren().remove(update2);
				btnDisable();
				topPersonPane.getProgramOutput().appendText("Updated: Student" + person + "\n" + b1);
			});
		}
		if (p1 instanceof Faculty) {
			Faculty person = (Faculty) p1;
			topPersonPane.getZip().setText(person.getAddress().getZip());
			topPersonPane.getStreetNumber().setText(person.getAddress().getStreetNumber());
			topPersonPane.getFirstNameField().setText(person.getFirstName());
			topPersonPane.getLastNameField().setText(person.getLastName());
			topPersonPane.getIdField().setText(person.getId());
			topPersonPane.getPhoneField().setText(person.getPhone());
			topPersonPane.getStreetName().setText(person.getAddress().getStreetName());
			topPersonPane.getAddressPane().getCityField().setText(person.getAddress().getCity());
			try {
				personPane.add(middleFacultyPane.getFacultyPane(), 2, 0);
			} catch (IllegalArgumentException e1) {

			}
			middleFacultyPane.getRankField().setText(person.getRank());
			middleFacultyPane.getSalaryField().setText(Double.toString(person.getSalary()));
			String coursesTeaching = "";
			for (String s : person.getCoursesTeaching()) {
				coursesTeaching += s + ",";
			}
			middleFacultyPane.getCoursesTeachingField().setText(coursesTeaching);
			buttonDisable();
			personPane.add(update2, 1, 3);
			update2.setOnAction(e1 -> {
				person.setFirstName(topPersonPane.getFirstNameField().getText());
				person.setLastName(topPersonPane.getLastNameField().getText());
				phone = topPersonPane.getPhoneField().getText();
				Address a2 = new Address();
				String city = topPersonPane.getAddressPane().getCityField().getText();
				String state = topPersonPane.getState().getSelectionModel().getSelectedItem();
				String streetName = topPersonPane.getAddressPane().getStreetNumberField().getText();
				String streetNumber = topPersonPane.getAddressPane().getStreetNumberField().getText();
				zip = topPersonPane.getAddressPane().getZip().getText();
				if (zip.toCharArray().length != 5 || isNumeric(zip) == false) {
					try {
						throw new ZipCodeException();
					} catch (ZipCodeException e2) {
						topPersonPane.getProgramOutput().appendText(e2.getMessage());
						return;
					}
				}
				if (phone.toCharArray().length != 10 || isNumeric(phone) == false) {
					try {
						throw new PhoneNumberException();
					} catch (PhoneNumberException e2) {
						topPersonPane.getProgramOutput().appendText(e2.getMessage());
						return;
					}
				}
				person.setPhone(phone);
				a2.setCity(city);
				a2.setState(state);
				a2.setStreetName(streetName);
				a2.setStreetNumber(streetNumber);
				a2.setZip(zip);
				person.setAddress(a2);
				String rankUpdate = middleFacultyPane.getSalaryField().getText();
				String coursesTeachingUpdate = middleFacultyPane.getCoursesTeachingField().getText();
				ArrayList<String> coursesTeachingArrayListUpdate = new ArrayList<>();
				for (String string : coursesTeachingUpdate.split(",")) {
					coursesTeachingArrayListUpdate.add(string);
				}
				person.setRank(rankUpdate);
				person.setCoursesTeaching(coursesTeachingArrayListUpdate);
				btnDisable();
				personPane.getChildren().remove(middleFacultyPane.getFacultyPane());
				topPersonPane.getProgramOutput().appendText("Updated: Faculty" + person + "\n" + b1);
			});
			BTNDisable();
		}
		// });
	}

	public BodyBag getB1() {
		return b1;
	}

	public void setSearchAction(Person p2) {
		topPersonPane.getZip().setText(p2.getAddress().getZip());
		topPersonPane.getStreetNumber().setText(p2.getAddress().getStreetNumber());
		topPersonPane.getFirstNameField().setText(p2.getFirstName());
		topPersonPane.getLastNameField().setText(p2.getLastName());
		topPersonPane.getIdField().setText(p2.getId());
		topPersonPane.getPhoneField().setText(p2.getPhone());
		topPersonPane.getStreetName().setText(p2.getAddress().getStreetName());
		topPersonPane.getAddressPane().getCityField().setText(p2.getAddress().getCity());
		topPersonPane.getProgramOutput().setText("FOUND!!!! \n");
		if (p2 instanceof Student) {
			personPane.getChildren().remove(middleFacultyPane.getFacultyPane());
			personPane.add(middleStudentPane.getStudentPane(), 2, 0);
			middleStudentPane.getGpaField().setText(Double.toString(((Student) p2).getGpa()));
			middleStudentPane.getCreditsTakingField().setText(Double.toString(((Student) p2).getCreditsTaking()));
			ArrayList<String> coursesNeeded = ((Student) p2).getCoursesNeeded();
			String coursesNeeeded = "";
			for (String s : coursesNeeded) {
				coursesNeeeded += s + ",";
				middleStudentPane.getCoursesNeededArea().setText(coursesNeeeded);
			}
		} else {
			personPane.getChildren().remove(middleStudentPane.getStudentPane());
			personPane.add(middleFacultyPane.getFacultyPane(), 2, 0);
			middleFacultyPane.getRankField().setText(((Faculty) p2).getRank());
			middleFacultyPane.getSalaryField().setText(Double.toString(((Faculty) p2).getSalary()));
			String coursesTeaching = "";
			for (String s : ((Faculty) p2).getCoursesTeaching()) {
				coursesTeaching += s + ",";
			}
			middleFacultyPane.getCoursesTeachingField().setText(coursesTeaching);
		}
	}

	public void setRemoveAction(Person p2) {
		personPane.getChildren().remove(middleFacultyPane);
		personPane.getChildren().remove(middleStudentPane);
		topPersonPane.getZip().setText(p2.getAddress().getZip());
		topPersonPane.getStreetNumber().setText(p2.getAddress().getStreetNumber());
		topPersonPane.getFirstNameField().setText(p2.getFirstName());
		topPersonPane.getLastNameField().setText(p2.getLastName());
		topPersonPane.getIdField().setText(p2.getId());
		topPersonPane.getPhoneField().setText(p2.getPhone());
		topPersonPane.getStreetName().setText(p2.getAddress().getStreetName());
		topPersonPane.getAddressPane().getCityField().setText(p2.getAddress().getCity());
		topPersonPane.getProgramOutput().setText("REMOVED !!!! \n");
		if (p2 instanceof Student) {
			personPane.getChildren().remove(middleFacultyPane.getFacultyPane());
			personPane.add(middleStudentPane.getStudentPane(), 2, 0);
			middleStudentPane.getGpaField().setText(Double.toString(((Student) p2).getGpa()));
			middleStudentPane.getCreditsTakingField().setText(Double.toString(((Student) p2).getCreditsTaking()));
			ArrayList<String> coursesNeeded = ((Student) p2).getCoursesNeeded();
			String coursesNeeeded = "";
			for (String s : coursesNeeded) {
				coursesNeeeded += s + ",";
				middleStudentPane.getCoursesNeededArea().setText(coursesNeeeded);
			}
		} else {
			personPane.getChildren().remove(middleStudentPane.getStudentPane());
			personPane.add(middleFacultyPane.getFacultyPane(), 2, 0);
			middleFacultyPane.getRankField().setText(((Faculty) p2).getRank());
			middleFacultyPane.getSalaryField().setText(Double.toString(((Faculty) p2).getSalary()));
			String coursesTeaching = "";
			for (String s : ((Faculty) p2).getCoursesTeaching()) {
				coursesTeaching += s + ",";
			}
			middleFacultyPane.getCoursesTeachingField().setText(coursesTeaching);
		}
		BTNDisable();
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

	public void btnDisable() {
		bottomButtonsPane.getUpdateBtn().setDisable(false);
		bottomButtonsPane.getFacultyBtn().setDisable(false);
		bottomButtonsPane.getInsertBtn().setDisable(false);
		bottomButtonsPane.getClearBtn().setDisable(false);
		bottomButtonsPane.getStudentBtn().setDisable(false);
		bottomButtonsPane.getSearchBtn().setDisable(false);
		bottomButtonsPane.getRemoveBtn().setDisable(false);
	}

	public void facultyDisable() {
		bottomButtonsPane.getStudentBtn().setDisable(true);
		bottomButtonsPane.getFacultyBtn().setDisable(false);
		bottomButtonsPane.getInsertBtn().setDisable(true);
	}

	public void buttonDisable() {
		bottomButtonsPane.getStudentBtn().setDisable(true);
		bottomButtonsPane.getFacultyBtn().setDisable(true);
		bottomButtonsPane.getInsertBtn().setDisable(true);
		bottomButtonsPane.getClearBtn().setDisable(true);
	}

	public void studentDisable() {
		bottomButtonsPane.getFacultyBtn().setDisable(true);
		bottomButtonsPane.getStudentBtn().setDisable(false);
		bottomButtonsPane.getInsertBtn().setDisable(true);
	}

	public void saveAction() {
		b1.writeFile();
		topPersonPane.getProgramOutput().setText("FILE SAVED");
	}

	public void loadAction() {
		b1.readFile();
		topPersonPane.getProgramOutput().setText("FILE LOADED \n " + b1);
	}

	public void exportStudent() {
		b1.exportStudent();
	}

	public void exportFaculty() {
		b1.exportFaculty();
	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public MiddleStudentPane getMiddleStudentPane() {
		return middleStudentPane;
	}

	public MiddleFacultyPane getMiddleFacultyPane() {
		return middleFacultyPane;
	}
	

}
