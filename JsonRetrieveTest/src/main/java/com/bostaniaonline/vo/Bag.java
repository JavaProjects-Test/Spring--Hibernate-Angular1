package com.bostaniaonline.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bag")
public class Bag {
	@Id
	@Column(name = "BAG_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bagId;

	@Column(name = "BAG_TYPE")
	private String bagType;

	@Column(name = "BAG_COMPANY")
	private String bagCompany;

	@Column(name = "BAG_PRICE")
	private String bagPrice;

	/**
	 * @return the bagId
	 */
	public int getBagId() {
		return bagId;
	}

	/**
	 * @param bagId
	 *            the bagId to set
	 */
	public void setBagId(int bagId) {
		this.bagId = bagId;
	}

	/**
	 * @return the bagType
	 */
	public String getBagType() {
		return bagType;
	}

	/**
	 * @param bagType
	 *            the bagType to set
	 */
	public void setBagType(String bagType) {
		this.bagType = bagType;
	}

	/**
	 * @return the bagCompany
	 */
	public String getBagCompany() {
		return bagCompany;
	}

	/**
	 * @param bagCompany
	 *            the bagCompany to set
	 */
	public void setBagCompany(String bagCompany) {
		this.bagCompany = bagCompany;
	}

	/**
	 * @return the bagPrice
	 */
	public String getBagPrice() {
		return bagPrice;
	}

	/**
	 * @param bagPrice
	 *            the bagPrice to set
	 */
	public void setBagPrice(String bagPrice) {
		this.bagPrice = bagPrice;
	}

}
