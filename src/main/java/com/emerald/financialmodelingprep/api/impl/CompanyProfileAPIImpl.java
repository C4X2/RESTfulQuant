package com.emerald.financialmodelingprep.api.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.util.StringUtils;

import com.emerald.financialmodelingprep.api.model.CompanyProfileAPI;
import com.emerald.financialmodelingprep.api.model.FinancialModelingPrepAPI;
import com.emerald.financialmodelingprep.common.constants.DataType;
import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.constants.SeriesType;
import com.emerald.financialmodelingprep.common.params.Company;

public class CompanyProfileAPIImpl implements CompanyProfileAPI
{
	private String url;
	
	@Override
	public FinancialModelingPrepAPI buildAPIURL(String ticker)
	{
		if (StringUtils.hasText(ticker))
		{
			this.url = BASE_URL + COMPANY_PROFILE + ticker;
		}
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
