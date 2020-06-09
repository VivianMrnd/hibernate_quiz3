package Entity_hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "barangay")

public class barangay implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 418460232978043047L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int b_id;

	@Column(name = "bname", unique = false, nullable = false, length = 100)
	private String bname;

	public int getId() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Set<PersonDetail> getPersons() {
		return persons;
	}

	public void setPersons(Set<PersonDetail> persons) {
		this.persons = persons;
	}

	@ManyToMany(mappedBy = "barangays")
	private Set<PersonDetail> persons = new HashSet<>();

	public barangay() {}

	public barangay(int b_id, String bnname, Set<PersonDetail> persons) {
		this.b_id = b_id;
		this.bname = bnname;
		this.persons = persons;
	}

}
