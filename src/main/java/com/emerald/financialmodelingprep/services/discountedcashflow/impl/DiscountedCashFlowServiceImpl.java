package com.emerald.financialmodelingprep.services.discountedcashflow.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.args.discountedcashflow.model.DiscountedCashFlowAPI;
import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.params.DiscountedCashFlow;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;
import com.emerald.financialmodelingprep.services.discountedcashflow.model.DiscountedCashFlowService;
import com.emerald.financialmodelingprep.services.impl.JsonDeserializerImpl;
import com.emerald.financialmodelingprep.services.model.URLConnectionService;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Service @Getter @Setter @Accessors(chain = true)
public class DiscountedCashFlowServiceImpl implements DiscountedCashFlowService
{
	@Autowired
	private DiscountedCashFlowAPI discountedCashFlowAPI;
	@Autowired
	private URLConnectionService urlConnectionService;

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
		return null;
	}

	@Override
	public List<DiscountedCashFlow> getHistoricalDiscountedCashFlow(String ticker, Period period)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
