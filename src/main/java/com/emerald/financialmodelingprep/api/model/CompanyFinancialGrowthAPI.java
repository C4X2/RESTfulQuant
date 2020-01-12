package com.emerald.financialmodelingprep.api.model;

public interface CompanyFinancialGrowthAPI extends FinancialModelingPrepAPI
{
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
}
