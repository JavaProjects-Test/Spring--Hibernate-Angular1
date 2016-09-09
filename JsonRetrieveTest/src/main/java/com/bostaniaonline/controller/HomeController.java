/**
 * 
 */
package com.bostaniaonline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bostaniaonline.mail.UserMail;
import com.bostaniaonline.service.IBostainaonlineService;
import com.bostaniaonline.vo.Bag;
import com.bostaniaonline.vo.Laptop;
import com.bostaniaonline.vo.Phone;
import com.bostaniaonline.vo.Speaker;
import com.bostaniaonline.vo.UserSignUp;

/**
 * @author sahil.kaushik
 * 
 */
@Controller
public class HomeController {
	@Autowired
	private IBostainaonlineService bostainaonlineService;

	/**
	 * @param bostainaonlineService
	 *            the bostainaonlineService to set
	 */
	public void setBostainaonlineService(
			IBostainaonlineService bostainaonlineService) {
		this.bostainaonlineService = bostainaonlineService;
	}

	String success = "success";
	String failure = "failure";
	String status = "status";

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> signupUser(@RequestBody UserSignUp usrerSignUp) {
		Map<String, String> insertMap = new HashMap<String, String>();
		int userId = bostainaonlineService.signupUser(usrerSignUp);
		if (userId != 0) {
			insertMap.put(status, success);
		} else {
			insertMap.put(status, failure);
		}
		return insertMap;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> userLogin(@RequestBody UserSignUp userSignUp) {
		Map<String, String> userValidation = new HashMap<String, String>();
		boolean userStatus = bostainaonlineService
				.validateUserForLogin(userSignUp);
		if (userStatus) {
			userValidation.put(status, success);
		} else {
			userValidation.put(status, failure);
		}
		return userValidation;
	}

	@RequestMapping(value = "usermailverification", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> emailVerification(@RequestBody UserSignUp userSignUp) {
		Map<String, String> userStatusMap = new HashMap<String, String>();
		if (userSignUp.getPassword().isEmpty()) {
			boolean emailStatus = bostainaonlineService
					.userEmailVerification(userSignUp);
			if (emailStatus) {
				userStatusMap.put(status, "emailVerified");
				return userStatusMap;
			} else {
				userStatusMap.put(status, failure);
				return userStatusMap;
			}
		} else {
			boolean rowUpdated = bostainaonlineService
					.userPasswordUpdate(userSignUp);
			if (rowUpdated) {
				UserMail.sendMail(userSignUp);
				userStatusMap.put(status, "passwordupdated");
			}
			return userStatusMap;
		}
	}

	@RequestMapping(value = "retrivephone", method = RequestMethod.GET)
	public @ResponseBody
	List<Phone> retrievePhone() {
		List<Phone> phoneList = new ArrayList<Phone>();
		phoneList = bostainaonlineService.retrieveAllPhones();
		return phoneList;
	}

	@RequestMapping(value = "retrievespeaker", method = RequestMethod.GET)
	public @ResponseBody
	List<Speaker> retrieveSpeaker() {
		List<Speaker> speakerList = new ArrayList<Speaker>();
		speakerList = bostainaonlineService.retrieveAllSpeakers();
		return speakerList;
	}

	@RequestMapping(value = "retrievebag", method = RequestMethod.GET)
	public @ResponseBody
	List<Bag> retrieveAllBag() {
		List<Bag> bagList = new ArrayList<Bag>();
		bagList = bostainaonlineService.retrieveAllBag();
		return bagList;
	}

	@RequestMapping(value = "retrievelaptop", method = RequestMethod.GET)
	public @ResponseBody
	List<Laptop> retrieveAllLaptop() {
		List<Laptop> laptopList = new ArrayList<Laptop>();
		laptopList = bostainaonlineService.retrieveAllLaptop();
		return laptopList;

	}

}
