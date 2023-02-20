package com.okta.poc.dto;

public class AuthenticationContextDTO {
	private String authenticationProvider;
	private String credentialProvider;
	private String credentialType;
	private String issuer;
	private int authenticationStep;
	private String externalSessionId;
	private String contextInterface;

	public String getAuthenticationProvider() {
		return authenticationProvider;
	}

	public void setAuthenticationProvider(String authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}

	public String getCredentialProvider() {
		return credentialProvider;
	}

	public void setCredentialProvider(String credentialProvider) {
		this.credentialProvider = credentialProvider;
	}

	public String getCredentialType() {
		return credentialType;
	}

	public void setCredentialType(String credentialType) {
		this.credentialType = credentialType;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public int getAuthenticationStep() {
		return authenticationStep;
	}

	public void setAuthenticationStep(int authenticationStep) {
		this.authenticationStep = authenticationStep;
	}

	public String getExternalSessionId() {
		return externalSessionId;
	}

	public void setExternalSessionId(String externalSessionId) {
		this.externalSessionId = externalSessionId;
	}

	public String getContextInterface() {
		return contextInterface;
	}

	public void setContextInterface(String contextInterface) {
		this.contextInterface = contextInterface;
	}

}
