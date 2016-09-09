/**
 * 
 */
package com.bostaniaonline.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bostaniaonline.vo.Bag;
import com.bostaniaonline.vo.Laptop;
import com.bostaniaonline.vo.Phone;
import com.bostaniaonline.vo.Speaker;
import com.bostaniaonline.vo.UserSignUp;

/**
 * @author sahil.kaushik
 * 
 */
public class BostaniaonlineDaoImpl implements IBostaniaonlineDao {

	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session session;
	Transaction transaction;

	public int signupUser(UserSignUp userSignUp) {
		int signupUserId = 0;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		signupUserId = (Integer) session.save(userSignUp);
		if (signupUserId != 0) {
			transaction.commit();
		}
		session.close();
		return signupUserId;
	}

	public List<UserSignUp> validateUserForLogin(UserSignUp userSignUp) {
		List<UserSignUp> list = new ArrayList<UserSignUp>();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		String query = "from UserSignUp where emailId=:emailId"
				+ " and password=:password";
		list = session.createQuery(query)
				.setParameter("emailId", userSignUp.getEmailId())
				.setParameter("password", userSignUp.getPassword()).list();
		transaction.commit();
		session.close();
		return list;
	}

	public List<UserSignUp> userEmailVerification(UserSignUp userSignUp) {
		List<UserSignUp> userList = new ArrayList<UserSignUp>();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		String query = "from UserSignUp where emailId=:emailId"
				+ " and firstName=:firstName" + " and lastName=:lastName";
		userList = session.createQuery(query)
				.setParameter("emailId", userSignUp.getEmailId())
				.setParameter("firstName", userSignUp.getFirstName())
				.setParameter("lastName", userSignUp.getLastName()).list();
		transaction.commit();
		session.close();
		return userList;
	}

	public int userPasswordUpdate(UserSignUp userSignUp) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		String hqlQuery = "UPDATE UserSignUp set password=:password where emailId=:emailId";
		Query query = session.createQuery(hqlQuery);
		query.setParameter("password", userSignUp.getPassword());
		query.setParameter("emailId", userSignUp.getEmailId());
		int result = query.executeUpdate();
		transaction.commit();
		session.close();
		return result;
	}

	public List<Phone> retrieveAllPhones() {
		List<Phone> phoneList = new ArrayList<Phone>();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		phoneList = session.createQuery("from Phone").list();
		transaction.commit();
		session.close();
		return phoneList;
	}

	public List<Speaker> retrieveAllSpeakers() {
		List<Speaker> speakerList = new ArrayList<Speaker>();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		speakerList = session.createQuery("from Speaker").list();
		transaction.commit();
		session.close();
		return speakerList;
	}

	public List<Bag> retrieveAllBag() {
		List<Bag> bagList = new ArrayList<Bag>();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		bagList = session.createQuery("from Bag").list();
		transaction.commit();
		session.close();
		return bagList;
	}

	public List<Laptop> retrieveAllLaptop() {
		List<Laptop> laptopList = new ArrayList<Laptop>();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		laptopList = session.createQuery("from Laptop").list();
		transaction.commit();
		session.close();
		return laptopList;
	}

}
