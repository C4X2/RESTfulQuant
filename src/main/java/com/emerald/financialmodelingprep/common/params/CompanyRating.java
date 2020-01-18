package com.emerald.financialmodelingprep.common.params;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 
 * @author C4X2
 * @version 1.2
 * 
 */
@Getter @Setter @Accessors(chain = true)
public class CompanyRating
{
	private String	symbol;
	private Long	score;
	private String	rating;
	private String	recommendation;

	// P/B Score
	private Long	pbScore;
	private String	pbRecommendation;

	// ROA Score
	private Long	roaScore;
	private String	roaRecommendation;

	// DCF
	private Long	dcfScore;
	private String	dcfRecommendation;

	// P/E Score
	private Long	peScore;
	private String	peRecommendation;

	// ROE Score
	private Long	roeScore;
	private String	roeRecommendation;

	// D/E Score
	private Long	deScore;
	private String	deRecommendation;
}
