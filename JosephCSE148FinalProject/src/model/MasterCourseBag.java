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

public class MasterCourseBag implements Serializable {
	private Course[] CourseBag;
	private int nElems;
	private int maxSize = 10;

	public MasterCourseBag(Course[] courseBag) {
		this.CourseBag = new Course[maxSize];
	}

	public Course[] getCourseBag() {
		return CourseBag;
	}

	public int getnElems() {
		return nElems;
	}

	public void setCourseBag(Course[] courseBag) {
		CourseBag = courseBag;
	}

	public void setnElems(int nElems) {
		this.nElems = nElems;
	}

	public void add(Course course) {
		if (nElems < maxSize) {
			CourseBag[nElems] = course;
			nElems++;
		} else {
			maxSize += 10;
			Course newCourseArray[] = new Course[maxSize];
			for (int i = 0; i < maxSize - 10; i++) {
				newCourseArray[i] = CourseBag[i];
			}
			CourseBag = newCourseArray;
			CourseBag[nElems] = course;
			nElems++;
		}
	}

	public Course removeByCourseNumber(String courseNumber) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (CourseBag[i].getCourseNumber().equals(courseNumber)) {
				Course deleted = CourseBag[i];
				for (int j = i; j < nElems - 1; j++) { // -1 ?????
					CourseBag[j] = CourseBag[j + 1];
				}
				nElems--;
				for (int j = nElems; j < CourseBag.length; j++) {
					CourseBag[j] = null;
				}
				return deleted;
			}
		}
		return null;
	}

	public Course SearchByCourseNumber(String courseNumber) {
		for (int i = 0; i < nElems; i++) {
			if (CourseBag[i].getCourseNumber().equals(courseNumber)) {

				return CourseBag[i];
			}
		}
		return null;
	}
	public Course update(String CourseNum, Course updateCourse) {

		Course c = SearchByCourseNumber(CourseNum);
		if (c == null) {
			return null;
		} else {
			c = updateCourse;
			return c;
		}
	}
	public void writeFile() {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("course.dat");
			oos = new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos.writeInt(nElems);
			oos.writeObject(CourseBag);
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void importCourse(){
		BufferedReader reader = null;
		
			try {
				reader = new BufferedReader(new FileReader("importCourse.txt"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
				String course;
				try {
					while((course = reader.readLine()) != null){
					String[] tokens = course.split(",");
					String courseNum = tokens[0];
					String courseTitle = tokens[1];
					double credits = Double.parseDouble(tokens[2]);
					String descrtipion = tokens[3];
					ArrayList<String> textbooks = new ArrayList<>();
					Textbook t1 = null ;
					for(int i = 4 ; i < tokens.length ;i ++){
						if(tokens[i].isEmpty()){
							return;
						}
						t1 = new Textbook();
						t1.setBookISBN(tokens[i]);
					}
					textbooks.add(t1.toString());
					Course c1 = new Course(courseNum, courseTitle);
					c1.setCourseCredits(credits);
					c1.setCourseDescription(descrtipion);
					c1.setTextbooks(textbooks);
					add(c1);
					
					}
				} catch (IOException e) {
		
					e.printStackTrace();
				}finally{
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
	public void exportCourses() {
		BufferedWriter writer = null;
	    try {
	        writer = new BufferedWriter(new FileWriter("exportCourse.txt"));
	        for ( int i = 0; i < CourseBag.length; i++)
	        {      
	        if(CourseBag[i] != null){
	          writer.write(CourseBag[i].toString());
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
			FileInputStream fis = new FileInputStream("course.dat");
			ois = new ObjectInputStream(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			nElems = ois.readInt();
			CourseBag = (Course[]) ois.readObject();
			MasterCourseBag b1 = new MasterCourseBag(CourseBag);
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
		return "MasterCourseBag [CourseBag=" + Arrays.toString(CourseBag) + ", nElems=" + nElems  + "]";
	}
}
