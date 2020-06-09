package list;

import java.io.Serializable;
import java.util.List;
import java.util.stream.IntStream;

public class PersonDetail implements Serializable {
	
	
	private static final long serialVersionUID = -5302830493777198637L;
	
	private int p_id;

	private String lastname;

	private String firstname;

	private String middlename;

	private int age;
	
	private List<barangay> barangays;

	public PersonDetail() {}

	public PersonDetail(int p_id, String lastname, String firstname, 
			String middlename, int age, List<barangay> barangays) {
		this.p_id = p_id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.middlename = middlename;
		this.age = age;
		this.barangays = barangays;
	}
	
	
	public int getp_id() {
		return p_id;
	}

	public void setId(int p_id) {
		this.p_id= p_id;
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

	public List<barangay> getBarangays() {
		return barangays;
	}

	public void setBarangays(List<barangay> barangays) {
		this.barangays = barangays;
	}



	int aa;
	int x = 0;

	int Age;

	public  int AgeCheck(int age) {
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
