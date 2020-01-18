package com.emerald.financialmodelingprep.services.stock.model;

import java.util.List;

import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.params.Stock;

public interface StockService
{
	/**
	 * Returns the Stock of the given company.
	 * 
	 * @param ticker ticker representing a company.
	 * @return the Stock of the ticker company
	 */
	public Stock getStock(final String ticker);
	
	/**
	 * 
	 * @return real-time stock prices for all stocks
	 */
	public List<Stock> getAllStocks();
	
	public List<Stock> getHistoricalStock(final String ticker);
	
	public List<Stock> getHistoricalStock(final String ticker, Period period);
}
