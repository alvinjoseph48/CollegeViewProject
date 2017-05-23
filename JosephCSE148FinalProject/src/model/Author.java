package model;

import java.io.Serializable;

public class Author implements Serializable {
	private String authorFirstName;
	private String authorLastName;

	public Author(String authorFirstName, String authorLastName) {
		super();
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
	}

	public Author() {

	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	@Override
	public String toString() {
		return "Author [authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName + "]";
	}

}
