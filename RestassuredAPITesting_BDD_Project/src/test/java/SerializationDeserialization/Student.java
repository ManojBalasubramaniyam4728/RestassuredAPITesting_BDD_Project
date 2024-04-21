package SerializationDeserialization;

import java.util.List;

public class Student {
	public Integer id;
	public String firstName;
	public String lastName;
	public String email;
	public String programme;

	List<String> courses;

	public int getSID() {
	return id;
	}

	public void setSID(Integer id) {
	this.id = id;
	}

	public String getFirstName() {
	return firstName;
	}

	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}
	
	public String getLastName() {
	return lastName;
	}

	public void setLastName(String lastName) {
	this.lastName = lastName;
	}

	public String getEmail() {
	return email;
	}

	public void setEmail(String email) {
	this.email = email;
	}
	
	public String getProgramme() {
	return programme;
	}

		
	public void setProgramme(String programme) {
	this.programme = programme;
	}

	public List<String> getCourses() {
	return courses;
	}

	public void setCourses(List<String> courses) {
	this.courses = courses;
	}

	public String getStudentRecord(){
	return(this.id+" "+this.firstName+" "+this.lastName+" "+this.email+" "+this.programme+" "+this.courses);
	}
}
