package com.emerald.financialmodelingprep.api.noargs.crypto.impl;

import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.noargs.crypto.model.Crypto;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;

@Service
public class CryptoAPIImpl implements Crypto
{
	@Override
	public String buildAPIURL(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		return BASE_URL + CRYPTO_SINGLE + '/' + ticker;
	}
	
	@Override
	public String buildAPIURL()
	{
		return BASE_URL + CRYPTO;
	}

}
