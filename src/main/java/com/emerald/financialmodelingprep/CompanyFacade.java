package com.emerald.financialmodelingprep;

import org.springframework.beans.factory.annotation.Autowired;

import com.emerald.financialmodelingprep.common.params.CompanyProfile;
import com.emerald.financialmodelingprep.common.params.CompanyRating;
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
	@Getter
	private String ticker;
	
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
}
