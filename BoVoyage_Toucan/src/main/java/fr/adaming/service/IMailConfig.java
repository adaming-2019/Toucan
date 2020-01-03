package fr.adaming.service;

public interface IMailConfig {
	public boolean sendMail(String sendTo, String content, String subject);

}
