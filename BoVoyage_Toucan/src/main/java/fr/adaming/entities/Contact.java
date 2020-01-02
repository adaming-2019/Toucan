package fr.adaming.entities;

public class Contact {

	// Declaration des attributs
	private String name;
	private String email;
	private String subject;
	private String text;

	// dexcalartion des constructeurs
	public Contact() {
		super();
	}

	public Contact(String name, String email, String subject, String text) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.text = text;
	}

	// declaration dse getters et setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	// Méthode toString
	@Override
	public String toString() {
		return "Contact [name=" + name + ", email=" + email + ", subject=" + subject + ", text=" + text + "]";
	}

}
