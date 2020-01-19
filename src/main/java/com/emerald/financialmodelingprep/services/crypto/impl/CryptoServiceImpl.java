package com.emerald.financialmodelingprep.services.crypto.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Service @Getter @Setter @Accessors(chain = true)
public class CryptoServiceImpl implements CryptoService
{
	private static final String		CRYPTOCURRENCIES_LIST	= "cryptocurrenciesList";
	@Autowired
	private Crypto					crypto;
	@Autowired
	private URLConnectionService	urlConnectionService;

	@Override
	public CryptocurrencyCoin getCryptocurrencyCoin(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		String url = getCrypto().buildAPIURL(ticker);
		String json = getUrlConnectionService().get(url);
		return JsonDeserializerImpl.getGson().fromJson(json, CryptocurrencyCoin.class);
	}

	@Override
	public List<CryptocurrencyCoin> getAllCryptocurrencyCoins()
	{
		String url = getCrypto().buildAPIURL();
		String json = getUrlConnectionService().get(url);
		List<CryptocurrencyCoin> coinList = getCryptocurrencyCoinsFromJson(json);
		return coinList;
	}

	private List<CryptocurrencyCoin> getCryptocurrencyCoinsFromJson(String json)
	{
		if (StringUtils.isBlank(json))
		{
			return null;
		}
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
}
