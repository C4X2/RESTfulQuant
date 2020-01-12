package com.emerald.financialmodelingprep.api.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

import org.springframework.util.StringUtils;

import com.emerald.financialmodelingprep.api.model.FinancialModelingPrepAPI;
import com.emerald.financialmodelingprep.common.constants.APICallType;
import com.emerald.financialmodelingprep.common.constants.DataType;
import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.constants.SeriesType;
import com.emerald.financialmodelingprep.common.params.Company;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;

public class FinancialModelingPrepAPIImpl implements FinancialModelingPrepAPI
{
	private String url;

	@Override
	public FinancialModelingPrepAPI buildAPIURL(APICallType callType)
	{
		return buildAPIURL(callType, null);
	}

	@Override
	public FinancialModelingPrepAPI buildAPIURL(APICallType callType, Company company)
	{
		ValidationUtils.nullCheck(callType);
		if (company == null && isCompanyARequiredParameter(callType))
		{
			return this;
		}
		this.url = BASE_URL + getURLForCallType(callType);
		decorateURLWithCompanyTicker(company);
		return this;
	}

	private void decorateURLWithCompanyTicker(Company company)
	{
		if (company == null || !StringUtils.hasText(company.getSymbol()))
		{
			return;
		}
		this.url += '/' + company.getSymbol();
	}

	private String getURLForCallType(APICallType callType)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private boolean isCompanyARequiredParameter(APICallType callType)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getURL()
	{
		return this.url;
	}

	@Override
	public String call()
	{
		try
		{
			URL apiUrl = new URL(getURL());
			InputStreamReader inputStreamReader = new InputStreamReader(apiUrl.openStream(), "UTF-8");
			BufferedReader br = new BufferedReader(inputStreamReader);
			String val = br.readLine();
			String nxtLine = br.readLine();
			while (nxtLine != null)
			{
				val += nxtLine;
				nxtLine = br.readLine();
			}
			return val;
		}
		catch (Exception e)
		{
			
		}
		return null;
	}

	@Override
	public FinancialModelingPrepAPI buildAPIURL(APICallType callType, Company company, Period period)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinancialModelingPrepAPI buildAPIURL(APICallType callType, Company company, DataType dataType)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinancialModelingPrepAPI buildAPIURL(APICallType callType, Company company, SeriesType seriesType)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
