package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TopPersonPane {

	private GridPane personPane;
	private Label firstNameLbl;
	private Label lastNameLbl;
	private Label idLbl;
	private Label phoneLbl;
	private Label programOutputLbl;
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField idField;
	private TextField phoneField;
	private AddressPane addressPane;
	private TextArea programOutput;
	private GridPane programOutputPane;
	private GridPane idPane;

	public TopPersonPane() {
		personPane = new GridPane();
		idPane = new GridPane();
		firstNameLbl = new Label("First Name");
		lastNameLbl = new Label("Last Name");
		idLbl = new Label("Your ID:");
		phoneLbl = new Label("Phone #");
		programOutputLbl = new Label("Output:");
		// userIdLbl = new Label("DON'T ENTER ID IF INSERTING");
		firstNameField = new TextField();
		lastNameField = new TextField();
		idField = new TextField();
		phoneField = new TextField();
		addressPane = new AddressPane();
		programOutput = new TextArea();
		programOutputPane = new GridPane();

		programOutput.setMaxSize(500, 100);
		addressPane.getStateList().setMaxSize(150, 100);
		
		personPane.setPadding(new Insets(15, 15, 15, 15));
		personPane.setVgap(5);
		personPane.setHgap(5);

		personPane.add(firstNameLbl, 0, 0);
		personPane.add(firstNameField, 1, 0);
		personPane.add(lastNameLbl, 0, 1);
		personPane.add(lastNameField, 1, 1);
		personPane.add(phoneLbl, 0, 2);
		personPane.add(phoneField, 1, 2);
		personPane.add(addressPane.getStreetNumberLbl(), 0, 3);
		personPane.add(addressPane.getStreetNumberField(), 1, 3);
		personPane.add(addressPane.getStreetNameLbl(), 0, 4);
		personPane.add(addressPane.getStreetNameField(), 1, 4);
		personPane.add(addressPane.getCityLbl(), 0, 5);
		personPane.add(addressPane.getCityField(), 1, 5);
		personPane.add(addressPane.getStateLbl(), 0, 6);
		personPane.add(addressPane.getStateList(), 1, 6);
		personPane.add(addressPane.getZipLbl(), 0, 7);
		personPane.add(addressPane.getZip(), 1, 7);
		programOutputPane.add(programOutputLbl, 0, 0);
		programOutputPane.add(programOutput, 1, 0);
		
		programOutput.setMaxHeight(100);
		programOutput.setMaxWidth(200);

		idPane.setPadding(new Insets(5, 5, 5, 5));
		idPane.setVgap(5);
		idPane.setHgap(5);

		programOutputPane.setPadding(new Insets(15, 15, 15, 15));
		programOutputPane.setVgap(5);
		programOutputPane.setHgap(5);
		
		idPane.add(idLbl, 2, 0);
		idPane.add(idField, 3, 0);
	
		programOutputLbl.setTextFill(javafx.scene.paint.Color.BLUE);
		idLbl.setTextFill(javafx.scene.paint.Color.BLUE);
	}

	public GridPane getProgramOutputPane() {
		return programOutputPane;
	}

	public TextArea getProgramOutput() {
		return programOutput;
	}

	public GridPane getPersonPane() {
		return personPane;
	}

	public Label getFirstNameLbl() {
		return firstNameLbl;
	}

	public TextField getFirstNameField() {
		return firstNameField;
	}

	public TextField getLastNameField() {
		return lastNameField;
	}

	public TextField getIdField() {
		return idField;
	}

	public Label getIdLbl() {
		return idLbl;
	}

	public TextField getPhoneField() {
		return phoneField;
	}

	public TextField getStreetNumber() {
		return addressPane.getStreetNumberField();
	}

	public ListView<String> getState() {
		return addressPane.getStateList();
	}

	public TextField getZip() {
		return addressPane.getZip();
	}

	public AddressPane getAddressPane() {
		return addressPane;
	}

	public TextField getStreetName() {
		return addressPane.getStreetNameField();
	}

	public String getCity() {
		return addressPane.getCityField().getText();
	}

	public GridPane getIdPane() {
		return idPane;
	}
	
	
}
