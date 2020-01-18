package com.emerald.financialmodelingprep.api.args.discountedcashflow.impl;

import java.util.HashMap;
import java.util.Map;

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
		ValidationUtils.validateTicker(company);
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buildHistoricalAPIURL(String company, DataType dataType)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buildHistoricalAPIURL(String company, SeriesType seriesType)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buildHistoricalAPIURL(String company, Map<String, String> args)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
