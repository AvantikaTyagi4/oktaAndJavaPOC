package com.okta.poc.dto;

public class UserAgentDTO {

	private String rawUserAgent;
	private String os;
	private String browser;

	public String getRawUserAgent() {
		return rawUserAgent;
	}

	public void setRawUserAgent(String rawUserAgent) {
		this.rawUserAgent = rawUserAgent;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

}
