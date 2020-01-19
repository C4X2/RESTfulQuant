package com.emerald.financialmodelingprep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import com.emerald.financialmodelingprep.api.noargs.crypto.model.Crypto;
import com.emerald.financialmodelingprep.api.noargs.profile.model.CompanyProfileAPI;
import com.emerald.financialmodelingprep.common.constants.APICallType;
import com.emerald.financialmodelingprep.common.constants.Period;
import com.emerald.financialmodelingprep.common.params.CompanyProfile;
import com.emerald.financialmodelingprep.common.params.CryptocurrencyCoin;
import com.emerald.financialmodelingprep.common.params.DiscountedCashFlow;
import com.emerald.financialmodelingprep.managers.model.APIFactory;
import com.emerald.financialmodelingprep.services.crypto.model.CryptoService;
import com.emerald.financialmodelingprep.services.discountedcashflow.model.DiscountedCashFlowService;
import com.emerald.financialmodelingprep.services.impl.JsonDeserializerImpl;
import com.emerald.financialmodelingprep.services.model.URLConnectionService;
import com.emerald.financialmodelingprep.services.profile.model.CompanyProfileService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@SpringBootTest
class FinancialmodelingprepApplicationTests
{

	/////////////////////////////////////////////////////////////////////
	//
	// Test Class Constants
	//
	/////////////////////////////////////////////////////////////////////

	private static final String	APPLE	= "AAPL";
	private static final String	BITCOIN	= "BTC";
	private static final String CRYPTOCURRENCIES_LIST = "cryptocurrenciesList";
	

	/////////////////////////////////////////////////////////////////////
	//
	// Test Class Fields
	//
	/////////////////////////////////////////////////////////////////////
	
	private APIFactory api;
	private URLConnectionService urlConnection;
	private ApplicationContext applicationContext;

	@Test
	void contextLoads()
	{
	}

	/////////////////////////////////////////////////////////////////////
	//
	// Cryptocurrencies Test
	//
	/////////////////////////////////////////////////////////////////////

