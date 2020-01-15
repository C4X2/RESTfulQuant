package com.emerald.financialmodelingprep.services.crypto.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.emerald.financialmodelingprep.api.noargs.crypto.model.Crypto;
import com.emerald.financialmodelingprep.common.params.CryptocurrencyCoin;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;
import com.emerald.financialmodelingprep.services.crypto.model.CryptoService;
import com.emerald.financialmodelingprep.services.impl.JsonDeserializerImpl;
import com.emerald.financialmodelingprep.services.model.URLConnectionService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CryptoServiceImpl implements CryptoService
{
	private static final String		CRYPTOCURRENCIES_LIST	= "cryptocurrenciesList";
	private Crypto					crypto;
	private URLConnectionService	urlConnectionService;

	@Override
	public CryptocurrencyCoin getCryptocurrencyCoin(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		String url = getCrypto().buildAPIURL(ticker).getURL();
		String json = getUrlConnectionService().get(url);
		return JsonDeserializerImpl.getGson().fromJson(json, CryptocurrencyCoin.class);
	}

	@Override
	public List<CryptocurrencyCoin> getAllCryptocurrencyCoins()
	{
		String url = getCrypto().buildAPIURL().getURL();
		String json = getUrlConnectionService().get(url);
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
		List<CryptocurrencyCoin> coinList = new ArrayList<CryptocurrencyCoin>();
		if (arr != null)
		{
			for (JsonElement elem : arr)
			{
				coinList.add(JsonDeserializerImpl.getGson().fromJson(elem, CryptocurrencyCoin.class));
			}

		}
		return coinList;
	}

	/**
	 * @return the crypto
	 */
	public Crypto getCrypto()
	{
		return crypto;
	}

	/**
	 * @param crypto the crypto to set
	 */
	@Autowired
	public void setCrypto(Crypto crypto)
	{
		this.crypto = crypto;
	}

	/**
	 * @return the urlConnectionService
	 */
	public URLConnectionService getUrlConnectionService()
	{
		return urlConnectionService;
	}

	/**
	 * @param urlConnectionService the urlConnectionService to set
	 */
	@Autowired
	public void setUrlConnectionService(URLConnectionService urlConnectionService)
	{
		this.urlConnectionService = urlConnectionService;
	}

}
