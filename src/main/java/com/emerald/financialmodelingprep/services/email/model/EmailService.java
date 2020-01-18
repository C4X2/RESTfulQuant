package com.emerald.financialmodelingprep.services.email.model;

import java.io.File;
import java.util.List;

import com.emerald.financialmodelingprep.common.exceptions.InvalidEmailAddressException;

public interface EmailService
{
	/**
	 * Sends an email containing the following message content using the properties
	 * held in the java-email.properties file.
	 * 
	 * @param messageContent the message content to be sent
	 * @throws InvalidEmailAddressException if the email in the
	 *         java-email.properties file is not a valid email address.
	 */
	public void send(String messageContent) throws InvalidEmailAddressException;

	/**
	 * 
	 * @param fromEmail email that the email comes from
	 * @param toAddress address to send the email to
	 * @param smtpHost server that will handle the transmission of the email
	 * @param messageContent the message content to be sent
	 * @param attachment attachment to be sent along with the email
	 * @param securityEnabled if true, fail sending an email if a secure connection
	 *        to the smtphost cannot be established.
	 * @throws InvalidEmailAddressException if the email given is not a valid email
	 *         address.
	 */
	public void send(String fromEmail, List<String> toAddress, String smtpHost, String messageContent, File attachment,
			boolean securityEnabled) throws InvalidEmailAddressException;
}
