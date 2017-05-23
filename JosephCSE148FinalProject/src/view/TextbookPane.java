package view;

import java.util.ArrayList;

import model.Author;
import model.BookBag;
import model.Textbook;
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

public class TextbookPane {
	private Button insertBtn;
	private Button searchBtn;
	private Button removeBtn;
	private Button updateBtn;
	private Button addBtn;
	private TextField textbookTitleField;
	private TextField textbookISBNField;
	private TextField textbookPriceField;
	private TextField authorFirstNameTextField;
	private TextField authorLastNameTextField;
	private TextField authorFirstNameTextField2;
	private TextField authorLastNameTextField2;
	private TextField authorFirstNameTextField3;
	private TextField authorLastNameTextField3;
	private TextField searchByISBNTextField;
	private TextArea idProgramOutputTextArea;
	private TextArea programOutputTextArea;
	private Label IsbnLbl;
	private Label textbookTitleLbl;
	private Label textbookISBNLbl;
	private Label textbookPriceLbl;
	private Label authorFirstNameLbl;
	private Label authorLastNameLbl;
	private Label programoutputLbl;
	private Label idProgramoutputLbl;
	private GridPane textbookPane;
	private GridPane textbookIdPane;
	private Textbook[] textbookArr;
	private BookBag b1;
	
	public TextbookPane() {
		insertBtn = new Button("Insert Textbook");
		searchBtn = new Button("Search By ISBN");
		removeBtn = new Button("Remove By ISBN");
		updateBtn = new Button("Click to Update By ISBN");
		addBtn = new Button("+");

		textbookTitleField = new TextField();
		textbookISBNField = new TextField();
		textbookPriceField = new TextField();
		authorFirstNameTextField = new TextField();
		authorLastNameTextField = new TextField();
		authorFirstNameTextField2 = new TextField();
		authorLastNameTextField2 = new TextField();
		authorFirstNameTextField3 = new TextField();
		authorLastNameTextField3 = new TextField();
		searchByISBNTextField = new TextField();

		programOutputTextArea = new TextArea();
		idProgramOutputTextArea = new TextArea();
		textbookTitleLbl = new Label("Textbook Title");
		textbookISBNLbl = new Label("Textbook ISBN");
		textbookPriceLbl = new Label("Textbook Price");
		authorFirstNameLbl = new Label("Authors first name");
		authorLastNameLbl = new Label("Authors last name");
		programoutputLbl = new Label("Program Output");
		idProgramoutputLbl = new Label("Program Output");
		IsbnLbl = new Label("Textbook Isbn:");
		textbookArr = new Textbook[10];
		b1 = new BookBag(textbookArr);

		textbookPane = new GridPane();
		textbookPane.setVgap(20);
		textbookPane.setHgap(20);
		textbookPane.setPadding(new Insets(20, 20, 20, 20));
		
		textbookPane.add(textbookTitleLbl, 0, 0);
		textbookPane.add(textbookTitleField, 1, 0);
		textbookPane.add(textbookISBNLbl, 0, 1);
		textbookPane.add(textbookISBNField, 1, 1);
		textbookPane.add(textbookPriceLbl, 0, 2);
		textbookPane.add(textbookPriceField, 1, 2);
		textbookPane.add(authorFirstNameLbl, 0, 3);
		textbookPane.add(authorFirstNameTextField, 1, 3);
		textbookPane.add(authorLastNameLbl, 0, 4);
		textbookPane.add(authorLastNameTextField, 1, 4);
		textbookPane.add(addBtn, 2, 4);
		textbookPane.add(insertBtn, 1, 5);
		textbookPane.add(programoutputLbl, 0, 6);
		textbookPane.add(programOutputTextArea, 1, 6);
		programOutputTextArea.setMaxHeight(100);
		programOutputTextArea.setMaxWidth(200);
		textbookIdPane = new GridPane();
		textbookIdPane.setVgap(20);
		textbookIdPane.setHgap(20);
		textbookIdPane.setPadding(new Insets(20, 20, 20, 20));
		textbookIdPane.add(IsbnLbl, 0, 0);
		textbookIdPane.add(searchByISBNTextField, 1, 0);
		textbookIdPane.add(searchBtn, 3, 1);
		textbookIdPane.add(removeBtn, 2, 1);
		textbookIdPane.add(updateBtn, 1, 1);
		textbookIdPane.add(idProgramoutputLbl, 0, 3);
		textbookIdPane.add(idProgramOutputTextArea, 1, 3,3,4);
	
		//idProgramOutputTextArea.setMaxHeight(100);
		//idProgramOutputTextArea.setMaxWidth(200);
	

	}

