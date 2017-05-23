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

import javafx.scene.layout.GridPane;

public class BodyBag implements Serializable {
	private int nElems = 0;
	private Person[] peopleArray;
	private int maxSize = 10;

	public BodyBag() {
		super();
		this.peopleArray = new Person[maxSize];
	}

	public BodyBag(Person[] peopleArray) {
		super();
		this.peopleArray = new Person[maxSize];
	}

	public int getnElems() {
		return nElems;
	}

	public void setnElems(int nElems) {
		this.nElems = nElems;
	}

	public Person[] getPeopleArray() {
		return peopleArray;
	}

	public void setPeopleArray(Person[] peopleArray) {
		this.peopleArray = peopleArray;
	}

	public void insert(Person person) {
		if (nElems < maxSize) {
			peopleArray[nElems] = person;
			nElems++;
		} else {
			maxSize += 10;
			Person[] newPeopleArray = new Person[maxSize];
			for (int i = 0; i < maxSize - 10; i++) {
				newPeopleArray[i] = peopleArray[i];
			}
			peopleArray = newPeopleArray;
			peopleArray[nElems] = person;
			nElems++;
		}
	}

	public Person removeById(String id) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (peopleArray[i].getId().equals(id)) {
				Person deleted = peopleArray[i];
				for (int j = i; j < nElems - 1; j++) {
					peopleArray[j] = peopleArray[j + 1];
				}
				nElems--;
				for (int j = nElems; j < peopleArray.length; j++) {
					peopleArray[j] = null;

				}
				return deleted;
			}
		}
		return null;
	}

	public Person searchById(String id) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (peopleArray[i].getId().equals(id)) {
				return peopleArray[i];
			}
		}
		return null;
	}

	public boolean update(String id, Person updatedPerson) {

		Person p = searchById(id);
		if (p == null) {
			return false;
		} else {
			p = updatedPerson;
			return true;
		}
	}

	public void importPerson() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("importPerson.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String person;
		ArrayList<String> coursesTook = null;
		ArrayList<String> coursesNeed = null;
		ArrayList<String> coursesTaking = null;
		ArrayList<String> coursesTeaching = null;
		try {
			while ((person = reader.readLine()) != null) {
				String[] tokens = person.split(",");
				String firstName = tokens[0];
				String lastName = tokens[1];
				String phoneNumber = tokens[2];
				String streetNumber = tokens[3];
				String streetName = tokens[4];
				String city = tokens[5];
				String state = tokens[6];
				String zip = tokens[7];
				Address a1 = new Address();
				a1.setCity(city);
				a1.setState(state);
				a1.setStreetName(streetName);
				a1.setStreetNumber(streetNumber);
				a1.setZip(zip);
				int index = 0;
				String major = null;
				double creditsTaking = 0;

				if (isNumeric(tokens[8])) {
					double gpa = Double.parseDouble(tokens[8]);
					coursesTook = new ArrayList<>();

					for (int i = 9; i < tokens.length; i++) {
						if (isNumeric(tokens[i])) {
							index = i;
							
							break;
						} else {
							coursesTook.add(tokens[i]);
						
						}
					}
				
					if (isNumeric(tokens[index])) {
						creditsTaking = Double.parseDouble(tokens[index]);
					}
					coursesNeed = new ArrayList<>();
					for (int i = index + 1; i < tokens.length; i++) {
						if (isNumeric(tokens[i])) {
							index = i;
							break;
						} else {
							coursesNeed.add(tokens[i]);
						}
					}
					coursesTaking = new ArrayList<>();
					if (isNumeric(tokens[index])) {
						major = tokens[index + 1];
						for (int i = index + 2; i < tokens.length; i++) {
							if (isNumeric(tokens[i])) {
								index = i;
								return;
							} else {
								coursesTaking.add(tokens[i]);
							}
						}
					}
					Student s1 = new Student(firstName, lastName);
					s1.setAddress(a1);
					s1.setCoursesNeeded(coursesNeed);
					s1.setCoursesTaking(coursesTaking);
					s1.setCreditsTaking(creditsTaking);
					s1.setCoursesTook(coursesTook);
					s1.setGpa(gpa);
					s1.setMajor(major);
					s1.setPhone(phoneNumber);
					insert(s1);
				} else {
					coursesTeaching = new ArrayList<>();
					String rank = tokens[8];
					double salary = Double.parseDouble(tokens[9]);
					for (int i = 9; i < tokens.length; i++) {
						coursesTeaching.add(tokens[i]);
					}

					Faculty f1 = new Faculty(firstName, lastName);
					f1.setAddress(a1);
					f1.setPhone(phoneNumber);
					f1.setRank(rank);
					f1.setSalary(salary);
					f1.setCoursesTeaching(coursesTeaching);
					insert(f1);
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public void exportStudent() {
		BufferedWriter writer = null;
		int maxsize = peopleArray.length;
		Student[] studentArray = new Student[maxsize];
		try {
			writer = new BufferedWriter(new FileWriter("exportStudent.txt"));
			for (int i = 0; i < peopleArray.length; i++) {
				if (peopleArray[i] instanceof Student) {
					int j;
					for (j = 0; j < nElems; j++) {
						studentArray[j] = (Student) peopleArray[i];
						System.out.println(studentArray[j]);
					}
					for (j = 0; j < nElems; j++) {
					if (studentArray[j] != null) {
						writer.write(studentArray[j].toString());
						writer.newLine();
						writer.flush();
					}
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void exportFaculty() {
		BufferedWriter writer = null;
		int maxsize = peopleArray.length;
		Faculty[] facultyArray = new Faculty[maxsize];
		try {
			writer = new BufferedWriter(new FileWriter("exportFaculty.txt"));
			for (int i = 0; i < peopleArray.length; i++) {
				if (peopleArray[i] instanceof Faculty) {
					for (int j = 0; j < facultyArray.length-1; j++) {
						facultyArray[i] = (Faculty) peopleArray[i];
					}
				}
			}
					for(int k = 0 ; k < facultyArray.length; k++ ){
					if (facultyArray[k] != null) {
						writer.write(facultyArray[k].toString());
						writer.newLine();
						writer.flush();
					}
					}
		
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void writeFile() {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("person.dat");
			oos = new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos.writeObject(peopleArray);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	///// load id
	public void readFile() {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("person.dat");
			ois = new ObjectInputStream(fis);
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			peopleArray = (Person[]) ois.readObject();
			BodyBag b1 = new BodyBag(peopleArray);
			for (int i = 0; i < peopleArray.length; i++) {
				if (peopleArray[0] == null) {
					nElems = 0;
				}
				if (peopleArray[i] != null) {
					nElems = i + 1;
				}
			}
			ois.close();
		} catch (EOFException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "BodyBag [nElems=" + nElems + ", peopleArray=" + Arrays.toString(peopleArray) + "]";
	}

}
