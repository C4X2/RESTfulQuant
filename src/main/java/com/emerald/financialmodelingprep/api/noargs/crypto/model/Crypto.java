package com.emerald.financialmodelingprep.api.noargs.crypto.model;

import com.emerald.financialmodelingprep.api.model.FinancialModelingPrepAPI;

public interface Crypto extends FinancialModelingPrepAPI
{
    /////////////////////////////////////////////////////////////////////
    //
    // Cryptocurrencies
    //
    /////////////////////////////////////////////////////////////////////

    /**
     * A URL endpoint to receive price information about a wide range of
     * cryptocurrencies. <br />
     * <p>
     * If information for a single cryptocurrency is desired, use the
     * {@link #CRYPTO_SINGLE} endpoint instead.
     * </p>
     *
     * <p>
     * The cryptocurrency endpoint provides: ticker, name (full name of the
     * cryptocurrency), price, changes, marketCapitalization.
     * </p>
     * <br />
     *
     * <p>
     * Updated in real-time.
     * </p>
     */
    public static final String	CRYPTO							= "/v3/cryptocurrencies";

    /**
     * A URL endpoint to receive price information about a single cryptocurrency.
     * <br />
     * <p>
     * If information for multiple cryptocurrencies is desired, use the
     * {@link #CRYPTO} endpoint instead.
     * </p>
     *
     * <p>
     * The cryptocurrency endpoint provides: ticker, name (full name of the
     * cryptocurrency), price, changes, marketCapitalization.
     * </p>
     * <br />
     *
     * <p>
     * Updated in real-time.
     * </p>
     * <em>Please note that the ticker of the desired cryptocurrency has to be
     * specified after this URL.</em>
     */
    public static final String	CRYPTO_SINGLE					= "/v3/cryptocurrency";
    
    /**
     * If the supplied argument is null, it is the equalivalent of calling the {@link #buildAPIURL()} method.
     */
    @Override
    public FinancialModelingPrepAPI buildAPIURL(String ticker);
    
    /**
     * Convience method to build the {@link #CRYPTO} endpoint URL.
     * @return the FinancialModelingPrepAPI object with the newly built URL.
     */
    public FinancialModelingPrepAPI buildAPIURL();
}
