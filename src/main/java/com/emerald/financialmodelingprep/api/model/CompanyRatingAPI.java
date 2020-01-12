package com.emerald.financialmodelingprep.api.model;

public interface CompanyRatingAPI extends FinancialModelingPrepAPI
{
	/////////////////////////////////////////////////////////////////////
	//
	// Company Rating
	//
	/////////////////////////////////////////////////////////////////////

	/**
	 * <p>
	 * The URL ending to receive a company's current rating.</p> 
	 * 
	 * <br />
	 *
	 * <p>
	 * A company's rating includes :rating (score, rating, recommendation),
	 * ratingDetails (P/B (score, recommendation), ROA (score, recommendation), DCF
	 * (score, recommendation), P/E (score, recommendation), ROE (score,
	 * recommendation), D/E (score, recommendation)).
	 *
	 * </p>
	 * <br />
	 * <p>
	 * Updated daily.
	 * </p>
	 * <em>Please note that the company has to be specified for this URL.</em>
	 */
	public static final String	COMPANY_RATING					= "/v3/company/rating/";
}
