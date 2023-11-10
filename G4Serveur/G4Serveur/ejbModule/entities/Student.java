package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Student extends User implements Serializable {

	private String firstName;
	private String lastName;
	private String telephone;
	@ManyToOne(fetch = FetchType.EAGER)
	private Filiere filiere;

	
	
	public Student() {}
	
	public Student(String email, String password ,String firstName, String lastName, String telephone) {
		super(email,password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
	}
	public Student(String email, String password ,String firstName, String lastName, String telephone,Filiere f) {
		super(email,password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.filiere = f;
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


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	
	
	
	

}
