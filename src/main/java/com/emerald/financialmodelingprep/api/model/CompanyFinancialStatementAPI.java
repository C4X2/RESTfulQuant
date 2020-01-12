package com.emerald.financialmodelingprep.api.model;

public interface CompanyFinancialStatementAPI extends FinancialModelingPrepAPIURLArguments
{
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
}
