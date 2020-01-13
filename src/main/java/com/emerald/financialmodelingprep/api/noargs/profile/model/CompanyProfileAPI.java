package com.emerald.financialmodelingprep.api.noargs.profile.model;

import com.emerald.financialmodelingprep.api.FinancialModelingPrepAPI;

public interface CompanyProfileAPI extends FinancialModelingPrepAPI
{
	/////////////////////////////////////////////////////////////////////
	//
	// Company Profile
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * The URL ending to receive a JSON that get the profile of the supplied
	 * company.
	 * </p>
	 *
	 * <br />
	 * <p>
	 * Includes Price, Beta, Volume Average, Market Capitalization, Last Dividend,
	 * 52 week range, stock price change, stock price change in percentage, Company
	 * Name, Exchange, Description, Industry, Sector, CEO, Website and image.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * Updated hourly.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 *
	 */
	public static final String	COMPANY_PROFILE					= "/v3/company/profile/";
}
