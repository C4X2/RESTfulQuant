package com.emerald.financialmodelingprep.services.email.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.common.exceptions.InvalidEmailAddressException;
import com.emerald.financialmodelingprep.services.email.model.EmailService;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Service @Getter @Setter @Accessors(chain = true)
public class EmailServiceImpl implements EmailService
{

	@Override
	public void send(String messageContent) throws InvalidEmailAddressException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send(String fromEmail, List<String> toAddress, String smtpHost, String messageContent, File attachment,
			boolean securityEnabled) throws InvalidEmailAddressException
	{
		// TODO Auto-generated method stub
		
	}
	
}
