package com.emerald.financialmodelingprep.services.discountedcashflow.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.args.discountedcashflow.model.DiscountedCashFlowAPI;
import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.params.DiscountedCashFlow;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;
import com.emerald.financialmodelingprep.services.discountedcashflow.model.DiscountedCashFlowService;
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
public class DiscountedCashFlowServiceImpl implements DiscountedCashFlowService
{
	@Autowired
	private DiscountedCashFlowAPI	discountedCashFlowAPI;
	@Autowired
	private URLConnectionService	urlConnectionService;
	private static final String		SYMBOL	= "symbol";

	@Override
	public DiscountedCashFlow getDiscountedCashFlow(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		String url = this.getDiscountedCashFlowAPI().buildAPIURL(ticker);
		String json = this.getUrlConnectionService().get(url);
		return JsonDeserializerImpl.getGson().fromJson(json, DiscountedCashFlow.class);
	}

	@Override
	public List<DiscountedCashFlow> getHistoricalDiscountedCashFlow(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		String url = this.getDiscountedCashFlowAPI().buildHistoricalAPIURL(ticker);
		String json = this.getUrlConnectionService().get(url);
		List<DiscountedCashFlow> historicalDiscountedCashFlow = getHistoricalCashFlowFromJson(json);
		return historicalDiscountedCashFlow;
	}

	@Override
	public List<DiscountedCashFlow> getHistoricalDiscountedCashFlow(String ticker, Period period)
	{
		ValidationUtils.validateTicker(ticker);
		String url = this.getDiscountedCashFlowAPI().buildHistoricalAPIURL(ticker);
		String json = this.getUrlConnectionService().get(url);
		List<DiscountedCashFlow> historicalDiscountedCashFlow = getHistoricalCashFlowFromJson(json);
		return historicalDiscountedCashFlow;
	}

	/**
	 * This is need to properly deserialize the response from the Financial Prep API
	 * b/c they format all the historical discounted chas flow information in a JSON array.
	 * 
	 * @param json json to be deserialized
	 * @return a DiscountedCashFlow object from the json
	 */
	private List<DiscountedCashFlow> getHistoricalCashFlowFromJson(String json)
	{
		if (StringUtils.isBlank(json))
		{
			return null;
		}
		JsonObject jObj = null;
		JsonArray arr = null;
		String symbol = null;
		JsonElement historicalCashFlow = JsonParser.parseString(json);
		if (historicalCashFlow.isJsonObject())
		{
			jObj = historicalCashFlow.getAsJsonObject();
		}
		if ((jObj != null) && (jObj.has(SYMBOL)))
		{
			symbol = jObj.get(SYMBOL).getAsString();
		}
		if ((jObj != null) && jObj.has(HISTORICAL_DCF))
		{
			arr = jObj.get(HISTORICAL_DCF).getAsJsonArray();
		}
		List<DiscountedCashFlow> historicalDiscountedCashFlow = new ArrayList<DiscountedCashFlow> ();
		if (arr != null)	
		{
			for (JsonElement elem : arr)
			{
				DiscountedCashFlow dcf = JsonDeserializerImpl.getGson().fromJson(elem, DiscountedCashFlow.class);
				dcf.setSymbol(symbol);
				historicalDiscountedCashFlow.add(dcf);				
			}
		}
		return historicalDiscountedCashFlow;
	}
}
