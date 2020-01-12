package com.emerald.financialmodelingprep.services.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.services.model.URLConnectionService;

@Service
public class URLConnectionServiceImpl implements URLConnectionService
{

	@Override
	public String get(String url)
	{
		try
		{
			URL apiUrl = new URL(url);
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
		} catch (Exception e)
		{

		}
		return null;
	}

}
