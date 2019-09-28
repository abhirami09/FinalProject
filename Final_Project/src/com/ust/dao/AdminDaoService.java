package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.ContactDetails;
import com.ust.beans.Login;
import com.ust.beans.Vendor;
import com.ust.beans.VendorContact;




public class AdminDaoService {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	
	// login validation
	
	public Login validate(String username, String password) {
		String sql = "select user_id from login where username='"
				+ username
				+ "' and password='" + password + "'";
		return template.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Login>(Login.class));
	}

	// to get all vendors

	public List<Vendor> getAllVendor() {
		return template
				.query("SELECT vendor_id,vendor_name,address,location,service,pincode,isActive FROM vendor where isActive=1 ",
						new RowMapper<Vendor>() {
							public Vendor mapRow(ResultSet rs, int row)
									throws SQLException {
								Vendor vendor = new Vendor();
								vendor.setVendor_id(rs.getInt(1));
								vendor.setVendor_name(rs.getString(2));
								vendor.setAddress(rs.getString(3));
								vendor.setLocation(rs.getString(4));
								vendor.setService(rs.getString(5));
								vendor.setPincode(rs.getInt(6));
								vendor.setIsActive(rs.getInt(7));
								return vendor;
							}
						});
	}

	// to get vendor by name

	public List<Vendor> getVendorByName(String vName) {
		return template
				.query("SELECT vendor_id,vendor_name,address,location,service,pincode,isActive FROM vendor"
						+ "where  vendor_name='" + vName +"' AND isActive=1 ",
						new RowMapper<Vendor>() {
							public Vendor mapRow(ResultSet rs, int row)
									throws SQLException {
								Vendor s = new Vendor();
								Vendor vendor = new Vendor();
								vendor.setVendor_id(rs.getInt(1));
								vendor.setVendor_name(rs.getString(2));
								vendor.setAddress(rs.getString(3));
								vendor.setLocation(rs.getString(4));
								vendor.setService(rs.getString(5));
								vendor.setPincode(rs.getInt(6));
								vendor.setIsActive(rs.getInt(7));

								return vendor;

							}
						});
	}
	
	
	
	// get contactdetails by id
	
	public ContactDetails getContactDetailsByVId(int vid) {
		String sql = "select cont_id,name,vendor_id,dept,email,phone from contactdetails where vendor_id=?";
		return template.queryForObject(sql, new Object[] { vid },
				new BeanPropertyRowMapper<ContactDetails>(ContactDetails.class));

	}
	
	
	// to disable a vendor
	public int disableVendor(int vId) {

		String sql = "update vendor set isActive='0' where vendor_id=" + vId
				+ "";

		return template.update(sql);
	}
	
	//Add vendor
	
	public int saveVendor(VendorContact vendorContact) {

		String sql1 = "insert into vendor(vendor_name,address,location,service,pincode,isActive) values "
				+ "('"
				+ vendorContact.getVendor_name()
				+ "','"
				+ vendorContact.getAddress()
				+ "','"
				+ vendorContact.getLocation()
				+ "','"
				+ vendorContact.getService()
				+ "','"
				+ vendorContact.getPincode()
				+ "',"
				+ 1
				+ ")";

		 template.update(sql1);
		 
		 Integer maxId = getMaxVid();
		 String sql2="insert into contactdetails(vendor_id,name,dept,email,phone) values ("
				 + maxId
					+ ",'"
					+ vendorContact.getName()
					+ "','"
					+ vendorContact.getDept()
					+ "','"
					+ vendorContact.getEmail()
					+ "','" + vendorContact.getPhone() + "')";
		 return template.update(sql2);

				 
		 
	}
	
	// to get max vendor_id
	private Integer getMaxVid() {
		Integer seq;
		String sql = "select MAX(vendor_id)from vendor";
		seq = template.queryForObject(sql, new Object[] {}, Integer.class);
		return seq;
	}
		
	// update vendor
	public int updateVendor(int vendor_id, VendorContact vendorContact) {

	String sql = "update vendor set vendor_name='" + vendorContact.getVendor_name()
	+ "' ,address='" + vendorContact.getAddress() + "' ,location='"
	+ vendorContact.getLocation() + "',service='" + vendorContact.getService() + "',pincode=" + vendorContact.getPincode() + ",isActive= 1 "
	+ "where vendor_id =" + vendor_id;
	template.update(sql);

	// Integer maxId = getSequence();

	String sql1 = "update contactdetails set vendor_id=" + vendor_id + ",name='"
	+ vendorContact.getName() + "',dept='"
	+ vendorContact.getDept() + "',email='"
	+ vendorContact.getEmail() + "',phone='" + vendorContact.getPhone() + "'where cont_id = " + vendorContact.getCont_id();

	return template.update(sql1);
	}
	
	// get vendor details by id
	public VendorContact getVendorById(int vendor_id) {
		String sql="select vendor.vendor_id,vendor_name,address,location,service,pincode,name,dept,email,phone,cont_id from vendor  join contactdetails  on vendor.vendor_id=contactdetails.vendor_id where vendor.isActive=1 and vendor.vendor_id='"+ vendor_id + "'";
		return template.queryForObject(sql, new Object[] {},
		new BeanPropertyRowMapper<VendorContact>(VendorContact.class));

		}



}

	
	
	
	
	
	
	


