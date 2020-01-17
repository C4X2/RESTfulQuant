package com.emerald.financialmodelingprep.api.noargs.profile.impl;

import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.noargs.profile.model.CompanyProfileAPI;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;

@Service
public class CompanyProfileAPIImpl implements CompanyProfileAPI
{
	@Override
	public String buildAPIURL(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		return BASE_URL + COMPANY_PROFILE + ticker;
	}

}
