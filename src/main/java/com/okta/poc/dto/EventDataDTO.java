package com.okta.poc.dto;

import java.util.List;

public class EventDataDTO {
	private String uuid;
	private String published;
	private String eventType;
	private String version;
	private String displayMessage;
	private String severity;

	private ClientDTO client;

	private Object device;

	private ActorDTO actor;

	private OutcomeDTO outcome;

	private List<TargetDTO> target;

	private DebugContextDTO debugContext;

	private TransactionDTO transaction;

	private String legacyEventType;

	private AuthenticationContextDTO authenticationContext;

	private SecurityContextDTO securityContext;

	private String insertionTimestamp;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDisplayMessage() {
		return displayMessage;
	}

	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public Object getDevice() {
		return device;
	}

	public void setDevice(Object device) {
		this.device = device;
	}

	public ActorDTO getActor() {
		return actor;
	}

	public void setActor(ActorDTO actor) {
		this.actor = actor;
	}

	public OutcomeDTO getOutcome() {
		return outcome;
	}

	public void setOutcome(OutcomeDTO outcome) {
		this.outcome = outcome;
	}

	public List<TargetDTO> getTarget() {
		return target;
	}

	public void setTarget(List<TargetDTO> target) {
		this.target = target;
	}

	public DebugContextDTO getDebugContext() {
		return debugContext;
	}

	public void setDebugContext(DebugContextDTO debugContext) {
		this.debugContext = debugContext;
	}

	public TransactionDTO getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionDTO transaction) {
		this.transaction = transaction;
	}

	public String getLegacyEventType() {
		return legacyEventType;
	}

	public void setLegacyEventType(String legacyEventType) {
		this.legacyEventType = legacyEventType;
	}

	public AuthenticationContextDTO getAuthenticationContext() {
		return authenticationContext;
	}

	public void setAuthenticationContext(AuthenticationContextDTO authenticationContext) {
		this.authenticationContext = authenticationContext;
	}

	public SecurityContextDTO getSecurityContext() {
		return securityContext;
	}

	public void setSecurityContext(SecurityContextDTO securityContext) {
		this.securityContext = securityContext;
	}

	public String getInsertionTimestamp() {
		return insertionTimestamp;
	}

	public void setInsertionTimestamp(String insertionTimestamp) {
		this.insertionTimestamp = insertionTimestamp;
	}

}
