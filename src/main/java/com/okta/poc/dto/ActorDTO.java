package com.okta.poc.dto;

public class ActorDTO {

	private String id;
	private String type;
	private String alternateId;
	private String displayName;
	private String detailEntry;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlternateId() {
		return alternateId;
	}

	public void setAlternateId(String alternateId) {
		this.alternateId = alternateId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDetailEntry() {
		return detailEntry;
	}

	public void setDetailEntry(String detailEntry) {
		this.detailEntry = detailEntry;
	}

}
