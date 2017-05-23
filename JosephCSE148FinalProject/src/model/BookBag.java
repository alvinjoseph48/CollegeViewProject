package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class BookBag implements Serializable {

	private int nElems = 0;
	private Textbook[] bookArray;
	private int maxSize = 30;

	public BookBag(Textbook[] bookArray) {
		super();
		this.bookArray = new Textbook[maxSize];
	}

	public BookBag() {
		super();
	}

	public int getnElems() {
		return nElems;
	}

	public void setnElems(int nElems) {
		this.nElems = nElems;
	}

	public Textbook[] getBookArray() {
		return bookArray;
	}

	public void setBookArray(Textbook[] bookArray) {
		this.bookArray = bookArray;
	}

	public void add(Textbook textbook) {
		if (nElems < maxSize) {
			bookArray[nElems] = textbook;
			nElems++;
		} else {
			maxSize += 10;
			Textbook newBookArray[] = new Textbook[maxSize];
			for (int i = 0; i < maxSize - 10; i++) {
				newBookArray[i] = bookArray[i];
			}
			bookArray = newBookArray;
			bookArray[nElems] = textbook;
			nElems++;
		}
	}

	public Textbook removeByBookISBN(String ISBN) throws ArrayIndexOutOfBoundsException {
		int i;
		for (i = 0; i < nElems; i++) {
			if (bookArray[i].getBookISBN().equals(ISBN)) {
				Textbook deleted = bookArray[i];
				for (int j = i; j < nElems - 1; j++) { // -1 ?????
					bookArray[j] = bookArray[j + 1];
				}
				nElems--;
				for (int j = nElems; j < bookArray.length; j++) {
					bookArray[j] = null;
				}
				return deleted;
			}
		}
		return bookArray[-1];
	}

	public Textbook SearchByBookISBN(String ISBN) throws ArrayIndexOutOfBoundsException {
		for (int i = 0; i < nElems; i++) {
			if (bookArray[i].getBookISBN().equals(ISBN)) {

				return bookArray[i];
			}
		}
		return bookArray[-1];
	}

	public void writeFile() {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("textbook.dat");
			oos = new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
				oos.writeObject(bookArray);		
				oos.close();
			}
		 catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void importTextbook(){
		BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader("importTextbook.txt"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
				String textbook;
				try {
					while((textbook = reader.readLine()) != null){
					String[] tokens = textbook.split(",");
					String isbn = tokens[0];
					String title = tokens[1];
					double price = Double.parseDouble(tokens[2]);
					ArrayList<Author> authors = new ArrayList<>();
					Author a1 ;
					for(int i =3 ; i < tokens.length ;i ++){
						if(tokens[i].isEmpty()){
							return;
						}
						a1 = new Author();
						a1.setAuthorFirstName(tokens[i]);
						a1.setAuthorLastName(tokens[++i]);
						authors.add(a1);	
					}
					Textbook t1 = new Textbook(isbn,title);
					t1.setBookPrice(price);
					t1.setBookAuthors(authors);
					add(t1);
					}
				} catch (IOException e) {
		
					e.printStackTrace();
				}finally{
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	public void exportTextbook() {
		BufferedWriter writer = null;
	    try {
	        writer = new BufferedWriter(new FileWriter("exportTextbook.txt"));
	        for ( int i = 0; i < bookArray.length; i++)
	        {      
	        if(bookArray[i] != null){
	          writer.write(bookArray[i].toString());
	          writer.newLine();
	          writer.flush();
	        }
	        }

	    } catch(IOException ex) {
	        ex.printStackTrace();
	    } finally{
	        if(writer!=null){
	            try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }  
	    }

	}

	public void readFile() {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("textbook.dat");
			ois = new ObjectInputStream(fis);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}
			try {
			bookArray =	(Textbook[]) ois.readObject();
			for(int i =0 ; i < bookArray.length ; i++){
			if(bookArray[i] !=null)
				nElems = i+1;
			}
			} catch (EOFException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		try {
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	@Override
	public String toString() {
		return "BookBag [nElems=" + nElems + ", bookArray=" + Arrays.toString(bookArray) + ", maxSize=" + maxSize;
	}

}
