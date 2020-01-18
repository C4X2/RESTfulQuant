package com.emerald.financialmodelingprep.services.discountedcashflow.model;

import java.util.List;

import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.params.DiscountedCashFlow;

public interface DiscountedCashFlowService
{
	/**
	 * <p>
	 * The name of the array received from the json response of the Historical DCF
	 * RESTful API endpoint.
	 * </p>
	 */
	public static final String HISTORICAL_DCF = "historicalDCF";

	/**
	 * This method finds and returns the DiscountedCashFlow Statement of a given
	 * corporation.
	 * 
	 * @param ticker a String literal representing a company trading on a stock
	 *        exchange.
	 * @return the real-time DiscountedCashFlow for the given
	 * @throws TickerDoesNotExistException if the given ticker does not exist
	 */
	public DiscountedCashFlow getDiscountedCashFlow(final String ticker);

	/**
	 * This method finds and returns the historical DiscountedCashFlow Statement of
	 * a given corporation from the last 10 years.
	 * 
	 * @param ticker a String literal representing a company trading on a stock
	 *        exchange.
	 * @return a list of discounted cash flow for the last ten years of a
	 *         corporations existence.
	 * @throws TickerDoesNotExistException if the given ticker does not exist
	 */
	public List<DiscountedCashFlow> getHistoricalDiscountedCashFlow(final String ticker);

	/**
	 * 
	 * This method finds and returns the historical DiscountedCashFlow Statement of
	 * a given corporation from the last 10 years in the given period format.
	 * 
	 * @param ticker a String literal representing a company trading on a stock
	 *        exchange.
	 * @param period a time-period interval that the data is returned in.
	 * @return a list of discounted cash flow statements augmented with the given
	 *         period argument.
	 */
	public List<DiscountedCashFlow> getHistoricalDiscountedCashFlow(final String ticker, Period period);
}
