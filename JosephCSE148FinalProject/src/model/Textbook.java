package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Textbook implements Serializable {

	private String bookISBN;
	private String bookTitle;
	private ArrayList<Author> bookAuthors = new ArrayList<>();
	private double bookPrice;

//	public Textbook(String bookISBN, String bookTitle, double bookPrice) throws NumberFormatException {
//		super();
//		this.bookISBN = bookISBN;
//		this.bookTitle = bookTitle;
//		this.bookPrice = bookPrice;
//	}

	public Textbook(String bookISBN, String bookTitle)throws NumberFormatException {
		super();
		this.bookISBN = bookISBN;
		this.bookTitle = bookTitle;
	}

	public Textbook() {
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public ArrayList<Author> getBookAuthors() {
		return bookAuthors;
	}

	public void setBookAuthors(ArrayList<Author> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "Textbook [bookISBN=" + bookISBN + ", bookTitle=" + bookTitle + ", bookAuthors=" + bookAuthors.toString()
				+ ", bookPrice=" + bookPrice + "]";
	}

}
