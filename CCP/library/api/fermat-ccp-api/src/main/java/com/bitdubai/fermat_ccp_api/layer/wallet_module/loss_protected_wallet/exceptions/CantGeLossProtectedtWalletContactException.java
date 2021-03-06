package com.bitdubai.fermat_ccp_api.layer.wallet_module.loss_protected_wallet.exceptions;

/**
 * The Class <code>CantGetWalletContactException</code>
 * is thrown when an error occurs trying to create a contact for a wallet
 * <p/>
 * Created by Leon Acosta - (laion.cj91@gmail.com) on 05/06/15.
 *
 * @version 1.0
 * @since Java JDK 1.7
 */
public class CantGeLossProtectedtWalletContactException extends LossProtectedWalletException {

    public static final String DEFAULT_MESSAGE = "CAN'T CREATE REQUESTED CONTACT EXCEPTION";

    public CantGeLossProtectedtWalletContactException(final String message, final Exception cause, final String context, final String possibleReason) {
        super(message, cause, context, possibleReason);
    }

    public CantGeLossProtectedtWalletContactException(final String message, final Exception cause) {
        this(message, cause, "", "");
    }

    public CantGeLossProtectedtWalletContactException(final String message) {
        this(message, null);
    }

    public CantGeLossProtectedtWalletContactException() {
        this(DEFAULT_MESSAGE);
    }
}
