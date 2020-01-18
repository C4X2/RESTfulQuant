package com.emerald.financialmodelingprep.api.noargs.ratings.impl;

import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.noargs.ratings.model.CompanyRatingAPI;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;

@Service
public class CompanyRatingAPIImpl implements CompanyRatingAPI
{
	
	@Override
	public String buildAPIURL(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		return BASE_URL + COMPANY_RATING + ticker;
	}

}
