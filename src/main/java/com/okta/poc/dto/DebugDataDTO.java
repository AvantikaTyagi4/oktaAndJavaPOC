package com.okta.poc.dto;

public class DebugDataDTO {

	private String requestId;
	private String dtHash;
	private String requestUri;
	private String targetEventHookIds;
	private String url;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getDtHash() {
		return dtHash;
	}

	public void setDtHash(String dtHash) {
		this.dtHash = dtHash;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getTargetEventHookIds() {
		return targetEventHookIds;
	}

	public void setTargetEventHookIds(String targetEventHookIds) {
		this.targetEventHookIds = targetEventHookIds;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
