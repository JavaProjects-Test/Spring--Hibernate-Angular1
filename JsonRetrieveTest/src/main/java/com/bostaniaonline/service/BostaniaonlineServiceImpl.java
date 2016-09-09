package com.bostaniaonline.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bostaniaonline.dao.IBostaniaonlineDao;
import com.bostaniaonline.vo.Bag;
import com.bostaniaonline.vo.Laptop;
import com.bostaniaonline.vo.Phone;
import com.bostaniaonline.vo.Speaker;
import com.bostaniaonline.vo.UserSignUp;

@Service
public class BostaniaonlineServiceImpl implements IBostainaonlineService {

	private IBostaniaonlineDao bostaniaonlineDao;

	/**
	 * @param bostaniaonlineDao
	 *            the bostaniaonlineDao to set
	 */
	public void setBostaniaonlineDao(IBostaniaonlineDao bostaniaonlineDao) {
		this.bostaniaonlineDao = bostaniaonlineDao;
	}

	public int signupUser(UserSignUp userSignUp) {
		if (userSignUp != null) {
			return bostaniaonlineDao.signupUser(userSignUp);
		}
		return 0;
	}

	public Boolean validateUserForLogin(UserSignUp userSignUp) {
		boolean userStatus = false;
		List<UserSignUp> list = new ArrayList<UserSignUp>();
		if (userSignUp != null) {
			list = bostaniaonlineDao.validateUserForLogin(userSignUp);
			if (list.size() > 0) {
				userStatus = true;
			}
		}
		return userStatus;
	}

	public Boolean userEmailVerification(UserSignUp userSignUp) {
		boolean userDataStatus = false;
		List<UserSignUp> userList = bostaniaonlineDao
				.userEmailVerification(userSignUp);
		if (userSignUp != null) {
			if (userList.size() > 0) {
				userDataStatus = true;
			}
		}
		return userDataStatus;
	}

	public boolean userPasswordUpdate(UserSignUp userSignUp) {
		boolean updateStatus = false;
		int rowUpdated = bostaniaonlineDao.userPasswordUpdate(userSignUp);
		if (rowUpdated > 0) {
			updateStatus = true;
			return updateStatus;
		} else {
			return updateStatus;
		}
	}

	public List<Phone> retrieveAllPhones() {
		List<Phone> listPhone = new ArrayList<Phone>();
		listPhone = bostaniaonlineDao.retrieveAllPhones();
		if (listPhone.size() > 0) {
			return listPhone;
		}
		return listPhone;
	}

	public List<Speaker> retrieveAllSpeakers() {
		List<Speaker> listSpeaker = new ArrayList<Speaker>();
		listSpeaker = bostaniaonlineDao.retrieveAllSpeakers();
		if (listSpeaker.size() > 0) {
			return listSpeaker;
		}
		return listSpeaker;
	}

	public List<Bag> retrieveAllBag() {
		List<Bag> listBag = new ArrayList<Bag>();
		listBag = bostaniaonlineDao.retrieveAllBag();
		if (listBag.size() > 0) {
			return listBag;
		}
		return listBag;
	}

	public List<Laptop> retrieveAllLaptop() {
		List<Laptop> listLaptop = new ArrayList<Laptop>();
		listLaptop = bostaniaonlineDao.retrieveAllLaptop();
		if (listLaptop.size() > 0) {
			return listLaptop;
		}
		return listLaptop;
	}

}
