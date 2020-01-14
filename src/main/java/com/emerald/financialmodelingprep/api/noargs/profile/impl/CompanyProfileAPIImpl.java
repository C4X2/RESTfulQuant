package com.emerald.financialmodelingprep.api.noargs.profile.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.emerald.financialmodelingprep.api.FinancialModelingPrepAPI;
import com.emerald.financialmodelingprep.api.noargs.profile.model.CompanyProfileAPI;

@Service
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
