package view;

import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AddressPane {

	private Label streetNumberLbl;
	private Label streetNameLbl;
	private Label cityLbl;
	private Label stateLbl;
	private Label zipLbl;

	private TextField streetNumberField;
	private TextField streetNameField;
	private TextField cityField;
	private TextField zip;

	private ListView<String> stateList;

	public AddressPane() {
		streetNumberLbl = new Label("Street Number");
		streetNameLbl = new Label("Street Name");
		cityLbl = new Label("City");
		stateLbl = new Label("State");
		zipLbl = new Label("Zip Code");

		streetNumberField = new TextField();
		streetNameField = new TextField();
		cityField = new TextField();
		zip = new TextField();

		ObservableList<String> states = FXCollections.observableArrayList("Alabama", "Alaska", "Arkansas", "Arizona",
				"California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho",
				"Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
				"Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
				"New Jersey", "New Mexico", "New York", "North Carolina,", "North Dakota", "Ohio", "Oklahoma", "Oregon",
				"Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
				"Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");

		stateList = new ListView<String>(states);
	}

	public Label getStreetNumberLbl() {
		return streetNumberLbl;
	}

	public Label getStreetNameLbl() {
		return streetNameLbl;
	}

	public Label getCityLbl() {
		return cityLbl;
	}

	public Label getStateLbl() {
		return stateLbl;
	}

	public Label getZipLbl() {
		return zipLbl;
	}

	public TextField getStreetNameField() {
		return streetNameField;
	}

	public TextField getStreetNumberField() {
		return streetNumberField;
	}

	public TextField getCityField() {
		return cityField;
	}

	public TextField getZip() {
		return zip;
	}

	public ListView<String> getStateList() {
		return stateList;
	}
	
}
