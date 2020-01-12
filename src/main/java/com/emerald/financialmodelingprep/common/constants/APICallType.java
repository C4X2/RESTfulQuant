package com.emerald.financialmodelingprep.common.constants;

/**
 * Since the Financial Modeling Prep Contains multiple different API's we have
 * to delineate between which API call we want to build.
 * 
 * @author C4X2
 *
 */
public enum APICallType
{
	COMPANY_PROFILE,
	INCOME_STATEMENT,
	BALANCE_SHEET_STATEMENT,
	CASH_FLOW_STATEMENT,
	COMPANY_ENTERPRISE_VALUE,
	COMPANY_KEY_METRICS,
	COMPANY_FINANCIAL_GROWTH,
	COMPANY_RATING,
	COMPANY_DISCOUNTED_CASH_FLOW,
	HISTORICAL_DISCOUNTED_CASH_FLOW,
	REAL_TIME_STOCK_PRICE,
	ALL_REAL_TIME_STOCK_PRICE,
	HISTORICAL_STOCK_PRICE,
	TICKER_LIST,
	CRYPTO,
	CRYPTO_SINGLE
}
