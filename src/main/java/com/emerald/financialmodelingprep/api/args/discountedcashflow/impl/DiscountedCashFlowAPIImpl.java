package com.emerald.financialmodelingprep.api.args.discountedcashflow.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.args.discountedcashflow.model.DiscountedCashFlowAPI;
import com.emerald.financialmodelingprep.common.constants.DataType;
import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.constants.SeriesType;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;

@Service
public class DiscountedCashFlowAPIImpl implements DiscountedCashFlowAPI
{

	@Override
	public String buildAPIURL(String company, Period period)
	{
		ValidationUtils.validateTicker(company);
		Map<String, String> args = new HashMap<String, String> ();
		args.put(PERIOD, period.toString());
		return buildAPIUrl(company, args);
	}

	@Override
	public String buildAPIURL(String company, DataType dataType)
	{
		ValidationUtils.validateTicker(company);
		Map<String, String> args = new HashMap<String, String> ();
		args.put(DATA_TYPE, dataType.toString());
		return buildAPIUrl(company, args);
	}

	@Override
	public String buildAPIURL(String company, SeriesType seriesType)
	{
		ValidationUtils.validateTicker(company);
		Map<String, String> args = new HashMap<String, String> ();
		args.put(SERIES_TYPE, seriesType.toString());
		return buildAPIUrl(company, args);
	}

	@Override
	public String buildAPIUrl(String company, Map<String, String> args)
	{
		return createURLWithArgs(true, company, args);
	}

	@Override
	public String buildAPIURL(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		return BASE_URL + COMPANY_DISCOUNTED_CASH_FLOW + ticker;
	}

	@Override
	public String buildHistoricalAPIURL(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		return BASE_URL + HISTORICAL_DISCOUNTED_CASH_FLOW + ticker;
	}

	@Override
	public String buildHistoricalAPIURL(String company, Period period)
	{
		ValidationUtils.validateTicker(company);
		HashMap<String, String> args = new HashMap<String, String> ();
		args.put(PERIOD, period.toString());
		return buildHistoricalAPIURL(company, args);
	}

	@Override
	public String buildHistoricalAPIURL(String company, DataType dataType)
	{
		ValidationUtils.validateTicker(company);
		HashMap<String, String> args = new HashMap<String, String> ();
		args.put(DATA_TYPE, dataType.toString());
		return buildHistoricalAPIURL(company, args);
	}

	@Override
	public String buildHistoricalAPIURL(String company, SeriesType seriesType)
	{
		ValidationUtils.validateTicker(company);
		HashMap<String, String> args = new HashMap<String, String> ();
		args.put(SERIES_TYPE, seriesType.toString());
		return buildHistoricalAPIURL(company, args);
	}

	@Override
	public String buildHistoricalAPIURL(String company, Map<String, String> args)
	{
		return createURLWithArgs(true, company, args);
	}

	private String createURLWithArgs(boolean historical, String company, Map<String, String> args)
	{
		ValidationUtils.validateTicker(company);
		// if no argument were supplied just return the real-time url unmodified
		if (CollectionUtils.sizeIsEmpty(args))
		{
			return buildAPIURL(company);
		}
		Boolean prevArg = null;
		StringBuffer url = historical ? new StringBuffer(buildHistoricalAPIURL(company)) : new StringBuffer(buildAPIURL(company));
		if (args.containsKey(PERIOD))
		{
			prevArg = true;
			url.append(RESTFUL_QUERY_OPERATOR);
			url.append(args.get(PERIOD));
		}
		if (args.containsKey(DATA_TYPE) && prevArg)
		{
			url.append(RESTFUL_QUERY_CONCAT);
			url.append(args.get(DATA_TYPE));
		}
		else if (args.containsKey(DATA_TYPE))
		{
			prevArg = true;
			url.append(RESTFUL_QUERY_OPERATOR);
			url.append(args.get(DATA_TYPE));
		}
		
		if (args.containsKey(SERIES_TYPE) && prevArg)
		{
			url.append(RESTFUL_QUERY_CONCAT);
			url.append(args.get(SERIES_TYPE));
		}
		else if (args.containsKey(SERIES_TYPE))
		{
			url.append(RESTFUL_QUERY_OPERATOR);
			url.append(args.get(SERIES_TYPE));
		}
		return url.toString();
	}

}
