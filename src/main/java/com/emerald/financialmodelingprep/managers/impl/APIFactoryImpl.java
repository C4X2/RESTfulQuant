package com.emerald.financialmodelingprep.managers.impl;

import com.emerald.financialmodelingprep.api.impl.CompanyEnterpriseValueAPIImpl;
import com.emerald.financialmodelingprep.api.impl.CompanyFinancialGrowthAPIImpl;
import com.emerald.financialmodelingprep.api.impl.CompanyFinancialStatementAPIImpl;
import com.emerald.financialmodelingprep.api.impl.CompanyKeyMetricsAPIImpl;
import com.emerald.financialmodelingprep.api.impl.CompanyProfileAPIImpl;
import com.emerald.financialmodelingprep.api.impl.CompanyRatingAPIImpl;
import com.emerald.financialmodelingprep.api.impl.CryptoAPIImpl;
import com.emerald.financialmodelingprep.api.impl.DiscountedCashFlowAPIImpl;
import com.emerald.financialmodelingprep.api.impl.StocksAPIImpl;
import com.emerald.financialmodelingprep.api.model.FinancialModelingPrepAPI;
import com.emerald.financialmodelingprep.common.constants.APICallType;
import com.emerald.financialmodelingprep.managers.model.APIFactory;

public class APIFactoryImpl implements APIFactory
{
	@Override
	public FinancialModelingPrepAPI getAPIOfType(APICallType callType)
	{
		if (callType == null)
		{
			return null;
		}
		FinancialModelingPrepAPI api = null;
		switch (callType)
		{
			case TICKER_LIST:
			case HISTORICAL_STOCK_PRICE:
			case REAL_TIME_STOCK_PRICE:
			case ALL_REAL_TIME_STOCK_PRICE:
				api = new StocksAPIImpl();
				break;
			case INCOME_STATEMENT:
			case BALANCE_SHEET_STATEMENT:
			case CASH_FLOW_STATEMENT:
				api = new CompanyFinancialStatementAPIImpl();
				break;
			case HISTORICAL_DISCOUNTED_CASH_FLOW:
			case COMPANY_DISCOUNTED_CASH_FLOW:
				api = new DiscountedCashFlowAPIImpl();
				break;
			case COMPANY_ENTERPRISE_VALUE:
				api = new CompanyEnterpriseValueAPIImpl();
				break;
			case COMPANY_FINANCIAL_GROWTH:
				api = new CompanyFinancialGrowthAPIImpl();
				break;
			case COMPANY_KEY_METRICS:
				api = new CompanyKeyMetricsAPIImpl();
				break;
			case COMPANY_PROFILE:
				api = new CompanyProfileAPIImpl();
				break;
			case COMPANY_RATING:
				api = new CompanyRatingAPIImpl();
				break;
			case CRYPTO:
			case CRYPTO_SINGLE:
				api = new CryptoAPIImpl();
				break;
			default:
				break;
		}
		return api;
	}



}