	@Test
	void cryptocurrenciesTest01()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		assertEquals("https://financialmodelingprep.com/api/v3/cryptocurrencies", api.buildAPIURL());
	}

	@Test
	void cryptocurrenciesTest02()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		// TODO SHOULD THROW AN ERROR
		assertEquals("https://financialmodelingprep.com/api/v3/cryptocurrencies", api.buildAPIURL(""));
	}

	@Test
	void cryptocurrenciesTest03()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		// TODO SHOULD THROW AN ERROR
		assertEquals("https://financialmodelingprep.com/api/v3/cryptocurrencies", api.buildAPIURL(null));
	}

	@Test
	void cryptocurrenciesTest05()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		assertNotNull(api.buildAPIURL("BTC"));
	}
	
	@Test
	void cryptocurrenciesTest06()
	{
		CryptocurrencyCoin coin = getApplicationContext().getBean(CryptoService.class).getCryptocurrencyCoin(BITCOIN);
		assertNotNull(coin);
	}

	/////////////////////////////////////////////////////////////////////
	//
	// Company Profile Tests
	//
	/////////////////////////////////////////////////////////////////////

	@Test
	void companyProfileTest01()
	{
		CompanyProfileAPI api = (CompanyProfileAPI) this.getApi().getAPIOfType(APICallType.COMPANY_PROFILE);
		assertNotNull(api);
	}

	@Test
	void companyProfileTest02()
	{
		CompanyProfileAPI api = (CompanyProfileAPI) this.getApi().getAPIOfType(APICallType.COMPANY_PROFILE);
		assertTrue(api instanceof CompanyProfileAPI);
	}

	@Test
	void companyProfileTest03()
	{
		CompanyProfileAPI api = (CompanyProfileAPI) this.getApi().getAPIOfType(APICallType.COMPANY_PROFILE);
		assertEquals("https://financialmodelingprep.com/api/v3/company/profile/AAPL", api.buildAPIURL(APPLE));
	}

	@Test
	void companyProfileTest04()
	{
		CompanyProfileAPI api = (CompanyProfileAPI) this.getApi().getAPIOfType(APICallType.COMPANY_PROFILE);
		assertNotNull(api.buildAPIURL(APPLE));
	}

	@Test
	void companyProfileTest05()
	{
		CompanyProfileAPI api = (CompanyProfileAPI) this.getApi().getAPIOfType(APICallType.COMPANY_PROFILE);
		// TODO SHOULD THROW AN ERROR
		assertNotNull(api.buildAPIURL(null));
	}
	
	@Test
	void companyProfileTest06()
	{
		CompanyProfileService companyProfileService = this.getApplicationContext().getBean(CompanyProfileService.class);
		CompanyProfile companyProfile = companyProfileService.getCompanyProfile(APPLE);
		assertNotNull(companyProfile);
	}

	@Test
	void companyProfileTest07()
	{
		CompanyProfileService companyProfileService = this.getApplicationContext().getBean(CompanyProfileService.class);
		CompanyProfile companyProfile = companyProfileService.getCompanyProfile(BITCOIN);
		// nuLL because bitcoin is a cryptocurrency not a ticker
		assertNull(companyProfile);
	}

	/////////////////////////////////////////////////////////////////////
	//
	// Company Rating Test
	//
	/////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////////////////
	//
	// Company Discounted Cash Flow Test
	//
	/////////////////////////////////////////////////////////////////////
	
	void companyDiscountedCashFlowTest01()
	{
		DiscountedCashFlowService dsc = getApplicationContext().getBean(DiscountedCashFlowService.class);
		assertNotNull(dsc);
	}
	
	void companyDiscountedCashFlowTest02()
	{
		DiscountedCashFlowService dsc = getApplicationContext().getBean(DiscountedCashFlowService.class);
		DiscountedCashFlow dcf = dsc.getDiscountedCashFlow(APPLE);
		assertNotNull(dcf);
	}
	
	void companyDiscountedCashFlowTest03()
	{
		DiscountedCashFlowService dsc = getApplicationContext().getBean(DiscountedCashFlowService.class);
		List<DiscountedCashFlow> listOfHistoricalDiscountedCashFlow = dsc.getHistoricalDiscountedCashFlow(APPLE);
		assertNotNull(listOfHistoricalDiscountedCashFlow);
		Assert.notEmpty(listOfHistoricalDiscountedCashFlow, "The list should be populated with multiple values");
	}
	
	void companyDiscountedCashFlowTest04()
	{
		DiscountedCashFlowService dsc = getApplicationContext().getBean(DiscountedCashFlowService.class);
		List<DiscountedCashFlow> dcf = dsc.getHistoricalDiscountedCashFlow(APPLE, Period.QUARTER);
		assertNotNull(dcf);
	}

	/////////////////////////////////////////////////////////////////////
	//
	// JsonDeserializer Test
	//
	/////////////////////////////////////////////////////////////////////
	@Test
	void jsonDeserializerTest01()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		String url = api.buildAPIURL(BITCOIN);
		String json = getUrlConnection().get(url);
		CryptocurrencyCoin coin = JsonDeserializerImpl.getGson().fromJson(json, CryptocurrencyCoin.class);
		assertNotNull(coin);
	}
	
	@Test
	void jsonDeserializerTest02()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		String url = api.buildAPIURL(BITCOIN);
		String json = getUrlConnection().get(url);
		CryptocurrencyCoin coin = JsonDeserializerImpl.getGson().fromJson(json, CryptocurrencyCoin.class);
		assertEquals(BITCOIN,coin.getTicker());
	}
	
	@Test
	void jsonDeserializerTest03()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		String url = api.buildAPIURL(BITCOIN);
		String json = getUrlConnection().get(url);
		CryptocurrencyCoin coin = JsonDeserializerImpl.getGson().fromJson(json, CryptocurrencyCoin.class);
		assertEquals("Bitcoin", coin.getName());
	}
	
	@Test
	void jsonDeserializerTest04()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		String url = api.buildAPIURL(BITCOIN);
		String json = getUrlConnection().get(url);
		CryptocurrencyCoin coin = JsonDeserializerImpl.getGson().fromJson(json, CryptocurrencyCoin.class);
		assertTrue(coin.getMarketCapitalization() > 0);
	}

	@Test
	void jsonDeserializerTest05()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		String url = api.buildAPIURL(BITCOIN);
		String json = getUrlConnection().get(url);
		CryptocurrencyCoin coin = JsonDeserializerImpl.getGson().fromJson(json, CryptocurrencyCoin.class);
		assertTrue((coin.getChanges() != null) && (coin.getChanges().compareTo(new BigDecimal(0)) != 0));
	}
	
	@Test
	void jsonDeserializerTest06()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		String url = api.buildAPIURL(BITCOIN);
		String json = getUrlConnection().get(url);
		CryptocurrencyCoin coin = JsonDeserializerImpl.getGson().fromJson(json, CryptocurrencyCoin.class);
		assertTrue(coin.getPrice().compareTo(new BigDecimal(0)) > 0);
	}
	
	@Test
	void jsonDeserializerTest07()
	{
		Crypto api = (Crypto) this.getApi().getAPIOfType(APICallType.CRYPTO);
		String url = api.buildAPIURL();
		String json = getUrlConnection().get(url);
		JsonObject jObj = null;
		JsonArray arr = null;
		JsonElement coins = JsonParser.parseString(json);
		if (coins.isJsonObject())
		{
			jObj = coins.getAsJsonObject();
		}
		if ((jObj != null) && jObj.has(CRYPTOCURRENCIES_LIST))
		{
			arr = jObj.get(CRYPTOCURRENCIES_LIST).getAsJsonArray();
		}
		List<CryptocurrencyCoin> coinList = new ArrayList<CryptocurrencyCoin> ();
		if (arr != null)
		{
			for (JsonElement elem : arr)
			{
				coinList.add(JsonDeserializerImpl.getGson().fromJson(elem, CryptocurrencyCoin.class));
			}

		}
		assertTrue(CollectionUtils.isNotEmpty(coinList));
	}
	
	@Test
	void testCompanyFacade()
	{
		CompanyFacade company = new CompanyFacade(APPLE);
		getApplicationContext().getAutowireCapableBeanFactory().autowireBean(company);
		DiscountedCashFlow dcf = company.getDiscountedCashFlow();
		assertNotNull(dcf);
	}

	/**
	 * @return the api
	 */
	public APIFactory getApi()
	{
		return this.api;
	}

	/**
	 * @param api the api to set
	 */
	@Autowired
	public void setApi(APIFactory api)
	{
		this.api = api;
	}

	/**
	 * @return the urlConnection
	 */
	public URLConnectionService getUrlConnection()
	{
		return urlConnection;
	}

	/**
	 * @param urlConnection the urlConnection to set
	 */
	@Autowired
	public void setUrlConnection(URLConnectionService urlConnection)
	{
		this.urlConnection = urlConnection;
	}

	/**
	 * @return the applicationContext
	 */
	public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}

	/**
	 * @param applicationContext the applicationContext to set
	 */
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext)
	{
		this.applicationContext = applicationContext;
	}
}
