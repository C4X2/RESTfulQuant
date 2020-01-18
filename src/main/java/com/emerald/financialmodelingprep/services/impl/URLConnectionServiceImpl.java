package com.emerald.financialmodelingprep.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.services.model.URLConnectionService;

import lombok.Synchronized;

@Service
public class URLConnectionServiceImpl implements URLConnectionService
{
	InputStreamReader inputStreamReader; 
	BufferedReader br;
	
	@Override @Synchronized
	public String get(String url)
	{
		try
		{
			URL apiUrl = new URL(url);
			inputStreamReader = new InputStreamReader(apiUrl.openStream(), "UTF-8");
			br = new BufferedReader(inputStreamReader);
			StringBuffer val = new StringBuffer(br.readLine());
			String nxtLine = br.readLine();
			while (nxtLine != null)
			{
				val.append(nxtLine);
				nxtLine = br.readLine();
			}
			return val.toString();
		} catch (Exception e)
		{

		}
		finally {
			if (inputStreamReader != null)
			{
				try
				{
					inputStreamReader.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (br != null)
			{
				try
				{
					br.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
