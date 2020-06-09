package Entity_hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personDetail")

public class PersonDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7049299835264090209L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "lastname", unique = false, nullable = false, length = 100)
	private String lastname;

	@Column(name = "firstname", unique = false, nullable = false, length = 100)
	private String firstname;

	@Column(name = "middlename", unique = false, nullable = true, length = 100)
	private String middlename;

	@Column(name = "age", unique = false, nullable = false, length = 100)
	private int age;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="person_location", 
	joinColumns={@JoinColumn(referencedColumnName="id")}, 
	inverseJoinColumns={@JoinColumn(referencedColumnName="id")}
			)
	private Set<barangay> barangays = new HashSet<>();

	public PersonDetail() {}

	public PersonDetail(int id, String lastname, String firstname, Set<barangay> barangays) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.barangays = barangays;
	}

	public int getid() {
		return id;
	}

	public void setP_id(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<barangay> getBarangays() {
		return barangays;
	}

	public void setBarangays(Set<barangay> barangays) {
		this.barangays = barangays;
	}
	
	
	public  int AgeCheck(int age) {
		int x = 0;
		int Age =0;

		if(x % 2==0){
			System.out.println("The last number is even: " + x);
		}

		else  {
			Age = (age / 4 * 3);
			System.out.println("The last number is odd: " + x);
		}
		return Age;
	}

	public int fibs(int age) {
		int aa;

		int x = 0;

		int y = 0;
		int z = 1;

		aa = age;

		for(int i = 1; i <= aa; i++)
		{
			x = y;
			y = z;
			z = x + y;
			System.out.println(x+ " ");
		} 
		return aa;
	}

	public void check(int arr[] , int toCheckValue, int toCheckValue1) {
		int Age =0;

		boolean match = IntStream.of(arr).anyMatch(x -> x == toCheckValue); 
		System.out.println("Length of the Lastname + Middlename: " + toCheckValue + " --- Exists in the Fibonacci Sequence: " + match); 

		boolean match1 = IntStream.of(arr).anyMatch(x -> x == toCheckValue1); 
		System.out.println("Length of Lastname + Middlename + Firstname: " + toCheckValue1 + " --- Exists in the Fibonacci Sequence: " + match1); 

		if(match == true) {
			System.out.println("Lastname: " + lastname);
			System.out.println("Middlename: " + middlename);
			System.out.println("Firstname: " + firstname);
		}
		else if (match1 == true) {

			System.out.println("Reverse:");
			String reverse = new StringBuffer(lastname).reverse().toString();
			String reverse1 = new StringBuffer(middlename).reverse().toString();
			String reverse2 = new StringBuffer(firstname).reverse().toString();
			System.out.println("Lastname: "+ reverse);
			System.out.println("Middlename: " + reverse1);
			System.out.println("Firstname: " + reverse2);
			System.out.println("Age: " + Age);

		}
		else if(match1 == false) {

			String mname = null;
			this.middlename = mname;
			System.out.println("Lastname: " + lastname);
			System.out.println("Firstname: " + firstname);
			System.out.println("Age: " + Age);
		}
	}
}
