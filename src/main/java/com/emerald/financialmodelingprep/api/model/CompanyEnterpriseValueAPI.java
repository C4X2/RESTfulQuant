package com.emerald.financialmodelingprep.api.model;

public interface CompanyEnterpriseValueAPI extends FinancialModelingPrepAPI
{
	/////////////////////////////////////////////////////////////////////
	//
	// Company Enterprise Value
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * The URL ending to receive a company's enterprise value. The default time
	 * period is annual but the {@link #PERIOD} query argument can be provided to
	 * receive quarterly statements as well. <br />
	 *
	 * <p>
	 * A company enterprise value includes : date, Stock Price, Number of Shares,
	 * Market Capitalization, - Cash & Cash Equivalents, + Total Debt, Enterprise
	 * Value.
	 * </p>
	 * <br />
	 * <p>
	 * Updated depending on the period argument.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 */
	public static final String	COMPANY_ENTERPRISE_VALUE		= "/v3/enterprise-value/";

}
