package com.emerald.financialmodelingprep.api.model;

public interface CompanyKeyMetricsAPI extends FinancialModelingPrepAPIURLArguments
{
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
}
