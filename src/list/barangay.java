package list;

import java.io.Serializable;

public class barangay implements Serializable{

	private static final long serialVersionUID = -7718223719561825957L;
	
	private int b_id;

	private String bname;

	public barangay() {}

	public barangay(int b_id, String bname) {
		this.b_id = b_id;
		this.bname = bname;
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

}
