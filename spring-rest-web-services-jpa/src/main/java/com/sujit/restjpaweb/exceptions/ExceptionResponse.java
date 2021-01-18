package com.sujit.restjpaweb.exceptions;

import java.util.Date;

/**
 * Generic Structure based error responses
 * based on the template as defined by the 
 * organization.
 * This template will have any custom 
 * structure we need, across the application.
 * 
 * Whenever an exception occurs we will return
 * the response in this specific format.
 */
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
