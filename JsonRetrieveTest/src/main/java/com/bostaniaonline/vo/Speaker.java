package com.bostaniaonline.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "speaker")
public class Speaker {
	@Id
	@Column(name = "SPEAKER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int speakerId;

	@Column(name = "SPEAKER_TYPE")
	private String speakerType;

	@Column(name = "SPEAKER_COMPANY")
	private String speakerCompany;

	@Column(name = "SPEAKER_PRICE")
	private String speakerPrice;

	/**
	 * @return the speakerId
	 */
	public int getSpeakerId() {
		return speakerId;
	}

	/**
	 * @param speakerId the speakerId to set
	 */
	public void setSpeakerId(int speakerId) {
		this.speakerId = speakerId;
	}

	/**
	 * @return the speakerType
	 */
	public String getSpeakerType() {
		return speakerType;
	}

	/**
	 * @param speakerType the speakerType to set
	 */
	public void setSpeakerType(String speakerType) {
		this.speakerType = speakerType;
	}

	/**
	 * @return the speakerCompany
	 */
	public String getSpeakerCompany() {
		return speakerCompany;
	}

	/**
	 * @param speakerCompany the speakerCompany to set
	 */
	public void setSpeakerCompany(String speakerCompany) {
		this.speakerCompany = speakerCompany;
	}

	/**
	 * @return the speakerPrice
	 */
	public String getSpeakerPrice() {
		return speakerPrice;
	}

	/**
	 * @param speakerPrice the speakerPrice to set
	 */
	public void setSpeakerPrice(String speakerPrice) {
		this.speakerPrice = speakerPrice;
	}
	
	
}
