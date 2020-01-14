package com.emerald.financialmodelingprep.api.noargs.crypto.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.emerald.financialmodelingprep.api.FinancialModelingPrepAPI;
import com.emerald.financialmodelingprep.api.noargs.crypto.model.Crypto;
import com.emerald.financialmodelingprep.common.params.CryptocurrencyCoin;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;
import com.emerald.financialmodelingprep.services.impl.JsonDeserializerImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class CryptoAPIImpl implements Crypto
{
	private static final String CRYPTOCURRENCIES_LIST = "cryptocurrenciesList";
	private String url;

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

	@Override
	public List<CryptocurrencyCoin> retrieveCryptocurrenciesFromJson(String json)
	{
		ValidationUtils.nullCheck(json);
		JsonObject jObj = null;
		JsonArray arr = null;
		JsonElement coins = JsonParser.parseString(json);
		if (coins.isJsonObject())
		{
			jObj = coins.getAsJsonObject();
		}
		if ((jObj != null) && jObj.has(CRYPTOCURRENCIES_LIST))
		{
			arr = jObj.get(CRYPTOCURRENCIES_LIST).getAsJsonArray();
		}
		List<CryptocurrencyCoin> coinList = new ArrayList<CryptocurrencyCoin> ();
		if (arr != null)
		{
			for (JsonElement elem : arr)
			{
				coinList.add(JsonDeserializerImpl.getGson().fromJson(elem, CryptocurrencyCoin.class));
			}

		}
		return coinList;
	}

}
