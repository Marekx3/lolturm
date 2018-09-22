package de.lolturm.message;

public class MessageBean {

	private String message;

	public MessageBean() {
		super();
		this.message = "";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSamePasswordMessage() {
		this.setMessage("Passwörter sind unterschiedlich!");
	}

	public void setSameUseridMessage() {
		this.setMessage("Username gibt es schon!");
	}

	public void setSameEmailMessage() {
		this.setMessage("Email gibt es schon!");
	}
	
	public void setSuccessfullyInsertMessage() {
		this.setMessage("Alles geklappt!");
	}

	public void setGeneralErrorMessage() {
		this.setMessage("Ein unerwarteter Fehler!");
	}

	public void setEmptyMessage() {
		this.setMessage("");
	}

	public void setSuccessfullySafedMessage() {
		this.setMessage("Erfolgreich gespeichert!");		
	}
}
