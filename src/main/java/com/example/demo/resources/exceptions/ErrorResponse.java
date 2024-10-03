package com.example.demo.resources.exceptions;

public class ErrorResponse {
	   private String message;
	    private String details;

	    public ErrorResponse(String message, String details) {
	        this.setMessage(message);
	        this.setDetails(details);
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