	public GridPane getTextbookIdPane() {
		return textbookIdPane;
	}

	public void saveAction() {
			b1.writeFile();
			programOutputTextArea.setText("FILE SAVED\n");
	}

	public void loadAction() {
			b1.readFile();
			programOutputTextArea.setText("FILE LOADED \n " + b1 + "\n");
	}

	public void insertBtnAction() {
		ArrayList<Author> authorsArr = new ArrayList<>();
		Textbook t1 = new Textbook();
		addBtn.setOnAction(e -> {
			String firstNameAuthor1 = authorFirstNameTextField.getText();
			String lastNameAuthor1 = authorLastNameTextField.getText();
			Author a1 = new Author(firstNameAuthor1, lastNameAuthor1);
			authorsArr.add(a1);
			authorFirstNameTextField.clear();
			authorLastNameTextField.clear();
			programOutputTextArea.setText("Enter Next Author to add more or Insert Whole Textbook\n");
			addBtn.setOnAction(e1 -> {
				String firstNameAuthor2 = authorFirstNameTextField.getText();
				String lastNameAuthor2 = authorLastNameTextField.getText();
			  Author a2 = new Author(firstNameAuthor2, lastNameAuthor2);
				authorsArr.add(a2);
				programOutputTextArea.setText("Enter 3rd Author MAX is 4 authors!! \n");
				authorFirstNameTextField.clear();
				authorLastNameTextField.clear();
				addBtn.setOnAction(e2 -> {
					String firstNameAuthor3 = authorFirstNameTextField.getText();
					String lastNameAuthor3 = authorLastNameTextField.getText();
					Author a3 = new Author(firstNameAuthor3, lastNameAuthor3);
					authorsArr.add(a3);
					programOutputTextArea.setText("Enter Textbook Information \n");
					authorFirstNameTextField.clear();
					authorLastNameTextField.clear();
					addBtn.setDisable(true);
					
				});
			});
		});
		insertBtn.setOnAction(event -> {

			Author a4 = null;
			try {
				String textbookTitle = textbookTitleField.getText();
				if (textbookTitle.isEmpty()) {
					programOutputTextArea.appendText("Must add a Title! \n");
					return;
				}
				String textbookISBN = textbookISBNField.getText();
				if (textbookISBN.isEmpty()) {
					programOutputTextArea.appendText("Must add A ISBN! \n");
					return;
				}
				Double textbookPrice = Double.parseDouble(textbookPriceField.getText());
				t1.setBookISBN(textbookISBN);
				t1.setBookTitle(textbookTitle);
				t1.setBookPrice(textbookPrice);
				String firstNameAuthor = authorFirstNameTextField.getText();
				String lastNameAuthor = authorLastNameTextField.getText();
				a4 = new Author(firstNameAuthor, lastNameAuthor);

				authorsArr.add(a4);
				t1.setBookAuthors(authorsArr);
				b1.add(t1);
				
				programOutputTextArea.appendText("ADDED!!! \n " + t1.toString() + "\n" + b1 + "\n");

				textbookTitleField.clear();
				textbookISBNField.clear();
				textbookPriceField.clear();
				authorFirstNameTextField.clear();
				authorLastNameTextField.clear();
				
				
			} catch (NumberFormatException e) {
				programOutputTextArea.appendText("Price must be a Number! \n");
				return;
			}
			addBtn.setDisable(false);
			
		});
		
	}

	public void searchBtnAction() {
		searchDisable();
		searchBtn.setOnAction(event -> {
			try {
				String searchByISBN = searchByISBNTextField.getText();
				Textbook found = b1.SearchByBookISBN(searchByISBN);
				idProgramOutputTextArea.appendText("\n Found Textbook ISBN:" + searchByISBN + "\n" + found + "\n");
			} catch (ArrayIndexOutOfBoundsException e) {
				idProgramOutputTextArea.appendText("Search for a valid ISBN!! \n");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				searchByISBNTextField.clear();
			}
		});
	}

