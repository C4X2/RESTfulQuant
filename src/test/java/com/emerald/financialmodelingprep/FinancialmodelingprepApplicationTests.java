package com.emerald.financialmodelingprep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.emerald.financialmodelingprep.api.model.CompanyProfileAPI;
import com.emerald.financialmodelingprep.api.model.Crypto;
import com.emerald.financialmodelingprep.common.constants.APICallType;
import com.emerald.financialmodelingprep.managers.impl.APIFactoryImpl;
import com.emerald.financialmodelingprep.managers.model.APIFactory;

@SpringBootTest
class FinancialmodelingprepApplicationTests {

	
    /////////////////////////////////////////////////////////////////////
    //
    // Test Class Constants
    //
    /////////////////////////////////////////////////////////////////////
	
	private static final String APPLE = "AAPL";
	
	
	@Test
	void contextLoads() {
	}
	
    /////////////////////////////////////////////////////////////////////
    //
    // Cryptocurrencies Test
    //
    /////////////////////////////////////////////////////////////////////
	
	@Test
	void cryptocurrenciesTest01()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		Crypto api = (Crypto) apiFactory.getAPIOfType(APICallType.CRYPTO);
		assertEquals("https://financialmodelingprep.com/api/v3/cryptocurrencies" , api.buildAPIURL().getURL());
	}
	
	@Test
	void cryptocurrenciesTest02()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		Crypto api = (Crypto) apiFactory.getAPIOfType(APICallType.CRYPTO);
		assertEquals("https://financialmodelingprep.com/api/v3/cryptocurrencies" , api.buildAPIURL("").getURL());
	}
	
	@Test
	void cryptocurrenciesTest03()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		Crypto api = (Crypto) apiFactory.getAPIOfType(APICallType.CRYPTO);
		assertEquals("https://financialmodelingprep.com/api/v3/cryptocurrencies" , api.buildAPIURL(null).getURL());
	}
	
	@Test
	void cryptocurrenciesTest04()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		Crypto api = (Crypto) apiFactory.getAPIOfType(APICallType.CRYPTO);
		assertNotNull(api.buildAPIURL(null).get());
	}
	
	@Test
	void cryptocurrenciesTest05()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		Crypto api = (Crypto) apiFactory.getAPIOfType(APICallType.CRYPTO);
		assertNotNull(api.buildAPIURL("BTC").get());
	}

	
    /////////////////////////////////////////////////////////////////////
    //
    // Company Profile Tests
    //
    /////////////////////////////////////////////////////////////////////
	
	@Test
	void companyProfileTest01()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		CompanyProfileAPI api = (CompanyProfileAPI) apiFactory.getAPIOfType(APICallType.COMPANY_PROFILE);
		assertNotNull(api);
	}
	
	@Test
	void companyProfileTest02()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		CompanyProfileAPI api = (CompanyProfileAPI) apiFactory.getAPIOfType(APICallType.COMPANY_PROFILE);
		assertTrue(api instanceof CompanyProfileAPI);
	}
	
	@Test
	void companyProfileTest03()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		CompanyProfileAPI api = (CompanyProfileAPI) apiFactory.getAPIOfType(APICallType.COMPANY_PROFILE);
		assertEquals("https://financialmodelingprep.com/api/v3/company/profile/AAPL", api.buildAPIURL(APPLE).getURL());
	}
	
	@Test
	void companyProfileTest04()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		CompanyProfileAPI api = (CompanyProfileAPI) apiFactory.getAPIOfType(APICallType.COMPANY_PROFILE);
		assertNotNull(api.buildAPIURL(APPLE).get());
	}
	
	@Test
	void companyProfileTest05()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		CompanyProfileAPI api = (CompanyProfileAPI) apiFactory.getAPIOfType(APICallType.COMPANY_PROFILE);
		assertNull(api.get());
	}
	
	@Test
	void companyProfileTest06()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		CompanyProfileAPI api = (CompanyProfileAPI) apiFactory.getAPIOfType(APICallType.COMPANY_PROFILE);
		assertNull(api.getURL());
	}
	
	@Test
	void companyProfileTest07()
	{
		APIFactory apiFactory = new APIFactoryImpl();
		CompanyProfileAPI api = (CompanyProfileAPI) apiFactory.getAPIOfType(APICallType.COMPANY_PROFILE);
		assertNotNull(api.buildAPIURL(null));
	}
	
	
    /////////////////////////////////////////////////////////////////////
    //
    // Company Rating Test
    //
    /////////////////////////////////////////////////////////////////////
}
