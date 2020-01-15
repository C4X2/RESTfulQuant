package com.emerald.financialmodelingprep.services.crypto.model;

import java.util.List;

import com.emerald.financialmodelingprep.common.params.CryptocurrencyCoin;

public interface CryptoService
{
	public CryptocurrencyCoin getCryptocurrencyCoin(String ticker);

	/**
	 * Returns the current prices of all crypto currencies.
	 * 
	 * @return
	 */
	public List<CryptocurrencyCoin> getAllCryptocurrencyCoins();
}
