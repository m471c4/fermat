package com.bitdubai.fermat_dmp_plugin.layer._13_basic_wallet.bitcoin_wallet.developer.bitdubai;

import com.bitdubai.fermat_api.Plugin;
import com.bitdubai.fermat_api.PluginDeveloper;
import com.bitdubai.fermat_api.layer._1_definition.enums.CryptoCurrency;
import com.bitdubai.fermat_api.layer._1_definition.enums.TimeFrequency;
import com.bitdubai.fermat_api.layer._6_license.PluginLicensor;
import com.bitdubai.fermat_dmp_plugin.layer._13_basic_wallet.bitcoin_wallet.developer.bitdubai.version_1.BitcoinWalletBasicWalletPluginRoot;

/**
 * Created by loui on 30/04/15.
 */
public class DeveloperBitDubai  implements PluginDeveloper, PluginLicensor {


    Plugin plugin;

    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    public DeveloperBitDubai () {

        /**
         * I will choose from the different versions of my implementations which one to start. Now there is only one, so
         * it is easy to choose.
         */

        plugin = new BitcoinWalletBasicWalletPluginRoot();

    }

    @Override
    public int getAmountToPay() {
        return 100;
    }

    @Override
    public CryptoCurrency getCryptoCurrency() {
        return CryptoCurrency.BITCOIN;
    }

    @Override
    public String getAddress() {
        return "13gpMizSNvQCbJzAPyGCUnfUGqFD8ryzcv";
    }

    @Override
    public TimeFrequency getTimePeriod() {
        return TimeFrequency.MONTHLY;
    }
}