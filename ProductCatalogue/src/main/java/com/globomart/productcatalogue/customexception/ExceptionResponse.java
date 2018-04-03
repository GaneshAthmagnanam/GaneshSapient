package com.globomart.productcatalogue.customexception;

public class ExceptionResponse {

	private String errorCode;
	private String error_Message;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getError_Message() {
		return error_Message;
	}
	public void setError_Message(String error_Message) {
		this.error_Message = error_Message;
	}
	
}
