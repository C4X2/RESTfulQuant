package com.emerald.financialmodelingprep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.emerald.financialmodelingprep.api.model.Crypto;
import com.emerald.financialmodelingprep.common.constants.APICallType;
import com.emerald.financialmodelingprep.managers.impl.APIFactoryImpl;
import com.emerald.financialmodelingprep.managers.model.APIFactory;

@SpringBootTest
class FinancialmodelingprepApplicationTests {

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
}
