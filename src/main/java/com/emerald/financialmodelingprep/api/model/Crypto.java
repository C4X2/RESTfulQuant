package com.emerald.financialmodelingprep.api.model;

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
}
