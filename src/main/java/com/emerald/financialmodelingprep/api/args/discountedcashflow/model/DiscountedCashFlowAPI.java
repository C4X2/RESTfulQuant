package com.emerald.financialmodelingprep.api.args.discountedcashflow.model;

import java.util.Map;

import com.emerald.financialmodelingprep.api.args.FinancialModelingPrepAPIURLArguments;
import com.emerald.financialmodelingprep.common.constants.DataType;
import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.constants.SeriesType;

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

	/**
	 * Builds the URL for the given company, accessing historical information.
	 * 
	 * @param ticker the ticker for the company that you want to receive information
	 *        about.
	 * @return the newly built URL.
	 */
	public String buildHistoricalAPIURL(String ticker);

	/**
	 * Builds the URL for the given company, accessing historical information.
	 * 
	 * @param callType A call type enum related to the API you want to call
	 * @param company the company that you want to receive information about.
	 * @param period an enum value related to the period argument
	 * @return the newly built URL.
	 */
	public String buildHistoricalAPIURL(String company, Period period);

	/**
	 * Builds the URL for the given company, accessing historical information.
	 * 
	 * @param callType A call type enum related to the API you want to call
	 * @param company the company that you want to receive information about.
	 * @param dataType
	 * @return the newly built URL.
	 */
	public String buildHistoricalAPIURL(String company, DataType dataType);

	/**
	 * Builds the URL for the given company, accessing historical information.
	 * 
	 * @param callType A call type enum related to the API you want to call
	 * @param company the company that you want to receive information about.
	 * @param seriesType
	 * @return the newly built URL.
	 */
	public String buildHistoricalAPIURL(String company, SeriesType seriesType);

	/**
	 * Builds the URL for the given company, accessing historical information.
	 * 
	 * @param company the company that you want to receive information about.
	 * @param args the query parameters to be adding to the end of this URL call
	 * @return the newly built URL.
	 */
	public String buildHistoricalAPIURL(String company, Map<String, String> args);
}
