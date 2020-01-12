package com.emerald.financialmodelingprep.api.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.util.StringUtils;

import com.emerald.financialmodelingprep.api.model.Crypto;
import com.emerald.financialmodelingprep.api.model.FinancialModelingPrepAPI;
import com.emerald.financialmodelingprep.common.constants.DataType;
import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.constants.SeriesType;
import com.emerald.financialmodelingprep.common.params.Company;

public class CryptoAPIImpl implements Crypto
{
	private String url;

	/*@Override
	public FinancialModelingPrepAPI buildAPIURL(Company company)
	{
		if (company == null)
		{
			return buildAPIURL();
		}
		return buildAPIURL(company.getSymbol());
	}*/
    /////////////////////////////////////////////////////////////////////
    //
    // Since the period argument, the data type argument and the seriestype argument 
	// is unsupported for the Crypto API it is the same as calling buildIRL();
    //
    /////////////////////////////////////////////////////////////////////
	@Override
	public FinancialModelingPrepAPI buildAPIURL(String ticker)
	{
		if (!StringUtils.hasText(ticker))
		{
			return buildAPIURL();
		}
		this.url = BASE_URL + CRYPTO_SINGLE + '/' + ticker;
		return this;
	}
	
	@Override
	public FinancialModelingPrepAPI buildAPIURL(Company company, Period period)
	{
		if (company == null)
		{
			return buildAPIURL();
		}
		return buildAPIURL(company.getSymbol());
	}

	@Override
	public FinancialModelingPrepAPI buildAPIURL(Company company, DataType dataType)
	{
		if (company == null)
		{
			return buildAPIURL();
		}
		return buildAPIURL(company.getSymbol());
	}

	@Override
	public FinancialModelingPrepAPI buildAPIURL(Company company, SeriesType seriesType)
	{
		if (company == null)
		{
			return buildAPIURL();
		}
		return buildAPIURL(company.getSymbol());
	}
	
	@Override
	public FinancialModelingPrepAPI buildAPIURL()
	{
		this.url = BASE_URL + CRYPTO;
		return this;
	}


	@Override
	public String getURL()
	{
		return this.url;
	}

	@Override
	public String get()
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

}
