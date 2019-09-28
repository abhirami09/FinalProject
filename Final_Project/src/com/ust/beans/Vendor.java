package com.ust.beans;

public class Vendor {
	private int vendor_id;
	private String vendor_name;
	private String address;
	private String location;
	private String service;
	private int pincode;
	private int isActive;
	
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(int vendor_id, String vendor_name, String address,
			String location, String service, int pincode, int isActive) {
		super();
		this.vendor_id = vendor_id;
		this.vendor_name = vendor_name;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActive = isActive;
	}
	public int getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Vendor [vendor_id=" + vendor_id + ", vendor_name="
				+ vendor_name + ", address=" + address + ", location="
				+ location + ", service=" + service + ", pincode=" + pincode
				+ ", isActive=" + isActive + "]";
	}
	
	

}
