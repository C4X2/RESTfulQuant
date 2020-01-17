package com.emerald.financialmodelingprep.services.profile.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerald.financialmodelingprep.api.noargs.profile.model.CompanyProfileAPI;
import com.emerald.financialmodelingprep.common.params.CompanyProfile;
import com.emerald.financialmodelingprep.common.utils.ValidationUtils;
import com.emerald.financialmodelingprep.services.impl.JsonDeserializerImpl;
import com.emerald.financialmodelingprep.services.model.URLConnectionService;
import com.emerald.financialmodelingprep.services.profile.model.CompanyProfileService;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Service @Getter @Setter @Accessors(chain = true)
public class CompanyProfileServiceImpl implements CompanyProfileService
{
	@Autowired
	private CompanyProfileAPI		companyProfileAPI;
	@Autowired
	private URLConnectionService	urlConnectionService;

	@Override
	public CompanyProfile getCompanyProfile(String ticker)
	{
		ValidationUtils.validateTicker(ticker);
		String url = getCompanyProfileAPI().buildAPIURL(ticker);
		String json = getUrlConnectionService().get(url);
		CompanyProfile companyProfile = JsonDeserializerImpl.getGson().fromJson(json, CompanyProfile.class);
		return companyProfile;
	}

}
