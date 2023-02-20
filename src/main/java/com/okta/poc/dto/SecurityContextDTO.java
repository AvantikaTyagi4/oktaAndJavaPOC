package com.okta.poc.dto;

public class SecurityContextDTO {

	private int asNumber;
	private String asOrg;
	private String isp;
	private String domain;
	private Boolean isProxy;

	public int getAsNumber() {
		return asNumber;
	}

	public void setAsNumber(int asNumber) {
		this.asNumber = asNumber;
	}

	public String getAsOrg() {
		return asOrg;
	}

	public void setAsOrg(String asOrg) {
		this.asOrg = asOrg;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Boolean getIsProxy() {
		return isProxy;
	}

	public void setIsProxy(Boolean isProxy) {
		this.isProxy = isProxy;
	}

}
