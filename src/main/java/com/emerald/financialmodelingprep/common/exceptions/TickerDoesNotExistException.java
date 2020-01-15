package com.emerald.financialmodelingprep.common.exceptions;

/**
 * Thrown when the application is expecting a valid ticker but an invalid ticker was supplied.
 * 
 * @author C4X2
 *
 */
public class TickerDoesNotExistException extends NullPointerException
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private static final String	DEFAULT_MESSAGE		= "An invalid ticker was supplied. This can mean the ticker was either null or not a known ticker or cyrptocurrecncy.";

	public TickerDoesNotExistException(String ticker)
	{
		super(ticker);
	}

	public TickerDoesNotExistException()
	{
		super(DEFAULT_MESSAGE);
	}

}