	public void removeBtnAction() {
		removeDisable();
		removeBtn.setOnAction(event -> {
			try {
				String removeByISBN = searchByISBNTextField.getText();
				Textbook remove = b1.removeByBookISBN(removeByISBN);
				idProgramOutputTextArea.setText("Removed Textbook: ISBN: " + removeByISBN + "\n" + remove + "\n");
			} catch (ArrayIndexOutOfBoundsException e) {
				idProgramOutputTextArea.appendText("Search for a valid ISBN!! \n");
			} catch (Exception e) {
				e.printStackTrace();
				idProgramOutputTextArea.appendText("Search for a valid ISBN!! \n");
			} finally {
				searchByISBNTextField.clear();
			}
		});
	}

	public void updateBtnAction() {
		updateDisable();
		updateBtn.setOnAction(event -> {
			TextArea updateOutputTextArea = new TextArea();

			Label updateTextbookTitleLbl = new Label("Update Textbook Title");
			Label updateTextbookISBNLbl = new Label("Update Textbook ISBN");
			Label updateTextbookPriceLbl = new Label("Update Textbook Price");
			Label updateFirstNameAuthorLbl = new Label("Update Author's first name");
			Label updateLastNameAuthorLbl = new Label("Update Author's Last name");
			TextField updateTextbookPriceTextField = new TextField();
			TextField updateTextbookISBNTextField = new TextField();
			TextField updateTextbookTitleTextField = new TextField();
			TextField updateLastNameAuthorTextField = new TextField();
			TextField updateFirstNameAuthorTextField = new TextField();
			TextField updateLastNameAuthorTextField1 = new TextField();
			TextField updateFirstNameAuthorTextField1 = new TextField();	
			TextField updateLastNameAuthorTextField2 = new TextField();
			TextField updateFirstNameAuthorTextField2 = new TextField();
			TextField updateLastNameAuthorTextField3 = new TextField();
			TextField updateFirstNameAuthorTextField3 = new TextField();
			

			Button updateBtn2 = new Button("Update");
			try {

				String updateByTextbookISBN = searchByISBNTextField.getText();
				Textbook updateTextbook = b1.SearchByBookISBN(updateByTextbookISBN);

				updateOutputTextArea.appendText("Updating Textbook ISBN : " + updateTextbook.getBookISBN() + "\n"+ updateTextbook +"\n");
				Stage stage = new Stage();
				GridPane updatePane = new GridPane();
				updateTextbookPriceTextField.setText(Double.toString(updateTextbook.getBookPrice()));
				updateTextbookISBNTextField.setText(updateTextbook.getBookISBN());
				updateTextbookTitleTextField.setText(updateTextbook.getBookTitle());
				updateLastNameAuthorTextField.setText(updateTextbook.getBookAuthors().get(0).getAuthorLastName());
				updateFirstNameAuthorTextField.setText(updateTextbook.getBookAuthors().get(0).getAuthorFirstName());
				try{
				updateTextbook.getBookAuthors().get(1) ;
					updatePane.add(updateFirstNameAuthorTextField1, 2, 3);
					updatePane.add(updateLastNameAuthorTextField1, 2, 4);
					updateLastNameAuthorTextField1.setText(updateTextbook.getBookAuthors().get(1).getAuthorLastName());
					updateFirstNameAuthorTextField1.setText(updateTextbook.getBookAuthors().get(1).getAuthorFirstName());
				updateTextbook.getBookAuthors().get(2);
					updatePane.add(updateFirstNameAuthorTextField2, 3, 3);
					updatePane.add(updateLastNameAuthorTextField2, 3, 4);
					updateLastNameAuthorTextField2.setText(updateTextbook.getBookAuthors().get(2).getAuthorLastName());
					updateFirstNameAuthorTextField2.setText(updateTextbook.getBookAuthors().get(2).getAuthorFirstName());
				updateTextbook.getBookAuthors().get(3);
					updatePane.add(updateFirstNameAuthorTextField3, 4, 3);
					updatePane.add(updateLastNameAuthorTextField3, 4, 4);
					updateLastNameAuthorTextField3.setText(updateTextbook.getBookAuthors().get(3).getAuthorLastName());
					updateFirstNameAuthorTextField3.setText(updateTextbook.getBookAuthors().get(3).getAuthorFirstName());
				}catch(IndexOutOfBoundsException e){
				}
				updateBtn2.setOnAction(e -> {
					String updateTitle = updateTextbookTitleTextField.getText();
					String updateISBN = updateTextbookISBNTextField.getText();
					String updateFirstNameAuthor = updateFirstNameAuthorTextField.getText();
					String updateLastNameAuthor = updateLastNameAuthorTextField.getText();
					String updateFirstNameAuthor1 = updateFirstNameAuthorTextField1.getText();
					String updateLastNameAuthor1 = updateLastNameAuthorTextField1.getText();
					String updateFirstNameAuthor2 = updateFirstNameAuthorTextField2.getText();
					String updateLastNameAuthor2 = updateLastNameAuthorTextField2.getText();
					String updateFirstNameAuthor3 = updateFirstNameAuthorTextField3.getText();
					String updateLastNameAuthor3 = updateLastNameAuthorTextField3.getText();
					try {
						Double updatePrice = Double.parseDouble(updateTextbookPriceTextField.getText());
						if (updatePrice != null) {
							updateTextbook.setBookPrice(updatePrice);
						}
					} catch (NumberFormatException e1) {
						updateOutputTextArea.appendText("Price must be a Number! \n");
						return;
					}
					if (updateTitle.isEmpty() == false) {
						updateTextbook.setBookTitle(updateTitle);
					}
					if (updateISBN.isEmpty() == false) {
						updateTextbook.setBookISBN(updateISBN);
					}

					if (updateFirstNameAuthor.isEmpty() == false || updateLastNameAuthor.isEmpty() == false) {
						Author updateAuthor = new Author(updateFirstNameAuthor, updateLastNameAuthor);
						Author updateAuthor1 = new Author(updateFirstNameAuthor1, updateLastNameAuthor1);
						Author updateAuthor2 = new Author(updateFirstNameAuthor2, updateLastNameAuthor2);
						Author updateAuthor3 = new Author(updateFirstNameAuthor3, updateLastNameAuthor3);
						ArrayList<Author> newArr = new ArrayList<>();
						newArr.add(updateAuthor);
						newArr.add(updateAuthor1);
						newArr.add(updateAuthor2);
						newArr.add(updateAuthor3);
						updateTextbook.setBookAuthors(newArr);
					}

					updateOutputTextArea.appendText("Updated Textbook :\n" + updateTextbook.toString() + "+\n");

					updateTextbookTitleTextField.clear();
					updateTextbookISBNTextField.clear();
					updateTextbookPriceTextField.clear();
					updateFirstNameAuthorTextField.clear();
					updateLastNameAuthorTextField.clear();
					updateBtn2.setDisable(true);

				});
				updatePane.add(updateTextbookTitleLbl, 0, 0);
				updatePane.add(updateTextbookTitleTextField, 1, 0);
				updatePane.add(updateTextbookISBNLbl, 0, 1);
				updatePane.add(updateTextbookISBNTextField, 1, 1);
				updatePane.add(updateTextbookPriceLbl, 0, 2);
				updatePane.add(updateTextbookPriceTextField, 1, 2);
				updatePane.add(updateFirstNameAuthorLbl, 0, 3);
				updatePane.add(updateFirstNameAuthorTextField, 1, 3);
				updatePane.add(updateLastNameAuthorLbl, 0, 4);
				updatePane.add(updateLastNameAuthorTextField, 1, 4);
				updatePane.add(updateBtn2, 0, 5);
				updatePane.add(updateOutputTextArea, 0, 6, 2, 6);
				updatePane.setPadding(new Insets(20, 20, 20, 20));
				updatePane.setVgap(30);
				updatePane.setHgap(10);

				Scene scene = new Scene(updatePane, 850, 600);

				stage.setScene(scene);
				stage.show();
			} catch (ArrayIndexOutOfBoundsException e) {
				idProgramOutputTextArea.appendText("Search for a valid ISBN!! \n");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				searchByISBNTextField.clear();
			}

		});
	}
	public void exportTextbook(){
		b1.exportTextbook();
	}
	public GridPane getTextbookPane() {
		return textbookPane;
	}
	public void removeDisable(){
		updateBtn.setDisable(true);
		searchBtn.setDisable(true);;
		removeBtn.setDisable(false);
	}
	public void updateDisable(){
		updateBtn.setDisable(false);
		searchBtn.setDisable(true);;
		removeBtn.setDisable(true);
	}
	public void searchDisable(){
		updateBtn.setDisable(true);
		searchBtn.setDisable(false);;
		removeBtn.setDisable(true);
	}

	public void importTextbook() {
		b1.importTextbook();
	}
}
