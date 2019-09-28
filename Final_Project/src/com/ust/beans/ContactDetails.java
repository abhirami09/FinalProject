package com.ust.beans;

public class ContactDetails {
	private int cont_id;
	private String name;
	private int vendor_id;
	private String dept;
	private String email;
	private String phone;
	
	public ContactDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactDetails(int cont_id, String name, int vendor_id,
			String dept, String email, String phone) {
		super();
		this.cont_id = cont_id;
		this.name = name;
		this.vendor_id = vendor_id;
		this.dept = dept;
		this.email = email;
		this.phone = phone;
	}

	public int getCont_id() {
		return cont_id;
	}

	public void setCont_id(int cont_id) {
		this.cont_id = cont_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ContactDetails [cont_id=" + cont_id + ", name=" + name
				+ ", vendor_id=" + vendor_id + ", dept=" + dept
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
	

}
