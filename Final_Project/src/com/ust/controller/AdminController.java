package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.beans.ContactDetails;
import com.ust.beans.Login;
import com.ust.beans.Vendor;
import com.ust.beans.VendorContact;
import com.ust.dao.AdminDaoService;


@RestController
public class AdminController {

	@Autowired
	AdminDaoService dao;

	// login validation

	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public Login selectUser(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return dao.validate(username,password);
	}

	// view vendor list
	@RequestMapping(value = "/api/vendor/{vName}", method = RequestMethod.GET)
	@ResponseBody
	public List getVendor(@PathVariable("vName") String vName) {
		List list;
		if (vName.equals("null")) {
			list = dao.getAllVendor();
		} else {
			list = dao.getVendorByName(vName);
		}

		return list;
	}

	// view contactdetails by vendor id

	@RequestMapping(value = "/api/contactDetails/{vId}", method = RequestMethod.GET)
	@ResponseBody
	public ContactDetails getContactDetails(@PathVariable("vId") int vId) {

		return dao.getContactDetailsByVId(vId);

	}

	// to disable a vendor

	@RequestMapping(value = "/api/disablevendor/{vId}", method = RequestMethod.PUT)
	@ResponseBody
	public void disableVendor(@PathVariable("vId") int vId) {
		dao.disableVendor(vId);
	}

	// Add Vendor
			@ResponseBody
			@RequestMapping(value = "/api/insertvendor", method = RequestMethod.POST)
			public void insertDoctor(@RequestBody VendorContact vc) {
				dao.saveVendor(vc);
			}
	
	// update  vendor details
	
		@RequestMapping(value = "/api/updateVendor", method = RequestMethod.PUT)
		public void updateVendorDetails(@RequestBody VendorContact vendorContact) {
			int vid=vendorContact.getVendor_id();
			dao.updateVendor(vid,vendorContact);

		}
		
		// view vendor list by id
		@RequestMapping(value = "/api/getvendor/{vendor_id}", method = RequestMethod.GET)
		@ResponseBody
		public VendorContact getvendors(@PathVariable("vendor_id") int vendor_id) {

		return  dao.getVendorById(vendor_id);

		}


	
	
	
	

}
