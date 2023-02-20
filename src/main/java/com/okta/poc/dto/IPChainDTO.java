package com.okta.poc.dto;

public class IPChainDTO {
	private String ip;
	private GeographicalContextDTO geographicalContext;
	private String version;
	private String source;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public GeographicalContextDTO getGeographicalContext() {
		return geographicalContext;
	}

	public void setGeographicalContext(GeographicalContextDTO geographicalContext) {
		this.geographicalContext = geographicalContext;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
