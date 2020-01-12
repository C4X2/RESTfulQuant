package com.emerald.financialmodelingprep.api.model;

import com.emerald.financialmodelingprep.common.constants.APICallType;
import com.emerald.financialmodelingprep.common.constants.DataType;
import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.constants.SeriesType;
import com.emerald.financialmodelingprep.common.params.Company;

public interface FinancialModelingPrepAPI
{
	/**
	 * The base url for making RESTful calls to the Financial Modeling Prep API
	 */
	public static final String	BASE_URL						= "https://financialmodelingprep.com/api";
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
	public static final String	PERIOD							= "?period=";

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
	public static final String	DATA_TYPE						= "?datatype=";

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
	public static final String	SERIES_TYPE						= "?serietype=";

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

	/////////////////////////////////////////////////////////////////////
	//
	// Company Financial Statements
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * The URL ending to receive a company's income statement. The default time
	 * period is annual but the {@link #PERIOD} query argument can be provided to
	 * receive quarterly statements as well. <br />
	 *
	 * <p>
	 * An income statement provides : date, Revenue, Revenue Growth, Cost of
	 * Revenue, Gross Profit, R&D Expenses, SG&A Expense, Operating Expenses,
	 * Operating Income, Interest Expense, Earnings before Tax, Income Tax Expense ,
	 * Net Income - Non-Controlling int, Net Income - Discontinued ops, Net Income,
	 * Preferred Dividends, Net Income Com, EPS, EPS Diluted, Weighted Average Shs
	 * Out, Weighted Average Shs Out (Dil), Dividend per Share, Gross Margin, EBITDA
	 * Margin, EBIT Margin, Profit Margin, Free Cash Flow margin, EBITDA, EBIT,
	 * Consolidated Income, Earnings Before Tax Margin, Net Profit Margin.
	 * </p>
	 * <br />
	 * <p>
	 * Updated depending on the period argument.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 */
	@Batachable
	public static final String	INCOME_STATEMENT				= "/v3/financials/income-statement/";

	/**
	 * The URL ending to receive a company's balance sheet statement. The default
	 * time period is annual but the {@link #PERIOD} query argument can be provided
	 * to receive quarterly statements as well. <br />
	 *
	 * <p>
	 * An income statement provides :date, Cash and cash equivalents, Short-term
	 * investments, Cash and short-term investments, Receivables, Inventories, Total
	 * current assets, Property, Plant & Equipment Net, Goodwill and Intangible
	 * Assets, Long-term investments, Tax assets, Total non-current assets, Total
	 * assets, Payables, Short-term debt, Total current liabilities, Long-term debt,
	 * Total debt, Deferred revenue, Tax Liabilities, Deposit Liabilities, Total
	 * non-current liabilities, Total liabilities, Other comprehensive income,
	 * Retained earnings (deficit), Total shareholders equity, Investments, Net
	 * Debt, Other Assets, Other Liabilities.
	 * </p>
	 * <br />
	 * <p>
	 * Updated depending on the period argument.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 */
	@Batachable
	public static final String	BALANCE_SHEET_STATEMENT			= "/v3/financials/balance-sheet-statement/";

	/**
	 * The URL ending to receive a company's cash flow statement. The default time
	 * period is annual but the {@link #PERIOD} query argument can be provided to
	 * receive quarterly statements as well. <br />
	 *
	 * <p>
	 * A cash flow statement provides : date, Depreciation & Amortization,
	 * Stock-based compensation, Operating Cash Flow, Capital Expenditure,
	 * Acquisitions and disposals, Investment purchases and sales, Investing Cash
	 * flow, Issuance (repayment) of debt, Issuance (buybacks) of shares, Dividend
	 * payments, Financing Cash Flow, Effect of forex changes on cash, Net cash flow
	 * / Change in cash, Free Cash Flow, Net Cash/Marketcap.
	 * </p>
	 * <br />
	 * <p>
	 * Updated depending on the period argument.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 */
	@Batachable
	public static final String	CASH_FLOW_STATEMENT				= "/v3/financials/cash-flow-statement/";

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

	/////////////////////////////////////////////////////////////////////
	//
	// Company Key Metrics
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * The URL ending to receive a company's key metrics. The default time period is
	 * annual but the {@link #PERIOD} query argument can be provided to receive
	 * quarterly statements as well. <br />
	 *
	 * <p>
	 * A company key metrics includes : date, Revenue per Share, Net Income per
	 * Share, Operating Cash Flow per Share, Free Cash Flow per Share, Cash per
	 * Share, Book Value per Share, Tangible Book Value per Share, Shareholders
	 * Equity per Share, Interest Debt per Share, Market Cap, Enterprise Value, PE
	 * ratio, Price to Sales Ratio, POCF ratio, PFCF ratio, PB ratio, PTB ratio, EV
	 * to Sales, Enterprise Value over EBITDA, EV to Operating cash flow, EV to Free
	 * cash flow, Earnings Yield, Free Cash Flow Yield, Debt to Equity, Debt to
	 * Assets, Net Debt to EBITDA, Current ratio, Interest Coverage, Income Quality,
	 * Dividend Yield, Payout Ratio, SG&A to Revenue, R&D to Revenue, Intangibles to
	 * Total Assets, Capex to Operating Cash Flow, Capex to Revenue, Capex to
	 * Depreciation, Stock-based compensation to Revenue, Graham Number, ROIC,
	 * Return on Tangible Assets, Graham Net-Net, Working Capital, Tangible Asset
	 * Value, Net Current Asset Value, Invested Capital, Average Receivables,
	 * Average Payables, Average Inventory, Days Sales Outstanding, Days Payables
	 * Outstanding, Days of Inventory on Hand, Receivables Turnover, Payables
	 * Turnover, Inventory Turnover, ROE, Capex per Share.
	 * </p>
	 * <br />
	 * <p>
	 * Updated depending on the period argument.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 */
	public static final String	COMPANY_KEY_METRICS				= "/v3/company-key-metrics/";

	/////////////////////////////////////////////////////////////////////
	//
	// Company Financial Growth
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * The URL ending to receive a company's financial growth metrics over a given
	 * time period. The default time period is annual but the {@link #PERIOD} query
	 * argument can be provided to receive quarterly statements as well. <br />
	 *
	 * <p>
	 * A company financial growth metrics : date, Gross Profit Growth, EBIT Growth,
	 * Operating Income Growth , Net Income Growth , EPS Growth , EPS Diluted Growth
	 * , Weighted Average Shares Growth , Weighted Average Shares Diluted Growth ,
	 * Dividends per Share Growth , Operating Cash Flow growth , Free Cash Flow
	 * growth , 10Y Revenue Growth (per Share) , 5Y Revenue Growth (per Share) , 3Y
	 * Revenue Growth (per Share) , 10Y Operating CF Growth (per Share) , 5Y
	 * Operating CF Growth (per Share) , 3Y Operating CF Growth (per Share) , 10Y
	 * Net Income Growth (per Share) , 5Y Net Income Growth (per Share) , 3Y Net
	 * Income Growth (per Share) , 10Y Shareholders Equity Growth (per Share) , 5Y
	 * Shareholders Equity Growth (per Share) , 3Y Shareholders Equity Growth (per
	 * Share) , 10Y Dividend per Share Growth (per Share) , 5Y Dividend per Share
	 * Growth (per Share) , 3Y Dividend per Share Growth (per Share) , Receivables
	 * growth , Inventory Growth , Asset Growth , Book Value per Share Growth , Debt
	 * Growth , R&D Expense Growth , SG&A Expenses Growth .
	 * </p>
	 * <br />
	 * <p>
	 * Updated depending on the period argument.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 */
	public static final String	COMPANY_FINANCIAL_GROWTH		= "/v3/financial-statement-growth/";

	/////////////////////////////////////////////////////////////////////
	//
	// Company Rating
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * The URL ending to receive a company's rating over a given time period. The
	 * default time period is annual but the {@link #PERIOD} query argument can be
	 * provided to receive quarterly statements as well. <br />
	 *
	 * <p>
	 * A company's rating includes :rating (score, rating, recommendation),
	 * ratingDetails (P/B (score, recommendation), ROA (score, recommendation), DCF
	 * (score, recommendation), P/E (score, recommendation), ROE (score,
	 * recommendation), D/E (score, recommendation)).
	 *
	 * </p>
	 * <br />
	 * <p>
	 * Updated depending on the period argument.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 */
	public static final String	COMPANY_RATING					= "/v3/company/rating/";

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

	/////////////////////////////////////////////////////////////////////
	//
	// Stocks
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * The URL ending to receive a company's real time stock price. If a list of all
	 * publicly available stocks is desired please use the
	 * {@link #ALL_REAL_TIME_STOCK_PRICE} endpoint.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * A company's real time stock price includes :symbol, price.
	 * </p>
	 *
	 * <br />
	 * <p>
	 * Updated in real-time.
	 * </p>
	 * <em>Please note that the ticker of the desired company has to be specified
	 * after this URL.</em>
	 */
	@Batachable
	public static final String	REAL_TIME_STOCK_PRICE			= "/v3/stock/real-time-price/";

	/**
	 * <p>
	 * The URL ending to receive all real time stock prices. If a particular
	 * publicly available stock is desired please use the
	 * {@link #REAL_TIME_STOCK_PRICE} endpoint.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * A company's real time stock price includes :symbol, price.
	 * </p>
	 *
	 * <br />
	 * <p>
	 * Updated in real-time.
	 * </p>
	 */
	public static final String	ALL_REAL_TIME_STOCK_PRICE		= "/v3/stock/real-time-price";

	/**
	 * <p>
	 * The URL ending to receive stock historical prices with change and volume.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * A company's historical stock price includes : symbol, historical ([date,
	 * open, high, low, close, volume, unadjustedVolume, change, changePercent,
	 * vwap, label, changeOverTime])
	 * </p>
	 * <p>
	 * Updated daily.
	 * </p>
	 * <em>Please note that the ticker of the desired company has to be specified
	 * after this URL.</em>
	 */
	public static final String	HISTORICAL_STOCK_PRICE			= "/v3/historical-price-full/";

	/**
	 * <p>
	 * The URL ending to receive all tickers in the Financial Modeling Prep
	 * database.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * A ticker includes stock price includes :symbolsList (symbol, name, price).
	 * </p>
	 *
	 * <br />
	 * <p>
	 * Updated in real-time.
	 * </p>
	 */
	public static final String	TICKER_LIST						= "/v3/company/stock/list";

	// TODO FINISH HISTORICAL STOCK DATA

	/////////////////////////////////////////////////////////////////////
	//
	// Cryptocurrencies
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * A URL endpoint to receive price information about a wide range of
	 * cryptocurrencies. <br />
	 * <p>
	 * If information for a single cryptocurrency is desired, use the
	 * {@link #CRYPTO_SINGLE} endpoint instead.
	 * </p>
	 *
	 * <p>
	 * The cryptocurrency endpoint provides: ticker, name (full name of the
	 * cryptocurrency), price, changes, marketCapitalization.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * Updated in real-time.
	 * </p>
	 */
	public static final String	CRYPTO							= "/v3/cryptocurrencies";

	/**
	 * A URL endpoint to receive price information about a single cryptocurrency.
	 * <br />
	 * <p>
	 * If information for multiple cryptocurrencies is desired, use the
	 * {@link #CRYPTO} endpoint instead.
	 * </p>
	 *
	 * <p>
	 * The cryptocurrency endpoint provides: ticker, name (full name of the
	 * cryptocurrency), price, changes, marketCapitalization.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * Updated in real-time.
	 * </p>
	 * <em>Please note that the ticker of the desired cryptocurrency has to be
	 * specified after this URL.</em>
	 */
	public static final String	CRYPTO_SINGLE					= "/v3/cryptocurrency";
	// TODO FOREX

	// TODO STOCK MARKET

	/**
	 * Builds the URL for the callType assuming that no company arguent is required.
	 * Used to build CRYPTO, TICKER_LIST and ALL_REAL_TIME_STOCK_PRICE for example.
	 *
	 * @param callType the API in which you want to call.
	 * @return the FinancialModelingPrepAPI object with the newly built URL.
	 */
	public FinancialModelingPrepAPI buildAPIURL(APICallType callType);

    /**
	* Builds the URL for the given company.
	* @param company the company that you want to receive information about.
 	* @return the FinancialModelingPrepAPI object with the newly built URL.
	*/
	public FinancialModelingPrepAPI buildAPIURL(Company company);

	/**
	* Builds the URL for the given company.
	* @param ticker the ticker for the company that you want to receive information about.
	* @return the FinancialModelingPrepAPI object with the newly built URL.
	*/
	public FinancialModelingPrepAPI buildAPIURL(String ticker);

	/**
	 * Builds the URL for the given company.
	 *
	 * @param callType A call type enum related to the API you want to call
	 * @param company the company that you want to receive information about.
	 * @return the FinancialModelingPrepAPI object with the newly built URL.
	 */
	public FinancialModelingPrepAPI buildAPIURL(APICallType callType, Company company);

	/**
	 * Builds the URL for the given company.
	 * @param callType A call type enum related to the API you want to call
	 * @param company the company that you want to receive information about.
	 * @param period an enum value related to the period argument
	 * @return the FinancialModelingPrepAPI object with the newly built URL.
	 */
	public FinancialModelingPrepAPI buildAPIURL(APICallType callType, Company company, Period period);

	/**
	 * Builds the URL for the given company.
	 * @param callType A call type enum related to the API you want to call
	 * @param company the company that you want to receive information about.
	 * @param dataType
	 * @return the FinancialModelingPrepAPI object with the newly built URL.
	 */
	public FinancialModelingPrepAPI buildAPIURL(APICallType callType, Company company, DataType dataType);

	/**
	 * Builds the URL for the given company.
	 * @param callType A call type enum related to the API you want to call
	 * @param company the company that you want to receive information about.
	 * @param seriesType
	 * @return the FinancialModelingPrepAPI object with the newly built URL.
	 */
	public FinancialModelingPrepAPI buildAPIURL(APICallType callType, Company company, SeriesType seriesType);

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
	public String call();

}
