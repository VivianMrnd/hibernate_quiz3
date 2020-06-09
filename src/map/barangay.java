package map;

import java.io.Serializable;

public class barangay implements Serializable{

	private static final long serialVersionUID = -7718223719561825957L;
	
	private int b_id;

	private String bname;
	
	private String street;

	public barangay() {}

	public barangay(int b_id, String bname, String street) {
		this.b_id = b_id;
		this.bname = bname;
		this.street = street;
	}

	public int getB_id() {
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	

}
