package com.emerald.financialmodelingprep.api.args.stocks.model;

import com.emerald.financialmodelingprep.api.Batachable;
import com.emerald.financialmodelingprep.api.args.FinancialModelingPrepAPIURLArguments;

public interface StocksAPI extends FinancialModelingPrepAPIURLArguments
{
	/////////////////////////////////////////////////////////////////////
	//
	// Stocks
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * The URL ending to receive a company's real time stock price. If a list of all
	 * publicly available stocks is desired please use the
	 * {@link #ALL_REAL_TIME_STOCK_PRICE} endpoint.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * A company's real time stock price includes :symbol, price.
	 * </p>
	 *
	 * <br />
	 * <p>
	 * Updated in real-time.
	 * </p>
	 * <em>Please note that the ticker of the desired company has to be specified
	 * after this URL.</em>
	 */
	@Batachable
	public static final String	REAL_TIME_STOCK_PRICE			= "/v3/stock/real-time-price/";

	/**
	 * <p>
	 * The URL ending to receive all real time stock prices. If a particular
	 * publicly available stock is desired please use the
	 * {@link #REAL_TIME_STOCK_PRICE} endpoint.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * A company's real time stock price includes :symbol, price.
	 * </p>
	 *
	 * <br />
	 * <p>
	 * Updated in real-time.
	 * </p>
	 */
	public static final String	ALL_REAL_TIME_STOCK_PRICE		= "/v3/stock/real-time-price";

	/**
	 * <p>
	 * The URL ending to receive stock historical prices with change and volume.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * A company's historical stock price includes : symbol, historical ([date,
	 * open, high, low, close, volume, unadjustedVolume, change, changePercent,
	 * vwap, label, changeOverTime])
	 * </p>
	 * <p>
	 * Updated daily.
	 * </p>
	 * <em>Please note that the ticker of the desired company has to be specified
	 * after this URL.</em>
	 */
	public static final String	HISTORICAL_STOCK_PRICE			= "/v3/historical-price-full/";

	/**
	 * <p>
	 * The URL ending to receive all tickers in the Financial Modeling Prep
	 * database.
	 * </p>
	 * <br />
	 *
	 * <p>
	 * A ticker includes stock price includes :symbolsList (symbol, name, price).
	 * </p>
	 *
	 * <br />
	 * <p>
	 * Updated in real-time.
	 * </p>
	 */
	public static final String	TICKER_LIST						= "/v3/company/stock/list";

	// TODO FINISH HISTORICAL STOCK DATA

}
