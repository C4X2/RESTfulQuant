package com.emerald.financialmodelingprep.api.args.discountedcashflow.model;

public interface DiscountedCashFlowAPI extends FinancialModelingPrepAPIURLArguments
{
	/////////////////////////////////////////////////////////////////////
	//
	// Company Discounted Cash Flow
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * The URL ending to receive a company's discounted cash flow.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * A company's discounted cash flow includes : symbol, date, Stock Price, DCF.
	 *
	 * </p>
	 * <br />
	 * <p>
	 * Updated in real time.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 */
	public static final String	COMPANY_DISCOUNTED_CASH_FLOW	= "/v3/company/discounted-cash-flow/";

	/**
	 * The URL ending to receive a company's discounted cash flow over a given time
	 * period. The default time period is annual but the {@link #PERIOD} query
	 * argument can be provided to receive quarterly statements as well. <br />
	 *
	 * <p>
	 * A company's rating includes :symbol, historicalDCF (date, Stock Price, DCF).
	 *
	 * </p>
	 * <br />
	 * <p>
	 * Updated depending on the period argument.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 */
	public static final String	HISTORICAL_DISCOUNTED_CASH_FLOW	= "/v3/company/historical-discounted-cash-flow/";
}
