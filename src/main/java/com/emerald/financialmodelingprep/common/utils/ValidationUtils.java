package com.emerald.financialmodelingprep.common.utils;

import java.util.Objects;

import org.junit.platform.commons.util.StringUtils;

import com.emerald.financialmodelingprep.common.exceptions.InvalidEmailAddressException;

/**
 * Util class dedicated to validating inputs.
 * 
 * @author C4X2
 * @version 1.2
 */
public class ValidationUtils
{
	/////////////////////////////////////////////////////////////////////
	//
	// FIELDS
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * According to emailregex.com, this standard is the closest to the email
	 * standard outlined in RFC5322. For the exact specification
	 * 
	 * @see https://www.ietf.org/rfc/rfc5322.txt
	 */
	public static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	/////////////////////////////////////////////////////////////////////
	//
	// Constructor, hidden to prevent instantiation.
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * <code>ValidationUtils</code> should not normally be instantiated.
	 */
	private ValidationUtils()
	{
	}

	/////////////////////////////////////////////////////////////////////
	//
	// Util Methods
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * Checks the input to see if any of the supplied arguments are null, if they
	 * are a NullPointerException is thrown.
	 * 
	 * @param objects an array of objects
	 */
	public static void nullCheck(Object... objects)
	{
		for (Object obj : objects)
		{
			Objects.requireNonNull(obj, "The supplied method parameter cannot be null!");
		}
	}

	public static void validateTicker(String ticker)
	{
		// TODO
		// throw new TickerDoesNotExistException("The supplied value of " + String.valueOf(ticker) + " is not a valid ticker");
	}

	/**
	 * Validates the given email address. If the email is valid the method does
	 * nothing, if the email address is invalid, throws an error.
	 * 
	 * @see https://www.ietf.org/rfc/rfc5322.txt
	 * @param email the email address to be validated
	 * @throws InvalidEmailAddressException is thrown if the supplied email is null,
	 *         empty or an invalid email address as defined by the RFC5322
	 *         specification.
	 */
	public static void validateEmail(String email) throws InvalidEmailAddressException
	{
		if (StringUtils.isBlank(email) || !email.matches(EMAIL_REGEX))
		{
			throw new InvalidEmailAddressException(
					"The provided email of :" + String.valueOf(email) + "is not a valid email address.");
		}
	}

}
