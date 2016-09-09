/**
 * 
 */
package com.bostaniaonline.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sahil.Kaushik
 *
 */
@Entity
@Table(name="phone")
public class Phone {
	@Id
	@Column(name="PHONE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int phoneId;
	
	@Column(name="PHONE_NAME")
	private String phoneName;
	
	@Column(name="PHONE_COMPANY")
	private String phoneCompany;
	
	@Column(name="PHONE_PRICE")
	private String phonePrice;

	/**
	 * @return the phoneId
	 */
	public int getPhoneId() {
		return phoneId;
	}

	/**
	 * @param phoneId the phoneId to set
	 */
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	/**
	 * @return the phoneName
	 */
	public String getPhoneName() {
		return phoneName;
	}

	/**
	 * @param phoneName the phoneName to set
	 */
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	/**
	 * @return the phoneCompany
	 */
	public String getPhoneCompany() {
		return phoneCompany;
	}

	/**
	 * @param phoneCompany the phoneCompany to set
	 */
	public void setPhoneCompany(String phoneCompany) {
		this.phoneCompany = phoneCompany;
	}

	/**
	 * @return the phonePrice
	 */
	public String getPhonePrice() {
		return phonePrice;
	}

	/**
	 * @param phonePrice the phonePrice to set
	 */
	public void setPhonePrice(String phonePrice) {
		this.phonePrice = phonePrice;
	}
	
	

}
