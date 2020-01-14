package com.emerald.financialmodelingprep.managers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.FinancialModelingPrepAPI;
import com.emerald.financialmodelingprep.api.args.discountedcashflow.model.DiscountedCashFlowAPI;
import com.emerald.financialmodelingprep.api.args.enterprisevalue.model.CompanyEnterpriseValueAPI;
import com.emerald.financialmodelingprep.api.args.financialgrowth.model.CompanyFinancialGrowthAPI;
import com.emerald.financialmodelingprep.api.args.financialstatements.model.CompanyFinancialStatementAPI;
import com.emerald.financialmodelingprep.api.args.keymetrics.model.CompanyKeyMetricsAPI;
import com.emerald.financialmodelingprep.api.args.stocks.model.StocksAPI;
import com.emerald.financialmodelingprep.api.noargs.crypto.model.Crypto;
import com.emerald.financialmodelingprep.api.noargs.profile.model.CompanyProfileAPI;
import com.emerald.financialmodelingprep.api.noargs.ratings.model.CompanyRatingAPI;
import com.emerald.financialmodelingprep.common.constants.APICallType;
import com.emerald.financialmodelingprep.managers.model.APIFactory;


/**
 * Returns the API Services offered by the Financial Modeling Prep API. Assumes
 * a Spring Environment.
 * 
 * @author C4X2
 *
 */
@Service
public class APIFactoryImpl implements APIFactory
{
	private ApplicationContext applicationContext;

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
				api = getApplicationContext().getBean(StocksAPI.class);
				break;
			case INCOME_STATEMENT:
			case BALANCE_SHEET_STATEMENT:
			case CASH_FLOW_STATEMENT:
				api = getApplicationContext().getBean(CompanyFinancialStatementAPI.class);
				break;
			case HISTORICAL_DISCOUNTED_CASH_FLOW:
			case COMPANY_DISCOUNTED_CASH_FLOW:
				api = getApplicationContext().getBean(DiscountedCashFlowAPI.class);
				break;
			case COMPANY_ENTERPRISE_VALUE:
				api = getApplicationContext().getBean(CompanyEnterpriseValueAPI.class);
				break;
			case COMPANY_FINANCIAL_GROWTH:
				api = getApplicationContext().getBean(CompanyFinancialGrowthAPI.class);
				break;
			case COMPANY_KEY_METRICS:
				api = getApplicationContext().getBean(CompanyKeyMetricsAPI.class);
				break;
			case COMPANY_PROFILE:
				api = getApplicationContext().getBean(CompanyProfileAPI.class);
				break;
			case COMPANY_RATING:
				api = getApplicationContext().getBean(CompanyRatingAPI.class);
				break;
			case CRYPTO:
			case CRYPTO_SINGLE:
				api = getApplicationContext().getBean(Crypto.class);
				break;
			default:
				break;
		}
		return api;
	}

	/**
	 * @return the applicationContext
	 */
	public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}

	/**
	 * @param applicationContext the applicationContext to set
	 */
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext)
	{
		this.applicationContext = applicationContext;
	}

}
