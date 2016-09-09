package com.bostaniaonline.dao;

import java.util.List;

import com.bostaniaonline.vo.Bag;
import com.bostaniaonline.vo.Laptop;
import com.bostaniaonline.vo.Phone;
import com.bostaniaonline.vo.Speaker;
import com.bostaniaonline.vo.UserSignUp;

public interface IBostaniaonlineDao {

	public int signupUser(UserSignUp userSignUp);

	public List<UserSignUp> validateUserForLogin(UserSignUp userSignUp);

	public List<UserSignUp> userEmailVerification(UserSignUp userSignUp);

	public int userPasswordUpdate(UserSignUp userSignUp);

	public List<Phone> retrieveAllPhones();

	public List<Speaker> retrieveAllSpeakers();

	public List<Bag> retrieveAllBag();

	public List<Laptop> retrieveAllLaptop();

}
