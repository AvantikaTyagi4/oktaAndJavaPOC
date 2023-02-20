package com.okta.poc.dto;

public class VerifyDTO {

	private String verification;

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public VerifyDTO(String verification) {
		super();
		this.verification = verification;
	}
}
