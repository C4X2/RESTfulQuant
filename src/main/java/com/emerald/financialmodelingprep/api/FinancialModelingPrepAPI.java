package com.emerald.financialmodelingprep.api;

public interface FinancialModelingPrepAPI
{
	/**
	 * The base url for making RESTful calls to the Financial Modeling Prep API
	 */
	public static final String	BASE_URL				= "https://financialmodelingprep.com/api";

	/**
	 * RESTful API argument to specify the time period in which the data is
	 * aggregated over.
	 *
	 * As arguments it accepts :
	 * <ul>
	 * <li>quarter</li>
	 * </ul>
	 * <br />
	 * <em>Please note that the company has to be specified before this argument is
	 * applied.</em>
	 */
	public static final String	PERIOD					= "period=";

	/**
	 * RESTful API argument to specify the format of the returned data. As a default
	 * this API returns json. If the supplied argument is csv, the API will return a
	 * downloadable csv file, otherwise it will return the datatype. As arguments it
	 * accepts :
	 * <ul>
	 * <li>csv</li>
	 * <li>json</li>
	 * </ul>
	 * <br />
	 * <em>Please note that the company has to be specified before this argument is
	 * applied.</em>
	 */
	public static final String	DATA_TYPE				= "datatype=";

	/**
	 * RESTful API argument to specify how the format of the returned data should be
	 * interpreted. If the supplied argument is line, the API will return a an array
	 * in which each element is a specific company. accepts :
	 * <ul>
	 * <li>line</li>
	 * </ul>
	 * <br />
	 * <em>Please note that the company has to be specified before this argument is
	 * applied.</em>
	 */
	public static final String	SERIES_TYPE				= "serietype=";

	/**
	 * <p>
	 * The operator used to indicate that there are additional parameters in the
	 * REST API call. Should only be used a maximum of once in the RESTful url.
	 * <em>Please note that the company has to be specified before this operator is
	 * applied.</em>
	 * </p>
	 */
	public static final String	RESTFUL_QUERY_OPERATOR	= "?";

	/**
	 * <p>
	 * The operator used to indicate theat there are multiple parameter
	 * specification in the RESTful url. <em>Please note that the concat character
	 * should be used only if there are multiple query parameters. Note that the
	 * company ticker has to be specified before this operator is applied.</em>
	 * </p>
	 */
	public static final String	RESTFUL_QUERY_CONCAT	= "&";

	/**
	 * Builds the URL for the given company.
	 * 
	 * @param ticker the ticker for the company that you want to receive information
	 *        about.
	 * @return the FinancialModelingPrepAPI object with the newly built URL.
	 */
	public FinancialModelingPrepAPI buildAPIURL(String ticker);

	/**
	 * Returns the URL stored in the FinancialModelingPrepAPI.
	 *
	 * @return the RESTful URL that this API is making calls to.
	 */
	public String getURL();

	/**
	 * Calls the URL and returns the JSON reponse as a string.
	 *
	 * @return a JSON representing the JSON reponse.
	 */
	public String get();

}
