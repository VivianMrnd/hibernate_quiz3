package Entity_hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "barangay")

public class barangay_onetomany implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7803607381398495898L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "bname", unique = true, nullable = false, length = 20)
	private String bname;
	
	@ManyToOne
	private PersonDetail_onetomany person;
	
	public barangay_onetomany() {}

	public barangay_onetomany(int id, String bname, PersonDetail_onetomany person) {
		super();
		this.id = id;
		this.bname = bname;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public PersonDetail_onetomany getPerson() {
		return person;
	}

	public void setPerson(PersonDetail_onetomany person) {
		this.person = person;
	}

}
