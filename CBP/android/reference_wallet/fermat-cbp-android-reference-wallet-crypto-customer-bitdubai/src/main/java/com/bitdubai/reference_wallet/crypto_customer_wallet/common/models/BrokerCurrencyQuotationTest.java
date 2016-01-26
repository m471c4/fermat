package com.bitdubai.reference_wallet.crypto_customer_wallet.common.models;

/**
 * Created by Yordin Alayn on 25.01.16.
 */
public class BrokerCurrencyQuotationTest {

    private String currencyOver;

    private String currencyUnder;

    private String exchangeRate;

    private Boolean exchangeRateInv;

    public BrokerCurrencyQuotationTest(
        String currencyOver,
        String currencyUnder,
        String exchangeRate
    ){
        this.currencyOver = currencyOver;
        this.currencyUnder = currencyUnder;
        this.exchangeRate = exchangeRate;
        this.exchangeRateInv = Boolean.FALSE;
    }

    public String getCurrencyOver(){ return this.currencyOver; }

    public String getCurrencyUnder(){ return this.currencyUnder; }

    public String getExchangeRate(){ return  this.exchangeRate; }

    public boolean getExchangeRateInv(){ return this.exchangeRateInv; }

    public void setExchangeRateInv(boolean exchangeRateInv){ this.exchangeRateInv = exchangeRateInv; }

}
