package com.emerald.financialmodelingprep.services.model;

/**
 * <p>
 * A service dedicated to connecting to URLs and servicing the response.
 * </p>
 * 
 * @author C4X2
 * @version 1.0
 */
public interface URLConnectionService
{
	/**
	 * <p>
	 * Calls the URL and returns the JSON response as a string.
	 * </p>
	 * 
	 * @param url a String representing a URL <br />
	 * @return a JSON representing the JSON response.
	 */
	public String get(String url);
}
