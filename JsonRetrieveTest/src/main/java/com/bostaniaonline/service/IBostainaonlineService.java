package com.bostaniaonline.service;

import java.util.List;

import com.bostaniaonline.vo.Bag;
import com.bostaniaonline.vo.Laptop;
import com.bostaniaonline.vo.Phone;
import com.bostaniaonline.vo.Speaker;
import com.bostaniaonline.vo.UserSignUp;

public interface IBostainaonlineService {

	public int signupUser(UserSignUp userSignUp);

	public Boolean validateUserForLogin(UserSignUp userSignUp);

	public Boolean userEmailVerification(UserSignUp userSignUp);

	public boolean userPasswordUpdate(UserSignUp userSignUp);

	public List<Phone> retrieveAllPhones();

	public List<Speaker> retrieveAllSpeakers();

	public List<Bag> retrieveAllBag();

	public List<Laptop> retrieveAllLaptop();
}
