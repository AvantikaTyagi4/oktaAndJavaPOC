package com.okta.poc.dto;

import java.util.List;

public class ClientDTO {

	private UserAgentDTO userAgent;
	private String zone;
	private String device;
	private int id;
	private String ipAddress;

	private GeographicalContextDTO geographicalContext;
	private List<IPChainDTO> ipChain;

	public UserAgentDTO getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(UserAgentDTO userAgent) {
		this.userAgent = userAgent;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public GeographicalContextDTO getGeographicalContext() {
		return geographicalContext;
	}

	public void setGeographicalContext(GeographicalContextDTO geographicalContext) {
		this.geographicalContext = geographicalContext;
	}

	public List<IPChainDTO> getIpChain() {
		return ipChain;
	}

	public void setIpChain(List<IPChainDTO> ipChain) {
		this.ipChain = ipChain;
	}

}
