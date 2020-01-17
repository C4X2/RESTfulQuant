package com.emerald.financialmodelingprep.api.args;

import java.util.Map;

import com.emerald.financialmodelingprep.api.FinancialModelingPrepAPI;
import com.emerald.financialmodelingprep.common.constants.DataType;
import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.constants.SeriesType;
import com.emerald.financialmodelingprep.common.params.Company;

/**
 * This class denotes which Financial Prep API's accept RESTful query parameters
 * like period, datatype, etc.
 * 
 * @author C4X2
 * @version 2.0
 *
 */
public interface FinancialModelingPrepAPIURLArguments extends FinancialModelingPrepAPI
{

	/**
	 * Builds the URL for the given company.
	 * 
	 * @param callType A call type enum related to the API you want to call
	 * @param company the company that you want to receive information about.
	 * @param period an enum value related to the period argument
	 * @return the newly built URL.
	 */
	public String buildAPIURL(String company, Period period);

	/**
	 * Builds the URL for the given company.
	 * 
	 * @param callType A call type enum related to the API you want to call
	 * @param company the company that you want to receive information about.
	 * @param dataType
	 * @return the newly built URL.
	 */
	public String buildAPIURL(String company, DataType dataType);

	/**
	 * Builds the URL for the given company.
	 * 
	 * @param callType A call type enum related to the API you want to call
	 * @param company the company that you want to receive information about.
	 * @param seriesType
	 * @return the newly built URL.
	 */
	public String buildAPIURL(String company, SeriesType seriesType);

	/**
	 * 
	 * @param company the company that you want to receive information about.
	 * @param args the query parameters to be adding to the end of this URL call
	 * @return the newly built URL.
	 */
	public String buildAPIUrl(String company, Map<String, String> args);
}
