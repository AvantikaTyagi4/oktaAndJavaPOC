package com.okta.poc.dto;

public class OktaEventDTO {

	private String eventType;
	private String eventTypeVersion;
	private String cloudEventsVersion;
	private String source;
	private String eventId;
	private DataDTO data;
	private String eventTime;
	private String contentType;

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventTypeVersion() {
		return eventTypeVersion;
	}

	public void setEventTypeVersion(String eventTypeVersion) {
		this.eventTypeVersion = eventTypeVersion;
	}

	public String getCloudEventsVersion() {
		return cloudEventsVersion;
	}

	public void setCloudEventsVersion(String cloudEventsVersion) {
		this.cloudEventsVersion = cloudEventsVersion;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public DataDTO getData() {
		return data;
	}

	public void setData(DataDTO data) {
		this.data = data;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
