package com.emerald.financialmodelingprep;

import java.util.List;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.params.CompanyProfile;
import com.emerald.financialmodelingprep.common.params.CompanyRating;
import com.emerald.financialmodelingprep.common.params.DiscountedCashFlow;
import com.emerald.financialmodelingprep.services.discountedcashflow.model.DiscountedCashFlowService;
import com.emerald.financialmodelingprep.services.profile.model.CompanyProfileService;
import com.emerald.financialmodelingprep.services.ratings.model.CompanyRatingService;

import lombok.Getter;
import lombok.Setter;

public class CompanyFacade
{
	@Autowired @Getter @Setter
	private CompanyProfileService companyProfileService;
	@Autowired @Getter @Setter 
	private CompanyRatingService companyRatingService;
	@Autowired @Getter @Setter 
	private DiscountedCashFlowService discountedCashFlowService;
	@Getter
	private final String ticker;
	
	public CompanyFacade(final String ticker)
	{
		this.ticker = ticker;
	}
	
	public CompanyProfile getCompanyProfile()
	{
		return getCompanyProfileService().getCompanyProfile(this.ticker);
	}
	
	public CompanyRating getCompanyRating()
	{
		return getCompanyRatingService().getCompanyRating(this.ticker);
	}

	public DiscountedCashFlow getDiscountedCashFlow()
	{
		return getDiscountedCashFlowService().getDiscountedCashFlow(this.ticker);
	}

	public List<DiscountedCashFlow> getHistoricalDiscountedCashFlow()
	{
		return getDiscountedCashFlowService().getHistoricalDiscountedCashFlow(this.ticker);
	}

	public List<DiscountedCashFlow> getHistoricalDiscountedCashFlow(Period period)
	{
		return getDiscountedCashFlowService().getHistoricalDiscountedCashFlow(this.ticker, period);
	}
}
