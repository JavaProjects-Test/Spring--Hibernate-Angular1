package com.bostaniaonline.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {
	@Id
	@Column(name = "LAPTOP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int laptopId;

	@Column(name = "LAPTOP_NAME")
	private String laptopNmae;

	@Column(name = "MODEL_NUMBER")
	private Long modelNumber;

	@Column(name = "LAPTOP_PRICE")
	private String laptopPrice;

	/**
	 * @return the laptopId
	 */
	public int getLaptopId() {
		return laptopId;
	}

	/**
	 * @param laptopId
	 *            the laptopId to set
	 */
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	/**
	 * @return the laptopNmae
	 */
	public String getLaptopNmae() {
		return laptopNmae;
	}

	/**
	 * @param laptopNmae
	 *            the laptopNmae to set
	 */
	public void setLaptopNmae(String laptopNmae) {
		this.laptopNmae = laptopNmae;
	}

	/**
	 * @return the modelNumber
	 */
	public Long getModelNumber() {
		return modelNumber;
	}

	/**
	 * @param modelNumber
	 *            the modelNumber to set
	 */
	public void setModelNumber(Long modelNumber) {
		this.modelNumber = modelNumber;
	}

	/**
	 * @return the laptopPrice
	 */
	public String getLaptopPrice() {
		return laptopPrice;
	}

	/**
	 * @param laptopPrice
	 *            the laptopPrice to set
	 */
	public void setLaptopPrice(String laptopPrice) {
		this.laptopPrice = laptopPrice;
	}

}
